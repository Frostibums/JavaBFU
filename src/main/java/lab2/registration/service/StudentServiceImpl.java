package lab2.registration.service;

import lab2.registration.exceptions.*;
import lab2.registration.model.*;

import java.time.LocalDate;
import java.util.*;


public class StudentServiceImpl extends dataClass implements StudentService {

    /**
     * Регистрация студента на курс. Регистрация возможна при следующих условиях:
     * - + курс еще не начался; x
     * - + курс предназначен для категории данного студента (магистра/бакалавра); x
     * - + студент прошел все обязательные курсы, необходимые для посещения данного курса; x
     * - + в курсе есть свободные места.
     *
     * @param studentId идентификатор студента
     * @param courseId  идентификатор курса, соответствующий CourseInstance.id
     * @return результат выполнения регистрации
     */
    @Override
    public ActionStatus subscribe(long studentId, long courseId)
            throws CourseInstanceNotFoundException, CourseCapacityIsLessThanOne, StudentNotFoundException, CourseInfoNotFoundException, StudentWrongCategoryException, StudentHasntCompletedPrerequisitesException, CourseIsFullException, StudentHasAlreadySubscribedExceptions, CourseHasAlreadyStartedException {

        var courseInstance =
                courseInstances.stream().filter(i -> i.getId() == courseId).findFirst().orElse(null);

        if (courseInstance == null)
            throw new CourseInstanceNotFoundException(courseId);

        if(courseInstance.getStartDate().isBefore(LocalDate.now()))
            throw new CourseHasAlreadyStartedException(courseId);

        if(courseInstance.getCapacity() < 1)
            throw new CourseCapacityIsLessThanOne(courseId);


        var student =
                bachelorStudents.stream().filter(bs -> bs.getId() == studentId).findFirst().orElse(null);
        StudentCategory category = student != null ? StudentCategory.BACHELOR : null;

        if (category == null) {
            student =
                    masterStudents.stream().filter(ms -> ms.getId() == studentId).findFirst().orElse(null);
            category = student != null ? StudentCategory.MASTER : null;
        }

        if (category == null)
            throw new StudentNotFoundException(studentId);


        var courseInfo =
                courseInfos.stream().filter(inf -> inf.getId() == courseInstance.getCourseId()).findFirst().orElse(null);

        if (courseInfo == null)
            throw new CourseInfoNotFoundException(courseId);

        boolean isAllowedCategory = courseInfo.getStudentCategories().contains(category);
        Student finalStudent = student;
        boolean isAllPrerequisitesCompleted = courseInfo.getPrerequisites().stream()
                .anyMatch(course -> finalStudent.getCompletedCourses().contains(course));

        if (!isAllowedCategory)
            throw new StudentWrongCategoryException(courseId, studentId);
        if (!courseInfo.getPrerequisites().isEmpty() && !isAllPrerequisitesCompleted)
            throw new StudentHasntCompletedPrerequisitesException(courseId, studentId);

        if (!subscriptions.containsKey(courseId)) {
            var studentList = new ArrayList<Long>();
            subscriptions.put(courseId, studentList);
        }

        if (courseInstance.getCapacity() <= subscriptions.get(courseId).size())
            throw new CourseIsFullException(courseId);

        if (subscriptions.get(courseId).contains(studentId))
            throw new StudentHasAlreadySubscribedExceptions(courseId, studentId);

        subscriptions.get(courseId).add(studentId);
        return ActionStatus.OK;
    }

    @Override
    public ActionStatus unsubscribe(long studentId, long courseId)
            throws CourseInstanceNotFoundException, CourseHasAlreadyStartedException, StudentIsntSubscribedExceptions {

        var courseInstance =
                courseInstances.stream().filter(i -> i.getId() == courseId).findFirst().orElse(null);

        if (courseInstance == null)
            throw new CourseInstanceNotFoundException(courseId);

        if(courseInstance.getStartDate().isBefore(LocalDate.now()))
            throw new CourseHasAlreadyStartedException(courseId);

        if (!subscriptions.containsKey(courseId) || !subscriptions.get(courseId).contains(studentId))
            throw new StudentIsntSubscribedExceptions(courseId, studentId);

        subscriptions.get(courseId).remove(studentId);
        return ActionStatus.OK;

    }

    @Override
    public List<CourseInstance> findAllSubscriptionsByStudentId(long studentId) {
        var courses = courseInstances.stream()
                .filter(course -> subscriptions.get(course.getId()) != null)
                .filter(course -> subscriptions.get(course.getId()).contains(studentId)).toList();
        return courses;

    }
}



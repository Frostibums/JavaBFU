package lab2.registration.service;

import lab2.registration.model.*;

import java.util.*;


public class InstructorServiceImpl extends dataClass implements CourseInstructorService{

    @Override
    public List<Student> findStudentsByCourseId(long courseId) {

        var studentsIds = subscriptions.get(courseId).stream().toList();
        var allStudents = bachelorStudents;
        allStudents.addAll(masterStudents);

        var res = allStudents.stream()
                .filter(student -> studentsIds.contains(student.getId())).toList();

        return res;

    }

    @Override
    public List<Student> findStudentsByInstructorId(long instructorId) {

        var allStudents = bachelorStudents;
        allStudents.addAll(masterStudents);

        var students = courseInstances.stream()
                .filter(course -> course.getInstructorId() == instructorId)
                .map(course -> course.getId())
                .filter(courseId -> subscriptions.get(courseId) != null)
                .flatMap(courseId -> findStudentsByCourseId(courseId).stream())
                .distinct().toList();

        return students;

    }

    @Override
    public List<Instructor> findReplacement(long instructorId, long courseId) {

        var courseInstanceId = courseInstances.stream()
                .filter(course -> course.getId() == courseId)
                .map(course -> course.getCourseId()).findFirst().orElse(null);

        var replacements = instructors.stream()
                .filter(instructor -> instructor.getCanTeach().contains(courseInstanceId))
                .filter(instructor -> instructor.getId() != instructorId).toList();

        return replacements;

    }
}

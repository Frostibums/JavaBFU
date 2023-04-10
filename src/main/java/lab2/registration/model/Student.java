package lab2.registration.model;

import java.util.List;

/**
 * Класс для информации о студенте
 */
public class Student extends Person {

    /**
     * список идентификаторов курсов (CourseInstance.id), пройденных студентом
     */
    private List<Long> completedCourses;

    //TODO: добавить геттеры и сеттеры

    public void setCompletedCourses(List<Long> completedCourses){
        this.completedCourses = completedCourses;
    }

    public List<Long> getCompletedCourses(){
        return completedCourses;
    }
}

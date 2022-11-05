package labs.lab2.src.registration.model;

/**
 * Класс для информации о студенте
 */
public class Student extends Person {

    /**
     * список идентификаторов курсов (CourseInstance.id), пройденных студентом
     */
    private long[] completedCourses;

    //TODO: добавить геттеры и сеттеры

    public void setCompletedCourses(long[] completedCourses){
        this.completedCourses = completedCourses;
    }

    public long[] getCompletedCourses(){
        return completedCourses;
    }
}

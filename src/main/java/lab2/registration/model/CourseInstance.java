package lab2.registration.model;

import java.time.LocalDate;


/**
 * Класс с данными о проведении курса. Один курс (например, дискретная математика) может быть проведен несколько раз.
 */
public class CourseInstance {
    
    /**
     * идентификатор проведения курса
     */
    private long id;

    /**
     * идентификатор курса, соответствующий CourseInfo.id
     */
    private long courseId;

    /**
     * идентификатор преподавателя
     */
    private long instructorId;

    /**
     * дата начала курса
     */
    private LocalDate startDate;

    /**
     * ограничение на число студентов курса
     */
    private int capacity;

    public void setId(long id){
        this.id = id;
    }

    public long getId(){
        return id;
    }

    public void setCourseId(long courseId){
        this.courseId = courseId;
    }

    public long getCourseId(){
        return courseId;
    }

    public void setInstructorId(long instructorId){
        this.instructorId = instructorId;
    }

    public long getInstructorId(){
        return instructorId;
    }

    public void setStartDate(LocalDate startDate){
        this.startDate = startDate;
    }

    public LocalDate getStartDate(){
        return startDate;
    }

    public void setCapacity(int capacity){
        this.capacity = capacity;
    }

    public int getCapacity(){
        return capacity;
    }
}

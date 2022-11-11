package lab2.registration.exceptions;

public class CourseIsFullException extends Exception {
    public CourseIsFullException(long courseId) {
        super("Курс courseId:" + courseId + " заполнен");
    }
}




package lab2.registration.exceptions;

public class CourseInstanceNotFoundException extends Exception {
    public CourseInstanceNotFoundException(long courseId) {
        super("Курс courseId:" + courseId + " не найден в courseInstances.json");
    }
}

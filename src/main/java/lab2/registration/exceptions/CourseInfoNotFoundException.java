package lab2.registration.exceptions;

public class CourseInfoNotFoundException extends Exception {
    public CourseInfoNotFoundException(long courseId) {
        super("Курс courseId:" + courseId + " не найден в courseInfos.json");
    }
}

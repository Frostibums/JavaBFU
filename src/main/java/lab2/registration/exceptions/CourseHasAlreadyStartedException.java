package lab2.registration.exceptions;

public class CourseHasAlreadyStartedException extends Exception {
    public CourseHasAlreadyStartedException(long courseId) {
        super("Курс courseId:" + courseId + " уже начался");
    }
}

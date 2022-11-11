package lab2.registration.exceptions;

public class StudentHasAlreadySubscribedExceptions extends Exception {
    public StudentHasAlreadySubscribedExceptions(long courseId, long studentId) {
        super("Студент studentId:" + studentId + " уже записан на courseId: " + courseId);
    }
}





package lab2.registration.exceptions;

public class StudentIsntSubscribedExceptions extends Exception {
    public StudentIsntSubscribedExceptions(long courseId, long studentId) {
        super("Студент studentId:" + studentId + " итак не записан на courseId: " + courseId);
    }
}

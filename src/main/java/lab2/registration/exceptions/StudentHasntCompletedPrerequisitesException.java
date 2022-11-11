package lab2.registration.exceptions;

public class StudentHasntCompletedPrerequisitesException extends Exception {
    public StudentHasntCompletedPrerequisitesException(long courseId, long studentId) {
        super("Студент studentId:" + studentId + " не закончил необходимые курсы для записи на courseId: " + courseId);
    }
}

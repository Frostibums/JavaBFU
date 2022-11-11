package lab2.registration.exceptions;

public class StudentWrongCategoryException extends Exception {
    public StudentWrongCategoryException(long courseId, long studentId) {
        super("Студент studentId:" + studentId + " не той категории для курса courseId: " + courseId);
    }
}

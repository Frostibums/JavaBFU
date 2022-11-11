package lab2.registration.exceptions;

public class StudentNotFoundException extends Exception {
    public StudentNotFoundException(long studentId) {
        super("Студент studentId:" + studentId + " не найден");
    }
}

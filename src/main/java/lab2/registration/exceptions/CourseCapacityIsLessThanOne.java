package lab2.registration.exceptions;

public class CourseCapacityIsLessThanOne extends Exception {
    public CourseCapacityIsLessThanOne(long courseId) {
        super("Курс courseId:" + courseId + " имеет <1 мест");
    }
}

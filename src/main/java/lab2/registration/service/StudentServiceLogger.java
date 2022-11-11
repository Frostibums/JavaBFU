package lab2.registration.service;

import lab2.registration.exceptions.*;
import lab2.registration.model.ActionStatus;
import lab2.registration.model.CourseInstance;

import java.io.IOException;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class StudentServiceLogger extends StudentServiceImpl{
    StudentServiceImpl studentServiceImpl = new StudentServiceImpl();

    private final static String LOGGER_NAME = StudentServiceLogger.class.getName();
    private final static Logger LOGGER = Logger.getLogger(LOGGER_NAME);

    final FileHandler fileHandler = new FileHandler("src/main/java/lab2/registration/logs/log", 3000, 10, true);

    public StudentServiceLogger() throws IOException {
        fileHandler.setFormatter(new SimpleFormatter());
        LOGGER.addHandler(fileHandler);
    }

    @Override
    public ActionStatus subscribe(long studentId, long courseId) throws CourseInstanceNotFoundException, CourseHasAlreadyStartedException, CourseCapacityIsLessThanOne, StudentNotFoundException, CourseInfoNotFoundException, StudentWrongCategoryException, StudentHasntCompletedPrerequisitesException, CourseIsFullException, StudentHasAlreadySubscribedExceptions {
        try {

            return studentServiceImpl.subscribe(studentId, courseId);

        } catch (CourseInstanceNotFoundException | CourseInfoNotFoundException e) {

            LOGGER.log(Level.WARNING, "Курс с таким идентификатором не найден.");
            LOGGER.log(Level.INFO, e.toString());

        } catch (CourseHasAlreadyStartedException e) {

            LOGGER.log(Level.WARNING, "Невозможно записать студента на курс, который уже начался.");
            LOGGER.log(Level.INFO, e.toString());

        } catch (CourseCapacityIsLessThanOne | CourseIsFullException e) {

            LOGGER.log(Level.WARNING, "Нет свободных мест.");
            LOGGER.log(Level.INFO, e.toString());

        } catch (StudentNotFoundException e) {

            LOGGER.log(Level.WARNING, "Студент с таким идентификатором не найден.");
            LOGGER.log(Level.INFO, e.toString());

        } catch (StudentWrongCategoryException e) {

            LOGGER.log(Level.WARNING, "Данный курс предназначен для другой категории студентов.");
            LOGGER.log(Level.INFO, e.toString());

        } catch (StudentHasntCompletedPrerequisitesException e) {

            LOGGER.log(Level.WARNING, "Студент еще не прошел все необходимые курсы для записи.");
            LOGGER.log(Level.INFO, e.toString());

        } catch (StudentHasAlreadySubscribedExceptions e) {

            LOGGER.log(Level.WARNING, "Студент уже записан на данный курс.");
            LOGGER.log(Level.INFO, e.toString());

        }
        return ActionStatus.NOK;
    }

    @Override
    public ActionStatus unsubscribe(long studentId, long courseId) throws CourseInstanceNotFoundException, CourseHasAlreadyStartedException, StudentIsntSubscribedExceptions {

            try {

                return studentServiceImpl.unsubscribe(studentId, courseId);

            } catch (CourseInstanceNotFoundException e) {

                LOGGER.log(Level.WARNING, "Курс с таким идентификатором не найден.");
                LOGGER.log(Level.INFO, e.toString());

            } catch (CourseHasAlreadyStartedException e) {

                LOGGER.log(Level.WARNING, "Невозможно отписать студента от курса, который уже начался.");
                LOGGER.log(Level.INFO, e.toString());

            } catch (StudentIsntSubscribedExceptions e) {

                LOGGER.log(Level.WARNING, "Данный студент не записан на курс.");
                LOGGER.log(Level.INFO, e.toString());

            }

        return ActionStatus.NOK;
    }

    @Override
    public List<CourseInstance> findAllSubscriptionsByStudentId(long studentId) {
        return studentServiceImpl.findAllSubscriptionsByStudentId(studentId);
    }
}

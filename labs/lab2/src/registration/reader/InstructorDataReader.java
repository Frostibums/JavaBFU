package labs.lab2.src.registration.reader;

import com.fasterxml.jackson.databind.ObjectMapper;
import labs.lab2.src.registration.model.Instructor;

import java.io.File;
import java.io.IOException;

/**
 * Класс для чтения информации о курсах из файлов
 */
public class InstructorDataReader {

    private ObjectMapper objectMapper = new ObjectMapper();

    /**
     * @return список преподавателей курсов
     */
    public Instructor[] readCourseInstructorData() throws IOException {
        return objectMapper.readValue(new File("src/main/java/labs/lab2/src/resources/instructors.json"), Instructor[].class);
    }

}

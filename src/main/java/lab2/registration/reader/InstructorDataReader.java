package lab2.registration.reader;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lab2.registration.model.Instructor;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс для чтения информации о курсах из файлов
 */
public class InstructorDataReader {

    private ObjectMapper objectMapper = new ObjectMapper();

    public List<Instructor> readInstructors() throws IOException {
        return objectMapper.readValue(new File("src/main/java/lab2/resources/instructors.json"), new TypeReference<ArrayList<Instructor>>() {});
    }
}

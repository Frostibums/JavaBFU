package labs.lab2.src.registration.reader;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import labs.lab2.src.registration.model.CourseInfo;
import labs.lab2.src.registration.model.CourseInstance;

import java.io.File;
import java.io.IOException;

/**
 * Класс для чтения информации о курсах из файлов
 */
public class CourseDataReader {

    private ObjectMapper objectMapper = new ObjectMapper();

    public CourseDataReader() {
        objectMapper.registerModule(new JavaTimeModule());
    }

    /**
     * @return список базовой информации о курсах
     */
    public CourseInfo[] readCourseInfoData() throws IOException {
        return objectMapper.readValue(new File("src/main/java/labs/lab2/src/resources/courseInfos.json"), CourseInfo[].class);
    }

    /**
     * @return список данных о проведении курсов
     */
    public CourseInstance[] readCourseInstancesData() throws IOException {
        return objectMapper.readValue(new File("src/main/java/labs/lab2/src/resources/courseInstances.json"), CourseInstance[].class);
    }

}

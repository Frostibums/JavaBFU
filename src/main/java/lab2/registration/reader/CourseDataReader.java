package lab2.registration.reader;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lab2.registration.model.CourseInfo;
import lab2.registration.model.CourseInstance;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CourseDataReader {

    private ObjectMapper objectMapper = new ObjectMapper();

    public CourseDataReader() {
        objectMapper.registerModule(new JavaTimeModule());
    }

    public List<CourseInstance> readCourseInstance() throws IOException {
        return objectMapper.readValue(new File("src/main/java/lab2/resources/courseInstances.json"), new TypeReference<ArrayList<CourseInstance>>() {});
    }

    public List<CourseInfo> readCourseInfo() throws IOException {
        return objectMapper.readValue(new File("src/main/java/lab2/resources/courseInfos.json"), new TypeReference<ArrayList<CourseInfo>>() {});
    }

}

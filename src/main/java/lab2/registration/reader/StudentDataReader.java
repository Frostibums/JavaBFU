package lab2.registration.reader;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lab2.registration.model.Student;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentDataReader {

    private ObjectMapper objectMapper = new ObjectMapper();

    public List<Student> readBachelorStudentData() throws IOException {
        return objectMapper.readValue(new File("src/main/java/lab2/resources/bachelorStudents.json"), new TypeReference<ArrayList<Student>>() {});
    }

    public List<Student>  readMasterStudentData() throws IOException {
        return objectMapper.readValue(new File("src/main/java/lab2/resources/masterStudents.json"), new TypeReference<ArrayList<Student>>() {});
    }

}

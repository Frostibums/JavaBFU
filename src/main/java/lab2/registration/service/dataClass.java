package lab2.registration.service;

import lab2.registration.model.CourseInfo;
import lab2.registration.model.CourseInstance;
import lab2.registration.model.Instructor;
import lab2.registration.model.Student;
import lab2.registration.reader.CourseDataReader;
import lab2.registration.reader.InstructorDataReader;
import lab2.registration.reader.StudentDataReader;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class dataClass {

    protected static List<Student> bachelorStudents;
    protected static List<Student> masterStudents;
    protected static List<Instructor> instructors;
    protected static List<CourseInfo> courseInfos;
    protected static List<CourseInstance> courseInstances;
    protected static Map<Long, List<Long>> subscriptions = new HashMap<Long, List<Long>>();

    static {
        try{
            StudentDataReader studentDataReader = new StudentDataReader();
            CourseDataReader courseDataReader = new CourseDataReader();
            InstructorDataReader instructorDataReader = new InstructorDataReader();

            bachelorStudents = studentDataReader.readBachelorStudentData();
            masterStudents = studentDataReader.readMasterStudentData();
            instructors = instructorDataReader.readInstructors();
            courseInfos = courseDataReader.readCourseInfo();
            courseInstances = courseDataReader.readCourseInstance();
        }catch(IOException e){
            System.out.println("Failed to load data from JSON");
            e.printStackTrace();
        }
    }
}

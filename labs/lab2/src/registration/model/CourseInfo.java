package labs.lab2.src.registration.model;

/**
 * Класс для базовой информации о курсе
 */
public class CourseInfo {

    /**
     * идентификатор курса
     */
    private long id;

    /**
     * название курса
     */
    private String name;

    /**
     * краткое описание курса
     */
    private String description;

    /**
     * Список идентификаторов курсов, которые нужно обязательно пройти до начала данного курса
     */
    private long[] prerequisites;

    /**
     * список категорий студентов, которые могут посещать курс
     */
    private StudentCategory[] studentCategories;

    // TODO: добавить геттеры и сеттеры

    public void setId(long id){
        this.id = id;
    }

    public long getId(){
        return id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

    public void setPrerequisites(long[] prerequisites){
        this.prerequisites = prerequisites;
    }

    public long[] getPrerequisites(){
        return prerequisites;
    }

    public void setStudentCategories(StudentCategory[] studentCategories){
        this.studentCategories = studentCategories;
    }

    public StudentCategory[] getStudentCategories(){
        return studentCategories;
    }
}

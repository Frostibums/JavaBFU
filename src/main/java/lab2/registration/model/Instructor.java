package lab2.registration.model;

import java.util.List;

/**
 * Класс для информации о преподавателе
 */
public class Instructor extends Person {

    /**
     * Идентификаторы курсов, которые может вести преподаватель
     */
    List<Long> canTeach;

    public void setCanTeach(List<Long> canTeach){
        this.canTeach = canTeach;
    }

    public List<Long> getCanTeach(){
        return canTeach;
    }
}

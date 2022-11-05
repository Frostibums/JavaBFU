package labs.lab2.src.registration.model;

/**
 * Класс для информации о преподавателе
 */
public class Instructor extends Person {

    /**
     * Идентификаторы курсов, которые может вести преподаватель
     */
    int[] canTeach;

    // TODO: добавить геттеры и сеттеры

    public void setCanTeach(int[] canTeach){
        this.canTeach = canTeach;
    }

    public int[] getCanTeach(){
        return canTeach;
    }
}

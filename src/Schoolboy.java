import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Objects;

public class Schoolboy extends Human{
    private HashMap<String, Integer> grades;
    private String olympiad;
    private Integer place;
    private int number_of_school;

    public Schoolboy() throws Exception {
        super("", "", "", 0);
        this.grades = new HashMap<String, Integer>();
        this.olympiad = "";
        this.place = 0;
        this.number_of_school = 0;
    }

    public Schoolboy(String first_name, String last_name, String gender, Integer age, int number_of_school, HashMap<String, Integer> grades, String olimp, Integer place) throws Exception {
        super(first_name, last_name,gender, age);
        if (first_name.isEmpty()) {
            throw new Exception("Строка имени не должна быть пустой");
        }
        if (last_name.isEmpty()) {
            throw new Exception("Строка фамилии не должна быть пустой");
        }
        for (int grade : grades.values()) {
            if(grade > 5 | grade < 2){
                throw new Exception("Оценки должны быть в пределе от 2 до 5");
            }
        }
        if (number_of_school < 0) {
            throw new Exception("Номер школы не может быть меньше нуля");
        }
        if (age > 19 | age < 7 ) {
            throw  new Exception("Возраст школьника не может быть меньше 7 т ольше 19");
        }
        this.grades = grades;
        this.olympiad = olimp;
        this.place = place;
        this.number_of_school = number_of_school;
    }

    public Schoolboy(Schoolboy clone) throws Exception {
        super(clone.get_first_name(), clone.get_last_name(),clone.get_gender(), clone.get_age());
        this.grades = clone.grades;
        this.olympiad = clone.olympiad;
        this.place = clone.place;
        this.number_of_school = clone.number_of_school;
    }

    public String get_olimp() {
        return this.olympiad;
    }

    public Integer get_place() {
        return place;
    }

    public HashMap<String, Integer> get_grades() {
        return grades;
    }

    public int get_number_of_school() {
        return number_of_school;
    }

    public void set_number_of_school(int number) {
        this.number_of_school = number;
    }

    public void set_grades(HashMap<String, Integer> grades) {
        this.grades = grades;
    }

    public void set_olympiad(String olympiad) {
        this.olympiad = olympiad;
    }

    public void set_place(Integer place) {
        this.place = place;
    }

    public double get_avg_grades() {
        double avg_grades = 0;
        int count_grades = 0;
        for (int grade : this.grades.values()) {
            avg_grades = avg_grades + grade;
            count_grades = count_grades + 1;
        }
        return avg_grades / count_grades;
    }
    public boolean is_grant() {
        boolean flag_olymp = false;
        boolean flag_grades = false;
        boolean flag_all_grades = true;
        if (Objects.equals(this.olympiad, "областная")) {
            flag_olymp = true;
        } else if (Objects.equals(this.olympiad, "школьная") & this.place == 1) {
            flag_olymp = true;
        } else if (Objects.equals(this.olympiad, "городская") & this.place <= 3 & this.place >= 1) {
            flag_olymp = true;
        }

        for (Integer value : this.grades.values()) {
            if (value < 4) {
                flag_all_grades = false;
                break;
            }
        }
        if (this.grades.containsKey("математика") & this.grades.containsKey("русский язык") & this.grades.containsKey("история") & this.grades.containsKey("английский язык")) {
            if (this.grades.get("математика") == 5 & this.grades.get("русский язык") == 5 & this.grades.get("история") == 5 & this.grades.get("английский язык") == 5 & flag_all_grades) {
                flag_grades = true;
            }
        }

        return flag_olymp & flag_grades;
    }

    public String toString() {
        return this.get_first_name() + " " + this.get_last_name() + " (Школьник)";
    }

}

class SchoolboyByRatingComparator implements Comparator<Schoolboy> {
    public int compare(Schoolboy o1, Schoolboy o2) {
        return Double.compare(o1.get_avg_grades(), o2.get_avg_grades());
    }
}

class SchoolboyBySchoolNumberComparator implements Comparator<Schoolboy> {
    public int compare(Schoolboy o1, Schoolboy o2) {
        return Double.compare(o1.get_number_of_school(), o2.get_number_of_school());
    }
}

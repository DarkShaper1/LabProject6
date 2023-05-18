import java.util.ArrayList;
import java.util.Comparator;

public class Student extends Human{
    private ArrayList<Integer> grades;
    private ArrayList<Integer> grades_kurs;
    private int kurs;

    public Student() throws Exception {
        super("", "","", 0);
        this.grades = new ArrayList<Integer>();
    }

    public Student(String first_name, String last_name,String gender, int age, ArrayList<Integer> grades, ArrayList<Integer> grades_kurs, int kurs) throws Exception {
        super(first_name, last_name,gender, age);
        if (age<18){
            throw new Exception("Возраст студента не может быть меньше 18");
        }
        if (first_name.isEmpty()) {
            throw new Exception("Строка имени не должна быть пустой");
        }
        if (last_name.isEmpty()) {
            throw new Exception("Строка фамилии не должна быть пустой");
        }
        for (int grade : grades) {
            if(grade > 5 | grade < 2){
                throw new Exception("Оценки должны быть в пределе от 2 до 5");
            }
        }
        for (int grade : grades_kurs) {
            if(grade > 5 | grade < 2){
                throw new Exception("Оценки должны быть в пределе от 2 до 5");
            }
        }
        this.grades = grades;
        this.grades_kurs = grades_kurs;
        this.kurs = kurs;
    }

    public Student(Student clone) throws Exception {
        super(clone.get_first_name(), clone.get_last_name(), clone.get_gender(), clone.get_age());
        this.grades = clone.grades;
        this.kurs = clone.kurs;
        this.grades_kurs = clone.grades_kurs;
    }

    public int get_kurs() {
        return this.kurs;
    }

    public ArrayList<Integer> get_grades() {
        return grades;
    }

    public void set_grades(ArrayList<Integer> grades) {
        this.grades = grades;
    }

    public void set_place(int kurs) {
        this.kurs = kurs;
    }

    public String toString() {
        return this.get_first_name() + " " + this.get_last_name() + " (Студент)";
    }
    public double get_avg_grades() {
        double avg_grades = 0;
        int count_grades = 0;
        for (int grade : this.grades) {
            avg_grades = avg_grades + grade;
            count_grades = count_grades + 1;
        }
        return avg_grades / count_grades;
    }

    public boolean is_grant() {
        double avg_grades = 0;
        int count_grades = 0;
        boolean flag = false;
        if (this.kurs >= 3) {
            for (int grade : this.grades) {
                avg_grades = avg_grades + grade;
                count_grades = count_grades + 1;
            }

            for( int grade : this.grades_kurs) {
                if (grade == 5) {
                    flag = true;
                    break;
                }
            }
            return flag & (avg_grades / count_grades >= 4.75);
        }
        else {
            for (int grade : this.grades) {
                avg_grades = avg_grades + grade;
                count_grades = count_grades + 1;
            }
            return (avg_grades / count_grades) >= 4.75;
        }

        
        
    }
}
class StudentsByRatingComparator implements Comparator<Student> {
    public int compare(Student o1, Student o2) {
        return Double.compare(o1.get_avg_grades(), o2.get_avg_grades());
    }
}

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        try {
            ArrayList<Human> all_humans = new ArrayList<Human>();
            ArrayList<Human> all_humans_with_grant = new ArrayList<Human>();
            ArrayList<Schoolboy> all_schoolboy = new ArrayList<Schoolboy>();
            ArrayList<Student> all_students = new ArrayList<Student>();
            HashMap<String, Integer> grades1 = new HashMap<String, Integer>();
            grades1.put("математика", 5);
            grades1.put("русский язык", 5);
            grades1.put("история", 5);
            grades1.put("английский язык", 5);
            grades1.put("физкультура", 4);
            HashMap<String, Integer> grades2 = new HashMap<String, Integer>();
            grades2.put("математика", 4);
            grades2.put("русский язык", 5);
            grades2.put("история", 4);
            grades2.put("английский язык", 5);
            grades2.put("физкультура", 4);
            HashMap<String, Integer> grades3 = new HashMap<String, Integer>();
            grades3.put("математика", 5);
            grades3.put("русский язык", 5);
            grades3.put("история", 5);
            grades3.put("английский язык", 5);
            grades3.put("физкультура", 3);
            HashMap<String, Integer> grades4 = new HashMap<String, Integer>();
            grades4.put("математика", 5);
            grades4.put("русский язык", 5);
            grades4.put("история", 5);
            grades4.put("английский язык", 5);
            grades4.put("физкультура", 5);
            ArrayList<Integer> kurs1 = new ArrayList<Integer>();
            kurs1.add(3);
            kurs1.add(5);
            ArrayList<Integer> kurs2 = new ArrayList<Integer>();
            kurs1.add(3);
            kurs1.add(4);
            ArrayList<Integer> kurs3 = new ArrayList<Integer>();
            ArrayList<Integer> kurs4 = new ArrayList<Integer>();
            ArrayList<Integer> kurs5 = new ArrayList<Integer>();
            ArrayList<Integer> stud_grades1 = new ArrayList<Integer>();
            stud_grades1.add(5);
            stud_grades1.add(5);
            ArrayList<Integer> stud_grades2 = new ArrayList<Integer>();
            stud_grades2.add(2);
            stud_grades2.add(3);
            stud_grades2.add(4);
            ArrayList<Integer> stud_grades3 = new ArrayList<Integer>();
            stud_grades3.add(4);
            stud_grades3.add(5);
            stud_grades3.add(3);
            stud_grades3.add(5);
            ArrayList<Integer> stud_grades4 = new ArrayList<Integer>();
            stud_grades4.add(5);
            stud_grades4.add(5);
            stud_grades4.add(3);
            ArrayList<Integer> stud_grades5 = new ArrayList<Integer>();
            stud_grades5.add(2);
            stud_grades5.add(5);
            stud_grades5.add(4);
            stud_grades5.add(5);
            Schoolboy ch = new Schoolboy("Дима", "Колесов", "male", 16, 12, grades1, "областная", 1);
            Schoolboy ch2 = new Schoolboy("Александр", "Погадаев", "male", 15, 4, grades2, "школьная", 1);
            Schoolboy ch3 = new Schoolboy("Анна", "Смирнова", "female", 17, 8, grades3, "городская", 2);
            Schoolboy ch4 = new Schoolboy("Дарья", "Соколова", "female", 14, 10, grades4, "областная", 8);
            Student st = new Student("Игорь", "Пахтушкин", "male", 21, stud_grades1, kurs1, 4);
            Student st2 = new Student("Евгений", "Кокуев", "male", 20, stud_grades2, kurs2, 3);
            Student st3 = new Student("Полина", "Воронина", "female", 21, stud_grades3, kurs3, 4);
            Student st4 = new Student("Алина", "Лисова", "female", 18, stud_grades4, kurs4, 1);
            Student st5 = new Student("Иван", "Пузанов", "male", 19, stud_grades5, kurs5, 2);
            all_humans.add(ch);
            all_humans.add(ch2);
            all_humans.add(ch3);
            all_humans.add(ch4);
            all_humans.add(st);
            all_humans.add(st2);
            all_humans.add(st3);
            all_humans.add(st4);
            all_humans.add(st5);
            all_schoolboy.add(ch);
            all_schoolboy.add(ch2);
            all_schoolboy.add(ch3);
            all_schoolboy.add(ch4);
            all_students.add(st);
            all_students.add(st2);
            all_students.add(st3);
            all_students.add(st4);
            all_students.add(st5);
            Collections.sort(all_humans);
            for (Human all_human : all_humans) {
                if (all_human.is_grant()) {
                    all_humans_with_grant.add(all_human);
                }
            }
            System.out.println(all_humans_with_grant);
            System.out.println("Лучший по успеваемости школьник: " + Collections.max(all_schoolboy, new SchoolboyByRatingComparator()));
            System.out.println("Лучший по успеваемости сутдент: " + Collections.max(all_students, new StudentsByRatingComparator()));
            all_schoolboy.sort(new SchoolboyByRatingComparator());
            System.out.println(all_schoolboy);
            all_schoolboy.sort(new SchoolboyBySchoolNumberComparator());
            System.out.println(all_schoolboy);
            all_students.sort(new StudentsByRatingComparator());
            System.out.println(all_students);
        }catch (Exception err){
            System.out.println("Ошибка");
            System.out.println(err.getMessage());

        }
    }
}
public class Human implements Comparable<Human>{
    private String first_name;
    private String last_name;
    private String gender;
    private Integer age;

    public Human(){
        this.first_name = "";
        this.gender = "";
        this.age = 0;
    }

    public Human(String first_name, String last_name, String gender, Integer age) throws Exception{
        char[] name = first_name.toCharArray();
        char[] surname = last_name.toCharArray();
        if (!Character.isUpperCase(name[0])){
            throw new Exception("Имя с маленькой буквы");
        }else {
            this.first_name = first_name;
        }
        if (!Character.isUpperCase(name[0])){
            throw new Exception("Фамилия с маленькой буквы");
        }else {
            this.last_name = last_name;
        }
        this.gender = gender;
        this.age = age;
    }

    public Human(Human clone){
        this.first_name = clone.first_name;
        this.age = clone.age;
        this.gender = clone.gender;
        this.last_name = clone.last_name;
    }

    public Integer get_age() {
        return this.age;
    }

    public String get_first_name() {
        return this.first_name;
    }

    public String get_last_name() {
        return this.last_name;
    }

    public String get_gender() {
        return this.gender;
    }

    public void set_first_name(String name) {
        this.first_name = name;
    }

    public void set_last_name(String name) {
        this.first_name = name;
    }

    public void set_gender(String gender) {
        this.gender = gender;
    }

    public void set_age(Integer age) {
        this.age = age;
    }

    public int compareTo(Human o) {
        return get_last_name().compareTo(o.get_last_name());
    }

    public boolean is_grant() {
        return false;
    }

}

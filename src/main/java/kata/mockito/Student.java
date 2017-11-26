package kata.mockito;

public class Student {
    private String name;
    private int age;

    public Student(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public final String getNameAge() {
        return name + ": " + age;
    }
}

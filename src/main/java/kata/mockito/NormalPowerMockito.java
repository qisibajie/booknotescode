package kata.mockito;

import java.io.File;

public class NormalPowerMockito {

    public String getStudentName(Student student) {
        return student.getName();
    }

    public String getStudentName(String name) {
        Student student = new Student(name);
        return student.getName();
    }


    public String getPersonName(Person person) {
        return person.getName();
    }

    public String getStudentNameAge(Student student) {
        return student.getNameAge();
    }

    public String getStaticName() {
        return Student.getStaticName();
    }

}

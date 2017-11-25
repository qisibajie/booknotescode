package kata.mockito;

import java.io.File;

public class NormalPowerMockito {

    public String getStudentName(Student student) {
        return student.getName();
    }

    public String getPersonName(Person person) {
        return person.getName();
    }
}

package kata.mockito;

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

    public String getPrivateName() {
        return getPrivate();
    }

    private String getPrivate() {
        return "123";
    }

    public String callSystemStaticMethod(String str) {
        return System.getProperty(str);
    }

    public void loopStudent(int count){
        for(int i=0; i<count;i++){
            Student.getStaticName();
        }

        for(int i=0; i< count+1; i++){
            Mock.getStaticName();
        }
    }
}

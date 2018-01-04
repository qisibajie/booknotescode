package kata.reflect;

import kata.mockito.Person;
import org.junit.Test;

import java.lang.reflect.Field;

public class ReflectOperationTest {
    @Test
    public void testGetSimpleObjectAttribute() {
        ReflectPerson reflectPerson = new ReflectPerson();
        Field[] fields = ReflectPerson.class.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }
    }

    @Test
    public void testSubClassObjectAttribute() {
        ReflectStudent reflectStudent = new ReflectStudent();
        Class<?> studentClass = ReflectStudent.class;

        while (studentClass != Object.class) {

            Field[] fields = studentClass.getDeclaredFields();
            for (Field field : fields) {
                System.out.println(field.getName());
            }
            studentClass = studentClass.getSuperclass();
        }
    }

}

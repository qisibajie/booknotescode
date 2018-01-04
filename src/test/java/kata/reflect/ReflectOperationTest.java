package kata.reflect;

import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.assertTrue;

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
        boolean isExistSameAttribute = ReflectOperation.isExistSameAttribute(ReflectStudent.class);
        assertTrue(!isExistSameAttribute);
    }

}

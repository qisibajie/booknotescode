package kata.reflect;

import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.assertTrue;

public class ReflectUtilsTest {
    @Test
    public void testGetSimpleObjectAttribute() {
        Field[] fields = ReflectPerson.class.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }
    }

    @Test
    public void testSubClassObjectAttribute() {
        boolean isExistSameAttribute = ReflectUtils.isExistSameAttribute(ReflectStudent.class);
        assertTrue(!isExistSameAttribute);
    }

}

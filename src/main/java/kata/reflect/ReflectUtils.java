package kata.reflect;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ReflectUtils {
    public static boolean isExistSameAttribute(Class<?> reflectClass) {
        Class<?> initClass = reflectClass;
        List<String> attributes = new ArrayList<>();
        while (initClass != Object.class) {
            Field[] fields = initClass.getDeclaredFields();
            for (Field field : fields) {
                if (attributes.contains(field.getName())) {
                    return true;
                }
                attributes.add(field.getName());
            }
            initClass = initClass.getSuperclass();
        }
        return false;
    }
}

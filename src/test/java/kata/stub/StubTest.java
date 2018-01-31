package kata.stub;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;
import static org.powermock.api.support.membermodification.MemberMatcher.method;
import static org.powermock.api.support.membermodification.MemberModifier.stub;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Person.class, EnumPerson.class})
public class StubTest {

    @Test
    public void testNormalMethodStub() {
        stub(method(Person.class, "getName")).toReturn("stubName");
        Person person = new Person();

        assertEquals("stubName", person.getName());
    }

    @Test
    public void testPrivateMethodStub() {
        stub(method(Person.class, "getPrivate")).toReturn("stubPrivate");
        Person person = new Person();

        assertEquals("stubPrivate", person.callPrivateMethod());
    }

    @Test
    public void testFinalMethodStub() {
        stub(method(Person.class, "getFinal")).toReturn("stubFinal");
        Person person = new Person();

        assertEquals("stubFinal", person.getFinal());
    }

    @Test
    public void testStaticMethodStub() {
        stub(method(Person.class, "getStatic")).toReturn("stubStatic");

        assertEquals("stubStatic", Person.getStatic());
    }

    @Test
    public void testEnumMethodStub() {
        stub(method(EnumPerson.class, "getEnum")).toReturn("stubEnum");

        assertEquals("stubEnum", EnumPerson.ENUM_WILL.getEnum("will"));
    }
}

package kata.mockito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.powermock.api.mockito.PowerMockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Mock.class)
public class NormalPowerMockitoTest {

    @Test
    public void testGetStudentNameByStudent() {
        //given
        Student student = mock(Student.class);
        NormalPowerMockito normalPowerMockito = new NormalPowerMockito();
        //when
        when(student.getName()).thenReturn("Will");
        String expectedName = normalPowerMockito.getStudentName(student);
        //then
        assertThat(expectedName, is("Will"));
    }

    @Test
    @PrepareForTest(NormalPowerMockito.class)
    public void should_use_RunWith_PrepareForTest_annotation_When_use_WhenNew_method() throws Exception {
        //given
        Student student = mock(Student.class);
        NormalPowerMockito normalPowerMockito = new NormalPowerMockito();
        //when
        whenNew(Student.class).withArguments("WILL").thenReturn(student);
        when(student.getName()).thenReturn("WILL_START");
        String expectedName = normalPowerMockito.getStudentName("WILL");
        //then
        assertThat(expectedName, is("WILL_START"));
    }

    @Test
    public void testGetPersonNameWithInterface() {
        //given
        NormalPowerMockito normalPowerMockito = new NormalPowerMockito();
        //when
        Person person = mock(Person.class);
        when(person.getName()).thenReturn("Will");
        String expectedPersonName = normalPowerMockito.getPersonName(person);
        //then
        assertThat(expectedPersonName, is("Will"));
    }

    @Test
    @PrepareForTest(Student.class)
    public void should_use_RunWith_PrepareForTest_annotation_when_mock_final_method_given_final_method_in_student() {
        //given
        NormalPowerMockito normalPowerMockito = new NormalPowerMockito();
        //when
        Student student = mock(Student.class);
        when(student.getNameAge()).thenReturn("Will : 18");
        String expectedNameAge = normalPowerMockito.getStudentNameAge(student);
        //then
        assertThat(expectedNameAge, is("Will : 18"));
    }

    @Test
    @PrepareForTest(Student.class)
    public void should_use_RunWith_PrepareForTest_annotation_when_mock_static_method_given_static_method_in_student() {
        //given
        NormalPowerMockito normalPowerMockito = new NormalPowerMockito();
        //when
        mockStatic(Student.class);
        when(Student.getStaticName()).thenReturn("will-static");
        String expectedName = normalPowerMockito.getStaticName();
        //then
        assertThat(expectedName, is("will-static"));
    }

    @Test
    @PrepareForTest(NormalPowerMockito.class)
    public void should_use_PrepareForTest_annotation_when_mock_private_method_given_private_method_in_normalPowerMockito() throws Exception {
        //given
        NormalPowerMockito normalPowerMockito = mock(NormalPowerMockito.class);
        //when
        when(normalPowerMockito.getPrivateName()).thenCallRealMethod();
        when(normalPowerMockito, "getPrivate").thenReturn("willPrivate");
        String expectedName = normalPowerMockito.getPrivateName();
        //then
        assertThat(expectedName, is("willPrivate"));
    }

    @Test
    @PrepareForTest(NormalPowerMockito.class)
    public void should_use_PrepareForTest_annotation_when_mock_system_static_method() {
        //given
        NormalPowerMockito normalPowerMockito = new NormalPowerMockito();
        mockStatic(System.class);
        //when
        when(System.getProperty("abc")).thenReturn("AAA");
        String expectedName = normalPowerMockito.callSystemStaticMethod("abc");
        //then
        assertThat(expectedName, is("AAA"));
    }

    @Test
    @PrepareForTest({Student.class, Mock.class})
    public void verify_static_method() {
        //given
        NormalPowerMockito normalPowerMockito = new NormalPowerMockito();
        mockStatic(Student.class);
        mockStatic(Mock.class);
        //when
        normalPowerMockito.loopStudent(2);
        //then

        verifyStatic(times(2));
        Student.getStaticName();

        verifyStatic(times(3));
        Mock.getStaticName();

        verifyStatic(times(4));
        Student.printHelloWorld();
    }

    @Test
    @PrepareForTest({Student.class})
    public void mock_void_static_method() {
        //given
        mockStatic(Student.class);

//        doNothing().when(Student.class);

        Student.printHelloWorld();
    }

    @Test
    @PrepareForTest({Student.class})
    public void test_mock_private_method() throws Exception {
        //given
        Student student = mock(Student.class);
        when(student.callPrivateMethod()).thenCallRealMethod();
        when(student, "getPrivateName").thenReturn("PrivateMock");
        assertEquals("PrivateMock", student.callPrivateMethod());
    }
}
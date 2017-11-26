package kata.mockito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.powermock.api.mockito.PowerMockito.*;

@RunWith(PowerMockRunner.class)
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
        String personName = normalPowerMockito.getPersonName(person);
        //then
        assertThat(personName, is("Will"));
    }

    @Test
    @PrepareForTest(Student.class)
    public void should_use_RunWith_PrepareForTest_annotation_when_mock_final_method_given_final_method_in_student() {
        //given
        NormalPowerMockito normalPowerMockito = new NormalPowerMockito();
        //when
        Student student = mock(Student.class);
        when(student.getNameAge()).thenReturn("Will : 18");
        String studentNameAge = normalPowerMockito.getStudentNameAge(student);
        //then
        assertThat(studentNameAge, is("Will : 18"));
    }

}
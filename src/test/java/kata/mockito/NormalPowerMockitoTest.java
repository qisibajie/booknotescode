package kata.mockito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.powermock.api.mockito.PowerMockito.whenNew;

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
    public void testNormalMockito_getPersonName() {
        Person person = mock(Person.class);
        when(person.getName()).thenReturn("Will");
        NormalPowerMockito normalPowerMockito = new NormalPowerMockito();
        assertThat(normalPowerMockito.getPersonName(person), is("Will"));
    }

}
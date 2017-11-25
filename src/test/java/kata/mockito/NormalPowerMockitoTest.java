package kata.mockito;

import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.powermock.api.mockito.PowerMockito.when;

public class NormalPowerMockitoTest {

    @Test
    public void testNormalMockito_getStudentName() {
        Student student = PowerMockito.mock(Student.class);
        when(student.getName()).thenReturn("Will");
        NormalPowerMockito normalPowerMockito = new NormalPowerMockito();
        assertThat(normalPowerMockito.getStudentName(student), is("Will"));
    }

    @Test
    public void testNormalMockito_getPersonName() {
        Person person = PowerMockito.mock(Person.class);
        when(person.getName()).thenReturn("Will");
        NormalPowerMockito normalPowerMockito = new NormalPowerMockito();
        assertThat(normalPowerMockito.getPersonName(person), is("Will"));
    }

}
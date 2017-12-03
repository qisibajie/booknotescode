package kata.legcycode.chapter3;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class SaleTest {

    @Test
    public void testDisplayAnItem() {
        FakeDisplay fakeDisplay = new FakeDisplay();
        Sale sale = new Sale(fakeDisplay);

        sale.scan("wanglichangcheng");

        assertEquals("123wanglichangcheng", fakeDisplay.getItemLine());
    }

    @Test
    public void testDisplayAnItemWithMock() {
        Display display = mock(Display.class);
        Sale sale = new Sale(display);

        sale.scan("wanglichangcheng");

        verify(display).showLine("123wanglichangcheng");
    }

    @Test
    public void testGetNameWithSpy() {
        Sale sale = spy(Sale.class);

        assertEquals("will", sale.getName("will"));
        verify(sale).getName("will");
    }

    @Test
    public void testGetNameWithMock3Times() {
        Sale sale = mock(Sale.class);

        when(sale.getName("will")).thenReturn("WILL");
        assertEquals("WILL", sale.getName("will"));
        assertEquals("WILL", sale.getName("will"));
        assertEquals("WILL", sale.getName("will"));
        verify(sale, times(3)).getName("will");
    }

    @Test
    public void testSpyDoReturnShouldNotGoThroughMethodBody() {
        Sale sale = spy(Sale.class);

        doReturn(3).when(sale).getAge(1);
        assertEquals(3, sale.getAge(1));
        verify(sale).getAge(1);
    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void testSpyThenReturnShouldGoThroughMethodBody() {
        Sale sale = spy(Sale.class);

        when(sale.getAge(1)).thenReturn(3);
        assertEquals(3, sale.getAge(1));
        verify(sale).getAge(1);
    }
}
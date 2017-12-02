package kata.legcycode.chapter3;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class SaleTest {

    @Test
    public void testDisplayAnItem() {
        FakeDisplay fakeDisplay = new FakeDisplay();
        Sale sale = new Sale(fakeDisplay);

        sale.scan("wanglichangcheng");

        assertEquals("123wanglichangcheng", fakeDisplay.getItemLine());
    }

    @Test
    public void testDisplayAnItemWithMock(){
        Display display = mock(Display.class);
        Sale sale = new Sale(display);

        sale.scan("wanglichangcheng");

        verify(display).showLine("123wanglichangcheng");
    }

}
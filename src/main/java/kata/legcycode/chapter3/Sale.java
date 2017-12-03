package kata.legcycode.chapter3;

import java.util.ArrayList;
import java.util.List;

public class Sale {
    private Display display;

    public Sale() {

    }

    public Sale(Display display) {
        this.display = display;
    }

    public void scan(String barcode) {
        String itemLine = "123" + barcode;
        display.showLine(itemLine);
    }

    public String getName(String name) {
        return name;
    }

    public int getAge(int age) {
        List<Integer> integers = new ArrayList<>();
        return integers.get(10);
    }

}

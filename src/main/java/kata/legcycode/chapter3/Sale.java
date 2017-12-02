package kata.legcycode.chapter3;

public class Sale {
    private Display display;

    public Sale(Display display){
        this.display = display;
    }

    public void scan(String barcode) {
        String itemLine = "123" + barcode;
        display.showLine(itemLine);
    }

}

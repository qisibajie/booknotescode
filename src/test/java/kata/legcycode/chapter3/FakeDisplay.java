package kata.legcycode.chapter3;

public class FakeDisplay implements Display {
    private String itemLine;

    @Override
    public void showLine(String itemLine) {
        this.itemLine = itemLine;
    }

    public String getItemLine() {
        return itemLine;
    }
}

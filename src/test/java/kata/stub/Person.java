package kata.stub;

public class Person {

    public String getName(){
        return "name";
    }

    private String getPrivate(){
        return "private";
    }

    public final String getFinal(){
        return "final";
    }

    public static String getStatic(){
        return "static";
    }

    public String callPrivateMethod(){
        return getPrivate();
    }
}

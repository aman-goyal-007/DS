import java.io.*;
 

public class Test {
    public static void main(String[] args) {
        Flags f = Flags.TRUE;
    }
}

enum Flags{
    TRUE("t"),FALSE("f"),A("z");
    private String a;

    Flags(String a){
        System.out.println("g");
    }
}
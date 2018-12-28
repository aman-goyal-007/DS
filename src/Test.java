import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class Test {
    public static void main(String[] args) {
        List aman = new ArrayList<Object>();
        test(aman);
    }

    public static void test(Collection<Object> a){

    }

}

enum Flags{
    TRUE,FALSE,A;

    private Flags(){
        System.out.println("g");
    }
}
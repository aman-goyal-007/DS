package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Aman",31));
        list.add(new Employee("Richa",28));

        Comparator<Employee> comp= (e1,e2)->{return e2.getName().compareTo(e1.getName());};
        Collections.sort(list,Comparator.comparing(Employee::getName).reversed());
        list.stream().forEach(System.out::println);
    }
}

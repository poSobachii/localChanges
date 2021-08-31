package u001Usefull.comparators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ListOperations {

    public static void main(String[] args) {
//        firstObject();
//        ListOperations test = new ListOperations();
//        test.sortingList();
        sortingList();
    }

    static void firstObject() {

        List<String> initializeList = List.of("String1", "String2");
        System.out.println(initializeList);
        List<String> listString = new LinkedList<>();
        listString.add("first add");
        listString.add("second add");
        listString.add("third add");
        System.out.println(listString);
        listString.add(0, "new add");
        System.out.println(listString);
    }

    static void sortingList() {

        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1, "Lokesh", "Gupta"));
        list.add(new Employee(3, "Alex", "Gussin"));
        list.add(new Employee(2, "Brian", "Sux"));
        list.add(new Employee(2, "Neon", "Piper"));
        list.add(new Employee(1, "Witch", "Piper"));
        list.add(new Employee(3, "David", "Beckham"));
        list.add(new Employee(2, "Alex", "Beckham"));
        list.add(new Employee(3, "Brian", "Suxena"));

        System.out.println(list.toString());
        Collections.sort(list, Comparator.comparing(Employee::getId).thenComparing(Employee::getName));
        list.sort(Comparator.comparing(Employee::getId).thenComparing(Employee::getName));

//        list.sort(Comparator.comparing(Employee::getId));
//        Collections.sort(list.subList(2, list.size()), Comparator.comparing(Employee::getName));

        Employee emp1 = list.stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparing(Employee::getId).reversed())
                .orElse(null);
        System.out.println(emp1.getId());
        Collections.sort(list, new SurnameComporator());
        System.out.println(list.toString());


    }
}


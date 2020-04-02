package a32_collections;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Collections {

    public static void main(String[] args) {
        arrayList();
//        set();
//        hashMap();
//        queue();
//        deque();
    }

    static void arrayList() {
        List<String> list = new ArrayList<String>();
        list.add("Green");
        list.add("Red");
        list.add("Blue");

        System.out.println(list);

        for (String item : list) {
            System.out.println(item);
        }
    }

    static void set() {
        Set<String> set = new HashSet<String>();
        set.add("Green");
        set.add("Red");
        set.add("Blue");

        System.out.println("дупликаты не допустимы: " + set);
    }

    static void hashMap() {
        Map<String, String> stringStringMap = new HashMap<String, String>();
        stringStringMap.put("Green", "Mark’s favourite");
        stringStringMap.put("Blue", "Joe’s least favourite");

        String value = stringStringMap.get("Green");
        System.out.println("Достань нам value ключа Green: " + value);

        for (String key : stringStringMap.keySet()) {
            System.out.println(stringStringMap.get(key));
        }

    }

    static void queue() {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < 5; i++)
            q.add(i);
        System.out.println("Все элементы нашей queue: " + q);
        int removed = q.remove();
        System.out.println("Какой элемент убрали ?: " + removed);
        System.out.println("Все элементы нашей queue после удаления головного элемента: " + q);
        System.out.println("Посмотрим какой следующий на выход: " + q.peek());
        System.out.println("Размер queue теперь: " + q.size());
    }

    static void deque(){
        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < 5; i++)
            q.add(i);
        System.out.println("Все элементы нашей deque: " + q);
        q.addFirst(10);
        q.addLast(15);
        System.out.println("Все элементы нашей deque после добавления значений: " + q);
        int firstToRemove = q.removeFirst();
        int lastToRemove = q.removeLast();
        System.out.println("Первый обьект: " + firstToRemove + " и последний: " + lastToRemove);
    }
}

package u001Usefull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class SetArrayMap {

    public static void main(String args[]) {

        // -----------------------------------------------------------------------------------
        System.out.println("HashSet EXAMPLE:");
        Set mySet1 = new HashSet();
        mySet1.add("A");
        mySet1.add("C");
        mySet1.add("A");
        mySet1.add("B");
        System.out.println("mySet1: " + mySet1);

        boolean delete = false;
        if (delete) {
            for (Iterator<String> iterator = mySet1.iterator(); iterator.hasNext(); ) {
                String s = iterator.next();
                if (s.length() % 2 == 0) {
                    iterator.remove();
                }
            }
        }

        List list = new ArrayList();
        list.add("D");
        list.add("C");
        list.add("A");
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("A");
        Set mySet2 = new HashSet(list);
        System.out.println("list: " + list);
        System.out.println("mySet2: " + mySet2);

        System.out.println("MySet1 matches mySet2: " + mySet1.equals(mySet2));

        mySet2.remove("D");
        System.out.println("mySet2: " + mySet2);
        System.out.println("MySet1 matches mySet2: " + mySet1.equals(mySet2));

        System.out.println("MySet1 contains all the elements: " + mySet1.containsAll(list));
        System.out.println("MySet2 contains all the elements: " + mySet2.containsAll(list));

        Iterator iterator = mySet1.iterator();
        while (iterator.hasNext()) {
            System.out.println("Iterator loop: " + iterator.next());
        }

        for (Object str : mySet1) {
            System.out.println("for-each loop: " + str);
        }

        mySet1.clear();
        System.out.println("mySet1 is Empty: " + mySet1.isEmpty());

        System.out.println("mySet1 has: " + mySet1.size() + " Elements");
        System.out.println("mySet2 has: " + mySet2.size() + " Elements");

        Object[] array = mySet2.toArray(new String[mySet2.size()]);
        System.out.println("The array:" + Arrays.toString(array));


        //        ----------------------------------------------------------
        System.out.println(" ");
        System.out.println("TreeSet EXAMPLE :");


        TreeSet<String> ts = new TreeSet<String>();

        ts.add("z");
        ts.add("A");
        ts.add("3");
        ts.add("H");
        ts.add("A");

        System.out.println(ts);

        TreeSet<Integer> ts2 = new TreeSet<Integer>();

        ts2.add(3);
        ts2.add(4);
        ts2.add(5);
        ts2.add(1);
        ts2.add(2);

        System.out.println(ts2);

        TreeSet<String> tree_set = new TreeSet<String>(new
                The_Comparator());

        tree_set.add("G");
        tree_set.add("E");
        tree_set.add("E");
        tree_set.add("K");
        tree_set.add("S");
        tree_set.add("4");
        System.out.println("Set before using the comparator: " +
                tree_set);

        System.out.println("The elements sorted in descending" +
                "order:");
        for (String element : tree_set)
            System.out.print(element + " ");


        //      -----------------------------------------------------------------------------
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("LinkedSet EXAMPLE: ");


        LinkedHashSet<String> linkedset =
                new LinkedHashSet<String>();

        linkedset.add("D");
        linkedset.add("B");
        linkedset.add("C");
        linkedset.add("A");

        linkedset.add("A");
        linkedset.add("E");

        System.out.println("Size of LinkedHashSet = " +
                linkedset.size());
        System.out.println("Original LinkedHashSet:" + linkedset);
        System.out.println("Removing D from LinkedHashSet: " +
                linkedset.remove("D"));
        System.out.println("Trying to Remove Z which is not " +
                "present: " + linkedset.remove("Z"));
        System.out.println("Checking if A is present=" +
                linkedset.contains("A"));
        System.out.println("Updated LinkedHashSet: " + linkedset);


        //        -----------------------------------------------------------------------------
        System.out.println(" ");
        System.out.println("List EXAMPLE: ");


        List templist = new ArrayList<>();

        System.out.println("1 - Current list is :" + templist);
        templist.add(0, "0");
        System.out.println("2 - Current list is :" + templist);
        templist.add(1, "1");
        System.out.println("3 - Current list is :" + templist);
        templist.set(1, "2");
        System.out.println("4 - Current list is :" + templist);
        templist.remove("1");
        System.out.println("5 - Current list is :" + templist);


        //        -----------------------------------------------------------------------------
        System.out.println(" ");
        System.out.println("Array vs ArrayList EXAMPLE: ");

        int[] arr = new int[3];
        System.out.println("1 - Current Array[]: " + Arrays.toString(arr));
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        System.out.println("2 - Current Array[]: " + Arrays.toString(arr));
        arr[2] = 7;
        System.out.println("3 - Current Array[]: " + Arrays.toString(arr));
        //       arr[3] = 5;    <-- bound exception error

        ArrayList<Integer> arrL = new ArrayList<Integer>();
        arrL.add(1);
        arrL.add(4);
        arrL.add(3);
        arrL.add(2);
        arrL.add(5);
        System.out.println("1 - Current ArrayList: " + arrL);


        //        -----------------------------------------------------------------------------
        System.out.println(" ");
        System.out.println("LinkedList EXAMPLE: ");

        LinkedList<String> linkedlist = new LinkedList<String>();

        linkedlist.add("Item1");
        linkedlist.add("Item5");
        linkedlist.add("Item3");
        linkedlist.add("Item6");
        linkedlist.add("Item2");

        System.out.println("Linked List Content: " + linkedlist);

        linkedlist.addFirst("First Item");
        linkedlist.addLast("Last Item");
        System.out.println("LinkedList Content after addition: " + linkedlist);

        Object firstvar = linkedlist.get(0);
        System.out.println("First element: " + firstvar);
        linkedlist.set(0, "Changed first item");
        Object firstvar2 = linkedlist.get(0);
        System.out.println("First element after update by set method: " + firstvar2);

        linkedlist.removeFirst();
        linkedlist.removeLast();
        System.out.println("LinkedList after deletion of first and last element: " + linkedlist);

        linkedlist.add(0, "Newly added item");
        linkedlist.remove(2);
        System.out.println("Final Content: " + linkedlist);


        //        -----------------------------------------------------------------------------
        System.out.println(" ");
        System.out.println("Queue EXAMPLE: ");

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < 5; i++)
            q.add(i);
        System.out.println("Elements of queue - " + q);

        int removedele = q.remove();
        System.out.println("removed element - " + removedele);
        System.out.println(q);
        q.add(5);
        System.out.println(q);
        System.out.println(((LinkedList<Integer>) q).get(4));
        q.remove();
        q.remove();
        System.out.println(q);
        int head = q.peek();
        System.out.println("head of queue - " + head);

        int size = q.size();
        System.out.println("Size of queue - " + size);


        //        -----------------------------------------------------------------------------
        System.out.println(" ");
        System.out.println("Stack EXAMPLE: ");

        Stack<String> stackOfCards = new Stack<>();

        stackOfCards.push("Jack");
        stackOfCards.push("Queen");
        stackOfCards.push("King");
        stackOfCards.push("Ace");

        System.out.println("Stack => " + stackOfCards);
        String cardAtTop = stackOfCards.pop();  // Throws EmptyStackException if the stack is empty
        System.out.println("Stack.pop() => " + cardAtTop);
        System.out.println("Current Stack => " + stackOfCards);
        cardAtTop = stackOfCards.peek(); // Get the item at the top of the stack without removing it
        System.out.println("Stack.peek() => " + cardAtTop);
        System.out.println("Current Stack => " + stackOfCards);

        int position = stackOfCards.search("Queen"); // It returns -1 if the element was not found in the stack
        if (position != -1) {
            System.out.println("Found the element \"Queen\" at position : " + position);
        } else {
            System.out.println("Element not found");
        }


        //        -----------------------------------------------------------------------------
        System.out.println(" ");
        System.out.println("HashMap EXAMPLE: ");

        class Dog {
            String color;

            Dog(String c) {
                color = c;
            }

            public String toString() {
                return color + " dog";
            }
        }

        HashMap hashMap = new HashMap<>();
        String d1 = "red";
        String d2 = "black";
        String d3 = "blue";
        String d4 = "white";
        String d5 = "green";
        String d6 = "black";
        String d7 = "white";
        String d8 = "orange";
        hashMap.put(d1, 10);
        hashMap.put(d2, 15);
        hashMap.put(d3, 5);
        hashMap.put(d4, 20);
        hashMap.put(d5, 25);
        hashMap.put(d6, 30);
        hashMap.put(d7, 35);
        hashMap.put(d8, 40);

        System.out.println(hashMap.size());
        hashMap.forEach((key, value) -> {
            System.out.println("Key : " + key + " ||   Value : " + value);
        });
    }
}


class The_Comparator implements Comparator<String> {
    public int compare(String str1, String str2) {
        String first_Str = str1;
        String second_Str = str2;
        return second_Str.compareTo(first_Str);
    }
}
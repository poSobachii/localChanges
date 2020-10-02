import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class FixCheck {

    public static void main(String[] args) {
        testNotNull();
    }

    static void testNotNull(){
        NotNullObject test = new NotNullObject();
        System.out.println(test.toString());
    }


    static void replaceObject(){
        int x = 9;
        System.out.println(x);
        x += 2;
        System.out.println(x);
        replaceInt(x);
        System.out.println(x);
    }

    static void replaceInt(int input){
        input += 2;
    }

    static void filterOutSmth(){
        ArrayList<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        System.out.println(integerList);
        filter(integerList);
        System.out.println("finally " + integerList);
    }
    static void filter(ArrayList<Integer> input){
        System.out.println(input);
        System.out.println(input.size());
        input.remove(1);
    }

    static void listTypes(List<Long> listToCheck){
        listToCheck = List.of(1L, 2L);
        System.out.println(listToCheck);
    }

    static void setContains(){
        Set<SomeSetObject> setToTest = new HashSet<>();
        SomeSetObject someSetObject = new SomeSetObject(1, "Jhon", "Snow");
        setToTest.add(someSetObject);
        setToTest.add(new SomeSetObject(2, "Khal", "Drogo"));
        setToTest.add(new SomeSetObject(3, "queen", "Elizabeth"));

        Set<SomeSetObject> setToTest2 = new HashSet<>();
        setToTest2.add(new SomeSetObject(10, "Jakob", "Snow"));
        setToTest2.add(new SomeSetObject(11, "Peeza", "Drogo"));
        setToTest2.add(new SomeSetObject(12, "Hulio", "Elizabeth"));

        List<SomeAnotherSetObject> anotherSetToTest = new ArrayList<>();
        anotherSetToTest.add( new SomeAnotherSetObject(1L, setToTest));
        anotherSetToTest.add( new SomeAnotherSetObject(2L, setToTest2));

        List<SomeAnotherSetObject> yoyoyo = anotherSetToTest.stream()
                .filter(x -> x.getSomeSet().contains(someSetObject))
                .collect(Collectors.toList());

        System.out.println(yoyoyo.get(0).getSomeSet());
        System.out.println(yoyoyo.get(1).getSomeSet());
    }

    static void definVariables() {
        long lon = 10L;
        int in = 10;
        long newlon = Long.valueOf(in);
        long newlon2 = in;



        byte byt = 53;
        int in2 = byt;

        int in3 = 53;
        byte byt2 = (byte) in3;

        int array[] = new int[10];
        array[0] = 100;
//        System.out.println(array[1]);


        char [] [] values = {
                {'a','b','c'},
                {'x', 'y'}
        };

//        System.out.println(values[1][1]);

//        String str1="Hello";
//        System.out.println("str1 is "+ str1);
//        String str2 = str1;
//        str1 ="World!!";
//        System.out.println("str1 after modify "+ str1);
//        System.out.println("str2 is "+ str2);


//        char[] copyFrom = { 'd', 'e', 'j', 'a', 'v', 'a', 'e', 'i', 'n', 'a', 't', 'e', 'd' };
//        char[] copyTo = new char[7];
//        System.arraycopy(copyFrom, 2, copyTo, 0, 4);
//        System.out.println(copyTo);


        int [] array1 = {2, 3, 4, 5, 6 ,7};
        int [] array2 = {2, 3, 4, 5, 6, 7};
        int [] array3 = {7, 4, 9, 1, 2, 8};

        System.out.println(array1.equals(array2));
        System.out.println(array1 == array2);
        System.out.println(Arrays.equals(array1, array2));
        System.out.println(Arrays.equals(array2, array3));

        Arrays.fill(array3, 10);
        System.out.println(Arrays.toString(array3));

        System.out.println(Arrays.toString(array3));
        Arrays.sort(array3);
        System.out.println(Arrays.toString(array3));

        String[] stringArray = {"Bob", "Michael", "jack"};

        List<String> integerList = Arrays.asList(stringArray);
        System.out.println(integerList.get(2));


        int[] org = new int[] {1, 2 ,3};
        int[] copy = Arrays.copyOf(org, 5);
        System.out.println(Arrays.toString(copy));
        copy[3] = 11;
        copy[4] = 55;
        System.out.println(Arrays.toString(copy));

        int arr[] = { 12, 13, 14, 15, 16, 17, 18 };

        int[] copy2 = Arrays.copyOfRange(arr, 2, 6);
        System.out.println(Arrays.toString(copy2));

        String smth = " Something is going";
        System.out.println(smth.trim());
        System.out.println(smth.indexOf("o"));

        String str= "quick brown fox jumps over the lazy dog";
        System.out.println("Substring starting from index 15:");
        System.out.println(str.substring(15));
        System.out.println("Substring starting from index 15 and ending at 20:");
        System.out.println(str.substring(15, 20));

        String str2 = "geekss@for@geekss";
        String[] arrOfStr = str2.split("@", 2);

        for (String a : arrOfStr)
            System.out.println(a);
    }

    static void putallmap() {
        HashMap<String, String> map1 = new HashMap<>();
        HashMap<String, String> map2 = new HashMap<>();
        map1.put("key1", "value1");
        map2.put("key2", "value2");
        map1.putAll(map2);
        System.out.println();
    }

    static void replaceallstring() {
        final String str1 = "Hello world";
        String str2 = str1.replaceAll("world", "peace");
        String str3 = str1.replaceAll("earth", "hell");
        String link1 = "www.google.com";
        String link2 = link1.replaceAll("www.", "https://");
        System.out.println(str2);
        System.out.println(link2);
    }

    static void ifStartsString() {
        String str1 = "Hello4World";
        String str2;
        if (str1.startsWith("Hello")) {
            str2 = str1.replaceAll("Hello", "Hi ");
        } else {
            str2 = "nothing happed";
        }
        System.out.println(str2);
    }

    static void constructorTest() {
        FixObject fixObject = new FixObject("Some", "object");
        System.out.println("result = " + fixObject);
    }

    static void iftest(int input) {
        int x = 5;
        int y = 6;
        int z = 7;
        if (x != input && y != input) {
            System.out.println("If done !");
        } else {
            System.out.println("If NOT done !!");
        }
    }

    static void divideZEro() {
        int x = 0;
        int y = 10 / x;
        System.out.println(y);
    }

    static void divideByPercent() {
        System.out.println(30 % 100);
        System.out.println(65 % 100);
        System.out.println(100 % 100);
        System.out.println(135 % 100);
        System.out.println(170 % 100);
        System.out.println(200 % 100);
    }

    static void replaceSmth() {
        String before = "eeac8037-e860-496b-9a7a-03a092bf253e";
        String after = before.replaceAll("-", "");
        System.out.println("before = " + before);
        System.out.println("after = " + after);
    }

    static void addString() {
        String digits = "4522";
        System.out.println("************" + digits);
    }

    static void atCharPlace() {
        String digits = "4525";
        System.out.println(digits.charAt(2) + "" + digits.charAt(3));
    }

    static void addZero() {
        String year = "2020";
        String month = "7";
        if (month.length() < 2) {
            month = "0" + month;
        }
        System.out.println(year.charAt(2) + "" + year.charAt(3) + "/" + month);
    }
}


class SomeSetObject {
                int nubmer;
                String name;
                String surname;

    public SomeSetObject(int nubmer, String name, String surname) {
        this.nubmer = nubmer;
        this.name = name;
        this.surname = surname;
    }

    public int getNubmer() {
        return nubmer;
    }

    public void setNubmer(int nubmer) {
        this.nubmer = nubmer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}

class SomeAnotherSetObject {
    Long id;
    Set<SomeSetObject> someSet;

    public SomeAnotherSetObject(Long id, Set<SomeSetObject> someSet) {
        this.id = id;
        this.someSet = someSet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<SomeSetObject> getSomeSet() {
        return someSet;
    }

    public void setSomeSet(Set<SomeSetObject> someSet) {
        this.someSet = someSet;
    }
}

class NotNullObject{

    @NotNull
    private String name;

    @NotNull
    private Integer age;


    public NotNullObject() {
    }

    public NotNullObject(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Name is " + name + ", age is " + age;
    }
}
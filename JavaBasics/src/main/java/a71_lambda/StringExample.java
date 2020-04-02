package a71_lambda;

public class StringExample {
    public static void main(String args[]) {
        MyGreeting morningGreeting = str -> "Good Morning " + str + "!";
        MyGreeting eveningGreeting = str -> "Good Evening " + str + "!";
        MyGreeting reverseStr = str -> {
            String result = "";

            for (int i = str.length() - 1; i >= 0; i--)
                result += str.charAt(i);

            return result;
        };

        System.out.println(morningGreeting.processName("Luis"));
        System.out.println(eveningGreeting.processName("Jessica"));
        System.out.println(reverseStr.processName("Lambda Demo"));
    }
}

interface MyGreeting {
    String processName(String str);
}


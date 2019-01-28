class Calculator {

    String calculate(String[] expression) {

        double a = Double.parseDouble(expression[0]);
        double b = Double.parseDouble(expression[2]);
        double c = Double.parseDouble(expression[4]);
        double result;
        switch (expression[1] + expression[3]) {
            case "++":
                result = a + b + c;
                break;
            case "+-":
                result = a + b - c;
                break;
            case "+*":
                result = a + (b * c);
                break;

            default:
                return "STOP";
        }
        return String.valueOf(result);
    }

}

--------------------------------------------------------------------------------------------------------------

for (int i = 0; i < 5; i++) {
.
.
.
.
}
инициализация - Начинаем считать i с нуля , условие - до тех пор пока i не станет =5 . инкремент i++ 


--------------------------------------------------------------------------------------------------------------
package guessnum;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static Random rand = new Random();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int myNum = rand.nextInt(100) + 1;
        System.out.println(myNum);

        int userNum = scan.nextInt();

        if (userNum > myNum) {
            System.out.println("lower");
        }
        if (userNum < myNum) {
            System.out.println("higher");
        }
        if (userNum == myNum) {
            System.out.println("correct");
    }
}

---------------------------------------------------------------------------------------------------------------------
public class HelloWorld {
	public static void main(String[] args) {
		String name;
		System.out.println(args.length);
		if (args.length == 0) {
			name = "World";
		} else {
			name = String.join(" ",args); 
		}
		System.out.println ("Hello, " + name);
	}
}
----------------------------------------------------------------------------------------------------------------------

public class Calc {
	public static void main(String[] args) {
		String strA = args[0];
		String strB = args[1];
		System.out.println(strA + strB);
		double a = Double.parseDouble(strA);
		double b = Double.parseDouble(strB);
		System.out.printf("Result = %.2f", (a+b));
	}
}

----------------------------------------------------------------------------------------------------------------------

package com.company;

import java.util.*;


public class Main {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("What's your name ?");
        String name = scan.nextLine();
        System.out.println(name.length());
        if (name.length() == 0) {
            name = "World";
        }
        System.out.println("Hello, " + name);
    }
}

//public class Main {
//
//    static Scanner scan = new Scanner(System.in);
//
//    public static void main(String[] expression) {
//        String name = scan.nextLine();
//        System.out.println(expression.length);
//        System.out.println("Hello " + name);
//    }
//}

----------------------------------------------------------------------------------------------------------------------

package testing;

public class Main {

    public static void main(String[] args) {
        double A = 10;
        double B = 25;
        double result;
        System.out.println(B % A);
        result = (B / A);
        System.out.println(result);
    }
}

----------------------------------------------------------------------------------------------------------------------

public class Puppy{

    public Puppy(String name){
        // Это конструктор и у него один параметр, name.
        System.out.println("Передаваемое имя:" + name );
    }
    public static void main(String []args){
        // Создание объекта myPuppy.
        Puppy myPuppy = new Puppy( "Багет" );
        Puppy myPuppy1 = new Puppy( "Багет2" );
        Puppy myPuppy2 = new Puppy( "Багет3" );
    }
}

---------------------------------------------------------------------------------------------------------------------- 

public class Test {    // улучшеный for

   public static void main(String args[]){
      int [] numbers = {10, 20, 30, 40, 50};

      for(int x : numbers ){
         System.out.print( x );
         System.out.print(",");
      }
      System.out.print("\n");
      String [] names ={"Олег", "Иван", "Дима", "Юля"};
      for( String name : names ) {
         System.out.print( name );
         System.out.print(",");
      }
   }
}

---------------------------------------------------------------------------------------------------------------------- 

public class Program{

    public static void main (String args[]){

        int x = sum(1, 2, 3);
        int y = sum(1, 4, 9);
        System.out.println(x);  // 6
        System.out.println(y);  // 14
    }
    static int sum(int a, int b, int c){

        return a + b - c;
    }
}

---------------------------------------------------------------------------------------------------------------------- 

public class Program{
      
    public static void main (String args[]){
          
        daytime(7);     // Good morning
        daytime(13);    // Good after noon
        daytime(32);    // 
        daytime(56);    // 
        daytime(2);     // Good night
    }
    static void daytime(int hour){
         
        if (hour >24 || hour < 0)
            return;
        if(hour > 21 || hour < 6)
            System.out.println("Good night");
        else if(hour >= 15)
            System.out.println("Good evening");
        else if(hour >= 11)
            System.out.println("Good after noon");
        else
            System.out.println("Good morning");
    }
}

---------------------------------------------------------------------------------------------------------------------- 

public class Test {

   public static void main(String args[]) {
      int [] numbers = {10, 20, 30, 40, 50};

      for(int x : numbers ) {
         if( x == 30 ) {
	      continue;    // если поставить break; на 30 закончится программа. результат будет 10 и 20 только
         }
         System.out.print( x );
         System.out.print("\n");
      }
   }
}

---------------------------------------------------------------------------------------------------------------------- 

public class Test {

   public static void main(String args[]){
      char grade = 'C';

      switch(grade)
      {
         case 'A' :
            System.out.println("Отлично!"); 
            break;
         case 'B' :
         case 'C' :
            System.out.println("Отлично выполнено");
            break;
         case 'D' :
            System.out.println("Вы прошли");
         case 'F' :
            System.out.println("Лучше попробуйте снова");
            break;
         default :
            System.out.println("Неверная оценка");
      }
      System.out.println("Ваша оценка " + grade);
   }
}

---------------------------------------------------------------------------------------------------------------------- 

import java.util.Date;

public class Test {

    public static void main(String args[]) {
        Date date = new Date();

        System.out.println(date.toString());
    }
}

----------------------------------------------------------------------------------------------------------------------

import java.util.*;
import java.text.*;

public class Time {

    public static void main(String args[]) {
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("E yyyy.MM.dd 'и время' hh:mm:ss a zzz");

        System.out.println("Текущая дата " + formatForDateNow.format(dateNow));
    }
}

//        G	Обозначение эры             	н.э.
//        y	Год из четырех цифр             2016
//        M	Номер месяца года	            11
//        d	Число месяца	                13
//        h	Формат часа в A.M./P.M.(1~12)	7
//        H	Формат часа(0~23)	            19
//        m	Минуты	                        30
//        s	Секунды	                        45
//        S	Миллисекунды	                511
//        E	День недели	                    Вс
//        D	Номер дня в году	            318
//        F	Номер дня недели в месяце	    2 (второе воскресение в этом месяце)
//        w	Номер неделя в году	            46
//        W	Номер недели в месяце	        2
//        a	Маркер A.M./P.M.	            AM
//        k	Формат часа(1~24)	            24
//        K	Формат часа в A.M./P.M.(0~11)	0
//        z	Часовой пояс	                FET (Дальневосточноевропейское время)
//        '	Выделение для текста	        Текст
//        ''	Одинарная кавычка	        '

----------------------------------------------------------------------------------------------------------------------

public class Test {

    public static void main(String args[]) {
        System.out.println("prog\tlang.su --> \\t - табуляция");
        System.out.println("prog\blang.su --> \\b - возврат на один шаг назад");
        System.out.println("prog\nlang.su --> \\n - новая строка");
        System.out.println("prog\rlang.su --> \\r - возврат каретки");
        System.out.println("prog\flang.su --> \\f - прогон страницы");
        System.out.println("prog\'lang.su --> \\' - одинарная кавычка");
        System.out.println("prog\"lang.su --> \\\" - двойная кавычка");
        System.out.println("prog\\lang.su --> \\\\ - обратная косая черта");
    }
}


----------------------------------------------------------------------------------------------------------------------

public class Test {

   public static void main(String args[]){
      char[] helloArray = { 'П', 'р', 'и', 'в', 'е', 'т', '.'};
      String helloString = new String(helloArray);  
      System.out.println(helloString);
   }
}

----------------------------------------------------------------------------------------------------------------------


public class Test {

   public static void main(String args[]) {
      String s = "Я стану отличным программистом!";
      int len = s.length();
      
      System.out.println( "Длина строки: " + len + " символ.");
   }
}


----------------------------------------------------------------------------------------------------------------------

public class Test {

    public static void main(String args[]) {
        String s = "1234567890";
        System.out.println(s.charAt(4));
    }
}

----------------------------------------------------------------------------------------------------------------------

public class ExampleMinNumber {
   
   public static void main(String[] args) {
      int a = 11;
      int b = 6;
      int c = minFunction(a, b);
      System.out.println("Минимальное значение = " + c);
   }

   /* Возвращает минимум из двух чисел */
   public static int minFunction(int n1, int n2) {
      int min;
      if (n1 > n2)
         min = n2;
      else
         min = n1;

      return min; 
   }
}


----------------------------------------------------------------------------------------------------------------------

public class swappingExample {

   public static void main(String[] args) {
      int a = 30;
      int b = 45;
      System.out.println("Перед тем как передать, значения аргументов a = " + a + " и b = " + b);

      // Вызов метода передачи
      swapFunction(a, b);
      System.out.println("\nСейчас, до и после передачи значения аргументов ");
      System.out.println("остались неизменными, a = " + a + " и b = " + b);
   }

   public static void swapFunction(int a, int b) {
      System.out.println("До замены: a = " + a + " b = " + b);
      
      // Передача параметров
      int c = a;
      a = b;
      b = c;
      System.out.println("После замены: a = " + a + " b = " + b);
   }
}


----------------------------------------------------------------------------------------------------------------------

public class ExampleOverloading {

   public static void main(String[] args) {
      int a = 7;
      int b = 3;
      double c = 5.1;
      double d = 7.2;
      int result1 = minFunction(a, b);
      
      // такая же функция с другими параметрами
      double result2 = minFunction(c, d);
      System.out.println("Минимальное значение = " + result1);
      System.out.println("Минимальное значение = " + result2);
   }

   // для integer
   public static int minFunction(int n1, int n2) {
      int min;
      if (n1 > n2)
         min = n2;
      else
         min = n1;

      return min; 
   }
   
   // для double
   public static double minFunction(double n1, double n2) {
     double min;
      if (n1 > n2)
         min = n2;
      else
         min = n1;

      return min; 
   }
}


----------------------------------------------------------------------------------------------------------------------

class MyClass {
    int x;


    MyClass() {
        x = 10;
    }
}

public class ConsDemo {

    public static void main(String args[]) {
        MyClass t1 = new MyClass();
        MyClass t2 = new MyClass();
        System.out.println(t1.x + " " + t2.x);
    }
}
----------------------------------------------------------------------------------------------------------------------
class MyClass {
    int x;

   MyClass(int i) {
      x = i;
   }
}

public class ConsDemo {

   public static void main(String args[]) {
      MyClass t1 = new MyClass( 10 );
      MyClass t2 = new MyClass( 20 );
      System.out.println(t1.x + " " + t2.x);
   }
}
----------------------------------------------------------------------------------------------------------------------

public class VarargsDemo {

   public static void main(String args[]) {
      // Вызов метода с переменной args  
      printMax(27, 11, 11, 5, 77.1);
      printMax(new double[]{10, 11, 12, 77, 71});
   }

   public static void printMax(double... numbers) {
      if (numbers.length == 0) {
         System.out.println("Ни один аргумент не передается");
         return;
      }

      double result = numbers[0];

      for (int i = 1; i <  numbers.length; i++)
      if (numbers[i] >  result)
      result = numbers[i];
      System.out.println("Максимальное значение " + result);
   }
}

----------------------------------------------------------------------------------------------------------------------

class Animal {
}

class Mammal extends Animal {
}

class Reptile extends Animal {
}

public class Dog extends Mammal {

   public static void main(String args[]) {
      Animal a = new Animal();
      Mammal m = new Mammal();
      Dog d = new Dog();

      System.out.println(m instanceof Animal);
      System.out.println(d instanceof Mammal);
      System.out.println(d instanceof Animal);
   }
}


----------------------------------------------------------------------------------------------------------------------

interface Animal{}
class Mammal implements Animal{}

public class Dog extends Mammal {

   public static void main(String args[]) {
      Mammal m = new Mammal();
      Dog d = new Dog();

      System.out.println(m instanceof Animal);
      System.out.println(d instanceof Mammal);
      System.out.println(d instanceof Animal);
   }
}


----------------------------------------------------------------------------------------------------------------------

public class TestArray {

   public static void main(String[] args) {
      double[] myList = {1.9, 2.9, 3.4, 3.5};

      // Вывести на экран все элементы массива
      for (int i = 0; i < myList.length; i++) {
         System.out.println(myList[i] + " ");
      }
      // Сумма элементов массива
      double total = 0;
      for (int i = 0; i < myList.length; i++) {
         total += myList[i];
      }
      System.out.println("Сумма чисел массива: " + total);
      // Нахождение среди элементов массива наибольшего
      double max = myList[0];
      for (int i = 1; i < myList.length; i++) {
         if (myList[i] > max) max = myList[i];
      }
      System.out.println("Наибольший элемент: " + max);
   }
}


----------------------------------------------------------------------------------------------------------------------

public class TestArray {

   public static void main(String[] args) {
      double[] myList = {1.9, 2.9, 3.4, 3.5};

      // Вывести массив на экран
      for (double element: myList) {
         System.out.println(element);
      }
   }
}


----------------------------------------------------------------------------------------------------------------------


public class Test {

    public static void main(String args[]) {
        // Вызов метода с переменной args
        printMax(27, 11, 11, 5, 77.1);
        printMax(new double[]{10, 11, 12, 77, 71});
    }

    public static void printMax(double... numbers) {
        if (numbers.length == 0) {
            System.out.println("Ни один аргумент не передается");
            return;
        }

        double result = numbers[0];

        for (int i = 1; i <  numbers.length; i++)
            if (numbers[i] >  result)
                result = numbers[i];
        System.out.println("Максимальное значение " + result);
    }
}


----------------------------------------------------------------------------------------------------------------------

String s = "Ах ты бяка";
String s2 = s.replaceAll("бяка", "вырезано цензурой");
System.out.println(s2);


----------------------------------------------------------------------------------------------------------------------

package com.company;

import java.util.*;

public class MyProject {

    public static void main(String[] args) {
        System.out.println("Input String:");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();


        Scanner scan = new Scanner(input);
        scan.useDelimiter("/");

        System.out.println("The delimiter use is "+scan.delimiter());

        while(scan.hasNext()){
            System.out.println(scan.next());
        }

        scan.close();

    }

}

----------------------------------------------------------------------------------------------------------------------
package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int x = 0;
        //Ввод
        System.out.print("Введите целое число: ");
        if (sc.hasNextInt()) {
            x = sc.nextInt();
        } else {
            System.out.println("Это не целое число!");
            return;
        }

        int[] digits = numberToArray(x);

        for (int line = 0; line < 7; line++) {
            for (int j = 0; j < digits.length; j++) {
                System.out.print(view[line][digits[j]]);
            }
            System.out.println();
        }
    }

    private static int[] numberToArray(int x) {
        //Решение
        char[] array1 = Integer.toString(x).toCharArray();
        int[] array2 = new int[array1.length];
        for (int i = 0; i < array1.length; i++) {
            array2[i] = Character.getNumericValue(array1[i]);
        }
        return array2;
    }

    private static final String[][] view = {

     {"  ***  ", "   *   ", "  ***  ", "  ***  ", "    *  ", " ***** ", "  ***  ", " ***** ", "  ***  ", "  ***  "},
     {" *   * ", "  **   ", " *   * ", " *   * ", "   **  ", " *     ", " *   * ", "     * ", " *   * ", " *   * "},
     {"*     *", " * *   ", " *   * ", "     * ", "  * *  ", " *     ", " *     ", "    *  ", " *   * ", " *   * "},
     {"*     *", "   *   ", "    *  ", "  ***  ", " *  *  ", " ****  ", " ****  ", "   *   ", "  ***  ", "  ***  "},
     {"*     *", "   *   ", "   *   ", "     * ", " ***** ", "     * ", " *   * ", "  *    ", " *   * ", "     * "},
     {" *   * ", "   *   ", "  *    ", " *   * ", "    *  ", " *   * ", " *   * ", "  *    ", " *   * ", "     * "},
     {"  ***  ", " ***** ", " ***** ", "  ***  ", "    *  ", "  ***  ", "  ***  ", "  *    ", "  ***  ", "  ***  "}};
}

----------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------

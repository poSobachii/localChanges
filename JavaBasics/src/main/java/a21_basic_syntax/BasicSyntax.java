package a21_basic_syntax;

import java.util.Arrays;
import java.util.List;

public class BasicSyntax {
    static String fieldVar1 = " #some GLOBAL string#";            // глобальная переменная или же филд(field) обьявляется в классе, вне методов
    static String fieldVar2;                                                         // глобальныя переменная без значения

    public static void main(String[] args) {
        declareVariables();
//        variableCasting();
//        arrays();
//        multidimensialArrays();
//        arrayManipulation();
//        assignStrings();
//        stringManipulation();
//        stringConversion();
//        whatisMuttable();           // stringBuilder example
//        arithmeticOperators();
//        relationalOperators();
//        logicalOperators();
//        ifElseThenStatement();
//        switchStatement();
//        doWhileStatement();


    }

    static void declareVariables() {
        String localVar1 = "#some local variable#";       // локальные переменные которые могут использоваться только в данном методе обьявлены в самом методе.
        int localvar2 = 5;                                                 // приравнивать значение к переменным можно сразу можно и позже, если нету модификатора final
        int localvar3;                                                      // в данном случае мы только обьявили нашу переменную, не дав ей значение
        long localvar4 = 10L;                                           // в некоторых случаях при привязке значений к примитивам следует добавлять окончания. подробней в таблице в презентации.
        System.out.println("данный метод может использовать как локальные переменные : " + localVar1);
        System.out.println("так и глобальные: " + fieldVar1);
        System.out.println("\nесли мы попытаемся использовать филд fieldVar2 , которая была обьявленна но не было присвоенно значение получаем: " + fieldVar2);
        fieldVar2 = "#some text assigned to global var#";
        System.out.println("в предыдушей строчке мы приравняли к переменной новое значение и получили: " + fieldVar2);
    }

    static void variableCasting() {
        byte byt = 50;
        int int1 = byt;                  // при приравнивании значения низжего порядке к вышему(implicit casting), ничего дополнительно указывать не следует
        System.out.println("у нас был байт со значением: " + byt);
        System.out.println("мы создали инт и прировняли к нему значение байта и получили: " + int1);
        System.out.println("разница между значениям нет, однако они лежат в разных типах переменных о чем нужно помнить");

        long long1 = 100;
        int int2 = (int) long1;             //  при приравнивании значения высшего к низжему(explicit casting), следует дополнительно определить класс в который нужно приравнять
        System.out.println("\nу нас был лонг: " + long1 + ", мы создали инт и прировняли к нему лонг и получили тоже самое значение: " + int2);
        System.out.println("как и в предыдущем примере разгницы между значениями нет, только в типах переменных в которых они лежат");
    }

    static void arrays() {
         /* при инициализации массива -
        левая часть состоит из типа переменных из которых наш массив будет состоять, квадратных скобок []
        определяюших что это будет массив, и названия переменной массив
        правая часть определяет как будет создан наш массив. размер массива определяется при его инициализации !!!
        new int[n] где n определяет размер нашего массива, будет создаен массив с дэфолтными значениями типа
        {} фигурные скобки со значениями внутри сразу определяют размер массива и приравнивают ему эти значения
        индексы в массивах отсчитываются с 0 */
        String[] stringArray1 = new String[3];                            // массив объявленый только по размеру
        String[] stringArray2 = {"Dog", "Cat", "Bird"};               // массив обьявленный сразу со значениями
        System.out.println("распечатаем наш первый массив стрингов " + Arrays.toString(stringArray1));
        System.out.println("мы получили 3 null values, потому что массив был инциализирован, но не присвоенны значения.");
        System.out.println("в отличии от второго массива, в котором мы сразу присваивали значения " + Arrays.toString(stringArray2));
        int[] intArray1 = new int[6];
        int[] intArray2 = {2, 3, 4, 5, 6, 7};
        System.out.println("\nвозьмем наши массивы интегеров 1: " + Arrays.toString(intArray1) + ", \nи 2: " + Arrays.toString(intArray2));
        System.out.println("по аналогии со стрингами, мы имеем два одинаковых по размеру массива, с и без присвоенных значений");
        Arrays.fill(intArray1, 10);
        System.out.println("присвоем первому массиву одно значение во все индексы командой .fill и получаем: " + Arrays.toString(intArray1));
        intArray1[3] = 34;
        System.out.println("мы так же можем присвоить значение кокретному индексу: " + Arrays.toString(intArray1));
    }

    static void multidimensialArrays() {
        int[][] intMultidimensialArray = {          // мы можем обьвлять массивы с несколькими массивами внутри.
                {1, 2, 3},                                         //   на данном примере у нас есть 2 массива в каждом из которых находятся еще по массиву с размером 3
                {4, 5, 6}
        };
        // при вытаскивании значений из мультидименсионных массивов следует указать сначала из какого массива мы хотим достать значение, затем индекс желаемого значения
        System.out.println("пожалуйста выдай нам 3 значение из первого массива: " + intMultidimensialArray[0][2]);
        System.out.println("пожалуйста выдай нам 2 значение из второго массива: " + intMultidimensialArray[1][1]);
    }

    static void arrayManipulation() {
        // создадим 3 массива интов и сравним их
        int[] intArray1 = {1, 2, 3};
        int[] intArray2 = {1, 2, 3};
        int[] intArray3 = {3, 2, 1};
        System.out.println("Равен ли массив1 и массив 2 ?: " + Arrays.equals(intArray1, intArray2));
        System.out.println("Равен ли массив1 и массив 3 ?: " + Arrays.equals(intArray1, intArray3));

        char[] charArray1 = {'d', 'e', 'j', 'a', 'v', 'a', 'e', 'i', 'n', 'a', 't', 'e', 'd'};        // возьмем массив из чаров(символов)
        char[] charArray2 = new char[7];                                                                                // создадим пустой массив размера в 7 символов
        System.arraycopy(charArray1, 2, charArray2, 0, 4);           // скопируем символы с 2ого индекса на позицию начиная с 0 индекса  и длиной в 4 единицы.
        System.out.println("\nПосле копирования с предыдущими параметрами мы получаем результат: " + Arrays.toString(charArray2));
        System.out.println("В результате видно что мы скопировали символы java и в конце получили \u0000, " +
                "\nт.к. размер нашего массива был изначально 7 единиц а мы скопировали и вставили значения тольк в первые 4 индекса ");

        int[] intArray4 = {7, 4, 9, 1, 2, 8};
        int[] intArray5 = new int[6];
        System.out.println("\nВозьмем два массива со значениями: " + Arrays.toString(intArray4) + ", и без: " + Arrays.toString(intArray5) + " и сделаем им команду .fill");
        Arrays.fill(intArray4, 10);
        Arrays.fill(intArray5, 10);
        System.out.println("Как видите команда .fill перезаписывает все значения в обоих случаях: " + Arrays.toString(intArray4) + ", и: " + Arrays.toString(intArray5));

        int[] intArray6 = {7, 4, 9, 1, 2, 8};
        System.out.println("\nСоздаем массив чисел: " + Arrays.toString(intArray6));
        Arrays.sort(intArray6);
        System.out.println("И делаем ему .sort: " + Arrays.toString(intArray6));

        String[] stringArray1 = {"Bob", "Michael", "Jack"};                                  //  у нас есть массив из стрингов
        List<String> stringList1 = Arrays.asList(stringArray1);                              // создаем лист имен и копируем его из массива
        System.out.println("\nЗначения остались те же самые, только теперь они лежат в разных типах данных, был массив: " + stringArray1[2]
                + " а стал ArrayList: " + stringList1.get(2));

        int[] intArray7 = {12, 13, 14, 15, 16, 17, 18};                                                          // другой способ скопировать массив командой .copyOf. возьмем массив с 3 элементами
        int[] intArray8 = Arrays.copyOf(intArray7, 9);                    // создадим другой массив присвоим ему копию первого и длину уже в 5 единиц.
        System.out.println("\nКак можете видеть copyOf вставил значения с первого массива во второй по порядку с 0 индекса " +
                "т.к. новый массив был на 2 единицы больше получаем дэфолтные значения - 0 в случае интеджеров " + Arrays.toString(intArray8));

        int[] intArray9 = Arrays.copyOfRange(intArray7, 2, 4);
        System.out.println("\nКомандой copyOfRange можно указать с какого по какой индексы только копировать так что получаем: " + Arrays.toString(intArray9));
    }

    static void assignStrings() {
        String string1 = "Hello!";
        char[] charArray1 = {'H', 'e', 'l', 'l', 'o', '!'};
        String string2 = new String(charArray1);                                // создали другую стрингу из массива символов
        System.out.println("равняется ли стринг1 и стринг2 ?: " + string1.equals(string2));
        String string3 = string1 + " world!";
        System.out.println("в стрингах можно складывать все что угодно и простейшими способами: " + string3);
    }

    static void stringManipulation() {
        String string1 = "      Hello!";
        String string2 = "      Hello!";
        System.out.println("Командой .length мы можем узнать длину стринги string1: " + string1.length());
        System.out.println("Сравниваем командой .equals первую и вторую стрингу: " + string1.equals(string2));
        System.out.println("Командой .trim мы убираем ненужные пробелы вначале стринги: " + string1.trim());

        String string3 = "quick brown fox jumps over the lazy dog";
        System.out.println("\nSubstring starting from index 15:");
        System.out.println(".substring \"режет\" стрингу до определенного индекса: " + string3.substring(15));
        System.out.println("или до и после определенных индексов: " + string3.substring(15));

        System.out.println("\n.indexOf найдет нам в стринге ближайший индекс запрашиваемого символа: " + string3.indexOf("i"));

        String string4 = "i've@become@so numb@i can@feel@you there";
        String[] stringArray1 = string4.split("@", 3);
        System.out.println("\n.split команда разрежет стрингу по определеннуму элементу и скопирует это в массив с указанной длинной,в данном случаем массив из 3 строк: ");
        for (String x : stringArray1) {
            System.out.println(x);
        }

        String string5 = "Hello world";
        String string6 = string5.replaceAll("world", "hell");
        System.out.println("\n.replaceAll команда заменит все заданные совпадения не требуемые. Была строка: " + string5 + " , стало: " + string6);
    }

    static void stringConversion() {
        int int1 = 1;
        double double1 = 1.1;
        String stringFromInt = String.valueOf(int1);
        String stringFromDouble = String.valueOf(double1);
        System.out.println("командой String.valueOf можно конверить любой тип в стрингу: " + stringFromInt + ", " + stringFromDouble);
        System.out.println("в данном случае числа уже являются текстом.");

        String longString = "10";
        String doubleString = "1.1";
        System.out.println("\nв обратном порядке же(текст в число) следует соблюдать формулу Type.parseType(string)");
        System.out.println("где мы вызываем класс желаемого типа и метод .parse");
        int newInt1 = Integer.parseInt(longString);
        double newDouble1 = Double.parseDouble(doubleString);
        System.out.println("теперь " + newInt1 + " и " + newDouble1 + " являются числом и дробью, а не текстом");
    }

    static void arithmeticOperators() {
        /*
                       + ( Addition ) Adds values on either side of the operator
                       - ( Subtraction ) Subtracts right hand operand from left hand operand
                       * ( Multiplication ) Multiplies values on either side of the operator
                       / (Division) Divides left hand operand by right hand operand
                      % (Modulus) Divides left hand operand by right hand operand and returns remainder
                      ++ (Increment) Increases the value of operand by 1
                      -- ( Decrement ) Decreases the value of operand by 1
        */
    }

    static void relationalOperators() {
        /*
                == (equal to) Checks if the values of two operands are equal or not, if yes then condition becomes true.
                != (not equal to) Checks if the values of two operands are equal or not, if values are not equal then condition becomes true.
                > (greater than) Checks if the value of left operand is greater than the value of right operand, if yes then condition becomes true.
                < (less than) Checks if the value of left operand is less than the value of right operand, if yes then condition becomes true.
                >= (greater than or equal to) Checks if the value of left operand is greater than or equal to the value of right operand, if yes then condition becomes true.
                <= (less than or equal to) Checks if the value of left operand is less than or equal to the value of right operand, if yes then condition becomes true.
       */
    }

    static void logicalOperators() {
        /*
                   && (logical and) Called Logical AND operator. If both the operands are non-zero, then the condition becomes true.
                   || (logical or) Called Logical OR Operator. If any of the two operands are non-zero, then the condition becomes true.
                    ! (logical not) Called Logical NOT Operator. Use to reverses the logical state of its operand. If a condition is true then Logical NOT operator will make false.
       */
    }

    static void ifElseThenStatement() {
        boolean boolean1 = true;
        boolean boolean2 = false;
        if (boolean1) {
            System.out.println("1) т.к. результат логического выражения true, мы зашли в if метод и распечатали эту строчку \n");
        }
        if (boolean2) {
            System.out.println("будет что то ?");
        } else {
            System.out.println("2) оператор else сработал т.к. логическое выражение было false \n");
        }

        if (boolean2) {
            System.out.println("условие true, if сработал");
        } else if (boolean1) {
            System.out.println("3) т.к. результат true сюда сработал else if");
        }

        // ternary operators позволяет  сократит количества объема кода
        //  следующее выражение
        if(boolean1){
            System.out.println("Hello If");
        } else  {
            System.out.println("Hello else");
        }

        // с помощью ternary operators
        System.out.println(boolean1 ? "Hello if" : "Hello else");
    }

    static void switchStatement() {
        int expression = 2;
        switch (expression) {
            case 1: System.out.println("case 1 сработал");
            case 2: System.out.println("case 2 сработал");
            case 3: System.out.println("case 3 сработал");
                break;                              // не забываем ставить break после каждого case
            default: System.out.println("дэфолт сработал");
        }
        System.out.println("сработал case 2 и case 3 т.к. после того как программа выполнила case 2 не было стоял break, и программа стала читать код дальше \n");

        int expression2 = 6;
        switch (expression2) {
            case 1: System.out.println("case 1 сработал");
            case 2: System.out.println("case 2 сработал");
            case 3: System.out.println("case 3 сработал"); break;
            default: System.out.println("т.k. мы подали необрабатываемый case, сработал дэфолт метод");
        }
    }

    static void doWhileStatement() {
        int count = 1;
        do {
            System.out.println("печатаем эту строчку пока while условие true");
            count++;
        } while (count < 10);
       /* цикл будет продолжаться пока while() = true. в данном случае мы заходим в метод, печатаем строчку, добавляем к count единицу, затем смотрим условие while.
        поэтому мы распечатали 9 раз строчку, начиная count с единицы и на 10 цикле , 10 != 10 сработало , поэтому  while луп закончился
        statament
                        while(count<10){
                       } do {
                       }
         работает так же, только условие смотрится сначала а не в конце
        .*/
    }

    static void whatisMuttable() {
            // главные не примитинвые классы - > array, class, interface, String
            //  чем отличается String mutable от примитивных данных типа int ?
        int int1  = 10;
        System.out.println("Возьмем инт и привяжем к нему значение: " + int1);
        int1 +=15;
        System.out.println("выражением x=x+15 мы можем сложить текущий инт + 15 и вложить сумму в тот же самый исходную переменную: " + int1 );
        String string1 = "hello";
        string1.concat(" world");
        System.out.println(string1);
    }

    //TODO написать как методы передают и возвращают значения

}

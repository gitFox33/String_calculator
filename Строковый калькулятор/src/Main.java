import javax.swing.*;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Введите выражение:");
        Scanner scan = new Scanner(System.in);
        String enter = scan.nextLine();
        String exp =  enter.replace("\"", "");
        calculator(exp);
    }

    public static void calculator(String input) throws Exception {

        //ОПРЕДЕЛЯЮ ДЕЙСТВИЕ И ДЕЛЮ ПО ЭТОМУ ДЕЙСТВИЮ

        char operand;
        String[] s;
        int c;
        if (input.contains("+")) {

            s = input.split(" \\+ ");
            operand = '+';
            //checkVariable(s[0], s[1]);
            plus(s[0], s[1]);

        } else if (input.contains("-")) {
            s = input.split(" - ");
            operand = '-';
            checkVariable(s[0], s[1]);
            minus(s[0], s[1]);

        } else if (input.contains("/")) {
            s = input.split(" / ");
            operand = '/';
            checkVariable(s[0], s[1]);
            delenie(s[0], s[1]);

        } else if (input.contains("*")) {
            s = input.split(" \\* ");
            operand = '*';
            checkVariable(s[0], s[1]);
            umnojenie(s[0], s[1]);
        } else {
            throw new Exception("Некорректное выражение");
        }
    }

    //МЕТОД "МИНУС"
    public static void minus(String first, String last) {
        int index;
        index = first.indexOf(last);
        if (index >= 0) {
            String one = first.substring(0, index);
            String two = first.substring(index + last.length());
            String result = one + two;
            print(result);
        } else {
            print(first);
        }
    }

    //МЕТОД "ПЛЮС"
    public static void plus(String first, String last) {
        String result = first + last;
        print(result);

    }

    //МЕТОД "ДЕЛЕНИЕ"
    public static void delenie(String first, String last) throws Exception {
        int x = first.length();
        int y = Integer.parseInt(last);
        if (y > 10 || y < 1) {                                             //ПРОВЕРКА ВТОРОГО ЧИСЛА
            throw new Exception("Числа от 1 до 10");
        } else {
            int z = x / y;
            String result = first.substring(0, z);
            print(result);
        }
    }

    //МЕТОД "УМНОЖЕНИЕ"
    public static void umnojenie(String first, String last) throws Exception {
        String result = "";
        int count = Integer.parseInt(last);
        if (count > 10 || count < 1) {                                    //ПРОВЕРКА ВТОРОГО ЧИСЛА
            throw new Exception("Числа от 1 до 10");
        } else {
            for (int i = 1; i <= count; i++) {
                result += first;
            }
        }
        print(result);
    }

    public static void print(String output) {                           //ПЕЧАТАЮ В КОВЫЧКАХ И С ТОЧКАМИ
        if (output.length() > 40) {
            String printL = output.substring(0,40);
            System.out.println('"'+printL + "..."+'"');
        } else {
            System.out.println('"' + output + '"');
        }
    }

    public static void checkVariable(String first, String last) throws Exception {
        try {
            if (Integer.parseInt(first) >= Integer.MIN_VALUE) {
                throw new Exception("Первая переменная должна быть строкой");
            }
        } catch (NumberFormatException e) {
            if (first.length() > 10 || last.length() > 10) {                 //ПРОВЕРЯЮ РАЗМЕР "СЛОВ"
                throw new Exception("Слова не более 10 знаков.");
            }
        }
    }
}







package gbExceptionHomeWork.homeWork_1.task1;

class Answer {
    public static void arrayOutOfBoundsException() {
        int[] arr = new int[]{3, 5, 4, 8, 10};
        System.out.println(arr[5]);

    }

    public static void divisionByZero() {
        int a = 5;
        int b = 0;
        int res = a / b;

    }

    public static void numberFormatException() {
        String str = new String("abc");
        int a = Integer.parseInt(str);

    }
}

public class Printer {
    public static void main(String[] args) {
        Answer ans = new Answer();
        try {
            ans.arrayOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Выход за пределы массива");
        }

        try {
            ans.divisionByZero();
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль");
        }

        try {
            ans.numberFormatException();
        } catch (NumberFormatException e) {
            System.out.println("Ошибка преобразования строки в число");
        }
    }
}
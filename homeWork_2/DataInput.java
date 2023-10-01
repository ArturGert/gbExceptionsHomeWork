package gbExceptionHomeWork.homeWork_2;
import java.util.Scanner;
/* Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), и возвращает введенное
 значение. Ввод текста вместо числа не должно приводить к падению приложения, вместо этого, необходимо повторно
 запросить у пользователя ввод данных.*/

public class DataInput {
    // Метод, который принимает на вход данные, проверяет на число: если введено число, то возвращает его, если нет
    // рекурсивно производит повтор ввода, до тех пор, пока не будет введено число.
    public static float processingOfData() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите число :");
        if (scan.hasNextFloat()) {
            float num = scan.nextFloat();
            return num;
        } else {
            System.out.println("Некорректное значение!");
            return processingOfData(); // рекурсивно запускаем метод
        }
    }
    public static void main(String[] args) {
        System.out.println("Вы ввели число: " + processingOfData() + ".");
    }
}

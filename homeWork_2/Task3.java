package gbExceptionHomeWork.homeWork_2;

public class Task3 {
    public static void main(String[] args) { // в данном конкретном случае нет необходимости передавать исключения выше "throws Exception" удалено из сигнатуры метода
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 5);
            int[] abc = {1, 2};
            abc[3] = 9;
//        } catch (Throwable ex) {
//            System.out.println("Что-то пошло не так..."); удален данный блок, ввиду отсутствия необходимости (ниже обработаны возможные исключения).
        } catch (ArithmeticException ex) {
            System.out.println("Делить на ноль недопустимо!"); // учитывая присутствие операции деления, необходимо обработать деление на ноль - добавлен данный блок catch
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        }
    }

    public static void printSum(Integer a, Integer b) { // внутри метода нет кода, который может вызвать исключение "throws FileNotFoundException" - удалено
        System.out.println(a + b);
    }
}

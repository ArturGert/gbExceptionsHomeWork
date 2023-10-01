package gbExceptionHomeWork.homeWork_2;

public class task2 {
    public static void main(String[] args){
        // Исключение
        try {
            int [] intArray  = new int[5];
            int d = 0;
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) { // исключение при делении на ноль (int d = 0)
            System.out.println("Catching exception: " + e);
        } catch (ArrayIndexOutOfBoundsException e) { // исключение при выходе за пределы массива (intArray[8])
            System.out.println("Catching exception: " + e);
        }
    }
}

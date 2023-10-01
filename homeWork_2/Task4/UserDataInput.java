package gbExceptionHomeWork.homeWork_2.Task4;
/*
Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
*/

import java.util.Scanner;

public class UserDataInput {
    public static String getInputData() {
        System.out.println("Введите строку: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static void checkEmptyInput(String inputData) throws  EmptyInputException{
        String trimmedinputData = inputData.trim();
        if (trimmedinputData.isEmpty()){
            throw new EmptyInputException();
        }
        System.out.println("Введена строка: " + inputData);
    }

    public static void main(String[] args)  {
        try {
            String userInput = getInputData();
            checkEmptyInput(userInput);;
        } catch (EmptyInputException e) {
            System.out.println(e.getMessage());;
        }
    }
}

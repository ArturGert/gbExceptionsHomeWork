package gbExceptionHomeWork.homeWork_2.Task4;

public class EmptyInputException extends Exception {
    public EmptyInputException() {
        super("Введена пустая строка!");
    }

    public EmptyInputException(String message) {
        super(message);
    }
}

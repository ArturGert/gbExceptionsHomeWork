package gbExceptionHomeWork.homeWork_3;

public class EmptyInputException extends Exception {
    public EmptyInputException() {
        super("Некорректный ввод данных! Необходимо ввести следующие данные: Фамилия Имя Отчество датарождения номертелефона пол");
    }
    public EmptyInputException(String message) {
        super(message);
    }
}

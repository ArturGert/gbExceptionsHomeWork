package gbExceptionHomeWork.homeWork_3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
Напишите приложение, которое будет запрашивать у пользователя следующие данные, разделенные пробелом:
Фамилия Имя Отчество датарождения номертелефона пол
Форматы данных(Для упрощения, можете все делать String):
фамилия, имя, отчество - строки
датарождения - строка формата dd.mm.yyyy
номертелефона - целое беззнаковое число без форматирования
пол - символ латиницей f или m.
Приложение должно проверить введенные данные по количеству. Если количество не совпадает с требуемым, вернуть код
ошибки, обработать его и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.
Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры. Если форматы данных
не совпадают, нужно бросить исключение, соответствующее типу проблемы. Можно использовать встроенные типы java и создать
свои. Исключение должно быть корректно обработано, пользователю выведено сообщение с информацией, что именно неверно.
Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, в него в одну строку должны з
аписаться полученные данные, вида
<Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>
Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
Не забудьте закрыть соединение с файлом.
При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано, пользователь
должен увидеть стектрейс ошибки.
 */

public class WriteFileFromUserDataInput {

    public static String[] getUserData(Scanner scanner) throws EmptyInputException {
        boolean flag = false; // условие для выхода из цикла
        String[] userData = null;
        while (!flag) {
            System.out.println("Введите Ваши данные: Фамилия Имя Отчество датарождения номертелефона пол: ");
            String inputData = scanner.nextLine();
            userData = inputData.split(" ");
                if (userData.length != 6) {
                    System.out.println("Некорректный ввод данных!");
                    continue;
            }
            String lastName = userData[0];
            String firstName = userData[1];
            String middleName = userData[2];
            String birthDateInput = userData[3];
            String phoneNumberInput = userData[4];
            String genderInput = userData[5];
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
                Date birthDate = dateFormat.parse(birthDateInput);
                long phoneNumber = Long.parseLong(phoneNumberInput);
                if (!(genderInput.equals("f") || genderInput.equals("m"))) {
                    throw new IllegalArgumentException("Ошибка: Неверный формат пола! Укажите  <f> или <m>. Повторите ввод!");
                }
                flag = true; // при корректном вводе цикл завершится и вернет нужный массив
            } catch (ParseException e) {
                System.out.println("Неверный формат даты рождения! Дата должна быть записана в формате <дд.мм.гггг>!  Повторите ввод!");
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат номера телефона. Повторите ввод!");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } return userData;
    }
// метод записывающий файл по введенным данным
    public static void getFile(String[] userData) throws EmptyInputException {
        String fileName = userData[0] + ".txt"; // имя файла
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) { // создание объекта BufferedWriter с использованием try с ресурсами (try-with-resources)
            writer.write(String.join(" ", userData)); // запись данных
            writer.newLine(); // переход на новую строку
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Основной метод
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            String[] userData = getUserData(scanner);
            getFile(userData);
            System.out.println("Данные успешно записаны в файл " + userData[0] + ".txt");
        } catch (EmptyInputException e) {
            throw new RuntimeException(e);
        }
    }
}





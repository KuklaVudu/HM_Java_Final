import java.util.Scanner;

public class InputData {
    public static void EntryData() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите данные через пробел: Фамилия Имя Отчество дата рождения номер телефона пол");
            System.out.println("Для выхода введите exit");
            boolean run = true;
            while (run) {
                String[] strings = scanner.nextLine().split(" ");
                if (strings[0].equalsIgnoreCase("exit")) {
                    break;  
                }
                HandlerError.EnteredData(strings);
            }
        }
    }
}

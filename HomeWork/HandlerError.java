import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class HandlerError {
    public static void EnteredData(String[] userData) {
        int count = 0;
        if (userData.length != 6) {
            System.out.println("Введено неверное количество данных");
            count++;
        } else {
            if (!userData[0].matches("[а-яА-Яa-zA-Z]+")) {
                System.out.println("Фамилия введена не верно");
                count++;
            }
            if (!userData[1].matches("[а-яА-Яa-zA-Z]+")) {
                System.out.println("Имя введено не верно");
                count++;
            }
            if (!userData[2].matches("[а-яА-Яa-zA-Z]+")) {
                System.out.println("Отчество введено не верно");
                count++;
            }
            DateFormat dataFormat = new SimpleDateFormat("dd.MM.yyyy");
            try {
                dataFormat.parse(userData[3]);
            } catch (ParseException e) {
                System.out.println("Неверный формат даты рождения");
                count++;
            }
            try {
                Long.parseLong(userData[4]);
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат телефона");
                count++;
            }
            if (!userData[5].equalsIgnoreCase("f") && !userData[5].equalsIgnoreCase("m")) {
                System.out.println("Неверный формат пола");
                count++;
            }
        }
        if (count == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < userData.length; i++) {
                if (i == userData.length - 1) {
                    stringBuilder.append(userData[i]);
                } else {
                    stringBuilder.append(userData[i]).append(" ");
                }
            }
            CreateFile.File(stringBuilder.toString(), userData[0]);
        }
    }
}

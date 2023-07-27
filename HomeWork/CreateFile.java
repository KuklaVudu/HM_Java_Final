import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CreateFile {
    public static void File(String text, String dataName) {
        boolean file = false;
        String string = "";
        if (Files.exists(Path.of(dataName + ".txt"))) {
            string = FileRecord(dataName);
            if (!string.contains(text)) {
                file = true;
                recordingFile(dataName, text, file);
                System.out.println("Данные добавлены");
            } else {
                System.out.println("Данные уже существуют");
            }
        } else {
            recordingFile(dataName, text, file);
            System.out.println("Файл " + dataName + ".txt создан");
        }
    }

    public static String FileRecord(String dataName) {
        try (FileReader read = new FileReader(dataName + ".txt")) {
            int CreateFile;
            StringBuilder stringBuilder = new StringBuilder();
            while ((CreateFile = read.read()) != -1) {
                stringBuilder.append((char) CreateFile);
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            throw new RuntimeException("Проблема с чтением - записью файла " + e);
        }
    }

    public static void recordingFile(String dataName, String text, boolean indicator) {
        try (FileWriter writer = new FileWriter(dataName + ".txt", indicator)) {
            writer.write(text + "\n");
        } catch (IOException e) {
            throw new RuntimeException("Ошибка записи файла" + e);
        }
    }
}
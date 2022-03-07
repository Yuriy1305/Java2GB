package HW5;
// 06/03/2022, Yuriy Lomtev
// 1. Реализовать сохранение данных в csv файл;
// 2. Реализовать загрузку данных из csv файла. Файл читается целиком.
//        Структура csv файла:
//        | Строка заголовок с набором столбцов |
//        | Набор строк с целочисленными значениями |
//        | * Разделитель между столбцами - символ точка с запятой (;) |
//        Пример:
//        Value 1;Value 2;Value 3
//        100;200;123
//        300,400,500
//        Для хранения данных использовать класс вида:
//    public class AppData {
//    private String[] header;
//    private int[][] data;
//     ... }
//    Если выполняется save(AppData data), то старые данные в файле полностью перезаписываются.

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;

public class MainInOutCVSFile {
    public static void main(String[] args) {
        String headerAndInt = "";
// готовим файл для записи и записываем в него приготовденное в AppData:
        try (FileOutputStream fileStream = new FileOutputStream("my csv file.csv")) {
            byte[] outPutData = AppData(headerAndInt).getBytes(StandardCharsets.UTF_8);
            fileStream.write(outPutData);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
// готовим файл для чтения
        try (FileInputStream fileStream = new FileInputStream("my csv file.csv")) {
            byte [] inputputData = new byte [fileStream.available()];
// читаем и выводим прочитанное:
            fileStream.read(inputputData);
            headerAndInt= new String(inputputData);
            System.out.println(headerAndInt);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static String AppData(String headerAndInt) {
// указана строка - не будем мучаться (save(AppData data)=перезапись автоматически применяется при изменении данных):
        headerAndInt = "Column 1;" + "Column 2;" + "Column 3;" + "\n";
// указан int - преобразуем в строки с переносом строки в конце:
        int[][] myInt = {{11, 12, 13}, {21, 22, 23}, {31, 32, 33}};
        for (int i = 0; i < myInt.length; i++) {
            for (int j = 0; j < myInt[1].length; j++) {
                headerAndInt += myInt[i][j] + ";";
            }
            headerAndInt += "\n";
        }
        return headerAndInt;
    }
}

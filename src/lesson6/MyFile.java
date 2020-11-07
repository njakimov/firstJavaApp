package lesson6;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Класс работы с файлами - читает, пишет, склеивает.
 */
public class MyFile {
    /**
     * Метод записи текста в файл
     *
     * @param nameFile - имя файла
     * @param textFile - содержимое файла
     * @return failRecord - наличие ошибки при записи файла
     */
    public static boolean printToFile(String nameFile, String textFile) {
        boolean failRecord = false;
        try {
            FileOutputStream fos = new FileOutputStream(nameFile);
            PrintStream ps = new PrintStream(fos);
            ps.println(textFile);
            fos.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            failRecord = true;
        }
        return failRecord;
    }

    /**
     * Метод чтения данных из файла
     *
     * @param nameFile - имя файла
     * @return StringBuffer - данные из файла
     */
    public static StringBuffer readFromFile(String nameFile) {
        StringBuffer s = new StringBuffer();

        try {
            FileInputStream fis = new FileInputStream(nameFile);
            InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);

            int i;
            while ((i = isr.read()) != -1) {
                s.append((char) i);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return s;
    }

    /**
     * Метод объединяющий данные из двух файлов и записывающих их в третий
     *
     * @param nameFile1 - имя первого файла - из которого читаем
     * @param nameFile2 - имя второго файла - из которого читаем
     * @param nameFile3 - имя третьего файла - в который пишем
     */
    public static void mergeFile(String nameFile1, String nameFile2, String nameFile3) {
        StringBuffer s;
        s = readFromFile(nameFile1);
        s.append(readFromFile(nameFile2));
        printToFile(nameFile3, s.toString());
    }
}

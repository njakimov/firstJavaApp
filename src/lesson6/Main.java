package lesson6;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Main {
    /**
     * 1. Создать 2 текстовых файла, примерно по 50-100 символов в каждом (особого значения не имеет);
     * 2. Написать программу, «склеивающую» эти файлы, то есть вначале идет текст из первого файла, потом текст из второго.
     * 3. Написать программу, которая проверяет присутствует ли указанное пользователем слово в файле.
     * 4. * Написать метод, проверяющий, есть ли указанное слово в папке, внутри есть файлы,
     * в которых может содержатся это слово (данная тема преднамеренно не рассказывалась,
     * поэтому надо погуглить (Гуглить - тоже надо уметь правильно).
     * При чем не просто найти решение и списать, а именно сформулировать проблему.
     * Пока вы будете формулировать проблему - вы найдете 50% решения)
     */
    public static void main(String[] args) {

        try {

            //1. Создать 2 текстовых файла, примерно по 50-100 символов в каждом (особого значения не имеет);
            if (printToFile("text1.txt", "Создать 2 текстовых файла, примерно по 50-100 символов в каждом (особого значения не имеет);")) {
                throw new Exception("Не смог записать данные в файл");
            }
            if (printToFile("text2.txt", "Написать программу, «склеивающую» эти файлы, то есть вначале идет текст из первого файла, потом текст из второго.")) {
                throw new Exception("Не смог записать данные в файл");
            }

            //2. Написать программу, «склеивающую» эти файлы, то есть вначале идет текст из первого файла, потом текст из второго.
            mergeFile("text1.txt", "text2.txt", "text3.txt");

            //3. Написать программу, которая проверяет присутствует ли указанное пользователем слово в файле.
            System.out.println("Искомый текст есть в строке: " + findTextInFile("text3.txt", "эти"));
            System.out.println("Искомый текст есть в строке: " + findTextInFile("text3.txt", "смог"));
            System.out.println("Искомый текст есть в строке: " + findTextInFile("text3.txt", "Эти"));

            //4. поиск текста в содержимом файлов конкретной папки - (если я правильно понял суть задачи)
            System.out.println("Искомый текст есть в папке: " + findTextInFolder("C:\\Users\\ingener401\\IdeaProjects\\firstJavaApp\\src\\lesson6", "эти"));


        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }

    }

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

    /**
     * Метод проверяет если или нет искомое слово в файле. Поиск с учетом регистра.
     *
     * @param nameFile - имя файла, в котором ищем
     * @param findText - текст, который ищем
     * @return boolean - найдено или нет совпадение
     */
    public static boolean findTextInFile(String nameFile, String findText) {
        boolean status = true;
        StringBuffer textFile;
        textFile = readFromFile(nameFile);
        if (textFile.indexOf(findText) == -1) {
            status = false;
        }
        return status;
    }

    /**
     * Метод поиска текста в содержимом файлов папки
     *
     * @param pathFolder - путь до папки
     * @param findText   - искомый текст
     * @return boolean - найдено или нет совпадение
     */
    public static boolean findTextInFolder(String pathFolder, String findText) {
        boolean status = true;
        // 1.получаем список файлов папки
        // 2. заталкиваем это все в массив названий файла
        // 3. пробегаемя по массиву названий файла и считываем файл
        // 4. ищем текст в данном файле, если там есть, то пишем имя файла в тертий массив

        File dir = new File(pathFolder); //path указывает на директорию
        List<File> lst = new ArrayList<>();
        for (File file : dir.listFiles()) {
            if (file.isFile())
                lst.add(file);
        }
//        StringBuffer textFile;
//        textFile = readFromFile(nameFile);
//        if (textFile.indexOf(findText) == -1) {
//            status = false;
//        }
        return status;
    }
}

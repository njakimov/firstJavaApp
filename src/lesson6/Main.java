package lesson6;

import java.io.StringWriter;

public class Main extends Throwable {

    private static FindText findText = new FindText();

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
            if (MyFile.printToFile("text1.txt", "Создать 2 текстовых файла, примерно по 50-100 символов в каждом (особого значения не имеет);")) {
                throw new Exception("Не смог записать данные в файл");
            }
            if (MyFile.printToFile("text2.txt", "Написать программу, «склеивающую» эти файлы, то есть вначале идет текст из первого файла, потом текст из второго.")) {
                throw new Exception("Не смог записать данные в файл");
            }

            //2. Написать программу, «склеивающую» эти файлы, то есть вначале идет текст из первого файла, потом текст из второго.
            MyFile.mergeFile("text1.txt", "text2.txt", "text3.txt");

            System.out.println("");
            System.out.println("----");
            System.out.println("Ищем в файле");
            
            //3. Написать программу, которая проверяет присутствует ли указанное пользователем слово в файле.
            findText.findTextInFile("text3.txt", "эти", false);
            // распечатываем класс в консоль методом из самого класса, хоть так и нельзя делать, но если очень хочется упростить чтение основной программы, то можно.
            findText.print();

            findText.findTextInFile("text3.txt", "смог", false);
            findText.print();

            findText.findTextInFile("text3.txt", "Эти", false);
            findText.print();

            System.out.println("");
            System.out.println("----");
            System.out.println("Ищем в папке");

            //4. поиск текста в содержимом файлов конкретной папки - (если я правильно понял суть задачи)
            findText.findTextInFolder("dsfghdfgh", "эти");
            findText.print();

        } catch (Throwable e) {
            e.printStackTrace();
        }

    }

}
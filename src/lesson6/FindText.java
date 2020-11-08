package lesson6;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс поиска текста в конкретном файле или в директории - без учета вложенности директорий
 */
public class FindText {
    private List<File> lstFile;                                                                                     // список с путем до файла и сами файлом в котором найден искомый текст
    private boolean blnStatus;                                                                                          // статус поиска в директории, есть или нет искомый текст в содержимом файлов папки
    private String stringTextToFind;                                                                                    // текст, который ищем

    FindText() {
        lstFile = new ArrayList<>();
        this.blnStatus = false;
        stringTextToFind = "";
    }

    public List<File> getLstFile() {
        return lstFile;
    }

    /**
     * метод добовления файла в список, если в нем найден искомы текст
     *
     * @param file - путь до файла
     */
    public void addLst(File file) {
        this.lstFile.add(file);
    }

    public void setLstFile(List<File> lstFile) {
        this.lstFile = lstFile;
    }

    public boolean isBlnStatus() {
        return blnStatus;
    }

    /**
     * Метод поиска текста в содержимом файлов папки
     *
     * @param pathFolder - путь до папки
     * @param findText   - искомый текст
     * @return boolean - найдено или нет совпадение
     */
    public boolean findTextInFolder(String pathFolder, String findText) {
        // 1.получаем список файлов папки
        // 2. заталкиваем это все в массив названий файла
        // 3. пробегаемя по массиву названий файла и считываем файл
        // 4. ищем текст в данном файле, если там есть, то пишем имя файла в тертий массив

        blnStatus = false;
        lstFile = new ArrayList<>();
        stringTextToFind = findText;
        try {
            if (pathFolder.isEmpty()) {
                throw new IOException("путь пустой");
            }

            File dir = new File(pathFolder); //path указывает на директорию
            if (dir.listFiles() == null) {
                throw new IOException("Дирректории не существует");
            }
            for (File file : dir.listFiles()) {
                if (file.isFile()) {
                    findTextInFile(file.toString(), findText, true);
                }
            }

            if (lstFile.size() != 0) {
                blnStatus = true;
            }


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return blnStatus;
    }

    /**
     * Метод проверяет если или нет искомое слово в файле. Поиск с учетом регистра.
     *
     * @param nameFile - имя файла, в котором ищем
     * @param findText - текст, который ищем
     * @param isDir    - если директория, то обнулять не надо в классе массив найденых файлов
     * @return boolean - найдено или нет совпадение
     */
    public boolean findTextInFile(String nameFile, String findText, boolean isDir) {
        blnStatus = true;
        if (!isDir) {
            lstFile = new ArrayList<>();
        }

        stringTextToFind = findText;

        StringBuffer textFile;
        textFile = MyFile.readFromFile(nameFile);
        if (textFile.indexOf(findText) == -1) {
            blnStatus = false;
        } else {
            addLst(new File(nameFile));
        }
        return blnStatus;
    }

    /**
     * Метод вывода содержимого класса в консоль
     * что на много удобнее и быстрее с учетом всех операций и позволяет в будущем организовать формирование логов
     */
    public void print() {
        System.out.println(" ");
        System.out.println("------------");
        System.out.println("Искомый текст: " + stringTextToFind);
        System.out.println("Текст найден в файле?: " + blnStatus);
        if (blnStatus) {
            for (File file : this.lstFile) {
                System.out.println("Текст найден в файле: " + file.toString());
            }
        }
    }
}

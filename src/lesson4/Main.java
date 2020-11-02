package lesson4;

public class Main {
    public static void main(String[] args) {

        Worker[] handbookWorker = new Worker[5];
        handbookWorker[0] = new Worker("Петров Иван Иванович", "Директор",
                "+79001005020", 1000, 28);
        handbookWorker[1] = new Worker("Иванов Петр Петрович", "Секретарь",
                "+79001005021", 10, 19);
        handbookWorker[2] = new Worker("Сидоров Константин Эдмундович", "Начальник цеха №1",
                "+79001005022", 250, 17);
        handbookWorker[3] = new Worker("Мишустин Николай Владимирович", "Техник 1 разряда",
                "+79001005023", 50, 64);
        handbookWorker[4] = new Worker("Гладков Евгений Львович", "Грузчик",
                "+79001005024", 200, 35);

        printComment("Полный список сотрудников: ");
        for (Worker worker : handbookWorker) {
            worker.printFullNamePosition();
        }

        printComment("Полный список сотрудников при помощи методов класса: ");
        for (Worker worker : handbookWorker) {
            System.out.println(worker.getFullName() + ' ' + worker.getPosition());
        }

        printComment("Список сотрудников старше 40 лет: ");
        for (Worker worker : handbookWorker) {
            if (worker.getAge() > 40) {
                worker.printInfo();
            }
        }

        setUpSalaryByAge(handbookWorker, 45);
        printComment("Полный список сотрудников после повышения зп: ");
        for (Worker worker : handbookWorker) {
            worker.printInfo();
        }
    }

    /**
     * метод повышения зп работника старше определенного возраста
     * @param handbookWorker - справочник работников
     * @param age - возраст, для которого увеличиваем зп
     */
    public static void setUpSalaryByAge(Worker[] handbookWorker, int age) {
        for (Worker worker : handbookWorker) {
            if (worker.getAge() > age)
                worker.setSalary(worker.getSalary() + 5000);
        }
    }

    // метод распечатки комментария
    public static void printComment(String text) {
        System.out.println("");
        System.out.println("----------");
        System.out.println(text);
    }

}

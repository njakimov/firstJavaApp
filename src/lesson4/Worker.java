package lesson4;

public class Worker {
    /**
     * 1. Создать класс "Сотрудник" с полями: ФИО, должность, телефон, зарплата, возраст;
     * 2. Конструктор класса должен заполнять эти поля при создании объекта;
     * 3. Внутри класса «Сотрудник» написать методы, которые возвращают значение каждого поля;
     * 4. Вывести при помощи методов из пункта 3 ФИО и должность.
     * 5. Создать массив из 5 сотрудников. С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
     * * Создать метод, повышающий зарплату всем сотрудникам старше 45 лет на 5000;
     * ** При создании экземпляра класса Сотрудник присваивать ему уникальный порядковый номер.
     */

    private final String fullName;                                                                                      // ФИО
    private String position;                                                                                            // должность
    private String telephoneNumber;                                                                                     // телефонный номер
    private float salary;                                                                                               // заработная плата
    private final int age;                                                                                              // возраст
    private final int id;                                                                                               // идентификатор работника
    private static int workerIdx = 0;                                                                                   // индекс для создания уникального идентификатора в классе

    /**
     * конструктор класса Сотрудники
     *
     * @param fullName        - ФИО
     * @param position        - должность
     * @param telephoneNumber - телефонный номер
     * @param salary          - заработная плата
     * @param age             - возраст
     */
    Worker(String fullName, String position, String telephoneNumber, float salary, int age) {
        this.id = ++workerIdx;
        this.fullName = fullName;
        this.position = position;
        this.telephoneNumber = telephoneNumber;
        this.salary = salary;
        this.age = age;
    }

    /**
     * конструктор класса Сотрудники
     *
     * @param fullName - ФИО
     * @param position - должность
     * @param salary   - заработная плата
     * @param age      - возраст
     */
    Worker(String fullName, String position, float salary, int age) {
        this.id = ++workerIdx;
        this.fullName = fullName;
        this.position = position;
        this.salary = salary;
        this.age = age;
    }

    /**
     * конструктор класса Сотрудники
     *
     * @param fullName - ФИО
     * @param age      - возраст
     */
    Worker(String fullName, int age) {
        this.id = ++workerIdx;
        this.fullName = fullName;
        this.age = age;
    }

    /**
     * Метод возвращает ФИО работника
     *
     * @return fullName
     */
    public String getFullName() {
        return this.fullName;
    }

    /**
     * Метод возвращает должность работника
     *
     * @return position
     */
    public String getPosition() {
        return this.position;
    }

    /**
     * Метод возвращает телефонный номер работника
     *
     * @return telephoneNumber
     */
    public String getTelephoneNumber() {
        return this.telephoneNumber;
    }

    /**
     * Метод возвращает величину заработной платы работника
     *
     * @return salary
     */
    public float getSalary() {
        return this.salary;
    }

    /**
     * Метод возвращает возраст работника
     *
     * @return age
     */
    public int getAge() {
        return this.age;
    }

    /**
     * Метод возвращает идентификатор работника
     *
     * @return id
     */
    public int getId() {
        return this.id;
    }

    /**
     * Метод устанавливающий зп работника
     *
     * @param salary - заработная плата на повышение
     */
    public void setSalary(float salary) {
        this.salary = salary;
    }

    public void printInfo() {
        System.out.println("-------");
        System.out.println("ИД: " + this.id);
        System.out.println("ФИО: " + this.fullName);
        System.out.println("Должность: " + this.position);
        System.out.println("ЗП: " + this.salary);
        System.out.println("Возраст: " + this.age);
    }

    public void printFullNamePosition() {
        System.out.print("ИД: " + this.id);
        System.out.print("\t ФИО: " + this.fullName);
        System.out.println("\t Должность: " + this.position);

    }
}

package lesson5;

/**
 * Создать классы Собака, Лошадь, Птица и Кот с наследованием от класса Животное.
 * Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие.
 * В качестве параметра каждому методу передается величина, означающая или длину препятствия
 *      (для бега и плавания), или высоту (для прыжков).
 * У каждого животного есть ограничения на действия
 *      (
 *          бег: кот 200 м., собака 500 м., Лошадь 1500 м., Птица 5 м.;
 *          прыжок: кот 2 м., собака 0.5 м., Лошадь 3 м., Птица 0.2 м. ;
 *          плавание: кот и птица не умеет плавать, собака 10 м., лошадь 100 м.
 *      ).
 *      При попытке животного выполнить одно из этих действий, оно должно сообщить результат.
 *      (Например, dog1.run(150); -> результат: 'Пёсик пробежал!')
 * * Добавить животным разброс в ограничениях.
 *      То есть у одной собаки ограничение на бег может быть 400 м., у другой 600 м.
 */

public abstract class Animal {
    protected String name;                                                                                              // имя животного
    protected int distanceRun;                                                                                          // дистанция, на которое производится бег
    protected int distanceSwim;                                                                                         // дистанция, на которое производится плавание
    protected float heightJump;                                                                                         // высота, на которое производится прыжок
    protected String typeAnimal;                                                                                        // тип животного
    protected int limitRun;                                                                                             // ограничение на бег

    public Animal(String name) {
        this.name = name;
        this.distanceRun = 0;
        this.distanceSwim = 0;
        this.heightJump = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDistanceRun() {
        return distanceRun;
    }

    public void setDistanceRun(int distanceRun) {
        this.distanceRun = distanceRun;
    }

    public int getDistanceSwim() {
        return distanceSwim;
    }

    public void setDistanceSwim(int distanceSwim) {
        this.distanceSwim = distanceSwim;
    }

    public float getHeightJump() {
        return heightJump;
    }

    public void setHeightJump(float heightJump) {
        this.heightJump = heightJump;
    }

    public String getTypeAnimal() {
        return typeAnimal;
    }

    public void setTypeAnimal(String typeAnimal) {
        this.typeAnimal = typeAnimal;
    }

    public String getAnimalInfo() {
        return
                this.typeAnimal + ": " + this.name + "\n " +
                        "Предел бега: " + this.limitRun + "\n " +
                        "Дистанция, на которую побежал: " + this.distanceRun + "\n " +
                        "Дистанция, на которую поплыл: " + this.distanceSwim + "\n " +
                        "Высота, на которую прыгнул: " + this.heightJump;
    }

    // абстрактный метод бег
    public abstract void run(int distance);

    // абстрактный метод прыжок
    public abstract void jump(float height);

    // абстрактный метод плавание
    public abstract void swim(int distance);
}

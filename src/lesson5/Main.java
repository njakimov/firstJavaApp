package lesson5;

import lesson4.Worker;
import java.util.ArrayList;
import java.util.*;

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
public class Main {
    public static void main(String[] args) {

        // Работа сделана по рассказанному уроку
        Horse brownHourse = new Horse("Вороной");
        Cat catSaimon = new Cat("Саймон");
        Dog dogBob = new Dog("Боб");
        Bird birdJane = new Bird("Джейн");

        Object[] animals = new Object[4];
        animals[0] = brownHourse;
        animals[1] = catSaimon;
        animals[2] = dogBob;
        animals[3] = birdJane;

        for (int i = 0; i < animals.length; i++) {
            ((Animal) animals[i]).run(500);
        }

        breaker();

        for (int i = 0; i < animals.length; i++) {
            ((Animal) animals[i]).jump(1);
        }

        breaker();

        for (int i = 0; i < animals.length; i++) {
            ((Animal) animals[i]).swim(9);
        }

        breaker();
        breaker();
        breaker();

        // работа сделана для себя - более читаемый вариант кода
        List<Animal> animalList = new ArrayList<>();
        animalList.add(new Horse("Вороной"));
        animalList.add(new Cat("Саймон"));
        animalList.add(new Dog("Боб"));
        animalList.add(new Bird("Джейн"));

        for (Animal animal : animalList) {
            animal.run(500);
        }

        breaker();

        for (Animal animal : animalList) {
            animal.swim(9);
        }

        breaker();

        for (Animal animal : animalList) {
            animal.jump(1);
        }

        breaker();

        for (Animal animal : animalList) {
            System.out.println(animal.getAnimalInfo());
        }

    }

    /**
     * разделитель
     */
    public static void breaker() {
        System.out.println("------------------");
    }
}

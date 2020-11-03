package lesson5;

import java.util.Random;

public class Cat extends Animal {
    Random limitGenerator = new Random();

    public Cat(String name) {
        super(name);
        this.typeAnimal = "Кошка";
        this.limitRun = limitGenerator.nextInt(200) + 100;
    }

    @Override
    public void run(int distance) {
        if (distance < this.limitRun) {
            this.distanceRun = distance;
            System.out.println("Кот " + this.name + " побежал дистанцию: " + this.distanceRun);
        } else {
            System.out.println("Кот " + this.name + " не может столько бегать");
        }
    }

    @Override
    public void jump(float height) {
        if (height < 2) {
            this.heightJump = height;
            System.out.println("Кот " + this.name + " прыгнул на высоту: " + this.heightJump);
        } else {
            System.out.println("Кот " + this.name + " не может на столько прыгать");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println("Кот " + this.name + " не может плавать от слова совсем");
    }
}

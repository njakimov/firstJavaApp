package lesson5;

import java.util.Random;

public class Bird extends Animal {

    Random limitGenerator = new Random();

    public Bird(String name) {
        super(name);
        this.typeAnimal = "Птица";
        this.limitRun = limitGenerator.nextInt(3) + 2;
    }

    @Override
    public void run(int distance) {
        if (distance < this.limitRun) {
            this.distanceRun = distance;
            System.out.println("Птичка " + this.name + " побежала дистанцию: " + this.distanceRun);
        } else {
            System.out.println("Птичка " + this.name + " не может столько бегать");
        }
    }

    @Override
    public void jump(float height) {
        if (height < 0.2) {
            this.heightJump = height;
            System.out.println("Птичка " + this.name + " прыгнула на высоту: " + this.heightJump);
        } else {
            System.out.println("Птичка " + this.name + " не может на столько прыгать");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println("Птичка " + this.name + " не может плавать от слова совсем");
    }
}

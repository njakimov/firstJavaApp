package lesson5;

import java.util.Random;

public class Dog extends Animal {

    Random limitGenerator = new Random();

    public Dog(String name) {
        super(name);
        this.typeAnimal = "Собака";
        this.limitRun = limitGenerator.nextInt(200) + 400;
    }

    @Override
    public void run(int distance) {
        if (distance < this.limitRun) {
            this.distanceRun = distance;
            System.out.println("Песик " + this.name + " побежал дистанцию: " + this.distanceRun);
        } else {
            System.out.println("Песик " + this.name + " не может столько бегать");
        }
    }

    @Override
    public void jump(float height) {
        if (height < 0.5) {
            this.heightJump = height;
            System.out.println("Песик " + this.name + " прыгнул на высоту: " + this.heightJump);
        } else {
            System.out.println("Песик " + this.name + " не может на столько прыгать");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance < 10) {
            this.distanceSwim = distance;
            System.out.println("Песик " + this.name + " проплыл дистанцию: " + this.distanceSwim);
        } else {
            System.out.println("Песик " + this.name + " не может на столько плыть");
        }
    }
}

package lesson5;

import java.util.Random;

public class Horse extends Animal {

    Random limitGenerator = new Random();

    public Horse(String name) {
        super(name);
        this.typeAnimal = "Лошадь";
        this.limitRun = limitGenerator.nextInt(200) + 1400;
    }

    @Override
    public void run(int distance) {
        if (distance < this.limitRun) {
            this.distanceRun = distance;
            System.out.println("Лошадь " + this.name + " побежала дистанцию: " + this.distanceRun);
        } else {
            System.out.println("Лошадь " + this.name + " не может столько бегать");
        }
    }

    @Override
    public void jump(float height) {
        if (height < 3) {
            this.heightJump = height;
            System.out.println("Лошадь " + this.name + " прыгнула на высоту: " + this.heightJump);
        } else {
            System.out.println("Лошадь " + this.name + " не может на столько прыгать");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance < 100) {
            this.distanceSwim = distance;
            System.out.println("Лошадь " + this.name + " проплыла дистанцию: " + this.distanceSwim);
        } else {
            System.out.println("Лошадь " + this.name + " не может на столько плыть");
        }
    }
}

package lesson4;

public class Car {
    String model;
    String color;
    int countWheels;
    static int props1 = 400;

    Car(String model) {
        this.model = model;
    }
    Car(String model, String color) {
        this.model = model;
        this.color = color;
    }

    void move() {
        System.out.println(model + " has moved ");
    }

    void beep() {
        System.out.println(model + " has beep-beep ");
    }

    void print() {
        System.out.println("color: " + this.color);
        System.out.println("model: " + this.model);
        System.out.println("countWheels: " + this.countWheels);
    }

}

package com.bridgeLabz.practice;

class Animal {
    public void makeSound() {
        System.out.println("animal");
    }
}


class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("dog");
    }
}
public class OverrideExample {
    public static void main(String[] args) {
        Animal dog = new Dog();
        dog.makeSound();
    }
}

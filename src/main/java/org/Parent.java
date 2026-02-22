package org;


public class Parent {

    String name;
    String eyeColor = "brown";
    String hairColor = "black";

    public Parent() {}

    public Parent(String name, String eyeColor, String hairColor) {
        this.name = name;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
    }

    public Parent(String eyeColor, String hairColor) {
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
    }

    public void displayPerson(){
        System.out.println(name + " Information ");

        System.out.println("Name: " + name);
        System.out.println("Eye Color: " + eyeColor);
        System.out.println("Hair Color: " + hairColor);
    }
}

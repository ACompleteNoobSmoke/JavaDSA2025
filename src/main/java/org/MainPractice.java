package org;

public class MainPractice {

    static void main() {
        Mason mason = new Mason("Mason Karr", "Black", "Blue");
        MasonJr masonJr = new MasonJr();
        System.out.println("Parent (Mason)");
        mason.displayPerson();
        System.out.println();
        System.out.println("Child (MasonJr)");
        System.out.println(masonJr.birthMarkExist);
        masonJr.displayPerson();
    }
}

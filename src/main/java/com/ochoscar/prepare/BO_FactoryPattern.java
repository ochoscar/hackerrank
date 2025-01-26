package com.ochoscar.prepare;

import java.util.Scanner;

/**
 * According to Wikipedia, a factory is simply an object that returns another object from some other method call, which is assumed to be "new".
 * <p>
 * In this problem, you are given an interface Food. There are two classes Pizza and Cake which implement the Food interface, and they both contain a method getType().
 * <p>
 * The main function in the Main class creates an instance of the FoodFactory class. The FoodFactory class contains a method getFood(String) that returns a new instance of Pizza or Cake according to its parameter.
 * <p>
 * You are given the partially completed code in the editor. Please complete the FoodFactory class.
 * <p>
 * Sample Input 1
 * <p>
 * cake
 * Sample Output 1
 * <p>
 * The factory returned class Cake
 * Someone ordered a Dessert!
 * Sample Input 2
 * <p>
 * pizza
 * Sample Output 2
 * <p>
 * The factory returned class Pizza
 * Someone ordered Fast Food!
 */
public class BO_FactoryPattern {

    public static void main(String args[]) {

        try {

            Scanner sc = new Scanner(System.in);
            //creating the factory
            FoodFactory foodFactory = new FoodFactory();

            //factory instantiates an object
            Food food = foodFactory.getFood(sc.nextLine());


            System.out.println("The factory returned " + food.getClass());
            System.out.println(food.getType());
        } catch (Exception e) {
            System.out.println("Unsuccessful Termination!!");
        }
    }

}

interface Food {
    public String getType();
}

class Pizza implements Food {
    public String getType() {
        return "Someone ordered a Fast Food!";
    }
}

class Cake implements Food {

    public String getType() {
        return "Someone ordered a Dessert!";
    }
}

class FoodFactory {
    public Food getFood(String order) {
        if (order.equalsIgnoreCase("pizza")) return new Pizza();
        else if (order.equalsIgnoreCase("cake")) return new Cake();
        return null;
    }
}

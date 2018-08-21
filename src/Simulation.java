import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Simulation {

  ArrayList<Item> loadItems(String fileName) {
    //Read the files
    File file = new File(fileName);
    //Create list of items
    ArrayList<Item> items = new ArrayList<>();
    try (Scanner scanner = new Scanner(file)) {
      while (scanner.hasNextLine()) {
        //Add items to the list
        String[] string = scanner.nextLine().split("=");
        Item item = new Item(string[0], Integer.parseInt(string[1]));
        items.add(item);
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    return items;
  }

  //Load the U1 rocket
  ArrayList<Rocket> loadU1(ArrayList<Item> items) {
    int i = 0;
    //Compares the available weight in the rocket and the lightest item in the list
    Collections.sort(items);
    //Create an rockets list
    ArrayList<Rocket> u1s = new ArrayList<>();
    if (!items.isEmpty()) {
      Rocket u1 = new U1();
      //Compares the available weight in the rocket and the lightest item in the list
      for (Item item : items) {
        System.out.println("Item: " + item.toString());
        if (u1.canCarry(item)) {
          u1.carry(item);
          System.out.println("Current cargo is: " + u1.getCargo());
        } else {
          u1s.add(u1);
          u1 = new U1();
          System.out.println("New rocket");
          u1.carry(item);
          System.out.println("Current cargo is: " + u1.getCargo());
        }
      }
    }
    return u1s;
  }

  //Load the U2 rocket
  ArrayList<Rocket> loadU2(ArrayList<Item> items) {
    int i = 0;
    //Compares the available weight in the rocket and the lightest item in the list
    Collections.sort(items);
    //Create an rockets list
    ArrayList<Rocket> u2s = new ArrayList<>();
    if (!items.isEmpty()) {
      Rocket u2 = new U2();
      //Compares the available weight in the rocket and the lightest item in the list
      for (Item item : items) {
        System.out.println("Item: " + item.toString());
        if (u2.canCarry(item)) {
          u2.carry(item);
          System.out.println("Current cargo is: " + u2.getCargo());
        } else {
          u2s.add(u2);
          u2 = new U1();
          System.out.println("New rocket");
          u2.carry(item);
          System.out.println("Current cargo is: " + u2.getCargo());
        }
      }
    }
    return u2s;
  }

  //Begin the simulation
  int runSimulation(ArrayList<Rocket> us) {
    // Total rockets cost
    int budget = 0;
    boolean success;
    for (Rocket u : us) {
      success = false;
      while (!success) {
        success = (u.land() && u.launch());
        //Adds the rocket cost
        budget += u.getCost();
        if (success) {
          System.out.println("success land and launch");
        } else {
          System.out.println("The rocket has crashed or exploded");
        }
      }
    }
    return budget;
  }
}

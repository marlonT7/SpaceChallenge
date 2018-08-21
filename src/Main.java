import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    Simulation simulation = new Simulation();
    //Read items from files
    ArrayList<Item> itemsPhase1 = simulation.loadItems("phase-1.txt");
    ArrayList<Item> itemsPhase2 = simulation.loadItems("phase-2.txt");
    System.out.println("Trying U1 rockets");
    System.out.println("Start of phase 1\n");
    //Load items to the U1 rockets in phase1
    ArrayList<Rocket> u1sPhase1 = simulation.loadU1(itemsPhase1);
    System.out.println("End of phase 1\n");

    System.out.println("Start of phase 2\n");
    //Load items to the U1 rockets in phase 2
    ArrayList<Rocket> u1sPhase2 = simulation.loadU1(itemsPhase2);
    System.out.println("End of phase 2\n");

    for (Rocket u1 : u1sPhase1) {
      System.out.println("U1: " + u1.toString());
    }
    for (Rocket u1 : u1sPhase2) {
      System.out.println("U1: " + u1.toString());
    }
    //Simulates launch and land, U1 rockets
    int budgetU1 = simulation.runSimulation(u1sPhase1) + simulation.runSimulation(u1sPhase2);
    System.out.println("\nBudget for U1 rockets"+budgetU1);


    System.out.println("\n\nTrying U2 rockets\n\n");


    System.out.println("Start of phase 1\n");
    //Load items to the U2 rockets in phase 1
    ArrayList<Rocket> u2sPhase1 = simulation.loadU2(itemsPhase1);
    System.out.println("End of phase 1\n");
    System.out.println("Start of phase 2\n");
    //Load items to the U2 rockets in phase 2
    ArrayList<Rocket> u2sPhase2 = simulation.loadU2(itemsPhase2);
    System.out.println("End of phase 2\n");

    for (Rocket u2 : u2sPhase1) {
      System.out.println("U2: " + u2.toString());
    }
    for (Rocket u2 : u2sPhase2) {
      System.out.println("U2: " + u2.toString());
    }
    //Simulates launch and land, U2 rockets
    int budgetU2 = simulation.runSimulation(u2sPhase1) + simulation.runSimulation(u2sPhase2);
    System.out.println("\nBudget for U2 rockets: "+budgetU2);

  }
}

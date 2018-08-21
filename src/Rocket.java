public abstract class Rocket implements SpaceShip{
  private int cost;
  private int weight;
  int maxWeight;
  int cargo;

  Rocket(int cost, int weight, int maxWeight) {
    this.cost = cost;
    this.weight = weight;
    this.maxWeight = maxWeight;
    this.cargo = 0;
  }

  @Override
  public String toString() {
    return "Rocket{" +
        "cost=" + cost +
        ", weight=" + weight +
        ", maxWeight=" + maxWeight +
        ", cargo=" + cargo +
        '}';
  }

  int getCost() {
    return cost;
  }

  int getWeight() {
    return weight;
  }

  int getCargo() {
    return cargo;
  }

  @Override
  public void carry(Item item) {
    this.cargo += item.getWeight();
  }

  @Override
  public boolean canCarry(Item item) {
    int newCargo = this.weight + this.cargo + item.getWeight();
    return maxWeight >= newCargo;
  }
}

class Item implements Comparable<Item> {
  private String name;
  private int weight;

   Item(String name, int weight) {
    this.name = name;
    this.weight = weight;
  }

  int getWeight() {
    return weight;
  }

  @Override
  public int compareTo(Item o) {
    return this.weight - o.weight;

  }

  @Override
  public String toString() {
    return "Item: " + this.name + ", weight: " + this.weight;
  }
}

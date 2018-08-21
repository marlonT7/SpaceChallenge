public class U2 extends Rocket {
  U2() {
    super(120, 18000, 29000);
  }

  @Override
  public boolean launch() {
    //Generates a random value to compare with the explode probability
    int randomExplosion = (int) (Math.random() * 100);
    return randomExplosion > 4 * (this.cargo / (this.maxWeight - this.getWeight()));
  }

  @Override
  public boolean land() {
    //Generates a random value to compare with the crash probability
    int randomCrash = (int) (Math.random() * 100) + 1;
    return randomCrash > 8 * (this.cargo / (this.maxWeight - this.getWeight()));
  }
}

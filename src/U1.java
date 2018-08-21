public class U1 extends Rocket {

  U1() {
    super(100, 10000, 18000);
  }

  @Override
  public boolean launch() {
    //Generates a random value to compare with the explode probability
    int randomExplosion = (int) (Math.random() * 100);
    return randomExplosion > 5 * (this.cargo / (this.maxWeight - this.getWeight()));
  }

  @Override
  public boolean land() {
    //Generates a random value to compare with the crash probability
    int randomCrash = (int) (Math.random() * 100);
    return randomCrash > (this.cargo / (this.maxWeight - this.getWeight()));
  }
}

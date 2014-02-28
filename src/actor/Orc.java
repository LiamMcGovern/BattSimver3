package actor;


import util.InputGUI;
import util.SingletonRandom;

/**
 * Created by Lenny on 2/28/14.
 */
public class Orc extends Actor {

   private double rage; //represents the level of anger the
   private double size;

   private final double MAX_RAGE = 15.0;
   private final double MIN_RAGE = 1.0;

   private final double MAX_SIZE = 10.0;
   private final double MIN_SIZE = 1.0;




    public Orc (){
        super();
        setRage(SingletonRandom.instance.getNormalDistribution(MIN_RAGE, MAX_RAGE, 5));
        setSize(SingletonRandom.instance.getNormalDistribution(MIN_RAGE, MAX_RAGE, 5));

    }

    @Override
    public void inputAllFields(){
        super.inputAllFields();
        setSize(InputGUI.getDouble((String.format("Input %s's Size [This must be between %4.1f and %4.1f]",
               super.getName(), MAX_SIZE, MIN_SIZE)), MIN_SIZE, MAX_SIZE));
    }

    @Override
    public String toString (){ //"\t Stealth:%4.1f \t", getArmor()
        return String.format("%s \t Size: %4.1f \t Rage: %4.1f \t ", super.toString(), getSize(), getRage());
    }

    public double getRage() {
        return rage;
    }

    public double getSize() {
        return size;
    }

    public void setRage(double rage) {
        this.rage = rage;
    }

    public void setSize(double size) {
        this.size = size;
    }
}

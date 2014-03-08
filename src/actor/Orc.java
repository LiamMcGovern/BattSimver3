package actor;


import util.InputGUI;
import util.SingletonRandom;

/**
 * Created by Lenny on 2/28/14.
 */
public class Orc extends Actor {


    /**
     * <i>rage</i> value represents if Orc is in a state of rage, if it is the amount on damage dealt will be
     * increased, and the amount of damage taken will be reduced for the next 3 attacks by the Orc or on the Orc.
     * Whichever comes first.
     * If the Orc takes damage the damage taken will be reduced by the amount of the constant RAGE_REDUCTION
     * If the Orc makes an attack there is a 50% chance the damage will be increased by 50%.
     */
   private boolean isRaging; //True is raging, false is not.
   private double size; //Orc's size effects it's health but adversely effects it's speed.


    /**
     * {@value}
     */
   private final double RAGE_REDUCTION = 0.70; //The quantity of damage taken is reduce to 70%.
    /**
     * {@value}
     */
   private final double MAX_SIZE = 10.0;
    /**
     * {@value}
     */
   private final double MIN_SIZE = 1.0;

    public Orc (){
        super();
        health = 1;
        setIsRaging(false);
        setSize(SingletonRandom.instance.getNormalDistribution(MIN_SIZE, MAX_SIZE, 5));
    }

    @Override
    public void inputAllFields(){
        super.inputAllFields();
        setSize(InputGUI.getDouble((String.format("Input %s's Size [This must be between %4.1f and %4.1f]",
               super.getName(), MAX_SIZE, MIN_SIZE)), MIN_SIZE, MAX_SIZE));
    }

    @Override
    public double getHealth(){
        return (isRaging == true) ? this.health = 0 : this.health = 1;
    }

    @Override
    public String toString (){ //"\t Stealth:%4.1f \t", getArmor()
        return String.format("%s \t Size: %4.1f \t Rage: %b \t ", super.toString(), getSize(), getIsRaging());
    }
    public boolean getIsRaging() {
        return isRaging;
    }

    public void setIsRaging(boolean isRaging) {
        this.isRaging = isRaging;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

}

package actor;


import army.Army;
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
    /**
     * Orc's size effects it's health but adversely effects it's speed.
     * The greater the size the greater the Health. The smaller the less the health.
     */
    private double size; //Orc's size

    /**
     * The quantity of damage taken is reduced by this constant, not actually implemented yet, not sure how the combat
     * system will be put into action.
     * {@value}
     */
    private final double RAGE_REDUCTION = 0.70; //The quantity of damage taken is reduce to 70%.

    /**
     * Max Health differs from other Actor's since this is an Orc.
     * {@value}
     */
    private final double ORC_MAX_HEALTH = 200;
    /**
     * Min Health differs from other Actor's since this is an Orc.
     * {@value}
     */
    private final double ORC_MIN_HEALTH = 1;
    /**
     * {@value}
     */
    private final double MAX_SIZE = 10.0;
    /**
     * {@value}
     */
    private final double MIN_SIZE = 1.0;

    /**
     * Orc constructor, generates the various variables based upon randomly generated values.
     * Attributes specific to the Orc are<br></br>  boolean <b>isRaging</b> value, which represents if the Orc is in a state
     * of Rage.
     * double size effects it's health but adversely effects it's speed.
     * The greater the size the greater the Health. The smaller the less the health.
     */
    public Orc() {
        super();

        /** We must reset the health, since the Orc has a different range for Health values*/
        setHealth(SingletonRandom.instance.getNormalDistribution(ORC_MIN_HEALTH, ORC_MAX_HEALTH, 5));
        setSize(SingletonRandom.instance.getNormalDistribution(MIN_SIZE, MAX_SIZE, 4));
        setHealth(getHealth() * (((getSize() - 5) * 0.05) + 1)); //Size of Orc modifying Health.
        /** Generate random value for rage */
        final double CHANCE_OF_RAGE = 0.05;
        setIsRaging(Math.random() < CHANCE_OF_RAGE); //by default the Orc is not raging.
    }

     /**
     * Orc constructor, generates the various variables based upon randomly generated values.
     * Attributes specific to the Orc are<br></br>  boolean <b>isRaging</b> value, which represents if the Orc is in a state
     * of Rage.
     * double size effects it's health but adversely effects it's speed.
     * The greater the size the greater the Health. The smaller the less the health.
     * @param army
     */
    public Orc(Army army) {
        super(army);
        /** We must reset the health, since the Orc has a different range for Health values*/
        setHealth(SingletonRandom.instance.getNormalDistribution(ORC_MIN_HEALTH, ORC_MAX_HEALTH, 5));
        setSize(SingletonRandom.instance.getNormalDistribution(MIN_SIZE, MAX_SIZE, 4));
        setHealth(getHealth() * (((getSize() - 5) * 0.05) + 1)); //Size of Orc modifying Health.
        /** Generate random value for rage */
        final double CHANCE_OF_RAGE = 0.05;
        setIsRaging(Math.random() < CHANCE_OF_RAGE); //by default the Orc is not raging.
    }


    @Override
    public void inputAllFields() {
        super.inputAllFields();
        setSize(InputGUI.getDouble((String.format("Input %s's Size [This must be between %4.1f and %4.1f]",
                super.getName(), MAX_SIZE, MIN_SIZE)), MIN_SIZE, MAX_SIZE));
        setIsRaging(InputGUI.getBooleanGUI("Is the Orc currently in a state of Rage?"));
    }

    /**
     * @return Return the <b>Orc's</b> health.
     */
    @Override
    public double getHealth() {
        return this.health;
    }

    @Override
    public String toString() { //"\t Stealth:%4.1f \t", getArmor()
        return String.format("%s \t Size: %4.1f \t Rage: %b \t ", super.toString(), getSize(), getIsRaging());
    }

    /**
     * Return the set the Orc's health.
     *
     * @param health Value to set health to
     */
    @Override
    public void setHealth(double health) {
        //If user input exceeds limit, set it to nearest limit
        if (health > this.ORC_MAX_HEALTH) {
            System.out.printf("The entered Health value is greater than specified limits," +
                    " setting the value to defined max %.1f instead %n", this.ORC_MAX_HEALTH);
            this.health = this.ORC_MAX_HEALTH;
        } else if (health < this.ORC_MIN_HEALTH) {
            System.out.printf("The entered Health value is lower than specified limits," +
                    " setting the value to defined min %.1f instead %n", this.ORC_MIN_HEALTH);
            this.health = this.ORC_MIN_HEALTH;
        } else {
            this.health = health;//If user input is valid set Attribute to that value.
        }
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

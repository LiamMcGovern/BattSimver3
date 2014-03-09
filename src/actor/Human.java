package actor;

import army.Army;
import util.InputGUI;
import util.SingletonRandom;

/**
 * Created by Lenny on 2/28/14.
 */
public class Human extends Actor {
    /**
     * armor double value represents the quantity of armor a <b>Human</b> possess. It will act as extra health.
     */
    private double armor;
    /**
     * {@value}
     */
    private final double MAX_ARMOR = 50.0;
    /**
     * {@value}
     */
    private final double MIN_ARMOR = 0.0;
    /**
     * {@value}
     */
    private boolean hasHorse;

    /**
     * <b>Human</b> constructor calls the <i>Actor</i> constructor, then establishes a random value for the
     * new <b>armor</b> instance field.
     */
    public Human() {
        super();
        final double CHANCEOFHORSE = 0.42;
        setHasHorse(Math.random() < CHANCEOFHORSE); //91% Chance.
        setArmor(SingletonRandom.instance.getNormalDistribution(MIN_ARMOR, MAX_ARMOR, 5.0));
    }

    public Human(Army allegiance) {
        super(allegiance);
        final double CHANCEOFHORSE = 0.42;
        setHasHorse(Math.random() < CHANCEOFHORSE); //91% Chance.
        setArmor(SingletonRandom.instance.getNormalDistribution(MIN_ARMOR, MAX_ARMOR, 5.0));
    }


    /**
     * Returns a formatted string containing all Attributes of <i>Actor</i> and <b>Human</b>
     *
     * @return Returns a <i>String</i> String representation of the <b>Human</b>.
     */
    @Override //Override the Superclass's  (Actor) toString Method.
    public String toString() {
        return String.format(super.toString() + "\t Armor:%4.1f \t Has Horse:%b", getArmor(), getHasHorse());
    }

    /**
     * Allows user to input all value's of the <b>Human</b> object and its parent <i>Actor</i>
     */
    @Override //Override the Superclass's  (Actor) inputAllFields Method.
    public void inputAllFields() {
        super.inputAllFields();
        setHasHorse(InputGUI.getBooleanGUI(String.format("Is %s riding a horse?", super.getName())));
        setArmor(InputGUI.getDouble((String.format("Input %s's Armor [This must be between %4.1f and %4.1f]",
                super.getName(), MAX_ARMOR, MIN_ARMOR)), MIN_ARMOR, MAX_ARMOR));
    }

    /**
     * Returns the value of the matching Object's armor field.
     *
     * @return Returns the Human's armor value (double).
     * @see Human
     */
    public double getArmor() {
        return this.armor;
    }

    public boolean getHasHorse() {
        return this.hasHorse;
    }

    /**
     * @param hasHorse returns a boolean representing the presence or lack thereof of a mount.
     */
    public void setHasHorse(boolean hasHorse) {
        this.hasHorse = hasHorse;
    }

    /**
     * Checks the parameter value against predefined limits, and if within sets the Human's armor field to the
     * proper value.
     *
     * @param armor Value to be assigned to the Human's armor field.
     * @see Human
     */
    public void setArmor(double armor) {
        if (armor > MAX_ARMOR) {
            System.out.printf("The entered Armor is greater than specified limits," +
                    " setting the value to defined max %.1f instead %n", MAX_ARMOR);
            this.armor = MAX_ARMOR;
        } else if (armor < MIN_ARMOR) {
            System.out.printf("The entered Armor is lower than specified limits," +
                    " setting the value to defined min %.1f instead %n", MIN_ARMOR);
            this.armor = MIN_ARMOR;
        } else {
            this.armor = armor;//If user input is valid set Attribute to that value.
        }
    }
}

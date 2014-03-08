package actor;// N.B.  Use of default package at this point in
// the program would indicate a lack of knowledge on the part of the student!

import army.Army;
import util.InputGUI;
import util.SingletonRandom;

import java.lang.String;

/**
 * A reference to object Actor, has the following attributes
 * A name with it's coinciding serial number, incremented at each call to the constructor.
 * Health, Speed, and Strength.
 * <b>Health</b>, <b>Speed</b> and <b>Strength</b> are represented by a double value between 0 and 100,
 * this is based on the fact that a percentage is a logical way of measuring Health, Speed, and Strength.
 * <p/>
 *
 * @author Liam McGovern [Input and SingletonRandom Classes are used with permission from Rex Woolard]
 * @version Assignment 2, Object Oriented Programming.
 *          Project:  BattleField Simulator
 *          Lab Professor: David Houtman
 */
public abstract class Actor {

    private Army actorAllegiance;

    /**
     * Defining the Maximum and Minimum values for each attribute
     * it was decided that 1-100 is valid since a percentage style representation is very versatile.
     */
    /**
     * {@value}
     */
    public final static double MAX_HEALTH = 100.0;
    /**
     * {@value}
     */
    public final static double MIN_HEALTH = 1.0;
    /**
     * {@value}
     */

    public final static double MAX_SPEED = 100.0;
    /**
     * {@value}
     */
    public final static double MIN_SPEED = 1.0;
    /**
     * {@value}
     */

    public final static double MAX_STRENGTH = 100.0;
    /**
     * {@value}
     */
    public final static double MIN_STRENGTH = 1.0;

    /**
     * actorSerialNumber a class variable
     * used to assign each actor a unique number, static since it should not be unique to each actor.
     */
    public static int actorSerialNumber = 0;

    //Actor instance variables
    /**
     * A string object initialized with the value of 'Actor'
     */
    private String name = "Actor";


    /**
     * actorId represents each Actors unique number
     */
    private int actorId;

    /**
     * Actor Strength....
     */
    private double strength;
    /**
     * Actor Speed....
     */
    private double speed;

    /**Actor Health...*/
    protected double health;

    /**
     * <i>Actor</i> constructor establishes values for each attribute based on the generation of a random number.
     * The <i>Actor</i> has a name and serial number associated with it, to keep track of the various actors.
     */
    Actor() {
        actorSerialNumber++;//Increased upon each instantiation to correlate with the quantity of Actors created.
        actorId = actorSerialNumber; //Make id = value of actorSerialNumber
        name = String.format("%s%d", name, actorId); //Combining name with id
        //Actor instance variables are automagically instantiated with random values between the defined limits.

        //-----------Attributes-------------
        //Generate random numbers for each attribute field.
        //SingletonRandom is Prof. Woolard's random number generator.
        strength = SingletonRandom.instance.getNormalDistribution(MIN_STRENGTH, MAX_STRENGTH, 3);
        speed = SingletonRandom.instance.getNormalDistribution(MIN_SPEED, MAX_SPEED, 3);
        health = SingletonRandom.instance.getNormalDistribution(MIN_HEALTH, MAX_HEALTH, 3);
        //-----------Attributes-------------
    }

    Actor(Army allegiance) {
        this.actorAllegiance = allegiance; //Allow's for the Actor's allegiance to be set to a specific Army.

        actorSerialNumber++;//Increased upon each instantiation to correlate with the quantity of Actors created.
        actorId = actorSerialNumber; //Make id = value of actorSerialNumber
        name = String.format("%s%d", name, actorId); //Combining name with id
        //Actor instance variables are automagically instantiated with random values between the defined limits.

        //-----------Attributes-------------
        //Generate random numbers for each attribute field.
        //SingletonRandom is Prof. Woolard's random number generator.
        strength = SingletonRandom.instance.getNormalDistribution(MIN_STRENGTH, MAX_STRENGTH, 3);
        speed = SingletonRandom.instance.getNormalDistribution(MIN_SPEED, MAX_SPEED, 3);
        health = SingletonRandom.instance.getNormalDistribution(MIN_HEALTH, MAX_HEALTH, 3);
        //-----------Attributes-------------
    }

    /**
     * Allows user to input all attributes of <i>Actor</i> Object.
     */
    public void inputAllFields() {
        //Utilizes the set methods to pass input to the coinciding variables.
        //Each value is checked by the corresponding set methods.
        System.out.println("You will now be asked to input the various fields of the chosen Actor");
        setName(InputGUI.getString((String.format("Input %s's Name", this.name)))); //change the name
        //Change the attributes
        setHealth(InputGUI.getDouble(String.format("Input %s's Health [This must be between %4.1f and %4.1f]",
                this.name, MAX_HEALTH, MIN_HEALTH), MIN_HEALTH, MAX_HEALTH));
        setSpeed(InputGUI.getDouble((String.format("Input %s's Speed [This must be between %4.1f and %4.1f]",
                this.name, MAX_SPEED, MIN_SPEED)), MIN_SPEED, MAX_SPEED));
        setStrength(InputGUI.getDouble((String.format("Input %s's Strength [This must be between %4.1f and %4.1f]",
                this.name, MAX_STRENGTH, MIN_STRENGTH)), MIN_STRENGTH, MAX_STRENGTH));
        //This uses Prof. Woolard's Input parsing class to capture input.
    }

    @Override //This method overrides Java's inherited Object.toString method.
    //toString, used either directly or in the absence of a toString call for the object.
    /**
     * Creates a String based on the attributes of the actor.
     * @return Returns a formatted string, containing the Actor's attributes.
     */
    public String toString() {
        return (actorAllegiance == null) ? String.format("Name: %-12s Health:%4.1f \t Speed:%4.1f \t Strength:%4.1f",
                this.name, this.health, this.speed, this.strength)
                : String.format("Name: %-12s \t Army:%s \t Health:%4.1f \t Speed:%4.1f \t Strength:%4.1f",
                this.name, actorAllegiance.getArmyName(), this.health, this.speed, this.strength);
    }

    //----------get methods
    //Standard getMethods, return the value of the calling objects fields.

    /**
     * Returns selected actors name
     *
     * @return Returns actor's name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns selected actors health
     **
     * @return Returns actor's health
     */
    public double getHealth() { //getHealth returns the respective value of health to the object it's called by.
        return this.health;
    }

    /**
     * Returns selected actors strength
     *
     * @return Returns actor's strength
     */
    public double getStrength() {//getStrength returns the respective value of health to the object it's called by.
        return this.strength;
    }


    /**
     * Returns selected actors speed
     *
     * @return Returns actor's speed
     */
    public double getSpeed() {//getSpeed returns the respective value of health to the object it's called by.
        return this.speed;
    }

    //----------get methods

    //----------set methods

    /**
     * Sets Actor's name
     *
     * @param name Value to set name to
     * @see Actor
     */
    public void setName(String name) {
        this.name = String.format("%s%d", name, actorId); //Set name and format it with the proper id number.
    }

    //-----Attribute set methods----------

    //Each double Attribute is checked against the corresponding predefined limit
    //If it exceeds either limit the value is set to the nearest limit and the user is notified.
    //Otherwise the selected field is set to the specified value.

     public void setActorAllegiance(Army actorAllegiance) {
        this.actorAllegiance = actorAllegiance;
    }

    /**
     * Sets the value of the Actor's health.
     * If the parameter inputed is greater than the limit, it sets it to the nearest limit.
     *
     * @param speed Value to set speed to
     * @see Actor
     */
    public void setSpeed(double speed) {
        //If user input exceeds limit, set it to nearest limit
        if (speed > MAX_SPEED) {
            System.out.printf("The entered Speed is greater than specified limits," +
                    " setting the value to defined max %.1f instead %n", MAX_SPEED);
            this.speed = MAX_SPEED;
        } else if (speed < MIN_SPEED) {
            System.out.printf("The entered Speed is lower than specified limits," +
                    " setting the value to defined min %.1f instead %n", MIN_SPEED);
            this.speed = MIN_SPEED;
        } else {
            this.speed = speed; //If user input is valid set Attribute to that value.
        }
    }

    /**
     * Sets the value of the Actor's health.
     * If the parameter inputed is greater than the limit, it sets it to the nearest limit.
     *
     * @param health Value to set health to
     * @see Actor
     */
    public void setHealth(double health) {
        //If user input exceeds limit, set it to nearest limit
        if (health > MAX_HEALTH) {
            System.out.printf("The entered Health value is greater than specified limits," +
                    " setting the value to defined max %.1f instead %n", MAX_HEALTH);
            this.health = MAX_HEALTH;
        } else if (health < MIN_HEALTH) {
            System.out.printf("The entered Health value is lower than specified limits," +
                    " setting the value to defined min %.1f instead %n", MIN_HEALTH);
            this.health = MIN_HEALTH;
        } else {
            this.health = health;//If user input is valid set Attribute to that value.
        }
    }

    /**
     * Sets the value of the Actor's strength.
     * If the parameter inputed is greater than the limit, it sets it to the nearest limit.
     *
     * @param strength Value to set strength to
     * @see Actor
     */
    public void setStrength(double strength) {
        //If user input exceeds limit, set it to nearest limit
        if (strength > MAX_STRENGTH) {
            System.out.printf("The entered Strength is greater than specified limits," +
                    " setting the value to defined max %.1f instead %n", MAX_STRENGTH);
            this.strength = MAX_STRENGTH;
        } else if (strength < MIN_STRENGTH) {
            System.out.printf("The entered Strength is lower than specified limits," +
                    " setting the value to defined min %.1f instead %n", MIN_STRENGTH);
            this.strength = MIN_STRENGTH;
        } else {
            this.strength = strength;//If user input is valid set Attribute to that value.
        }
    }
    //-----Attribute set methods----------

    /**
     * Returns true if the actors has at least a quarter of it's health remaining, otherwise it returns false.
     *
     * @return Return's a boolean value that represents the Object's ability to move based on it's health.
     * @see Actor
     */
    public boolean isHealthyEnoughToMove() {
        final double healthToLowToMove = (MAX_HEALTH * 0.10);
        return (health > healthToLowToMove) ? true : false;
    }
}

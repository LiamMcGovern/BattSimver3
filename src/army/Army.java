package army;

import actor.*;

import java.util.ArrayList;

/**
 * Created by Lenny on 2/26/14.
 */
public class Army {
    /**
     * armyName is Army a String representing the Army object's name.
     */
    protected String armyName = "Unnamed Army";


    /**
     * armyForces will hold the 'Army' of Actor objects
     */
    private ArrayList<Actor> armyForces;

    /**
     * <b>Army</b> constructor takes String armyName and to set the Army's name.
     *
     * @param armyName
     */
    public Army(String armyName) {
        this.armyName = armyName;
        armyForces = new ArrayList<Actor>();
    }

    /**
     * Constructor for army, that recieves a name and automagically populates the army's forces based on the provided
     * quantityOfActors arguement.
     *
     * @param armyName         String that will become the aArmy's name
     * @param quantityOfActors Quantity of actors to Populate the Army with.
     */
    public Army(String armyName, int quantityOfActors) {
        this.armyName = armyName;
        armyForces = new ArrayList<Actor>(quantityOfActors);
    }

    /**
     * Populates the army with the provided arguments quantity. The choice of each is based on the probability of each
     * appearing. It makes sense that their is a higher probability to witness a Orc / Human in battle then a Wizard
     * so I have implemented the probability to address that, and to establish a realistic representation of
     * a live Battlefield.
     *
     * @param quantityOfActors
     */
    public void fillArmy(int quantityOfActors) {
        //Probabilities
        final double PROBABILITY_OF_ORC = 0.4;
        final double PROBABILITY_OF_HUMAN = 0.3;
        final double PROBABILITY_OF_HOBBIT = 0.25;
        final double PROBABILITY_OF_WIZARD = 0.05;


        /**
         * Really long winded method of implementing a probability based system, that generates actors
         * Currently rewriting a util Class to do the same thing, but as of Submission that is not prepared for
         * a release.
         */
        for (i = 0; i < quantityOfActors; i++) {
            Actor tempActor;
            double tempNum = Math.random();
            double tempCount = 0;
            if (tempNum <= PROBABILITY_OF_WIZARD) {
                tempActor = new Wizard();
                armyForces.add(tempActor);
            }
            tempCount += PROBABILITY_OF_WIZARD;
            if (tempNum > tempCount && tempNum <= tempCount + PROBABILITY_OF_ORC) {
                tempActor = new Orc();
                armyForces.add(tempActor);
            }
            tempCount += PROBABILITY_OF_ORC;
            if (tempNum > tempCount && tempNum <= tempCount + PROBABILITY_OF_HUMAN) {
                tempActor = new Human();
                armyForces.add(tempActor);
            }
            tempCount += PROBABILITY_OF_HUMAN;
            if (tempNum > tempCount && tempNum <= tempCount + PROBABILITY_OF_HOBBIT) {
                tempActor = new Hobbit();
                armyForces.add(tempActor);
            }
        }
    }

    /**
     * Allows editing of Actor object at specified index.
     * @param indexOfActorToEdit
     */
    public void edit(int indexOfActorToEdit){
        Actor tempActor;
        tempActor=armyForces.get(indexOfActorToEdit);
        tempActor.inputAllFields();
        armyForces.set(indexOfActorToEdit, tempActor);
    }

    /**
     * Display each Actor to console (via toString)
     */
    public void display(){
        System.out.printf("Displaying %s's Forces", this.getArmyName());
        for (Actor iActor : armyForces) {
            System.out.println(iActor);
        }
    }

    /**
     * @return Returns the ArrayList object of the Army's Actor's
     */
    public ArrayList<Actor> getArmyForces() {
        return armyForces;
    }

    /**
     * @return Returns the String representation of the Army
     */
    public String getArmyName() {
        return armyName;
    }

    /**
     * Allows for the Army's forces to be reassigned to another ArrayList, it is however unlikely to be implemented.
     *
     * @param armyForces
     */
    public void setArmyForces(ArrayList<Actor> armyForces) {
        this.armyForces = armyForces;
    }

    /**
     * Simple method to assign the respective Army's name
     *
     * @param armyName
     */
    public void setArmyName(String armyName) {
        this.armyName = armyName;
    }

}

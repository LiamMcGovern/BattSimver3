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
     * @param armyName
     */
    public Army(String armyName){
        this.armyName = armyName;
        armyForces = new ArrayList<Actor>();
    }

    public Army(String armyName, int quantityOfActors){
        this.armyName = armyName;
        armyForces = new ArrayList<Actor>(quantityOfActors);
    }

    public void fillArmy(int quantityOfActors){
        //Probabilities
        final double PROBABILITY_OF_ORC = 0.4;
        final double PROBABILITY_OF_HUMAN = 0.3;
        final double PROBABILITY_OF_HOBBIT = 0.25;
        final double PROBABILITY_OF_WIZARD = 0.05;


        /**
         * Really long winded method of
         */
        for (i=0;i<quantityOfActors;i++){
            Actor tempActor;
            double tempNum = Math.random();
            double tempCount=0;
            if (tempNum <= PROBABILITY_OF_WIZARD) { tempActor = new Wizard(); armyForces.add(tempActor); }
            tempCount+=PROBABILITY_OF_WIZARD;
            if (tempNum > tempCount && tempNum <= tempCount + PROBABILITY_OF_ORC) { tempActor = new Orc(); armyForces.add(tempActor);}
            tempCount+=PROBABILITY_OF_ORC;
            if (tempNum > tempCount && tempNum <= tempCount + PROBABILITY_OF_HUMAN) { tempActor = new Human(); armyForces.add(tempActor);}
            tempCount+=PROBABILITY_OF_HUMAN;
            if (tempNum > tempCount && tempNum <= tempCount + PROBABILITY_OF_HOBBIT) { tempActor = new Hobbit(); armyForces.add(tempActor);}
        }

    }

    /**
     *
     * @return Returns the ArrayList object of the Army's Actor's
     */
    public ArrayList<Actor> getArmyForces() {
        return armyForces;
    }

    /**
     *
     * @return Returns the String reprentation of the Army
     */
    public String getArmyName() {
        return armyName;
    }


    public void setArmyForces(ArrayList<Actor> armyForces) {
        this.armyForces = armyForces;
    }
    public void setArmyName(String armyName) {
        this.armyName = armyName;
    }

}

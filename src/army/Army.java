package army;

import actor.Actor;

import java.util.ArrayList;

/**
 * Created by Lenny on 2/26/14.
 */
public class Army {
    /**
     * sArmyName is Army a String representing the Army object's name.
     */
    private String sArmyName = "Unnamed Army";


    /**
     * armyForces will hold the 'Army' of Actor objects
     */
    private ArrayList<Actor> armyForces;

    /**
     * <b>Army</b> constructor takes String armyName and to set the Army's name.
     * @param armyName
     */
    public Army(String armyName){
        this.sArmyName = armyName;
        armyForces = new ArrayList<Actor>();
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
    public String getsArmyName() {
        return sArmyName;
    }


    public void setArmyForces(ArrayList<Actor> armyForces) {
        this.armyForces = armyForces;
    }
    public void setsArmyName(String sArmyName) {
        this.sArmyName = sArmyName;
    }

}

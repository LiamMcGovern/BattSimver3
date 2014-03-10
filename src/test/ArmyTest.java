package test;

import army.Army;
import util.Input;
import util.InputGUI;

import java.util.Scanner;

/**
 * Created by lvm on 3/9/14.
 */

/**
* Test program used to demonstrate the functionality of the <b>Army</b> objects methods.
*
* @author Liam McGovern
* @version Assignment 3, Object Oriented Programming.
*          Project:  BattleField Simulator
*          Lab Professor: David Houtman
*/
public class ArmyTest {

    public static void main(String[] args) {
        String firstArmyName = InputGUI.getString("Provide a name for the first Army");
        String secondArmyName = InputGUI.getString("Provide a name for the second Army");
        int armyCapacity;
        Army armyOne;
        Army armyTwo;


        boolean setCapacity = InputGUI.getBooleanGUI("Would you like to initialize them automagically with a predifined" +
                "quantity of actors?");
        if (setCapacity == true) {
            armyCapacity = InputGUI.getInt("Input the capacity <0-999>", 0, 999);
            //Create based on provided capacity.
            armyOne = new Army(firstArmyName, armyCapacity);
            armyTwo = new Army(secondArmyName, armyCapacity);
        } else { //Create and Populate
            //Create
            armyOne = new Army(firstArmyName);
            armyTwo = new Army(secondArmyName);
            //Populate
            armyOne.fillArmy(10);
            armyTwo.fillArmy(10);
        }


    }

}

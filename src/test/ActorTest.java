package test;

import actor.Actor;
import actor.Hobbit;
import actor.Wizard;

/**
 * Test program to demonstrate that each individual actor (either a hobbit or wizard) has unique modifiable attributes
 * that can be displayed to terminal with a call to either toString, or naturally without.
 *
 * @author Liam McGovern [Input and SingletonRandom Classes are used with permission from Rex Woolard]
 * @version Assignment 2, Object Oriented Programming.
 *          Project:  BattleField Simulator
 *          Lab Professor: David Houtman
 */
public class ActorTest {
    public static void main(String[] args) {
        //Don't require a1 large array, so a1 byte variable is adequate .
        final byte amountOfActors = 20;
        byte arrayIndex = 0;

        Actor[] arrayOfActors;//Create an array of references to Actor objects
        arrayOfActors = new Actor[amountOfActors]; //Define the array of Actors length to be 10.


        // Create a1 Wizard, and modify it's fields
        System.out.println("Test Wizard input");
        Actor wiz1 = new Wizard(); //Construct a1 Wizard
        System.out.println("Printing contents of UNmodified actor \n" + wiz1); //Print UNmodified Wizard.
        wiz1.inputAllFields(); //Change Hobbit.
        System.out.println("Printing contents of modified actor \n" + wiz1); //Print changed Wizard.
        //Place this actor into the arrayOfActors array

        // Create a1 Hobbit, and modify it's fields
        System.out.println("Test Hobbit input");
        Actor a1 = new Hobbit();//Construct a1 Hobbit
        System.out.println("Printing contents of UNmodified actor \n" + a1);//Print UNmodified Hobbit.
        a1.inputAllFields();//Change Hobbit.
        System.out.println("Printing contents of modified actor \n" + a1);//Print modified Hobbit.
        // END-Create a1 Hobbit, and modify it's fields

        // Create a second Wizard and Hobbit, and modify their fields, then display all actors
        System.out.println("Test and verify input of different Objects");
        a1 = new Wizard(); //Construct a Wizard and reuse the a1 pointer.
        Actor hob1 = new Hobbit();//Construct a Hobbit
        System.out.println("Printing contents of UNmodified actor \n" + a1 + "\n" + hob1); //Print UNmodified Actors.
        a1.inputAllFields(); //Change Hobbit.
        hob1.inputAllFields();//Change Wizard.
        System.out.println("Printing contents of modified actor \n" + a1 + "\n" + hob1); //Print changed Actors.
        // END-Create a second Wizard and Hobbit, and modify their fields, then display all actors

        //N.B. in order to test out subclass methods I used typecasting since we instantiated Actors instead of their
        //Subclass. ((SubclassName)objectOfSubclass).methodFromSubClass , is the format for this.

        //Test out modifications to Wizard boolean values, and the Wizard's set Methods
        System.out.println("Test and verify Wizard subclass set Methods");
        System.out.println("Printing contents of UNmodified actor \n" + wiz1);
        //We can efficiently test both set and get below, by combining them.
        ((Wizard) wiz1).setHasHorse(!((Wizard) wiz1).getHasHorse()); //Set's the value to opposite of it's current value.
        System.out.println("Printing contents of modified actor (Post changing hasHorse) \n" + wiz1); //Proof
        ((Wizard) wiz1).setHasStaff(!((Wizard) wiz1).getHasStaff()); //Set's the value to opposite of it's current value.
        System.out.println("Printing contents of UNmodified actor (Post changing hasStaff) \n" + wiz1); //Proof
        //END-Test out modifications to Wizard boolean values, and the Wizard's set Methods


        //Test out modifications to Hobbit stealth field.
        System.out.println("Test and verify Hobbit subclass set Methods");
        System.out.println("Printing contents of UNmodified actor \n" + hob1);
        ((Hobbit)hob1).setStealth(((Hobbit)hob1).getStealth() + 1); //Increases current Stealth by one.
        System.out.println("Printing contents of modified actor (Post changing stealth) \n" + hob1); //Proof
        //END-Test out modifications to Hobbit boolean values, and the Hobbit's set Methods

        //Place reference locations the previously created Actors into the arrayOfActors array.
        arrayOfActors[arrayIndex++] = wiz1;
        arrayOfActors[arrayIndex++] = a1;
        arrayOfActors[arrayIndex++] = hob1;
        //END-Place reference locations of each of the previously created Actors into the arrayOfActors array.

        //Populate the remaining elements in the array with Hobbits, leaving room for an additional 5 wizards.
        for (int i = arrayIndex; i < arrayOfActors.length - 5; i++) {
            arrayOfActors[i] = new Hobbit();
            arrayIndex++;
        }

        //Populate the last spots in the arrayOfActors array with Wizards.
        for (int i = arrayIndex; i < arrayOfActors.length; i++) {
            arrayOfActors[i] = new Wizard();
            arrayIndex++;
        }

        System.out.println("Printing all the actors");
        //Print to console the final actors.
        for (int i = 0; i < arrayOfActors.length-1; i++) {
            System.out.println(arrayOfActors[i]);
        }
        //END-Print to console the final actors.
    }
}
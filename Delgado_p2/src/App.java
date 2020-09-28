/*
Author: Andres Delgado
COP 3330
*/

import java.util.ArrayList;
import java.util.Scanner;


public class App {

    public static Scanner kb = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput()) {
            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);

            displayBmiInfo(bmi);
        }

        displayBmiStatistics(bmiData);
    }

    public static boolean moreInput(){
        String temp;
        System.out.print("\nInput new BMI? Y(yes) or N(no): ");
        temp = kb.nextLine();
        if(temp.equals("Y")){
            return true;
        }
        kb.close();
        return false;
    }

    public static double getUserHeight(){
        System.out.print("\nEnter height in inches: ");
        double temp = kb.nextDouble();
        kb.nextLine();
        while(temp <= 0){
            System.out.print("\nInvalid value. Enter a positive number: ");
            temp = kb.nextDouble();
            kb.nextLine();
        }
        return temp;
    }

    public static double getUserWeight(){
        System.out.print("\nEnter height in weight: ");
        double temp = kb.nextDouble();
        kb.nextLine();
        while(temp <= 0){
            System.out.print("\nInvalid value. Enter a positive number: ");
            temp = kb.nextDouble();
            kb.nextLine();
        }
        return temp;
    }

    public static void displayBmiInfo(BodyMassIndex bmi){
        System.out.println("\nUser BMI: "+bmi.bmiScore());
        System.out.println("\nBMI Category: "+bmi.bmiCategory());
    }

    public static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData){
        double avg = 0;
        for (BodyMassIndex bmiDatum : bmiData) {
            avg = avg + bmiDatum.bmiScore();
        }
        avg = avg/bmiData.size();
        System.out.println("\nAverage BMI: "+avg);
    }
}

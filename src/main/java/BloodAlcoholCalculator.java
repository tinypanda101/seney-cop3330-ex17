/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Ryan Seney
 */

import java.text.DecimalFormat;
import java.util.Scanner;

public class BloodAlcoholCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean isNumber = false;
        String gender;
        String ouncesOfAlcohol;
        String weight;
        String hoursSince;
        do {
            System.out.print("Enter a 1 if you are male or 2 if you are female. ");
            gender = scanner.next();
            isNumber = numberOrNot(gender);

        } while (isNumber == false);

        do {
            System.out.print("How many ounces of alcohol did you have? ");
            ouncesOfAlcohol = scanner.next();
            isNumber = numberOrNot(ouncesOfAlcohol);
        } while (isNumber == false);

        do {
            System.out.print("What is your weight in pounds? ");
            weight = scanner.next();
            isNumber = numberOrNot(weight);
        } while (isNumber == false);

        do {
            System.out.print("How many hours has it been since your last drink? ");
            hoursSince = scanner.next();
            isNumber = numberOrNot(hoursSince);
        }while (isNumber == false);

        double distributionRatio;

        int genderInt = Integer.parseInt(gender);
        double ouncesOfAlcoholDouble = Double.parseDouble(ouncesOfAlcohol);
        int weightInt = Integer.parseInt(weight);
        int hoursSinceInt = Integer.parseInt(hoursSince);

        if(genderInt == 1)
            distributionRatio = 0.73;
        else
            distributionRatio = 0.66;

        double bac = 0;

        bac = (ouncesOfAlcoholDouble * 5.14 / weightInt * distributionRatio) - 0.015 * hoursSinceInt;

        DecimalFormat df = new DecimalFormat("#.######");

        System.out.println("Your BAC is " + df.format(bac));
        System.out.println((bac > 0.08) ? "It is not legal for you to drive": "It is legal for you to drive");
    }

    public static boolean numberOrNot(String input){

        try
        {
            Integer.parseInt(input);

        }
        catch(NumberFormatException ex)
        {
            return false;
        }
        return true;
    }
}

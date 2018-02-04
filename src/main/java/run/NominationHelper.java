package run;

import awards.Award;
import checks.LimitChecker;
import employees.Person;
import nominators.Nominator;
import nominees.Nominee;

import java.util.*;

/**
 * Created by Aleh_Hutyrchyk on 1/9/2018.
 */

public class NominationHelper {

    /**
     * Prints awards from List
     * @param awards - award
     * @param type - award type
     */
    public void printAwards(List<Award> awards, String type) {
        System.out.println("LIST 'awards' with exact 'type' output");
        for (Award bonus : awards ) {
            if(null != bonus.getType() && bonus.getType().equals(type)) {
                System.out.println(bonus);
            }
        }
    }

    /**
     * Prints awards from Set with exact 'type'
     * @param awards - awards set
     * @param type - award type
     */
    public void printAwards2(HashSet<Award> awards, String type) {
        System.out.println("\n" + "SET 'awards' with exact 'type' output");
        for (Award bonus : awards ) {
            if(bonus.getType() == type) {System.out.println(bonus);}
        }
    }

    /**
     * Prints awards from Set with unique types
     * @param awards - awards set
     */
    public void printAwards3(HashSet<Award> awards) {
        System.out.println("SET 'awards' with unique types output");
        for (Award bonus : awards ) {
            System.out.println(bonus);
        }
    }

    /**
     * Prints awards from Set with unique types
     * @param set1 - awards set
     */
    public void printAwardsSet(HashSet<Award> set1) {
        System.out.println("SET 'set1' with unique types output");
        for (Award bonus : set1 ) {
            System.out.println(bonus);
        }
    }





    /**
     * Gives award to nominee after limits verification for nominator and nominee;
     * increases nominatorAwardQuantity and nominatorAwardAmount if nomination was successful
     * @param nominee - nominee
     * @param award - award
     * @param checker - limit checker for nominator/nominee
     */

    public void nominate(Nominator nominator, Nominee nominee, Award award, LimitChecker checker) {
        //System.out.println(nominee1.getName() + " received " + award1.getValue() + " $ award" + "\n");
        if (checker.canNominate(nominator, nominee, award)) {
            this.receiveAward(award, nominee);
            nominator.setNominatorAwardQuantity(nominator.getNominatorAwardQuantity() + 1);   //nominatorAwardQuantity++;
            nominator.setNominatorAwardAmount(nominator.getNominatorAwardAmount() + award.getValue());  //nominatorAwardAmount = nominatorAwardAmount + award.getValue();
        } else {
            System.out.println("Vtopku! No more awards!!!");
        }
    }

    /**
     * Allows nominee receive award; if award contains SOLI - performs award value recalculation;
     * awards without SOLI - recalculation with special formula; increases nomineeAwardSum and nomineeAwardQuantity
     * @param award - award
     * @param nominee - nominee
     */

    public void receiveAward(Award award, Nominee nominee) {
        double p = award.getValue();
        Random random = new Random();
        double c = Math.random();
        int z = random.nextInt(10);

        if (award.getSoli() > 0) {
            //calculation for SOLI
            double newValue;
            newValue = award.getValue() + (award.getValue() * award.getSoli() / 100);
            nominee.setNomineeAwardSum(nominee.getNomineeAwardSum() + newValue);  //= nomineeAwardSum + newValue;
            nominee.setNomineeAwardQuantity(nominee.getNomineeAwardQuantity() + 1);  //nomineeAwardQuantity++;
            System.out.printf("New Recalculated award = %s. " + " SOLI value = %s\n", newValue, award.getSoli());
        } else {

            nominee.setNomineeAwardSum(nominee.getNomineeAwardSum() + award.getValue()); //this.nomineeAwardSum += award.getValue(); // this.nomineeAwardSum = nomineeAwardSum + award.getValue(); - оператор присваивания
            nominee.setNomineeAwardQuantity(nominee.getNomineeAwardQuantity() + 1); //nomineeAwardQuantity++;
            nominee.setPopulation(nominee.getPopulation() + 1);  //population++;

            if(nominee.getQuantity() == 0) {

                System.out.println("New " + p + " award received. No SOLI recalculation.");
                //System.out.println("population " + population);
                nominee.setQuantity(calculateQuantity(z, p, c, nominee));  //quantity = calculateQuantity(z, p, c);
                //System.out.println("calculatedQuantity " + quantity);
            }else {
                System.out.println("New " + p + " award received. No SOLI recalculation.");
                nominee.setQuantity(calculateQuantity(z, p, c, nominee));  //quantity2 = calculateQuantity(z, p, c);
                //System.out.println("calculatedQuantity " + quantity2);
            }


        }


    }

    /**
     * Recalculates awards without SOLI
     * @param z - random whole number
     * @param p - award value
     * @param c - random decimal, e.g. 5% = 0,05
     * @param nominee - nominee
     * @return - recalculated award value
     */
    private double calculateQuantity(int z, double p, double c, Nominee nominee) {
        double a = Math.pow(z, 2) * (p) * (1 - p) / Math.pow(c, 2);
        return a / (1 + ((a - 1) / nominee.getPopulation()));
    }
}

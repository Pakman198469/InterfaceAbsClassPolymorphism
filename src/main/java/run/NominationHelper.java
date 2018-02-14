package run;

import awards.Award;
import checks.LimitChecker;
import checks.MyCheckedException;
import nominators.Nominator;
import nominees.Nominee;

import java.util.*;

/**
 * Class contains important methods: nominate, receiveAward and calculateQuantity;
 * Contains several methods for printing out awards from List, Set, Map.
 * @author Aleh_Hutyrchyk
 */

public class NominationHelper {

    /**
     * Prints awards from List with specific 'type'
     * @param awards - award
     * @param type - specified award type
     */
    public void printAwards(List<Award> awards, String type) {
        System.out.println("LIST 'awards' with specific 'type' output");
        for (Award bonus : awards ) {
            if(null != bonus.getType() && bonus.getType().equals(type)) {
                System.out.println(bonus);
            }
        }
    }

    /**
     * Prints out award with exact 'type' from Set
     * Throws exception if award type = "Ordnung"
     * @param awards - awards set
     * @param type - award type
     */
    public void printAwards2(HashSet<Award> awards, String type) throws MyCheckedException {
        System.out.println("\n" + "SET 'awards' with exact 'type' output");
        for (Award bonus : awards ) {
            if(bonus.getType() == type) {
                System.out.println(bonus);
                if(bonus.getType().equals("Ordnung")) {
                throw new MyCheckedException("Ordnung EXCEPTION!!!!!!!!!!!"); }
            }
        }
    }

    /**
     * Prints awards from List with unique type which was reached by converting List to Set.
     * @param awards - awards in list
     */
    public void printAwardsTypes(List<Award> awards) {
        System.out.println("\n" + "LIST 'awards' with unique 'type' output");
        Set<String> types = new HashSet<>();
        for (Award bonus : awards ) {
            types.add(bonus.getType());
        }
        System.out.println(types);
    }

    /**
     * Prints awards from Set with unique types
     * @param awards - awards set
     */
    public void printAwards3(HashSet<Award> awards){
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
     * Method prints out entire Map.
     * @param mapa - our custom map.
     */
    public void printMap(Map<Award, Nominee > mapa) {
        for(Map.Entry<Award, Nominee> entry: mapa.entrySet()) {
                System.out.println("Key: " + entry.getKey() + " " + "Value: " + entry.getValue());
        }
    }

    /**
     * Method prints out entire Map and throws exception if it contains award with unsupported type.
     * @param mapa - our custom Map.
     * @param type - unsupported award type should be passed here.
     * @throws MyCheckedException - if contains unsupported award type.
     */
    public void analyze2(Map<Award, Nominee > mapa, String type) throws MyCheckedException {
        System.out.println("Map contains following award types:");
        for(Award award : mapa.keySet()) {
            Set<String> types = new HashSet<>();
            types.add(award.getType());
            if(type.equals(award.getType())) {
                throw new MyCheckedException("Unsupported award TYPE !!!!!!!");
            }
            System.out.println(types);
        }
    }



    /**
     * Gives award to nominee after limits verification for nominator and nominee;
     * increases nominatorAwardQuantity and nominatorAwardAmount if nomination was successful;
     * throws NullPointerException if award type = NULL.
     * @param nominee - nominee
     * @param award - award
     * @param checker - limit checker for nominator/nominee
     */
    public void nominate(Nominator nominator, Nominee nominee, Award award, LimitChecker checker) throws NullPointerException {
        if (checker.canNominate(nominator, nominee, award)) {
            //if(award.getType() == null){ throw new NullPointerException("Award type can't be NULL during nomination!!!"); }
            this.receiveAward(award, nominee);
            nominator.setNominatorAwardQuantity(nominator.getNominatorAwardQuantity() + 1);
            nominator.setNominatorAwardAmount(nominator.getNominatorAwardAmount() + award.getValue());
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
            nominee.setNomineeAwardSum(nominee.getNomineeAwardSum() + newValue);
            nominee.setNomineeAwardQuantity(nominee.getNomineeAwardQuantity() + 1);
            System.out.printf("New Recalculated award = %s. " + " SOLI value = %s\n", newValue, award.getSoli());
        } else {
            nominee.setNomineeAwardSum(nominee.getNomineeAwardSum() + award.getValue());
            nominee.setNomineeAwardQuantity(nominee.getNomineeAwardQuantity() + 1);
            nominee.setPopulation(nominee.getPopulation() + 1);
            if(nominee.getQuantity() == 0) {
                System.out.println("New " + p + " award received. No SOLI recalculation.");
                nominee.setQuantity(calculateQuantity(z, p, c, nominee));
            }else {
                System.out.println("New " + p + " award received. No SOLI recalculation.");
                nominee.setQuantity(calculateQuantity(z, p, c, nominee));
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

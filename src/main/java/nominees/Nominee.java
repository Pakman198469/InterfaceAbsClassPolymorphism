package nominees;

import awards.Award;
import java.util.Random;

/**
 * Created by Aleh_Hutyrchyk on 12/14/2017.
 */
public class Nominee {
    static{
        System.out.println("Nominee initialized");
    }

    private String name;
    private double awardSum;
    private double quantity;
    private double quantity2;
    private int population;
    private boolean found = true;



    public Nominee(String name, int awardSum) {
        this.name = name;
        this.awardSum = awardSum;
    }

    public String getName() {
        return name;
    }

    public double getAwardSum() {
        return awardSum;
    }

    public void receiveAward(Award award) {
        double p = award.getValue();
        Random random = new Random();
        double c = Math.random();
        int z = random.nextInt(10);


        if (award.getSoli() > 0) {
            //calculation for SOLI
            double newValue;
            newValue = award.getValue() + (award.getValue() * award.getSoli() / 100);
            this.awardSum = awardSum + newValue;
            System.out.printf("New Recalculated award = %s. " + " SOLI value = %s\n", newValue, award.getSoli());
        } else {

            this.awardSum = awardSum + award.getValue();
            population++;

            if(quantity == 0) {

                System.out.println("New " + p + " award received. No SOLI recalculation.");
                //System.out.println("population " + population);
                quantity = calculateQuantity(z, p, c);
                System.out.println("calculatedQuantity " + quantity);
            }else {
                quantity2 = calculateQuantity(z, p, c);
                System.out.println("calculatedQuantity " + quantity2);
            }


        }

        if(quantity != 0 && quantity2 !=0) {
            System.out.println("Two non-soli awards received.");
            found = false;
        }else {
            System.out.println("Not enough awards to compare.");
        }

        if(quantity <= quantity2 || quantity < 1) {
            System.out.println("quantity is very low.");
        }

        if(!found) {
            System.out.println("brrrrrr. What a pain!");
        }

    }

    private double calculateQuantity(int z, double p, double c) {
        return ((Math.pow(z, 2) * (p) * (1 - p)) / (Math.pow(c, 2))) / (1 + ((((Math.pow(z, 2) * (p) * (1 - p)) / (Math.pow(c, 2))) - 1) / population));
    }

}

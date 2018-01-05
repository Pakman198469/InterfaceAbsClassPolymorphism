package checks;

import awards.Award;
import nominators.Nominator;
import nominees.Nominee;

/**
 * Checks limits of awards for nominee and nominator
 * @author Aleh_Hutyrchyk
 * @version 1.2
 * @since 28.12.2017
 */
public class LimitChecker {

    /**
     * Verifies if nominator/nominee can give/receive awards by comparing nominatorAwardQuantity/nominatorAwardQuantityLimit,
     * nominatorAwardAmount/nominatorAwardAmountLimit, nomineeAwardQuantity/nomineeAwardQuantityLimit, nomineeAwardSum/awardSumLimit;
     * @param nominator - nominator
     * @param nominee - nominee
     * @param award - award
     * @return - <code>true</code> - nominator/nominee can give/receive awards<br />
     *           {@code false} - nominator/nominee can not give/receive awards
     */
    public boolean canNominate(Nominator nominator, Nominee nominee, Award award){

        if(nominator.getNominatorAwardQuantity() >= nominator.getNominatorAwardQuantityLimit()) {
            System.out.println(nominator.getName() + " reached QuantityLimit");
            switch (nominator.getNominatorAwardQuantity()) {
                case 1 :
                    System.out.println(" of 1 award");
                    break;
                case 2:
                    System.out.println(" of 2 awards");
                    break;
                case 3:
                    System.out.println(" of 3 awards");
                    break;
                    default:
                        System.out.println(" Too many awards were given.");
                        break;
            }
            return false;
        }else if (nominator.getNominatorAwardAmount() >= nominator.getNominatorAwardAmountLimit() || nominator.getNominatorAwardAmountLimit() < nominator.getNominatorAwardAmount() + award.getValue()) {
            System.out.println(nominator.getName() + " reached AmountLimit.");

            while (nominator.getNominatorAwardAmount() >= 0) {
                System.out.println("Limit is " + nominator.getNominatorAwardAmountLimit() + " EUR");
                break;
            }
            return false;
        }else if (nominee.getNomineeAwardQuantity() >= nominee.getNomineeAwardQuantityLimit()) {

            do{
                System.out.println("OLOLO");
            } while (false);

            System.out.println(nominee.getName() + " reached NomineeQuantityLimit of " + nominee.getNomineeAwardQuantity() + " awards.");
            return false;
        }else if (nominee.getNomineeAwardSum() >= nominee.getAwardSumLimit() || nominee.getAwardSumLimit() < nominee.getNomineeAwardSum() + award.getValue()) {
            System.out.println(nominee.getName() + " reached NomineeSumLimit of " + nominee.getNomineeAwardSum() + " EUR");
            return false;
        }

        return true;
    }
}

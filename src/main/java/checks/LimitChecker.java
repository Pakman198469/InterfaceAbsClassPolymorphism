package checks;

import awards.Award;
import nominators.Nominator;
import nominees.Nominee;

public class LimitChecker {

    public boolean canNominate(Nominator nominator, Nominee nominee, Award award){

        if(nominator.getNominatorAwardQuantity() >= nominator.getNominatorAwardQuantityLimit()) {
            System.out.println();
            return false;
        }else if (nominator.getNominatorAwardAmount() >= nominator.getNominatorAwardAmountLimit() || nominator.getNominatorAwardAmountLimit() <= nominator.getNominatorAwardAmount() + award.getValue()) {
            System.out.println();
            return false;
        }else if (nominee.getNomineeAwardQuantity() >= nominee.getNomineeAwardQuantityLimit()) {
            System.out.println();
            return false;
        }else if (nominee.getNomineeAwardSum() >= nominee.getAwardSumLimit() || nominee.getAwardSumLimit() <= nominee.getNomineeAwardSum() + award.getValue()) {}

        return true;
    }
}

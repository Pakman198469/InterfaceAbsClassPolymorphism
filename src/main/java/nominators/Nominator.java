package nominators;

import awards.Award;
import nominees.Nominee;

/**
 * Created by Aleh_Hutyrchyk on 12/14/2017.
 */
public class Nominator {
    static{
        System.out.println("Nominator initialized \n");
    }

    private String name;

    public Nominator(String name) {
        this.name = name;
    }

    public void nominate(Nominee nominee, Award award) {
        //System.out.println(nominee1.getName() + " received " + award1.getValue() + " $ award" + "\n");
        nominee.receiveAward(award);

    }

}

package run;

import awards.Award;
import checks.LimitChecker;
import nominators.Nominator;
import nominees.Nominee;



/**
 * Created by Aleh_Hutyrchyk on 12/14/2017.
 */
public class Runner {
    public static void main(String[] args) {
        Award award1 = new Award(100);
        Award award2 = new Award(20,50);
        Award award3 = new Award(80,90);
        Nominee nominee1 = new Nominee("Great Emperor", 110, 3);
        Nominee nominee2 = new Nominee("Gogi", 300,1);
        Nominee nominee3 = new Nominee("Raschid", 100,0);
        Nominator nominator1 = new Nominator("Great Nominator", 8, 300);
        LimitChecker checker = new LimitChecker();


        nominator1.nominate(nominee1, award1, checker);
        nominator1.nominate(nominee1, award1, checker);
        System.out.println(nominee1.getName() + "'s award balance = " + nominee1.getNomineeAwardSum() + "\n");

        nominator1.nominate(nominee2, award1, checker);
        nominator1.nominate(nominee2, award3, checker);
        System.out.println(nominee2.getName() + "'s award balance = " + nominee2.getNomineeAwardSum() + "\n");

        nominator1.nominate(nominee3, award2, checker);
        nominator1.nominate(nominee3, award3, checker);
        System.out.println(nominee3.getName() + "'s award balance = " + nominee3.getNomineeAwardSum() + "\n");

    }

}

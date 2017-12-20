package run;

import awards.Award;
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
        Nominee nominee1 = new Nominee("Great Emperor", 0);
        Nominee nominee2 = new Nominee("Gogi", 0);
        Nominee nominee3 = new Nominee("Raschid", 0);
        Nominator nominator1 = new Nominator("Great Nominator");


        nominator1.nominate(nominee1, award1);
        nominator1.nominate(nominee1, award1);
        System.out.println(nominee1.getName() + "'s award balance = " + nominee1.getAwardSum() + "\n");

        nominator1.nominate(nominee2, award1);
        nominator1.nominate(nominee2, award3);
        System.out.println(nominee2.getName() + "'s award balance = " + nominee2.getAwardSum() + "\n");

        nominator1.nominate(nominee3, award2);
        nominator1.nominate(nominee3, award3);
        System.out.println(nominee3.getName() + "'s award balance = " + nominee3.getAwardSum() + "\n");

    }

}

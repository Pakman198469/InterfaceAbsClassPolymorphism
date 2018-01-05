package run;

import awards.Award;
import checks.LimitChecker;
import nominators.Nominator;
import nominees.Nominee;



/**
 * Creates new objects and performs actions on them (e.g.: give awards)
 * @author Aleh_Hutyrchyk
 */
public class Runner {
    public static void main(String[] args) {
        Award award1 = new Award(100);
        Award award2 = new Award(20,50);
        Award award3 = new Award(80,90);
        Nominee nominee1 = new Nominee("Great Emperor", 1000, 5);
        Nominee nominee2 = new Nominee("Gogi", 300,3);
        Nominee nominee3 = new Nominee("Raschid", 100,1);
        Nominator nominator1 = new Nominator("Great Nominator", 30, 1000);
        LimitChecker checker = new LimitChecker();


        /*
          Give award N times and multiply award value to index value each time it is given
         */
        for (int i = 0; i < 10; i++) {
            Award award8 = new Award(200 * i);
            nominator1.nominate(nominee1, award8, checker);
        }


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

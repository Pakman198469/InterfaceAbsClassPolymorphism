package run;

import awards.Award;
import checks.LimitChecker;
import employees.Person;
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
        Person person1 = new Nominee("Great Emperor", 1000, 5);
        Nominee nominee1 = null;
        if (person1 instanceof Nominee) {
            nominee1 = (Nominee) person1;
        }
        Person person2 = new Nominee("Gogi", 300,3);
        Nominee nominee2 = null;
        if (person2 instanceof Nominee) {
            nominee2 = (Nominee) person2;
        }
        Person person3 = new Nominee("Raschid", 100,1);
        Nominee nominee3 = null;
        if (person3 instanceof Nominee) {
            nominee3 = (Nominee) person3;
        }
        Person person4 = new Nominator("Great Nominator", 30, 1000);
        Nominator nominator1 = null;
        if (person4 instanceof Nominator) {
            nominator1 = (Nominator) person4;
        }
        Person person5 = new Nominator("Extended nominator", 25, 3, "IT", 20, 500);
        Nominator nominator2 = null;
        if (person5 instanceof Nominator) {
            nominator2 = (Nominator) person5;
        }
        LimitChecker checker = new LimitChecker();
        NominationHelper helper = new NominationHelper();


        /*
          Give award N times and multiply award value to index value each time it is given
         */
        for (int i = 0; i < 10; i++) {
            Award award8 = new Award(200 * i);
            helper.nominate(nominator1,nominee1,award8,checker);
        }

        helper.nominate(nominator1,nominee1,award1,checker);
        helper.nominate(nominator1,nominee1, award1, checker);
        System.out.println(nominee1.getName() + "'s award balance = " + nominee1.getNomineeAwardSum() + "\n");

        helper.nominate(nominator1,nominee2, award1, checker);
        helper.nominate(nominator1,nominee2, award3, checker);
        System.out.println(nominee2.getName() + "'s award balance = " + nominee2.getNomineeAwardSum() + "\n");

        helper.nominate(nominator1,nominee3, award2, checker);
        helper.nominate(nominator1,nominee3, award3, checker);
        System.out.println(nominee3.getName() + "'s award balance = " + nominee3.getNomineeAwardSum() + "\n");

        System.out.println(nominator1.toString());
        System.out.println(nominator2);
        System.out.println(nominee1);
    }

}

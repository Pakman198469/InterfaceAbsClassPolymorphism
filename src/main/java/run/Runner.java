package run;

import awards.Award;
import checks.LimitChecker;
import checks.MyCheckedException;
import employees.Person;
import nominators.Nominator;
import nominees.Nominee;

import java.util.*;


/**
 * Creates new objects and performs actions on them (e.g.: give awards)
 * @author Aleh_Hutyrchyk
 */
public class Runner {

    public static void main(String[] args) throws MyCheckedException {
        Award award1 = new Award(10, 42, "OMG");
        Award award2 = new Award(20,50);
        Award award3 = new Award(80,90);
        Award award4 = new Award(20, 42, "OMG");
        Award award5 = new Award(30, 42, "OMG");
        Award award6 = new Award(30, 42, "OMG");
        Award award7 = new Award(100, 42, "OMG1");
        Award award8 = new Award(100);
        Award award9 = new Award(100, 42, "WTF");
        Award award10 = new Award(100, 42, "WTF1");
        Award award11 = new Award(100, 42, "WTF2");
        Award award12 = new Award(100, 42, "WTF3");
        Award award13 = new Award(100, 42, "WTF4");
        Award award14 = new Award(100, 42, "OMG");
        Award award15 = new Award(100, 42, "Ordnung");
        Award award16 = new Award(100, 42, "Muss");
        Award award17 = new Award(100, 42, "Sein!");

        /**
         * Casting - it's you telling the compiler that an Object of type A is actually
         * of more specific type B, and thus gaining access to all the methods on B that
         * you wouldn't have had otherwise.
         */
        Person person1 = new Nominee("Great Emperor", 1000, 5);
        Nominee nominee1 = (Nominee) person1; //casting

        Person person2 = new Nominee("Gogi", 300,3);
        Nominee nominee2 = (Nominee) person2;

        Person person3 = new Nominee("Raschid", 100,1);
        Nominee  nominee3 = (Nominee) person3;

        /**
         * instanceof is a keyword that is used for checking if a reference variable is
         * containing a given type of object reference or not.
         * When we do typecasting, it is always a good idea to check if the typecasting
         * is valid or not. instanceof helps use here. We can always first check for validity
         * using instanceof, then do typecasting.
         */
        Person person4 = new Nominator("Great Nominator", 30, 1000);
        Nominator nominator1 = null;
        //if (person4 instanceof Nominator) {
            nominator1 = (Nominator) person4;
        //}
        Person person5 = new Nominator("Extended nominator", 25, 3, "IT", 20, 500);
        Nominator nominator2 = null;
        //if (person5 instanceof Nominator) {
            nominator2 = (Nominator) person5;
       //}
        LimitChecker checker = new LimitChecker();
        NominationHelper helper = new NominationHelper();


        List<Award> awards = new ArrayList<Award>();
        awards.add(award1);
        awards.add(award4);
        awards.add(award5);
        awards.add(award6);
        awards.add(award7);
        awards.add(award8);
        awards.add(award9);
        awards.add(award10);
        awards.add(award11);
        awards.add(award12);
        awards.add(award13);
        awards.add(award14);
        awards.add(award15);
        awards.add(award16);
        awards.add(award17);


        /*for (Object bonus : awards ) {
            System.out.println(bonus);

        }*/

        //several awards of exact type
        System.out.println("==========================================================");
        helper.printAwardsTypes(awards);
        helper.printAwards(awards , "OMG");
        System.out.println("==========================================================");

        Set<Award> set1 = new HashSet<>();
        set1.add(award1);
        set1.add(award4);
        set1.add(award5);
        set1.add(award6);
        set1.add(award7);
        set1.add(award8);
        set1.add(award9);
        set1.add(award10);
        set1.add(award11);
        set1.add(award12);
        set1.add(award13);
        set1.add(award14);
        set1.add(award15);
        set1.add(award16);
        set1.add(award17);
        //only unique awards (one time in set)
        helper.printAwardsSet((HashSet<Award>) set1);

        System.out.println("==========================================================");
        Set<Award> set = new HashSet<>(awards);
        //helper.printAwards3((HashSet<Award>) set);

        //awards of exact type from SET
        try {
            helper.printAwards2((HashSet<Award>) set, "WTF");
        } catch (MyCheckedException e) {
            e.printStackTrace();
        }


        System.out.println("==========================================================");

        Map<Award, Nominee > mapa = new HashMap();
        mapa.put(award1,nominee1);
        mapa.put(award2,nominee1);
        mapa.put(award1,nominee3);
        mapa.put(award15,nominee2);

        System.out.println(mapa.size());
        /*System.out.println(mapa);
        System.out.println(Arrays.asList(mapa));
        System.out.println(Collections.singletonList(mapa));*/

        /**
         * entrySet usage
         * Map.Entry - describe key/value pare
         * entrySet() - method is used to get Set view of the mappings contained in this map
         */
        for(Map.Entry<Award, Nominee> entry: mapa.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " " + "Value: " + entry.getValue());
        }

        helper.analyze2(mapa,"type" );

        System.out.println("==========================================================");


        /**
         *Give award N times and multiply award value to index value each time it is given
         */
        for (int i = 0; i < 10; i++) {
            award8 = new Award(200 * i);
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
        System.out.println(nominator1.toString(false));
    }

}

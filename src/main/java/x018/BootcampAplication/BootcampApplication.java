package x018.BootcampAplication;

import java.util.Scanner;

public class BootcampApplication {
    static String[] bootcampList = bootcampTypeList();
    static Bootcamp[] bootcamps = instantionOfBootcamps(bootcampList);

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to Bootcamp Application page! ");
        Bootcamp java = new Bootcamp(bootcampList[0], "11.12.2018", "10.01.2019");
        System.out.println("You can apply to these specifications: ");
        for (String r : bootcampTypeList()) {
            System.out.print(r + " ");
        }
        entry(scan);

//        System.out.println("Print out all bootcampers");
//        bootcampParticipantOut();
    }

    public static void entry(Scanner scan) {
        System.out.println("");
        System.out.println("Enter your name: ");
        String name = scan.next();
        System.out.println("Enter your bootcamp type: ");
        String bootcampType = scan.next();
        System.out.println("Your name is " + name + ", and you choose " + bootcampType);
        addPatricipant(bootcampType, name);
    }

    public static void bootcampParticipantOut() {
        for (int i = 0; i < bootcamps.length; i++) {
            System.out.println(bootcamps[i].getType());
            for (int j = 0; j < bootcamps[i].getParticipantName().length; j++) {
                System.out.println(bootcamps[i].getParticipantName()[j]);
            }
        }
    }

    public static String[] bootcampTypeList() {
        String[] bootcampTypes = {"Java", "Test Automation", "DevOps", "CRM" , "yo yo yo"};
        return bootcampTypes;
    }

    public static Bootcamp[] instantionOfBootcamps(String[] bootcampList) {
        Bootcamp[] bootcamps = new Bootcamp[bootcampList.length];
        for (int i = 0; i < bootcampList.length; i++) {
            Bootcamp bootcamp = new Bootcamp(bootcampList[i], "11.10", "01.01");
            bootcamps[i] = bootcamp;
        }
        return bootcamps;
    }

    public static void addPatricipant(String bootcampType, String name){
        System.out.println("this is bootcamps lengths - " + bootcamps.length);
        boolean assignToBootcamp = false;
        for (int i = 0; i <bootcamps.length; i++) {

            if(bootcamps[i].getType().equals(bootcampType)) {
                String[] names = {name};
                bootcamps[i].setParticipantName(names);
                System.out.println("You joined the bootcamp!");
                assignToBootcamp = true;
            }
            if(i == bootcamps.length-1 && assignToBootcamp == false) {
                System.out.println("Sorry, we dont have such bootcamp!");
            }

        }
    }
}


//        switch (bootcampType) {
//            case "JV": System.out.print(" Java"); break;
//            case "TA": System.out.print(" Test Automation"); break;
//            case "DO": System.out.print(" DevOps"); break;
//            case "CRM": System.out.print(" CRM"); break;
//        }


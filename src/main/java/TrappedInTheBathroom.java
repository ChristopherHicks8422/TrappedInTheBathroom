import java.util.*;

public class TrappedInTheBathroom {
    private static Locations currentLocation;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeLocations();
        showLocation();

        while (true) {
            String command = scanner.nextLine().toUpperCase();
            if (command.equals("QUIT")) {
                break;
            }
            processCommand(command);
        }

        System.out.println("Thanks for playing!");
    }



    private static void initializeLocations() {
        Locations l1 = new Locations("Toilet", "********************\nThis is the toilet\n" +
                "If it couldn't flush that it won't flush you\nFind another way out!\n**********************");
        Locations l2 = new Locations("Bathtub", "*******************\nI guess you could hide" +
                "here\nand close the shower curtain...\nBut thanks to 80's movies I always check there for monsters\n" +
                "You have to get out of here.\n*********************");
        Locations l3 = new Locations("Bathroom Door", "********************\nThrough the dense fog" +
                "(What did you eat?!)\nyou locate the bathroom door but the knob won't turn\nHow long have you been" +
                "trapped in here?\nIs this even your bathroom?");

        l1.addExit(new Exits(Exits.NORTH, l2));
        l1.addExit(new Exits(Exits.EAST, l3));
        l2.addExit(new Exits(Exits.SOUTH, l1));
        l3.addExit(new Exits(Exits.WEST, l1));

        currentLocation = l1;
    }

    private static void showLocation() {
        System.out.println("\n" + currentLocation.getRoomTitle() + "\n");
        System.out.println(currentLocation.getDescription() + "\n");

        System.out.println("Available directions : ");
        for (Enumeration e = currentLocation.getExits().elements(); e.hasMoreElements();) {
            Exits an_exit = (Exits) e.nextElement();
            System.out.println(an_exit);
        }
    }

    private static void processCommand(String command) {
        for (Enumeration e = currentLocation.getExits().elements(); e.hasMoreElements();) {
            Exits an_exit = (Exits) e.nextElement();

            if (an_exit.getDirectionName().compareTo(command) == 0 || an_exit.getShortDirectionName().compareTo(command) == 0) {
                currentLocation = an_exit.getLeadsTo();
                showLocation();
                return;
            }
        }

        System.out.println("\nHuh? Invalid direction!");
    }
}
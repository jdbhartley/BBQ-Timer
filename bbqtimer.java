import java.util.Scanner;

//This class is the object that represents out meat
class Meat {
    private double timeToCook;  //Time required to cook meat
    private String name;        //Name of the meat

    //Constructor
    Meat(String nm, double ttc) {
        name = nm;
        timeToCook = ttc;
    }

    //Returns name of meat
    String getName() {
        return name;
    }

    //This is the timer method.
    void MeatTimer() {
        try {
                System.out.println("Starting timer for " + name);
                for (double seconds = timeToCook*60; seconds > 0; seconds--) {
                    System.out.println("Time remaining: " + (int)seconds/60 + " minutes and " + (int)seconds%60 + " seconds");
                    Thread.sleep(1000);
                }
            }
            catch (InterruptedException ex) {
                System.out.println("An exception has occured");
            }
    }

    //Second timer method taking in a seconds parameter
    void MeatTimer(int sec) {
        try {
                System.out.println("Starting timer for " + name);
                for (double seconds = sec; seconds > 0; seconds--) {
                    System.out.println("Time remaining: " + (int)seconds/60 + " minutes and " + (int)seconds%60 + " seconds");
                    Thread.sleep(1000);
                }
            }
            catch (InterruptedException ex) {
                System.out.println("An exception has occured");
            }
    }
}

//Start of the program and driver class
class BBQTimer {
    public static void main(String args[]) {
        //Create our scanner for input
        Scanner input = new Scanner(System.in);
        int in = -1;

        //Define the meats and their properties
        Meat newyorkstrip = new Meat("New York Strip", 11.5);
        Meat ribeye = new Meat("Ribeye", 8.5);
        Meat porterhouse = new Meat("Porterhouse", 8.5);
        Meat flanksteak = new Meat("Flank Steak", 15);
        Meat porkchops = new Meat("Pork Chops", 12.5);
        Meat chickenbreast = new Meat("Chicken Breast", 12.5);
        Meat fish = new Meat("Fish (Any Fillet)", 10);

        //Add our meats to the array
        Meat[] meats = new Meat[7];
        meats[0] = newyorkstrip;
        meats[1] = ribeye;
        meats[2] = porterhouse;
        meats[3] = flanksteak;
        meats[4] = porkchops;
        meats[5] = chickenbreast;
        meats[6] = fish;

        //Build menu
        System.out.println("Please enter a selection from our menu that you would like to grill.");
        System.out.println("Make sure that your grill is hot, oiled and ready to go.");
        System.out.println("Flip once half way through.");
        for (int i = 0; i < meats.length; i++) {
            System.out.println(i+1 + ". " + meats[i].getName());
        }
        
        //This gets a char from the user as menu selection
        in = input.nextInt();

        //Menu selection
        switch(in-1) {
            case -1:
                //Exit the program
                System.exit(0);
            default:
                if (in <= meats.length && in > -1) {
                    meats[in-1].MeatTimer();
                }
                else {
                    System.out.println("Invalid selection, exiting...");
                    System.exit(0);
                }
        }
        
    }
}
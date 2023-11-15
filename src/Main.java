import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner in = new Scanner(System.in);


        String finished = "";
        boolean done = false;
        boolean done2 = false;

        System.out.print("Ready to roll the dice? Press 'Enter' to play.");
        in.nextLine();

        do {
            int die1 = random.nextInt(6)+1;
            int die2 = random.nextInt(6)+1;
            int crapsRoll = die1 + die2;

            System.out.println("Your first roll is a " + die1 + ", and your second is a " + die2); {
                if (crapsRoll == 7 || crapsRoll == 11){
                    System.out.println("You rolled a " + crapsRoll + ", you won with a natural!");
                }
                else if (crapsRoll == 2 || crapsRoll == 3 || crapsRoll == 12) {
                    System.out.println("You rolled a " + crapsRoll + " and crapped out, you loose!");
                } else {
                    System.out.println("You rolled a " + crapsRoll + ", that is the new point. Continue to roll");
                    int newPoint = crapsRoll;
                   do {
                       System.out.print("Press 'Enter' to roll.");
                       in.nextLine();
                       die1 = random.nextInt(6)+1;
                       die2 = random.nextInt(6)+1;
                       crapsRoll = die1 + die2;
                       System.out.println("Your first roll is a " + die1 + ", and your second is a " + die2);
                       if (crapsRoll == newPoint){
                           System.out.println("You rolled a " + newPoint + " and made new point, you win!");
                           done2 = true;
                       } else if (crapsRoll == 7){
                           System.out.println("You rolled a 7, you loose!");
                           done2 = true;
                       } else {
                           System.out.println("You rolled a " + crapsRoll + ", you're still trying for a " + newPoint);

                       }

                   }while (!done2);
                }

            }
            System.out.print("Do you want to play again? [Y,N]: ");
            finished = in.nextLine();
            if (finished.equalsIgnoreCase("n")) {
                done = true;
            } else if (finished.equalsIgnoreCase("y")) {
                done = false;
            }

        } while (!done);
    }
}
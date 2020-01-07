import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        Money start = new Money();
        Money goal = new Money();
        System.out.println("Enter your current saving");
        start.readinput();
        System.out.println("only start amount before doubling:");
        start.writeOutput();
        System.out.println("after doubling: ");
        goal = start.times(2);
        System.out.print("if you double that you will have: ");
        goal.writeOutput();

        System.out.print("Or better yet");
        goal = start.add(goal);
        System.out.println("if you triple the original amount you will have");
        goal.writeOutput();


    }
}

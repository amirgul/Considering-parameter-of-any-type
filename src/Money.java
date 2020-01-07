import java.util.Scanner;

public class Money
{
    private long dollars;
    private long cents;

    public void set(long newDollars)
    {
        if(newDollars <0)
        {
            System.out.println("Wrong parameter entered for long must be greater than zero");
        }
        else
        {
            dollars = newDollars;
            cents = 0;
        }
    }
    public void set(double newAmount)
    {
        if(newAmount <0)
        {
            System.out.println("Negative amount for double is not allowed");
        }
        else
        {
            long allcents = Math.round(newAmount *100);
            dollars = allcents/100;
            cents = allcents%100;
        }
    }
    public void set(Money moneyObject)
    {
        dollars = moneyObject.dollars;
        cents = moneyObject.cents;
    }
    public void set(String amountString)
    {
        String dollarStirng = "";
        String centsString= "";
        if(amountString.charAt(0)== '$')
            amountString = amountString.substring(1);
        amountString = amountString.trim();

        int pointLocation = amountString.indexOf(".");
        if(pointLocation < 0)
        {
            cents = 0;
            dollars = Long.parseLong(amountString);
        }
        else
        {
            dollarStirng = amountString.substring(0, pointLocation);
            centsString = amountString.substring(pointLocation+1);
        }
        if(centsString.length() <= 1)
            centsString = centsString + "0";
        dollarStirng.trim();
        centsString.trim();

        dollars = Long.parseLong(dollarStirng);
        cents = Long.parseLong(centsString);

    }
    public void readinput()
    {
        System.out.println("Enter amount on a line by itself");
        Scanner keyboard = new Scanner(System.in);
        String amount = keyboard.nextLine();
        set(amount.trim());
    }
    public void writeOutput()
    {
        System.out.print("$"+ dollars);
        if(cents <10)
        {
            System.out.print(.0 + cents);
        }
        else
            System.out.print("." + cents);
    }
    public Money times(int n)
    {
        Money product = new Money();
        product.cents = n * cents;
        long carryDollars = product.cents/100;
        product.cents = product.cents%100;
        product.dollars = n*dollars+carryDollars;
        return  product;
    }
    public Money add(Money otherAmount)
    {
        Money sum = new Money();
        sum.cents = otherAmount.cents + cents;
        long carryDollars = sum.cents/100;
        sum.cents = sum.cents%100;
        sum.dollars = otherAmount.dollars + carryDollars + dollars;
        return  sum;

    }
}

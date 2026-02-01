import pack.Bank;
import java.util.*;
public class temp
{
    public static void main(String [] args)
    {
        Scanner gg1=new Scanner(System.in);
        Bank obj1=new Bank();
        String name;
        int k,ch1,ch2,pin,pass,sw;
        double bal;
        System.out.println("--------WELCOME TO THE ZEUS BANK----------");
        System.out.println("Enter Your Full Name: ");
        name=gg1.nextLine();
        System.out.println("Enter Your Year Of Birth: ");
        k=gg1.nextInt();
        System.out.println("Enter Your 5 digit PIN(it should not start with 0): ");
        pin=gg1.nextInt();
        while (!obj1.isValidPin(pin)) {
        pin = gg1.nextInt();
        }
        System.out.println("Congratulation Your Account Has Been Opened Successfully----");
        System.out.println("Now There is Only 3 Rules you have to follow.They Are:");
        System.out.println(" 1. Don't Forget your PIN "+pin+" or else you cannot withdraw, deposit and also cannot access sensitive information.");
        System.out.println("2. You have to maintain the minimum account balance of $4,000.");
        System.out.println("3.  If You want to create a FD Account the balance should be minimum $50,000.");
        System.out.println("That being said time to deposit in your account-");
        System.out.println("Enter the amount you want to deposit: ");
        do{
        bal=gg1.nextDouble();
        if(bal<4000)
        {
        System.out.println("Follow Rule no 2.Re-enter the the amount to deposit");  
        }
        }while(bal<4000);
        obj1.getdata1(bal,name,k,pin);
        System.out.println("We offer an interest rate of 6.9% for Fixed deposit Account for 5 years");
        System.out.println("Do You Want to Open a FD for 5 years?");
        System.out.println("Press '1' for Yes\nPress '2' for No");
        ch1=gg1.nextInt();
        if(ch1==1)
        {
            do
            {
                System.out.print("Enter the Amount to open a fixed deposit Account:  ");
                bal=gg1.nextDouble();
                System.out.println("Enter Your 5 digit PIN to continue");
                pass=gg1.nextInt();
                if(bal<50000 || pass!=pin)
                {
                    System.out.println("Follow The Rule No 3 Please!");
                }
            }while(bal<50000.0 || pass!=pin);
            obj1.FD(bal);
        }

        do
        {
            System.out.println("Press '1' to Deposit money in Savings Account");
            System.out.println("Press '2' to withdraw money from Savings Account");
            System.out.println("Press '3' to Show details of Account");
            System.out.println("Press '4' to Change Your PIN");
            System.out.println("Press '5' to Exit");
            System.out.print("Enter Choice: ");
            ch2=gg1.nextInt();
            switch(ch2)
            {
                case 1:
                System.out.print("Enter the Amount to Deposit:  ");
                bal=gg1.nextDouble();
                System.out.print("Please Enter Your 5 digit PIN to continue:  ");
                pass=gg1.nextInt();
                obj1.deposit(bal, pass);
                break;

                case 2:
                System.out.print("Enter the Amount to Withdraw:  ");
                bal=gg1.nextDouble();
                System.out.print("Please Enter Your 5 digit PIN to continue:  ");
                pass=gg1.nextInt();
                obj1.withdrawl(bal, pass);
                break;

                case 3:
                if(ch1==1)
                {
                    System.out.println("Which Account Details You Want to see?");
                    System.out.println("Enter '1' for Savings Account\n Enter '2' for Fixed Deposit Account");
                    sw=gg1.nextInt();
                    obj1.showdata(sw);
                }
                else
                obj1.showdata(1);
                break;

                case 4:
                System.out.println("Enter your current PIN:  ");
                pass=gg1.nextInt();
                obj1.change_pin(pass);
                break;

                case 5:
                System.out.println("We are happy to serve you. Hope we will see again soon");
                break;
                default:
                System.out.println("Wrong Choice!Re-enter it");
                break;
            }
        }while(ch2!=5);

        if(ch1==1)
                {
                    obj1.fiveyears( 1);
                    obj1.fiveyears (2);
                }
                else
                { 
                    obj1.fiveyears( 1); 
                }
        gg1.close();
    }
    
}


package pack;
import java.security.DrbgParameters;
import java.util.*;

abstract class BankAccount
{
  
    protected double balance_SA;
    protected double balance_FDA;
    protected String account_holder_name;
    protected int min_balance=4000;
    protected double interest1=4.2;
    protected double interest2=6.9;
    protected double yr=5.0;
    protected long  account_no;
    protected int password;
    Scanner gg1=new Scanner(System.in);
   public  void getdata1(double bal1,String name,int k,int pass)
    {
        balance_SA=bal1;
        account_no=965500*k;
        password=pass;
        account_holder_name=name;
    }
   protected double calculate(int sw)
    {
        double total=0.0;
        if(sw==1)
        {
            total=(balance_SA*yr*interest1)/100.0;
            total=total+balance_SA;
            
        }
        else if(sw==2)
        {
            total=(balance_FDA*yr*interest2)/100.0;
            total=total+balance_FDA;
        }
        return total;
    }
    public void FD(double bal)
    {
        balance_FDA=bal;
        System.out.println("Congratulations Your Fixed Deposit Account has been created succesfully");
    }
    public boolean isValidPin(int pin) {
     if(pin >= 10000 && pin <= 99999)
     {
        return true;
     }
     else
     {
        System.out.println("Please Enter a 5 digit PIN only!");
        return false;
     }
}

    abstract void deposit(double a,int b);
    abstract void withdrawl(double a,int b);
    abstract void showdata(int d);
    abstract void fiveyears(int d);
    abstract void change_pin(int c);
}
public class Bank extends BankAccount
{
public void deposit(double bal,int pass)
 {
    int p;
    if(pass!=password)
    {
        System.out.println("Cannot deposit as you entered Wrong PIN no");
        return;
    }
    balance_SA+=bal;
    System.out.println(bal+" credited to your Bank Account "+account_no);
    System.out.println("Do You Want to see your Account information?");
    System.out.println("Press '1' for YES and '2' for NO");
    p=gg1.nextInt();
    if (p==1)
    showdata(1);
 } 
 public void withdrawl(double bal,int pass)
 {
    int p;
    if(pass!=password)
    {
        System.out.println("Cannot Withdraw as you entered Wrong PIN no");
        return;
    }
    balance_SA-=bal;
    if(balance_SA<min_balance || bal>balance_SA)
    {
        System.out.println("Your Bank Account Balance Is lower than $4,000 cannot withdraw money until you deposit some");
        balance_SA+=bal;
        return;
    }
    System.out.println(bal+" debited from your Bank Account "+account_no);
    System.out.println("Do You Want to see your Account information?");
    System.out.println("Press '1' for YES and '2' for NO");
    p=gg1.nextInt();
    if (p==1)
    showdata(1);

 }

 public void showdata(int sw)
 {
    if(sw==1)
    {
    System.out.println("******************************************************");
    System.out.println("Welcome Again to ZEUS Bank!");
    System.out.println("Your Account Details");
    System.out.println("Name - "+account_holder_name);
    System.out.println("Account Number - "+account_no);
    System.out.println("Balance - "+balance_SA);
   System.out.println("******************************************************");
    }
    else if(sw==2)
    {
        System.out.println("******************************************************");
        System.out.println("Your Fixed Deposit Account Details");
        System.out.println("Name - "+account_holder_name);
        System.out.println("Balance - "+balance_FDA);
       System.out.println("******************************************************");
    }
 }
public void fiveyears(int sw)
{
double total;
    if(sw==1)
    {
        total=calculate(1);
        System.out.println("******************************************************");
        System.out.println("Thank You for being with us for the last 5 years.");
        System.out.println("After 5 years your account balance grew from "+balance_SA+" to "+total);
        System.out.println("We are glad to serve you ");
        System.out.println("******************************************************");
    }
    else if(sw==2)
    {
        total=calculate(2);
        System.out.println("******************************************************");
        System.out.println(account_holder_name+" Your 5 years of Fixed Deposit is completed ");
         System.out.println("After 5 years your fixed deposit account balance grew from "+balance_FDA+" to "+total);
         System.out.println("We are glad to serve you ");
        System.out.println("******************************************************");

    }
}


public void change_pin(int pass)
{
    int pin,checkpin;
    if(pass!=password)
    {
        System.out.println("Incorrect PIN!");
        return;
    }
    System.out.println("Enter Your new 5-digit PIN:  ");
    pin=gg1.nextInt();
    while (!isValidPin(pin)) {
    pin = gg1.nextInt();
    }
    System.out.println("Re-enter your new PIN:  ");
    checkpin=gg1.nextInt();
    while (!isValidPin( checkpin)) {
    checkpin = gg1.nextInt();
    }
    if(checkpin==pin)
    {
        password=pin;
        System.out.println("PIN changed successfully!");
    }
    else
    {
        System.out.println("PINs don't match. Try again later!");
    }
}
    
}

import java.util.Scanner;
class Bank_A
{
    protected String Name;
    protected int Acc_no;
    protected int Balance1;
    protected int Balance2;
    Bank_A()
    {
        Scanner tr=new Scanner(System.in);
        System.out.print("Enter the Name:");
        Name=tr.next();
        System.out.print("Enter the Account Number:");
        Acc_no=tr.nextInt();
        System.out.print("Enter the Balance for the Savings Account:");
        Balance1=tr.nextInt();
    }
    Bank_A(int c)
    {
        Balance2+=c;
    }
}
class Savings extends Bank_A
{
    protected int deposit;

    public void Deposit()
    {
        Scanner f=new Scanner(System.in);
        System.out.print("Enter the Deposited Amount:");
        deposit=f.nextInt();
        Balance1+=deposit;
    }
}
class Current extends Bank_A
{
    Scanner d=new Scanner(System.in);
    protected int dj;
    protected int withdrawl;
    Current(int b)
    {
        super(b);
    }
    void Depoist()
    {
        System.out.print("Enter the Deposited Amount:");
        dj=d.nextInt();
        Balance2+=dj;
    }
    void Withdrawl()
    {
        System.out.print("Enter the Withdrawl Amount:");
        withdrawl=d.nextInt();
        if(withdrawl>Balance2)
        {
            System.out.print("Insufficient Balance");
            return;
        }
        Balance2-=withdrawl;
    }
    void Display()
    {
        System.out.println("Name:"+Name);
        System.out.println("Account Number:"+Acc_no);
        System.out.println("The Savings Account Balance:"+Balance1);
        System.out.println("The Current Account Balance:"+Balance2);
    }
}
class Bank_Account
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n;
        System.out.print("ENter the number of Objects:");
        n=sc.nextInt();
        Savings[] S=new Savings[n];
        Current[] C=new Current[n];
        int k;
        for(int i=0;i<n;i++)
        {
            System.out.println("Enter the Details of the Customer "+(i+1)+":");
            S[i]=new Savings();
            System.out.print("Enter the Balance for the Current Account:");
            k=sc.nextInt();
            C[i]=new Current(k);
        }
        for(int i=0;i<n;i++)
        {
            int c;
            System.out.print("Enter the Choice Customer "+(i+1)+":\n1 for Savings Account.\2 for Current Account.");
            c=sc.nextInt();
            switch(c)
            {
                case 1:
                    S[i].Deposit();
                    break;
                case 2:
                {
                    int g;
                    System.out.print("Enter the Choice:\n1 for Deposit.\n2 for withdrawl");
                    g=sc.nextInt();
                    if(g==1)
                        C[i].Depoist();
                    else if(g==2)
                        C[i].Withdrawl();
                    else
                        System.out.println("You Entered Wrong input...");
                }
                break;
                default:
                    System.out.println("You Entered Wring Input...");
                    break;
            }
        }
        for(int i=0;i<n;i++)
        {
            System.out.println("The Details of the Customer "+(i+1)+":");
            C[i].Display();
        }
    }
}

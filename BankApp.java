import java.util.Scanner;

class BankDetails {
    private String accno;
    private String name;
    private String Acc_type;
    private long balance;

    Scanner sc = new Scanner(System.in);

    public void openAccount() {
        System.out.println("Enter Account no:");
        accno = sc.next();
        System.out.println("Enter name:");
        name = sc.next();
        System.out.println("Enter Account Type:");
        Acc_type = sc.next();
        System.out.println("Enter Balance:");
        balance = sc.nextLong();
    }

    public void showAccount() {
        System.out.println("Name of Account Holder:" + name);
        System.out.println("Account no:" + accno);
        System.out.println("Account type:" + Acc_type);
        System.out.println("Account Balance:" + balance);
    }

    public void deposit() {
        long amt;
        System.out.println("Enter the amount you want to deposit:");
        amt = sc.nextLong();
        balance = amt + balance;
        System.out.println("Balance after Deposit:"+balance);
    }

    public void withdrawl() {
        long amt;
        System.out.println("Enter the Amount to Withdraw:");
        amt = sc.nextLong();
        if (balance >= amt) {
            balance = balance - amt;
            System.out.println("Balance after withdrawl:" + balance);
        } else {
            System.out.println("Insufficient Balance!!");
        }
    }

    public boolean search(String ac_no) {
        if (accno.equals(ac_no)) {
            showAccount();
            return (true);
        } else {
            return (false);
        }
    }
}
public class BankApp {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("How many number of Customers do you want to input?");
        int n=sc.nextInt();
        BankDetails c[]=new BankDetails[n];
        for(int i=0;i<c.length;i++)
        {
            c[i]=new BankDetails();
            c[i].openAccount();
        }
        int ch;
        do
        {
            System.out.println("\n===========Banking Application System===========");
            System.out.println("1.Display all account details\n 2.Search by Account number\n 3.Deposit the amount\n 4.Withdraw the amount\n 5.Exit");
            System.out.println("Enter your choice:");
            ch=sc.nextInt();
            switch (ch)
            {
                case 1:
                    for(int i=0;i<c.length;i++)
                    {
                        c[i].showAccount();
                    }
                    break;

                case 2:
                    System.out.println("Enter account no you want to search:");
                    String ac_no=sc.next();
                    boolean found=false;
                    for(int i=0;i<c.length;i++)
                    {
                        found=c[i].search(ac_no);
                        if(found){
                            break;
                        }
                    }
                    if(!found){
                        System.out.println("Search Failed! Account doesn't Exist..!!");
                    }
                    break;

                case 3:
                    System.out.println("Enter the account no:");
                    ac_no=sc.next();
                    found=false;
                    for(int i=0;i<c.length;i++)
                    {
                        found=c[i].search(ac_no);
                        if(found)
                        {
                            c[i].deposit();
                            break;
                        }
                    }
                    if (!found)
                    {
                        System.out.println("Search Failed !!");
                    }
                    break;
                case 4:
                    System.out.println("Enter Account no:");
                    ac_no=sc.next();
                    found=false;
                    for(int i=0;i<c.length;i++)
                    {
                        found=c[i].search(ac_no);
                        if(found)
                        {
                            c[i].withdrawl();
                            break;
                        }
                    }
                    if(!found)
                    {
                        System.out.println("Search Failed!!!");
                    }
                    break;

                case 5:
                    System.out.println("See you soon....Have a Nice Day(-_-)");
                    break;
            }
        }
        while(ch!=5);
    }
}

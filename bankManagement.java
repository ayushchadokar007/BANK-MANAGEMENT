import java.util.Scanner;

class bankAccount {
    String name;
    String userName;
    String password;
    String accountNo;
    float balance = 100000f;
    int transactions = 0;
    String transactionHistory = "";

    Scanner sc = new Scanner(System.in);

    public void register() {
        System.out.print("\nEnter Your Name - ");
        this.name = sc.nextLine();
        System.out.print("\nEnter Your Username - ");
        this.userName = sc.nextLine();
        System.out.print("\nEnter Your Password - ");
        this.password = sc.nextLine();
        System.out.print("\nEnter Your Account Number - ");
        this.accountNo = sc.nextLine();
        System.out.println("\nRegistration completed..kindly login");
    }

    public boolean login() {
        boolean isLogin = false;
        while (!isLogin) {
            System.out.print("\nEnter Your Username: ");
            String Username = sc.nextLine();
            if (Username.equals(userName)) {
                while (!isLogin) {
                    System.out.print("\nEnter Your Password: ");
                    String Password = sc.nextLine();
                    if (Password.equals(password)) {
                        System.out.println("\nLogin successful!!");
                        isLogin = true;
                    } else {
                        System.out.println("\nIncorrect Password");
                    }
                }
            } else {
                System.out.println("Username not found");
            }
        }
        return isLogin;
    }

    public void withdraw() {
        System.out.print("\nEnter amount to withdraw: ");
        float amount = sc.nextFloat();
        if (balance >= amount) {
            transactions++;
            balance -= amount;
            System.out.println("\nWithdrawl successfull!!");
            String str = amount + "Rs Withdrawl";
            transactionHistory = transactionHistory.concat(str);
        } else {
            System.out.println("Insufficient Balance");
        }
    }

    public void deposite() {
        System.out.print("\nEnter amount to deposite: ");
        float amount = sc.nextFloat();
        balance += amount;
        System.out.println("\nDeposite successfull!!");
        transactions++;
        String str = amount + "Rs Deposite";
        transactionHistory = transactionHistory.concat(str);
    }

    public void transfer() {
        System.out.print("\n Enter Receipient's Name - ");
        String receipient = sc.nextLine();
        System.out.print("Enter amount to transfer: ");
        float amount = sc.nextFloat();
        if (balance >= amount) {
            if (amount <= 500000f) {
                balance -= amount;
                System.out.println("Successfully Transfer to " + receipient);
                transactions++;
                String str = amount + "Rs Transfer" + receipient + "\n";
                transactionHistory = transactionHistory.concat(str);
            } else {
                System.out.println("Sorry!...Limit is 50000.00");
            }
        } else {
            System.out.println("Insufficient Balance");
        }
    }

    public void checkBalance() {
        System.out.println("\nTotal Balance:- " + balance + " Rs");
    }

    public void transaction() {
        if (transactions == 0) {
            System.out.println("\nEmpty");
        } else {
            System.out.println("\n" + transactionHistory);
        }
    }

}

class bankManagement {

    public static int takeInput(int limit) {
        Scanner s = new Scanner(System.in);
        int input = 0;
        boolean flags = false;
        while (!flags) {
            input = s.nextInt();
            flags = true;
            if (flags && input > limit || input < 1) {
                System.out.println("\nChoose the number between 1 to " + limit);
                flags = false;
            }
        }
        return input;

    }

    public static void main(String[] args) {
        System.out.println("************************ Wellcome To SBI Bank **********************");
        System.out.println("1.Register \n2.Exit");
        System.out.print("\nEnter the choise: ");
        int choice = takeInput(2);

        if (choice == 1) {
            bankAccount b = new bankAccount();
            b.register();
            while (true) {
                System.out.println("\n1.Login \n2.Exit");
                System.out.println("\nEnter Your Choice: ");
                choice = takeInput(2);
                if (choice == 1) {
                    if (b.login()) {
                        System.out.println("\n********************* WELLCOME BACK " + b.name.toUpperCase()
                                + "****************************");
                        boolean flags = false;
                        while (!flags) {
                            System.out.println(
                                    "\n1.Withdraw \n2.Deposite \n3.Transfer \n4.Check Balance \n5.Transaction \n6.Exit");
                            System.out.println("\nEnter Your Choice: ");
                            int c = takeInput(6);
                            switch (c) {
                                case 1:
                                    b.withdraw();
                                    break;

                                case 2:
                                    b.deposite();
                                    break;

                                case 3:
                                    b.transfer();
                                    break;

                                case 4:
                                    b.checkBalance();
                                    break;

                                case 5:
                                    b.transaction();
                                    break;

                                case 6:
                                    flags = true;
                                    break;
                            }
                        }
                    }
                } else {
                    System.exit(0);
                }
            }
        } else {
            System.exit(0);
        }
    }
}
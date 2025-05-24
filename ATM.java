import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int balance = 5000;
        int password = 1234;

        // Account input
        System.out.print("Enter your Account Number: ");
        int userId = sc.nextInt();
        System.out.println("Your User_ID: " + userId);

        // Sleep for 2 seconds
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Unexpected error during wait.");
        }

        // Pin input
        System.out.print("Enter your ATM pin: ");
        int pin = sc.nextInt();

        System.out.println("------------------------------------------------------------------------------------------------");

        // Validate pin
        if (pin == password) {
            while (true) {
                System.out.println("""
                    1 == Check Balance
                    2 == Withdraw Balance
                    3 == Deposit Balance
                    4 == Transfer Money
                    5 == Exit
                """);

                System.out.print("Enter your choice: ");
                int option;
                try {
                    option = sc.nextInt();
                } catch (Exception e) {
                    System.out.println("Invalid option.");
                    sc.next(); // consume invalid input
                    continue;
                }

                switch (option) {
                    case 1:
                        System.out.println("Current Balance: " + balance);
                        break;

                    case 2:
                        System.out.print("Please enter withdraw amount: ");
                        int withdraw = sc.nextInt();
                        if (balance >= withdraw) {
                            balance -= withdraw;
                            System.out.println("------------------------------------------------------------------------------------------------");
                            System.out.println(withdraw + " is debited from your account.");
                            System.out.println("Your Updated Balance: " + balance);
                            System.out.println("------------------------------------------------------------------------------------------------");
                        } else {
                            System.out.println("Insufficient Balance");
                        }
                        break;

                    case 3:
                        System.out.print("Please enter deposit amount: ");
                        int deposit = sc.nextInt();
                        balance += deposit;
                        System.out.println("------------------------------------------------------------------------------------------------");
                        System.out.println(deposit + " is credited to your account.");
                        System.out.println("Your Updated Balance: " + balance);
                        System.out.println("------------------------------------------------------------------------------------------------");
                        break;

                    case 4:
                        System.out.print("Please enter the amount to transfer: ");
                        int transfer = sc.nextInt();
                        if (balance >= transfer) {
                            System.out.print("Enter recipient's account number: ");
                            int recipient = sc.nextInt();
                            balance -= transfer;
                            System.out.println("------------------------------------------------------------------------------------------------");
                            System.out.println(transfer + " has been transferred to account " + recipient);
                            System.out.println("Your Updated Balance: " + balance);
                            System.out.println("------------------------------------------------------------------------------------------------");
                        } else {
                            System.out.println("Insufficient Balance");
                        }
                        break;

                    case 5:
                        System.out.println("Exit");
                        System.out.println("------------------------------------------------------------------------------------------------");
                        return;

                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        } else {
            System.out.println("Wrong pin, please try again.");
        }

        sc.close();
    }
}


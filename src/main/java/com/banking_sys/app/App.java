package com.banking_sys.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        List<Bank> bankList = new ArrayList<Bank>();
        Bank bObject = null;
        int accCount = 0;
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.println(" Welcome to the Banking world ");

                System.out.println("Select an option..........");
                System.out.println("Search account[1]");
                System.out.println("Create account[2]");
                System.out.println("Deposit amt[3]");
                System.out.println("Withdraw amt[4]");
                System.out.println("close account[5]");
                System.out.println("logout instance[6]");

                char option = sc.nextLine().charAt(0);
                switch (option) {
                    case '1':
                        System.out.println("enter the account number....");
                        String acc_no = sc.nextLine();
                        System.out.println(bankList.get(0));

                        Boolean found = false;
                        for (Bank acc : bankList) {
                            if (acc.acc_number == acc_no) {
                                System.out.println("here");
                                bObject = acc;

                                found = true;
                                System.out.println(bObject);
                            }

                            if (!found) {
                                System.out.println("account not found");

                            }
                        }
                        break;

                    case '2':
                        System.out.println("Create account ....");
                        System.out.println("Enter account name ....");

                        String acc_name = sc.nextLine();
                        System.out.println("Enter the account type");
                        String acc_type = sc.nextLine();
                        String accNo = Integer.toString(accCount);

                        bObject = new Bank(accNo, acc_name, true, acc_type);
                        accCount += 1;
                        System.out.println(" Account created " + bObject);
                        bankList.add(bObject);
                        break;

                    case '3':
                        if (bObject == null) {
                            System.out.println("please select a account, No account selected");
                        }
                        System.out.println("Enter the amount to deposit ....");

                        double amt_balance = sc.nextDouble();

                        bObject.setBalance(amt_balance);
                        bObject.setTransaction("deposit", amt_balance);
                        System.out.println("Amount deposited. Updated balance: " + bObject.getBalance());

                    case '4':
                        System.out.println("withdraw amt ....");

                        Double amt_balanc = sc.nextDouble();

                        Double prev_balance = bObject.getBalance();

                        bObject.setBalance(prev_balance - amt_balanc);
                        bObject.setTransaction("withdraw", amt_balanc);

                }

                System.out.println("Would you like to continue.....? y or Y ");

                String input = sc.nextLine();

                if (!input.isEmpty() && input.charAt(0) == 'y' || input.charAt(0) == 'Y') {
                    continue;
                } else {
                    break;
                }
            }
        }

    }
}

package BankingProject.accounts;

import BankingProject.customers.Customer;

public class BankAccount {
    double balance;
    //person who owns the accout
    Customer customer;
    //counts the number of accts made; shared across all instances
    static int counter = 10000;
    //instance variable of acct number
    int accountNumber;

    BankAccount(String name, int age){
        balance = 0;
        customer = new Customer(name, age);

        counter++;
        accountNumber = counter;
    }

    public static void main(String[] args) {
        BankAccount a1 = new BankAccount("x", 35);
        BankAccount a2 = new BankAccount("abc", 23);
        System.out.println(a1.accountNumber);
        System.out.println(a2.accountNumber);
    }

}

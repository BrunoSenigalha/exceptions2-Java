package models.entities;

import models.exceptions.DomainException;

public class Account {
    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
        if (balance < 0){
            throw new DomainException("Invalid balance value");
        }
        else if (withdrawLimit < 100){
            throw new DomainException("Invalid withdraw limit value");
        }
        else {
            this.number = number;
            this.holder = holder;
            this.balance = balance;
            this.withdrawLimit = withdrawLimit;
        }
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(Double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    public void deposit(Double amount) {
        balance += amount;
    }

    public void withdraw(Double amount) {
        if (withdrawLimit < amount){
            throw new DomainException("The amount exceeds withdraw limit");
        }
        else if (amount > balance) {
            throw new DomainException("Not enough balance");
        }
        else {
            balance -= amount;
        }
    }

    @Override
    public String toString(){
        return "Balance: " + balance;
    }
}

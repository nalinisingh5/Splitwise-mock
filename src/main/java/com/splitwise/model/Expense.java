package com.splitwise.model;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

public class Expense {
    private String emailId; // the one who paid
    private String description;
    private double expenseAmount;
    private int numberOfUsers;
    private LocalDateTime localDateTime;
    private ExpenseGroup expenseGroup;
    private List<String> userIds;
    private List<Double> share;

    public Expense(String emailId, String description, double expenseAmount, LocalDateTime localDateTime, ExpenseGroup expenseGroup) {
        this.emailId = emailId;
        this.description = description;
        this.expenseAmount = expenseAmount;
        this.localDateTime = localDateTime;
        this.expenseGroup = expenseGroup;
    }
}

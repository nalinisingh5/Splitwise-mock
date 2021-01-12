package com.splitwise.service;

import com.splitwise.model.Expense;
import com.splitwise.model.ExpenseGroup;
import com.splitwise.model.UserShare;
import com.splitwise.repository.ExpenseRepository;
import com.splitwise.repository.UserShareRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseService {

    public Expense createExpense(String emailId, String description, double expenseAmount, int numberOfUsers, LocalDateTime localDateTime, List<String> userIds, List<Double> share, String groupName) {


        List<UserShare> userShareList = new ArrayList<>();
        for (int i = 0; i < numberOfUsers; i++) {
            Map<String, Double> particularUserShare = new HashMap<>();
            if (particularUserShare.containsKey(userIds.get(i)))
                particularUserShare.put(userIds.get(i), particularUserShare.get(userIds.get(i)) + share.get(i));
            particularUserShare.put(userIds.get(i), share.get(i));
            UserShare userShare = new UserShare();
            userShare.setEmailId(emailId);
            userShare.setParticularUserShare(particularUserShare);
            userShareList.add(userShare);
        }
        UserShareRepository.userShareList.addAll(userShareList);
        Expense expense = new Expense(emailId, description, expenseAmount, localDateTime, new ExpenseGroup(groupName, userShareList));
        ExpenseRepository.expenseList.add(expense);
        return expense;
    }
}

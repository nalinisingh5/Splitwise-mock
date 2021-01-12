package com.splitwise.service;

import com.splitwise.model.ExpenseGroup;
import com.splitwise.model.User;
import com.splitwise.repository.ExpenseGroupRepository;
import com.splitwise.repository.UserRepository;

import java.util.HashSet;
import java.util.Set;

public class ExpenseGroupService {

    public ExpenseGroup createExpenseGroup(String groupName) {
        Set<User> users = new HashSet<>();
        ExpenseGroup expenseGroup = new ExpenseGroup(groupName, users);
        ExpenseGroupRepository.expenseGroups.putIfAbsent(groupName, users);
        return expenseGroup;
    }

    public void addUserToExpenseGroup(String groupName, String email) {
        User user = UserRepository.userHashMap.get(email);
        ExpenseGroupRepository.expenseGroups.get(groupName).add(user);
    }
}

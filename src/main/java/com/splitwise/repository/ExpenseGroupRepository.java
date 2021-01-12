package com.splitwise.repository;

import com.splitwise.model.ExpenseGroup;
import com.splitwise.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ExpenseGroupRepository {
    public static Map<String, Set<User>> expenseGroups =  new HashMap<>();
}

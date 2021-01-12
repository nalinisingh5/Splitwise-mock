package com.splitwise.model;

import java.util.List;
import java.util.Set;

public class ExpenseGroup {
    private String groupName;
    private Set<User> groupMembers;
    private List<UserShare> userShareList;


    public ExpenseGroup(String groupName, Set<User> groupMembers) {
        this.groupName = groupName;
        this.groupMembers = groupMembers;
    }

    public ExpenseGroup(String groupName, List<UserShare> userShareList) {
        this.groupName = groupName;
        this.userShareList = userShareList;
    }

    public void ExpenseGroup() {
    }
}

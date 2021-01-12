import com.splitwise.model.Expense;
import com.splitwise.model.ExpenseGroup;
import com.splitwise.model.User;
import com.splitwise.model.UserShare;
import com.splitwise.repository.UserShareRepository;
import com.splitwise.service.ExpenseGroupService;
import com.splitwise.service.ExpenseService;
import com.splitwise.service.UserService;

import java.awt.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SplitwiseMain {

    static ExpenseGroupService expenseGroupService;
    static UserService userService;
    static ExpenseService expenseService;

    public static void main(String args[]) throws IOException {
        expenseGroupService = new ExpenseGroupService();
        userService = new UserService();
        expenseService = new ExpenseService();
        createTestUsers();
        createExpenseGroups();
        //Add user to ExpenseGroup
        expenseGroupService.addUserToExpenseGroup("Trip", "nalinisingh.529@gmail.com");
        expenseGroupService.addUserToExpenseGroup("Trip", "richa.7@gmail.com");
        expenseGroupService.addUserToExpenseGroup("Trip", "rounak.48@gmail.com");

        //Add user to ExpenseGroup
        expenseGroupService.addUserToExpenseGroup("Flat", "nalinisingh.529@gmail.com");
        expenseGroupService.addUserToExpenseGroup("Flat", "richa.7@gmail.com");
        expenseGroupService.addUserToExpenseGroup("Flat", "rounak.48@gmail.com");
        expenseGroupService.addUserToExpenseGroup("Flat", "akanksha.17@gmail.com");

        // Create expense for expenseGroup : Trip
        createExpenseForTrip("Trip");

        // Create expense for expenseGroup : Flat
        createExpenseForFlat("Flat");

        show();
        //showExpenseForOneUser("nalinisingh.529@gmail.com");
    }

    private static void showExpenseForOneUser(String emailId) {
        UserShare userShare = UserShareRepository.userShareList.stream().filter(userShareList -> userShareList.getEmailId().equals(emailId)).findFirst().orElseThrow();
        Map<String, Double> map =  userShare.getParticularUserShare();
        for(String email : map.keySet())
            System.out.println(email + " owes " + map.get(email)+ " to " + emailId);
    }

    private static void show() {
        List<UserShare> userShareList = UserShareRepository.userShareList;
        for (UserShare userShare : userShareList) {
            String owner = userShare.getEmailId();
            for (Map.Entry entry : userShare.getParticularUserShare().entrySet()) {
                System.out.println(entry.getKey() + " owes " + entry.getValue() + " to " + owner);
            }
        }
    }

    private static void createExpenseForTrip(String groupName) {
        List<String> userIds = new ArrayList<>();
        userIds.add("richa.7@gmail.com");
        userIds.add("rounak.48@gmail.com");
        List<Double> share = new ArrayList<>();
        share.add(13000.0);
        share.add(5000.0);
        Expense expense = expenseService.createExpense("nalinisingh.529@gmail.com", "Trip money", 20000.0, 2, LocalDateTime.now(), userIds, share, groupName);
    }

    private static void createExpenseForFlat(String groupName) {
        List<String> userIds = new ArrayList<>();
        userIds.add("richa.7@gmail.com");
        userIds.add("rounak.48@gmail.com");
        userIds.add("akanksha.17@gmail.com");
        List<Double> share = new ArrayList<>();
        share.add(110.0);
        share.add(50.0);
        share.add(50.0);

        List<String> userIds2 = new ArrayList<>();
        userIds2.add("richa.7@gmail.com");
        userIds2.add("rounak.48@gmail.com");
        userIds2.add("nalinisingh.529@gmail.com");
        List<Double> share2 = new ArrayList<>();
        share2.add(500.0);
        share2.add(500.0);
        share2.add(500.0);
        Expense expense1 = expenseService.createExpense("nalinisingh.529@gmail.com", "Lunch money", 300.0, 3, LocalDateTime.now(), userIds, share, groupName);
        Expense expense2 = expenseService.createExpense("akanksha.17@gmail.com", "WiFi money", 2000.0, 3, LocalDateTime.now(), userIds2, share2, groupName);
    }

    public static void createExpenseGroups() {
        ExpenseGroup Trip = expenseGroupService.createExpenseGroup("Trip");
        ExpenseGroup Flat = expenseGroupService.createExpenseGroup("Flat");
    }

    public static void createTestUsers() {
        User user1 = userService.createUser("nalini.singh", "Nalini Singh", "nalinisingh.529@gmail.com", "8123813536");
        User user2 = userService.createUser("richa.singh", "Richa Singh", "richa.7@gmail.com", "81233333333");
        User user3 = userService.createUser("rounak.a", "Rounak Agarwal", "rounak.48@gmail.com", "81233333833");
        User user4 = userService.createUser("akanksha.s", "Akanksha Singh", "akanksha.17@gmail.com", "81233433833");
    }
}

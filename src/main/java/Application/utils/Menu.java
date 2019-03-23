//package Application.utils;
//
//import java.util.InputMismatchException;
//import java.util.Scanner;
//
//public class Menu {
//    GymService jymService = GymService.getInstance();
//
//    public void showMenu() {
//        System.out.println("#########################\n" +
//                "1.Log In\n2.News\n3.Employee Schedule\n4.Sections Schedule" +
//                "\n5.Add New Administrator Profile\n6.Exit App");
//    }
//    public void showAdministratorMenu(){
//        System.out.println("*************************" +
//                "\n1.Employee Schedule\n2.Show members\n3.Add a new member" +
//                " \n4.Delete a member \n5.Change member status");
//    }
//
//    private int intInput() {
//        Scanner scanner = new Scanner(System.in);
//        int i;
//        i = scanner.nextInt();
//        return i;
//    }
//
//    private String stringInput() {
//        Scanner scanner = new Scanner(System.in);
//        String s;
//        s = scanner.nextLine();
//        return s;
//    }
//
//    public void userInput() {
//        int i;
//        String s1;
//        String s2;
//        try {
//            System.out.println();
//            i = intInput();
//            while (true) {
//                if (i == 1) {
//                    System.out.println("Please enter LOGIN: ");
//                    s1 = stringInput();
//                    System.out.println("Please enter password");
//                    s2 = stringInput();
//                    loginAndShowAdministratorMenu(s1,s2);
//                }
//                else if (i == 5) {
//                    System.out.println("Please enter a new login: ");
//                    s1 = stringInput();
//                    System.out.println("Please enter a new password: ");
//                    s2 = stringInput();
//                    jymService.createNewAdminProfile(s1, s2);
//                }
//                else if (i==6){
//                    System.out.println("Good Bye!");
//                }
//                i= intInput();
//            }
//
//        } catch (InputMismatchException e) {
//            System.out.println("Please enter a number!");
//        }
//    }
//    public void loginAndShowAdministratorMenu(String login, String password){
//        if (jymService.checkIfAdministratorExists(login,password)){
//            showAdministratorMenu();
//        }
//    }
//}

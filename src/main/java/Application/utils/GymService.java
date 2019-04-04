//package Application.utils;
//
//import Application.model.User;
//
//public class GymService{
//    private static GymService instance;
//
//    public static GymService getInstance() {
//        if (instance == null) {
//            synchronized (GymService.class) {
//                if (instance == null) {
//                    instance = new GymService();
//                }
//            }
//        }
//        return instance;
//    }
//
//    public void createNewAdminProfile(String login, String password) {
//        User administrator = new User(login, password);
//        User.administrators.add(administrator);
//        System.out.println(User.administrators);
//    }
//
//    public boolean checkIfAdministratorExists(String login, String password) {
//        boolean ifExists = false;
//        for (User a : User.administrators) {
//            if (a.getLogin().equalsIgnoreCase(login) && a.getPassword().equals(password)) {
//                ifExists = true;
//            }
//        }
//        return ifExists;
//    }
//
//}

package Application.utils;

import Application.model.Administrator;

public class GymService{
    private static GymService instance;

    public static GymService getInstance() {
        if (instance == null) {
            synchronized (GymService.class) {
                if (instance == null) {
                    instance = new GymService();
                }
            }
        }
        return instance;
    }

    public void createNewAdminProfile(String login, String password) {
        Administrator administrator = new Administrator(login, password);
        Administrator.administrators.add(administrator);
        System.out.println(Administrator.administrators);
    }

    public boolean checkIfAdministratorExists(String login, String password) {
        boolean ifExists = false;
        for (Administrator a : Administrator.administrators) {
            if (a.getLogin().equalsIgnoreCase(login) && a.getPassword().equals(password)) {
                ifExists = true;
            }
        }
        return ifExists;
    }

}

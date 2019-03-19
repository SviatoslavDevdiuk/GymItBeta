
import dataBase.DBTest;
import model.MemberDAO;

import java.io.IOException;
import java.sql.*;

public class Main {

    public static void main(String[] args) throws IOException, SQLException {
        MemberDAO memberdao = MemberDAO.getInstance();
        DBTest dbTest = new DBTest();
//        memberdao.createMembers();
        dbTest.testApp();
        DBTest.printDownloadedMembers();
    }


}

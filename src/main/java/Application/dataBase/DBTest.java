//package Application.dataBase;
//
//import Application.model.Member;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class DBTest {
//    private static Member memberInstance = new Member();
//    private static List<Member> downloadedMembers = new ArrayList<>();
//
//    public static void addNewMembers() {
//
//    }
//
//    public static void printDownloadedMembers() {
//        for (Member m : downloadedMembers) {
//            System.out.println(m);
//        }
//    }
//
//    public static void testApp() throws SQLException {
//        Connection conn = DriverManager.
//                getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
//        Statement stmt = conn.createStatement();
//        PreparedStatement prstmt = null;
//        ResultSet rs = null;
//        String readMembers = "SELECT * FROM MEMBERS4";
//        try {
//            stmt.execute("TRUNCATE TABLE MEMBERS4");
//            stmt.execute("SELECT (FIRST_NAME, EMAIL) FROM MEMBERS4 WHERE ID = 98");
//            for (Member m : memberInstance.members) {
//                prstmt = conn.prepareStatement
//                        ("INSERT INTO MEMBERS4(FIRST_NAME, LAST_NAME, CONTACT_NUMBER, EMAIL)"
//                                + "VALUES(?,?,?,?)");
//                prstmt.setString(1, m.getFirstName());
//                prstmt.setString(2, m.getLastName());
//                prstmt.setInt(3, m.getContactNumber());
//                prstmt.setString(4, m.getEmail());
//                prstmt.execute();
//            }
//            rs = stmt.executeQuery(readMembers);
//            while (rs.next()) {
//                Member member = new Member.MemberBuilder(rs.getString("FIRST_NAME")
//                        , rs.getString("LAST_NAME"), rs.getInt("CONTACT_NUMBER"))
//                        .withEmail(rs.getString("EMAIL")).create();
//                downloadedMembers.add(member);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            if (prstmt != null) {
//                prstmt.close();
//            }
//
//            try {
//                stmt.execute("EXPLAIN SELECT * FROM MEMBERS4 WHERE ID = 101");
//                stmt.execute("CREATE TABLE IF NOT EXISTS members4" +
//                        "( id INT NOT NULL AUTO_INCREMENT,"
//                        + "first_name VARCHAR(100) NOT NULL,"
//                        + "last_name VARCHAR(100) NOT NULL,"
//                        + "contact_number INT(100) NOT NULL,"
//                        + "email VARCHAR(100) NOT NULL)");
//                stmt.close();
//
//
//            } catch (SQLException e) {
//                e.printStackTrace();
//            } finally {
//                try {
//                    if (stmt != null) {
//                        conn.close();
//                    }
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//                try {
//                    if (conn != null) {
//                        conn.close();
//                    }
//                } catch (SQLException e1) {
//                    e1.printStackTrace();
//                }
//            }
//
//        }
//    }

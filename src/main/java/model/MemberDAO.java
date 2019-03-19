package model;

import java.util.List;

public class MemberDAO {
    Member memberInstance = new Member();
    private static MemberDAO instance;

    private MemberDAO() {

    }

    public static MemberDAO getInstance() {
        if (instance == null) {
            synchronized (MemberDAO.class) {
                if (instance == null) {
                    instance = new MemberDAO();
                }
            }
        }
        return instance;
    }


    public void createMembers() {
        Member m1 = new Member.MemberBuilder("Anton", "Maksymenko", 788148844)
                .withEmail("antonmaxymenko@gmail.com").create();
        Member m2 = new Member.MemberBuilder("Maksym", "Duda,", 625524545)
                .withEmail("maksymduda@yahoo.com").create();
        Member m3 = new Member.MemberBuilder("Mishka", "Tkachenko", 762425135)
                .withEmail("mishatkachenko@mail.ru").create();
        Member m4 = new Member.MemberBuilder("Oleksandr", "Voynalovich", 562562562
        ).withEmail("oleksandrvoynalovich@yandex.ru").create();
        Member m5 = new Member.MemberBuilder("Elisey", "Zamahkov", 2121215521)
                .withEmail("eliseyzamakhov@gmail.com").create();
        Member m6 = new Member.MemberBuilder("Bartlomiej", "Kornacki", 965695695)
                .withEmail("bartkornacki@gmail.com").create();
        memberInstance.addMember(m1);
        memberInstance.addMember(m2);
        memberInstance.addMember(m3);
        memberInstance.addMember(m4);
        memberInstance.addMember(m5);
        memberInstance.addMember(m6);
    }
}

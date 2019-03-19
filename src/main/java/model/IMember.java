package model;

import java.math.BigInteger;

public interface IMember {

    void removeMember(Member member);
    boolean addMember (Member member);

    Member editMember(BigInteger contactNumber);


//    List<Member> sortByAge();


}

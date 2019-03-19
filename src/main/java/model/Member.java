package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@ToString
@Setter
@Getter
public class Member implements IMember {
    private int id;
    public String firstName;
    private String lastName;
    //    private Calendar dateOfBirth;
    private long pesel;
    private Address address;
    private int contactNumber;
    private String email;
    //    private List<String> healthIssues;
    private int emergencyContact;
    public static List<Member> members = new ArrayList<>();

    public Member(String firstName, String lastName, int contactNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNumber = contactNumber;
    }

    public Member() {

    }

    @Override
    public void removeMember(Member member) {
        members.remove(member);
    }

    @Override
    public boolean addMember(Member member) {
        return members.add(member);
    }

    @Override
    public Member editMember(BigInteger contactNumber) {





        return null;
    }

//    @Override
//    public List<Member> sortByAge() {
//        members.sort((o1, o2) -> o1.getDateOfBirth().compareTo(o2.getDateOfBirth()));
//        return members;
//    }

    public static class MemberBuilder {
        private int id;
        private String firstName;
        private String lastName;
        private Calendar dateOfBirth;
        private long pesel;
        private Address address;
        private int contactNumber;
        private String email;
        private List<String> healthIssues;
        private int emergencyContact;

        public MemberBuilder(String firstName, String lastName, int contactNumber) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.contactNumber = contactNumber;

        }

        public MemberBuilder withDateOfBith(Calendar dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public MemberBuilder withPesel(long pesel) {
            this.pesel = pesel;
            return this;
        }

        public MemberBuilder withHealthIssues(List<String> healthIssues) {
            this.healthIssues = healthIssues;
            return this;
        }

        public MemberBuilder withEmergencyContact(int emergencyContact) {
            this.emergencyContact = emergencyContact;
            return this;
        }

        public MemberBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Member create() {
            Member member = new Member();
            member.setFirstName(this.firstName);
            member.setLastName(this.lastName);
            member.setContactNumber(this.contactNumber);
//            member.setDateOfBirth(this.dateOfBirth);
            member.setPesel(this.pesel);
//            member.setHealthIssues(this.healthIssues);
            member.setEmergencyContact(this.emergencyContact);
            member.setEmail(this.email);

            return member;

        }
    }
}

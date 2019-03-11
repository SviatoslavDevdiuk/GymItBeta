package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@ToString
@Getter
@Setter
public class Member implements IMember {
    private int id;
    private String fullName;
    //    private Calendar dateOfBirth;
    private long pesel;
    private Address address;
        private int contactNumber;
    private String email;
    //    private List<String> healthIssues;
    private int emergencyContact;
    public static List<Member> members = new ArrayList<>();

    public Member(int id, String fullName, int contactNumber, String email) {
        this.id = id;
        this.fullName = fullName;
        this.contactNumber = contactNumber;
        this.email = email;
    }

    public Member() {

    }


    @Override
    public void removeMember(Member member) {
        members.remove(member);
    }

//    @Override
//    public List<Member> sortByAge() {
//        members.sort((o1, o2) -> o1.getDateOfBirth().compareTo(o2.getDateOfBirth()));
//        return members;
//    }

    public static class MemberBuilder {
        private int id;
        private String fullName;
        private Calendar dateOfBirth;
        private long pesel;
        private Address address;
        private int contactNumber;
        private String email;
        private List<String> healthIssues;
        private int emergencyContact;

        public MemberBuilder(String fullName, int contactNumber) {
            this.fullName = fullName;
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

        public Member create() {
            Member member = new Member();
            member.setFullName(this.fullName);
//            member.setContactNumber(this.contactNumber);
//            member.setDateOfBirth(this.dateOfBirth);
            member.setPesel(this.pesel);
//            member.setHealthIssues(this.healthIssues);
            member.setEmergencyContact(this.emergencyContact);
            member.setEmail(this.email);
            members.add(member);
            return member;

        }
    }
}

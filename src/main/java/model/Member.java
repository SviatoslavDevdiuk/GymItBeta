package model;

import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;
import java.util.List;

@Getter
@Setter
public class Member {
    private int id;
    private String fullName;
    private Calendar dateOfBirth;
    private int pesel;
    private Address address;
    private int contactNumber;
    private String email;
    private List<String> healthIssues;
    private int emergencyContact;

    public Member() {
    }

    public class MemberBuilder {
        private int id;
        private String fullName;
        private Calendar dateOfBirth;
        private int pesel;
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

        public MemberBuilder withPesel(int pesel) {
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
            member.setDateOfBirth(this.dateOfBirth);
            member.setPesel(this.pesel);
            member.setHealthIssues(this.healthIssues);
            member.setEmergencyContact(this.emergencyContact);
            member.setEmail(this.email);
            return member;
        }
    }
}

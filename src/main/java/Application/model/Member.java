package Application.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "MEMBERS4")
public class Member implements IMember {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "first_name")
    public String firstName;
    @Column(name = "last_name")
    private String lastName;
    //    private Calendar dateOfBirth;
//    private long pesel;
//    private Address address;
//    private int contactNumber;
    @Column(name = "email")
    private String email;
    //    private List<String> healthIssues;
//    private int emergencyContact;
//    public static List<Member> members = new ArrayList<>();

    public Member(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Member() {

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
//            member.setContactNumber(this.contactNumber);
//            member.setDateOfBirth(this.dateOfBirth);
//            member.setPesel(this.pesel);
            member.setEmail(this.email);

            return member;

        }
    }
}

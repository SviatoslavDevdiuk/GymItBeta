import com.opencsv.CSVWriter;
import model.Member;

import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        CSVWriter csvWriter = new CSVWriter(new FileWriter("members1.csv"));
        Member member = new Member.MemberBuilder("Sviatoslav Devdiuk",788148844)
                .withPesel(94051715).withEmergencyContact(844148788).create();

    }
}

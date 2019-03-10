package utils;

import com.opencsv.CSVWriter;
import model.Member;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SCVUtility {
    private String dataRaw;
    private List<Member> members;

//    public List<Member> readSCV(String file) {
//        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
//            while ((dataRaw = br.readLine()) != null) {
//                members = new ArrayList<>();
//            }
//            ;
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
    public void writeMemberToSCV(List<Member>members) throws IOException {
      String csvFile = "A:\\Projects\\GymIt\\members.csv";
      FileWriter fw = new FileWriter(csvFile);
      for (Member m:members){
          List<String>membersData = new ArrayList<>();
          membersData.addAll(Collections.singleton(members.toString()));
      }

    }

}

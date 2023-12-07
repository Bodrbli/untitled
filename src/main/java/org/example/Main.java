package org.example;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Patient> patientList = Dump.getDump();

//        Functions.getExpensesList(patientList); //forEach

//        System.out.println(Functions.getFirstPatient1999(patientList)); //findFirst

//        System.out.println(Functions.getMapFromList(patientList)); //collect

//        System.out.println(Functions.checkAgeMan(patientList)); //noneMatch

//        System.out.println(Functions.checkAgeMan(patientList)); //anyMatch
    }
}
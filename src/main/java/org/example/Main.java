package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Patient> patientList = Dump.getDump();
        Thread.sleep(2000);

        System.out.println(Functions.getMinExpPatient(patientList)); //min

        System.out.println(Functions.getMaxExpPatient(patientList)); //max

        System.out.println(Functions.getFirstPatient1999(patientList)); //findFirst

        System.out.println(Functions.checkAgeMan(patientList)); //anyMatch

        System.out.println(Functions.checkAgeMan(patientList)); //noneMatch

        System.out.println(Functions.getMapFromList(patientList)); //collect

        Functions.getExpensesList(patientList); //forEach

        System.out.println(Functions.checkNoneIllPatient(patientList)); //allMatch
    }
}
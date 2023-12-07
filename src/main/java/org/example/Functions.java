package org.example;

import java.time.LocalDate;
import java.time.Period;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.ChronoField;
import java.util.*;
import java.util.stream.Collectors;

public class Functions {

    private static java.time.chrono.ChronoLocalDate ChronoLocalDate;

    public static void getExpensesList(List<Patient> patients) { //forEach
        patients
                .stream()
                .map(p ->p.getFio() + " " + p.getExpenses())
                .forEach(System.out::println);
    }
    public static String getFirstPatient1999(List<Patient> patients) { //findFirst

         return patients
                .stream()
                .filter(p -> p.getBirthDate().getYear() == 1999 && p.getBirthDate().getMonthValue() == 12)
                .map(p ->p.getFio() + " " + p.getBirthDate())
                .findFirst()
                 .orElse("нет такого пациента");

    }
    public static Boolean checkAgeMan(List<Patient> patients) { //noneMatch
        LocalDate currentDate =LocalDate.now();
        return patients
                .stream()
                .noneMatch(p -> Period.between(p.getBirthDate(), currentDate).getYears() == 100);
    }
    public static Boolean checkAnyAgeMan(List<Patient> patients) { //anyMatch
        LocalDate currentDate =LocalDate.now();
        return patients
                .stream()
                .allMatch(p -> Period.between(p.getBirthDate(), currentDate).getYears() == 100);
    }

    public static Comparator<Patient> comp = Comparator
            .comparing(Patient::getBirthDate);

    /*public static Map<LocalDate, String> getMapFromList(List<Patient> patients) {

        Map<LocalDate, String> localDateStringMap;
        return localDateStringMap =
                patients
                .stream()
                .collect(Collectors.toMap(p -> p.getBirthDate(), p -> p.getFio()));
    }*/
}

package org.example;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

public class Functions {


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

    public static Map<LocalDate, String> getMapFromList(List<Patient> patients) { //collect

        Map<LocalDate, String> localDateStringMap;
        return localDateStringMap =
                patients
                .stream()
                .collect(Collectors.toMap(p -> p.getBirthDate(), p -> p.getFio()));
    }

    public static Comparator<Patient> comp = (p1, p2) -> { //comparator
        int result;
        result = p1.getExpenses()
                .stream()
                .reduce((acc, cur) -> acc + cur)
                .get()
                .compareTo(p2.getExpenses()
                        .stream()
                        .reduce((acc, cur) -> acc + cur)
                        .get());
        if (result == 0) {
            if (p1.getBirthDate().equals(p2.getBirthDate())) return 0;
            else if (p1.getBirthDate().isBefore(p2.getBirthDate())) {
                return 1;
            }
            else return -1;
        } else return result;
    };

    public static Patient getMaxExpPatient(List<Patient> patients) { //max
        return patients
                .stream()
                .max(comp)
                .get();
    }

    public static Patient getMinExpPatient(List<Patient> patients) { //min
        return  patients
                .stream()
                .min(comp)
                .get();
    }
    public static Boolean checkNoneIllPatient(List<Patient> patients) { //allMatch
        return patients
                .stream()
                .allMatch(p -> p.getExpenses().size() > 0);
    }
}

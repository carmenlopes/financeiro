package com.controlefinanceiro.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public abstract class DataUtils {

    public static LocalDate convertStringToDate(String data){
        Locale.setDefault(Locale.US);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(data, formatter);
    }

    public static LocalDate getLastDayofMonth(String data){
        LocalDate dataConvert = convertStringToDate(data);
        return dataConvert.withDayOfMonth(dataConvert.getMonth().length(dataConvert.isLeapYear()));
    }
}

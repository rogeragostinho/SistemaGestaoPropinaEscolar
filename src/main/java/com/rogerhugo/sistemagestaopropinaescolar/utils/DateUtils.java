package com.rogerhugo.sistemagestaopropinaescolar.utils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DateUtils {
    public static LocalDate dateToLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static Date localDateToDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public static java.sql.Date localDateToSqlDate(LocalDate localDate) {
        return java.sql.Date.valueOf(localDate);
    }
}

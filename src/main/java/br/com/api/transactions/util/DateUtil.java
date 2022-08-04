package br.com.api.transactions.util;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    public static boolean isPast(LocalDateTime dateTimeToBeValidated){
        int i = dateTimeToBeValidated.compareTo(LocalDateTime.now());
        if(i < 1){
            return false;
        }
        return true;
    }

    public static LocalDateTime convertStringOffSetDateTimeToLocalDateTime(String dateTimeWithOffSet){
        OffsetDateTime offsetDateTime = OffsetDateTime
                .parse(dateTimeWithOffSet, DateTimeFormatter.ISO_OFFSET_DATE_TIME);

        LocalDateTime localDateTime = offsetDateTime.toLocalDateTime();

        LocalDateTime currentLocalDateTime = localDateTime.plusSeconds(offsetDateTime.getOffset().getTotalSeconds());

        return currentLocalDateTime;
    }

}

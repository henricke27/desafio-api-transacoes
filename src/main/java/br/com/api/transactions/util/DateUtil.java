package br.com.api.transactions.util;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateUtil {

    public static long calculateSecondsDifference(LocalDateTime initialDate){
        return initialDate.until(LocalDateTime.now(), ChronoUnit.SECONDS);
    }

    public static LocalDateTime convertStringOffSetDateTimeToLocalDateTime(String dateTimeWithOffSet){
        OffsetDateTime offsetDateTime = OffsetDateTime
                .parse(dateTimeWithOffSet, DateTimeFormatter.ISO_OFFSET_DATE_TIME);

        LocalDateTime localDateTime = offsetDateTime.toLocalDateTime();

        LocalDateTime currentLocalDateTime = localDateTime.plusSeconds(offsetDateTime.getOffset().getTotalSeconds());

        return currentLocalDateTime;
    }

}

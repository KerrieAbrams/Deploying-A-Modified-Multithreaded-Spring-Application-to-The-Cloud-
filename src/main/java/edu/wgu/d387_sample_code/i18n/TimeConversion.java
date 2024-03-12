package edu.wgu.d387_sample_code.i18n;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeConversion {
    private ZoneId zEastern=ZoneId.of("America/New_York");

    private ZoneId zMountain= ZoneId.of("America/Denver");
    private ZoneId zUTC=ZoneId.of("UTC");
    private ZoneId zoneId=ZoneId.systemDefault();

    private String liveStreamTimes;

    public  String getLiveStreamTimes() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
        DateTimeFormatter dateStyle = DateTimeFormatter.ofPattern("dd LLL yyyy");
        LocalDateTime localDateTime=LocalDateTime.now();
        ZonedDateTime zonedDateTime=localDateTime.atZone(zoneId);

        ZonedDateTime zonedDateTimeEastern=zonedDateTime.withZoneSameInstant(zEastern);
        LocalDateTime localDateTimeEastern=zonedDateTimeEastern.toLocalDateTime();

        ZonedDateTime zonedDateTimeMountain =zonedDateTime.withZoneSameInstant(zMountain);
        LocalDateTime localDateTimeMountain=zonedDateTimeMountain.toLocalDateTime();

        ZonedDateTime zonedDateTimeUTC =zonedDateTime.withZoneSameInstant(zUTC);
        LocalDateTime localDateTimeUTC=zonedDateTimeUTC.toLocalDateTime();

        liveStreamTimes = (localDateTime.format(dateStyle) + " at " + localDateTimeEastern.format(formatter) + " ET| " + localDateTimeMountain.format(formatter) + " MT| " + localDateTimeUTC.format(formatter) + " UTC");

        return liveStreamTimes;
    }


}

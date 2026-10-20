package org.parking_lot.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;

public class DateTimeParser {
    static public LocalDateTime parse(String input) {
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .parseCaseInsensitive()
                .appendPattern("d MMMM h:mm a yyyy")
                .toFormatter(Locale.ENGLISH);

        return LocalDateTime.parse(input, formatter);
    }
}

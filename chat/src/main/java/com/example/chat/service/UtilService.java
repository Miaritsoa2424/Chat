package com.example.chat.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class UtilService {
    public static String getTimeAgo(LocalDateTime dateTime) {
        if (dateTime == null) {
            return "";
        }
        
        LocalDateTime now = LocalDateTime.now();
        long days = ChronoUnit.DAYS.between(dateTime, now);
        long hours = ChronoUnit.HOURS.between(dateTime, now);
        long minutes = ChronoUnit.MINUTES.between(dateTime, now);

        if (days > 0) {
            return days + " j";
        } else if (hours > 0) {
            return hours + " h";
        } else if (minutes > 0) {
            return minutes + " min";
        } else {
            return "à l'instant";
        }
    }
}

package com.josealmir.gymmanagementsystem.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GymLogger {

    private static GymLogger instance;
    private static final String LOG_FILE = "gym-activities.log";

    private GymLogger() {}

    public static GymLogger getInstance() {
        if (instance == null) {
            synchronized (GymLogger.class) {
                if (instance == null) {
                    instance = new GymLogger();
                }
            }
        }
        return instance;
    }

    public void log(String message) {
        try (PrintWriter out = new PrintWriter(new FileWriter(LOG_FILE, true))) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String timestamp = dateFormat.format(new Date());
            out.println(timestamp + " - " + message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

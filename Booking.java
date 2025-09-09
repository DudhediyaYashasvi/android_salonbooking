package com.snjb.myapplication;

public class Booking {
    private String name, email, phone, date, time, service;

    public Booking(String name, String email, String phone, String date, String time, String service) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.date = date;
        this.time = time;
        this.service = service;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getDate() { return date; }
    public String getTime() { return time; }
    public String getService() { return service; }
}
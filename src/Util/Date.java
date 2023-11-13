package Util;

public class Date {
    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public void setDate(int new_day, int new_month, int new_year){
        this.day = new_day;
        this.month = new_month;
        this.year = new_year;
    }

    public String getDate() {
        return String.format("%02d/%02d/%04d", day, month, year);
    }
}


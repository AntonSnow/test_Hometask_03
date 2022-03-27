package by.training.java.module_4.programming_with_classes.task06;

public class Time {

    private int hour;
    private int minute;
    private int second;

    public Time() {
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
    }

    public String getCurrentTime() {
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }

    public void setTime(String fullTime, int parameter) {
        String[] arrayTime = fullTime.split(" ");
        if (arrayTime.length == 3 && !fullTime.matches("(.*)[a-zа-яA-ZА-Я]+(.*)")) {
            Integer enteredHours = Integer.valueOf(arrayTime[0]);
            Integer enteredMinute = Integer.valueOf(arrayTime[1]);
            Integer enteredSecond = Integer.valueOf(arrayTime[2]);

            if (parameter == 1) {
                setHour(enteredHours);
                setMinute(enteredMinute);
                setSecond(enteredSecond);
            } else {

                this.second += enteredSecond;
                if (getSecond() > 0) {
                    this.minute += this.second / 60;
                    this.second %= 60;
                }
                this.minute += enteredMinute;
                if (getMinute() > 0) {
                    this.hour += this.minute / 60;
                    this.minute %= 60;
                }
                this.hour += enteredHours;
                if (getHour() > 0) {
                    this.hour %= 24;

                }
            }
        }
    }

    public void setHour(int number) {
        if (number >= 0 && number <= 23) {
            this.hour = number;
        } else {
            this.hour = 0;
        }
    }

    public void setMinute(int number) {
        if (number >= 0 && number <= 59) {
            this.minute = number;
        } else {
            this.minute = 0;
        }
    }

    public void setSecond(int number) {
        if (number >= 0 && number <= 59) {
            this.second = number;
        } else {
            this.second = 0;
        }
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }
}

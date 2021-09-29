package com.dlex.OOC.Week2.MyDate;

public class MyDate {
    private int year;
    private int month;
    private int day;

    private final static String[] strMonths = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    private final static String[] strDays = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    private final static int[] daysInMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public MyDate(int year, int month, int day) throws ArithmeticException {
        if (!isValidDate(year, month, day)) {
            throw new ArithmeticException("Invalid year, month, or day!");
        }
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void setDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public boolean isLeapYear(int year)  {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    public boolean isValidDate(int year, int month, int day) {
        int count = 0;
        if ((year >= 1 && year <= 9999) && (month >= 1 && month <= 12)) {
            count += 1;
            boolean check = isLeapYear(year);
            int range = daysInMonths[month - 1];
            if (month == 2 && check && day >= 1 && day <= 29) {
                count += 1;
            } else if (month == 2 && day >= 1 && day <= 28) {
                count += 1;
            } else if (day >= 1 && day <= range) {
                count += 1;
            }
        }
        return count == 2;
    }

    public int getDayOfWeek(int year, int month, int day) {
        if (month < 3) {
            month += 12;
            year -= 1;
        }
        int value = ((13 * month + 3) / 5 + day + year + year / 4 - year / 100 + year / 400) % 7 + 1;
        return value == 7 ? 0 : value;
    }

    public MyDate nextDay() {
        MyDate myDate;
        boolean checkMonth = this.month == 2;
        boolean checkDay = daysInMonths[this.month - 1 ] == this.day;
        boolean check = isLeapYear(this.year);
        if (check && checkMonth && checkDay) {
            myDate = new MyDate(this.year, this.month, this.day + 1);
        } else if ((check && checkMonth && this.day == 29) || !check && checkMonth && checkDay) {
            myDate = new MyDate(this.year, this.month + 1,  1);
        } else if (this.month == 12 && checkDay) {
            myDate = new MyDate(this.year + 1 , 1, 1);
        } else if (checkDay) {
            myDate = new MyDate(this.year, this.month + 1, 1);
        } else {
            myDate = new MyDate(this.year, this.month, this.day + 1);
        }
        setDate(myDate.getYear(), myDate.getMonth(), myDate.getDay());
        return myDate;
    }

    public MyDate nextMonth() {
        MyDate myDate;
        boolean checkDay = daysInMonths[this.month - 1] == this.day;
        boolean check = isLeapYear(this.year);
        if (check && this.month == 1 && checkDay) {
            myDate = new MyDate(this.year, this.month + 1, 29);
        } else if (this.month == 12 && checkDay) {
            myDate = new MyDate(this.year + 1, 1, daysInMonths[0]);
        } else if ((this.month != 12 && checkDay) || (check && this.month == 2 && this.day == 29)) {
            myDate = new MyDate(this.year, this.month + 1, daysInMonths[this.month]);
        } else if (this.month == 12) {
            myDate = new MyDate(this.year + 1,  1, this.day);
        } else {
            myDate = new MyDate(this.year, this.month + 1, this.day);
        }
        setDate(myDate.getYear(), myDate.getMonth(), myDate.getDay());
        return myDate;
    }

    public MyDate nextYear() {
        MyDate myDate;
        if (isLeapYear(this.year + 1) && this.month == 2 && this.day == 28) {
            myDate = new MyDate(this.year + 1, this.month, 29);
        } else {
            myDate = new MyDate(this.year + 1, this.month, this.day);
        }
        setDate(myDate.getYear(), myDate.getMonth(), myDate.getDay());
        return myDate;
    }


    public MyDate previousDay() {
        MyDate myDate;
        if (isLeapYear(this.year) && this.month == 3 && this.day == 1) {
            myDate = new MyDate(this.year, this.month - 1, 29);
        } else if (this.month == 1 && this.day == 1) {
            myDate = new MyDate(this.year - 1, 12, 31);
        } else if (this.day == 1) {
            myDate = new MyDate(this.year, this.month - 1, daysInMonths[this.month - 2]);
        } else {
            myDate = new MyDate(this.year, this.month, this.day - 1);
        }
        setDate(myDate.getYear(), myDate.getMonth(), myDate.getDay());
        return myDate;
    }

    public MyDate previousMonth() {
        MyDate myDate;
        boolean checkDay = daysInMonths[this.month - 1] == this.day;
        boolean check = isLeapYear(this.year);
        if (check && this.month == 3 && daysInMonths[this.month - 2] < this.day) {
            myDate = new MyDate(this.year, this.month - 1, 29);
        } else if ((check && this.month == 3 && checkDay) || (check && this.month == 2 && this.day == 29) || (this.month != 1  && checkDay) || (this.month == 3 && daysInMonths[this.month - 2] <= this.day)) {
            myDate = new MyDate(this.year, this.month - 1, daysInMonths[this.month - 2]);
        } else if (this.month == 1) {
            myDate = new MyDate(this.year - 1,  12, this.day);
        } else {
            myDate = new MyDate(this.year, this.month - 1, this.day);
        }
        setDate(myDate.getYear(), myDate.getMonth(), myDate.getDay());
        return myDate;
    }

    public MyDate previousYear() {
        MyDate myDate;
        boolean check = isLeapYear(this.year - 1);
        if (check && this.month == 2 && this.day == 28) {
            myDate =  new MyDate(this.year - 1, this.month, 29);
        } else if (!check && this.month == 2 && this.day == 29) {
            myDate =  new MyDate(this.year - 1, this.month, daysInMonths[this.month - 1]);
        } else {
            myDate =  new MyDate(this.year - 1, this.month, this.day);
        }
        setDate(myDate.getYear(), myDate.getMonth(), myDate.getDay());
        return myDate;
    }


    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return strDays[getDayOfWeek(this.year, this.month, this.day)] + " " + this.day + " " + strMonths[this.month - 1] + " " + this.year;
    }

}

package com.ls.awajimatradeeder.Classes;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.format.DateFormat;

import com.ls.awajimatradeeder.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static com.ls.awajimatradeeder.Classes.Profile.PROFILES_TABLE;
import static com.ls.awajimatradeeder.Classes.Profile.PROFILE_ID;

public class Birthday {
    public static final String BIRTHDAY_TABLE = "birthday_table";

    public static final String BIRTHDAY_STATUS = "bbirthday_status";
    public static final String BIRTHDAY_ID = "bbirth_id";
    public static final String BIRTHDAY_DAYS_REMAINING = "bdays_remaining";
    public static final String BIRTHDAY_DAYS_BTWN = "bdays_between";

    public static final String B_FIRSTNAME = "b_FirstName";
    public static final String B_SURNAME = "b_Surname";
    public static final String B_EMAIL = "b_Email";
    public static final String B_PHONE = "b_Phone";
    public static final String B_DOB = "b_DOb";
    public static final String B_PROF_ID = "b_Prof_ID";



    public static final String CREATE_BIRTHDAY_TABLE = "CREATE TABLE IF NOT EXISTS " + BIRTHDAY_TABLE + " (" + B_PROF_ID + " INTEGER , " + BIRTHDAY_ID + " INTEGER PRIMARY KEY   , " +
            B_FIRSTNAME + " TEXT, " + B_SURNAME + " TEXT, " + B_EMAIL + " TEXT, " + B_PHONE + " TEXT, " +
            B_DOB + " TEXT, " + BIRTHDAY_DAYS_REMAINING + " TEXT, " + BIRTHDAY_DAYS_BTWN + " TEXT, " + BIRTHDAY_STATUS + " TEXT, " + "FOREIGN KEY(" + B_PROF_ID + ") REFERENCES " + PROFILES_TABLE + "(" + PROFILE_ID + "))";


    @SuppressLint("ConstantLocale")
    private final static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
            "yyyy-MM-dd", Locale.getDefault());


    private static final int DAY_IN_MILLIS = 86400000;
    private String bFirstName;
    private String bSurName;
    private String bGender;
    private int birthdayID=12;
    private int bProfileID;
    private String bPhoneNumber;
    private String bEmail;
    private String bAddress;
    private String bStatus;
    private String bDate;
    private Date date;
    private boolean bRemind;
    private  int bYearOfBirth =0;
    private  boolean bShowYear =false;
    private Profile bProfile;
    Context bContext;
    private Date birthDay;
    private String bDaysRemaining;
    private int bDaysBtwn;
    public Birthday() {
        super();
    }

    public Birthday(int profileID, int birthdayID, String name, String phoneNumber, String email,  String date, int daysBTWN, String daysRemaining, String status) {
        this.bFirstName = name.toUpperCase();
        this.bProfileID = profileID;
        this.birthdayID = birthdayID;
        this.bPhoneNumber = phoneNumber;
        this.bEmail = email;
        this.bDate = date;
        this.bStatus = status;
        this.bDaysBtwn =daysBTWN;
        this.bDaysRemaining = daysRemaining;
    }
    public Birthday(int profileID, int birthdayID, String name, String phoneNumber, String email,  String date) {
        this.bFirstName = name.toUpperCase();
        this.bProfileID = profileID;
        this.birthdayID = birthdayID;
        this.bPhoneNumber = phoneNumber;
        this.bEmail = email;
        this.bDate = date;

    }

    public String getbFirstName() {
        return bFirstName;
    }

    public void setbFirstName(String bFirstName) {
        this.bFirstName = bFirstName;
    }

    public String getbSurName() {
        return bSurName;
    }

    public void setbSurName(String bSurName) {
        this.bSurName = bSurName;
    }

    public String getbGender() {
        return bGender;
    }

    public void setbGender(String bGender) {
        this.bGender = bGender;
    }

    public int getBirthdayID() {
        return birthdayID;
    }

    public void setBirthdayID(int birthdayID) {
        this.birthdayID = birthdayID;
    }

    public int getbProfileID() {
        return bProfileID;
    }

    public void setbProfileID(int bProfileID) {
        this.bProfileID = bProfileID;
    }

    public String getbPhoneNumber() {
        return bPhoneNumber;
    }

    public void setbPhoneNumber(String bPhoneNumber) {
        this.bPhoneNumber = bPhoneNumber;
    }

    public String getbEmail() {
        return bEmail;
    }

    public void setbEmail(String bEmail) {
        this.bEmail = bEmail;
    }

    public String getbAddress() {
        return bAddress;
    }

    public void setbAddress(String bAddress) {
        this.bAddress = bAddress;
    }

    public String getbStatus() {
        return bStatus;
    }

    public void setbStatus(String bStatus) {
        this.bStatus = bStatus;
    }

    public String getbDate() {
        return bDate;
    }

    public void setbDate(String bDate) {
        this.bDate = bDate;
    }

    public boolean isbRemind() {
        return bRemind;
    }

    public void setbRemind(boolean bRemind) {
        this.bRemind = bRemind;
    }

    public int getbYearOfBirth() {
        return bYearOfBirth;
    }

    public void setbYearOfBirth(int bYearOfBirth) {
        this.bYearOfBirth = bYearOfBirth;
    }

    public boolean isbShowYear() {
        return bShowYear;
    }

    public void setbShowYear(boolean bShowYear) {
        this.bShowYear = bShowYear;
    }

    public Profile getbProfile() {
        return bProfile;
    }

    public void setbProfile(Profile bProfile) {
        this.bProfile = bProfile;
    }

    public String getbDaysRemaining() {
        return bDaysRemaining;
    }

    public void setbDaysRemaining(String bDaysRemaining) {
        this.bDaysRemaining = bDaysRemaining;
    }

    public int getbDaysBtwn() {
        return bDaysBtwn;
    }

    public void setbDaysBtwn(int bDaysBtwn) {
        this.bDaysBtwn = bDaysBtwn;
    }
    public String getFormattedDaysRemainingString(String currentDate,String dateOfBirth) {
        int i = getDaysInBetween(currentDate,dateOfBirth);


        if (i == 0) {
            return (bContext.getString(R.string.date_today) + "!");
        } else if (i == 1) {
            return (bContext.getString(R.string.date_tomorrow) + "!");
        } else if (i == -1) {

            return bContext.getString(R.string.date_yesterday);
        } else if (i > 1 && i <= 6) {
            Date newDate = new Date();
            newDate.setTime(getBirthDay().getTime() - DAY_IN_MILLIS);
            return (String) DateFormat.format("EEEE", newDate);
        } else if (i == 7) {
            return (bContext.getString(R.string.date_week));
        } else if (i < 9) {
            return " " + String.valueOf(i) + " " + bContext.getString(R.string.date_days);
        } else if (i > 99) {
            return "  " + String.valueOf(i) + " " + bContext.getString(R.string.date_days);
        } else {
            return "" + i + " " + bContext.getString(R.string.date_days);
        }
    }
    public String getAge() {
        Date birthDate = getBirthDay();

        int year = this.getbYearOfBirth();

        Calendar calendarBirthday = Calendar.getInstance();
        calendarBirthday.set(year, birthDate.getMonth(), birthDate.getDate());

        Calendar nextBirthdate = Calendar.getInstance();
        nextBirthdate.set(getYearOfNextBirthday(birthDate), birthDate.getMonth(), birthDate.getDate());

        int age = nextBirthdate.get(Calendar.YEAR) - calendarBirthday.get(Calendar.YEAR);

        if (nextBirthdate.get(Calendar.MONTH) > calendarBirthday.get(Calendar.MONTH) ||
                (nextBirthdate.get(Calendar.MONTH) == calendarBirthday.get(Calendar.MONTH) &&
                        nextBirthdate.get(Calendar.DATE) > calendarBirthday.get(Calendar.DATE))) {
            age--;
        }

        if (age < 0) {
            return "N/A";
        } else {
            return String.valueOf(age);
        }
    }

    public int getDaysInBetween( String currentDate,String dateOfBirth) {
        int daysBetween = (int) getDayCount(currentDate, dateOfBirth);

        if (daysBetween == 366) {
            daysBetween = 0;
        }
        return daysBetween;
    }


    public static long getDayCount(String start, String end) {

        long dayCount = 0;
        try {
            Date dateStart = simpleDateFormat.parse(start);
            Date dateEnd = simpleDateFormat.parse(end);
            if (dateStart != null) {
                if (dateEnd != null) {
                    dayCount = Math.round((dateEnd.getTime() - dateStart.getTime())
                            / (double) DAY_IN_MILLIS);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dayCount;
    }

    public static int getYearOfNextBirthday(Date date) {

        int year = 2014;
        date.setYear(year);

        boolean nowAhead = dateInFuture(date);

        // While date instance is in the past, increase by a year and check again
        while (nowAhead) {

            year += 1;
            date.setYear(year);

            nowAhead = dateInFuture(date);
        }
        return year;
    }


    private static boolean dateInFuture(Date queryDate) {

        Calendar nowCal = Calendar.getInstance();

        Date now = new Date();
        now.setYear(nowCal.get(Calendar.YEAR));
        now.setMonth(nowCal.get(Calendar.MONTH));
        now.setDate(nowCal.get(Calendar.DATE));

        long millisNow = now.getTime();
        long millisBDAY = queryDate.getTime();

        return millisNow > millisBDAY + DAY_IN_MILLIS;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }
}

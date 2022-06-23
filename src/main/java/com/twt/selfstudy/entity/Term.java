package com.twt.selfstudy.entity;

public class Term {
    static private String term;
    static private String currentYear;
    static private int startWeek;
    static private int weekLen;

    public static String getTerm() {
        return term;
    }

    public static void setTerm(String term) {
        Term.term = term;
    }

    public static String getCurrentYear() {
        return currentYear;
    }

    public static void setCurrentYear(String currentYear) {
        Term.currentYear = currentYear;
    }

    public static int getStartWeek() {
        return startWeek;
    }

    public static void setStartWeek(int startWeek) {
        Term.startWeek = startWeek;
    }

    public static int getWeekLen() {
        return weekLen;
    }

    public static void setWeekLen(int weekLen) {
        Term.weekLen = weekLen;
    }
}

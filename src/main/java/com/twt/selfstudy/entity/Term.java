package com.twt.selfstudy.entity;

public class Term {
    static private String term = "21221";
    static private String currentYear = "2021";

    static public String getTerm() {
        return term;
    }

    static public void setTerm(String term) {
        Term.term = term;
    }

    public static String getCurrentYear() {
        return currentYear;
    }

    public static void setCurrentYear(String currentYear) {
        Term.currentYear = currentYear;
    }
}
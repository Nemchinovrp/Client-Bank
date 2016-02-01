package com.becomejavasenior.controllers;

/**
 * Created by Roman on 01.02.2016.
 */
public class ConvertDate {
    public static java.sql.Date convert( java.util.Date javaDate) {
        java.sql.Date sqlDate = null;
        if (javaDate != null) { sqlDate = new java.sql.Date(javaDate.getTime());
        }
        return sqlDate;
    }
}

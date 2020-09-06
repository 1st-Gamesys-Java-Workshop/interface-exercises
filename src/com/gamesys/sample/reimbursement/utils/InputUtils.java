package com.gamesys.sample.reimbursement.utils;

public class InputUtils {

    public static boolean isValid(String value) {
        return value == null || value.isEmpty();
    }

    public static boolean isAnAmount(String value) {
        return value.matches("[0-9]+");
    }

}

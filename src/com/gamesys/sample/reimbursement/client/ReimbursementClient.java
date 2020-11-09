package com.gamesys.sample.reimbursement.client;

public interface ReimbursementClient {

    void execute();

    default String getInputFor(String fieldName) {
        return null;
    }

    static boolean isValid(String value) {
        return value == null || value.isEmpty();
    }

}

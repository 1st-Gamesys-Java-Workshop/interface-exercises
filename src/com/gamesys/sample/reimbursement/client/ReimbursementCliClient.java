package com.gamesys.sample.reimbursement.client;

import com.gamesys.sample.reimbursement.core.ReimbursementService;

import java.math.BigDecimal;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReimbursementCliClient {

    private final ReimbursementService reimbursementService;
    private final Scanner inputScanner = new Scanner(System.in);

    public ReimbursementCliClient(ReimbursementService reimbursementService) {
        this.reimbursementService = reimbursementService;
    }

    public void execute() {
        String itemName = getInputFor("Item name");
        String amount = getInputFor("Amount");
        String receiptUrl = getInputFor("Receipt URL");

        reimbursementService.reimburse(itemName, new BigDecimal(amount), receiptUrl);
    }

    private String getInputFor(String fieldName) {
        String input;

        do {
            System.out.print("Enter " + fieldName + ": ");
            input = getInputValue();
        } while (input.isEmpty());

        return input;
    }

    private String getInputValue() {
        try {
            return inputScanner.nextLine();
        } catch (NoSuchElementException e) {
            return "";
        }
    }

    @Override
    protected void finalize() throws Throwable {
        inputScanner.close();
    }
}

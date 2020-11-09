package com.gamesys.sample.reimbursement.client;

import com.gamesys.sample.reimbursement.core.ReimbursementService;
import com.gamesys.sample.reimbursement.utils.InputUtils;

import java.math.BigDecimal;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReimbursementCliClient implements ReimbursementClient {

    private final ReimbursementService reimbursementService;
    private final Scanner inputScanner = new Scanner(System.in);

    public ReimbursementCliClient(ReimbursementService reimbursementService) {
        this.reimbursementService = reimbursementService;
    }

    @Override
    public void execute() {
        String itemName = getInputFor("Item name");
        String amount;
        do {
            amount = getInputFor("Amount");
        } while (!InputUtils.isAnAmount(amount));
        String receiptUrl = getInputFor("Receipt URL");

        String bank = getInputFor("Bank");
        String accountNumber = getInputFor("Account Number");

        reimbursementService.reimburseWithBank(itemName, new BigDecimal(amount), receiptUrl, bank, accountNumber);
    }

    @Override
    public String getInputFor(String fieldName) {
        String input;

        do {
            System.out.print("Enter " + fieldName + ": ");
            input = getInputValue();
        } while (InputUtils.isValid(input));

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

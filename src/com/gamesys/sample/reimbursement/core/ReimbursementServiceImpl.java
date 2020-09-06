package com.gamesys.sample.reimbursement.core;

import java.math.BigDecimal;

public class ReimbursementServiceImpl implements ReimbursementService {

    private final ReimbursementGateway reimbursementGateway;
    private final ReceiptGateway receiptGateway;

    public ReimbursementServiceImpl(ReimbursementGateway reimbursementGateway, ReceiptGateway receiptGateway) {
        this.reimbursementGateway = reimbursementGateway;
        this.receiptGateway = receiptGateway;
    }

    @Override
    public void reimburse(String itemName, BigDecimal amount, String receiptUrl) {
        Reimbursement reimbursement = new Reimbursement(itemName, amount, receiptUrl);
        reimbursementGateway.save(reimbursement);
        receiptGateway.save(receiptUrl);
    }

}

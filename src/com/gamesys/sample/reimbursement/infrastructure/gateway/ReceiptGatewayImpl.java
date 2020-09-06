package com.gamesys.sample.reimbursement.infrastructure.gateway;

import com.gamesys.sample.reimbursement.core.ReceiptGateway;

public class ReceiptGatewayImpl implements ReceiptGateway {

    @Override
    public void save(String receiptUrl) {
        // Do Nothing
        System.out.println("Receipt " + receiptUrl + " saved.");
    }

}

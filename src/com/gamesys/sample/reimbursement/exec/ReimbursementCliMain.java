package com.gamesys.sample.reimbursement.exec;

import com.gamesys.sample.reimbursement.client.ReimbursementCliClient;
import com.gamesys.sample.reimbursement.client.ReimbursementClient;
import com.gamesys.sample.reimbursement.core.*;
import com.gamesys.sample.reimbursement.infrastructure.gateway.ReceiptGatewayImpl;
import com.gamesys.sample.reimbursement.infrastructure.gateway.ReimbursementGatewayImpl;

public class ReimbursementCliMain {

    public static void main(String[] args) {
        ReimbursementGateway reimbursementGateway = new ReimbursementGatewayImpl();
        ReceiptGateway receiptGateway = new ReceiptGatewayImpl();
        ReimbursementWithBankService reimbursementService = new ReimbursementServiceImpl(reimbursementGateway, receiptGateway);

        ReimbursementClient cliClient = new ReimbursementCliClient(reimbursementService);
        cliClient.execute();
    }

}

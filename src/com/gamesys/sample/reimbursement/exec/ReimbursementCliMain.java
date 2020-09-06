package com.gamesys.sample.reimbursement.exec;

import com.gamesys.sample.reimbursement.client.ReimbursementCliClient;
import com.gamesys.sample.reimbursement.core.ReceiptGateway;
import com.gamesys.sample.reimbursement.core.ReimbursementGateway;
import com.gamesys.sample.reimbursement.core.ReimbursementService;
import com.gamesys.sample.reimbursement.core.ReimbursementServiceImpl;
import com.gamesys.sample.reimbursement.infrastructure.gateway.ReceiptGatewayImpl;
import com.gamesys.sample.reimbursement.infrastructure.gateway.ReimbursementGatewayImpl;

public class ReimbursementCliMain {

    public static void main(String[] args) {
        ReimbursementGateway reimbursementGateway = new ReimbursementGatewayImpl();
        ReceiptGateway receiptGateway = new ReceiptGatewayImpl();
        ReimbursementService reimbursementService = new ReimbursementServiceImpl(reimbursementGateway, receiptGateway);

        ReimbursementCliClient cliClient = new ReimbursementCliClient(reimbursementService);
        cliClient.execute();
    }

}

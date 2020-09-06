package com.gamesys.sample.reimbursement.exec;

import com.gamesys.sample.reimbursement.client.ReimbursementClient;
import com.gamesys.sample.reimbursement.client.ReimbursementTcpClient;
import com.gamesys.sample.reimbursement.core.ReceiptGateway;
import com.gamesys.sample.reimbursement.core.ReimbursementGateway;
import com.gamesys.sample.reimbursement.core.ReimbursementService;
import com.gamesys.sample.reimbursement.core.ReimbursementServiceImpl;
import com.gamesys.sample.reimbursement.infrastructure.gateway.ReceiptGatewayImpl;
import com.gamesys.sample.reimbursement.infrastructure.gateway.ReimbursementGatewayImpl;

public class ReimbursementTcpMain {

    public static void main(String[] args) {
        ReimbursementGateway reimbursementGateway = new ReimbursementGatewayImpl();
        ReceiptGateway receiptGateway = new ReceiptGatewayImpl();
        ReimbursementService reimbursementService = new ReimbursementServiceImpl(reimbursementGateway, receiptGateway);

        ReimbursementClient tcpClient = new ReimbursementTcpClient(reimbursementService);
        tcpClient.execute();
    }

}

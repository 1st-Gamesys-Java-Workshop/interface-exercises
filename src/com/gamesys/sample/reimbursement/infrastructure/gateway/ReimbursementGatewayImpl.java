package com.gamesys.sample.reimbursement.infrastructure.gateway;

import com.gamesys.sample.reimbursement.core.Reimbursement;
import com.gamesys.sample.reimbursement.core.ReimbursementGateway;

public class ReimbursementGatewayImpl implements ReimbursementGateway {

    @Override
    public void save(Reimbursement reimbursement) {
        // Do Nothing
        System.out.println("Reimbursement saved.");
    }

}

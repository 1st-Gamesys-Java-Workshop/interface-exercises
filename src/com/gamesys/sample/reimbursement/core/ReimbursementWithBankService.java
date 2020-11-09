package com.gamesys.sample.reimbursement.core;

import java.math.BigDecimal;

public interface ReimbursementWithBankService extends ReimbursementService {

    void reimburseWithBank(
            String itemName,
            BigDecimal amount,
            String receiptUrl,
            String bank,
            String accountNumber);

}

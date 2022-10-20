package capstone.project.model;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ReportIncomeRequest {
    private UUID incomeId;
    private String incomeFrom;
    private String amount;
    private String accountNumber;
    private String accountName;
    private String proofTrans;
}

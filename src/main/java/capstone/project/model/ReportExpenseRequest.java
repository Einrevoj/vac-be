package capstone.project.model;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ReportExpenseRequest {

    private UUID expenseId;
    private String expenseFrom;
    private String amount;
    private String accountNumber;
    private String withdrawnFrom;
    private String proofTrans;
}

package capstone.project.dto;

import lombok.Data;

import java.time.ZonedDateTime;
import java.util.UUID;

@Data
public class ReportExpenseDTO {

    private UUID expenseId;
    private String expenseFrom;
    private String amount;
    private String withdrawnFrom;
    private String accountNumber;
    private String proofTrans;
    private ZonedDateTime createdDate;
    private ZonedDateTime modifiedDate;
}

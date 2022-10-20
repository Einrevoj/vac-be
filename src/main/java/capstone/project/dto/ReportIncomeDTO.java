package capstone.project.dto;

import lombok.Data;

import java.time.ZonedDateTime;
import java.util.UUID;

@Data
public class ReportIncomeDTO {

    private UUID incomeId;
    private String incomeFrom;
    private String amount;
    private String accountNumber;
    private String accountName;
    private String proofTrans;
    private ZonedDateTime createdDate;
    private ZonedDateTime modifiedDate;
}

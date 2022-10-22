package capstone.project.dto;

import lombok.Data;

import java.time.ZonedDateTime;
import java.util.UUID;

@Data
public class InvestmentDTO {

    private UUID investmentId;
    private String investmentTo;
    private String platformUsed;
    private String withdrawnFrom;
    private String amount;
    private String proofTrans;
    private ZonedDateTime createdDate;
    private ZonedDateTime modifiedDate;
}

package capstone.project.model;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class InvestmentRequest {
    private UUID investmentId;
    private String investmentTo;
    private String platFormUsed;
    private String withdrawnFrom;
    private String amount;
    private String proofTrans;
}

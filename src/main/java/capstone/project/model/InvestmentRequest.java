package capstone.project.model;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class InvestmentRequest {

    private String investmentTo;
    private String platformUsed;
    private String withdrawnFrom;
    private String amount;
    private String proofTrans;
}

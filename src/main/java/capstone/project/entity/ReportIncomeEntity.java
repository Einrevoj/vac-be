package capstone.project.entity;

import capstone.project.config.SchemaConfiguration;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Setter
@ToString
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = SchemaConfiguration.SCHEMA_NAME, name = "REPORTINCOME")
public class ReportIncomeEntity {

    @Id
    private UUID incomeId;
    private String incomeFrom;
    private String amount;
    private String accountNumber;
    private String accountName;
    private String proofTrans;
    private ZonedDateTime createdDate;
    private ZonedDateTime modifiedDate;
}

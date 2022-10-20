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
@Table(schema = SchemaConfiguration.SCHEMA_NAME, name = "REPORTEXPENSE")
public class ReportExpenseEntity {

    @Id
    private UUID expenseId;
    private String expenseFrom;
    private String amount;
    private String withdrawnFrom;
    private String accountNumber;
    private String proofTrans;
    private ZonedDateTime createdDate;
    private ZonedDateTime modifiedDate;
}

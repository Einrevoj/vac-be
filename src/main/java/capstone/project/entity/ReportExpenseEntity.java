package capstone.project.entity;

import capstone.project.config.SchemaConfiguration;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.ZonedDateTime;
import java.util.Objects;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ReportExpenseEntity that = (ReportExpenseEntity) o;
        return expenseId != null && Objects.equals(expenseId, that.expenseId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

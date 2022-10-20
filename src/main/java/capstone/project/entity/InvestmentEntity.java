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
@Table(schema = SchemaConfiguration.SCHEMA_NAME, name = "INVESTMENT")
public class InvestmentEntity {

    @Id
    private UUID investmentId;
    private String investmentTo;
    private String platFormUsed;
    private String withdrawnFrom;
    private String amount;
    private String proofTrans;
    private ZonedDateTime createdDate;
    private ZonedDateTime modifiedDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        InvestmentEntity that = (InvestmentEntity) o;
        return investmentId != null && Objects.equals(investmentId, that.investmentId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

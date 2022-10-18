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
@Table(schema = SchemaConfiguration.SCHEMA_NAME, name = "MEMBERLIST")
public class MemberListEntity {
    @Id
    private UUID memberlistId;
    private String firstName;
    private String lastName;
    private String contactNumber;
    private String status;
    private ZonedDateTime createdDate;
    private ZonedDateTime modifiedDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        MemberListEntity that = (MemberListEntity) o;
        return memberlistId != null && Objects.equals(memberlistId, that.memberlistId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

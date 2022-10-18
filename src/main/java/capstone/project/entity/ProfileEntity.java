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
@Table(schema = SchemaConfiguration.SCHEMA_NAME, name = "PROFILE")
public class ProfileEntity {
    @Id
    private UUID memberId;
    private String email;
    private String contactNumber;
    private String birthday;
    private String address;
    private String occupation;
    private String employer;
    private String position;
    private String imageLink;
    private ZonedDateTime createdDate;
    private ZonedDateTime modifiedDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ProfileEntity that = (ProfileEntity) o;
        return memberId != null && Objects.equals(memberId, that.memberId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

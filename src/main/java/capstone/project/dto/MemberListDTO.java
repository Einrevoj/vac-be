package capstone.project.dto;

import lombok.Data;

import java.time.ZonedDateTime;
import java.util.UUID;

@Data
public class MemberListDTO {

    private UUID memberlistId;
    private String firstName;
    private String lastName;
    private String contactNumber;
    private String status;
    private String filter;
    private ZonedDateTime createdDate;
    private ZonedDateTime modifiedDate;
}

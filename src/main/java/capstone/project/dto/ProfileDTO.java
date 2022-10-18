package capstone.project.dto;

import lombok.Data;

import java.time.ZonedDateTime;
import java.util.UUID;

@Data
public class ProfileDTO {

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
}

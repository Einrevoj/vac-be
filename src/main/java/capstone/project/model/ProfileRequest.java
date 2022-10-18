package capstone.project.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProfileRequest {

    private String email;
    private String contactNumber;
    private String birthday;
    private String address;
    private String occupation;
    private String employer;
    private String position;
    private String imageLink;
}

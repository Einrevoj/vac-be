package capstone.project.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemberListRequest {

    private String firstName;
    private String lastName;
    private String contactNumber;
    private String status;

}

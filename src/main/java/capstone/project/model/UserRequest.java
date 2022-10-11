package capstone.project.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRequest {

    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String password;
    private String confirmPassword;
}

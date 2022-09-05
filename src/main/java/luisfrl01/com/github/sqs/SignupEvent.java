package luisfrl01.com.github.sqs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignupEvent {

    private String signupTime;
    private String userName;
    private String email;
}

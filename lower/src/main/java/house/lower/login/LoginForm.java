package house.lower.login;


import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class LoginForm {

    @NotBlank(message = "아이디를 입력해주세요")
    private String id;

    @NotNull(message = "비밀번호를 입력해주세요")
    @NotEmpty(message = "비밀번호를 입력해주세요")
    private String password;

}


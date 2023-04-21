package house.lower.user.form;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UserUpdateForm {

    @NotBlank(message = "이름을 입력해주세요")
    private String userName;            //이름

    @NotBlank(message = "아이디를 입력해주세요")
    private String userId;              //아이디

    @NotBlank(message = "비밀번호를 입력해주세요")
    private String userPassword;        //비밀번호

    private int userNo;                 //회원번호

    @NotNull
    @Range(min=1, max=9999, message = "반을 선택해주세요")
    private int classNo;             //반 번호

    private String className;           //반 이름

    @NotBlank(message = "핸드폰 번호를 입력해주세요")
    private String userPhone;           //휴대폰

    @NotNull
    @Min(value = 1, message = "나이를 입력해주세요")
    private int userAge;             //나이

    private String userDelYn;           //삭제여부
    private String userRegDt;           //생성일자
    private String userEmail;           //이메일

}

package house.lower.User.vo;

import lombok.Data;

/**
 * 회원 정보 VO
 */
@Data
public class UserVO {

    private String userName;            //이름
    private String userId;              //아이디
    private String userPassword;        //비밀번호
    private int userNo;                 //회원번호
    private String classNo;             //반 번호
    private String className;           //반 이름
    private String userPhone;           //휴대폰
    private String userAge;             //나이
    private String userDelYn;           //삭제여부
    private String userRegDt;           //생성일자
    private String userEmail;           //이메일
}

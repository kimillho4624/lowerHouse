package house.lower.user.vo;

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
    private int classNo;             //반 번호
    private String className;           //반 이름
    private String userPhone;           //휴대폰
    private int userAge;             //나이
    private String userDelYn;           //삭제여부
    private String userRegDt;           //생성일자
    private String userEmail;           //이메일

    public UserVO() {
    }

    public UserVO(String userName, String userId, String userPassword, int userNo, int classNo, String userPhone, int userAge, String userEmail) {
        this.userName = userName;
        this.userId = userId;
        this.userPassword = userPassword;
        this.userNo = userNo;
        this.classNo = classNo;
        this.userPhone = userPhone;
        this.userAge = userAge;
        this.userEmail = userEmail;
    }
}







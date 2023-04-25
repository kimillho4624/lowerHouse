package house.lower.child.vo;

import lombok.Data;

/**
 * 어린이 정보
 */
@Data
public class ChildVO {

    private int childNo;                //유아 번호
    private String childName;           //유아 이름
    private int classNo;                //반 번호
    private String className;           //반 이름
    private int childAge;               //나이
    private String childGender;         //성별

    private String childRegDt;          //생성 일자
    private String childDelYn;          //삭제 여부


    public ChildVO() {
    }

    public ChildVO(String childName, int classNo, int childAge, String childGender) {
        this.childName = childName;
        this.classNo = classNo;
        this.childAge = childAge;
        this.childGender = childGender;
    }
}


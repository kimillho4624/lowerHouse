package house.lower.lower.vo;

import lombok.Data;

@Data
public class LowerVO {

    public int lowerNo;                     // 하원 번호
    public String lowerTitle;                // 하원 제목
    public String lowerType;                //하원 종류
    public int carNo;                       // 차량 번호
    public String carName;                  // 차량 이름
    public String lowerStartHh;              // 하원 시작 시간
    public String lowerStartMi;             // 하원 시작 분
    public String lowerDt;                  // 하원 날짜
    public String lowerRegDt;               // 하원 생성 일자
    public String lowerDelYn;               // 삭제 여부
    public int childNo;                     // 유아 번호
    public String childName;                // 유아 이름
    public int lowerChildNo;                // 하원 유아 번호
    public String childGender;              // 유아 성별
    public String className;                // 반 이름
    public int classNo;                     // 반 번호


    public LowerVO() {
    }

    public LowerVO(int lowerNo, String lowerTitle, String lowerType, int carNo, String lowerStartHh, String lowerStartMi, String lowerDt) {
        this.lowerNo = lowerNo;
        this.lowerTitle = lowerTitle;
        this.lowerType = lowerType;
        this.carNo = carNo;
        this.lowerStartHh = lowerStartHh;
        this.lowerStartMi = lowerStartMi;
        this.lowerDt = lowerDt;
    }
}


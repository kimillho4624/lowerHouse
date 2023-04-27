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
}

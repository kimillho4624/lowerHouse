package house.lower.lower.form;

import house.lower.cmm.vo.CodeVO;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

@Data
public class LowerSaveForm {

    public int lowerNo;                     // 하원 번호

    @NotBlank(message = "제목을 입력 하세요.")
    public String lowerTitle;               // 하원 제목

    public String lowerType;                //하원 종류

    public int carNo;                       // 차량 번호

    public String carName;                  // 차량 이름

    @NotBlank(message = "시간 선택 필수")
    public String lowerStartHh;              // 하원 시작 시간

    @NotBlank(message = "분 선택 필수")
    public String lowerStartMi;             // 하원 시작 분

    @NotBlank(message = "날짜 선택 필수")
    public String lowerDt;                  // 하원 날짜

    public List<CodeVO> hourList;           // 시간 선택
    public List<CodeVO> minList;            // 분 선택

    public String[] childNoArr;             // 유아 번호 체크박스 배열
}

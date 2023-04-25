package house.lower.child.form;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ChildUpdateForm {

    private int childNo;                //유아 번호

    @NotBlank(message = "이름을 입력해주세요")
    private String childName;           //유아 이름

    @NotNull
    @Min(value = 1, message = "반을 선택해주세요")
    private int classNo;                //반 번호

    private String className;           //반 이름

    @NotNull
    @Min(value = 1 , message = "나이를 입력해주세요")
    private int childAge;               //나이

    private String childGender;         //성별

}

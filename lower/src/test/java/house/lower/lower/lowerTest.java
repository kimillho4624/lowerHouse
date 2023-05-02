package house.lower.lower;

import house.lower.lower.service.LowerService;
import house.lower.lower.vo.LowerVO;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest
class lowerTest {

    @Autowired
    private LowerService lowerService;

    @Test
    @DisplayName("하원 관리 crud 테스트")
    void lowerCRUD() throws Exception {


        //save
        LowerVO lowerVO = new LowerVO(6,"title","A", 1 , "21", "10" , "2023-05-02");
        int result = lowerService.saveLowerInfo(lowerVO);
        assertThat(result).isEqualTo(1);

        //list
        List<LowerVO> lowerList = lowerService.selectLowerList(lowerVO);
        assertThat(lowerList.size()).isEqualTo(4);

        //update
        lowerVO.setLowerTitle("titleUpdate");
        lowerService.updateLowerInfo(lowerVO);

        //info
        LowerVO lowerInfoVO = lowerService.selectLowerInfo(6);
        assertThat("titleUpdate").isEqualTo(lowerInfoVO.getLowerTitle());

    }
}

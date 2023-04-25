package house.lower.child;

import house.lower.child.service.ChildService;
import house.lower.child.vo.ChildVO;
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
class childTest {

    @Autowired
    private ChildService childService;

    @Test
    @DisplayName("유아 관리 테스트")
    void crudTest() throws Exception {

        //save
        ChildVO vo = new ChildVO("김윤환",1,8,"M");
        childService.saveChildInfo(vo);

        //list
        List<ChildVO> childList = childService.selectChildList(vo);
        assertThat(childList.size()).isEqualTo(1);

        //update
        vo.setChildName("김수미");
        vo.setChildGender("W");
        vo.setChildNo(15);
        log.info("name1={}",vo.getChildName());
        childService.updateChildInfo(vo);

        log.info("name2={}",vo.getChildName());

        //select
        ChildVO childVO = childService.selectChildInfo(15);

        assertThat(childVO.getChildName()).isEqualTo(vo.getChildName());

        //delete
        assertThat(childService.removeChildInfo(15)).isEqualTo(1);


    }



}

package house.lower.user;

import house.lower.user.service.UserService;
import house.lower.user.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class userTest {

    @Autowired
    UserService userService;

    @Test
    @DisplayName("회원 crud 테스트")
    void crudTest() throws Exception {

        //save
        UserVO user1 = new UserVO("김홍주","test1234","1234",16,1,"01012345678",35,"wow123@naver");
        userService.saveUserInfo(user1);

        //userInfo
        UserVO userInfo = userService.selectUserInfo(user1.getUserNo());
        assertThat(user1.getUserNo()).isEqualTo(userInfo.getUserNo());

        //update
        userInfo.setUserName("김종민");
        userService.updateUserInfo(userInfo);

        UserVO updateInfo = userService.selectUserInfo(userInfo.getUserNo());
        assertThat(userInfo.getUserName()).isEqualTo(updateInfo.getUserName());


        //delete
        userService.removeUserInfo(updateInfo.getUserNo());
        UserVO removeInfo = userService.selectUserInfo(updateInfo.getUserNo());
        assertThat(removeInfo.getUserDelYn()).isEqualTo("Y");
    }
}

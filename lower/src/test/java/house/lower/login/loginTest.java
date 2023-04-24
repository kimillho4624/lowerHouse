package house.lower.login;

import house.lower.login.service.LoginService;
import house.lower.user.vo.UserVO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
class loginTest {

    @Autowired
    LoginService loginService;

    @Test
    @DisplayName("로그인 테스트")
    void loginTest() throws Exception {

        UserVO loginUser = loginService.login("user1", "1234");

//        assertThat("USER1").isEqualTo(loginUser.getUserId());
        assertThatThrownBy(() -> assertThat("user1").isEqualTo(loginUser.getUserId()) )
                .isInstanceOf(NullPointerException.class);

    }
    
    
}

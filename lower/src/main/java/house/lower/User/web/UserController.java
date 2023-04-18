package house.lower.User.web;


import house.lower.User.service.UserService;
import house.lower.User.vo.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/list")
    public String selectUserList(UserVO userVO) throws Exception{

        List<UserVO> list = userService.selectUserList(userVO);


        return "user";
    }


}

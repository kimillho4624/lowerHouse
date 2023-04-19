package house.lower.User.web;


import house.lower.User.service.UserService;
import house.lower.User.vo.UserVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;


    /**
     * 회원 목록
     * @param userVO
     * @return
     * @throws Exception
     */
    @GetMapping("/list")
    public String selectUserList(UserVO userVO, Model model) throws Exception{

        List<UserVO> userList = userService.selectUserList(userVO);

        log.info("userlist={}",userList);

        model.addAttribute("userList", userList);

        return "user/userList";
    }

    /**
     * 사용자 등록 폼
     * @param userVO
     * @return
     * @throws Exception
     */
    @GetMapping("/form")
    public String userForm(UserVO userVO) throws Exception {

        return "user/userForm";
    }

    @RequestMapping("/save")
    public String saveUserInfo(UserVO userVO) throws Exception {

        log.info("userVO={}", userVO);

        int result = userService.saveUserInfo(userVO);


        return "redirect:/user/list";
    }

    /**
     * 메인 페이지
     * @return
     * @throws Exception
     */
    @GetMapping("/")
    public String loadPage() throws Exception {


        return "index";
    }

}

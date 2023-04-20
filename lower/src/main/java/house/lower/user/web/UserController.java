package house.lower.user.web;


import house.lower.user.service.UserService;
import house.lower.user.vo.UserVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

        return "user/userAddForm";
    }

    /**
     * 회원 저장
     * @param userVO
     * @return
     * @throws Exception
     */
    @PostMapping("/save")
    public String saveUserInfo(UserVO userVO) throws Exception {

        log.info("userVO={}", userVO);

        int result = userService.saveUserInfo(userVO);


        return "redirect:/user/list";
    }

    /**
     * 회원 상세정보
     * @param userNo
     * @param model
     * @return
     * @throws Exception
     */
    @GetMapping("/userInfo/{userNo}")
    public String userInfo(@PathVariable int userNo, Model model) throws Exception {
        UserVO userVO = userService.selectUserInfo(userNo);
        model.addAttribute("userVO", userVO);
        return "user/userInfo";
    }

    /**
     * 회원 삭제
     * @param userNo
     * @return
     * @throws Exception
     */
    @GetMapping("/remove/{userNo}")
    public String removeUserInfo(@PathVariable int userNo) throws Exception {
            int result = userService.removeUserInfo(userNo);
        return "redirect:/user/list";
    }

    /**
     * 회원 수정 폼
     * @param userNo
     * @param model
     * @return
     * @throws Exception
     */
    @GetMapping("/edit/{userNo}")
    public String editUserForm(@PathVariable int userNo, Model model) throws Exception {
        UserVO userVO = userService.selectUserInfo(userNo);
        model.addAttribute("userVO", userVO);
        return "user/userEditForm";
    }

    /**
     * 회원 수정
     * @param userVO
     * @return
     * @throws Exception
     */
    @PostMapping("/edit")
    public String updateUserInfo(UserVO userVO) throws Exception {
        int result = userService.updateUserInfo(userVO);
        return "redirect:/user/userInfo/"+userVO.getUserNo();
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

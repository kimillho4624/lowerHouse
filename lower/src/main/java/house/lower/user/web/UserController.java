package house.lower.user.web;


import house.lower.SessionConst;
import house.lower.argumentresolver.Login;
import house.lower.user.form.UserSaveForm;
import house.lower.user.form.UserUpdateForm;
import house.lower.user.service.UserService;
import house.lower.user.vo.UserVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    public String selectUserList(UserVO userVO, Model model, HttpServletRequest request) throws Exception{

        //회원 목록
        List<UserVO> userList = userService.selectUserList(userVO);

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
     * @param userSaveForm
     * @return
     * @throws Exception
     */
    @PostMapping("/save")
    public String saveUserInfo(@Validated @ModelAttribute("userVO") UserSaveForm userSaveForm, BindingResult bindingResult, RedirectAttributes ra) throws Exception {

        String message ="";

        //검증에 실패하면 다시 입력 폼으로
        if(bindingResult.hasErrors()){
            log.info("error={}", bindingResult);
            return "user/userAddForm";
        }

        UserVO userVO = new UserVO();
        userVO.setUserId(userSaveForm.getUserId());
        userVO.setUserName(userSaveForm.getUserName());
        userVO.setUserAge(userSaveForm.getUserAge());
        userVO.setUserEmail(userSaveForm.getUserEmail());
        userVO.setUserPhone(userSaveForm.getUserPhone());
        userVO.setUserPassword(userSaveForm.getUserPassword());
        userVO.setClassNo(userSaveForm.getClassNo());

        int result = userService.saveUserInfo(userVO);

        if(result > 0 ){
            message = "가입 성공";
        } else {
            message = "가입 실패";
        }

        ra.addFlashAttribute("message", message);
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
    public String removeUserInfo(@PathVariable int userNo,RedirectAttributes ra) throws Exception {
        int result = userService.removeUserInfo(userNo);

        String message = "";

        if(result > 0 ){
            message = "삭제 성공";
        } else {
            message = "삭제 실패";
        }

        ra.addFlashAttribute("message", message);
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
     * @param userUpdateForm
     * @return
     * @throws Exception
     */
    @PostMapping("/edit")
    public String updateUserInfo(@Validated @ModelAttribute("userVO") UserUpdateForm userUpdateForm, BindingResult bindingResult) throws Exception {

        if(bindingResult.hasErrors()){
            log.info("error={}", bindingResult);
            return "user/userEditForm";
        }

        UserVO userVO = new UserVO();
        userVO.setUserNo(userUpdateForm.getUserNo());
        userVO.setUserId(userUpdateForm.getUserId());
        userVO.setUserName(userUpdateForm.getUserName());
        userVO.setUserAge(userUpdateForm.getUserAge());
        userVO.setUserEmail(userUpdateForm.getUserEmail());
        userVO.setUserPhone(userUpdateForm.getUserPhone());
        userVO.setUserPassword(userUpdateForm.getUserPassword());
        userVO.setClassNo(userUpdateForm.getClassNo());

        int result = userService.updateUserInfo(userVO);
        return "redirect:/user/userInfo/"+userVO.getUserNo();
    }

}

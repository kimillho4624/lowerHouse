package house.lower.login.web;

import house.lower.SessionConst;
import house.lower.login.LoginForm;
import house.lower.login.service.LoginService;
import house.lower.user.vo.UserVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@Slf4j
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    /**
     * 로그인 폼
     * @param loginForm
     * @param model
     * @return
     * @throws Exception
     */
    @GetMapping("/login")
    public String loginForm(@ModelAttribute LoginForm loginForm, Model model) throws Exception {
        model.addAttribute("loginForm", loginForm);
        return "login/loginForm";
    }

    /**
     * 로그인 체크
     * @param loginForm
     * @param bindingResult
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping("/login")
    public String login(@Validated @ModelAttribute LoginForm loginForm, BindingResult bindingResult, HttpServletRequest request) throws Exception {

        if(bindingResult.hasErrors()){
            log.info("error={}", bindingResult);
            return "login/loginForm";
        }

        UserVO user = loginService.login(loginForm.getId(),loginForm.getPassword());

        if (user == null) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
            return "login/loginForm";
        }

        //로그인 성공 처리 TODO
        //세션이 있으면 세션 반환, 없으면 신규 세션 생성
        HttpSession session = request.getSession();
        //세션에 로그인 회원 정보 보관
        session.setAttribute(SessionConst.LOGIN_USER, user);

        return "redirect:/";
    }

    /**
     * 세션삭제
     * @param request
     * @return
     */
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {

        //세션삭제
        HttpSession session = request.getSession();
        if (session != null) {
            session.invalidate();
        }

        return "redirect:/";
    }

}

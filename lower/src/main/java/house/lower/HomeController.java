package house.lower;

import house.lower.argumentresolver.Login;
import house.lower.login.LoginForm;
import house.lower.user.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@Slf4j
public class HomeController {

    @GetMapping("")
//    public String home(@SessionAttribute(name= SessionConst.LOGIN_USER, required = false) UserVO loginUser, Model model) {
//      ArgumentResolver를 사용해서 @Login 애노테이션이 있으면 자동으로 세션에 있는 로그인 회원을 찾아주고 없으면 null을 반환한다.
    public String home(@Login UserVO loginUser, Model model) {

        //세션에 회원 데이터가 있으면 home
        if(loginUser == null){
            model.addAttribute("loginForm", new LoginForm());
            return "login/loginForm";
        }

        //세션에 유지되면 로그인으로 이동
        return "redirect:user/list";
    }


}

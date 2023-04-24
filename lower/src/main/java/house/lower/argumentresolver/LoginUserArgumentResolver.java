package house.lower.argumentresolver;

import house.lower.SessionConst;
import house.lower.user.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
public class LoginUserArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {

        log.info("supportsParameter start!");

        // hasParameterAnnotation() 메소드를 사용해서 파라미터의 애노테이션으로 Argument Resolver 적용 대상을 제한할 수 있다.
        boolean hasParameterAnnotation = parameter.hasParameterAnnotation(Login.class);
        // isAssignableFrom()은 특정 Class 가 어떤 클래스/인터페이스를 상속/구현했는지 체크한다.
        boolean hasUserType = UserVO.class.isAssignableFrom(parameter.getParameterType());

        return hasParameterAnnotation && hasUserType;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

        log.info("resolveArgument start!!");

        HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();
        HttpSession session = request.getSession();
        if (session == null) {
            return null;
        }

        return session.getAttribute(SessionConst.LOGIN_USER);
    }

}

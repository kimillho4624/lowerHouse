package house.lower.login.service;

import house.lower.user.mapper.UserMapper;
import house.lower.user.vo.UserVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoginService {

    private final UserMapper userMapper;

    public UserVO login(String id, String password) throws Exception {
        Optional<UserVO> findUserOptional = userMapper.findByLoginId(id);

        //아이디는 일치한 경우
        if(findUserOptional.isPresent()){
            UserVO user = findUserOptional.get();
            //비밀번호 일치 확인
            if(user.getUserPassword().equals(password)){
                return user;
            }else{
                return null;
            }
        }else{  //아이디 틀린 경우
            return null;
        }
    }
}

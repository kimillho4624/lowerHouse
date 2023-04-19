package house.lower.User.service;

import house.lower.User.mapper.UserMapper;
import house.lower.User.vo.UserVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;

    public List<UserVO> selectUserList(UserVO userVO) throws Exception{

        List<UserVO> userList = userMapper.selectUserList(userVO);

        return userList;
    }

    public int saveUserInfo(UserVO userVO) throws Exception {

        int result = userMapper.saveUserInfo(userVO);

        return result;
    }
}

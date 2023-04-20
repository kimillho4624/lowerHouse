package house.lower.user.service;

import house.lower.user.mapper.UserMapper;
import house.lower.user.vo.UserVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;

    /**
     * 회원 목록 조회
     * @param userVO
     * @return
     * @throws Exception
     */
    public List<UserVO> selectUserList(UserVO userVO) throws Exception{

        List<UserVO> userList = userMapper.selectUserList(userVO);

        return userList;
    }

    /**
     * 회원 저장
     * @param userVO
     * @return
     * @throws Exception
     */
    public int saveUserInfo(UserVO userVO) throws Exception {
        int result = userMapper.saveUserInfo(userVO);
        return result;
    }


    /**
     * 회원 조회
     * @param userNo
     * @return
     * @throws Exception
     */
    public UserVO selectUserInfo(int userNo) throws Exception {
        UserVO userVO = userMapper.selectUserInfo(userNo) ;
        return userVO;
    }

    /**
     * 회원 삭제
     * @param userNo
     * @return
     */
    public int removeUserInfo(int userNo) throws SQLException {
        int result = userMapper.removeUserInfo(userNo);
        return result;
    }

    /**
     * 회원 수정
     * @param userVO
     * @return
     */
    public int updateUserInfo(UserVO userVO) throws SQLException {
        int result = userMapper.updateUserInfo(userVO);
        return result;
    }
}

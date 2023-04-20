package house.lower.user.mapper;

import house.lower.user.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface UserMapper {

    List<UserVO> selectUserList(UserVO userVO) throws SQLException;

    int saveUserInfo(UserVO userVO) throws SQLException;

    UserVO selectUserInfo(int userNo) throws SQLException;

    int removeUserInfo(int userNo) throws SQLException;

    int updateUserInfo(UserVO userVO) throws SQLException;
}

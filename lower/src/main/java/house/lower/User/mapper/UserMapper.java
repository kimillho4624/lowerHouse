package house.lower.User.mapper;

import house.lower.User.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface UserMapper {

    List<UserVO> selectUserList(UserVO userVO) throws SQLException;

    int saveUserInfo(UserVO userVO) throws SQLException;
}

package house.lower.lower.mapper;

import house.lower.child.vo.ChildVO;
import house.lower.lower.vo.LowerVO;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface LowerMapper {

    List<LowerVO> selectLowerList(LowerVO lowerVO) throws SQLException;

    int saveLowerInfo(LowerVO lowerVO) throws SQLException ;

    LowerVO selectLowerInfo(int lowerNo) throws SQLException;

    int updateLowerInfo(LowerVO lowerVO) throws SQLException;

    int removeLowerInfo(int lowerNo) throws SQLException;

    int saveLowerChildInfo(LowerVO lowerVO) throws SQLException;

    List<LowerVO> selectLowerChildInfoList(int lowerNo) throws SQLException;

    int removeLowerChildInfo(int lowerChildNo) throws SQLException;

    int removeLowerChildList(int lowerNo) throws SQLException;
}

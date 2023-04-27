package house.lower.lower.mapper;

import house.lower.lower.vo.LowerVO;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface LowerMapper {

    List<LowerVO> selectLowerList(LowerVO lowerVO) throws SQLException;

    int saveLowerInfo(LowerVO lowerVO) throws SQLException ;
}

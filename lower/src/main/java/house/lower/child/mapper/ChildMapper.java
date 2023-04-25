package house.lower.child.mapper;

import house.lower.child.vo.ChildVO;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface ChildMapper {

    List<ChildVO> selectChildList(ChildVO childVO) throws SQLException;

    int saveChildInfo(ChildVO childVO) throws SQLException;

    ChildVO selectChildInfo(int childNo) throws SQLException;

    int removeChildInfo(int childNo) throws SQLException;

    int updateChildInfo(ChildVO childVO) throws SQLException;
}

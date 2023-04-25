package house.lower.child.service;

import house.lower.child.mapper.ChildMapper;
import house.lower.child.vo.ChildVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChildService {

    private final ChildMapper childMapper;

    public List<ChildVO> selectChildList(ChildVO childVO) throws Exception {
        return childMapper.selectChildList(childVO);
    }

    public int saveChildInfo(ChildVO childVO) throws Exception {
        return childMapper.saveChildInfo(childVO);
    }

    public ChildVO selectChildInfo(int childNo) throws Exception {
        return childMapper.selectChildInfo(childNo);
    }

    public int removeChildInfo(int childNo) throws Exception {
        return childMapper.removeChildInfo(childNo);
    }

    public int updateChildInfo(ChildVO childVO) throws Exception {
        return childMapper.updateChildInfo(childVO);
    }
}

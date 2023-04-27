package house.lower.lower.service;

import house.lower.lower.mapper.LowerMapper;
import house.lower.lower.vo.LowerVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class LowerService {

    private final LowerMapper lowerMapper;

    public List<LowerVO> selectLowerList(LowerVO lowerVO) throws Exception {
        return lowerMapper.selectLowerList(lowerVO);
    }

    public int saveLowerInfo(LowerVO lowerVO) throws Exception {
        return lowerMapper.saveLowerInfo(lowerVO);
    }
}

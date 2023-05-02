package house.lower.lower.service;

import house.lower.lower.form.LowerSaveForm;
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

    public LowerVO selectLowerInfo(int lowerNo) throws Exception {
        return lowerMapper.selectLowerInfo(lowerNo);
    }

    public int updateLowerInfo(LowerVO lowerVO) throws Exception {
        return lowerMapper.updateLowerInfo(lowerVO);
    }

    public int removeLowerInfo(int lowerNo) throws Exception {
        return lowerMapper.removeLowerInfo(lowerNo);
    }

    public int saveLowerChildInfo(LowerSaveForm lowerSaveForm) throws Exception {

        int result = 0;

        for(int i = 0; i<lowerSaveForm.getChildNoArr().length; i++){

            LowerVO lowerVO = new LowerVO();

            String childArr[] = lowerSaveForm.getChildNoArr()[i].split(",");

            lowerVO.setChildNo(Integer.parseInt(childArr[0]));
            lowerVO.setChildName(childArr[1]);
            lowerVO.setLowerNo(lowerSaveForm.getLowerNo());

            result = lowerMapper.saveLowerChildInfo(lowerVO);
        }

        return result;
    }
}

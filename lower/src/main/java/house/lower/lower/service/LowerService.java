package house.lower.lower.service;

import house.lower.child.vo.ChildVO;
import house.lower.lower.form.LowerSaveForm;
import house.lower.lower.mapper.LowerMapper;
import house.lower.lower.vo.LowerVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.rmi.server.ExportException;
import java.sql.SQLException;
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

        int result = 0 ;

        result = lowerMapper.removeLowerInfo(lowerNo);

        //하원 유아도 삭제 해야함
        lowerMapper.removeLowerChildList(lowerNo);

        return result;
    }

    public int saveLowerChildInfo(LowerSaveForm lowerSaveForm) throws Exception {

        int result = 0;

        for(int i = 0; i<lowerSaveForm.getChildNoArr().length; i++){

            LowerVO lowerVO = new LowerVO();

            String childArr[] = lowerSaveForm.getChildNoArr()[i].split(",");

            lowerVO.setChildNo(Integer.parseInt(childArr[0]));
            lowerVO.setChildName(childArr[1]);
            lowerVO.setClassNo(Integer.parseInt(childArr[2]));
            lowerVO.setLowerNo(lowerSaveForm.getLowerNo());

            result = lowerMapper.saveLowerChildInfo(lowerVO);
        }

        return result;
    }

    public List<LowerVO> selectLowerChildInfoList(int lowerNo) throws Exception {
        return lowerMapper.selectLowerChildInfoList(lowerNo);
    }

    public int removeLowerChildInfo(LowerSaveForm lowerSaveForm) throws Exception{

        int result = 0;

        for(int i=0; i<lowerSaveForm.getChildNoArr().length; i++) {

            LowerVO lowerVO = new LowerVO();
            lowerVO.setLowerChildNo(Integer.parseInt(lowerSaveForm.getChildNoArr()[i]));

            result = lowerMapper.removeLowerChildInfo(lowerVO.getLowerChildNo());
        }

        return result;
    }

}

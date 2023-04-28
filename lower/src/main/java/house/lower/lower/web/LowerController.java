package house.lower.lower.web;

import house.lower.cmm.vo.CodeVO;
import house.lower.lower.form.LowerSaveForm;
import house.lower.lower.form.LowerUpdateForm;
import house.lower.lower.service.LowerService;
import house.lower.lower.vo.LowerVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/lower")
@RequiredArgsConstructor
public class LowerController {

    private final LowerService lowerService;

    /**
     * 하원 정보 목록
     * @param lowerVO
     * @return
     * @throws Exception
     */
    @GetMapping("/list")
    public String selectLowerList(LowerVO lowerVO,Model model) throws Exception {

        List<LowerVO> lowerList = lowerService.selectLowerList(lowerVO);
        model.addAttribute("lowerList", lowerList);
        return "lower/lowerList";
    }

    /**
     * 하원 정보 등록 폼
     * @param lowerSaveForm
     * @param model
     * @return
     * @throws Exception
     */
    @GetMapping("/form")
    public String lowerAddForm(LowerSaveForm lowerSaveForm, Model model) throws Exception {

        //시간 , 분 셀렉트 박스
//        lowerSaveForm.setHourList(hourList());
//        lowerSaveForm.setMinList(minuteList());
        List<CodeVO> hourList = hourList();
        List<CodeVO> minList = minuteList();

        model.addAttribute("hourList", hourList());
        model.addAttribute("minList", minList);
        model.addAttribute("lowerSaveForm", lowerSaveForm);
        return "lower/lowerAddForm";
    }

    /**
     * 하원 정보 저장
     * @param lowerSaveForm
     * @param bindingResult
     * @param model
     * @return
     * @throws Exception
     */
    @PostMapping("/save")
    public String saveLowerInfo(@Valid LowerSaveForm lowerSaveForm, BindingResult bindingResult, Model model) throws Exception {

        if(lowerSaveForm.getLowerType().equals("A") && lowerSaveForm.getCarNo()==0){
            bindingResult.reject("lowerTypeError","차량을 선택해주세요." );

            List<CodeVO> hourList = hourList();
            List<CodeVO> minList = minuteList();

            model.addAttribute("hourList",hourList);
            model.addAttribute("minList",minList);
            return "/lower/lowerAddForm";
        }

        if(bindingResult.hasErrors()){

            log.info("error={}", bindingResult);

            //시간 , 분 셀렉트 박스
            List<CodeVO> hourList = hourList();
            List<CodeVO> minList = minuteList();

            model.addAttribute("hourList",hourList);
            model.addAttribute("minList",minList);
            return "/lower/lowerAddForm";
        }

        LowerVO lowerVO = new LowerVO();
        lowerVO.setLowerTitle(lowerSaveForm.getLowerTitle());
        lowerVO.setLowerType(lowerSaveForm.getLowerType());
        lowerVO.setCarNo(lowerSaveForm.getCarNo());
        lowerVO.setLowerDt(lowerSaveForm.getLowerDt());
        lowerVO.setLowerStartHh(lowerSaveForm.getLowerStartHh());
        lowerVO.setLowerStartMi(lowerSaveForm.getLowerStartMi());

        int result = lowerService.saveLowerInfo(lowerVO);

        return "redirect:/lower/list";
    }

    /**
     * 하원 상세 정보
     * @param lowerNo
     * @param model
     * @return
     * @throws Exception
     */
    @GetMapping("/info/{lowerNo}")
    public String selectLowerInfo(@PathVariable int lowerNo, Model model) throws Exception {

        LowerVO lowerVO = lowerService.selectLowerInfo(lowerNo);

        model.addAttribute("lowerVO", lowerVO);
        return "lower/lowerInfo";
    }

    /**
     * 하원 수정 폼
     * @param lowerNo
     * @param model
     * @return
     * @throws Exception
     */
    @GetMapping("edit/{lowerNo}")
    public String editLowerForm(@PathVariable int lowerNo, Model model) throws Exception {
        LowerVO lowerVO = lowerService.selectLowerInfo(lowerNo);

        //시간 , 분 셀렉트 박스
        List<CodeVO> hourList = hourList();
        List<CodeVO> minList = minuteList();

        model.addAttribute("lowerUpdateForm", lowerVO);
        model.addAttribute("hourList", hourList());
        model.addAttribute("minList", minList);
        return "lower/lowerEditForm";
    }

    @PostMapping("/edit")
    public String updateLowerInfo(LowerUpdateForm lowerUpdateForm, Model model) throws Exception {

        LowerVO lowerVO = new LowerVO();
        lowerVO.setLowerNo(lowerUpdateForm.getLowerNo());
        lowerVO.setLowerType(lowerUpdateForm.getLowerType());
        lowerVO.setLowerTitle(lowerUpdateForm.getLowerTitle());
        lowerVO.setLowerStartHh(lowerUpdateForm.getLowerStartHh());
        lowerVO.setLowerStartMi(lowerUpdateForm.getLowerStartMi());
        lowerVO.setLowerDt(lowerUpdateForm.getLowerDt());
        lowerVO.setCarNo(lowerUpdateForm.getCarNo());

        int result = lowerService.updateLowerInfo(lowerVO);

        return "";
    }

    /**
     * 시간 <option>태그 만들기
     * @return
     */
    public List<CodeVO> hourList() {

        List<CodeVO> list = new ArrayList<>();
        for(int i=9; i<24; i++){
            CodeVO codeVO = new CodeVO();

            if(i<10) {
                codeVO.setCode("0"+i);
                codeVO.setValue("0"+i);
                list.add(codeVO);
            } else {
                codeVO.setCode(String.valueOf(i));
                codeVO.setValue(String.valueOf(i));
                list.add(codeVO);
            }
        }
        return list;
    }

    /**
     * 분 <option>태그 만들기
     * @return
     */
    public List<CodeVO> minuteList() {

        List<CodeVO> list = new ArrayList<>();
        for(int i=0; i<6; i++){
            CodeVO codeVO = new CodeVO();
            codeVO.setCode(i+"0");
            codeVO.setValue(i+"0");
            list.add(codeVO);
        }
        return list;

    }
}

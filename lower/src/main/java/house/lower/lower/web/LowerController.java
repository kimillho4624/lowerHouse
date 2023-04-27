package house.lower.lower.web;

import house.lower.lower.form.LowerSaveForm;
import house.lower.lower.service.LowerService;
import house.lower.lower.vo.LowerVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
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

        log.info("lowerSaveForm@@@@@@@@@@@={}", lowerSaveForm);

        if(lowerSaveForm.getLowerType().equals("A") && lowerSaveForm.getCarNo()==0){
            bindingResult.reject("lowerTypeError","차량을 선택해주세요." );
            return "/lower/lowerAddForm";
        }

        if(bindingResult.hasErrors()){
            log.info("error={}", bindingResult);
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

        return "";
    }
}

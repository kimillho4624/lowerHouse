package house.lower.child.web;

import house.lower.child.form.ChildSaveForm;
import house.lower.child.form.ChildUpdateForm;
import house.lower.child.service.ChildService;
import house.lower.child.vo.ChildVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/child")
@RequiredArgsConstructor
public class ChildController {

    private final ChildService childService;

    /**
     * 유아 목록
     *
     * @param childVO
     * @return
     * @throws Exception
     */
    @GetMapping("/list")
    public String selectChildList(ChildVO childVO, Model model) throws Exception {
        List<ChildVO> childList = childService.selectChildList(childVO);
        model.addAttribute("childList", childList);
        return "child/childList";
    }

    /**
     * 유아 저장 폼
     *
     * @param childSaveForm
     * @param model
     * @return
     * @throws Exception
     */
    @GetMapping("/form")
    public String saveChildForm(ChildSaveForm childSaveForm, Model model) throws Exception {

        model.addAttribute("childSaveForm", childSaveForm);
        return "child/childAddForm";
    }

    /**
     * 유아 정보 저장
     *
     * @param childSaveForm
     * @param bindingResult
     * @param model
     * @return
     * @throws Exception
     */
    @PostMapping("/save")
    public String saveChildInfo(@Valid @ModelAttribute ChildSaveForm childSaveForm, BindingResult bindingResult,RedirectAttributes ra) throws Exception {

        if (bindingResult.hasErrors()) {
            log.info("error={}", bindingResult);
            return "child/childAddForm";
        }

        ChildVO childVO = new ChildVO();
        childVO.setChildName(childSaveForm.getChildName());
        childVO.setChildAge(childSaveForm.getChildAge());
        childVO.setChildGender(childSaveForm.getChildGender());
        childVO.setClassNo(childSaveForm.getClassNo());

        int result = childService.saveChildInfo(childVO);

        String message = "";
        if(result > 0 ){
            message = "등록 성공";
        }else {
            message = "등록 실패";
        }

        ra.addFlashAttribute("message", message);
        return "redirect:/child/list";
    }

    /**
     * 유아 상세 정보
     * @param childNo
     * @param model
     * @return
     * @throws Exception
     */
    @GetMapping("/info/{childNo}")
    public String selectChildInfo(@PathVariable int childNo, Model model) throws Exception {
        ChildVO childVO = childService.selectChildInfo(childNo);
        model.addAttribute("childVO", childVO);
        return "child/childInfo";
    }

    /**
     * 유아 삭제
     * @param childNo
     * @return
     * @throws Exception
     */
    @ResponseBody
    @GetMapping("/remove/{childNo}")
    public String removeChildInfo(@PathVariable int childNo) throws Exception {
        int result = childService.removeChildInfo(childNo);

        String message = "";
        if(result > 0 ){
            message = "<script>alert('삭제가 성공했습니다.');location.href='/child/list';</script>";
        } else {
            message = "<script>alert('삭제가 실패했습니다.');location.href='/child/list';</script>";
        }


        return message;
    }

    /**
     * 유아 수정 폼
     * @param childNo
     * @param model
     * @return
     * @throws Exception
     */
    @GetMapping("/edit/{childNo}")
    public String editChildForm(@PathVariable int childNo, Model model) throws Exception {

        ChildVO childVO = childService.selectChildInfo(childNo);

        model.addAttribute("childUpdateForm", childVO);
        return "child/childUpdateForm";
    }

    @PostMapping("/edit")
    public String updateChildInfo(@Valid  ChildUpdateForm childUpdateForm, BindingResult bindingResult, RedirectAttributes ra) throws Exception {

        if (bindingResult.hasErrors()) {
            log.info("error={}", bindingResult);
            return "child/childAddForm";
        }

        ChildVO childVO = new ChildVO();
        childVO.setChildNo(childUpdateForm.getChildNo());
        childVO.setChildName(childUpdateForm.getChildName());
        childVO.setChildAge(childUpdateForm.getChildAge());
        childVO.setChildGender(childUpdateForm.getChildGender());
        childVO.setClassNo(childUpdateForm.getClassNo());

        int result = childService.updateChildInfo(childVO);
        String message = "";
        if(result > 0 ){
            message = "수정 성공";
        }else {
            message = "수정 실패";
        }

        ra.addFlashAttribute("message", message);
        return "redirect:/child/list";
    }
}

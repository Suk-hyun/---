package hello.hellospring2.controller;

import hello.hellospring2.domain.Memo;
import hello.hellospring2.service.MemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemoController {

    private final MemoService memoService;

    @Autowired
    public MemoController(MemoService memoService) {
        this.memoService = memoService;
    }

    @GetMapping("/memo/new")
    public String createForm() {
        return "memo/createMemoForm";
    }

    @PostMapping("/memo/new")
    public String create(MemoForm form) {
        Memo memo = new Memo();
        memo.setTitle(form.getTitle());
        memo.setContent(form.getContent());

        memoService.save(memo);
        return "redirect:/";
    }

    @GetMapping("/memos")
    public String list(Model model) { // repository 에서 resultList()로 객체 받아옴!
        List<Memo> memos = memoService.findMemos();
        model.addAttribute("memos", memos);
        return "memo/memoList";
    }
}

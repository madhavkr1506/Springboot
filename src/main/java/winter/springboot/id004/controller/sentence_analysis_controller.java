package winter.springboot.id004.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import winter.springboot.id004.response.sentence_response;
import winter.springboot.id004.service.sentence_analysis;

@Controller
@RequestMapping("/sentenceanalysis")
public class sentence_analysis_controller {

    @Autowired
    private sentence_analysis sentence_;
    
    @PostMapping("/analyzesentence")
    public String sendToAnalyze(@ModelAttribute sentence_response sentences,Model model){
        sentence_.analyzesentence(sentences);
        model.addAttribute("positiveSentences", sentence_.getPositiveSentences());
        model.addAttribute("negativeSentences", sentence_.getNegativeSentences());
        model.addAttribute("neutralSentences", sentence_.getNeutralSentences());
        return "result";

    }

}

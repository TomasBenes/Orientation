package com.dependencyinjection.dependencyinjection.usefulUtilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UtilityServiceController {

    private final UtilityService utilityService;

    @Autowired
    public UtilityServiceController (UtilityService utilityService) {
        this.utilityService = utilityService;
    }

    @GetMapping("/useful")
    public String mainPage(){
        return "index";
    }

    @GetMapping("/useful/colored")
    public String getColoredPage(Model model){
        model.addAttribute("coloredBackground", utilityService.randomColor());
        return "coloredBackground";
    }

    @GetMapping("/useful/email")
    public String getEmailValidator (Model model, @RequestParam String email){
        model.addAttribute("emailValidator", utilityService.isValidEmail(email));
        model.addAttribute("emailSpecific", email);
        return "email";
    }

    @GetMapping("useful/encoder")
    public String encode (Model model, @RequestParam String textToEncode, @RequestParam Integer numberOfShift) {
        model.addAttribute("text", utilityService.caesar(textToEncode, numberOfShift));
        return "caesar";
    }

    @GetMapping("useful/decoder")
    public String decode (Model model, @RequestParam String textToDecode, @RequestParam Integer numberOfShift){
        model.addAttribute("text", utilityService.caesar(textToDecode, -numberOfShift));
        return "caesar";
    }

}

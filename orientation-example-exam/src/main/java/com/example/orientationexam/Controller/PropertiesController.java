package com.example.orientationexam.Controller;

import com.example.orientationexam.DTO.PropertiesDto;
import com.example.orientationexam.Model.Properties;
import com.example.orientationexam.Service.PropertiesService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class PropertiesController {

    private final PropertiesService propertiesService;

    public PropertiesController (PropertiesService propertiesService) {
        this.propertiesService = propertiesService;
    }

    @GetMapping("/")
    public String list(){
        return "index";
    }

    @PostMapping("/save-link")
    public String saveLink (@RequestParam String url, @RequestParam String alias, RedirectAttributes attributes) {
        attributes.addFlashAttribute("successMessage", this.propertiesService.addProperties(new Properties(url, alias)));
        return "redirect:/";
    }

    @GetMapping("/a/{alias}")
    public String listPage(@PathVariable String alias){
        Properties properties = this.propertiesService.findByAlias(alias);
        this.propertiesService.incrementHitCount(properties);
        return "redirect:" + properties.getUrl();
    }

    @GetMapping("/api/links")
    @ResponseBody
    public ResponseEntity<List<Properties>> getProperties() {
        return ResponseEntity.ok(this.propertiesService.getAllProperties());
    }

    @DeleteMapping("/api/links/{id}")
    @ResponseBody
    public ResponseEntity deleteProperties (@PathVariable Integer id, @RequestBody PropertiesDto propertiesDto) {
        this.propertiesService.deleteProperties(id, propertiesDto);
        return ResponseEntity.noContent().build();
    }
//use-responsebody anotation pro json
    /*@GetMapping("/age")
    ResponseEntity<String> age(
            @RequestParam("yearOfBirth") int yearOfBirth) {

        if (yearOfBirth > 2020) {
            return new ResponseEntity<>(
                    "Year of birth cannot be in the future",
                    HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.status(HttpStatus.OK)
                .body("Your age is " + (2020 - yearOfBirth));
    }*/

}

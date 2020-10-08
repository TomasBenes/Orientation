package com.api.backend.Service;

import com.api.backend.Model.Greeter;
import org.springframework.stereotype.Service;

@Service
public class MainServiceImpl implements MainService{

    @Override
    public String greeting(String name, String title) {
        if (name == null) {
            return "Please provide a name!";
        } else if (title == null) {
            return "Please provide a title!";
        }  else if (name == null && title == null) {
            return "Please provide a name and title!";
        } else {
            return "Oh, hi there " + name + ", my dear " + title + "!";
        }
    }
}

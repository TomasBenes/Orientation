package com.api.backend.Service;

import com.api.backend.Model.Greeter;
import org.springframework.stereotype.Service;

@Service
public interface MainService {
    public String greeting (String name, String title);
}

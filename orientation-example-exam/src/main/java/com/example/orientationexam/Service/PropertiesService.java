package com.example.orientationexam.Service;

import com.example.orientationexam.DTO.PropertiesDto;
import com.example.orientationexam.Model.Properties;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PropertiesService {
    String successMessage (Properties properties);
    String addProperties (Properties properties);
    Properties findByAlias (String alias);
    void incrementHitCount (Properties properties);
    List<Properties> getAllProperties ();
    void deleteProperties (Integer id, PropertiesDto propertiesDto);
}

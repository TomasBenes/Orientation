package com.example.orientationexam.Service;

import com.example.orientationexam.DTO.Error;
import com.example.orientationexam.DTO.PropertiesDto;
import com.example.orientationexam.Model.Properties;
import com.example.orientationexam.Repository.PropertiesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class PropertiesServiceImpl implements PropertiesService{

    private final PropertiesRepo propertiesRepo;

    @Autowired
    public PropertiesServiceImpl (PropertiesRepo propertiesRepo) {
        this.propertiesRepo = propertiesRepo;
    }

    @Override
    public String successMessage(Properties properties) {
        return "Your URL is aliased to " + properties.getAlias() + " and your secret code is " + properties.getSecretCode().toString();
    }

    @Override
    public String addProperties(Properties properties) {
        Optional<Properties> optionalProperties = this.propertiesRepo.findPropertiesByAlias(properties.getAlias());
        if (optionalProperties.isPresent()){
            return "Your alias is already in use!";
        } else {
            this.propertiesRepo.save(properties);
            return successMessage(properties);
        }

    }

    @Override
    public Properties findByAlias(String alias) {
        return this.propertiesRepo.findPropertiesByAlias(alias).get();
    }

    @Override
    public void incrementHitCount(Properties properties) {
        properties.setHitCount(properties.getHitCount()+1);
        this.propertiesRepo.save(properties);
    }

    @Override
    public List<Properties> getAllProperties() {
        return this.propertiesRepo.findAll();
    }

    @Override
    public void deleteProperties(Integer id, PropertiesDto propertiesDto) {
        Optional<Properties> properties = this.propertiesRepo.findById(id);
        if (properties.get().getSecretCode() == propertiesDto.getSecretCode()){
            this.propertiesRepo.deleteById(id);
        }
    }

}

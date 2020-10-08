package com.example.orientationexam.Repository;

import com.example.orientationexam.Model.Properties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PropertiesRepo extends JpaRepository<Properties, Integer> {

    Optional<Properties> findPropertiesByAlias (String alias);
}

package com.example.Prueba_Test;

import com.example.Prueba_Test.config.BDConfigurationProperties;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class ClaseTonta {


    private final BDConfigurationProperties bdConfigurationProperties;
    @PostConstruct
    void enseña(){
       log.info(bdConfigurationProperties.url());
       log.info(bdConfigurationProperties.username());
       log.info(bdConfigurationProperties.password());
    }
}

package io.github.allanmarques83;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;


public class DotEnvConfiguration implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        setEnviroments(getDotEnv());
        return new String[] { DotEnvConfigurationDefault.class.getName() };
    }

    private void setEnviroments(Map<String, String> myEnviroments) {
        myEnviroments.entrySet().forEach(entry -> {
            String envKey = entry.getKey();
            String envValue = entry.getValue();

            System.setProperty(envKey, envValue);
        });
    }

    private Map<String, String> getDotEnv() {
        Map<String, String> myEnviroments = new HashMap<>();

        try {
            Resource resource = new ClassPathResource(".env");

            Path path = Paths.get(resource.getURI());

            Files.lines(path).forEach(line -> {
                String[] keyValue = line.split("=");
                myEnviroments.put(keyValue[0], keyValue[1]);
            });
        } catch (IOException e) {
            System.out.printf(
                "Error on set spring-dot-environment. Trace: %s%n", e.getMessage()
            );
        }
        return myEnviroments;
    }
}

@Configuration
class DotEnvConfigurationDefault {
    @Bean
    public String dotEnvBean() {
        return ":)";
    }
}

package com.hackathon1.demo.UserLimit.domain;
import java.time.Duration;
import java.time.LocalDateTime;

public class UserLimitDTO {

    private Long id;
    private ModelType modelType;  // Tipo de modelo de IA (OPENAI, META, etc.)
    private Integer maxRequests;  // Número máximo de solicitudes
    private Integer maxTokens;    // Número máximo de tokens
    private Duration windowDuration;  // Duración de la ventana de tiempo

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ModelType getModelType() {
        return modelType;
    }

    public void setModelType(ModelType modelType) {
        this.modelType = modelType;
    }

    public Integer getMaxRequests() {
        return maxRequests;
    }

    public void setMaxRequests(Integer maxRequests) {
        this.maxRequests = maxRequests;
    }

    public Integer getMaxTokens() {
        return maxTokens;
    }

    public void setMaxTokens(Integer maxTokens) {
        this.maxTokens = maxTokens;
    }

    public Duration getWindowDuration() {
        return windowDuration;
    }

    public void setWindowDuration(Duration windowDuration) {
        this.windowDuration = windowDuration;
    }
}

/*package com.hackathon1.demo.UserLimit.domain;

import lombok.Data;
import java.time.Duration;

@Data
public class UserLimitDTO {

    private Long id;
    private ModelType modelType;  // Tipo de modelo de IA (OPENAI, META, etc.)
    private Integer maxRequests;  // Número máximo de solicitudes
    private Integer maxTokens;    // Número máximo de tokens
    private Duration windowDuration;  // Duración de la ventana de tiempo
}*/
//con @data
package com.hackathon1.demo.UserLimit.application;

import com.hackathon1.demo.UserLimit.domain.UserLimitDTO;
import com.hackathon1.demo.UserLimit.domain.User;
import com.hackathon1.demo.UserLimit.service.UserLimitService;
import com.hackathon1.demo.UserLimit.domain.UserLimit;
import com.hackathon1.demo.UserLimit.domain.ModelType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/company/users/{userId}/limits")
public class UserLimitController {

    @Autowired
    private UserLimitService userLimitService;

    // Crear un nuevo UserLimit para un usuario
    @PostMapping
    public ResponseEntity<UserLimitDTO> createUserLimit(@PathVariable Long userId, @RequestBody UserLimitDTO userLimitDTO) {
        try {
            // Crear un nuevo UserLimit y devolverlo como DTO
            UserLimit userLimit = userLimitService.createUserLimit(userLimitDTO, userId);

            // Convertir el UserLimit a DTO
            UserLimitDTO responseDto = new UserLimitDTO();
            responseDto.setId(userLimit.getId());
            responseDto.setModelType(userLimit.getModelType());
            responseDto.setMaxRequests(userLimit.getMaxRequests());
            responseDto.setMaxTokens(userLimit.getMaxTokens());
            responseDto.setWindowDuration(userLimit.getWindowDuration());

            return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);  // Usuario no encontrado
        }
    }

    // Obtener un UserLimit por ID
    @GetMapping("/{limitId}")
    public ResponseEntity<UserLimitDTO> getUserLimit(@PathVariable Long userId, @PathVariable Long limitId) {
        try {
            // Obtener el UserLimit y convertirlo en DTO
            UserLimit userLimit = userLimitService.getUserLimit(limitId);

            // Convertir a DTO
            UserLimitDTO responseDto = new UserLimitDTO();
            responseDto.setId(userLimit.getId());
            responseDto.setModelType(userLimit.getModelType());
            responseDto.setMaxRequests(userLimit.getMaxRequests());
            responseDto.setMaxTokens(userLimit.getMaxTokens());
            responseDto.setWindowDuration(userLimit.getWindowDuration());

            return new ResponseEntity<>(responseDto, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);  // Límite no encontrado
        }
    }

    // Actualizar un UserLimit existente
    @PutMapping("/{limitId}")
    public ResponseEntity<UserLimitDTO> updateUserLimit(@PathVariable Long userId, @PathVariable Long limitId, @RequestBody UserLimitDTO userLimitDTO) {
        try {
            // Actualizar el UserLimit y devolver el resultado
            UserLimit userLimit = userLimitService.updateUserLimit(limitId, userLimitDTO);

            // Convertir a DTO
            UserLimitDTO responseDto = new UserLimitDTO();
            responseDto.setId(userLimit.getId());
            responseDto.setModelType(userLimit.getModelType());
            responseDto.setMaxRequests(userLimit.getMaxRequests());
            responseDto.setMaxTokens(userLimit.getMaxTokens());
            responseDto.setWindowDuration(userLimit.getWindowDuration());

            return new ResponseEntity<>(responseDto, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);  // Límite no encontrado
        }
    }

    // Validar si el límite de un usuario ha sido excedido para un modelo de IA
    @GetMapping("/validate")
    public ResponseEntity<String> validateUserLimit(@PathVariable Long userId,
                                                    @RequestParam ModelType modelType) {
        try {
            // Validar si el usuario ha excedido su límite para el modelo específico
            User user = new User();  // Aquí debes recuperar el usuario del repositorio
            user.setId(userId);  // Establecer el ID del usuario

            boolean limitExceeded = userLimitService.isLimitExceeded(user, modelType);

            if (limitExceeded) {
                return new ResponseEntity<>("Límite excedido para el modelo: " + modelType, HttpStatus.FORBIDDEN);
            } else {
                return new ResponseEntity<>("Límite no excedido", HttpStatus.OK);
            }
        } catch (RuntimeException e) {
            return new ResponseEntity<>("Usuario no encontrado", HttpStatus.NOT_FOUND);
        }
    }
}


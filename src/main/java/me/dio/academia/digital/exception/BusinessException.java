package me.dio.academia.digital.exception;

import java.util.function.Supplier;

public class BusinessException extends RuntimeException {

    private ApiErrorMessage errorMessage;
    public BusinessException(Long id) {
        super(String.format("User with id %d not found or not exist.", id));
    }

    public BusinessException(String message) {
        super(message);
    }

}

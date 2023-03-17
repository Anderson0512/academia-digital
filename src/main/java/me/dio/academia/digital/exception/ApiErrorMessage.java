package me.dio.academia.digital.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;
@Data
//@Builder
@ToString
@JsonInclude(Include.NON_NULL)
public class ApiErrorMessage {

    private HttpStatus status;

    private String details;

    private String message;
    private List<String> errors;

    public ApiErrorMessage(HttpStatus status, List<String> errors) {
        super();
        this.status = status;
        this.errors = errors;
    }

    public ApiErrorMessage(HttpStatus status, String error) {
        super();
        this.status = status;
        errors = Arrays.asList(error);
    }
}

package com.pedronieto.java_template_kit.adapter.exception.handler.response;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@JsonTypeName("apierro")
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
@JsonPropertyOrder({
        "timestamp",
        "codigoErro",
        "mensagem",
        "mensagemDetalhada",
        "status",
        "subErros"
})
public class ApiErroResponse {
    @JsonProperty("timestamp")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private final LocalDateTime timestamp;
    @JsonProperty("status")
    private HttpStatus status;
    @JsonProperty("codigoErro")
    private Integer codigoErro;
    @JsonProperty("mensagem")
    private String mensagem;
    @JsonProperty("mensagemDetalhada")
    private String mensagemDetalhada;

    @JsonProperty("subErros")
    private List<ApiSubErro> subErros;

    public ApiErroResponse(HttpStatus status) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.codigoErro = status.value();
        this.subErros = new ArrayList<>();
    }

    public ApiErroResponse(HttpStatus status, Throwable ex) {
        this(status);
        this.mensagem = "Erro inesperado";
        this.mensagemDetalhada = ex.getLocalizedMessage();
    }

    public ApiErroResponse(HttpStatus status, String mensagem, Throwable ex) {
        this(status);
        this.mensagem = mensagem;
        this.mensagemDetalhada = ex.getLocalizedMessage();
    }

    private void addSubErro(ApiSubErro subError) {
        this.subErros.add(subError);
    }

    private void addValidationError(FieldError fieldError) {
        addSubErro(new ApiSubErro(fieldError.getField(), fieldError.getDefaultMessage()));
    }

    private void addValidationError(ObjectError objectError) {
        addSubErro(new ApiSubErro(objectError.getObjectName(), objectError.getDefaultMessage()));
    }

    public void addValidationErrors(List<FieldError> fieldErrors) {
        fieldErrors.forEach(this::addValidationError);
    }

    public void addValidationError(List<ObjectError> globalErrors) {
        globalErrors.forEach(this::addValidationError);
    }

    public void addErroNegocio(String codigo, String mensagem) {
        addSubErro(new ApiSubErro(codigo, mensagem));
    }
}
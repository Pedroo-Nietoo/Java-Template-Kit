package com.pedronieto.java_template_kit.adapter.exception.handler.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
@JsonPropertyOrder({
        "codigo",
        "mensagem"
})
public class ApiSubErro {

    @Getter
    private String codigo;
    @Getter
    private String mensagem;

    public ApiSubErro(String codigo, String mensagem) {
        this.codigo = codigo;
        this.mensagem = mensagem;
    }

}
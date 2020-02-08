package com.taluna.logging.product.exception;

import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@ControllerAdvice
public class RestExceptionHandler {
    private static final String ERROR = "error";
    private static final String TICKET = "ticket";
    private static final String UNKNOWN_ERROR = "Erro desconhecido";

    @ExceptionHandler(DomainException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody
    Map<String, Object> handleUncaughtException(Exception ex) {
        Map<String, Object> map = new HashMap<>();
        map.put(ERROR, UNKNOWN_ERROR);
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        map.put(TICKET, timeInMillis);
        return map;
    }

}

package com.pawelszpunar.core.error;

import org.springframework.web.bind.MethodArgumentNotValidException;
import java.util.List;
import java.util.stream.Collectors;

// wyciągnięcie błędów z exception

public class ErrorMessagesMapper {
    public static List<String> map(MethodArgumentNotValidException ex) {
        return ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());
    }
}

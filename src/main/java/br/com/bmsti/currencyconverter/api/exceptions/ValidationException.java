package br.com.bmsti.currencyconverter.api.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.validation.BindingResult;

@AllArgsConstructor
@Getter
public class ValidationException extends RuntimeException {

    private BindingResult bindingResult;
}

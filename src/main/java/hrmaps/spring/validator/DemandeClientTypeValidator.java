package hrmaps.spring.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import hrmaps.spring.entites.DemandeClientType;

@Component
public class DemandeClientTypeValidator implements Validator{
	@Override
    public boolean supports(Class<?> aClass) {
        return DemandeClientType.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

    }

}

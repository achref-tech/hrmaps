package hrmaps.spring.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import hrmaps.spring.entites.Client;
@Component
public class ClientValidator implements Validator{
	@Override
    public boolean supports(Class<?> aClass) {
        return Client.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

    }

}

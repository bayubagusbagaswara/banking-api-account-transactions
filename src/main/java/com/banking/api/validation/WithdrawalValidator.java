package com.banking.api.validation;


import com.banking.api.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@AllArgsConstructor
@Data
public class WithdrawalValidator implements Validator {

    private Double amount;




    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;
        if(! (user.getCheckingBalance() - amount >= 0 )){
            errors.rejectValue("checkingBalance", "NotZero.checkingBalance", "Balance too low");
        }
    }
}

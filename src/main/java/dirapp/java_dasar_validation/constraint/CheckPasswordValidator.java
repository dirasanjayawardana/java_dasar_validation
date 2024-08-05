package dirapp.java_dasar_validation.constraint;

import dirapp.java_dasar_validation.Register;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

// harus implements --> ConstraintValidator<ConstraintAnnotationnya, tipeYgBisaDivalidasi>
public class CheckPasswordValidator implements ConstraintValidator<CheckPassword, Register> {

    private String messageTemplate;

    @Override
    public void initialize(CheckPassword constraintAnnotation) {
        messageTemplate = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Register value, ConstraintValidatorContext context) {
        if (value.getPassword() == null || value.getRetypePassword() == null) {
            return true; // skip validation
        }

        boolean isValid = value.getPassword().equals(value.getRetypePassword());

        // ConstraintValidatorContext --> digunakan untuk membuat custom message dan path
        // dalam keadaan ideal parameter ini tidak dibutuhkan, karena message dan path otomatis sudah ada
        if(!isValid){
            // disable message defaultnya
            context.disableDefaultConstraintViolation();

            // buat message custom untuk password
            context.buildConstraintViolationWithTemplate(messageTemplate)
                    .addPropertyNode("password")
                    .addConstraintViolation();

            // buat message custom untuk refTypePassowrd
            context.buildConstraintViolationWithTemplate(messageTemplate)
                    .addPropertyNode("retypePassword")
                    .addConstraintViolation();
        }

        return isValid;
    }
}
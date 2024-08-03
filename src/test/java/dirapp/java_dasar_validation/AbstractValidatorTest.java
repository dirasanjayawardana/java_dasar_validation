package dirapp.java_dasar_validation;

import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.executable.ExecutableValidator;

public abstract class AbstractValidatorTest {
  
  protected ValidatorFactory validatorFactory;

  protected Validator validator;

  protected ExecutableValidator executableValidator;

  @BeforeEach
  void setUp() {
    validatorFactory = Validation.buildDefaultValidatorFactory();
    validator = validatorFactory.getValidator();
    executableValidator = validator.forExecutables();
  }

  @AfterEach
  void tearDown() {
    validatorFactory.close();
  }

  void validate(Object o) {
    Set<ConstraintViolation<Object>> violations = validator.validate(o);
    for (ConstraintViolation<Object> violation : violations) {
      System.out.println(violation.getPropertyPath());
      System.out.println(violation.getMessage());

      System.out.println("===========================================================");
    }
  }

  // jika groups tidak diberikan, maka validasi tidak dilakukan
  void validateWithGroups(Object o, Class<?>... groups) {
    Set<ConstraintViolation<Object>> violations = validator.validate(o, groups);
    for (ConstraintViolation<Object> violation : violations) {
      System.out.println(violation.getPropertyPath());
      System.out.println(violation.getMessage());
      System.out.println("===========================================================");
    }
  }
}

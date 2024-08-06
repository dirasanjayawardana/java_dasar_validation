package dirapp.java_dasar_validation;

import java.util.Set;

import dirapp.java_dasar_validation.extractor.DataIntegerValueExtractor;
import dirapp.java_dasar_validation.extractor.DataValueExtractor;
import dirapp.java_dasar_validation.extractor.EntryValueExtractorKey;
import dirapp.java_dasar_validation.extractor.EntryValueExtractorValue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.MessageInterpolator;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.executable.ExecutableValidator;

public abstract class AbstractValidatorTest {
  
  protected ValidatorFactory validatorFactory;

  protected Validator validator;

  protected ExecutableValidator executableValidator;

  protected MessageInterpolator messageInterpolator;

  @BeforeEach
  void setUp() {
    // validatorFactory = Validation.buildDefaultValidatorFactory();

    validatorFactory = Validation.byDefaultProvider().configure()
            .addValueExtractor(new DataValueExtractor())
            .addValueExtractor(new EntryValueExtractorKey())
            .addValueExtractor(new EntryValueExtractorValue())
            .addValueExtractor(new DataIntegerValueExtractor())
            .buildValidatorFactory();

    validator = validatorFactory.getValidator();
    executableValidator = validator.forExecutables();
    messageInterpolator = validatorFactory.getMessageInterpolator();
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

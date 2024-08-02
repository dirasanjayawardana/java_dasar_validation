package dirapp.java_dasar_validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class ValidatorTest {
  // ValidatorFactory merupakan sebuah interface yang digunakan untuk membuat object-object yang ada di Bean Validation.
  // untuk membuat ValidatorFactory menggunakan class Validation dan method buildDefaultValidatorFactory().
  // ValidatorFactory juga merupakan object yang berat, sebaiknya hanya buat sekali dalam sebuah aplikasi
  // untuk membuat validator dengan validatorFacotry.getValidator()

  @Test
  void testCreateValidator() {

    ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    Validator validator = validatorFactory.getValidator();

    Assertions.assertNotNull(validator);

    validatorFactory.close();
  }
}

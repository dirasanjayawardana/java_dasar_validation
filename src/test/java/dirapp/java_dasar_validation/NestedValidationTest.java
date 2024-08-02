package dirapp.java_dasar_validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class NestedValidationTest {
  // secara default, jika terdapat nested object, Bean Validation tidak akan melakukan validasi terhadap data object tersebut
  // jika ingin melakukan validasi terhadap nested Object, perlu menambahkan Annotation @Valid


  private Validator validator;

  @BeforeEach
  void setUp() {
    validator = Validation.buildDefaultValidatorFactory().getValidator();
  }


  @Test
  void testNested() {
    Person person = new Person();
    person.setFirstName("Dira");
    person.setLastName("Sanjaya");

    Address address = new Address();
    person.setAddress(address);

    Set<ConstraintViolation<Person>> violations = validator.validate(person);
    for (ConstraintViolation<Person> violation : violations) {
      System.out.println(violation.getMessage());
      System.out.println(violation.getPropertyPath());
      System.out.println("=========================================================");
    }
  }
}
package dirapp.java_dasar_validation;

import org.junit.jupiter.api.Test;

import jakarta.validation.ConstraintViolation;

import java.util.Set;
import java.lang.reflect.Constructor;

public class ConstructorValidationTest extends AbstractValidatorTest {
  // Bean Validation bisa digunakan untuk melakukan validasi di Contructor
  // baik itu Contructor paramter maupun Constructor Value
  // dengan cara menambahkan Annotation Contraint di Constructor
  // untuk melakukan validasinya menggunakan interface ExecutableValidator dengan method forExecuteables()
  // untuk eksekusinya dengan method validateContructorParameters(constructornya, parameternya, groupnya) dan 
  // validateConstructorReturnValue(constructornya, returnValuenya, groupnya)

  @Test
  void testValidateConstructorParameter() throws NoSuchMethodException {
    String firstName = "";
    String lastName = "";
    Address address = new Address();

    Constructor<Person> constructor = Person.class.getConstructor(String.class, String.class, Address.class);

    Set<ConstraintViolation<Object>> violations = executableValidator
        .validateConstructorParameters(constructor, new Object[]{firstName, lastName, address});
    for (ConstraintViolation<Object> violation : violations) {
      System.out.println(violation.getPropertyPath());
      System.out.println(violation.getMessage());
      System.out.println("======================================================================");
    }
  }


  @Test
  void testValidateConstructorReturnValue() throws NoSuchMethodException {
    String firstName = "";
    String lastName = "";
    Address address = new Address();

    Person person = new Person(firstName, lastName, address);

    Constructor<Person> constructor = Person.class.getConstructor(String.class, String.class, Address.class);

    Set<ConstraintViolation<Object>> violations = executableValidator
        .validateConstructorReturnValue(constructor, person);
    for (ConstraintViolation<Object> violation : violations) {
      System.out.println(violation.getPropertyPath());
      System.out.println(violation.getMessage());
      System.out.println("======================================================================");
    }
  }
}

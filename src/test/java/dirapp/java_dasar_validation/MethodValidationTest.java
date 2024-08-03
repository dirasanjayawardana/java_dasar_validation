package dirapp.java_dasar_validation;

import org.junit.jupiter.api.Test;

import jakarta.validation.ConstraintViolation;

import java.util.Set;
import java.lang.reflect.Method;

public class MethodValidationTest extends AbstractValidatorTest {
  // Bean Validation bisa digunakan untuk melakukan validasi di Method, baik itu Method paramter maupun Return Value
  // dengan cara menambahkan Annotation Contraint di Method
  // untuk melakukan validasinya menggunakan interface ExecutableValidator dengan method forExecuteables()
  // untuk eksekusinya dengan method validateParameters(classnya, methodnya, parameternya, groupnya) dan // validateReturnValue(classnya, methodnya, returnValuenya, groupnya)

  @Test
  void testSayHello() throws NoSuchMethodException {
    Person person = new Person();
    String name = "";

    Method method = Person.class.getMethod("sayHello", String.class);

    // validateParameters(classnya, methodnya, parameternya, groupnya)
    Set<ConstraintViolation<Person>> violations = executableValidator.validateParameters(person, method, new Object[]{name});
    for (ConstraintViolation<Person> violation : violations) {
      System.out.println(violation.getPropertyPath());
      System.out.println(violation.getMessage());
      System.out.println("===============================================================");
    }
  }

  @Test
  void testFullName() throws NoSuchMethodException {
    Person person = new Person();
    person.setFirstName("");
    person.setLastName("");

    String returnValue = person.fullName();

    Method method = Person.class.getMethod("fullName");

    // validateReturnValue(classnya, methodnya, returnValuenya, groupnya)
    Set<ConstraintViolation<Person>> violations = executableValidator.validateReturnValue(person, method, returnValue);
    for (ConstraintViolation<Person> violation : violations) {
      System.out.println(violation.getPropertyPath());
      System.out.println(violation.getMessage());
      System.out.println("==============================================================");
    }
  }
}

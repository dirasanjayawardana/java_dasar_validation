package dirapp.java_dasar_validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class ConstraintViolationTest {
    // Untuk melakukan validasi terhadap object yang sudah diberikan Constraint pada field atau methodnya, bisa menggunakan validator.validate(Objectnya)
    // Hasil kembaliannya akan ditampung dalam Set<ConstraintViolation<T>, jika tidak ada kesalahan, maka Set<ConstraintViolation<T> akan kosong.


    private ValidatorFactory validatorFactory;

    private Validator validator;

    @BeforeEach
    void setUp() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }


    @AfterEach
    void tearDown() {
        validatorFactory.close();
    }


    @Test
    void testValidationFailedNotBlank() {
        Person person = new Person();

        Set<ConstraintViolation<Person>> violations = validator.validate(person);
        Assertions.assertEquals(3, violations.size());

        for (ConstraintViolation<Person> violation : violations) {
            // mendapatkan message errornya
            System.out.println("Message : " + violation.getMessage());
            // mengetahui field yang error ada di object mana
            System.out.println("Bean : " + violation.getLeafBean());
            // mendapatkan annotasi yang dilanggar
            System.out.println("Constraint : " + violation.getConstraintDescriptor().getAnnotation());
            // mendapatkan value dari field yang error
            System.out.println("Invalid Value : " + violation.getInvalidValue());
            // mengetahui error ada di field mana
            System.out.println("Path : " + violation.getPropertyPath());

            System.out.println("===============================");
        }
    }


    @Test
    void testValidationFailedSize() {
        Person person = new Person();
        person.setFirstName("DIRAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        person.setLastName("DIRAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");

        Set<ConstraintViolation<Person>> violations = validator.validate(person);
        Assertions.assertEquals(3, violations.size());

        for (ConstraintViolation<Person> violation : violations) {
            System.out.println("Message : " + violation.getMessage());
            System.out.println("Bean : " + violation.getLeafBean());
            System.out.println("Constraint : " + violation.getConstraintDescriptor().getAnnotation());
            System.out.println("Invalid Value : " + violation.getInvalidValue());
            System.out.println("Path : " + violation.getPropertyPath());

            System.out.println("=========================================================");
        }
    }


    @Test
    void testValidationSuccess() {
        Person person = new Person();
        person.setFirstName("Dira");
        person.setLastName("Sanjaya");

        Set<ConstraintViolation<Person>> violations = validator.validate(person);
        Assertions.assertEquals(0, violations.size());
    }
}
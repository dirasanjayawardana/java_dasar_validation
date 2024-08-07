package dirapp.java_dasar_validation;

import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExceptionTest extends AbstractValidatorTest {
    // secara default Bean Validation tidak membuat exception ketika terjadi error
    // hanya mengembalikan error dalam bentuk Set<ConstraintViolation<T>>
    // jika butuh membuat exception manual, bisa menggunakan ConstraintViolationExceptio

    @Test
    void testException() {
        Assertions.assertThrows(ConstraintViolationException.class, () -> {
            Person person = new Person();
            validateWithException(person);
        });
    }
}

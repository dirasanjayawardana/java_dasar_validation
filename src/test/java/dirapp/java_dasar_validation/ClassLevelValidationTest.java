package dirapp.java_dasar_validation;

import org.junit.jupiter.api.Test;

public class ClassLevelValidationTest extends AbstractValidatorTest {
    // Constraint bisa di tambahkan pada level class
    // tambahkan ElementType.TYPE pada target di Custom Constraint agar bisa digunakan di class

    @Test
    void testClassLevel() {
        Register register = new Register();
        register.setUsername("dira");
        register.setPassword("test");
        register.setRetypePassword("test123");

        validate(register);
    }
}

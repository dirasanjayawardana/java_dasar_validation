package dirapp.java_dasar_validation;

import dirapp.java_dasar_validation.service.UserService;
import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Set;

public class CrossParameterValidationTest extends AbstractValidatorTest {
    // Cross-Parameter Constraint digunakan untuk melakukan validasi beberapa parameter
    // @SupportedValidationTarget --> untuk melakukan validasi semua parameter di Method atau Constructor

    // untuk melakukan validasinya menggunakan interface ExecutableValidator dengan method forExecuteables()
    // untuk eksekusinya dengan method validateParameters(classnya, methodnya, parameternya, groupnya)

    @Test
    void testCrossParameter() throws NoSuchMethodException {

        UserService userService = new UserService();

        Method method = UserService.class.getMethod("register", String.class, String.class, String.class);
        String username = "dira";
        String password = "test";
        String retypePassword = "test1234";

        Set<ConstraintViolation<UserService>> violations = executableValidator
                .validateParameters(userService, method, new Object[]{username, password, retypePassword});

        for (ConstraintViolation<UserService> violation : violations) {
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());
            System.out.println("=======================================================");
        }

    }
}

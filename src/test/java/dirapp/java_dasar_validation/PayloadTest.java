package dirapp.java_dasar_validation;

import org.junit.jupiter.api.Test;

import dirapp.java_dasar_validation.group.CreditCardPaymentGroup;
import dirapp.java_dasar_validation.payload.EmailErrorPayload;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Payload;

import java.util.Set;

public class PayloadTest extends AbstractValidatorTest {
  // pada Annotation Constraint, selain memiliki method message() dan groups(), juga terdapat payload()
  // method payload() digunakan untuk menambah informasi ketika menggunakan constraint
  // namun tidak digunakan sama sekali oleh Bean Validation

  // contoh ketika terjadi validation error akan mengirim email

  @Test
  void testPayload() {
    Payment payment = new Payment();
    payment.setOrderId("0001");
    payment.setAmount(20_000L);
    payment.setCreditCard("31111");

    Set<ConstraintViolation<Object>> violations = validator.validate(payment, CreditCardPaymentGroup.class);
    for (ConstraintViolation<Object> violation : violations) {
      System.out.println(violation.getPropertyPath());
      System.out.println(violation.getMessage());

      // trigger payload() agar di jalankan ketika terjadi error
      Set<Class<? extends Payload>> payload = violation.getConstraintDescriptor().getPayload();
      for (Class<? extends Payload> payloadClass : payload) {
        if(payloadClass == EmailErrorPayload.class){
          EmailErrorPayload emailErrorPayload = new EmailErrorPayload();
          emailErrorPayload.sendEmail(violation);
        }
      }

      System.out.println("============================================================");
    }
  }
}

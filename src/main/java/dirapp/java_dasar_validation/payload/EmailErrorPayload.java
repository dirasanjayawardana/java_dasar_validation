package dirapp.java_dasar_validation.payload;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Payload;

public class EmailErrorPayload implements Payload {
  // pada Annotation Constraint, selain memiliki method message() dan groups(), juga terdapat payload()
  // method payload() digunakan untuk menambah informasi ketika menggunakan constraint
  // namun tidak digunakan sama sekali oleh Bean Validation
  
  // contoh ketika terjadi validation error akan mengirim email

  public void sendEmail(ConstraintViolation<?> violation){
    System.out.println("Send email because error : " + violation.getMessage());
  }
}

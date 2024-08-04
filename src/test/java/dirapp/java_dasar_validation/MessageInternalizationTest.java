package dirapp.java_dasar_validation;

import java.util.Locale;
import java.util.Set;

import org.hibernate.validator.internal.engine.MessageInterpolatorContext;
import org.hibernate.validator.messageinterpolation.ExpressionLanguageFeatureLevel;
import org.junit.jupiter.api.Test;

import dirapp.java_dasar_validation.group.CreditCardPaymentGroup;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.MessageInterpolator;

public class MessageInternalizationTest extends AbstractValidatorTest {
  // secara default ketika menggunakan resource bundle (file properties), Locale yang digunakan adalah Locale.getDefault()
  // untuk merubah Locale untuk Resourcel bundle, haru merubah Locale defaultnya


  @Test
  void testI18N() {
    Locale.setDefault(new Locale("in", "ID"));

    Payment payment = new Payment();
    payment.setOrderId("3240982394823904832049");
    payment.setAmount(10L);

    validateWithGroups(payment, CreditCardPaymentGroup.class);
  }


  // dengan menggunakan MessageInterpolator, tidak perlu set LocaleDefault() nya
  // cukup gunakan Locale di Message Interpolator, sehinggal Locale hany diubah untuk message saja, tidak secara keseluruhan aplikasi
  @Test
  void testMessageInterpolator() {
    Payment payment = new Payment();
    payment.setOrderId("3240982394823904832049");
    payment.setAmount(10L);

    Locale locale = new Locale("in", "ID");

    Set<ConstraintViolation<Object>> violations = validator.validate(payment, CreditCardPaymentGroup.class);
    for (ConstraintViolation<Object> violation : violations) {
      System.out.println(violation.getPropertyPath());
      System.out.println(violation.getMessageTemplate());

      MessageInterpolator.Context context = new MessageInterpolatorContext(
          violation.getConstraintDescriptor(), violation.getInvalidValue(), violation.getRootBeanClass(),
          violation.getPropertyPath(), violation.getConstraintDescriptor().getAttributes(),
          violation.getConstraintDescriptor().getAttributes(),
          ExpressionLanguageFeatureLevel.VARIABLES, true
      );

      String message = messageInterpolator.interpolate(violation.getMessageTemplate(), context, locale);
      System.out.println(message);

      System.out.println("==============================================================");
    }
  }
}

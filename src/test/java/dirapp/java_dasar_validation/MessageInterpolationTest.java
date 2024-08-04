package dirapp.java_dasar_validation;

import org.junit.jupiter.api.Test;

import dirapp.java_dasar_validation.group.VirtualAccountPaymentGroup;

public class MessageInterpolationTest extends AbstractValidatorTest {
  // Message Interpolation merupakan proses membuat pesan error ketika terjadi kesalahan pada constraint
  // secara default, pesan kesalahan akan diambil dari method message() miliki contraint
  // jika ingin menyesuaikan message sesuai constraintnya bisa dengan {method}
  // jika ingin menampilkan karakter {} di dalam message, perlu menambahkan \ di depannya, misalnya \{contoh\}
  
  @Test
  void testMessage() {

    Payment payment = new Payment();
    payment.setOrderId("10238138193810312938");
    payment.setVirtualAccount("312313");
    payment.setAmount(10L);

    validateWithGroups(payment, VirtualAccountPaymentGroup.class);
  }
}

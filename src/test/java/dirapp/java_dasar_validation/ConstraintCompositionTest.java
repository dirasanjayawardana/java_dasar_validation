package dirapp.java_dasar_validation;

import dirapp.java_dasar_validation.group.CreditCardPaymentGroup;
import org.junit.jupiter.api.Test;

public class ConstraintCompositionTest extends AbstractValidatorTest {
    // Constraint Composition digunakan untuk membuat Constraint baru yang didalamnya adalah kumpulan beberapa Constraint lainnya
    // dengan membuat Constraint Annotation Custom, dan menambahkan Constraint Annotation lain pada Annotation custom yang dibuat
    // @ReportAsSingleViolation --> jika terjadi error disalah satu constraint, tidak dilanjutkan pengecekan ke constraint selanjutnya

    @Test
    void testComposition() {
        Payment payment = new Payment();
        payment.setOrderId("29852309850238529589akjkjdsak");

        validateWithGroups(payment, CreditCardPaymentGroup.class);
    }
}

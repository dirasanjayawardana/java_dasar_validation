package dirapp.java_dasar_validation.constraint;

import dirapp.java_dasar_validation.enums.CaseMode;
import dirapp.java_dasar_validation.group.CreditCardPaymentGroup;
import dirapp.java_dasar_validation.group.VirtualAccountPaymentGroup;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.ReportAsSingleViolation;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

// Constraint Composition digunakan untuk membuat Constraint baru yang didalamnya adalah kumpulan beberapa Constraint lainnya
// dengan membuat Constraint Annotation Custom, dan menambahkan Constraint Annotation lain pada Annotation custom yang dibuat
// @ReportAsSingleViolation --> jika terjadi error disalah satu constraint, tidak dilanjutkan pengecekan ke constraint selanjutnya

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@CheckCase(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class},
        mode = CaseMode.UPPER, message = "{order.id.upper}")
@NotBlank(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class},
        message = "{order.id.notblank}")
@Size(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class},
        min = 1, max = 10, message = "{order.id.size}")
@Documented
@Constraint(validatedBy = {})
@Target({FIELD})
@Retention(RUNTIME)
@ReportAsSingleViolation // jika terjadi error disalah satu constraint, tidak dilanjutkan pengecekan ke constraint selanjutnya
public @interface CheckOrderId {

    String message() default "invalid order id";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
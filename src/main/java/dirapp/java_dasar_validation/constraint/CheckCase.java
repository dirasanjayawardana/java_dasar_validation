package dirapp.java_dasar_validation.constraint;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import dirapp.java_dasar_validation.enums.CaseMode;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = {CheckCaseValidator.class})
@Target({FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
public @interface CheckCase {

  CaseMode mode();

  // wajib ada message(), groups() dan payload()
  String message() default "invalid case format";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}


// @Documented:
// Anotasi ini digunakan untuk menunjukkan bahwa anotasi @CheckCase akan disertakan dalam dokumentasi Javadoc. Ini membantu untuk mendokumentasikan bahwa anotasi ini ada dan dapat digunakan di tempat-tempat tertentu.

// @Constraint:
// Anotasi ini digunakan untuk menunjukkan bahwa anotasi @CheckCase adalah sebuah constraint (batasan/validasi) yang harus divalidasi oleh validator tertentu.
// Atribut validatedBy menunjuk pada kelas validator (CheckCaseValidator.class) yang akan digunakan untuk melakukan validasi.

// @Target:
// Anotasi ini digunakan untuk menentukan di mana anotasi @CheckCase dapat diterapkan. Dalam hal ini, @CheckCase dapat diterapkan pada FIELD dan ANNOTATION_TYPE.
// FIELD berarti anotasi ini bisa diterapkan pada variabel/field.
// ANNOTATION_TYPE berarti anotasi ini bisa digunakan untuk mendekorasi anotasi lainnya.

// @Retention:
// Anotasi ini menentukan berapa lama anotasi @CheckCase akan dipertahankan. Dalam hal ini, @CheckCase akan dipertahankan pada runtime (RUNTIME), yang berarti anotasi ini tersedia selama runtime dan dapat diakses melalui reflection.
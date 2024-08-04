# Bean Validation
Merupakan standard spesifikasi untuk melakukan validasi di java.
Masuk ke dalam teknologi Java Enterprise/Jakarta Enterprise.

## Hibernate Validator
Bean Validation hanyalah spedifikasi standard, yang berisi kumpulan kontrak interface dan annotation.
untuk implementasinya, butuh driver untuk Bean Validation.
Hibernate Validator adalah salah satu driver atau implementasi Bean Validation yang paling populer.

## Validator
Merupakan class utama dalam Bean Validation, digunakan sebagai object untuk mengeksekusi validation.
Validator merupakan object yang berat, sebaiknya hanya dibuat satu kali saja dalam sebuah aplikasi.
Validator merupakan sebuah interface, untuk membuatnya butuh object ValidatorFactory.

### Validator Factory
Validator factory merupakan sebuah interface yang digunakan untuk membuat object-object yang ada di Bean Validation.
untuk membuat ValidatorFactory menggunakan class Validation dan method buildDefaultValidatorFactory().
ValidatorFactory juga merupakan object yang berat, sebaiknya hanya buat sekali dalam sebuah aplikasi

## Learning
- test/ValidatorTest.java
- test/ConstraintViolationTest.java
- test/NestedValidationTest.java
- test/HibernateValidatorConstraintTest.java
- test/GroupTest.java
- test/GroupSequenceTest.java
- test/GroupConvertTest.java
- test/PayloadTest.java
- test/MethodValidationTest.java
- test/ConstructorValidationTest.java
- test/MessageInterpolationTest.java
- resource/ValidationMessage.properties
- test/MessageInternalizationTest.java
- test/CustomConstraintTest.java
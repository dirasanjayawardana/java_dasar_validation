package dirapp.java_dasar_validation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ContainerDataTest extends AbstractValidatorTest {
    // saat membuat class, banyak menggunakan tipe data container (seperti Optional, Collection, List, Set, Map, dll)
    // secara default jika container diisi dengan data Oject, misal @Valid List<Address>, maka secara otomatis Bean Validation akan melakukan validasi semua data object Address sesuai dengan constraint yang ada di class Address
    // untuk melakukan validasi pada tipe data container yang berisi data generic type (seperti List<String> atau Map>String, String>, dengan cara memberikan Annotasi pada generic Type nya
    // contohnya --> List<@NotBlank(message = "contoh") String>

    @Test
    void testContainerData() {
        Person person = new Person();
        person.setFirstName("Dira");
        person.setLastName("Sanjaya");
        person.setAddress(new Address());
        person.getAddress().setCity("Jakarta");
        person.getAddress().setCountry("Indonesia");
        person.getAddress().setStreet("Jl. testing test");

        person.setHobbies(new ArrayList<>());
        person.getHobbies().add("");
        person.getHobbies().add("   ");
        person.getHobbies().add("Gaming");

        validate(person);
    }
}

package dirapp.java_dasar_validation;

import dirapp.java_dasar_validation.container.Data;
import dirapp.java_dasar_validation.container.DataInteger;
import dirapp.java_dasar_validation.container.Entry;
import org.junit.jupiter.api.Test;

public class ValueExtractorTest extends AbstractValidatorTest {
    // value extractor merupakan proses melakukan ekstraksi nilai dari data jenis container (List, Map, dll)
    // sehingga bisa melakukan validation untuk setiap generic yang ada pada container

    @Test
    void testSampleData() {
        SampleData data = new SampleData();
        data.setData(new Data<>());
        data.getData().setData("   ");

        validate(data);
    }

    @Test
    void testSampleEntry() {
        SampleEntry sampleEntry = new SampleEntry();
        sampleEntry.setEntry(new Entry<>());
        sampleEntry.getEntry().setKey("");
        sampleEntry.getEntry().setValue("");

        validate(sampleEntry);
    }

    @Test
    void testSampleDataInteger() {
        SampleDataInteger sampleDataInteger = new SampleDataInteger();
        sampleDataInteger.setData(new DataInteger());
        sampleDataInteger.getData().setData(0);

        validate(sampleDataInteger);
    }
}

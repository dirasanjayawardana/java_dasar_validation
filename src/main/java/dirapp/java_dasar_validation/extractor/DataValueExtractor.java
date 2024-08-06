package dirapp.java_dasar_validation.extractor;

import dirapp.java_dasar_validation.container.Data;
import jakarta.validation.valueextraction.ExtractedValue;
import jakarta.validation.valueextraction.ValueExtractor;

// Data<@ExtractedValue ?> --> menandakan bahwa Data yang akan di extract
public class DataValueExtractor implements ValueExtractor<Data<@ExtractedValue ?>> {

    @Override
    public void extractValues(Data<?> originalValue, ValueReceiver receiver) {
        Object data = originalValue.getData();
        receiver.value(null, data);
    }
}
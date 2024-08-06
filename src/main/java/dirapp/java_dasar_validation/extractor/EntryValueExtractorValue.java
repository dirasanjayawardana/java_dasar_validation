package dirapp.java_dasar_validation.extractor;

import dirapp.java_dasar_validation.container.Entry;
import jakarta.validation.valueextraction.ExtractedValue;
import jakarta.validation.valueextraction.ValueExtractor;

// extractor dibuat untuk setiap generic dari container, misal Entry<K, V>, maka harus dibuat extractor untuk K dan V
public class EntryValueExtractorValue implements ValueExtractor<Entry<?, @ExtractedValue ?>> {

    @Override
    public void extractValues(Entry<?, ?> originalValue, ValueReceiver receiver) {
        receiver.keyedValue(null, "value", originalValue.getValue());
    }
}
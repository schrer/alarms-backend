package at.schrer.alarms.client.converter;

import com.opencsv.bean.CsvToBeanBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class CsvMessageConverter<T> implements HttpMessageConverter<List<T>> {
    private static final Logger LOGGER = LoggerFactory.getLogger(CsvMessageConverter.class);

    @Override
    public boolean canRead(Class clazz, MediaType mediaType) {
        Type genericSuperclass = this.getClass().getGenericSuperclass();
        if (genericSuperclass instanceof ParameterizedType parameterizedType) {
            return parameterizedType.getActualTypeArguments()[0].equals(clazz);
        }

        throw new RuntimeException("Missing type parameter");
    }

    @Override
    public boolean canWrite(Class clazz, MediaType mediaType) {
        return false;
    }

    @Override
    public List<MediaType> getSupportedMediaTypes() {
        return List.of(MediaType.ALL);
    }

    @Override
    public List<T> read(Class<? extends List<T>> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return new CsvToBeanBuilder<T>(new InputStreamReader(inputMessage.getBody()))
                .build()
                .parse();
    }

    @Override
    public void write(List<T> ts, MediaType contentType, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        // Not implemented
        LOGGER.warn("Trying to write CSV object with message converter that does not support writing.");
    }
}

package at.schrer.alarms.client.converter;

import at.schrer.alarms.data.client.bgl.BglFireBrigade;
import at.schrer.alarms.data.client.bgl.BglFireBrigadeHolder;

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
import java.util.List;

public class BglBrigadeCsvMessageConverter implements HttpMessageConverter<BglFireBrigadeHolder> {
    private static final Logger LOGGER = LoggerFactory.getLogger(BglBrigadeCsvMessageConverter.class);

    @Override
    public boolean canRead(Class clazz, MediaType mediaType) {
        return BglFireBrigadeHolder.class.equals(clazz);
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
    public BglFireBrigadeHolder read(Class<? extends BglFireBrigadeHolder> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        List<BglFireBrigade> brigades = new CsvToBeanBuilder<BglFireBrigade>(new InputStreamReader(inputMessage.getBody()))
                .withType(BglFireBrigade.class)
                .withSeparator(';')
                .withSkipLines(1)
                .build()
                .parse();
        return new BglFireBrigadeHolder(brigades);
    }

    @Override
    public void write(BglFireBrigadeHolder ts, MediaType contentType, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        // Not implemented
        LOGGER.warn("Trying to write CSV object with message converter that does not support writing.");
    }
}

package at.schrer.alarms.client;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.ParameterizedType;
import java.util.List;

abstract class BaseClient<T> {
    private final Class<T> genericType;
    private final RestTemplate restTemplate;

    BaseClient() {
        this.restTemplate = new RestTemplate();
        this.genericType = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    protected T get(String uri) {
        ResponseEntity<T> response = restTemplate.getForEntity(uri, genericType);
        return response.getBody();
    }

    protected void setMessageConverter(HttpMessageConverter<?> messageConverter) {
        restTemplate.setMessageConverters(List.of(messageConverter));
    }
}

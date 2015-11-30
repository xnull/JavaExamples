import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

/**
 * Created by bynull on 30.11.15.
 */
public class GovnoTest {

    @Test
    public void testTest() throws Exception {
        String json = "{\"data\": {\"customField\": \"custom data\"}, \"result\": true}";

        MyGenericMessage<MyWeirdObject> obj = JsonUtil.objectMapper.readValue(json, new TypeReference<MyGenericMessage<MyWeirdObject>>() {
        });

        assertTrue(obj.result);
    }

    public static class JsonUtil {
        private static final ObjectMapper objectMapper = build();

        private static ObjectMapper build() {
            SimpleModule module = new SimpleModule();
            module.addDeserializer(MyWeirdObject.class, new MyDeserializer());

            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(module);

            return mapper;
        }
    }

    public static class MyDeserializer  extends JsonDeserializer<MyWeirdObject> {
        @Override
        public MyWeirdObject deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
            jp.nextValue();

            MyWeirdObject obj = new MyWeirdObject();
            obj.name = jp.getValueAsString();
            return obj;
        }
    }

    public static class MyGenericMessage<T> {
        public boolean result;
        public T data;
    }

    public static class MyWeirdObject {
        public String name;
    }
}

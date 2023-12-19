package demo.application.backend.utils.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import demo.application.backend.utils.datetime.Util_DateTime;
import lombok.SneakyThrows;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GlobalJsonLocalDateTimeUsingTimeZoneSerializer extends JsonSerializer<LocalDateTime> {

    @SneakyThrows
    @Override
    public void serialize(LocalDateTime date, JsonGenerator jsonGenerator, SerializerProvider provider) throws IOException {
        date = Util_DateTime.deserializarFechaHora(date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), true);
        jsonGenerator.writeString(date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
    }
}


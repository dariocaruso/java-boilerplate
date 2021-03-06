package ar.com.dariocaruso.boilerplate.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Converter(autoApply = true)
public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, Date> {

    @Override
    public Date convertToDatabaseColumn(LocalDateTime localDateTime) {
        return (localDateTime == null ? null : Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant()));
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Date date) {
        return (date == null ? null : LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()));
    }
}

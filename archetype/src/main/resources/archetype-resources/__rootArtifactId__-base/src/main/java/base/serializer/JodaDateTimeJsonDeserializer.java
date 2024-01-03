#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.base.serializer;

import ${package}.base.util.date.JodaDateTimeUtils;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.io.IOException;

/**
 * @Author linchengdong
 * @Date 2023-11-29 15:09
 * @PackageName:${package}.base.serializer
 * @ClassName: JodaDateTimeJsonDeserializer
 * @Description: 日期反序列化
 * @Version 1.0
 */
public class JodaDateTimeJsonDeserializer extends JsonDeserializer {


    @Override
    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        String dataString = jsonParser.readValueAs(String.class);
        DateTimeFormatter formatter = DateTimeFormat.forPattern(JodaDateTimeUtils.DATE_TIME_FORMAT);
        return DateTime.parse(dataString, formatter);
    }
}

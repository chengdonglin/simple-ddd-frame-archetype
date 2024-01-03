#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.base.serializer;

import ${package}.base.util.date.JodaDateTimeUtils;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.joda.time.DateTime;

import java.io.IOException;

/**
 * @Author linchengdong
 * @Date 2023-11-29 15:11
 * @PackageName:${package}.base.serializer
 * @ClassName: JodaDateTimeJsonSerializer
 * @Description: 日期序列化
 * @Version 1.0
 */
public class JodaDateTimeJsonSerializer extends JsonSerializer<DateTime> {

    @Override
    public void serialize(DateTime value, JsonGenerator gen, SerializerProvider serializerProvider) throws IOException {
        gen.writeString(value.toString(JodaDateTimeUtils.DATE_TIME_FORMAT));
    }
}

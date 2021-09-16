package wooteco.prolog.common;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConverterConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(monthConverter());
        registry.addConverter(localDateConverter());
    }

    private Converter<String, Month> monthConverter() {
        return new Converter<String, Month>() {
            @Override
            public Month convert(String source) {
                return Month.of(Integer.parseInt(source));
            }
        };
    }

    private Converter<String, LocalDate> localDateConverter() {
        return new Converter<String, LocalDate>() {
            @Override
            public LocalDate convert(String source) {
                return LocalDate.parse(source, DateTimeFormatter.ofPattern("yyyyMMdd"));
            }
        };
    }
}

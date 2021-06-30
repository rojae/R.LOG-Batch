package kr.rlog.batch.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
@Slf4j
public class MessageUtils {

    private static MessageSource messageSource;

    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        MessageUtils.messageSource = messageSource;
    }

    public static String getMessage(String key, Object... args) {
        Locale locale = LocaleContextHolder.getLocale();
        return MessageUtils.messageSource.getMessage(key, args, locale);
    }

    public static String getMessage(String key, Locale locale, Object... args) {
        return MessageUtils.messageSource.getMessage(key, args, locale);
    }

    public static String getMessage(MessageSourceResolvable resolvable) {
        Locale locale = LocaleContextHolder.getLocale();
        return MessageUtils.messageSource.getMessage(resolvable, locale);
    }

}
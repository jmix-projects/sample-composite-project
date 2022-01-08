package com.company.users.entity;

import io.jmix.core.metamodel.annotation.DatatypeDef;
import io.jmix.core.metamodel.annotation.Ddl;
import io.jmix.core.metamodel.datatype.FormatStrings;
import io.jmix.core.metamodel.datatype.TimeZoneAwareDatatype;
import io.jmix.core.metamodel.datatype.impl.AbstractTemporalDatatype;

import javax.annotation.Nullable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalQuery;
import java.util.Locale;
import java.util.TimeZone;

@DatatypeDef(id = InstantDatatype.ID, javaClass = Instant.class, defaultForClass = true, value = InstantDatatype.VALUE)
@Ddl("TIMESTAMP")
public class InstantDatatype extends AbstractTemporalDatatype<Instant> implements TimeZoneAwareDatatype {

    /**
     * Defines the datatype definition identifier.
     */
    public static final String ID = "instant";

    /**
     * Defines the datatype definition value.
     */
    public static final String VALUE = "usr_InstantDatatype";

    /**
     * Public default constructor.
     */
    public InstantDatatype() {
        super(DateTimeFormatter.ISO_INSTANT);
    }

    @Override
    public String format(@Nullable final Object aValue, final Locale aLocale, @Nullable final TimeZone aTimeZone) {
        final String result;
        if (aValue instanceof Instant) {
            if (aTimeZone == null) {
                result = format(aValue, aLocale);
            } else {
                final LocalDateTime localDateTime = ((Instant) aValue).atZone(aTimeZone.toZoneId()).toLocalDateTime();

                result = format(localDateTime, aLocale);
            }
        } else {
            result = null;
        }

        return result;
    }

    @Override
    protected DateTimeFormatter getDateTimeFormatter() {
        return DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withZone(ZoneId.systemDefault());
    }

    @Override
    protected DateTimeFormatter getDateTimeFormatter(final FormatStrings someFormatStrings, final Locale aLocale) {
        return DateTimeFormatter.ofPattern(someFormatStrings.getDateTimeFormat(), aLocale)
                .withZone(ZoneId.systemDefault());
    }

    @Override
    protected TemporalQuery<Instant> newInstance() {
        return Instant::from;
    }
}
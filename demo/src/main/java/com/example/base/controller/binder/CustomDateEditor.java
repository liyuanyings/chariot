package com.example.base.controller.binder;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.util.Date;

public class CustomDateEditor extends PropertyEditorSupport {

    private final String[] dateFormats;

    private final boolean allowEmpty;

    private final int exactDateLength;

    public CustomDateEditor(String[] dateFormat, boolean allowEmpty) {
        this.dateFormats = dateFormat;
        this.allowEmpty = allowEmpty;
        this.exactDateLength = -1;
    }

    public CustomDateEditor(String[] dateFormat, boolean allowEmpty, int exactDateLength) {
        this.dateFormats = dateFormat;
        this.allowEmpty = allowEmpty;
        this.exactDateLength = exactDateLength;
    }

    @Override
    public void setAsText(@Nullable String text) throws IllegalArgumentException {
        if (this.allowEmpty && !StringUtils.hasText(text)) {
            setValue(null);
        }
        else if (text != null && this.exactDateLength >= 0 && text.length() != this.exactDateLength) {
            throw new IllegalArgumentException(
                    "Could not parse date: it is not exactly" + this.exactDateLength + "characters long");
        }
        else {
            try {
                setValue(DateUtils.parseDate(text, dateFormats));
            }
            catch (ParseException ex) {
                throw new IllegalArgumentException("Could not parse date: " + ex.getMessage(), ex);
            }
        }
    }

    @Override
    public String getAsText() {
        Date value = (Date) getValue();
        return (value != null ? DateFormatUtils.format(value, "yyyy-mm-dd hh:mm:ss") : "");
    }

}

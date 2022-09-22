package com.todo.todoserver.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFountException extends RuntimeException {

    private String reasonName;
    private String fieldName;
    private Object fieldValue;

    public ResourceNotFountException(String reasonName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s : '%s' ", reasonName, fieldName, fieldValue));
        this.reasonName = reasonName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getReasonName() {
        return reasonName;
    }

    public void setReasonName(String reasonName) {
        this.reasonName = reasonName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(Object fieldValue) {
        this.fieldValue = fieldValue;
    }

}

package com.example.kendo.exception;

public class BusinessException extends RuntimeException {

    private final String messageId;
    private final String field;

    public BusinessException(String messageId, String field) {
        super(String.format("エラーコード: %s, 対象フィールド: %s", messageId, field));
        this.messageId = messageId;
        this.field = field;
    }

    public String getMessageId() {
        return messageId;
    }

    public String getField() {
        return field;
    }
}

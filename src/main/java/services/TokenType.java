package services;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum TokenType {

    IDENTIFICADOR("IDENTIFICADOR", true),
    REAL_NUMBER("NÚMERO REAL", true),
    INT_NUMBER("NÚMERO INTEIRO", true),
    COMMENT("COMENTÁRIO", false),
    ABSTRACT("ABSTRACT", false),
    ASSERT("ASSERT", false),
    BOOLEAN("BOOLEAN", false),
    BREAK("BREAK", false),
    BYTE("BYTE", false),
    CASE("CASE", false),
    CATCH("CATCH", false),
    CHAR("CHAR", false),
    CLASS("CLASS", false),
    CONST("CONST", false),
    CONTINUE("CONTINUE", false),
    DEFAULT("DEFAULT", false),
    DOUBLE("DOUBLE", false),
    DO("DO", false),
    ELSE("ELSE", false),
    ENUM("ENUM", false),
    EXTENDS("EXTENDS", false),
    FALSE("FALSE", false),
    FINAL("FINAL", false),
    FINALLY("FINALLY", false),
    FLOAT("FLOAT", false),
    FOR("FOR", false),
    IF("IF", false),
    IMPLEMENTS("IMPLEMENTS", false),
    IMPORT("IMPORT", false),
    INSTANCEOF("INSTANCEOF", false),
    INT("INT", false),
    INTERFACE("INTERFACE", false),
    LONG("LONG", false),
    GOTO("GOTO", false),
    NATIVE("NATIVE", false),
    NEW("NEW", false),
    NULL("NULL", false),
    PACKAGE("PACKAGE", false),
    PRIVATE("PRIVATE", false),
    PROTECTED("PROTECTED", false),
    PUBLIC("PUBLIC", false),
    RETURN("RETURN", false),
    SHORT("SHORT", false),
    STATIC("STATIC", false),
    STRICTFP("STRICTFP", false),
    SUPER("SUPER", false),
    SWITCH("SWITCH", false),
    SYNCHRONIZED("SYNCHRONIZED", false),
    THIS("THIS", false),
    THROW("THROW", false),
    THROWS("THROWS ", false),
    TRANSIENT("TRANSIENT ", false),
    TRUE("TRUE ", false),
    TRY("TRY ", false),
    VOID("VOID ", false),
    VOLATILE("VOLATILE ", false),
    WHILE("WHILE ", false);

    public String message;

    public boolean addTableSymbol;
}

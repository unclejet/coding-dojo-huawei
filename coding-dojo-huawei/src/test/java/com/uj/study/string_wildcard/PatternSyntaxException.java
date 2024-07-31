package com.uj.study.string_wildcard;

public class PatternSyntaxException extends java.util.regex.PatternSyntaxException {
    /**
     * Constructs a new instance of this class.
     *
     * @param desc  A description of the error
     * @param regex The erroneous pattern
     * @param index The approximate index in the pattern of the error,
     *              or {@code -1} if the index is not known
     */
    public PatternSyntaxException(String desc, String regex, int index) {
        super(desc, regex, index);
    }
}

package com.tanglingtreats.templates;

import com.tanglingtreats.Formatting;

import java.util.Arrays;
import java.util.Objects;

public class Template {
    public enum Type {
        NONE("No template"),
        KEYMINT("Keymint");

        private final String label;

        public static final String[] STRINGS = Arrays.stream(Type.values())
                .map(Enum::toString)
                .toList()
                .toArray(new String[0]);


        Type(String label) {
            this.label = label;
        }

        public static Type valueOfLabel(String label) {
            for (Type t: values()) {
                if (Objects.equals(t.label, label)) {
                    return t;
                }
            }
            return Type.NONE;
        }

        @Override
        public String toString() {
            return this.label;
        }
    }

    private Type templateType = Type.NONE;

    public Type getTemplateType() {
        return templateType;
    }

    public String encode(String input) {
        String result = "12340987";

        return result;
    }

    public String decode(String input) {
        StringBuilder sb = new StringBuilder();

        sb.append("81");
        sb.append(Formatting.NEWLINE);

        sb.append(Formatting.TAB);
        sb.append("82");
        sb.append(Formatting.NEWLINE);

        sb.append(Formatting.TAB);
        sb.append(Formatting.TAB);
        sb.append("83");
        sb.append(Formatting.NEWLINE);

        return sb.toString();
    }

}

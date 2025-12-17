package com.tanglingtreats.templates;

import com.tanglingtreats.Formatting;
import com.tanglingtreats.Util;

import java.util.Arrays;
import java.util.Objects;

public class Template {
    public static final String ERR_INVALID_INPUT = "The input is not a valid CBOR.";

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

    protected Type templateType = Type.NONE;

    public Template() {

    }


    public Type getTemplateType() {
        return templateType;
    }

}

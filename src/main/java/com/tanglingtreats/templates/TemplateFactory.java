package com.tanglingtreats.templates;

public class TemplateFactory {
    public static Template getTemplate(String type) {
        switch(Template.Type.valueOfLabel(type)) {
            default -> {
                return new Template();
            }
        }
    }
}

package com.yeet42.firstpass.gui;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

public final class FieldMethods {
    /**
     * Empty private constructor to make sure this class won't be instantiated.
     */
    private FieldMethods() {
    }

    /**
     * Generates a JFXTextField.
     *
     * @param label      name of the JFXTextField
     * @param fieldWidth width of the JFXTextField
     * @return the generated JFXTextField
     */
    static JFXTextField generateJfxTextField(final String label, final int fieldWidth) {
        JFXTextField field = new JFXTextField();
        field.setLabelFloat(true);
        field.setPromptText(label);
        field.setMinWidth(fieldWidth);
        field.setMaxWidth(fieldWidth);
        return field;
    }

    /**
     * Generates a JFXPasswordField.
     *
     * @param label      name of the JFXPasswordField
     * @param fieldWidth width of the JFXPasswordField
     * @return the generated JFXPasswordField
     */
    static JFXPasswordField generateJfxPasswordField(
            final String label, final int fieldWidth) {
        final JFXPasswordField pwBox = new JFXPasswordField();
        pwBox.setLabelFloat(true);
        pwBox.setPromptText(label);
        pwBox.setMinWidth(fieldWidth);
        pwBox.setMaxWidth(fieldWidth);
        return pwBox;
    }
}

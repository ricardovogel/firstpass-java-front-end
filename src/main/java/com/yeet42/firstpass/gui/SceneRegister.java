package com.yeet42.firstpass.gui;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.validation.RequiredFieldValidator;
import com.jfoenix.validation.base.ValidatorBase;
import com.yeet42.firstpass.guiinteraction.Login;
import com.yeet42.firstpass.guiinteraction.PasswordChecking;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputControl;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class SceneRegister extends ProgramScene {
    SceneRegister() {
        super(Scenes.REGISTRATION);
    }

    @Override
    public void generateScene() {
        final VBox registrationForm = new VBox(30);
        registrationForm.setAlignment(Pos.CENTER);

        // Title
        final Text sceneTitle = new Text("Register");
        sceneTitle.setId("title-text");
        final int fieldWidth = 250;

        // Password1
        final JFXPasswordField passwordField = FieldMethods
                .generateJfxPasswordField("Password", fieldWidth);
        final RequiredFieldValidator passwordEmptyValidator = new RequiredFieldValidator();
        passwordEmptyValidator.setMessage("Please enter a password.");

        final PasswordLengthRule passwordLengthRuleValidator = new PasswordLengthRule();
        passwordLengthRuleValidator.setMessage(
                "Your password must be between 6 and 72 characters."
        );
        final PasswordCapitalRule passwordCapitalRuleValidator = new PasswordCapitalRule();
        passwordCapitalRuleValidator.setMessage("Your password must contain a capital letter.");
        final PasswordLowercaseRule passwordLowercaseRuleValidator = new PasswordLowercaseRule();
        passwordLowercaseRuleValidator.setMessage("Your password must contain a lowercase letter.");
        final PasswordNumberRule passwordNumberRuleValidator = new PasswordNumberRule();
        passwordNumberRuleValidator.setMessage("Your password must contain a number.");
        final PasswordSpecialCharacterRule passwordSpecialCharacterRuleValidator =
                new PasswordSpecialCharacterRule();
        passwordSpecialCharacterRuleValidator.setMessage(
                "You password must contain a special character");


        passwordField.getValidators().addAll(
                passwordEmptyValidator,
                passwordLengthRuleValidator,
                passwordCapitalRuleValidator,
                passwordNumberRuleValidator,
                passwordSpecialCharacterRuleValidator
        );
        passwordField.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) {
                passwordField.validate();
            }
        });

        // Password2
        final JFXPasswordField password2Field = FieldMethods
                .generateJfxPasswordField("Password", fieldWidth);
        final RequiredFieldValidator password2Validator = new RequiredFieldValidator();
        password2Validator.setMessage("Please enter your password again.");
        final SecondPasswordValidator passwordMatchValidator =
                new SecondPasswordValidator(passwordField);
        passwordMatchValidator.setMessage("Please make sure your passwords match up.");
        password2Field.getValidators().addAll(password2Validator, passwordMatchValidator);
        password2Field.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) {
                password2Field.validate();
            }
        });

        // Button to return to the login page in case the user want to
        final Button returnButton = new Button("Return");
        final GridPane buttonGrid = new GridPane();
        returnButton.setOnAction(click ->
                ProgramManager.openScene(Scenes.LOGIN)
        );
        buttonGrid.setHgap(10);
        buttonGrid.add(returnButton, 0, 0);
        returnButton.setId("blue-button");

        // Register button
        final Button registerButton = new Button("Register");
        registerButton.setOnAction(event -> register(
                passwordField,
                password2Field
        ));
        registerButton.setId("blue-button");

        // Align button to right
        final HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(returnButton);
        hbBtn.getChildren().add(registerButton);
        hbBtn.setMinWidth(fieldWidth);
        hbBtn.setMaxWidth(fieldWidth);

        buttonGrid.setMinWidth(fieldWidth);
        buttonGrid.setMaxWidth(fieldWidth);

        registrationForm.getChildren().addAll(
                sceneTitle,
                passwordField,
                password2Field,
                hbBtn
        );

        this.setPrimaryParent(registrationForm);
    }

    @Override
    public void setSceneTitle() {
        this.setSceneTitle("Registration");
    }


    /**
     * Registers a user. If something is wrong, change the mistakeText and return.
     *
     * @param passwordF  first password field
     * @param password2F second password field
     */
    private void register(final JFXPasswordField passwordF,
                          final JFXPasswordField password2F) {
        if (!passwordF.validate() | !password2F.validate()) {
            return;
        }

        final String password = passwordF.getText();

        Login.register(password);
        ProgramManager.openScene(Scenes.REGISTRATION_SECOND_FACTOR);
    }

    private class SecondPasswordValidator extends ValidatorBase {
        JFXPasswordField firstPasswordField;

        SecondPasswordValidator(final JFXPasswordField firstPasswordField) {
            super();
            this.firstPasswordField = firstPasswordField;
        }

        @Override
        protected void eval() {
            TextInputControl textField = (TextInputControl) srcControl.get();
            if (!textField.getText().equals(firstPasswordField.getText())) {
                hasErrors.set(true);
            } else {
                hasErrors.set(false);
            }
        }
    }

    private class PasswordLengthRule extends ValidatorBase {
        @Override
        protected void eval() {
            TextInputControl textField = (TextInputControl) srcControl.get();
            if (PasswordChecking.lengthRule(textField.getText())) {
                hasErrors.set(false);
            } else {
                hasErrors.set(true);
            }
        }
    }

    private class PasswordCapitalRule extends ValidatorBase {
        @Override
        protected void eval() {
            TextInputControl textField = (TextInputControl) srcControl.get();
            if (PasswordChecking.capitalRule(textField.getText())) {
                hasErrors.set(false);
            } else {
                hasErrors.set(true);
            }
        }
    }

    private class PasswordLowercaseRule extends ValidatorBase {
        @Override
        protected void eval() {
            TextInputControl textField = (TextInputControl) srcControl.get();
            if (PasswordChecking.lowercaseRule(textField.getText())) {
                hasErrors.set(false);
            } else {
                hasErrors.set(true);
            }
        }
    }

    private class PasswordNumberRule extends ValidatorBase {
        @Override
        protected void eval() {
            TextInputControl textField = (TextInputControl) srcControl.get();
            if (PasswordChecking.numberRule(textField.getText())) {
                hasErrors.set(false);
            } else {
                hasErrors.set(true);
            }
        }
    }

    private class PasswordSpecialCharacterRule extends ValidatorBase {
        @Override
        protected void eval() {
            TextInputControl textField = (TextInputControl) srcControl.get();
            if (PasswordChecking.specialCharacterRule(textField.getText())) {
                hasErrors.set(false);
            } else {
                hasErrors.set(true);
            }
        }
    }

    /**
     * Validator to check if an email address is a correct email address.
     * Uses the Java regex from emailregex.com.
     */
    private class CorrectEmailValidator extends ValidatorBase {
        @Override
        protected void eval() {
            TextInputControl textField = (TextInputControl) srcControl.get();
            if (textField.getText().matches(
                    "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?"
                            + ":[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\"
                            + "[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*"
                            + "[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-"
                            + "4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-"
                            + "9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\"
                            + "x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])"
            )) {
                hasErrors.set(false);
            } else {
                hasErrors.set(true);
            }
        }
    }
}

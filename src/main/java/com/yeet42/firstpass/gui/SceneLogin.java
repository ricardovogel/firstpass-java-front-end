package com.yeet42.firstpass.gui;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import com.yeet42.firstpass.guiinteraction.Login;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class SceneLogin extends ProgramScene {
    SceneLogin() {
        super(Scenes.LOGIN);
    }

    @Override
    protected void generateScene() {
        final VBox loginForm = new VBox(30);
        loginForm.setAlignment(Pos.CENTER);

        // Buffer
        final Text bufferText = new Text();

        // Title
        final Text sceneTitle = new Text("Welcome to FirstPass");
        sceneTitle.setId("title-text");

        final int fieldWidth = 200;
        // Username
        final JFXTextField userTextField =
                FieldMethods.generateJfxTextField("Username", fieldWidth);
        RequiredFieldValidator usernameValidator = new RequiredFieldValidator();
        usernameValidator.setMessage("Please enter a username.");
        userTextField.getValidators().add(usernameValidator);
        userTextField.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) {
                userTextField.validate();
            }
        });

        // Password
        final JFXPasswordField passwordField =
                FieldMethods.generateJfxPasswordField("Password", fieldWidth);
        RequiredFieldValidator passwordValidator = new RequiredFieldValidator();
        passwordValidator.setMessage("Please enter a password.");
        passwordField.getValidators().add(passwordValidator);
        passwordField.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) {
                passwordField.validate();
            }
        });

        // Failed message
        final Text failedLogin = new Text();
        failedLogin.setFill(Color.FIREBRICK);
        failedLogin.setText("Your username or password is incorrect.");
        failedLogin.setVisible(false);

        // Sign in button
        final Button signInButton = new Button("Sign in");
        final GridPane buttonGrid = new GridPane();
        buttonGrid.setAlignment(Pos.TOP_RIGHT);
        buttonGrid.setHgap(10);
        buttonGrid.add(signInButton, 0, 0);
        signInButton.setOnAction(event -> {
            signIn(userTextField, passwordField, failedLogin);
            // clear password field after user login to ensure security
            passwordField.clear();
        });

        signInButton.setId("blue-button");

        // Register
        final Button registerButton = new Button("Register");
        buttonGrid.add(registerButton, 1, 0);
        registerButton.setOnAction(event ->
                ProgramManager.openScene(Scenes.REGISTRATION));
        registerButton.setId("blue-button");

        buttonGrid.setMinWidth(fieldWidth);
        buttonGrid.setMaxWidth(fieldWidth);


        loginForm.getChildren().addAll(
                bufferText,
                sceneTitle,
                userTextField,
                passwordField,
                buttonGrid,
                failedLogin
        );
        this.setPrimaryParent(loginForm);

    }

    @Override
    protected void setSceneTitle() {
        this.setSceneTitle("Log In");
    }

    private void signIn(final JFXTextField usernameField,
                        final JFXPasswordField passwordField, final Text failedLogin) {

        if (!usernameField.validate() | !passwordField.validate()) {
            return;
        }
        if (Login.validatePassword(usernameField.getText(),
                passwordField.getText())) {
            ProgramManager.openScene(Scenes.SECOND_FACTOR);
        } else {
            failedLogin.setVisible(true);
        }
    }

}

package controllers;

import java.util.Date;

import jobs.MailForgotPasswordJob;
import jobs.MailNewUserConfirmationJob;
import jobs.MailUnlockAccountJob;
import models.User;
import play.Logger;
import play.mvc.Controller;


public class Enrolling extends Controller {


    public static void register() {

        render();
    }


    public static void doRegister(String email, String password, String retypePassword) {

        validation.email(email).message("enrolling.validation.emailIsRequired");
        validation.minSize(password, 8).message("enrolling.validationPasswordIsEmpty");
        validation.isTrue(password.equals(retypePassword)).message("enrolling.validation.passwordsDoNotMatch");

        if (validation.hasErrors()) {
            params.flash();
            validation.keep();
            register();
        }

        User user = new User();
        user.email = email;
        user.setPassword(password);
        user.createdDate = new Date();
        user.save();

        Logger.info("User saved: " + user + " with id: " + user.id);

        User savedUser = User.findById(user.id);

        Logger.info("User retrieved: " + savedUser + " with id: " + savedUser.id);

        new MailNewUserConfirmationJob(savedUser.id).afterRequest();

        render(user);
    }


    public static void confirmRegistration(String uuid) {

        Logger.info("User confirmation request received fro UUID %s", uuid);

        if (User.count("byUuidAndStage", uuid, User.CREATED) < 1) {
            confirmationFailed();
        }

        User user = User.find("byUuid", uuid).first();

        Logger.info("Found a user for confirmation: " + user.email);

        user.stage = User.CONFIRMED;

        user.save();

        render(user);
    }


    public static void confirmationFailed() {

        render();
    }


    public static void registerStep1(String email) {

        render(email);
    }


    public static void forgotPassword() {

        render();
    }


    public static void doForgotPassword(String email) {

        validation.email(email).message("enrolling.validation.emailIsRequired");

        if (validation.hasErrors()) {
            params.flash();
            validation.keep();
            forgotPassword();
        }

        new MailForgotPasswordJob(email).afterRequest();

        render(email);
    }


    public static void passwordResetFailed() {

        render();
    }


    public static void resetPassword(String uuid) {

        Logger.info("User password reset request received for UUID %s", uuid);

        if (User.count("byUuid", uuid) < 1) {
            passwordResetFailed();
        }

        User user = User.find("byUuid", uuid).first();

        Logger.info("Found a user for password reset: %s", user.email);

        render(user);

    }

    public static void doResetPassword(String email, String password, String retypePassword) {

        validation.minSize(password, 8).message("enrolling.validationPasswordIsEmpty");
        validation.isTrue(password.equals(retypePassword)).message("enrolling.validation.passwordsDoNotMatch");

        User user = User.find("byEmail", email).first();

        Logger.info("Found a user for password reset: %s", user.email);

        if (validation.hasErrors()) {
            params.flash();
            validation.keep();
            resetPassword(user.uuid);
        }

        user.setPassword(password);

        user.save();

        render(user);
    }


    public static void unlockAccount() {

        render();
    }


    public static void doUnlockAccount(String email) {

        validation.email(email).message("enrolling.validation.emailIsRequired");

        if (validation.hasErrors()) {
            params.flash();
            validation.keep();
            unlockAccount();
        }

        new MailUnlockAccountJob(email).afterRequest();

        render(email);
    }


    public static void performUnlockFailed() {

        render();
    }


    public static void performUnlock(String uuid) {

        Logger.info("User account unlock request received for UUID %s", uuid);

        if (User.count("byUuidAndLocked", uuid, true) < 1) {
            performUnlockFailed();
        }

        User user = User.find("byUuid", uuid).first();
        user.locked = false;
        user.failedLoginAttempts = 0;
        user.save();

        Logger.info("Found a user for account unlock: %s", user.email);

        render(user);
    }
}

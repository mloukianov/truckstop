package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

@With(Secure.class)
public class Application extends Controller {

    public static void index() {
        render();
    }


    public static void forgotPassword() {

        render();
    }


    public static void unlockAccount() {

        render();
    }


    public static void dashboard() {

        String email = Security.connected();
        User user = User.find("byEmail", email).first();

        render(user);
    }
}
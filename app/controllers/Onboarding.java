package controllers;

import play.mvc.Controller;
import play.mvc.With;

@With(Secure.class)
public class Onboarding extends Controller {

    /**
     * Display start screen for onboarding the user
     * @param email
     */
    public static void startOnboarding(String email) {

        render(email);
    }


    /**
     * Display step 1 for onboarding the user and collect the data
     */
    public static void step1() {

        String username = Security.connected();

        render(username);
    }


    /**
     * Save collected
     */
    public static void doStep1() {


        step2();
    }


    public static void step2() {

        String username = Security.connected();

        render(username);
    }


    public static void doStep2() {

        step3();
    }


    public static void step3() {

        String username = Security.connected();

        render(username);
    }


    public static void doStep3() {

        enrollmentCompleted();
    }


    public static void enrollmentCompleted() {

        String username = Security.connected();

        render(username);
    }
}

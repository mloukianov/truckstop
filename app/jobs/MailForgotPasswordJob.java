package jobs;

import notifiers.Mails;
import play.Logger;
import play.jobs.Job;
import models.User;

public class MailForgotPasswordJob extends Job {

    private String email;

    public MailForgotPasswordJob(String email) {
        super();
        this.email = email;
    }

    /**
     * Here you do the job
     *
     * @throws Exception if problems occurred
     */
    @Override
    public void doJob() throws Exception {
        super.doJob();

        if (User.count("byEmail", this.email) < 1) {
            Logger.info("User with email %s can not be found", email);
            return;
        }


        User user = User.find("byEmail", email).first();

        Logger.info("Sending forgot password emai to emaio %s", user.email);

        Mails.forgotPassword(user);
    }
}

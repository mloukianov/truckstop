package jobs;

import models.User;
import notifiers.Mails;
import play.Logger;
import play.jobs.Job;

public class MailNewUserConfirmationJob extends Job {

    private Long id;

    public MailNewUserConfirmationJob(Long id) {

        Logger.info("New instance of a job started with user id: " + id);

        this.id = id;
    }


    /**
     * Here you do the job
     *
     * @throws Exception if problems occurred
     */
    @Override
    public void doJob() throws Exception {

        User user = User.findById(this.id);

        Logger.info("User to confirm: " + user);

        Mails.confirmation(user);
    }
}

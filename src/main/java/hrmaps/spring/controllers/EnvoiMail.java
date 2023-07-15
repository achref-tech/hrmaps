package hrmaps.spring.controllers;

/*import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import hrmaps.spring.entites.Mail;
import hrmaps.spring.servicesImp.MailServiceImpl;

@RestController
public class EnvoiMail {

    private final MailServiceImpl emailService;

    @Autowired
    public EnvoiMail(MailServiceImpl emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send-email")
    public void sendEmail(@RequestBody Mail emailRequest) {
        String to = emailRequest.getTo();
        String subject = emailRequest.getSubject();
        String text = emailRequest.getText();

        emailService.sendEmail(to, subject, text);
    }
}

/*import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hrmaps.spring.entites.Mail;
import hrmaps.spring.services.MailService;




@Component
public class EnvoiMail {
	
	
	@Autowired
	private MailService mailService;
	
	public void EnvoiMail() {
		Mail mail = new Mail();
		mail.setMailFrom("benyoussefachref212@gmail.com");
		mail.setMailTo("achref.benyoussef1@esprit.tn");
		mail.setMailSubject("Spring Boot - Email demo");
		mail.setMailContent("Just testing");
		mailService.sendEmail(mail);
	}

}

*/
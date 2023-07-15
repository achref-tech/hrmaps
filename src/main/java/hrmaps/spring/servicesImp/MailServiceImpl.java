package hrmaps.spring.servicesImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl {
    
    @Autowired
    private JavaMailSender mailSender;
    
    public void sendAcceptanceEmail(String recipientEmail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipientEmail);
        message.setSubject("Votre demande a été acceptée");
        message.setText("Cher utilisateur, votre demande a été acceptée. Félicitations !");
        
        mailSender.send(message);
    }
}



/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import hrmaps.spring.services.MailService;

@Service
public class MailServiceImpl implements MailService {

    private final JavaMailSender javaMailSender;

    @Autowired
    public MailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }
    @Override
    public void sendEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        javaMailSender.send(message);
    }
}


/*import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import hrmaps.spring.entites.Mail;
import hrmaps.spring.repositories.MailRepository;
import hrmaps.spring.services.MailService;




@Service
public class MailServiceImpl implements MailService
{
	@Autowired
	private JavaMailSender javaMailSender;
    @Autowired
    private MailRepository repo;
	@Override
	public long sendEmail(Mail mail)  throws MailException
	{
		System.out.println("send email");
		//MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		SimpleMailMessage msg = new SimpleMailMessage();
		 msg.setTo(mail.getDestinataire());
		 msg.setFrom("achref.benyoussef1@esprit.tn");
		 msg.setSubject(mail.getObjet());
		 msg.setText(mail.getMessage());
		 javaMailSender.send(msg);
		 return repo.save(mail).getId();
	}		 
		/*try {
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setSubject(mail.getMailSubject());
			mimeMessageHelper.setFrom(new InternetAddress(mail.getMailFrom()));
			mimeMessageHelper.setTo(mail.getMailTo());
			mimeMessageHelper.setText(mail.getMailContent());
			javaMailSender.send(mimeMessageHelper.getMimeMessage());
		} 
		catch (MessagingException e) {
			e.printStackTrace();
		}
	}*/



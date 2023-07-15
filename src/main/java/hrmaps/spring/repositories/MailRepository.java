package hrmaps.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import hrmaps.spring.entites.Mail;


public interface MailRepository extends JpaRepository<Mail,Long> {
	

}

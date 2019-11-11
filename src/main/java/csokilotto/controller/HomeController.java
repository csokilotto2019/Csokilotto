package csokilotto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import csokilotto.dbr.Chocolate;
import csokilotto.dbr.Message;
import csokilotto.entity.User;
import csokilotto.entity.pa_Chocolate;
import csokilotto.repository.ChocolateRepository;
import csokilotto.repository.MessageRepository;
import csokilotto.service.ChocolateService;
import csokilotto.service.EmailService;
import csokilotto.service.MessageService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.h2.util.New;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class HomeController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private EmailService emailService;
	private MessageService messageservice;
	private ChocolateService chocosercive;
	
	/**
	 * beállítja a szervízt, hogy az használható legyen
	 * @param emailService
	 */
	@Autowired
	public void setEmailService(EmailService emailService) {
		this.emailService = emailService;
	}

	@Autowired
	public void setMessageservice(MessageService messageservice) {
		this.messageservice = messageservice;
	}

	@Autowired
	public void setChocosercive(ChocolateService chocosercive) {
		this.chocosercive = chocosercive;
	}
	
	/**
	 * Ha csak az alap címet írjuk be akkor ez az ág fut meg.
	 * @param model
	 * @return
	 */
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("pageTitle", "Minden napra egy csoki!");
		model.addAttribute("user", new User());
		return "index";
	}
	
	/**
	 * A /win-re való post kérést követően ez az ég fog megfutni.
	 * Itt történik a nyereménycsoki előkeresése és az üzenet küldése.
	 * @param user a frontendről visszakapot objektum.
	 * @return a sikeres lefutást követően az oldal ahová átszertnénk irányítani. 
	 * templates/ok.html
	 */
	@PostMapping("/win")
	public String greetingSubmit(@ModelAttribute User user, Model model) {
		
		log.info("Nyertünk");
		Random rand = new Random();

		int rand_int1 = rand.nextInt(6) + 1;

		Chocolate chocolate = chocosercive.findById((long) rand_int1);
		log.info("Csoki megvan");
		log.info(String.valueOf(rand_int1));
		log.info(chocolate.getName());
		messageservice.saveMess(new Message(user.getEmail(),chocolate));

		emailService.sendMessage(user.getEmail(),chocolate);
		log.debug(user.getEmail());
		model.addAttribute("pa_Chocolate", new pa_Chocolate(chocolate.getName(),chocolate.getTaste(),chocolate.getTypetoString(),chocolate.getWeight(),chocolate.getManufacturer(),chocolate.getPicture()));
		
		return "ok";
	}

}
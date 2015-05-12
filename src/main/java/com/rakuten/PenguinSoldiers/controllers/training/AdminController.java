package com.rakuten.PenguinSoldiers.controllers.training;

import javax.persistence.Lob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.rakuten.PenguinSoldiers.models.account.Account;
import com.rakuten.PenguinSoldiers.models.account.AccountRepository;
import com.rakuten.PenguinSoldiers.models.account.Admin;
import com.rakuten.PenguinSoldiers.models.account.AdminRepository;
import com.rakuten.PenguinSoldiers.models.account.UserService;
import com.rakuten.PenguinSoldiers.models.training.Training;
import com.rakuten.PenguinSoldiers.models.training.TrainingService;
import com.rakuten.PenguinSoldiers.models.training.Goal;
import com.rakuten.PenguinSoldiers.models.training.GoalService;
import com.rakuten.PenguinSoldiers.models.training.Outline;
import com.rakuten.PenguinSoldiers.models.training.OutlineService;
import com.rakuten.PenguinSoldiers.models.training.Premise;
import com.rakuten.PenguinSoldiers.models.training.PremiseService;
import com.rakuten.PenguinSoldiers.models.training.Target;
import com.rakuten.PenguinSoldiers.models.training.TargetService;
import com.rakuten.PenguinSoldiers.models.training.Venue;
import com.rakuten.PenguinSoldiers.models.training.VenueService;

import com.rakuten.PenguinSoldiers.util.DateTimeUtil;

import java.lang.String;

@Controller
public class AdminController {
	@Autowired
	private TrainingService trainingService;
	@Autowired
	private GoalService goalService;
	@Autowired
	private OutlineService outlineService;
	@Autowired
	private PremiseService premiseService;
	@Autowired
	private TargetService targetService;
	@Autowired
	private VenueService venueService;
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private UserService userService;

	@RequestMapping(value = "admin", method = RequestMethod.GET)
	public String admin() {
		return "admin/adminMain";
	}

	@RequestMapping(value = "admin/addTrainingPrograms", method = RequestMethod.GET)
	public String addTrainingPrograms() {
		return "admin/addTrainingPrograms";
	}

	@Lob
	private String overview;

	@RequestMapping(value = "admin/addAction", method = RequestMethod.GET)
	/*
	 * public String addAction(@Valid @ModelAttribute Training Training) {
	 * String Name = Training.getName(); Training tr = new Training(Name);
	 * //tr.setOverview(overview); trainingService.save(tr); return
	 * "home/homeSignedIn"; }
	 */
	public String addAction(@RequestParam("name") String Name,
			@RequestParam("overview") String overview,
			@RequestParam("goal") String goal,
			@RequestParam("date") String date,
			@RequestParam("target") String target,
			@RequestParam("participantNum") int participantNum,
			@RequestParam("duedate") String duedate,
			@RequestParam("venue") String venue,
			@RequestParam("outline") String outline,
			@RequestParam("premise") String premise, ModelMap model)
	// public String addAction(Principal principal, @RequestParam("name") String
	// Name, @RequestParam("overview") String overview, @RequestParam("goal")
	// String goal, @RequestParam("date") String date, @RequestParam("target")
	// String target, @RequestParam("participantNum") int participantNum,
	// @RequestParam("duedate") String duedate, @RequestParam("venue") String
	// venue, ModelMap model)
	{
		// create new training program item
		Training tr = new Training(Name);
		tr.setOverview(overview);
		tr.setMax_participants(participantNum);
		UserDetails userDetails = (UserDetails) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();

		Account user = accountRepository.findByEmail(userDetails.getUsername());
		tr.setUser(user);
		trainingService.save(tr);
		Long training_id = tr.getId();

		// add training goal
		Goal gl = new Goal(goal);
		gl.setTraining_id(training_id);
		goalService.save(gl);

		// add training outline
		Outline ol = new Outline(outline);
		ol.setTraining_id(training_id);
		outlineService.save(ol);

		// add training premise
		Premise pr = new Premise(premise);
		pr.setTraining_id(training_id);
		premiseService.save(pr);

		// add training target people
		Target ta = new Target(target);
		ta.setTraining_id(training_id);
		targetService.save(ta);

		// add training venue info
		Venue ve = new Venue(venue);
		ve.setTraining_id(training_id);
		venueService.save(ve);

		return "home/homeSignedIn";
	}
	

	@RequestMapping(value = "admin/addAdmin", method = RequestMethod.GET)
	public String addAdmin(@RequestParam("newAdminId") String newAdminId) {

		UserDetails userDetails = (UserDetails) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();

		Account a = accountRepository.findByUsername(userDetails.getUsername());
		if (adminRepository.isAdmin(a.getId())) {
			Account newAdmin = accountRepository.findById(new Long(newAdminId));
			Admin admin = new Admin();
			admin.setUserId(newAdmin.getId());
			admin.setAddedBy(a.getId());
			admin.setAddedOn(DateTimeUtil.getNow());

			adminRepository.addAdmin(admin);
		}

		return null;
	}
}
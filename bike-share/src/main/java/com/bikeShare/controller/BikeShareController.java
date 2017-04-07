package com.bikeShare.controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bikeShare.model.Bikes;
import com.bikeShare.model.SharesBooks;
import com.bikeShare.model.User;
import com.bikeShare.model.UserProfile;
import com.bikeShare.service.BikeService;
import com.bikeShare.service.BookService;
import com.bikeShare.service.DashboardService;
import com.bikeShare.service.HistoryService;
import com.bikeShare.service.SharesBooksService;
import com.bikeShare.service.UserProfileService;
import com.bikeShare.service.UserService;



@Controller
@RequestMapping("/")
@SessionAttributes("roles")
public class BikeShareController {
	
	
	@Autowired
	SharesBooksService shbService;
	
	@Autowired
	BikeService bikeService;

	@Autowired
	UserService userService;
	
	@Autowired
	UserProfileService userProfileService;
	
	@Autowired
	MessageSource messageSource;

	@Autowired
	PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;
	
	@Autowired
	AuthenticationTrustResolver authenticationTrustResolver;
	
	/*** ###
	 * 
	 *  Nav Bar pages
	 */
	/**
	 * This method will show index page.
	 */
	@RequestMapping(value = { "/index" }, method = RequestMethod.GET)
	public String index() {

		return "index";
	}
	
	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String home(ModelMap model) {
		User user=userService.findBySSO(getPrincipal());
		
		DashboardService newcreditobj = new DashboardService();
		Integer creditearned = newcreditobj.fetchUserCredits(user.id);
		Integer bikesrided = newcreditobj.fetchBikesDetails(user.id,"c");
		Integer bikeshared = newcreditobj.fetchBikesDetails(user.id,"a");
		Integer bikebooked = newcreditobj.fetchBikesDetails(user.id,"b");
		model.addAttribute("bikeshared", bikeshared );
		model.addAttribute("bikebooked", bikebooked );
		model.addAttribute("bikesrided", bikesrided);
		model.addAttribute("creditearned", creditearned);
		model.addAttribute("loggedinuser",user.getFirstName());
		return "home";
	}
	
	@RequestMapping(value = { "/share" }, method = RequestMethod.GET)
	public String share(ModelMap model) {

		User user=userService.findBySSO(getPrincipal());
		List<Bikes> listbikes = bikeService.findByowner_id(user.id);
		model.addAttribute("bikes", listbikes);
		return "share";
	}
	
	@RequestMapping(value = { "/book" }, method = RequestMethod.GET)
	public String book(ModelMap model) {
		User user=userService.findBySSO(getPrincipal());
		BookService book = new BookService();
		BookService book2 = new BookService();
		List<BookService> currentbooked = book.getcurrentBookingsById(user.id);
		List<BookService> bookablebikelist = book2.getBookBikeList(user.id);
		model.addAttribute("currentbooked", currentbooked);
		model.addAttribute("bookablebikes", bookablebikelist);
		return "book";
	}
	
	@RequestMapping(value = { "/history" }, method = RequestMethod.GET)
	public String history(ModelMap model) {
		User user=userService.findBySSO(getPrincipal());
		HistoryService history = new HistoryService();
		List<HistoryService> historylist = history.viewBookHistory(user.id);
		model.addAttribute("historylist", historylist);
		return "history";
	}
	
	
	@RequestMapping(value = { "/myprofile" }, method = RequestMethod.GET)
	public String myprofile(ModelMap model) {
		User user=userService.findBySSO(getPrincipal());
		model.addAttribute("user",user);
		return "myprofile/myprofile";
	}
	
	@RequestMapping(value = { "/myprofile/edit-{userid}" }, method = RequestMethod.GET)
	public String myprofileedit(ModelMap model) {
		User user=userService.findBySSO(getPrincipal());
		model.addAttribute("user",user);
		model.addAttribute("status",false);
		return "myprofile/myprofile-edit";
	}
	
	@RequestMapping(value = { "/myprofile/edit-{userid}" }, method = RequestMethod.POST)
	public String myprofileupdate(@Valid User user, BindingResult result,ModelMap model) {
		
		userService.updateUser(user);
		model.addAttribute("success", "Updated successfully");
		model.addAttribute("status",true);
		return "myprofile/myprofile";
	}
	
	@RequestMapping(value = { "/aboutus" }, method = RequestMethod.GET)
	public String aboutus() {
		
		return "aboutus";
	}
	
	@RequestMapping(value = { "/forgot" }, method = RequestMethod.GET)
	public String forgotpass() {

		return "forgotpass";
	}

	
	/*** ###
	 * 
	 *  Share Bikes pages and ADD BIKES request methods
	 */
	
	
	@RequestMapping(value = { "/sharebike/addbike" }, method = RequestMethod.GET)
	public String share_addbike(ModelMap model) {
		Bikes bikes = new Bikes();
		model.addAttribute("bikes", bikes);
		model.addAttribute("loggedinuser", getPrincipal());
		return "sharebike/addbike";
	}
	
	/**
	 * This method will be called on form submission, handling POST request for
	 * saving user in database. It also validates the user input
	 */
	@RequestMapping(value = { "/sharebike/addbike" }, method = RequestMethod.POST)
	public String saveBike(@Valid Bikes bikes, BindingResult result,
			ModelMap model) {
		User user=userService.findBySSO(getPrincipal());
		bikes.setOwner_id(user.id);
		bikes.setSharestatus("off");
		bikes.setDeletion_status("no");
		bikeService.saveBikes(bikes);

		model.addAttribute("success", "Bike added Successfully");
		//return "success";
		return "/sharebike/addbikesuccess";
	}
	
	
	/*** ###
	 * 
	 *  Share Bikes - Start,Stop,Delete GET request methods
	*/
	
	@RequestMapping(value = { "/sharebike/start-{bikeid}" }, method = RequestMethod.GET)
	public String startshare(@PathVariable Integer bikeid) {
		bikeService.updateBikeShareStart(bikeid,"on");
		return "redirect:/share";
	}
	
	@RequestMapping(value = { "/sharebike/stop-{bikeid}" }, method = RequestMethod.GET)
	public String stopshare(@PathVariable Integer bikeid) {
		bikeService.updateBikeShareStart(bikeid,"off");
		return "redirect:/share";
	}
	
	
	@RequestMapping(value = { "/sharebike/delete-{bikeid}" }, method = RequestMethod.GET)
	public String sharedelete(@PathVariable Integer bikeid) {
		bikeService.deleteBike(bikeid);
		return "redirect:/share";
	}
	
	
	/*** ###
	 * 
	 *  Share Bikes - Add,Delete Sharable Date to Bikes
	*/
	
	@RequestMapping(value = { "/sharebike/bike-{bikeid}/sharedate" }, method = RequestMethod.GET)
	public String getSharedetailspage(@PathVariable Integer bikeid, ModelMap model) {
		Bikes bikedetail = bikeService.findById(bikeid);
		List<SharesBooks> shareddates = shbService.getSharedatesbyID(bikeid);
		
		model.addAttribute("bikedetail",bikedetail);
		model.addAttribute("shareddates",shareddates);
		model.addAttribute("bikeid", bikeid);
		return "/sharebike/sharedate";
	}
	
	@RequestMapping(value = { "/sharebike/bike-{bikeid}/sharedate/add" }, method = RequestMethod.GET)
	public String initSharedate(@PathVariable Integer bikeid, ModelMap model) {

		SharesBooks shbs = new SharesBooks();
		model.addAttribute("shbs", shbs);
		return "/sharebike/add-date";

	}
	
	@RequestMapping(value = { "/sharebike/bike-{bikeid}/sharedate/add" }, method = RequestMethod.POST)
	public String addSharedate(@Valid SharesBooks shbs, BindingResult result, ModelMap model,@PathVariable Integer bikeid) throws ParseException {
		shbs.setBike_id(bikeid);
		shbs.setCreditstatus("NotCredited");
		shbs.setBookingstatus("NotBooked");
		shbs.setBooked_by(0);
		SimpleDateFormat dfmt = new SimpleDateFormat("yyyy-MM-dd");
        Date dateformatted = dfmt.parse("1900-01-01");
        //Date dt = java.sql.Date.valueOf(new String(dateformatted));
		shbs.setBooked_date(dateformatted);
		shbService.saveSharesBooks(shbs);
		
		return "redirect:/sharebike/bike-{bikeid}/sharedate";
	}
	

	@RequestMapping(value = { "/sharebike/bike-{bikeid}/sharedate/sh-{shbid}/delete" }, method = RequestMethod.GET)
	public String deleteSharedate(@PathVariable Integer bikeid, @PathVariable Integer shbid, ModelMap model) {
		shbService.deletebyShareBookId(shbid);
		return "/sharebike";
	}
	
	/*** ###
	 * 
	 *  Book Bikes pages and request methods
	*/
	@RequestMapping(value = { "/bookbike/bike-{bikeid}" }, method = RequestMethod.GET)
	public String getBookbikedetailspage(@PathVariable Integer bikeid, ModelMap model) {
		
		BookService viewslots = new BookService();
		List<BookService> availableslots = viewslots.viewDateSlots(bikeid);
		model.addAttribute("availableslots",availableslots );
		model.addAttribute("bikeid",bikeid);
		return "/bookbike/bookbike";
	}
	
	
	@RequestMapping(value = { "/bookbike/bike-{bikeid}/shb-{shbid}/confirm" }, method = RequestMethod.GET)
	public String bookbike(@PathVariable Integer bikeid, @PathVariable Integer shbid, ModelMap model) throws ParseException {
		User user=userService.findBySSO(getPrincipal());
		
		shbService.updateBookedDates(shbid,user.id); 
		model.addAttribute("rbikeid", bikeid);
		//update the column of the shares_and_bookings for the specific date to booked_by and booked_date and booking status
		return "/bookbike/bookbikesuccess";
	}
		
	@RequestMapping(value = { "/bookbike/bike-{bikeid}/ridedone-{shbid}" }, method = RequestMethod.GET)
	public String RideDone(@PathVariable Integer shbid,@PathVariable Integer bikeid, ModelMap model) throws SQLException{
		User user=userService.findBySSO(getPrincipal());
		
		BookService newupdate = new BookService();
		String status = newupdate.updateRideDone(shbid,bikeid,user.id);
		model.addAttribute("status", status);
		return "/bookbike/status";
	}
	/**
	 * This method will list all existing users.
	 */
	@RequestMapping(value = { "/list" }, method = RequestMethod.GET)
	public String listUsers(ModelMap model) {

		List<User> users = userService.findAllUsers();
		model.addAttribute("users", users);
		model.addAttribute("loggedinuser", getPrincipal());
		return "userslist";
	}

	/**
	 * This method will provide the medium to add a new user.
	 */
	@RequestMapping(value = { "/newuser" }, method = RequestMethod.GET)
	public String newUser(ModelMap model) {
		User user = new User();
		model.addAttribute("user", user);
		model.addAttribute("edit", false);
		model.addAttribute("loggedinuser", getPrincipal());
		return "registration";
	}

	/**
	 * This method will be called on form submission, handling POST request for
	 * saving user in database. It also validates the user input
	 */
	@RequestMapping(value = { "/newuser" }, method = RequestMethod.POST)
	public String saveUser(@Valid User user, BindingResult result,
			ModelMap model) {
		System.out.println(result);
		if (result.hasErrors()) {
			
			return "registration";
		}

		if(!userService.isUserSSOUnique(user.getId(), user.getSsoId())){
			FieldError ssoError =new FieldError("user","ssoId",messageSource.getMessage("non.unique.ssoId", new String[]{user.getSsoId()}, Locale.getDefault()));
		    result.addError(ssoError);
		    System.out.println("ERROR IN user sso unique");
			return "registration";
		}
		
		userService.saveUser(user);

		model.addAttribute("success", "User " + user.getFirstName() + " "+ user.getLastName() + " registered successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		//return "success";
		return "registrationsuccess";
	}


	/**
	 * This method will provide the medium to update an existing user.
	 */
	@RequestMapping(value = { "/edit-user-{ssoId}" }, method = RequestMethod.GET)
	public String editUser(@PathVariable String ssoId, ModelMap model) {
		User user = userService.findBySSO(ssoId);
		model.addAttribute("user", user);
		model.addAttribute("edit", true);
		model.addAttribute("loggedinuser", getPrincipal());
		return "registration";
	}
	
	/** 
	 * This method will be called on form submission, handling POST request for
	 * updating user in database. It also validates the user input
	 */
	@RequestMapping(value = { "/edit-user-{ssoId}" }, method = RequestMethod.POST)
	public String updateUser(@Valid User user, BindingResult result,
			ModelMap model, @PathVariable String ssoId) {

		if (result.hasErrors()) {
			return "registration";
		}

		userService.updateUser(user); 
		model.addAttribute("success", "User " + user.getFirstName() + " "+ user.getLastName() + " updated successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		return "registrationsuccess";
	}
	
	
	/**
	 * This method will delete an user by it's SSOID value.
	 */
	@RequestMapping(value = { "/delete-user-{ssoId}" }, method = RequestMethod.GET)
	public String deleteUser(@PathVariable String ssoId) {
		userService.deleteUserBySSO(ssoId);
		return "redirect:/list";
	}
	

	/**
	 * This method will provide UserProfile list to views
	 */
	@ModelAttribute("roles")
	public List<UserProfile> initializeProfiles() {
		return userProfileService.findAll();
	}
	
	
	/**
	 * This method handles Access-Denied redirect.
	 */
	@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("loggedinuser", getPrincipal());
		return "accessDenied";
	}

	/**
	 * This method handles login GET requests.
	 * If users is already logged-in and tries to goto login page again, will be redirected to list page.
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		System.out.println("reaching here..");
		if (isCurrentAuthenticationAnonymous()) {
			return "login";
	    } else {
	    	return "redirect:/home";  
	    }
	}

	/**
	 * This method handles logout requests.
	 * Toggle the handlers if you are RememberMe functionality is useless in your app.
	 */
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null){    
			//new SecurityContextLogoutHandler().logout(request, response, auth);
			persistentTokenBasedRememberMeServices.logout(request, response, auth);
			SecurityContextHolder.getContext().setAuthentication(null);
		}
		return "redirect:/login?logout";
	}

	/**
	 * This method returns the principal[user-name] of logged-in user.
	 */
	private String getPrincipal(){
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails)principal).getUsername();
			
			//System.out.println((UserDetails)principal);
		} else {
			userName = principal.toString();
		}
		return userName;
	}
	
	/**
	 * This method returns true if users is already authenticated [logged-in], else false.
	 */
	private boolean isCurrentAuthenticationAnonymous() {
	    final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    return authenticationTrustResolver.isAnonymous(authentication);
	}


}
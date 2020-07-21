package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.model.Member;
import com.app.transaction.MyTransaction;
import com.app.ws.WebServiceClient;

@Controller
@RequestMapping(value = "/")
public class HomeController {

	@Autowired
	private MyTransaction myTransaction;
	@Autowired
	private WebServiceClient webServiceClient;

	public void setWebServiceClient(WebServiceClient webServiceClient) {
		this.webServiceClient = webServiceClient;
	}

	public void setMyTransaction(MyTransaction myTransaction) {
		this.myTransaction = myTransaction;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String displaySortedMembers(Model model) {
		model.addAttribute("newMember", new Member());
		return "home";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String registerNewMember(
			@ModelAttribute("newMember") Member newMember,
			BindingResult result, Model model) {

		webServiceClient.simpleSendAndReceive();
		myTransaction.saveMember(newMember);
		model.addAttribute("member", newMember);
		return "home1";

	}
}

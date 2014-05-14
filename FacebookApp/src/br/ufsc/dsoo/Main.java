package br.ufsc.dsoo;

import facebook4j.Facebook;
import br.ufsc.dsoo.controller.Authenticate;
import br.ufsc.dsoo.view.UserInterface;

public class Main {

	public static void main (String[] args) {
		
		UserInterface ui = new UserInterface();
		Authenticate auth = new Authenticate();
		Facebook facebook = auth.FacebookAuth(ui);
		ui.showApplicationOptions(facebook);
	}
}



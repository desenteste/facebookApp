package br.ufsc.dsoo.controller;

import javax.swing.JOptionPane;

import br.ufsc.dsoo.view.UserInterface;
import facebook4j.Facebook;

public class Validate {

	Features features;
	UserInterface ui;
	
	public Validate(){
		features = new Features();
	}
	
	public void optionValidate(int option, Facebook facebook) {
	
		ui = new UserInterface();
		switch (option) {
			case 0:
				ui.showMessage("Aplicação Finalizada!");
				System.exit(0);
			case 1: 
				features.setOpenBarEventAsAttending(facebook,ui);
				break;
			case 2:
				features.postTaggingAllFriends(facebook,ui);
				break;
			case 3:
				features.groupMemberByGender(facebook,ui);
				break;
			case 4:
				ui.showHelp(facebook);
				break;
			case 5:
				ui.showAboutUs(facebook);
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção incorreta");
				ui.showApplicationOptions(facebook);
		}
		
	}

}

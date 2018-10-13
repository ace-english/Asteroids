package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class AboutCommand extends Command {

	public AboutCommand() {
		super("About");
	}
	
	public void actionPerformed(ActionEvent e) {
		System.out.println("This in an asteroids game!\n"
				+ "Goal: Obtain as many points as possible in as short a time.");
	}

}

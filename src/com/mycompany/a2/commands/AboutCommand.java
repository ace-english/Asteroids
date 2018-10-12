package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class AboutCommand extends Command {

	public AboutCommand() {
		super("About");
	}
	
	public void actionPerformed(ActionEvent e) {
		System.out.println("About.");
	}

}

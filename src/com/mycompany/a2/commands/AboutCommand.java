package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.events.ActionEvent;

public class AboutCommand extends Command {

	public AboutCommand() {
		super("About");
	}
	
	public void actionPerformed(ActionEvent e) {
		
	    Dialog.show("About", "Ace English\nCSC 133 Section 4\nVersion 2.0", "OK", "Close");
	}

}

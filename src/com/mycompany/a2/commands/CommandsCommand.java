package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CommandsCommand extends Command {

		public CommandsCommand() {
			super("Commands");
		}
		
		public void actionPerformed(ActionEvent e) {
			System.out.println("Commands selected.");
		}

	

}

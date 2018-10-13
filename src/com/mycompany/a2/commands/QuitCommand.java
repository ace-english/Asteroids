package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.mycompany.a2.GameButton;

public class QuitCommand extends Command {

	public QuitCommand(Form form) {
		super("Quit");
	}
	
	public void actionPerformed(ActionEvent e) {
		Dialog popup = new Dialog("Are you sure you want to quit?");
		GameButton yes, no;
		yes= new GameButton("Yes");
		no=new GameButton("No");
		popup.add(yes);
		popup.add(no);
		popup.show();
		yes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evt) {
				if(evt.getComponent().equals(yes)) {
					System.exit(0);
				}
				
			}
			
		});
	}

}

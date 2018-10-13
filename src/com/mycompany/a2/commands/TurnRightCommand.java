package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class TurnRightCommand extends Command {
	
	private GameWorld gw;

	public TurnRightCommand(GameWorld gw) {
		super("Turn right");
		this.gw=gw;
	}
	
	public void actionPerformed(ActionEvent e) {
		gw.turnRight();
		System.out.println("Ship turned right");
	}

}

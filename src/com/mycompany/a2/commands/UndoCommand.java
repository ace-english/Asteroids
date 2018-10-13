package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;
import com.mycompany.a2.Util;

public class UndoCommand extends Command {
	
	private GameWorld gw;

	public UndoCommand(GameWorld gw) {
		super("Undo");
		this.gw=gw;
	}
	
	public void actionPerformed(ActionEvent e) {
		System.out.println("Undo command chosen");
	}

}

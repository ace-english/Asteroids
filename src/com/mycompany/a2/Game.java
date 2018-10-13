/**
 * 
 */
package com.mycompany.a2;
import com.mycompany.a2.commands.*;

import java.util.LinkedList;

import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;

public class Game extends Form {
	
	public Game() {
		super("Asteroids", BoxLayout.y());
		play();
	}
	
	private void play() {
		
		PointsView pv = new PointsView();
		MapView mv = new MapView();
		GameWorld gw = new GameWorld();
		
		
		this.setLayout(new BorderLayout());
		Container cmdWrapper = new Container();
		cmdWrapper.setLayout(new BoxLayout(BoxLayout.Y_AXIS));

	    
	    //Sound checkbox
	    CheckBox soundBox = new CheckBox("Sound");
	    soundBox.setSelected(true);
		
		//Declare toolbar
	    Toolbar toolbar = new Toolbar();	
	    this.setToolbar(toolbar);
	    toolbar.addComponentToSideMenu(soundBox);
		
		//declare all the commands we shall be using
	    AddPSCommand addPsCmd = new AddPSCommand(gw);
	    FirePSCommand firePsCmd = new FirePSCommand(gw);
	    AddAsteroidCommand addAsteroidCmd = new AddAsteroidCommand(gw);
	    AddNPSCommand addNPSCmd = new AddNPSCommand(gw);
	    AddStationCommand addStationCmd = new AddStationCommand(gw);
	    IncreaseSpeedCommand increaseSpeedCmd = new IncreaseSpeedCommand(gw);
	    DecreaseSpeedCommand decreaseSpeedCmd = new DecreaseSpeedCommand(gw);
	    TurnLeftCommand turnLeftCmd = new TurnLeftCommand(gw);
	    TurnRightCommand turnRightCmd = new TurnRightCommand(gw);
	    AimLeftCommand aimLeftCmd = new AimLeftCommand(gw);
	    AimRightCommand aimRightCmd = new AimRightCommand(gw);
	    FireNPSCommand fireNPSCmd = new FireNPSCommand(gw);
	    HyperspaceJumpCommand hyperspaceJumpCmd = new HyperspaceJumpCommand(gw);
	    RestockCommand restockCmd = new RestockCommand(gw);
	    KillAsteroidCommand killAsteroidCmd = new KillAsteroidCommand(gw);
	    KillNPSCommand killNPSCmd = new KillNPSCommand(gw);
	    PlayerShotCommand playerShotCmd = new PlayerShotCommand(gw);
	    CollisionAsteroidCommand collisionAsteroidCmd = new CollisionAsteroidCommand(gw);
	    CollisionNPSCommand collisionNPSCmd = new CollisionNPSCommand(gw);
	    AsteroidCollisionCommand asteroidCollisionCmd = new AsteroidCollisionCommand(gw);
	    CollisionAsteroidNPSCommand collisionAsteroidNPSCmd = new CollisionAsteroidNPSCommand(gw);
	    TickCommand tickCmd = new TickCommand(gw);
	    QuitCommand quitCmd = new QuitCommand(this);
	    AboutCommand aboutCmd = new AboutCommand();
	    CommandsCommand commandsCmd = new CommandsCommand();
	    SaveGameCommand saveCmd = new SaveGameCommand(gw);
	    NewGameCommand newGameCmd = new NewGameCommand(gw);
	    UndoCommand undoCommand = new UndoCommand(gw);
	    
		
		//=====add key listeners========
	    //< - aim left
		addKeyListener(44, aimLeftCmd);
		//> - aim right
		addKeyListener(46, aimRightCmd);
		//up - increase speed
		addKeyListener(-91, increaseSpeedCmd);
		//down - decrease speed
		addKeyListener(-92, decreaseSpeedCmd);
		//left - turn left
		addKeyListener(-93, turnLeftCmd);
		//right - turn right
		addKeyListener(-94, turnRightCmd);
		//space - fire
		addKeyListener(-90, firePsCmd);
		//j - hyperspace jump
		addKeyListener(106, hyperspaceJumpCmd);
		
		/*
		for(int i=-128; i<128; i++) {
			addKeyListener(i, new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent evt) {
					System.out.println("Pressed " +evt.getKeyEvent());
					
				}
			});
		}
		*/
	
		
		//add commands that should have buttons to list
		LinkedList<Command> cmds = new LinkedList<Command>();
		cmds.add(addStationCmd);
		cmds.add(addNPSCmd);
		cmds.add(addAsteroidCmd);
		cmds.add(addPsCmd);
		cmds.add(increaseSpeedCmd);
		cmds.add(decreaseSpeedCmd);
		cmds.add(firePsCmd);
		cmds.add(fireNPSCmd);
		cmds.add(tickCmd);
		cmds.add(turnLeftCmd);
		cmds.add(turnRightCmd);
		cmds.add(aimRightCmd);
		cmds.add(aimLeftCmd);
		cmds.add(restockCmd);
		cmds.add(hyperspaceJumpCmd);
		cmds.add(killNPSCmd);
		cmds.add(killAsteroidCmd);
		cmds.add(collisionAsteroidNPSCmd);
		cmds.add(collisionNPSCmd);
		cmds.add(collisionAsteroidCmd);
		cmds.add(asteroidCollisionCmd);
		cmds.add(playerShotCmd);
		
		
		
		//allocate buttons for commands
		LinkedList<GameButton> buttons = new LinkedList<GameButton>();
		for(int i=0; i<cmds.size(); i++) {
			buttons.add(new GameButton());
		}
		
		//add buttons in list to east pane of box layout.
		//Assign each button a command from the list
		Command cmd; GameButton button;
		for(int i=0; i<cmds.size(); i++) {
			button=buttons.get(i);
			cmd=cmds.get(i);
			button.setCommand(cmd);
			cmdWrapper.add(button);
		}

	    

		//Add components to Box Layout
		this.add(BorderLayout.WEST, cmdWrapper);
		this.add(BorderLayout.NORTH, pv);
		this.add(BorderLayout.CENTER, mv);
		this.show();
		//Assign dimensions of map into Util
		Util.init(mv);
		//add observers to GameWorld
		gw.addObserver(pv);
		gw.addObserver(mv);
		gw.init();	
		

		//reset list of buttons to use for side menu
		buttons.clear();
		
		//allocate buttons for commands
		for(int i=0; i<cmds.size(); i++) {
			buttons.add(new GameButton());
		}
		
		//add buttons in list to side menu
		//Assign each button a command from the list
		for(int i=0; i<cmds.size(); i++) {
			button=buttons.get(i);
			cmd=cmds.get(i);
			button.setCommand(cmd);
	    	toolbar.addComponentToSideMenu(button);
		}
		
		
		//reset lists to use for overflow menu
		cmds.clear();
		buttons.clear();
		
	    
	    //same show different star
	    cmds.add(quitCmd);
	    cmds.add(aboutCmd);
	    cmds.add(commandsCmd);
	    cmds.add(newGameCmd);
	    cmds.add(saveCmd);
	    cmds.add(undoCommand);
	    
	    //assign commands to fresh buttons
	    for(int i=0; i<cmds.size(); i++) {
	    	buttons.add(new GameButton());
	    	buttons.get(i).setCommand(cmds.get(i));
	    }
	    
	    //add list of buttons to toolbar's overflow menu
	    for(Command temp: cmds) {
	    	toolbar.addCommandToOverflowMenu(temp);
	    }
			
	}
}

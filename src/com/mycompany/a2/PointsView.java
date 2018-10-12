package com.mycompany.a2;

import java.util.Observable;
import java.util.Observer;

import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;

public class PointsView extends Container implements Observer {

	/*
	private class Tuple extends Container{
		private Label value, name;
		public Tuple(String name, String value) {
			name+=": ";
			this.name=new Label(name);
			this.value=new Label(value);
			getAllStyles().setPadding(0, 0, 10, 10);
			this.value.getAllStyles().setPadding(0, 0, 10, 10);
			this.name.getAllStyles().setPadding(0, 0, 10, 10);
			this.add(name);
			this.add(value);
		}
		
		public void set(String value) {
			this.value.setText(value);
			//System.out.println(name.getText()+" is now "+this.value.getText());
			this.repaint();
		}
		
		public Tuple(String name, int value) {
			this(name, Integer.toString(value));
		}
		
		public void set(int value) {
			set(Integer.toString(value));
		}
		
	}
	*/
	
	Label points, ammo, time, sound, lives;
	public PointsView(){
		setLayout(new BoxLayout(BoxLayout.X_AXIS));
		points=new Label("0");
		ammo=new Label("0");
		time=new Label("0");
		sound=new Label("ON");
		lives=new Label("3");
		
		points.getAllStyles().setPadding(0, 0, 5, 5);
		ammo.getAllStyles().setPadding(0, 0, 5, 5);		
		time.getAllStyles().setPadding(0, 0, 5, 5);		
		sound.getAllStyles().setPadding(0, 0, 5, 5);		
		lives.getAllStyles().setPadding(0, 0, 5, 5);

		
		this.add(new Label("Points: "));
		this.add(points);
		this.add(new Label("Missile count: "));
		this.add(ammo);
		this.add(new Label("Elapsed time: "));
		this.add(time);
		this.add(new Label("Sound: "));
		this.add(sound);
		this.add(new Label("Lives: "));
		this.add(lives);
		
	}
	@Override
	public void update(Observable observable, Object data) {
		GameWorldProxy gw = (GameWorldProxy) data;
		points.setText(Integer.toString(gw.getPoints()));
		ammo.setText(Integer.toString(gw.getAmmo()));
		time.setText(Integer.toString(gw.getTime()));
		lives.setText(Integer.toString(gw.getLives()));
		if(gw.getSound()) 
			sound.setText("ON");
		else
			sound.setText("OFF");
		this.repaint();
	}

}

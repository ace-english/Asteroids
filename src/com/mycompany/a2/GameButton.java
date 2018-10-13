package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;

public class GameButton extends Button {
	
	public GameButton(String name) {
		super(name);
		getAllStyles().setFgColor(ColorUtil.rgb(85,0,85));
		
		getAllStyles().setPadding(0, 0, 0, 0);
	}
	
	public GameButton() {
		this("Button");
	}
	
}

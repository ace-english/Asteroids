package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;

public class PlayerMissile extends Missile {

	public PlayerMissile(MissileLauncher ml) {
		super(ml);
		setColor(ColorUtil.WHITE);
	}
	
	public String toString() {
		return "PS's Missile: " + super.toString();
	}

}

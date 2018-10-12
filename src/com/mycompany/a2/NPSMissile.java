package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;

public class NPSMissile extends Missile {

	public NPSMissile(MissileLauncher ml) {
		super(ml);
		setColor(ColorUtil.rgb(0xff, 0, 0));
	}
	
	public String toString() {
		return "NPS's Missile: " + super.toString();
	}

}

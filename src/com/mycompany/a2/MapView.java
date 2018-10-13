package com.mycompany.a2;

import java.util.Observable;
import java.util.Observer;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.plaf.Border;

public class MapView extends Container implements Observer {

	TextArea map;
	public MapView() {
		map=new TextArea();
		map.setEditable(false);
		setLayout(new BorderLayout());
		this.add(BorderLayout.CENTER, map);
		this.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.BLACK));
	}
	@Override
	public void update(Observable observable, Object data) {
		GameWorldProxy gw = (GameWorldProxy) data;
		map.setText(gw.printAll());
		this.repaint();
		System.out.println(gw.printAll());
	}

}

/**
 *   nTorrent - A GUI client to administer a rtorrent process 
 *   over a network connection.
 *   
 *   Copyright (C) 2007  Kim Eik
 *
 *   This program is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package ntorrent.gui;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;

import ntorrent.gui.menubar.MainMenuBar;
import ntorrent.gui.window.Window;

/**
 * The main ntorrent window, consisting of menubar and jtabbedpane, 
 * where each tab holds its own session.
 */
public class MainWindow extends Window implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	public MainWindow() {
		super();
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setJMenuBar(new MainMenuBar(this));
		JPanel frame = new JPanel(new BorderLayout());
		JTabbedPane connections = new JTabbedPane(JTabbedPane.TOP);
		connections.addTab("Profile", null);
		frame.add(connections);
		frame.add(new StatusBar(),BorderLayout.SOUTH);
		setContentPane(frame);
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
	}
}
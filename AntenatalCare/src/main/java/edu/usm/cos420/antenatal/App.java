package edu.usm.cos420.antenatal;

import java.awt.EventQueue;

import edu.usm.cos420.antenatal.controller.AntenatalController;
import edu.usm.cos420.health.controller.Controller;

/**
 * Top level application class that coordinates the calls to view and Controller
 */
public class App {
	/**
	 * Entry point for application : calls {@link AntenatalController}
	 *
	 * @param args
	 *            main program arguments, currently not used
	 */
	public static void main(String[] args) {
	   Controller controller = new Controller();

		//EventQueue.invokeLater(controller::displayGUI);
	}
}

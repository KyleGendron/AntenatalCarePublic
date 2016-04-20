package edu.usm.cos420.antenatal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

import edu.usm.cos420.antenatal.controller.AntenatalController;

public class AntenatalInitialization {

   private static AntenatalController anteController;
   
   
   public static JPanel initializeGUI(){
      anteController = new AntenatalController();
      //EventQueue.invokeLater(anteController::displayGUI);
      anteController.displayGUI();
      return anteController.getView();
   }
   
   
   
}
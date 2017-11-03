package main;

import java.io.File;
import javax.swing.JFileChooser;

public class TestFilePicker {

	public static void main(String[] args) {
		
		JFileChooser chooser = new JFileChooser("./bin");
		
		int result = chooser.showOpenDialog(null);
		
        if (result == JFileChooser.APPROVE_OPTION){
        	
            File openFile = chooser.getSelectedFile();
            System.out.println(openFile);
            
        } else if (result == JFileChooser.CANCEL_OPTION) {
        	
        	System.out.println("Sorry, you didn't select a file to open.");
        	
        }
        
        int saveResult = chooser.showSaveDialog(null);
        
        if (saveResult == JFileChooser.APPROVE_OPTION){
        	
            File saveFile = chooser.getSelectedFile();
            System.out.println(saveFile);
            
        } else if (saveResult == JFileChooser.CANCEL_OPTION) {
        	
        	System.out.println("Sorry, you didn't select a file to save.");
        	
        }

	}

}

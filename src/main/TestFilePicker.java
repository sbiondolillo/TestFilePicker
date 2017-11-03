package main;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;

public class TestFilePicker {

	public static void main(String[] args) {
		
		JFileChooser chooser = new JFileChooser("./bin");
		
		int result = chooser.showOpenDialog(null);
		
        if (result == JFileChooser.APPROVE_OPTION){
        	
            File openFile = chooser.getSelectedFile();
            System.out.println("You selected: " + openFile.getPath());
            if (openFile.canRead()) {
            	
            	System.out.println("Great, you can read from this file!");
            }
            else {
            	
            	System.out.println("Sorry, you can't read from this file!");
            	
            }
            
        } else if (result == JFileChooser.CANCEL_OPTION) {
        	
        	System.out.println("Sorry, you didn't select a file to open.");
        	
        }
        
        int saveResult = chooser.showSaveDialog(null);
        
        if (saveResult == JFileChooser.APPROVE_OPTION){
        	
            File saveFile = chooser.getSelectedFile();
            System.out.println("You selected: " + saveFile.getPath());
            if (saveFile.canWrite()) {
            	
            	System.out.println("Great, you can write to this file!");
            }
            else {
            	
            	if (saveFile.exists()) {
            	
            		System.out.println("Sorry, you can't write to this file!");
            		
            	} else {
            		
            		try {
            			
            			saveFile.createNewFile();
            			System.out.println("Great, you can write to this file!");
            			
            		}
            		catch (IOException e) {
            			
            			System.out.println("Sorry, you won't be able to save to this file.");
            		}
            		
            	}
            	
            }
            
        } else if (saveResult == JFileChooser.CANCEL_OPTION) {
        	
        	System.out.println("Sorry, you didn't select a file to save.");
        	
        }

	}

}

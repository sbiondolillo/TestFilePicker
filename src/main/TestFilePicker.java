package main;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class TestFilePicker {

	public static void main(String[] args) {
		
		// slightly modified version of code found at
		// https://stackoverflow.com/questions/3651494/jfilechooser-with-confirmation-dialog
		JFileChooser chooser = new JFileChooser("./bin"){
			@Override
		    public void approveSelection(){
		        File f = getSelectedFile();
		        if(f.exists() && getDialogType() == SAVE_DIALOG){
		            int result = JOptionPane.showConfirmDialog(this,
		            		"The file exists, overwrite?","Existing file",
		            		JOptionPane.YES_NO_OPTION);
		            switch(result){
		                case JOptionPane.YES_OPTION:
		                    super.approveSelection();
		                    return;
		                case JOptionPane.CANCEL_OPTION:
		                    cancelSelection();
		                    return;
		                default:
		                	return;		                
		            }
		        }
		        super.approveSelection();
		    }        
		};
		
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
            	
            		System.out.println("Sorry, you don't have permission to write to this file!");
            		
            	} else {
            		
            		try {
            			
            			saveFile.createNewFile();
            			System.out.println("Great, you can write to this file!");
            			
            		}
            		catch (IOException e) {
            			
            			System.out.println("Sorry, there was an error trying to write to this file:" + e.getClass());
            		}
            		
            	}
            	
            }
            
        } else if (saveResult == JFileChooser.CANCEL_OPTION) {
        	
        	System.out.println("Sorry, you didn't select a file to save.");
        	
        }        

	}

}

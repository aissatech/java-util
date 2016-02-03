package it.proteam.ocajp.examlab.rubrica.oop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadWriteFile {

	public ReadWriteFile() {		
	}
	public static void main(String args[])throws IOException{
		ReadWriteFile lett = new ReadWriteFile();
		List<String> rubrica = lett.leggiFile();

		// adding new line to the address book
	    rubrica.add("4, Camille Bordon, camille@gmail.com, Via dei Serpenti 15");
	    rubrica.add("5, Aaron Schwartz, aaron@gmail.com, Via di Santa Croce in Gerusalemme 1");
	
	    // writing the updated address book into a new file
	    ReadWriteFile ogg = new ReadWriteFile();
	    ogg.scriviFile(rubrica);
	}

	/**
	 * Reading the address book lines from the file
	 * and store this data into a list of strings
	 */
	public List<String> leggiFile(){
		String file = "rubrica.txt";    
	      
	      //Creates a FileReader Object
	      FileReader reader = null;
		try {
			reader = new FileReader(file);
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		} 
	    //Creates a BufferedReader Object
	    BufferedReader br = null;
	    String line = "";
	    List<String> righe = new ArrayList<String>();
	      
	    try{
	    	br = new BufferedReader(reader);	
		    while( (line = br.readLine()) != null){		    	
		    	righe.add(line);
		    }
	    }catch(IOException e){
	    	e.getMessage();
	    }finally {
		    try {
		        br.close();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		 }
	    
	    return righe;
	}
	/*
	 * Writing the updated address book
	 * into a new file 
	 */
	public boolean scriviFile(List<String> rubrica){
		boolean esito = false;
		String file = "newRubrica.txt";
		
		//Creates a FileWriter Object
		FileWriter writer = null;
		try {
			writer = new FileWriter(file);
		} catch (IOException e) {			
			e.printStackTrace();
		}
		BufferedWriter bw = new BufferedWriter(writer);
		
		Iterator<String> iter = rubrica.iterator();
		while(iter.hasNext()){
			String riga = iter.next();
			try {
				bw.write(riga + "\n");
				bw.flush();
				esito = true;
			} catch (IOException e) {				
				e.printStackTrace();
				esito = false;
			}
		}		
		
		return esito;
	}
}

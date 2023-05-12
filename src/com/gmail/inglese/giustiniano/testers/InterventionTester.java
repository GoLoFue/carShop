package com.gmail.inglese.giustiniano.testers;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

import com.gmail.inglese.giustiniano.classes.Intervention;

public class InterventionTester {
	
	public static void main(String [] args) throws ParseException, FileNotFoundException{
		
		Scanner sc = new Scanner(new File("Intervention.dati"));
		Intervention anInterv = Intervention.read(sc);
		anInterv.print();
		anInterv = Intervention.read(); 
		anInterv.print();
		
	}

}

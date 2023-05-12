package com.gmail.inglese.giustiniano.testers;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

import com.gmail.inglese.giustiniano.classes.Vehicle;

public class VehicleTester {
	
	public static void main(String [] args) throws FileNotFoundException, ParseException {
		
		Scanner sc = new Scanner(new File("Auto.dati"));
		Vehicle aVehicle = Vehicle.read(sc);
		aVehicle.print();
		aVehicle = aVehicle.read();
		aVehicle.print();
		
	}
	

}

package com.gmail.inglese.giustiniano.testers;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

import com.gmail.inglese.giustiniano.classes.CarPark;

public class CarParkTester {

	public static void main(String[] args) throws FileNotFoundException, ParseException {
		
		Scanner scVehicle = new Scanner(new File ("Auto.dati"));
		Scanner scInterv = new Scanner(new File ("Intervention.dati"));
		CarPark parking = new CarPark(scVehicle, scInterv);
		parking.print();
		
	}

}

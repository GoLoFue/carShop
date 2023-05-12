package com.gmail.inglese.giustiniano.classes;

import java.io.PrintStream;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

import com.gmail.inglese.giustiniano.utils.Costants;

public class Intervention {
	
	
	
	public Intervention(String immatriculation, Date interventionDate, double interventionCost){
		
		this.immatriculation = immatriculation;
		this.interventionDate = interventionDate;
		this.interventionCost = interventionCost;

	}
	
	
	
	public Intervention() {
		
	}



	public static Intervention read() throws ParseException{
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Digit the immatriculation: ");
		String imm = sc.nextLine();
		if(imm.equals("")) return null;
		System.out.print("Digit the intervention date: ");
		String date = sc.next();
		if(date.equals("")) return null;
		Date newDate = Costants.sdfday.parse(date);
		System.out.print("Digit the intervention cost: ");
		String interventionCost = sc.next();
		if(interventionCost.equals("")) return null;
		double newCost = Double.parseDouble(interventionCost);
		return new Intervention (imm, newDate, newCost);
		
	}
	
	public static Intervention read(Scanner sc) throws ParseException {
	
		if(!sc.hasNext()) return null;
		String imm = sc.next();
		if(!sc.hasNext()) return null;
		String date = sc.next();
		Date newDate = Costants.sdfday.parse(date);
		if(!sc.hasNext()) return null;
		String cost = sc.next();
		double newCost = Double.parseDouble(cost);
		sc.nextLine();
		return new Intervention (imm, newDate, newCost);
		
	}
	
	public String getImmatriculation() {
		
		return this.immatriculation;
	}

	public Date getInterventionDate() {
		
		return this.interventionDate;
		
	}
	
	public double getInterventionCost() {
		
		return this.interventionCost;
	}
	
	public Vehicle getVehicle() {
		
		return this.vehicle;
	}
	
	public void setVehicle(Vehicle aVehicle) {
		
		this.vehicle = aVehicle;
	}
	
	public void print() {
		
		System.out.println("Immatriculation: " + this.immatriculation);
		System.out.println("Date: " + Costants.sdfday.format(interventionDate));
		System.out.println("Cost: " + this.interventionCost);
		
	}
	
	public void print(PrintStream ps) {
		
		ps.print(this.immatriculation + " ");
		ps.print(Costants.sdfday.format(interventionDate) + " ");
		ps.println(this.interventionCost + " ");
		
	}
	
	private String immatriculation;
	private Date interventionDate;
	private double interventionCost;
	private Vehicle vehicle; 
	
}

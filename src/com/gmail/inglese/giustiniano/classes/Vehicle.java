package com.gmail.inglese.giustiniano.classes;

import java.io.PrintStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.gmail.inglese.giustiniano.utils.Costants;


public class Vehicle {
	
	
	
	public Vehicle(String immatriculation, Date registrationYear, double kmXLiter, double runnedKm, double cost){
		
		this.immatriculation = immatriculation;
		this.registrationYear = registrationYear;
		this.kmXLiter = kmXLiter; 
		this.runnedKm = runnedKm;
		this.cost = cost;
		
	}
	
	
	
	public Vehicle(String immatriculation, Date registrationYear, double kmXLiter, double runnedKm, double cost, ArrayList<Intervention> interventions) {
	
		this.immatriculation = immatriculation;
		this.registrationYear = registrationYear;
		this.kmXLiter = kmXLiter;
		this.runnedKm = runnedKm;
		this.cost = cost;
		this.interventions = interventions;
	}



	public static Vehicle read() throws ParseException{
	
		Scanner sc = new Scanner(System.in);
		System.out.print("Digit the immatriculation: ");
		String imm = sc.next();
		if(imm.equals("")) return null;
		System.out.print("Digit immatriculation's year: ");
		String year = sc.next();
		Date newYear = Costants.sdf.parse(year);
		if(year.equals("")) return null;
		System.out.print("Digit the runned kms: ");
		String runnedKm = sc.next();
		double newKm = Double.parseDouble(runnedKm);
		if(runnedKm.equals("")) return null;
		System.out.print("Digit how many kms x liter the vehicle can run: ");
		String kmXLiter = sc.next();
		double newKmXLiter = Double.parseDouble(kmXLiter);
		if(kmXLiter.equals("")) return null; 
		System.out.print("Digit the cost of the vehicle: ");
		String cost = sc.next();
		double newCost = Double.parseDouble(cost);
		if(cost.equals("")) return null;
		
		return new Vehicle(imm, newYear, newKm, newKmXLiter, newCost);
		
	}
	
	public static Vehicle read(Scanner sc) throws ParseException {
	
		if(!sc.hasNextLine()) return null;
		String imm = sc.nextLine();
		if(!sc.hasNextLine()) return null;
		String year = sc.nextLine();
		Date newYear = Costants.sdf.parse(year);
		if(!sc.hasNextLine()) return null;
		String runnedKm = sc.nextLine();
		double newKm = Double.parseDouble(runnedKm);
		if(!sc.hasNextLine()) return null;
		String kmXLiter = sc.nextLine();
		double newKmXLiter = Double.parseDouble(kmXLiter);
		if(!sc.hasNextLine()) return null;
		String cost = sc.nextLine();
		double newCost = Double.parseDouble(cost);
		return new Vehicle(imm, newYear, newKm, newKmXLiter, newCost);
	}
	
	public String getImmatriculation() {
		
		return immatriculation;
		
	}
	
	public Date getRegistrationYear() {
		
		return registrationYear;
	}
	
	public double getKmXLiter() {
		
		return kmXLiter;
	}

	public double getRunnedKm() {
		
		return runnedKm;
	}
	
	public double getCost() {
		
		return cost;
	}
	
	public ArrayList<Intervention> getInterventions() {
		return interventions;
	}



	public void setInterventions(ArrayList<Intervention> interventions) {
		this.interventions = interventions;
	}



	public void setKm(double newKm) {
		
		this.runnedKm = newKm;
		
	}
	
	public void setKmXLiter(double newKmXLiter) {
		
		this.kmXLiter = newKmXLiter;
		
	}
	
	public void print() {
		
		print(System.out);
	}
	
	public void print(PrintStream ps) {
		
		ps.println(this.immatriculation);
		ps.println(Costants.sdf.format(registrationYear));
		ps.println(this.runnedKm);
		ps.println(this.kmXLiter);
		ps.println(this.cost);
	}
	
	public void printWithInterventions() {
		
		System.out.println("");
		this.print();
		System.out.println("Interventions list: ");
		for(Intervention i: interventions) {
			
			i.print();
			
		}
	
	}
	
	
	public void addIntervention(Intervention interv) {
		
		interventions.add(interv);
		
	}
	
	public double getMaintenanceCost() {
		
		double maintenanceCost = 0;
		for(Intervention interv : interventions) {
			
			maintenanceCost = maintenanceCost + interv.getInterventionCost();
		}
		
		return maintenanceCost;
	}
	
	public double getTotalCost() {
		
		return this.getCost() + this.getMaintenanceCost();
	}
	
	private String immatriculation;
	private Date registrationYear;
	private double kmXLiter;
	private double runnedKm;
	private double cost;
	private ArrayList<Intervention> interventions;
}

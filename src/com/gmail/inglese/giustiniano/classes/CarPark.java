package com.gmail.inglese.giustiniano.classes;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class CarPark {
	
	public CarPark() {
		
		this.interventions = new ArrayList<Intervention>();
		this.vehicles = new ArrayList<Vehicle>();
	
	}
	
	public CarPark(Scanner scVehicle, Scanner scInterv) throws ParseException{
		
		this.vehicles = new ArrayList<Vehicle>();
		Vehicle vehicle = Vehicle.read(scVehicle);
		while(vehicle != null) {
			
			vehicles.add(vehicle);
			vehicle = Vehicle.read(scVehicle);
		}
		
		this.interventions = new ArrayList<Intervention>();
		Intervention intervention = Intervention.read(scInterv);
		while(intervention != null) {
			
			Vehicle vehicle1 = searchVehicleByImmatriculation(intervention.getImmatriculation());
			if(vehicle1 != null) {
				
				intervention.setVehicle(vehicle1);
				vehicle1.addIntervention(intervention);
				interventions.add(intervention);
				
			}
			
			intervention = Intervention.read(scInterv);
			
		}
		
	}
	
	
	public Vehicle searchVehicleByImmatriculation(String immatriculation) {
		
		boolean trovato = false;
		int i = 0;
		while(!trovato && i<vehicles.size()) {
			
			if(vehicles.get(i).getImmatriculation().equals(immatriculation)) {
				
				trovato = !trovato;
				
			}else {
			
				i++;
				
			}
			
		}
		
		if(trovato) return vehicles.get(i);
		else return null;
		
	}
	
	public void print() {
		
		for(Vehicle v : vehicles) {
			
			v.printWithInterventions();
			
		}
		
		
	}


	private ArrayList<Intervention> interventions;
	private ArrayList<Vehicle> vehicles;
	

}

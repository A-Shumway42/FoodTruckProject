package com.skilldistillery.foodtruck;

public class FoodTruck {
	// name, food type and rating for up to five food trucks
	// including the id which will be generated in a 
	// constructor from a static field that is incremented
	// as each truck is created.
	private String name;
	private String foodType;
	private double rating;
	
	private static int idGenerator = 1000;
	private int truckId;
	
	// no arg constructor
	public FoodTruck() {}

	public FoodTruck(String name, String foodType, double rating) {
		this.name = name;
		this.foodType = foodType;
		this.rating = rating;
		this.truckId = idGenerator;
		idGenerator++;
	}
	// create mutators & accessors
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public int getTruckId() {
		return truckId;
	}

	public void setTruckId(int truckId) {
		this.truckId = truckId;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FoodTruck *Name: ");
		builder.append(name);
		builder.append(", Food Type: ");
		builder.append(foodType);
		builder.append(", Rating: ");
		builder.append(rating);
		builder.append(", Truck ID: ");
		builder.append(truckId);
		builder.append("*");
		return builder.toString();
	}
	
	
	
	
	
	
	
}

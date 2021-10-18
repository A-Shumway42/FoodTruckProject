package com.skilldistillery.foodtruck;

import java.util.Scanner;

public class FoodTruckApp {

	public static void main(String[] args) {

		FoodTruckApp foodTrucksApp = new FoodTruckApp();
		FoodTruck[] foodTrucks = new FoodTruck[5];

		foodTrucksApp.run(foodTrucks);

	}

	private void run(FoodTruck[] foodTrucks) {
		Scanner input = new Scanner(System.in);
		foodTrucks = buildTrucks(foodTrucks, input);

		printMenu();
		menuChoice(foodTrucks, input);
		input.close();

	}

	private FoodTruck[] buildTrucks(FoodTruck[] foodTrucks, Scanner input) {
		System.out.println("Welcome to ShumTrucks Food App!");
		int numOfTrucks = 0;
		System.out.println("How many food trucks would you like to create?");
		numOfTrucks = numOfTrucksLimit(input.nextInt(), input);
		foodTrucks = new FoodTruck[numOfTrucks];

		for (int i = 0; i < foodTrucks.length; i++) {
			System.out.println("What is the name of Food Truck " + (i + 1) + "?");
			String name = input.nextLine();
			if (name.equals("quit")) {
				break;
			}

			System.out.println("What is the Food Type of Food Truck " + (i + 1) + "?");
			String foodType = input.nextLine();

			System.out.println("What is the rating of Food Truck " + (i + 1) + "?");
			double rating = input.nextDouble();
			input.nextLine();

			foodTrucks[i] = new FoodTruck(name, foodType, rating);

			System.out.println("Food Truck " + (i + 1) + " created!");
		}
		return foodTrucks;

	}

	private void printMenu() {
		System.out.println("******************************************");
		System.out.println("*_________________Menu___________________*");
		System.out.println("* 1. Food Truck List                     *");
		System.out.println("* 2. Show Average Ratings of Food Trucks *");
		System.out.println("* 3. Display Highest-Rated Food Truck    *");
		System.out.println("* 4. Quit                                *");
		System.out.println("******************************************");

	}

	
	private boolean menuChoice(FoodTruck[] foodTrucks, Scanner input) {
		boolean keepGoing = true;
		while (keepGoing) {
			int choice = input.nextInt();
			switch (choice) {
			case 1:
				showFoodTruckList(foodTrucks);
				break;
			case 2:
				showAverageRatingsOfFoodTrucks(foodTrucks);
				break;
			case 3:
				showHighestRatedFoodTruck(foodTrucks);
				break;
			case 4:
				System.out.println("Closing app! Thank You!");
				return false;
			default:
				System.out.println("Invalid selection. Please choose available options.");
				break;

			}
		}
		return keepGoing;
	}

	private void showFoodTruckList(FoodTruck[] foodTrucks) {
		for (FoodTruck foodTruck : foodTrucks) {
			if (foodTruck != null)
				System.out.println(foodTruck.toString());
		}
	}

	private void showAverageRatingsOfFoodTrucks(FoodTruck[] foodTrucks) {
		int sum = 0;
		int length = 0;
		for (int i = 0; i < foodTrucks.length; i++) {
			if (foodTrucks[i] != null) {
				sum += foodTrucks[i].getRating();
				length++;
			}
		}
		double average = sum / length;
		System.out.println(average);

	}

	private void showHighestRatedFoodTruck(FoodTruck[] foodTrucks) {
		double highestRating = foodTrucks[0].getRating();
		int maxIndex = 0;
		for (int i = 0; i < foodTrucks.length; i++) {
			if (foodTrucks[i] != null && foodTrucks[i].getRating() > highestRating) {
				highestRating = foodTrucks[i].getRating();
				maxIndex = i;
			}
		}
		System.out.println(foodTrucks[maxIndex].toString());

	}

	private int numOfTrucksLimit(int numOfTrucks, Scanner input) {
		int truckLimit = 5;
		int truckFloor = 1;
		boolean keepGoing = true;
		while (keepGoing) {
			if (numOfTrucks > truckLimit) {
				System.out.println("The maximum amount of trucks is 5.");
				System.out.println("How many food trucks would you like to create?");
				numOfTrucks = input.nextInt();

			} else if (numOfTrucks < truckFloor) {
				System.out.println("The minimum amount of trucks is 1.");
				System.out.println("How many food trucks would you like to create?");
				numOfTrucks = input.nextInt();

			} else {
				keepGoing = false;
			}

		}
		input.nextLine();
		return numOfTrucks;
	}
}

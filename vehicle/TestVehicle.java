package vehicle;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
/**
 * @author sanchuanjiang
 *
 */
import java.util.Scanner;

public class TestVehicle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		int[][] arrayGraph = Reader01.createArray("src/vehicle/graph.txt");
		String[][] arrayRoute = Reader02.createArray("src/vehicle/route.txt");
		String[][] arrayInventory = Reader03.createArray("src/vehicle/inventory.csv");
		FamilyCar [] arrayCar = new FamilyCar[10];
		String[][] arrayValue = new String[10][2];
		

		
		
		System.out.println("Please choose: 1.Route Vehicles;  2.Manage dealership inventory;  3.Exit program");
		Scanner A = new Scanner(System.in);
		int input = A.nextInt();
		while(input!=1&& input!=2&& input!=3) {
			System.out.println("Please choose again");
			input = A.nextInt();
		}
		if(input == 1) {
	    Scanner D = new Scanner(System.in);
		System.out.println("Please select route for DumpTruck such as \"AB\"");
		String truckRoute = D.nextLine();
	
		
		System.out.println("Please select a different route for SchoolBus such as \"CE\"");
		String busRoute = D.nextLine();
		while (isEqual(truckRoute, busRoute)) {
			setRoute();
		}
		Scanner S = new Scanner(System.in);
		System.out.println("Please write an Integer as speed of DumpTruck ");
		dt.setMiles_per_hour(S.nextInt());
		System.out.println("Please write an Integer as speed of SchoolBus");
		sb.setMiles_per_hour(S.nextInt());

		while(!isCollision(truckRoute,busRoute, arrayGraph, arrayRoute)) {
			System.out.println("DumpTruck has traveled " + Reader01.calRoute(Reader02.chooseRoute(truckRoute, arrayRoute), arrayGraph) + " miles in " + (double)Reader01.calRoute(Reader02.chooseRoute(truckRoute, arrayRoute), arrayGraph)/dt.getMiles_per_hour() + " hours and used " +  Reader01.calRoute(Reader02.chooseRoute(truckRoute, arrayRoute), arrayGraph)/(dt.getMiles_per_hour()*dt.getMiles_per_gallon()) + " gallon gas with average " + dt.getMiles_per_hour() + " miles per hour and it's route is " + Reader02.chooseRoute(truckRoute, arrayRoute));
			System.out.println("SchoolBus has traveled " + Reader01.calRoute(Reader02.chooseRoute(busRoute, arrayRoute), arrayGraph) + " miles in " + (double)Reader01.calRoute(Reader02.chooseRoute(busRoute, arrayRoute), arrayGraph)/sb.getMiles_per_hour() + " hours and used " +  Reader01.calRoute(Reader02.chooseRoute(busRoute, arrayRoute), arrayGraph)/(sb.getMiles_per_hour()*sb.getMiles_per_gallon()) + " gallon gas  with average " + sb.getMiles_per_hour() + " miles per hour and it's route is " + Reader02.chooseRoute(busRoute, arrayRoute));
			break;
		}
		while(isCollision(truckRoute,busRoute, arrayGraph, arrayRoute)) {
			System.out.println("collision");
			System.out.println("Please choose what you want to change: a.Rerouting a vehicle; b.Change the speed of a vehicle");
			Scanner C = new Scanner(System.in);
			String sd= C.nextLine();
			if(sd.equals("b")) {
			System.out.println("Please choose a vehicle form DumpTruck and SchoolBus, press \"dt\" for DumpTruck \"sb\" for SchoolBus");
			String vehforspeed=C.nextLine();
			System.out.println("Please write an Integer as a new speed");
			int newspeed=C.nextInt();
			if(vehforspeed.equals("dt")) {
				dt.setMiles_per_hour(newspeed);
			}
			else {
				sb.setMiles_per_hour(newspeed);
			}
			}
			else {
				System.out.println("Please choose a vehicle form DumpTruck and SchoolBus,  press \"dt\" for DumpTruck \"sb\" for SchoolBus");
				String vehfordivert=C.nextLine();
				if(vehfordivert.equals("dt")) {
				System.out.println("Please select route for DumpTruck");
				 truckRoute= C.nextLine();
				
				}
				else {
					System.out.println("Please select route for SchoolBus");
					 busRoute= C.nextLine();
						
				}
			
			}

		}
		}
		else if (input == 2) {
			for(int i = 1; i<arrayInventory.length; i++) {
				FamilyCar fc = new FamilyCar(arrayInventory[i][0],arrayInventory[i][1],Integer.parseInt(arrayInventory[i][2]),arrayInventory[i][3],Double.parseDouble(arrayInventory[i][4]),Double.parseDouble(arrayInventory[i][5]),Integer.parseInt(arrayInventory[i][6]));
				arrayCar[i-1] = fc;
				}
			for(int j = 1; j<arrayInventory.length; j++) {
				arrayValue[j-1][0] = arrayInventory[j][7];
				arrayValue[j-1][1] = arrayInventory[j][8];
				}
			
			System.out.println("Please type in an Number as dealership’s account balance");
			Scanner B = new Scanner(System.in);
			double balance = B.nextDouble();
			for(int n = 0; n<arrayCar.length; n++) {
				if(arrayValue[n][1].equals("Buy")) {
					if(balance < calCost(arrayValue, arrayCar, n)) {
						
						System.out.println("Sorry , you missed " + arrayCar[n]);
					}
					else {
						balance = balance - calCost(arrayValue, arrayCar, n);
						System.out.println("Congratulations you just bought a " + arrayCar[n]);
					}
				}
				else if(arrayValue[n][1].equals("Sell")){
					balance = balance+calSales(calCost(arrayValue, arrayCar, n));
					System.out.println("Congratulations you just sold a " + arrayCar[n]);
				}
			}
			}
			
		
		else if (input == 3) {
			
		}

	

		}
	static DumpTruck dt = new DumpTruck("Mack", "Granite", 2017, "White", 5.5, 13, 55);
	static SchoolBus sb = new SchoolBus("Blue Bird", "Conventional", 2012, "Yellow", 11.2, 24, 54);
	FamilyCar fc = new FamilyCar("Toyota", "Sienna", 2008, "Blue", 19, 38.4, 65);
	

	public static double calCost(String[][] arrayValue, FamilyCar[] arrayCar, int i) {
		double costPrice;
		int colorPrice;
		double yearPrice;
		double capPrice;
		if(arrayCar[i].getColor().equals("black")) {
			colorPrice = 700;
		}
		else if(arrayCar[i].getColor().equals("white")){
			colorPrice = 1000;
		}
		else colorPrice = 0;
		capPrice = arrayCar[i].getCubic_ft()*49;
		yearPrice = 5000/(2018-arrayCar[i].getYear());
		costPrice = colorPrice + yearPrice + capPrice;
		return costPrice + Integer.parseInt(arrayValue[i][0]);
	}
	public static double calSales(double dou) {
		double salesPrice;
		salesPrice = 1.15*dou;
		return salesPrice;
	}
	
	public static void setRoute() {
        Scanner D = new Scanner(System.in);
		System.out.println("Please select route for DumpTruck such as \"AB\"");
		String truckRoute = D.nextLine();
		System.out.println("Please select a different route for SchoolBus such as \"CE\"");
		String busRoute = D.nextLine();

	}
	public static void setSpeed() {
		Scanner D = new Scanner(System.in);
		System.out.println("Please select speed for DumpTruck ");
		dt.setMiles_per_hour(D.nextInt());
		System.out.println("Please select speed for SchoolBus");
		sb.setMiles_per_hour(D.nextInt());
	}

	
	private static boolean isEqual(String truckRoute, String busRoute) {
		HashSet<Character> set1 = new HashSet<Character>();
//		HashSet<String> set2 = new HashSet<String>();
//		set1.add(truckRoute);
		if (truckRoute.length() != busRoute.length())
			return false;
		for (char c : truckRoute.toCharArray()) {
			set1.add(c);
		}
		char[] result = new char[truckRoute.length()];
		for (char c : busRoute.toCharArray()) {
			if (!set1.contains(c)) {
				return false;
			}
		}
		return true;
	}
	
	private static String isContained(String truckRoute, String busRoute) {
		HashSet<Character> set1 = new HashSet<Character>();
		for (char c : truckRoute.toCharArray()) {
			set1.add(c);
		}
		ArrayList<Character> result = new ArrayList<Character>();
		for (char c : busRoute.toCharArray()) {
			if (set1.contains(c)) {
				result.add(c);
				
			}
		}
		
		return result.toString();
	}
	public static boolean isCollision(String truckRoute, String busRoute, int[][] arrayGraph, String[][] arrayRoute) {
		if(isContained(truckRoute, busRoute).contains("I")&&
			(Reader01.calRoute(Reader02.chooseRoute(truckRoute, arrayRoute).substring(0, truckRoute.indexOf("I")), arrayGraph)/dt.getMiles_per_hour()==Reader01.calRoute(Reader02.chooseRoute(busRoute, arrayRoute).substring(0, busRoute.indexOf("I")), arrayGraph)/sb.getMiles_per_hour())) { 
				return true;
			
		}
		if(isContained(truckRoute, busRoute).contains("J")&&
			(Reader01.calRoute(Reader02.chooseRoute(truckRoute, arrayRoute).substring(0, truckRoute.indexOf("J")), arrayGraph)/dt.getMiles_per_hour()==Reader01.calRoute(Reader02.chooseRoute(busRoute, arrayRoute).substring(0, busRoute.indexOf("J")), arrayGraph)/sb.getMiles_per_hour())) {
				return true;
			
		}
		if(isContained(truckRoute, busRoute).contains("K")&&
			(Reader01.calRoute(Reader02.chooseRoute(truckRoute, arrayRoute).substring(0, truckRoute.indexOf("K")), arrayGraph)/dt.getMiles_per_hour()==Reader01.calRoute(Reader02.chooseRoute(busRoute, arrayRoute).substring(0, busRoute.indexOf("K")), arrayGraph)/sb.getMiles_per_hour())) {
				return true;
			
		}
		if(isContained(truckRoute, busRoute).contains("L")&&
			(Reader01.calRoute(Reader02.chooseRoute(truckRoute, arrayRoute).substring(0, truckRoute.indexOf("L")), arrayGraph)/dt.getMiles_per_hour()==Reader01.calRoute(Reader02.chooseRoute(busRoute, arrayRoute).substring(0, busRoute.indexOf("L")), arrayGraph)/sb.getMiles_per_hour())) {
				return true;
			
		}
		
		return false;
		
		
	}
	
   	  
    

}
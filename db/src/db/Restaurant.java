package db;

import java.util.Vector;

enum Risk {HIGH, MEDIUM, LOW, NA};

public class Restaurant {
	public int businessID;
	public String name;
	public int ZIP;
	public Vector<Review> reviews;
	public Vector<Inspection> inspections;
	
	public Restaurant (int b, String n, int z, Inspection i) {
		inspections = new Vector<Inspection>();
		reviews = new Vector<Review>();
		businessID = b;
		name = n;
		ZIP = z;
	}
	
	class Inspection {
		public String inspectionID;
		public int inspectionScore;
		public Risk riskFactor;
		
		public Inspection (){
			
		}
	}
	class Review {
		public String review;
		public int reviewScore;
		
		public Review(String r, int s) {
			review = r;
			reviewScore = s;
		}
	}
}
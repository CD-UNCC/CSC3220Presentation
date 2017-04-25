package db;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Vector;

public class Main {
	
	private static Main Server;
	private static boolean ServerRunning;
	private static String currFile;
	private static HashMap<String, Restaurant> Restaurants;
	
	public static void main(String args[]) {
		Server  =  new Main();
		//Server.run();
		Server.updateDB();
	}
	
	public void run() {
		while(ServerRunning) {
			updateDB();
		}
	}
	
	@SuppressWarnings("resource")
	private void updateDB() {
		URL website;

		DateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
		Calendar c = Calendar.getInstance();
		try {
			currFile = "c:\\Users\\Cocoa\\OneDrive\\School\\2017S\\CSC3220\\asd\\db" + formatter.format(c.getTime()) + ".csv";
			File dbupdate = new File(currFile);
			website = new URL("https://data.sfgov.org/api/views/pyih-qa8i/rows.csv?accessType=DOWNLOAD");
			ReadableByteChannel rbc = Channels.newChannel(website.openStream());
			FileOutputStream fos = new FileOutputStream(dbupdate);
			fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void parseDB() {
		Vector<String> lines;
	}
	
	public Main() {
		ServerRunning = true;
		
	}
}

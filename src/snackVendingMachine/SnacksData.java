package snackVendingMachine;

import java.io.FileReader;
import java.util.HashMap;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SnacksData
{ 
	
	//note: I tried to read them as json file but it wasn't detecting the file 
   /*static public List<Snack> get() {
	
	List<Snack> snacks = new ArrayList<>();
	
	        snacks.add(new Snack("A1", 1.50));
	        snacks.add(new Snack("A2", 1.75));
	        snacks.add(new Snack("A3", 2.00));
	        snacks.add(new Snack("A4", 2.25));
	        snacks.add(new Snack("A5", 2.50));
	        snacks.add(new Snack("B1", 1.25));
	        snacks.add(new Snack("B2", 1.50));
	        snacks.add(new Snack("B3", 1.75));
	        snacks.add(new Snack("B4", 2.00));
	        snacks.add(new Snack("B5", 2.25));	    
	

	// print the snacks list
	for (Snack snack : snacks) {
	    System.out.println("Snack Name: " + snack.getName() + ", Price: " + snack.getPrice());
	}
	
	return snacks;
}
*/
//this way faster in map than list
   static public Map<String, Double> set()
   { 
	   Map<String, Double> snacks = new HashMap<>();
    snacks.put("A1", 1.50);
    snacks.put("A2", 1.75);
    snacks.put("A3", 2.00);
    snacks.put("A4", 2.25);
    snacks.put("A5", 2.50);
    snacks.put("B1", 1.25);
    snacks.put("B2", 1.50);
    snacks.put("B3", 1.75);
    snacks.put("B4", 2.00);
    snacks.put("B5", 2.25);
    snacks.put("C1", 1.25);
    snacks.put("C2", 1.50);
    snacks.put("C3", 1.75);
    snacks.put("C4", 2.00);
    snacks.put("C5", 2.25);
    snacks.put("D1", 1.50);
    snacks.put("D2", 1.75);
    snacks.put("D3", 2.00);
    snacks.put("D4", 2.25);
    snacks.put("D5", 2.50);
    snacks.put("E1", 1.25);
    snacks.put("E2", 1.50);
    snacks.put("E3", 1.75);
    snacks.put("E4", 2.00);
    snacks.put("E5", 2.25);
    return snacks;
	   
   }
   
   
   public List<Snack>jsonReader(){
	   
	   List<Snack> snacks = new ArrayList<>();
	   ObjectMapper mapper = new ObjectMapper();
	   try {
	       Snack[] snackArray = mapper.readValue(new File("snacks.json"), Snack[].class);
	       for (Snack snack : snackArray) {
	           snacks.add(snack);
	       }
	   } catch (IOException e) {
	       e.printStackTrace();
	   }

	   // print the snacks list
	   for (Snack snack : snacks) {
	       System.out.println("Snack Name: " + snack.getName() + ", Price: " + snack.getPrice());
	   }
	return snacks;}
}
import java.io.*;
import java.util.*;

//This program computes the Jaccard distance between two sets
public class Jaccard{
		
	public static void main(String[] args){
		long startTime = System.currentTimeMillis();

		ArrayList<Double> set1;
		ArrayList<Double> set2;
		
		set1=new ArrayList<Double>();
		set2=new ArrayList<Double>();
	
		set1.add(1.1);
		set1.add(2.2); 
		set1.add(3.3); 
		set1.add(4.4);

		set2.add(0.1); 
		set2.add(0.2); 
		set2.add(4.4); 
		set2.add(0.3);

		Set<Double> dSet1=new HashSet<>(set1);
		Set<Double> dSet2=new HashSet<>(set2);
		//This is the destructive version of union
		//It will destroy the dSet1's all value
	//	dSet1.addAll(dSet2);
		
		
		//This is the non-destructive version of union
		//It will not destroy, because we are copying the list first

		Set<Double> union=new HashSet<>(set1);
		union.addAll(dSet2);
		int u=union.size();
		System.out.println("Union set has "+union.size()+" elements ");
		
		//This is non-destructuve version of intersection
		Set<Double> intersection=new HashSet<>(set1);
		intersection.retainAll(dSet2);
		int i=intersection.size();
		System.out.println("Intersection set has "+i+" elements ");

		//Computing the Jaccard Index 
		float jc=(float)i/(float)u;
		System.out.println("Jaccard Coefficient is : " +jc);
		
		
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Start time: "+startTime);
		System.out.println("End Time: "+endTime+"\nElapsedtime: "+totalTime);

	
	}//end of main method



}//end of class

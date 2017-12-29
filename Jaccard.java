import java.io.*;
import java.util.*;

//This program computes the Jaccard distance between two sets
public class Jaccard{
	
	static double getJaccardIndex(ArrayList<Double> list1, ArrayList<Double> list2 ){
		
		Set<Double> set1=new HashSet<>(list1);
		Set<Double> set2=new HashSet<>(list2);

		Set<Double> union=new HashSet<>(set1);
		union.addAll(set2);
		int u=union.size();
		System.out.println("Union set has "+union.size()+" elements ");
		
		//This is non-destructuve version of intersection
		Set<Double> intersection=new HashSet<>(set1);
		intersection.retainAll(set2);
		int i=intersection.size();
		System.out.println("Intersection set has "+i+" elements ");

		//Computing the Jaccard Index 
		float jc=(float)i/(float)u;
		System.out.println("Jaccard Coefficient is : " +jc);
		return jc;
	}	





	public static void main(String[] args){
		long startTime = System.currentTimeMillis();

		ArrayList<Double> list1;
		ArrayList<Double> list2;
		ArrayList<Double> list3;
		
		list1=new ArrayList<Double>();
		list2=new ArrayList<Double>();
		list3=new ArrayList<Double>();
	
		list1.add(1.1);
		list1.add(2.2); 
		list1.add(3.3); 
		list1.add(4.4);

		list2.add(0.1); 
		list2.add(0.2); 
		list2.add(4.4); 
		list2.add(0.3);
		
		list3.add(0.1); 
		list3.add(0.2); 
		list3.add(4.4); 
		list3.add(0.3);

		
		//This is the destructive version of union
		//It will destroy the dSet1's all value
	//	dSet1.addAll(dSet2);
		
		
		//This is the non-destructive version of union
		//It will not destroy, because we are copying the list first

		getJaccardIndex(list1,list2);
		
		
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Start time: "+startTime);
		System.out.println("End Time: "+endTime+"\nElapsedtime: "+totalTime);

	
	}//end of main method



}//end of class

import java.io.*;
import java.util.*;

//This program computes the Jaccard distance between two sets
public class Jaccard{
	
	static double getJaccardIndex(ArrayList<Double> list1, ArrayList<Double> list2 ){
		
		Set<Double> set1=new HashSet<>(list1);
		Set<Double> set2=new HashSet<>(list2);
		//This is the destructive version of union
		//It will destroy the dSet1's all value
		//	dSet1.addAll(dSet2);
		
		
		//This is the non-destructive version of union
		//It will not destroy, because we are copying the list first

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


	public static void addPoint(ArrayList<Double> list1, double first,double second, double third, double forth){
		//list1=new ArrayList<Double>();
		list1.add(first);
		list1.add(second); 
		list1.add(third); 
		list1.add(forth);
	}


	public static void main(String[] args){
		long startTime = System.currentTimeMillis();

		ArrayList<Double> list1;
		ArrayList<Double> plane1;
		ArrayList<Double> plane2;
		
		list1=new ArrayList<Double>();
		plane1=new ArrayList<Double>();
		plane2=new ArrayList<Double>();
	
		addPoint(list1,1.1,2.2,3.3,4.4);
		addPoint(plane1,1.1,2.2,4.4,0.3);
		addPoint(plane2,0.5,0.7,4.2,0.5);
				
				
		int bucketBit1;
		int bucketBit2;

		if(getJaccardIndex(list1,plane1)>0.5){
			bucketBit1=0b1;
		}else{
			bucketBit1=0b0;
		}

		if(getJaccardIndex(list1,plane2)>0.5){
			bucketBit2=1;
		}else{
			bucketBit2=0;
		}
		
		
		//getting the bucket number
		bucketBit1 <<= 1;
        bucketBit1 |= bucketBit2;
        System.out.println("The bucket number is : "+Integer.toString(bucketBit1,2));











		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		//System.out.println("Start time: "+startTime);
		System.out.println("End Time: "+endTime+"\nElapsedtime: "+totalTime);

	
	}//end of main method



}//end of class

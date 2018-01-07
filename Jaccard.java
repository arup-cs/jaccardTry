import java.io.*;
import java.util.*;

//This program computes the Jaccard distance between two sets
public class Jaccard{
	static ArrayList<Record> trainList=new ArrayList<Record>();
	static ArrayList<Record> resultList=new ArrayList<Record>();
	static ArrayList<Record> list00= new ArrayList<Record>();
	static ArrayList<Record> list01= new ArrayList<Record>();
	static ArrayList<Record> list10= new ArrayList<Record>();
	static ArrayList<Record> list11= new ArrayList<Record>();
	
	static ArrayList<Double> list1=new ArrayList<Double>();
	static ArrayList<Double> plane1=new ArrayList<Double>();
	static ArrayList<Double> plane2=new ArrayList<Double>();


	
	public static void addPoint(ArrayList<Double> list1, double first,double second, double third, double forth){
		//list1=new ArrayList<Double>();
		System.out.println("Adding to list "+first+" "+second+" "+third+" "+forth);

		list1.add(first);
		list1.add(second); 
		list1.add(third); 
		list1.add(forth);
	}



	static double getJaccardIndex(ArrayList<Double> list1, ArrayList<Double> plane ){
		
		Set<Double> set1=new HashSet<>(list1);
		Set<Double> set2=new HashSet<>(plane);
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

	


	static String getBucketNumber(ArrayList<Double> list1, ArrayList<Double> plane1,ArrayList<Double>plane2){
		int bucketBit1;
		int bucketBit2;
		String bucketNumber="";

		if(getJaccardIndex(list1,plane1)>0.2){
			bucketBit1=0b1;
		}else{
			bucketBit1=0b0;
		}

		if(getJaccardIndex(list1,plane2)>0.2){
			bucketBit2=1;
		}else{
			bucketBit2=0;
		}

		//getting the bucket number
		bucketBit1 <<= 1;
        bucketBit1 |= bucketBit2;
        bucketNumber=Integer.toString(bucketBit1,2);
        //System.out.println("******************>>>>>>>>The bucket number is : "+bucketNumber);
        return bucketNumber;
	}



	



	static void setUp(String fileName,ArrayList<Double> list) throws IOException{
			BufferedReader reader=null;
			String line="";
			int totalRecord=0;
			
			try{
				reader=new BufferedReader(new FileReader(fileName));
				line=reader.readLine();
			} catch (Exception e){
				System.out.println("File Not Found");
			}
						
						

						while(line!=null){
							totalRecord=totalRecord+1;
							String[] tokens=line.split(",");
							Record record1=new Record();
							record1.setSepalL(Float.parseFloat(tokens[0]));
							record1.setSepalW(Float.parseFloat(tokens[1]));
							record1.setPetalL(Float.parseFloat(tokens[2]));
							record1.setPetalW(Float.parseFloat(tokens[3]));
							record1.setCategory(tokens[4]);
							
							addPoint(list,Double.parseDouble(tokens[0]),Double.parseDouble(tokens[1]),
								Double.parseDouble(tokens[2]),Double.parseDouble(tokens[3]));


							//Hash function and hash table should be included
							//tlist.add(record1);
							String bnumber=getBucketNumber(list, plane1,plane2);
							System.out.println("Got bucket Number: "+bnumber); 
							if(bnumber.equals("0")){
								list00.add(record1);
								System.out.println("**********************************>>Inserted in 00 table ");
							} else if(bnumber.equals("1")){
								list01.add(record1);
								System.out.println("**********************************>>Inserted in 01 Table");
							} else if(bnumber.equals("10")){
								list10.add(record1);
								System.out.println("**********************************>>Inserted in 10 Table");
							} else if(bnumber.equals("11")){
								list11.add(record1);
								System.out.println("**********************************>>Inserted in 11 Table");
							}


							list.clear();
							line=reader.readLine();
										
							
						}//end of while
						reader.close();
	}//endof setup
	





	public static void main(String[] args){
		
	long startTime = System.currentTimeMillis();
	addPoint(plane1,4.9,3.86,1.73,1.28);
	addPoint(plane2,7.03,3.15,8.2,0.45);
	

	try	{
		setUp("train.txt",list1);
	} catch(Exception e){
		System.out.println("Something wrong in setup");
	}
		
		
	
		//addPoint(list1,1.1,2.2,3.3,4.4);
		
				
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		//System.out.println("Start time: "+startTime);
		System.out.println("End Time: "+endTime+"\nElapsedtime: "+totalTime);

	
	}//end of main method



}//end of class

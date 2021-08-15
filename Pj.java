import java.io.*;
//it use for date time 
import java.text.SimpleDateFormat;
 public class Pj{ 	
	public static void main(String[] args){ 
   //command line argument pasing 	
		String a = args[0]; 
//Convert the String to array that is taken as argument 		
		char[] words = a.toCharArray(); 
		System.out.println("\n" + "Volume in drive " + words[0] + " is Local Disk"); 
		System.out.println("Directory of " + a + "\n"); 
//create an object of SimpleDateFormat (special class)		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm"); 	
		long fileSize, size = 0; 
		int count = 0; 
		//using guider Block to detect & handle the exception
		try{
//create a file as parameterised argument 			
			File path1 = new File(a); 
//create an array to store the all file names			
			File[] files1 = path1.listFiles();
			//conditon for hte array is not contain in null value
			if(files1 != null && files1.length > 0)
			{
	//array travers in loop 
for(File f1 : files1){ 
 //to find main directory size		
fileSize = f1.length(); 
 //having file then nested 'if' condition				
if(f1.isFile()){ 
//if having file then it count				
count++; 		
//size of the each file 					
size += f1.length(); 		
// print the date and time of all files and also files name in tree structure 
System.out.println(dateFormat.format(f1.lastModified()) + "\t" + "\t" + " " + fileSize + "\t" + f1.getName()); 	
				} 
// having sub directory in same folder then condition will bw execuite				
				else if(f1.isDirectory()){ 
//same as print sub directory
System.out.println(dateFormat.format(f1.lastModified()) + "\t" + "<DIR>" + "\t" + "\t" + f1.getName()); 	
			} 		
			} 
//print size & total file			
System.out.println("\t" + "\t" + count + " File(s)" + "\t" + " " + size + " bytes");
          if(files1 != null && files1.length > 0)
               {	
		   // nested foreach loop 
			for(File f2 : files1){ 
			
				if(f2.isDirectory()){ 				
	System.out.println("\n" + "Directory of " + f2 + "\n");
	//store all directory name in string variable				
String s1 = f2.getName(); 
//concatenation the path as argument the string another variable				
String n1 = a.concat("\\"); 
//also concat the path and sub directory name 					
String sb1 = n1.concat(s1);
//create new file respective this path as parameter					
File path2 = new File(sb1); 	
//using arary to store the nested file / directory name					
File[] files2 = path2.listFiles();
long count1 = 0; 					
int size1 = 0; 
	//again condition 
   if(files2 != null && files2.length > 0)
                    {	
// foreach to travers and store the array in a variable 
for(File f3 : files2){ 	
// getting for size					
   fileSize = f3.length(); 
//having any nested file then					
	if(f3.isFile()){ 				
	count1++; 		
size1 += f3.length(); 	
System.out.println(dateFormat.format(f3.lastModified()) + "\t" + "\t" + " " + fileSize + "\t" + f3.getName()); 	
} 
//print date time and  name  					
else if(f3.isDirectory()){ 			
System.out.println(dateFormat.format(f3.lastModified()) + "\t" + "<DIR>" + "\t" + "\t" + f3.getName()); 	
} 				
} 	
   //finaly count all files and size 					
System.out.println("\t" + "\t" + count1 + " File(s)" + "\t" + " " + size1 + " bytes"); 	
} 			
} 	
} 
}}}
//if any exception occure then catch the exception and handle 
 catch(Exception e){ 		
 System.out.println(e); 	
 }}}

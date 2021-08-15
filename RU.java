 import java.io.File;
import java.io.*;
import java.text.SimpleDateFormat;

public class RU
  {
        
    public void show(File arr[])
      {
      try{
        //foreach loop for main diretory files
        for(File file:arr)
         {
           SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy   HH:mm");
				long bytes = file.length();
          if(file.isFile())
                 {
                    
             System.out.println(sdf.format(file.lastModified()) + "\t\t" + bytes + "\t" +file.getName());
           }
                           
        //have any directory then condition
         else if(file.isDirectory())
      {
          System.out.println(sdf.format(file.lastModified()) + "\t" +"<dir>" + "\t\t" + file.getName());
           }
		   }
         int count=0; 
          long size=0;
      
              for(File f:arr)
             {
                if(f.isFile())
                    {count++;
                        size+=f.length();
                }
            }
System.out.println("\t\t" + count + " File(s)" +  "\t\t" + size + " bytes");

		for( File f5 : arr){
			if(f5.isDirectory()){
				System.out.println("\n" + "Directory of " + f5 + "\n");
				
				show(f5.listFiles());
			}
			
		}
          
 }catch(Exception e)
      {System.out.println(e);}
    }

    public static void main(String args[]) 
       { 
          long result=0; 
             String user=args[0];
             String userin=args[1];
             String userinput = user + " " + userin;
              try{
        File maindir = new File(userinput);
           
           if(maindir.exists() && maindir.isDirectory())
                {
                         System.out.println("\n" + "Directory of " +maindir+ "\n");
                     
                       
                    
                    File[] arr1= maindir.listFiles();
                         
                    RU rufs = new RU();
                               rufs.show(arr1);
                    System.out.println("\n" + "Totlal Files Listed:");
                            
                        long freeSpace = 0;
                               long size=0;
                            for(File file:arr1)
                                 {
                          size+=file.length();
                         freeSpace=file.getFreeSpace();
                         }
                     System.out.println("\t\t" + " File(s)" + "\t\t" + size + " bytes");
					 System.out.println("\t\t" + "DIR" + "\t\t" + freeSpace + " bytes free");
      
               }}

            catch(Exception ex)
                      {System.out.println(ex);}
                    }
             }

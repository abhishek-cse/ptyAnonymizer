package sbi;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.protegrity.ap.java.Protector;
import com.protegrity.ap.java.ProtectorException;
import com.protegrity.ap.java.SessionObject;
public class FileProtection2 {

   public static void main1(String args[]) throws IOException, ProtectorException {
	  
	   String scanIn = ("D:\\Official\\Java\\data\\para.txt");
	   String scanOut = ("D:\\Official\\Java\\data\\SFTP_OUT.csv");
	      
	   String token1 = "";

	   Protector protector=null;
       try {
           protector=Protector.getProtector();

    } catch (ProtectorException e) {
           e.printStackTrace();
           throw e;
    }
       String deName="TE_AN_S13_L0R0_Y";
       String user = "USER1";
       
	    // for-each loop for calculating heat index of May - October

	    // create Scanner inFile1
	    Scanner inFile1 = new Scanner(new File(scanIn)).useDelimiter(",");

	    // Original answer used LinkedList, but probably preferable to use ArrayList in most cases
	    // List<String> temps = new LinkedList<String>();
	    List<String> temps = new ArrayList<String>();

	    // while loop
	    while (inFile1.hasNext()) {
	      // find next line
	      token1 = inFile1.next();
	      System.out.println("line"+token1);
	      temps.add(token1);
	    }
	    inFile1.close();

	    String[] tempsArray = temps.toArray(new String[0]);
	    String[] first_nameOutput=new String[tempsArray.length];

/*	    for (String s : tempsArray) {
	      System.out.println(s);
	    }
*/
		SessionObject session=protector.createSession(user);

		if (!protector.protect(session,deName , tempsArray,first_nameOutput))
            System.out.println("Protect api failed !!! \nError : "+protector.getLastError(session));
        //System.out.println("Printing protected output");
        	for (int i=0;i<first_nameOutput.length;i++) {
        	System.out.println((first_nameOutput[i]));	      
        }
	     
   }
}


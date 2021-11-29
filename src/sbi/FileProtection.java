package sbi;

import java.io.BufferedWriter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

//import com.opencsv.CSVParserWriter;
import com.protegrity.ap.java.Protector;
import com.protegrity.ap.java.ProtectorException;
import com.protegrity.ap.java.SessionObject;

import org.neo4j.procedure.Name;


public class FileProtection {


		public static void main(String[] args) throws FileNotFoundException, IOException, ProtectorException {

			//String scanIn = new String(args[0]).toString();
			//System.out.println(scanIn);
			String scanIn = new String();	
			scanIn = ("D:\\Official\\Java\\data\\abc.txt");
			System.out.println(scanIn);
			String scanOut = new String(args[0]).toString();
			System.out.println("     "+scanOut);
			
			
			System.out.println("*******");

			int line_count = Integer.parseInt(args[2]);

	       	Protector protector=null;
	        try {
	            protector=Protector.getProtector();

	     } catch (ProtectorException e) {
	            e.printStackTrace();
	            throw e;
	     }
	        String deName="TE_AN_S13_L0R0_Y";
	        String deAccountNumber = "TE_AN_S13_L0R0_Y";
	        String deAadharCard = "TE_AN_S13_L0R0_Y";
	        String deEmail = "TE_AN_S13_L0R0_Y";
	        String user= "USER1";
	        
//	        int line_count = Integer.parseInt(args[0]);
	        //int line_count = 3000001;
			//Create the CSVFormat object
			CSVFormat format = CSVFormat.RFC4180.withHeader().withDelimiter(',');
			
			//initialize the CSVParser object
			//CSVParser parser = new CSVParser(new FileReader("D:\\Official\\Java\\AP_java\\src\\SFTP_NEW.csv"), format);
			//CSVParser parser = new CSVParser(new FileReader("/opt/data/SFTP_NEW.csv"), format);
			CSVParser parser = new CSVParser(new FileReader(scanIn), format);

			//ID
			//String[] id_arr = new String[line_count];
			String[] first_name_arr = new String[line_count];
			String[] last_name_arr = new String[line_count];
			String[] city_arr = new String[line_count];
			String[] address_arr = new String[line_count];
			String[] dob_arr = new String[line_count];
			String[] accountnumber_arr = new String[line_count];
			String[] cardtype_arr = new String[line_count];
			String[] aadhar_card_arr = new String[line_count];
			String[] job_arr = new String[line_count];
			String[] email_arr = new String[line_count];
			String[] phonenumber_arr = new String[line_count];
			String[] country_arr = new String[line_count];
			List<Employee> emps = new ArrayList<Employee>();
			
			for(CSVRecord record : parser){
				Employee emp = new Employee();

				//id_arr[(int)record.getRecordNumber()-1] = record.get("FIRST_NAME");
				first_name_arr[(int)record.getRecordNumber()-1] = record.get("FIRST_NAME");  //protect
				last_name_arr[(int)record.getRecordNumber()-1] = record.get("LAST_NAME");  
							
				city_arr[(int)record.getRecordNumber()-1] = record.get("CITY");
				address_arr[(int)record.getRecordNumber()-1] = record.get("ADDRESS");
				dob_arr[(int)record.getRecordNumber()-1] = record.get("DOB");
				accountnumber_arr[(int)record.getRecordNumber()-1] = record.get("ACCOUNTNUMBER"); //protect
				cardtype_arr[(int)record.getRecordNumber()-1] = record.get("CARDTYPE");
				aadhar_card_arr[(int)record.getRecordNumber()-1] = record.get("AADHAR_CARD"); //protect
				job_arr[(int)record.getRecordNumber()-1] = record.get("JOB");
				email_arr[(int)record.getRecordNumber()-1] = record.get("EMAIL");    //protect
				phonenumber_arr[(int)record.getRecordNumber()-1] = record.get("PHONENUMBER");
				country_arr[(int)record.getRecordNumber()-1] = record.get("COUNTRY");
		        }
			
			//Columns to be protected 
			String[] first_nameOutput=new String[first_name_arr.length];
			//System.out.println(first_name_arr.length);
			String[] accountNumberOutput=new String[accountnumber_arr.length];
			String[] aadharCardOutput=new String[aadhar_card_arr.length];
			String[] emailOutput=new String[email_arr.length];


			SessionObject session=protector.createSession(user);

			if (!protector.protect(session,deName , first_name_arr,first_nameOutput))
                System.out.println("Protect api failed !!! \nError : "+protector.getLastError(session));
	        //System.out.println("Printing protected output");
	        	for (int i=0;i<first_nameOutput.length;i++) {
	        	//System.out.println("Raw value:	"+(first_nameOutput[i]));	      
	        }
		    
	        
	        if (!protector.protect(session,deAccountNumber , accountnumber_arr,accountNumberOutput))
	                System.out.println("Protect api failed !!! \nError : "+protector.getLastError(session));
		        //System.out.println("Printing protected output");
		        for (int j=0;j<accountNumberOutput.length;j++) {
		       	//System.out.println("Raw value:	"+(accountNumberOutput[j]));	               
	        }
	       
		    if (!protector.protect(session,deAadharCard , aadhar_card_arr,aadharCardOutput))
	                System.out.println("Protect api failed !!! \nError : "+protector.getLastError(session));
		        //System.out.println("Printing protected output");
		        for (int j=0;j<aadharCardOutput.length;j++) {
		       	//System.out.println("Raw value:	"+(aadharCardOutput[j]));	               
	        }

			if (!protector.protect(session,deEmail , email_arr,emailOutput))
	                System.out.println("Protect api failed !!! \nError : "+protector.getLastError(session));
		        //System.out.println("Printing protected output");
		        for (int j=0;j<emailOutput.length;j++) {
		       	//System.out.println("Raw value:	"+(emailOutput[j]));	               
	        }
		        


	        
			//close the parser*/
	        parser.close();
	        
	        //final String SAMPLE_CSV_FILE = "D:\\Official\\Java\\AP_java\\src\\bcd.txt";
	        //final String SAMPLE_CSV_FILE = 	"/opt/data/SFTP_OUT.csv";
	        
	        final String SAMPLE_CSV_FILE = 	 scanOut;
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(SAMPLE_CSV_FILE));

			//CSVPrinter printer = new CSVPrinter(System.out, format.withDelimiter('#'));
            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
            		.withHeader("FIRST_NAME", "LAST_NAME", "CITY", "ADDRESS", "DOB", "ACCOUNTNUMBER", "CARDTYPE", "AADHAR_CARD", "JOB", "EMAIL", "PHONENUMBER", "COUNTRY"));
			System.out.println("********");
			//csvPrinter.printRecord("FIRST_NAME", "LAST_NAME", "CITY", "ADDRESS", "DOB", "ACCOUNTNUMBER", "CARDTYPE", "AADHAR_CARD", "JOB", "EMAIL", "PHONENUMBER", "COUNTRY");
	        for (int j=0;j<line_count/3;j++) {
				csvPrinter.printRecord(first_nameOutput[j], last_name_arr[j], city_arr[j], address_arr[j], dob_arr[j], 
						accountNumberOutput[j], cardtype_arr[j], aadharCardOutput[j], job_arr[j], emailOutput[j], 
						phonenumber_arr[j], country_arr[j]);
				csvPrinter.flush();

			
	        }
	        for (int j=(line_count/3);j<(line_count/3)*2;j++) {
				csvPrinter.printRecord(first_nameOutput[j], last_name_arr[j], city_arr[j], address_arr[j], dob_arr[j], 
						accountNumberOutput[j], cardtype_arr[j], aadharCardOutput[j], job_arr[j], emailOutput[j], 
						phonenumber_arr[j], country_arr[j]);
				csvPrinter.flush();

			
	        }
	        for (int j=(line_count/3)*2;j<line_count;j++) {
				csvPrinter.printRecord(first_nameOutput[j], last_name_arr[j], city_arr[j], address_arr[j], dob_arr[j], 
						accountNumberOutput[j], cardtype_arr[j], aadharCardOutput[j], job_arr[j], emailOutput[j], 
						phonenumber_arr[j], country_arr[j]);
				csvPrinter.flush();

			
	        }
	        

			
	        
		}
		



}

package sbi;

import java.util.Collection;

public class Employee {

	private String[] FIRST_NAME;
	private String[] LAST_NAME;
	private String[] CITY;
	private String[] ADDRESS;
	private String[] DOB;
	private String[] ACCOUNTNUMBER;
	private String[] CARDTYPE;
	private String[] AADHAR_CARD;
	private String[] JOB;
	private String[] EMAIL;
	private String[] PHONENUMBER;
	private String[] COUNTRY;
		
	
	public String[] getFIRST_NAME() {
		return FIRST_NAME;
	}
	public String[] setFIRST_NAME(String[] FIRST_NAME) {
		this.FIRST_NAME = FIRST_NAME;
		return FIRST_NAME;
	}
/*	public String[] setFIRST_NAME(String string) {
		// TODO Auto-generated method stub
		return null;
	}*/
	
	public String[] getLAST_NAME() {
		return LAST_NAME;
	}
	public void setLAST_NAME(String[] lAST_NAME) {
		LAST_NAME = lAST_NAME;
	}
	public String[] getCITY() {
		return CITY;
	}
	
	public void setCITY(String[] cITY) {
		CITY = cITY;
	}
	
	public String[] getADDRESS() {
		return ADDRESS;
	}
	
	public void setADDRESS(String[] aDDRESS) {
		ADDRESS = aDDRESS;
	}
	
	public String[] getDOB() {
		return DOB;
	}
	
	public void setDOB(String[] dOB) {
		DOB = dOB;
	}
	
	public String[] getACCOUNTNUMBER() {
		return ACCOUNTNUMBER;
	}
	
	public void setACCOUNTNUMBER(String[] aCCOUNTNUMBER) {
		ACCOUNTNUMBER = aCCOUNTNUMBER;
	}
	
	
	public String[] getCARDTYPE() {
		return CARDTYPE;
	}
	public void setCARDTYPE(String[] cARDTYPE) {
		CARDTYPE = cARDTYPE;
	}
	
	
	public String[] getAADHAR_CARD() {
		return AADHAR_CARD;
	}
	public void setAADHAR_CARD(String[] aADHAR_CARD) {
		AADHAR_CARD = aADHAR_CARD;
	}
	
	
	public String[] getJOB() {
		return JOB;
	}
	public void setJOB(String[] jOB) {
		JOB = jOB;
	}
	
	
	public String[] getEMAIL() {
		return EMAIL;
	}
	public void setEMAIL(String[] eMAIL) {
		EMAIL = eMAIL;
	}
	
	
	public String[] getPHONENUMBER() {
		return PHONENUMBER;
	}
	public void setPHONENUMBER(String[] pHONENUMBER) {
		PHONENUMBER = pHONENUMBER;
	}
	
	
	public String[] getCOUNTRY() {
		return COUNTRY;
	}
	public void setCOUNTRY(String[] cOUNTRY) {
		COUNTRY = cOUNTRY;
	}


	
	@Override
	public String toString(){
		//return "FIRST_NAME="+FIRST_NAME+",Name="+name+",Role="+role+",Salary="+salary+"\n";
		return null;
	}
}

//FIRST_NAME,LAST_NAME,CITY,ADDRESS,DOB,ACCOUNTNUMBER,CARDTYPE,AADHAR_CARD,JOB,EMAIL,PHONENUMBER,COUNTRY

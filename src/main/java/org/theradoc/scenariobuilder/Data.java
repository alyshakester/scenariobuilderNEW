package org.theradoc.scenariobuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
//import org.apache.commons.io.FileUtils;

import org.apache.commons.io.FileUtils;

public class Data {
	static String[] mshArray = new String[12];
	static String[] pidArray = new String[31];
	static String[] pv1Array = new String[53];
	
	static String readHL7Template() throws IOException
	{
		InputStream in = Data.class.getResourceAsStream("adtTemplate.txt");
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		mshArray = reader.readLine().split("\\|", -1);
		pidArray = reader.readLine().split("\\|", -1);
		pv1Array = reader.readLine().split("\\|", -1);
		//Debug code to view strings in HL7 Array
//		int i = 0;
//		for(String s : mshArray)
//		{
//			System.out.println(i + ") " + s);
//			i++;
//		}
//		i = 0;
//		for(String s : pidArray)
//		{
//			System.out.println(i + ") " + s);
//			i++;
//		}
//		i = 0;
//		for(String s : pv1Array)
//		{
//			System.out.println(i + ") " + s);
//			i++;
//		}
		reader.close();
		String mshLine = rebuildString(mshArray);
		String pidLine = rebuildString(pidArray);
		String pv1Line = rebuildString(pv1Array);
		String hl7message = mshLine + "\n" + pidLine + "\n" + pv1Line;
		return hl7message;
	}
	
	//when click load from adt it compiles the hl7 taking fields and separating with pipes
	static String compileHL7()
	{
		mshArray[6] = checkDate(mshArray[6]);
		pv1Array[44] = checkDate(pv1Array[44]);
		String mshLine = rebuildString(mshArray);
		String pidLine = rebuildString(pidArray);
		String pv1Line = rebuildString(pv1Array);
		String hl7String = mshLine + "\r\n" + pidLine + "\r\n" + pv1Line;
		return hl7String;
	}
	static String compileMicroHeader()
	{
		mshArray[2] = "MIC";
		mshArray[3] = "ARUP";
		mshArray[4] = "";
		mshArray[8] = "ORU^R01";
		mshArray[6] = checkDate(mshArray[6]);
		pv1Array[44] = checkDate(pv1Array[44]);
		String mshLine = rebuildString(mshArray);
		String pidLine = rebuildString(pidArray);
		String pv1Line = rebuildString(pv1Array);
		String hl7String = mshLine + "\r\n" + pidLine + "\r\n" + pv1Line;
		return hl7String;
	}
	
	public static String createSurgery(String[] fileArray, String workingDirectory) throws FileNotFoundException 
	{
		DateFormat dateFormat = new SimpleDateFormat("MMdd");
		Date date = new Date();		
		String fileName = "surg2009" + dateFormat.format(date) + ".txt";
		PrintWriter writer = new PrintWriter(workingDirectory + "\\" + fileName);
		writer.println("MRN,Account_number,family_name,given_name,or_location,case_date,Start,Stop,Surgeon,Procedure,ASACode,WoundClass,Surgery_Type,Misc,TestField,Notused,facility_code,nhsn_cat,surg_code,Anesthesiologist,Surgery_service,SurgeonCode,AnethesiologistCode,surgery_future1,pat_class,point_of_care,room,bed,admit_date,disharge_date,encounter_future1,encounter_future2,encounter_future3,encounter_future4,Diabetes Mellitus,Height,Height Unit,Weight,Weight Unit,Outpatient,Emergency,General Anesthesia,trauma,Endoscope,Multiple Procedures,Implant,Transplant,Transplant Autologous,Primary Closure,Duration of Labor,Estimated Blood Loss,Spinal level,Approach/technique,Hip Replancement,Knee replancement");
		for(int i = 0; i < 55; i++)
		{
			writer.print(fileArray[i]);
			if(i < 54)
				writer.print(",");
		}
		writer.close();		
		return fileName;
	}
	
	public static void bulkSurgery(String parseDirectory) throws IOException, SQLException, ClassNotFoundException 
	{
		Database.connectToDB();
		if(Database.checkDBForPatient(CSVReader.readFirstRowFromCSV()) == true)
		{
			InputStream in = Data.class.getResourceAsStream("/scenarioBuilder/src/main/java/org/theradoc/scenariobuilder/surg20091023.csv");
			File dest = new File(parseDirectory + "/surg20091023.csv");
			FileUtils.copyInputStreamToFile(in, dest);
		} 
	}
	
	public static String spinTheWheel(String patId) {
		try
		{
			char i = patId.charAt(8);
			switch(i)
			{
			case '1': patId = "2-" + patId;
					break;
			case '2': patId = "2-" + patId;
					break;
			case '3': patId = "2-" + patId;
					break;
			case '4': patId = "3-" + patId;
					break;
			case '5': patId = "3-" + patId;
					break;
			case '6': patId = "3-" + patId;
					break;
			case '7': patId = "3-" + patId;
					break;
			case '8': patId = "4-" + patId;
					break;
			case '9': patId = "4-" + patId;
					break;
			case '0': patId = "4-" + patId;
					break;
			default: patId = "4-" + patId;
					break;
			}
		} catch (Exception e) 
		{
			System.err.println("Unable to determine institution");
		}
		System.out.println("New patId - " + patId);
		return patId;
	}
	
	static void createADTFile(String patient, String adt, String workingDirectory) throws FileNotFoundException 
	{
		PrintWriter writer = new PrintWriter(workingDirectory + "\\ADT - " + patient);
		writer.println(adt);
		writer.close();
	}
	
	static String formatDate(String dateStr) throws ParseException
	{
		String[] newDate = dateStr.split("/");
		if(newDate[1].length() < 2)
			newDate[1] = "0" + newDate[1];
		if(newDate[0].length() < 2)
			newDate[0] = "0" + newDate[0];
		dateStr = newDate[2] + newDate[0] + newDate[1];
		return dateStr;
	}
	
	static String rebuildString(String[] array) 
	{
		StringBuilder builder = new StringBuilder();
		for(String s : array) {
			builder.append(s + "|");
		}
		return builder.toString();
	}
	
	public static String[] getMshArray() {
		return mshArray;
	}

	public static void setMshArray(String[] mshArray) {
		Data.mshArray = mshArray;
	}

	public static String[] getPidArray() {
		return pidArray;
	}

	public static void setPidArray(String[] pidArray) {
		Data.pidArray = pidArray;
	}

	public static String[] getPv1Array() {
		return pv1Array;
	}

	public static void setPv1Array(String[] pv1Array) {
		Data.pv1Array = pv1Array;
	}
	public static String[] getOBRArray() {
		return Micro.obrArray;
	}
	public static String[] getOBXArray() {
		return MainWindow.obxArray;
	}
	public static String checkDate(String dateStr) {
		if(dateStr.length() < 9)
			dateStr = dateStr + "0800";
		return dateStr;
	}
}

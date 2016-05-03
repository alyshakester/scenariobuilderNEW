package org.theradoc.scenariobuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.text.ParseException;

public class CSVReader {
	
	public static int readFile() throws IOException, ClassNotFoundException, SQLException, ParseException 
	{
		InputStream in = Data.class.getResourceAsStream("ADT.csv");
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String line = "";
		//Skips column names in CSV
		reader.readLine();
		int count = 0;
		while((line = reader.readLine()) != null)
		{
			Data.readHL7Template();
			String[] rowArray = line.split(",");
			if(rowArray[9].contains("/"))
				Data.mshArray[6] = Data.formatDate(rowArray[9]);
			else
				Data.mshArray[6] = rowArray[9];
			Data.mshArray[8] = rowArray[11];
			Data.pidArray[3] = rowArray[0];
			Data.pidArray[5] = rowArray[2] + "^" + rowArray[3];
			Data.pidArray[7] = rowArray[5];
			Data.pidArray[8] = rowArray[4];
			Data.pidArray[18] = rowArray[0];
			Data.pv1Array[3] = rowArray[6] + "^" + rowArray[7] + "^" + rowArray[8];
			if(rowArray[10].isEmpty())
			{
				if(rowArray[9].contains("/"))
					Data.pv1Array[44] = Data.formatDate(rowArray[9]);
				else
					Data.pv1Array[44] = rowArray[9];
			} else
			{
				if(rowArray[10].contains("/"))
					Data.pv1Array[44] = Data.formatDate(rowArray[10]);
				else
					Data.pv1Array[44] = rowArray[10];
			}
				
			String message = Data.compileHL7();
//			System.out.println(message);
			Database.connectToDB();
			Database.insertADTRecord(message);
			count++;
		}
		return count;
	}
	
	@SuppressWarnings("resource")
	public static int readCustomFile(File file) throws ClassNotFoundException, UnknownHostException, IOException, ParseException, SQLException
	{
		int count = 0;
		String line = "";
		BufferedReader reader = new BufferedReader(new FileReader(file));
		while((line = reader.readLine()) != null)
		{
			Data.readHL7Template();
			String[] rowArray = line.split(",");
			Data.mshArray[6] = Data.formatDate(rowArray[9]);
			Data.mshArray[8] = "ADT^A01";
			Data.pidArray[3] = rowArray[0];
			Data.pidArray[5] = rowArray[2] + "^" + rowArray[3];
			Data.pidArray[7] = rowArray[5];
			Data.pidArray[8] = rowArray[4];
			Data.pidArray[18] = rowArray[0];
			Data.pv1Array[3] = rowArray[6] + "^" + rowArray[7] + "^" + rowArray[8];
			Data.pv1Array[44] = Data.formatDate(rowArray[9]);
			String message = Data.compileHL7();
//			System.out.println(message);
			Database.connectToDB();
			Database.insertADTRecord(message);
			count++;
		}
		return count;
	}
	
	public static String readFirstRowFromCSV() throws IOException
	{
		String patientMRN = null;
		InputStream in = Data.class.getResourceAsStream("surg20091023.csv");
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String line = "";
		//Skips column names in CSV
		reader.readLine();
		line = reader.readLine();
		String[] rowArray = line.split(",");
		patientMRN = rowArray[0];
		return patientMRN;
	}
	
	public static void appendInstitution() throws IOException 
	{
		InputStream in = Data.class.getResourceAsStream("surg20091023.csv");
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		
		FileWriter writer = new FileWriter("surgeries.csv");
		String[] rowArray = null;
		String line = "";
		//Skips column names in CSV
		reader.readLine();
		try
		{
			while((line = reader.readLine()) != null)
			{
				rowArray = line.split(",");
				rowArray[0] = Data.spinTheWheel(rowArray[0]);
//				rowArray[0] = "BD" + rowArray[0];
//				rowArray[0] = checkMRNLength(rowArray[0]);
				
				writer.append(rowArray[0]);
				writer.append(',');
				writer.append(rowArray[1]);
				writer.append(',');
				writer.append(rowArray[2]);
				writer.append(',');
				writer.append(rowArray[3]);
				writer.append(',');
				writer.append(rowArray[4]);
				writer.append("\n");
				
			}
		} catch (NullPointerException e) 
		{
			System.out.println(rowArray[0]);
			e.printStackTrace();
		}
		
		writer.flush();
		writer.close();
	}
	
	static String checkMRNLength(String mrn) {
		while(mrn.length() < 9)
			mrn = mrn + "0";
		return mrn;
	}
}
package org.theradoc.scenariobuilder;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class Micro {
	private static String[] mshArray;
	private static String[] pidArray;
	private static String[] pv1Array;
	static String[] orcArray;
	private static int fileRowCount;
	private static ArrayList<String> fullMicroArray = new ArrayList<String>();
	@SuppressWarnings("unused")
	private static ArrayList<String> obrArrayMessage = new ArrayList<String>();
	private static int obrCount;
	private static ArrayList<String> obr1 = new ArrayList<String>();
	private static ArrayList<String> obr2 = new ArrayList<String>();
	private static ArrayList<String> obr3 = new ArrayList<String>();
	private static ArrayList<String> obr4 = new ArrayList<String>();
	private static ArrayList<String> obr5 = new ArrayList<String>();
	private static ArrayList<String> obr6 = new ArrayList<String>();
	private static ArrayList<String> obr7 = new ArrayList<String>();
	private static ArrayList<String> obr8 = new ArrayList<String>();
	private static ArrayList<String> obr9 = new ArrayList<String>();
	private static ArrayList<String> obr10 = new ArrayList<String>();
	private static ArrayList<String> obrList = new ArrayList<String>();
	static String[] obrArray = new String[43];
	private static ArrayList<String> obxList = new ArrayList<String>();
	static String obrlist = obrList.toString().substring(1).replaceAll(", O", "\r\nO");
	static String obrS = obrlist.replaceAll("]", "");

	static String readMicroTemplate(String fileName, boolean microHeaderPresent) throws IOException {
		String hl7message = null;
		InputStream in = Data.class.getResourceAsStream(fileName);
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		if (microHeaderPresent) {
			hl7message = Data.compileMicroHeader();
			// skip the first 3 lines for MSH PID and PV1 from Micro message
			// template
			reader.readLine();
			reader.readLine();
			reader.readLine();
			orcArray = reader.readLine().split("\\|", -1);
		} else {
			mshArray = reader.readLine().split("\\|", -1);
			pidArray = reader.readLine().split("\\|", -1);
			pv1Array = reader.readLine().split("\\|", -1);
			orcArray = reader.readLine().split("\\|", -1);
			// obrArray1 = reader.readLine().split("\\|", -1);
			// Debug code to view strings in HL7 Array
			// int i = 0;
			// for(String s : mshArray)
			// {
			// System.out.println(i + ") " + s);
			// i++;
			// }
			// for(String s : pidArray)
			// {
			// System.out.println(i + ") " + s);
			// i++;
			// }
			// for(String s : pv1Array)
			// {
			// System.out.println(i + ") " + s);
			// i++;
			// }
			// for(String s : orcArray)
			// {
			// System.out.println(i + ") " + s);
			// i++;
			// }
			// for(String s : obrArray)
			// {
			// System.out.println(i + ") " + s);
			// i++;
			// }

			String mshLine = Data.rebuildString(mshArray);
			String pidLine = Data.rebuildString(pidArray);
			String pv1Line = Data.rebuildString(pv1Array);
			hl7message = mshLine + "\n" + pidLine + "\n" + pv1Line;

		}
		reader.close();
		return hl7message;
	}

	public static void getFullMicroArray(String fileName) throws IOException {
		InputStream in = Data.class.getResourceAsStream(fileName);
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		for (@SuppressWarnings("unused")
		int i = 0; reader.readLine() != null; i++) {
			fileRowCount++;
		}
		reader.close();
		InputStream in2 = Data.class.getResourceAsStream(fileName);
		BufferedReader reader2 = new BufferedReader(new InputStreamReader(in2));
		for (int j = 0; j < fileRowCount; j++) {
			fullMicroArray.add(reader2.readLine());
		}
		reader2.close();

		// System.out.println(fullMicroArray);
	}

	public static void clearMicroArray() {
		fullMicroArray.clear();
		@SuppressWarnings("unused")
		int returnSize = fullMicroArray.size();
		// System.out.println("size of full array" + returnSize);
		obrCount = 0;
		fileRowCount = 0;
		// obr List
		obrList.removeAll(obrList);
		obr1.removeAll(obr1);
		obr2.removeAll(obr2);
		obr3.removeAll(obr3);
		obr4.removeAll(obr4);
		obr5.removeAll(obr5);
		obr6.removeAll(obr6);
		obr7.removeAll(obr7);
		obr8.removeAll(obr8);
		obr9.removeAll(obr9);
		obr10.removeAll(obr10);
		// obx List
		obxList.removeAll(obxList);
		// check for straggling info
		// System.out.println("File row count" + fileRowCount);
		// System.out.println("obr list" + obrList);
		// System.out.println("obx list" + obxList);

	};

	// Populating the OBR number in dropdown
	public static JComboBox<String> populateOBRDropdown(JComboBox<String> obrDD) {
		for (int i = 0; i < fullMicroArray.size(); i++) {
			if (fullMicroArray.get(i).substring(0, fullMicroArray.get(i).indexOf("|")).equals("OBR")) {
				i++;
				obrCount++;
				obrDD.addItem("OBR " + obrCount);
				// System.out.println(obrDD);
			}
		}
		return obrDD;
	}


	// Populating the OBX number for the OBR selected in the drop down
	public static void populateOBXDropdown(Object object, JComboBox<String> obxDD) {
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
		obxDD.setModel(model);
		switch (object.toString()) {
		case "OBR 1":
			for (String s : obr1) {
				int firstPipe = s.indexOf("|");
				int secondPipe = s.indexOf("|", firstPipe + 1);
				if (s != null)
					obxDD.addItem("OBX " + s.substring(firstPipe + 1, secondPipe));
			}
			break;
		case "OBR 2":
			for (String s : obr2) {
				int firstPipe = s.indexOf("|");
				int secondPipe = s.indexOf("|", firstPipe + 1);
				if (s != null)
					obxDD.addItem("OBX " + s.substring(firstPipe + 1, secondPipe));
			}
			break;
		case "OBR 3":
			for (String s : obr3) {
				int firstPipe = s.indexOf("|");
				int secondPipe = s.indexOf("|", firstPipe + 1);
				if (s != null)
					obxDD.addItem("OBX " + s.substring(firstPipe + 1, secondPipe));
			}
			break;
		case "OBR 4":
			for (String s : obr4) {
				int firstPipe = s.indexOf("|");
				int secondPipe = s.indexOf("|", firstPipe + 1);
				if (s != null)
					obxDD.addItem("OBX " + s.substring(firstPipe + 1, secondPipe));
			}
			break;
		case "OBR 5":
			for (String s : obr5) {
				int firstPipe = s.indexOf("|");
				int secondPipe = s.indexOf("|", firstPipe + 1);
				if (s != null)
					obxDD.addItem("OBX " + s.substring(firstPipe + 1, secondPipe));
			}
			break;
		}
	}

	public static ArrayList<String> currentOBR(Object object) {
		ArrayList<String> selectedArray = null;
		switch (object.toString()) {
		case "OBR 1":
			selectedArray = obr1;
			break;
		case "OBR 2":
			selectedArray = obr2;
			break;
		case "OBR 3":
			selectedArray = obr3;
			break;
		case "OBR 4":
			selectedArray = obr4;
			break;
		case "OBR 5":
			selectedArray = obr5;
			break;
		case "OBR 6":
			selectedArray = obr6;
			break;
		case "OBR 7":
			selectedArray = obr7;
			break;
		case "OBR 8":
			selectedArray = obr8;
			break;
		case "OBR 9":
			selectedArray = obr9;
			break;
		case "OBR 10":
			selectedArray = obr10;
			break;
		}
		return selectedArray;
	}

	public static void populateOBRList() {
		for (int i = 0; i < fullMicroArray.size(); i++) {
			// System.out.println(fullMicroArray.get(i));
			if (fullMicroArray.get(i).substring(0, fullMicroArray.get(i).indexOf("|")).equals("OBR")) {
				obrList.add(fullMicroArray.get(i));
			}
		}
	}

	public static void initialOBR() {
		for (String s : obrList)
			obrArray = (obrList.toString().split("\\|", -1));
	}

	public static void getCurrentOBRSegments(JComboBox<String> comboOBR) {
		obrArray = obrList.get(comboOBR.getSelectedIndex()).split("\\|", -1);
		// Debug code to view array elements
		// int i = 0;
		// for(String s : obrArray)
		// {
		// System.out.println(i + ") " + s);
		// i++;
		// }
	}

	// obr lines store the OBX lines belonging to that OBR.
	public static void populateOBXList() {
		for (int i = 0; i < fullMicroArray.size(); i++) {
			if (fullMicroArray.get(i).substring(0, fullMicroArray.get(i).indexOf("|")).equals("OBX")) {
				obxList.add(fullMicroArray.get(i));
			}
		}
		// for(String s : obxList)
		// System.out.println(s);
		splitOBXList(obr1);
		splitOBXList(obr2);
		splitOBXList(obr3);
		splitOBXList(obr4);
		splitOBXList(obr5);
		splitOBXList(obr6);
		splitOBXList(obr7);
		splitOBXList(obr8);
		splitOBXList(obr9);
		splitOBXList(obr10);
	}

	public static void splitOBXList(ArrayList<String> obr) {
		int currentNumber = 0;
		int obxNum;
		for (int i = 0; obxList.size() != 0; i++) {
			int firstPipe = obxList.get(0).indexOf("|");
			int secondPipe = obxList.get(0).indexOf("|", firstPipe + 1);
			// System.out.println(obxList);
			// System.out.println("First pipe: " + firstPipe + " - Second pipe:
			// " + secondPipe);
			obxNum = Integer.parseInt(obxList.get(0).substring(firstPipe + 1, secondPipe));
			if (obxNum > currentNumber) {
				obr.add(i, obxList.get(0));
				obxList.remove(0);
				currentNumber = obxNum;
			} else {
				return;
			}
		}
	}

	public static void saveOBRChanges(String obrSelection) {
		String obrStr = Data.rebuildString(obrArray);
		obrList.set(Integer.parseInt(obrSelection.substring(obrSelection.indexOf(" ") + 1)) - 1, obrStr);
	}

	public static void saveOBXChanges(String obxSelection) {
		String obxStr = Data.rebuildString(MainWindow.obxArray);
		obxList.set(Integer.parseInt(obxSelection.substring(obxSelection.indexOf(" ") + 1)) - 1, obxStr);
	}

	// adds OBR lines to obrList
	public static void addOBR() {
		obrList.add("OBR|" + (obrCount + 1) + "||||||||||||||||||||||||||||||||||||||||||");
		obrCount++;
		// obrArray = new String[43];
		// obrArray[0] = String.valueOf(obrCount + 1);
	}

	// Grabbing obr array stuff and parsing

	public static <Arraylist> String getArrayforOBR() {
		String obrlist = obrList.toString().substring(1).replaceAll("], O", "\r\nO");
		//String obrlistClean = obrlist.replaceAll("[", "");
		String obrS = obrlist.replace("]", "");
		String obxPull1 = obr1.toString().substring(1).replaceAll(", O", "\r\nO");
		String obx1 = obxPull1.replaceAll("]", "");
		String obxPull2 = obr2.toString().substring(1).replaceAll(", O", "\r\nO");
		String obx2 = obxPull2.replaceAll("]", "");
		String obxPull3 = obr3.toString().substring(1).replaceAll(", O", "\r\nO");
		String obx3 = obxPull3.replaceAll("]", "");
		String obxPull4 = obr4.toString().substring(1).replaceAll(", O", "\r\nO");
		String obx4 = obxPull4.replaceAll("]", "");
		String obxPull5 = obr5.toString().substring(1).replaceAll(", O", "\r\nO");
		String obx5 = obxPull5.replaceAll("]", "");
		String obxPull6 = obr6.toString().substring(1).replaceAll(", O", "\r\nO");
		String obx6 = obxPull6.replaceAll("]", "");
		String obxPull7 = obr7.toString().substring(1).replaceAll(", O", "\r\nO");
		String obx7 = obxPull7.replaceAll("]", "");
		String obxPull8 = obr8.toString().substring(1).replaceAll(", O", "\r\nO");
		String obx8 = obxPull8.replaceAll("]", "");
		String obxPull9 = obr9.toString().substring(1).replaceAll(", O", "\r\nO");
		String obx9 = obxPull9.replaceAll("]", "");
		String obxPull10 = obr10.toString().substring(1).replaceAll(", O", "\r\nO");
		String obx10 = obxPull10.replaceAll("]", "");
		String obrAndObxString = obrS + "\r\n" + obx1.replace("[", "").trim() + "\r\n" + obx2.replace("[", "").trim()
				+ "\r\n" + obx3.replace("[", "").trim() + "\r\n" + obx4.replace("[", "").trim() + "\r\n"
				+ obx5.replace("[", "").trim() + "\r\n" + obx6.replace("[", "").trim() + "\r\n"
				+ obx7.replace("[", "").trim() + "\r\n" + obx8.replace("[", "").trim() + "\r\n"
				+ obx9.replace("[", "").trim() + "\r\n" + obx10.replace("[", "").trim() + "\r\n";
		String obrAndObxStringCleaned = obrAndObxString.substring(0).replaceAll(", O", "\r\nO");
		return obrAndObxStringCleaned;
	}

	public static String compileMicro() {
		if (Data.compileMicroHeader().isEmpty()) {
			String mshLine = Data.rebuildString(mshArray);
			String pidLine = Data.rebuildString(pidArray);
			String pv1Line = Data.rebuildString(pv1Array);
			String orcLine = Data.rebuildString(orcArray);
			String hl7String = mshLine + "\r\n" + pidLine + "\r\n" + pv1Line + "\r\n" + orcLine;
			return hl7String;
		} else {
			String microHeaderADT = Data.compileMicroHeader();
			String orcLine = Data.rebuildString(orcArray);
			return microHeaderADT + "\r\n" + orcLine;
		}
		// String obrListing = obrList.toString();
		// String obxLine1 = obr1.toString();
		// String obxLine2 = obr2.toString();
		// String obxLine3 = obr3.toString();
		// String obxLine4 = obr4.toString();
		// String obxLine5 = obr5.toString();
		// String obxLine6 = obr6.toString();
		// Need to logically split each line to OBR1 OBR2 and OBX1 OBX2 etc

	}

	public static void createMicroFile(String organism, String micro, String workingDirectory)
			throws FileNotFoundException {
		PrintWriter writer = new PrintWriter(workingDirectory + "\\" + organism + ".txt");
		writer.println(compileMicro() + "\r\n" + getArrayforOBR());
		writer.close();
		Component compileMicro = null;
		JOptionPane.showMessageDialog(compileMicro, "Your file has been downloaded to " + workingDirectory);
	}
}

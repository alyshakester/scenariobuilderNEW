package org.theradoc.scenariobuilder;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Scrollbar;

public class MainWindow {

	private JFrame frmScenarioBuilder;
	private JTextField tfSurgeryMRN;
	private JTextField tfSurgeryAccountNumber;
	private JTextField tfSurgeryFamilyName;
	private JTextField tfSurgeryGivenName;
	private JTextField tfSurgeryFuture1;
	private JTextField tfPatClass;
	private JTextField tfPointOfCare;
	private JTextField tfSurgeryRoom;
	private JTextField tfSurgeryBed;
	private JTextField tfSurgeryAdmitDate;
	private JTextField tfSurgeryDischargeDate;
	private JTextField tfEncounterFuture1;
	private JTextField tfEncounterFuture2;
	private JTextField tfEncounterFuture3;
	private JTextField tfEncounterFuture4;
	private JTextField tfORLocation;
	private JTextField tfCaseDate;
	private JTextField tfStart;
	private JTextField tfStop;
	private JTextField tfSurgeon;
	private JTextField tfProcedure;
	private JTextField tfSurgeryType;
	private JTextField tfMisc;
	private JTextField tfTestField;
	private JTextField tfNotUsed;
	private JTextField tfFacilityCode;
	private JTextField tfSurgeryCode;
	private JTextField tfAnesthesiologist;
	private JTextField tfSurgeryService;
	private JTextField tfSurgeonCode;
	private JTextField tfAnesthesiologistCode;
	private JTextField tfDurationOfLabor;
	private JTextField tfEstimatedBloodLoss;
	private JTextField tfHeight;
	private JTextField tfWeight;
	private JTextField tfADTMRN;
	private JTextField tfADTPatientName;
	private JTextField tfADTType;
	private JTextField tfADTMessageDate;
	private JTextField tfADTBirthdate;
	private JTextField tfADTSex;
	private JTextField tfADTAccountNumber;
	private JTextField tfADTInstitution;
	private JTextField tfADTFloor;
	private JTextField tfADTBed;
	private JTextField tfADTDischargeDate;

	private JComboBox<String> comboCreateType = new JComboBox<String>();
	private JComboBox<String> comboApproachTechnique = new JComboBox<String>();
	private JComboBox<String> comboHipReplacement = new JComboBox<String>();
	private JComboBox<String> comboKneeReplacement = new JComboBox<String>();
	private JComboBox<String> comboASACode = new JComboBox<String>();
	private JComboBox<String> comboWoundClass = new JComboBox<String>();
	private JComboBox<String> comboNHSNCategory = new JComboBox<String>();
	private JComboBox<String> comboWeightUnit = new JComboBox<String>();
	private JComboBox<String> comboHeightUnit = new JComboBox<String>();
	private JComboBox<String> comboSpinalLevel = new JComboBox<String>();
	private JComboBox<String> comboADTCreateType = new JComboBox<String>();
	private JComboBox<String> comboMicroOBR = new JComboBox<String>();
	private JComboBox<String> comboMicroOBX = new JComboBox<String>();
	private JComboBox<String> comboMicroCreateType = new JComboBox<String>();
	private JComboBox<String> comboTemplateSelect = new JComboBox<String>();

	private JCheckBox chckbxADTOpt = new JCheckBox("Optional fields");
	private JCheckBox chckbxADTCond = new JCheckBox("Conditional fields");

	private JRadioButton rdbtnOutpatientYes = new JRadioButton("Yes");
	private JRadioButton rdbtnOutpatientNo = new JRadioButton("No");
	private JRadioButton rdbtnEmergencyNo = new JRadioButton("No");
	private JRadioButton rdbtnEmergencyYes = new JRadioButton("Yes");
	private JRadioButton rdbtnGeneralAnesthesiaNo = new JRadioButton("No");
	private JRadioButton rdbtnGeneralAnesthesiaYes = new JRadioButton("Yes");
	private JRadioButton rdbtnTraumaNo = new JRadioButton("No");
	private JRadioButton rdbtnTraumaYes = new JRadioButton("Yes");
	private JRadioButton rdbtnEndoscopeNo = new JRadioButton("No");
	private JRadioButton rdbtnEndoscopeYes = new JRadioButton("Yes");
	private JRadioButton rdbtnMultipleProceduresNo = new JRadioButton("No");
	private JRadioButton rdbtnMultipleProceduresYes = new JRadioButton("Yes");
	private JRadioButton rdbtnImplantNo = new JRadioButton("No");
	private JRadioButton rdbtnImplantYes = new JRadioButton("Yes");
	private JRadioButton rdbtnTransplantNo = new JRadioButton("No");
	private JRadioButton rdbtnTransplantYes = new JRadioButton("Yes");
	private JRadioButton rdbtnTransplantAutologousNo = new JRadioButton("No");
	private JRadioButton rdbtnTransplantAutologousYes = new JRadioButton("Yes");
	private JRadioButton rdbtnPrimaryClosureNo = new JRadioButton("No");
	private JRadioButton rdbtnPrimaryClosureYes = new JRadioButton("Yes");
	private JRadioButton rdbtnDiabetesMellitusYes = new JRadioButton("Yes");
	private JRadioButton rdbtnDiabetesMellitusNo = new JRadioButton("No");
	private JButton btnMicroLoadAdt = new JButton("Load ADT Patient");

	private JTextArea taHL7 = new JTextArea();
	private JTextArea taMicro = new JTextArea();
	private JLabel lblADTStatus = new JLabel("");
	private JLabel lblSurgeryStatus = new JLabel("");
	private JLabel lblMicroOBRCount = new JLabel("0");
	private JLabel lblMicroOBXCount = new JLabel("0");
	private JLabel lblMicroStatus = new JLabel("");
	private String workingDirectory = System.getProperty("user.dir");
	private Timer timer;
	private boolean microHeaderPresent = false;
	static String[] obxArray;
	private JTextField tfPatientAddress;
	private JTextField tfSecurity;
	private JTextField tfEncodingCharacters;
	private JTextField tfSendingApplication;
	private JTextField tfSendingFacility;
	private JTextField tfReceivingApplication;
	private JTextField tfReceivingFacility;
	private JTextField tfMessageControlID;
	private JTextField tfProcessingID;
	private JTextField tfVersionID;
	private JTextField tfPatientIDExternal;
	private JTextField tfAlternatePatientID;
	private JTextField tfMothersMaiden;
	private JTextField tfPatientAlias;
	private JTextField tfRace;
	private JTextField tfCountyCode;
	private JTextField tfPhoneNumberHome;
	private JTextField tfPhoneNumberBusiness;
	private JTextField tfPrimaryLanguage;
	private JTextField tfMaritalStatus;
	private JTextField tfReligion;
	private JTextField tfSocialSecurityNumber;
	private JTextField tfDriversLicenseNumber;
	private JTextField tfMothersIdentifier;
	private JTextField tfEthnicGroup;
	private JTextField tfBirthPlace;
	private JTextField tfMultipleBirthIndicator;
	private JTextField tfBirthOrder;
	private JTextField tfCitizenship;
	private JTextField tfVeteransStatus;
	private JTextField tfNationalityCode;
	private JTextField tfPatientDeathDate;
	private JTextField tfPatientDeathIndicator;
	private JTextField tfPatientClass;
	private JTextField tfAdmissionType;
	private JTextField tfPreadmitNumber;
	private JTextField tfPriorPatientLocation;
	private JTextField tfAttendingDoctor;
	private JTextField tfReferringDoctor;
	private JTextField tfConsultingDoctor;
	private JTextField tfHospitalService;
	private JTextField tfTemporaryLocation;
	private JTextField tfPreadmitTestIndicator;
	private JTextField tfReadmissionIndicator;
	private JTextField tfAdmitSource;
	private JTextField tfContractPeriod;
	private JTextField tfInterestCode;
	private JTextField tfAmbulatoryStatus;
	private JTextField tfVIPIndicator;
	private JTextField tfAdmittingDoctor;
	private JTextField tfPatientType;
	private JTextField tfFinancialClass;
	private JTextField tfChargePriceIndicator;
	private JTextField tfCourtesyCode;
	private JTextField tfCreditRating;
	private JTextField tfContractCode;
	private JTextField tfContractEffectiveDate;
	private JTextField tfContractAmount;
	private JTextField tfTransferBadDebtCode;
	private JTextField tfTransferBadDebtDate;
	private JTextField tfBadDebtAgencyCode;
	private JTextField tfBadDebtTRFAmount;
	private JTextField tfBadDebtRecoveryAmt;
	private JTextField tfDeleteAcctIndicator;
	private JTextField tfDeleteAccountDate;
	private JTextField tfDichargeDisposition;
	private JTextField tfDischargeToLocation;
	private JTextField tfDietType;
	private JTextField tfServicingFacility;
	private JTextField tfAccountStatus;
	private JTextField tfPendingLocation;
	private JTextField tfPriorTempLocation;
	private JTextField tfADTAdmitDate;
	private JTextField tfCurrentPatientBalance;
	private JTextField tfTotalCharges;
	private JTextField tfTotalAdjustments;
	private JTextField tfTotalPayments;
	private JTextField tfAlternativeVisitID;
	private JTextField tfVisitorIndicator;
	private JTextField tfOtherCareProvider;
	private JTextField tfBedStatus;
	private JTextField tfOrderControl;
	private JTextField tfPlaceOrderNumber;
	private JTextField tfFillerOrderNumber;
	private JTextField tfPlacerGroupNumber;
	private JTextField tfOrderStatus;
	private JTextField tfOrderControlCodeReason;
	private JTextField tfResponseFlag;
	private JTextField tfQuantityTiming;
	private JTextField tfParent;
	private JTextField tfDateTimeTransaction;
	private JTextField tfEnteredBy;
	private JTextField tfEnteringOrganization;
	private JTextField tfVerifiedBy;
	private JTextField tfOrderingProvider;
	private JTextField tfEnterersLocation;
	private JTextField tfCallbackPhone;
	private JTextField tfOrderEffectiveDateTime;
	private JTextField tfEnteringDevice;
	private JTextField tfActionBy;
	private JTextField tfOBRUniversalServiceIdentifier;
	private JTextField tfOBRPlaceOrderNumber;
	private JTextField tfOBRFillerOrderNumber;
	private JTextField tfOBRPriority;
	private JTextField tfOBRRequestedDateTime;
	private JTextField tfOBRObservationDateTime;
	private JTextField tfOBRObservationEndDateTime;
	private JTextField tfOBRCollectionVolume;
	private JTextField tfOBRCollectorIdentifier;
	private JTextField tfOBRSpecimenActionCode;
	private JTextField tfOBRDangerCode;
	private JTextField tfOBRRelevantClinicalInfo;
	private JTextField tfOBRSpecimenReceivedDateTime;
	private JTextField tfOBROrderCallbackPhone;
	private JTextField tfOBRSpecimenSource;
	private JTextField tfOBROrderingProvider;
	private JTextField tfOBRPlacerField1;
	private JTextField tfOBRPlacerField2;
	private JTextField tfOBRFillerField1;
	private JTextField tfOBRFillerField2;
	private JTextField tfOBRResultsRptStatusChng;
	private JTextField tfOBRCollectorsComment;
	private JTextField tfOBRTransportArrangement;
	private JTextField tfOBRChargeToPractice;
	private JTextField tfOBRDiagnosticServiceSectionID;
	private JTextField tfOBRResultsStatus;
	private JTextField tfOBRParentResult;
	private JTextField tfOBRParentNumber;
	private JTextField tfOBRQuantityTiming;
	private JTextField tfOBRResultCopiesTo;
	private JTextField tfOBRTransportationMode;
	private JTextField tfOBRReasonForStudy;
	private JTextField tfOBRPrincipalResultInterpreter;
	private JTextField tfOBRAssistantResultInterpreter;
	private JTextField tfOBRTechnician;
	private JTextField tfOBRTransportLogisiticsOfCollectedSample;
	private JTextField tfOBRTranscriptionist;
	private JTextField tfOBRScheduledDateTime;
	private JTextField tfOBRNumberOfSamplesContainers;
	private JTextField tfOBRTransportArranged;
	private JTextField tfOBREscortRequired;
	private JTextField tfOBRPlannedPatientTransportComment;
	private JTextField tfOBXValueType;
	private JTextField tfOBXObservationIdentifier;
	private JTextField tfOBXObservationSubID;
	private JTextField tfOBXObservationValue;
	private JTextField tfOBXUnits;
	private JTextField tfOBXReferencesRange;
	private JTextField tfOBXAbnormalFlags;
	private JTextField tfOBXProbability;
	private JTextField tfOBXNatureOfAbnormalTest;
	private JTextField tfOBXObservResultStatus;
	private JTextField tfOBXDateLastObsNormalValues;
	private JTextField tfOBXUserDefinedAccessChecks;
	private JTextField tfOBXDateTimeOfTheObservation;
	private JTextField tfOBXProducersID;
	private JTextField tfOBXResponsibleObserver;
	private JTextField tfOBXObservationMethod;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmScenarioBuilder.setVisible(true);
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					SwingUtilities.updateComponentTreeUI(window.frmScenarioBuilder);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmScenarioBuilder = new JFrame();
		frmScenarioBuilder.getContentPane().setBackground(new Color(255, 255, 224));
		frmScenarioBuilder.setTitle("Scenario Builder");
		frmScenarioBuilder.setBounds(100, 100, 1423, 788);
		frmScenarioBuilder.setMinimumSize(new Dimension(1398, 772));
		frmScenarioBuilder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmScenarioBuilder.getContentPane().setLayout(null);

		ButtonGroup bgDiabetesMellitus = new ButtonGroup();
		bgDiabetesMellitus.add(rdbtnDiabetesMellitusYes);
		bgDiabetesMellitus.add(rdbtnDiabetesMellitusNo);

		ButtonGroup bgOutpatient = new ButtonGroup();
		bgOutpatient.add(rdbtnOutpatientYes);
		bgOutpatient.add(rdbtnOutpatientNo);

		ButtonGroup bgEmergency = new ButtonGroup();
		bgEmergency.add(rdbtnEmergencyYes);
		bgEmergency.add(rdbtnEmergencyNo);

		ButtonGroup bgGeneralAnesthesia = new ButtonGroup();
		bgGeneralAnesthesia.add(rdbtnGeneralAnesthesiaYes);
		bgGeneralAnesthesia.add(rdbtnGeneralAnesthesiaNo);

		ButtonGroup bgTrauma = new ButtonGroup();
		bgTrauma.add(rdbtnTraumaYes);
		bgTrauma.add(rdbtnTraumaNo);

		ButtonGroup bgEndoscope = new ButtonGroup();
		bgEndoscope.add(rdbtnEndoscopeYes);
		bgEndoscope.add(rdbtnEndoscopeNo);

		ButtonGroup bgMultipleProcedures = new ButtonGroup();
		bgMultipleProcedures.add(rdbtnMultipleProceduresYes);
		bgMultipleProcedures.add(rdbtnMultipleProceduresNo);

		ButtonGroup bgImplant = new ButtonGroup();
		bgImplant.add(rdbtnImplantYes);
		bgImplant.add(rdbtnImplantNo);

		ButtonGroup bgTransplant = new ButtonGroup();
		bgTransplant.add(rdbtnTransplantYes);
		bgTransplant.add(rdbtnTransplantNo);

		ButtonGroup bgTransplantAutologous = new ButtonGroup();
		bgTransplantAutologous.add(rdbtnTransplantAutologousYes);
		bgTransplantAutologous.add(rdbtnTransplantAutologousNo);

		ButtonGroup bgPrimaryClosure = new ButtonGroup();
		bgPrimaryClosure.add(rdbtnPrimaryClosureYes);
		bgPrimaryClosure.add(rdbtnPrimaryClosureNo);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(null);
		tabbedPane.setPreferredSize(new Dimension(1391, 898));
		tabbedPane.setBounds(10, 13, 1397, 741);
		frmScenarioBuilder.getContentPane().add(tabbedPane);

		final JPanel panelADT = new JPanel();
		panelADT.setBackground(new Color(255, 250, 205));
		tabbedPane.addTab("ADT", null, panelADT, null);
		panelADT.setLayout(null);

		JPanel panelMSH = new JPanel();
		panelMSH.setBackground(new Color(255, 250, 205));
		panelMSH.setBorder(null);
		panelMSH.setBounds(9, 59, 324, 274);
		panelADT.add(panelMSH);
		panelMSH.setLayout(null);

		JLabel lblDateTime = new JLabel("Date / Time of Message");
		lblDateTime.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDateTime.setBounds(4, 128, 137, 16);
		panelMSH.add(lblDateTime);
		lblDateTime.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblMessageType = new JLabel("Message Type");
		lblMessageType.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMessageType.setBounds(4, 176, 137, 16);
		panelMSH.add(lblMessageType);
		lblMessageType.setHorizontalAlignment(SwingConstants.CENTER);

		tfADTType = new JTextField();
		tfADTType.setToolTipText("ADT^A01 : admit/visit notification. Other types listed on iSpec 3.3.2");
		tfADTType.setBounds(149, 173, 166, 22);
		panelMSH.add(tfADTType);
		tfADTType.setColumns(10);

		tfADTMessageDate = new JTextField();
		tfADTMessageDate.setToolTipText("Must be YYYYMMDDHHMMSS");
		tfADTMessageDate.setBounds(149, 125, 166, 22);
		panelMSH.add(tfADTMessageDate);
		tfADTMessageDate.setColumns(10);

		JLabel lblEncodingCharacters = new JLabel("Encoding Characters");
		lblEncodingCharacters.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEncodingCharacters.setBounds(4, 8, 137, 16);
		panelMSH.add(lblEncodingCharacters);
		lblEncodingCharacters.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblSendingApplication = new JLabel("Sending Application");
		lblSendingApplication.setBounds(4, 32, 137, 16);
		panelMSH.add(lblSendingApplication);
		lblSendingApplication.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblSendingFacility = new JLabel("Sending Facility");
		lblSendingFacility.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSendingFacility.setBounds(4, 56, 137, 16);
		panelMSH.add(lblSendingFacility);
		lblSendingFacility.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblReceivingApplication = new JLabel("Receiving Application");
		lblReceivingApplication.setBounds(4, 80, 137, 16);
		panelMSH.add(lblReceivingApplication);
		lblReceivingApplication.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblReceivingFacility = new JLabel("Receiving Facility");
		lblReceivingFacility.setBounds(4, 104, 137, 16);
		panelMSH.add(lblReceivingFacility);
		lblReceivingFacility.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblSecurity = new JLabel("Security");
		lblSecurity.setBounds(4, 152, 137, 16);
		panelMSH.add(lblSecurity);
		lblSecurity.setHorizontalAlignment(SwingConstants.CENTER);

		tfSecurity = new JTextField();
		tfSecurity.setBackground(new Color(245, 245, 220));
		tfSecurity.setEnabled(false);
		tfSecurity.setBounds(149, 149, 166, 22);
		panelMSH.add(tfSecurity);
		tfSecurity.setColumns(10);

		tfEncodingCharacters = new JTextField();
		tfEncodingCharacters.setToolTipText("Must be ^~\\{ or ^~\\&");
		tfEncodingCharacters.setBounds(149, 5, 166, 22);
		panelMSH.add(tfEncodingCharacters);
		tfEncodingCharacters.setColumns(10);

		tfSendingApplication = new JTextField();
		tfSendingApplication.setBackground(new Color(245, 245, 220));
		tfSendingApplication.setEnabled(false);
		tfSendingApplication.setBounds(149, 29, 166, 22);
		panelMSH.add(tfSendingApplication);
		tfSendingApplication.setColumns(10);

		tfSendingFacility = new JTextField();
		tfSendingFacility.setBackground(new Color(245, 245, 220));
		tfSendingFacility.setEnabled(false);
		tfSendingFacility.setBounds(149, 53, 166, 22);
		panelMSH.add(tfSendingFacility);
		tfSendingFacility.setColumns(10);

		tfReceivingApplication = new JTextField();
		tfReceivingApplication.setBackground(new Color(245, 245, 220));
		tfReceivingApplication.setEnabled(false);
		tfReceivingApplication.setBounds(149, 77, 166, 22);
		panelMSH.add(tfReceivingApplication);
		tfReceivingApplication.setColumns(10);

		tfReceivingFacility = new JTextField();
		tfReceivingFacility.setBackground(new Color(245, 245, 220));
		tfReceivingFacility.setEnabled(false);
		tfReceivingFacility.setBounds(149, 101, 166, 22);
		panelMSH.add(tfReceivingFacility);
		tfReceivingFacility.setColumns(10);

		JLabel lblMessageControlId = new JLabel("Message Control ID");
		lblMessageControlId.setBounds(4, 200, 137, 16);
		panelMSH.add(lblMessageControlId);
		lblMessageControlId.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblProcessingId = new JLabel("Processing ID");
		lblProcessingId.setBounds(4, 224, 137, 16);
		panelMSH.add(lblProcessingId);
		lblProcessingId.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblVersionId = new JLabel("Version ID");
		lblVersionId.setBounds(4, 248, 137, 16);
		panelMSH.add(lblVersionId);
		lblVersionId.setHorizontalAlignment(SwingConstants.CENTER);

		tfMessageControlID = new JTextField();
		tfMessageControlID.setBackground(new Color(245, 245, 220));
		tfMessageControlID.setEnabled(false);
		tfMessageControlID.setColumns(10);
		tfMessageControlID.setBounds(149, 197, 166, 22);
		panelMSH.add(tfMessageControlID);

		tfProcessingID = new JTextField();
		tfProcessingID.setBackground(new Color(245, 245, 220));
		tfProcessingID.setEnabled(false);
		tfProcessingID.setColumns(10);
		tfProcessingID.setBounds(149, 221, 166, 22);
		panelMSH.add(tfProcessingID);

		tfVersionID = new JTextField();
		tfVersionID.setBackground(new Color(245, 245, 220));
		tfVersionID.setEnabled(false);
		tfVersionID.setColumns(10);
		tfVersionID.setBounds(149, 245, 166, 22);
		panelMSH.add(tfVersionID);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 224));
		panel.setBorder(null);
		panel.setBounds(342, 86, 1013, 247);
		panelADT.add(panel);
		panel.setLayout(null);

		JLabel lblPatiendIdexternal = new JLabel("Patient ID (External)");
		lblPatiendIdexternal.setHorizontalAlignment(SwingConstants.CENTER);
		lblPatiendIdexternal.setBounds(4, 6, 158, 16);
		panel.add(lblPatiendIdexternal);

		tfPatientIDExternal = new JTextField();
		tfPatientIDExternal.setBackground(new Color(245, 245, 220));
		tfPatientIDExternal.setEnabled(false);
		tfPatientIDExternal.setColumns(10);
		tfPatientIDExternal.setBounds(170, 3, 166, 22);
		panel.add(tfPatientIDExternal);

		JLabel lblMrnCharacters = new JLabel("Patient ID (MRN)");
		lblMrnCharacters.setBounds(4, 30, 158, 16);
		panel.add(lblMrnCharacters);
		lblMrnCharacters.setHorizontalAlignment(SwingConstants.CENTER);

		tfADTMRN = new JTextField();
		tfADTMRN.setToolTipText("The MRN is required. QA999999999");
		tfADTMRN.setBounds(170, 27, 166, 22);
		panel.add(tfADTMRN);
		tfADTMRN.setColumns(10);

		JLabel lblAlternatePatientId = new JLabel("Alternate Patient ID");
		lblAlternatePatientId.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlternatePatientId.setBounds(4, 54, 158, 16);
		panel.add(lblAlternatePatientId);

		tfAlternatePatientID = new JTextField();
		tfAlternatePatientID.setBackground(new Color(245, 245, 220));
		tfAlternatePatientID.setEnabled(false);
		tfAlternatePatientID.setColumns(10);
		tfAlternatePatientID.setBounds(170, 51, 166, 22);
		panel.add(tfAlternatePatientID);

		tfADTPatientName = new JTextField();
		tfADTPatientName.setToolTipText("In format of LASTNAME^FIRSTNAME^MIDDLE");
		tfADTPatientName.setBounds(170, 75, 166, 22);
		panel.add(tfADTPatientName);
		tfADTPatientName.setColumns(10);

		JLabel label_62 = new JLabel("Patient Name");
		label_62.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_62.setBounds(4, 78, 158, 16);
		panel.add(label_62);
		label_62.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblMothersMaidenName = new JLabel("Mother's Maiden Name");
		lblMothersMaidenName.setHorizontalAlignment(SwingConstants.CENTER);
		lblMothersMaidenName.setBounds(4, 102, 158, 16);
		panel.add(lblMothersMaidenName);

		tfMothersMaiden = new JTextField();
		tfMothersMaiden.setBackground(new Color(245, 245, 220));
		tfMothersMaiden.setEnabled(false);
		tfMothersMaiden.setColumns(10);
		tfMothersMaiden.setBounds(170, 99, 166, 22);
		panel.add(tfMothersMaiden);

		tfADTBirthdate = new JTextField();
		tfADTBirthdate.setToolTipText("Must be YYYYMMDD");
		tfADTBirthdate.setBounds(170, 123, 166, 22);
		panel.add(tfADTBirthdate);
		tfADTBirthdate.setColumns(10);

		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setBounds(4, 126, 158, 16);
		panel.add(lblDateOfBirth);
		lblDateOfBirth.setHorizontalAlignment(SwingConstants.CENTER);

		tfADTSex = new JTextField();
		tfADTSex.setToolTipText("M, F or U");
		tfADTSex.setBounds(170, 147, 166, 22);
		panel.add(tfADTSex);
		tfADTSex.setColumns(10);

		JLabel label_64 = new JLabel("Sex");
		label_64.setBounds(4, 150, 158, 16);
		panel.add(label_64);
		label_64.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblPatientAlias = new JLabel("Patient Alias");
		lblPatientAlias.setHorizontalAlignment(SwingConstants.CENTER);
		lblPatientAlias.setBounds(4, 174, 158, 16);
		panel.add(lblPatientAlias);

		tfPatientAlias = new JTextField();
		tfPatientAlias.setBackground(new Color(245, 245, 220));
		tfPatientAlias.setEnabled(false);
		tfPatientAlias.setColumns(10);
		tfPatientAlias.setBounds(170, 171, 166, 22);
		panel.add(tfPatientAlias);

		JLabel lblRace = new JLabel("Race");
		lblRace.setHorizontalAlignment(SwingConstants.CENTER);
		lblRace.setBounds(4, 198, 158, 16);
		panel.add(lblRace);

		tfRace = new JTextField();
		tfRace.setBackground(new Color(245, 245, 220));
		tfRace.setEnabled(false);
		tfRace.setColumns(10);
		tfRace.setBounds(170, 195, 166, 22);
		panel.add(tfRace);

		JLabel lblCountyCode = new JLabel("County Code");
		lblCountyCode.setHorizontalAlignment(SwingConstants.CENTER);
		lblCountyCode.setBounds(342, 6, 158, 16);
		panel.add(lblCountyCode);

		tfCountyCode = new JTextField();
		tfCountyCode.setBackground(new Color(245, 245, 220));
		tfCountyCode.setEnabled(false);
		tfCountyCode.setColumns(10);
		tfCountyCode.setBounds(508, 3, 166, 22);
		panel.add(tfCountyCode);

		JLabel lblNewLabel_1 = new JLabel("Patient Address");
		lblNewLabel_1.setBounds(4, 222, 158, 16);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);

		tfPatientAddress = new JTextField();
		tfPatientAddress.setBackground(new Color(245, 245, 220));
		tfPatientAddress.setEnabled(false);
		tfPatientAddress.setBounds(170, 219, 504, 22);
		panel.add(tfPatientAddress);
		tfPatientAddress.setColumns(10);

		JLabel lblPhoneNumber = new JLabel("Phone Number - Home");
		lblPhoneNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhoneNumber.setBounds(342, 30, 158, 16);
		panel.add(lblPhoneNumber);

		tfPhoneNumberHome = new JTextField();
		tfPhoneNumberHome.setBackground(new Color(245, 245, 220));
		tfPhoneNumberHome.setEnabled(false);
		tfPhoneNumberHome.setColumns(10);
		tfPhoneNumberHome.setBounds(508, 27, 166, 22);
		panel.add(tfPhoneNumberHome);

		JLabel lblPhoneNumber_1 = new JLabel("Phone Number - Business");
		lblPhoneNumber_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhoneNumber_1.setBounds(342, 54, 158, 16);
		panel.add(lblPhoneNumber_1);

		tfPhoneNumberBusiness = new JTextField();
		tfPhoneNumberBusiness.setBackground(new Color(245, 245, 220));
		tfPhoneNumberBusiness.setEnabled(false);
		tfPhoneNumberBusiness.setColumns(10);
		tfPhoneNumberBusiness.setBounds(508, 51, 166, 22);
		panel.add(tfPhoneNumberBusiness);

		JLabel lblPrimaryLanguage = new JLabel("Primary Language");
		lblPrimaryLanguage.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrimaryLanguage.setBounds(342, 126, 158, 16);
		panel.add(lblPrimaryLanguage);

		tfPrimaryLanguage = new JTextField();
		tfPrimaryLanguage.setBackground(new Color(245, 245, 220));
		tfPrimaryLanguage.setEnabled(false);
		tfPrimaryLanguage.setColumns(10);
		tfPrimaryLanguage.setBounds(508, 123, 166, 22);
		panel.add(tfPrimaryLanguage);

		JLabel lblMartialStatus = new JLabel("Martial Status");
		lblMartialStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblMartialStatus.setBounds(342, 150, 158, 16);
		panel.add(lblMartialStatus);

		tfMaritalStatus = new JTextField();
		tfMaritalStatus.setBackground(new Color(245, 245, 220));
		tfMaritalStatus.setEnabled(false);
		tfMaritalStatus.setColumns(10);
		tfMaritalStatus.setBounds(508, 147, 166, 22);
		panel.add(tfMaritalStatus);

		JLabel lblReligion = new JLabel("Religion");
		lblReligion.setHorizontalAlignment(SwingConstants.CENTER);
		lblReligion.setBounds(342, 174, 158, 16);
		panel.add(lblReligion);

		tfReligion = new JTextField();
		tfReligion.setBackground(new Color(245, 245, 220));
		tfReligion.setEnabled(false);
		tfReligion.setColumns(10);
		tfReligion.setBounds(508, 171, 166, 22);
		panel.add(tfReligion);

		tfADTAccountNumber = new JTextField();
		tfADTAccountNumber.setToolTipText(
				"TheraDoc uses the value in PID-18 - Patient Account Number as the primary identifier for encounters. QA999999999");
		tfADTAccountNumber.setBounds(508, 195, 166, 22);
		panel.add(tfADTAccountNumber);
		tfADTAccountNumber.setColumns(10);

		JLabel lblAccountNumbersame = new JLabel("Patient Account Number");
		lblAccountNumbersame.setBounds(342, 198, 158, 16);
		panel.add(lblAccountNumbersame);
		lblAccountNumbersame.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblSsnNumber = new JLabel("SSN Number");
		lblSsnNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblSsnNumber.setBounds(674, 6, 158, 16);
		panel.add(lblSsnNumber);

		tfSocialSecurityNumber = new JTextField();
		tfSocialSecurityNumber.setBackground(new Color(245, 245, 220));
		tfSocialSecurityNumber.setEnabled(false);
		tfSocialSecurityNumber.setColumns(10);
		tfSocialSecurityNumber.setBounds(840, 3, 166, 22);
		panel.add(tfSocialSecurityNumber);

		JLabel lblDriversLicenseNumber = new JLabel("Driver's License Number");
		lblDriversLicenseNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblDriversLicenseNumber.setBounds(674, 30, 158, 16);
		panel.add(lblDriversLicenseNumber);

		tfDriversLicenseNumber = new JTextField();
		tfDriversLicenseNumber.setBackground(new Color(245, 245, 220));
		tfDriversLicenseNumber.setEnabled(false);
		tfDriversLicenseNumber.setColumns(10);
		tfDriversLicenseNumber.setBounds(840, 27, 166, 22);
		panel.add(tfDriversLicenseNumber);

		JLabel lblMothersIdentifier = new JLabel("Mother's Identifier");
		lblMothersIdentifier.setHorizontalAlignment(SwingConstants.CENTER);
		lblMothersIdentifier.setBounds(674, 54, 158, 16);
		panel.add(lblMothersIdentifier);

		tfMothersIdentifier = new JTextField();
		tfMothersIdentifier.setBackground(new Color(245, 245, 220));
		tfMothersIdentifier.setEnabled(false);
		tfMothersIdentifier.setColumns(10);
		tfMothersIdentifier.setBounds(840, 51, 166, 22);
		panel.add(tfMothersIdentifier);

		JLabel lblEthnicGroup = new JLabel("Ethnic Group");
		lblEthnicGroup.setHorizontalAlignment(SwingConstants.CENTER);
		lblEthnicGroup.setBounds(674, 78, 158, 16);
		panel.add(lblEthnicGroup);

		tfEthnicGroup = new JTextField();
		tfEthnicGroup.setBackground(new Color(245, 245, 220));
		tfEthnicGroup.setEnabled(false);
		tfEthnicGroup.setColumns(10);
		tfEthnicGroup.setBounds(840, 75, 166, 22);
		panel.add(tfEthnicGroup);

		JLabel lblBirthPlace = new JLabel("Birth Place");
		lblBirthPlace.setHorizontalAlignment(SwingConstants.CENTER);
		lblBirthPlace.setBounds(674, 102, 158, 16);
		panel.add(lblBirthPlace);

		tfBirthPlace = new JTextField();
		tfBirthPlace.setBackground(new Color(245, 245, 220));
		tfBirthPlace.setEnabled(false);
		tfBirthPlace.setColumns(10);
		tfBirthPlace.setBounds(840, 99, 166, 22);
		panel.add(tfBirthPlace);

		JLabel lblMultipleBirthIndicator = new JLabel("Multiple Birth Indicator");
		lblMultipleBirthIndicator.setHorizontalAlignment(SwingConstants.CENTER);
		lblMultipleBirthIndicator.setBounds(674, 126, 158, 16);
		panel.add(lblMultipleBirthIndicator);

		tfMultipleBirthIndicator = new JTextField();
		tfMultipleBirthIndicator.setBackground(new Color(245, 245, 220));
		tfMultipleBirthIndicator.setEnabled(false);
		tfMultipleBirthIndicator.setColumns(10);
		tfMultipleBirthIndicator.setBounds(840, 123, 166, 22);
		panel.add(tfMultipleBirthIndicator);

		JLabel lblBirthOrder = new JLabel("Birth Order");
		lblBirthOrder.setHorizontalAlignment(SwingConstants.CENTER);
		lblBirthOrder.setBounds(674, 150, 158, 16);
		panel.add(lblBirthOrder);

		tfBirthOrder = new JTextField();
		tfBirthOrder.setBackground(new Color(245, 245, 220));
		tfBirthOrder.setEnabled(false);
		tfBirthOrder.setColumns(10);
		tfBirthOrder.setBounds(840, 147, 166, 22);
		panel.add(tfBirthOrder);

		JLabel lblCitizenship = new JLabel("Citizenship");
		lblCitizenship.setHorizontalAlignment(SwingConstants.CENTER);
		lblCitizenship.setBounds(674, 174, 158, 16);
		panel.add(lblCitizenship);

		tfCitizenship = new JTextField();
		tfCitizenship.setBackground(new Color(245, 245, 220));
		tfCitizenship.setEnabled(false);
		tfCitizenship.setColumns(10);
		tfCitizenship.setBounds(840, 171, 166, 22);
		panel.add(tfCitizenship);

		JLabel lblVeteransMilitaryStatus = new JLabel("Veterans Military Status");
		lblVeteransMilitaryStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblVeteransMilitaryStatus.setBounds(342, 78, 158, 16);
		panel.add(lblVeteransMilitaryStatus);

		tfVeteransStatus = new JTextField();
		tfVeteransStatus.setBackground(new Color(245, 245, 220));
		tfVeteransStatus.setEnabled(false);
		tfVeteransStatus.setColumns(10);
		tfVeteransStatus.setBounds(508, 75, 166, 22);
		panel.add(tfVeteransStatus);

		JLabel lblNationalityCode = new JLabel("Nationality Code");
		lblNationalityCode.setHorizontalAlignment(SwingConstants.CENTER);
		lblNationalityCode.setBounds(342, 102, 158, 16);
		panel.add(lblNationalityCode);

		tfNationalityCode = new JTextField();
		tfNationalityCode.setBackground(new Color(245, 245, 220));
		tfNationalityCode.setEnabled(false);
		tfNationalityCode.setColumns(10);
		tfNationalityCode.setBounds(508, 99, 166, 22);
		panel.add(tfNationalityCode);

		JLabel lblPatientDeathDate = new JLabel("Patient Death Date / Time");
		lblPatientDeathDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblPatientDeathDate.setBounds(674, 198, 158, 16);
		panel.add(lblPatientDeathDate);

		tfPatientDeathDate = new JTextField();
		tfPatientDeathDate.setBackground(new Color(245, 245, 220));
		tfPatientDeathDate.setEnabled(false);
		tfPatientDeathDate.setColumns(10);
		tfPatientDeathDate.setBounds(840, 195, 166, 22);
		panel.add(tfPatientDeathDate);

		JLabel lblPatientDeathIndicator = new JLabel("Patient Death Indicator");
		lblPatientDeathIndicator.setHorizontalAlignment(SwingConstants.CENTER);
		lblPatientDeathIndicator.setBounds(674, 222, 158, 16);
		panel.add(lblPatientDeathIndicator);

		tfPatientDeathIndicator = new JTextField();
		tfPatientDeathIndicator.setBackground(new Color(245, 245, 220));
		tfPatientDeathIndicator.setEnabled(false);
		tfPatientDeathIndicator.setColumns(10);
		tfPatientDeathIndicator.setBounds(840, 219, 166, 22);
		panel.add(tfPatientDeathIndicator);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 250, 205));
		panel_1.setBorder(null);
		panel_1.setBounds(10, 337, 1345, 321);
		panelADT.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblPatientClass = new JLabel("Patient Class");
		lblPatientClass.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPatientClass.setHorizontalAlignment(SwingConstants.CENTER);
		lblPatientClass.setBounds(4, 10, 137, 16);
		panel_1.add(lblPatientClass);

		tfPatientClass = new JTextField();
		tfPatientClass.setToolTipText("I: Inpatient/ O: Outpatient/ E: Emergency/ P: PreAdmit");
		tfPatientClass.setColumns(10);
		tfPatientClass.setBounds(149, 7, 166, 22);
		panel_1.add(tfPatientClass);

		JLabel label_66 = new JLabel("Institution");
		label_66.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_66.setBounds(4, 34, 137, 16);
		panel_1.add(label_66);
		label_66.setHorizontalAlignment(SwingConstants.CENTER);

		tfADTInstitution = new JTextField();
		tfADTInstitution.setToolTipText("Assigned Patient Location: INST^ROOM^BED");
		tfADTInstitution.setBounds(149, 31, 166, 22);
		panel_1.add(tfADTInstitution);
		tfADTInstitution.setColumns(10);

		JLabel lblRoom = new JLabel("Room");
		lblRoom.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRoom.setBounds(4, 58, 137, 16);
		panel_1.add(lblRoom);
		lblRoom.setHorizontalAlignment(SwingConstants.CENTER);

		tfADTFloor = new JTextField();
		tfADTFloor.setToolTipText("Assigned Patient Location: INST^ROOM^BED");
		tfADTFloor.setBounds(149, 55, 166, 22);
		panel_1.add(tfADTFloor);
		tfADTFloor.setColumns(10);

		JLabel label_68 = new JLabel("Bed");
		label_68.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_68.setBounds(4, 82, 137, 16);
		panel_1.add(label_68);
		label_68.setHorizontalAlignment(SwingConstants.CENTER);

		tfADTBed = new JTextField();
		tfADTBed.setToolTipText("Assigned Patient Location: INST^ROOM^BED");
		tfADTBed.setBounds(149, 79, 166, 22);
		panel_1.add(tfADTBed);
		tfADTBed.setColumns(10);

		tfAdmissionType = new JTextField();
		tfAdmissionType.setBackground(new Color(245, 245, 220));
		tfAdmissionType.setEnabled(false);
		tfAdmissionType.setColumns(10);
		tfAdmissionType.setBounds(149, 103, 166, 22);
		panel_1.add(tfAdmissionType);

		JLabel lblAdmissionType = new JLabel("Admission Type");
		lblAdmissionType.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdmissionType.setBounds(4, 106, 137, 16);
		panel_1.add(lblAdmissionType);

		tfPreadmitNumber = new JTextField();
		tfPreadmitNumber.setBackground(new Color(245, 245, 220));
		tfPreadmitNumber.setEnabled(false);
		tfPreadmitNumber.setColumns(10);
		tfPreadmitNumber.setBounds(149, 127, 166, 22);
		panel_1.add(tfPreadmitNumber);

		JLabel lblPreadmitNumber = new JLabel("Preadmit Number");
		lblPreadmitNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblPreadmitNumber.setBounds(4, 130, 137, 16);
		panel_1.add(lblPreadmitNumber);

		tfPriorPatientLocation = new JTextField();
		tfPriorPatientLocation.setBackground(new Color(245, 245, 220));
		tfPriorPatientLocation.setEnabled(false);
		tfPriorPatientLocation.setColumns(10);
		tfPriorPatientLocation.setBounds(149, 151, 166, 22);
		panel_1.add(tfPriorPatientLocation);

		JLabel lblPriorPatientLocation = new JLabel("Prior Patient Location");
		lblPriorPatientLocation.setHorizontalAlignment(SwingConstants.CENTER);
		lblPriorPatientLocation.setBounds(4, 154, 137, 16);
		panel_1.add(lblPriorPatientLocation);

		tfAttendingDoctor = new JTextField();
		tfAttendingDoctor.setBackground(new Color(245, 245, 220));
		tfAttendingDoctor.setEnabled(false);
		tfAttendingDoctor.setColumns(10);
		tfAttendingDoctor.setBounds(149, 175, 166, 22);
		panel_1.add(tfAttendingDoctor);

		JLabel lblAttendingDoctor = new JLabel("Attending Doctor");
		lblAttendingDoctor.setHorizontalAlignment(SwingConstants.CENTER);
		lblAttendingDoctor.setBounds(4, 178, 137, 16);
		panel_1.add(lblAttendingDoctor);

		tfReferringDoctor = new JTextField();
		tfReferringDoctor.setBackground(new Color(245, 245, 220));
		tfReferringDoctor.setEnabled(false);
		tfReferringDoctor.setColumns(10);
		tfReferringDoctor.setBounds(149, 199, 166, 22);
		panel_1.add(tfReferringDoctor);

		JLabel lblReferringDoctor = new JLabel("Referring Doctor");
		lblReferringDoctor.setHorizontalAlignment(SwingConstants.CENTER);
		lblReferringDoctor.setBounds(4, 202, 137, 16);
		panel_1.add(lblReferringDoctor);

		tfConsultingDoctor = new JTextField();
		tfConsultingDoctor.setBackground(new Color(245, 245, 220));
		tfConsultingDoctor.setEnabled(false);
		tfConsultingDoctor.setColumns(10);
		tfConsultingDoctor.setBounds(149, 223, 166, 22);
		panel_1.add(tfConsultingDoctor);

		JLabel lblConsultingDoctor = new JLabel("Consulting Doctor");
		lblConsultingDoctor.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultingDoctor.setBounds(4, 226, 137, 16);
		panel_1.add(lblConsultingDoctor);

		JLabel lblHospitalService = new JLabel("Hospital Service");
		lblHospitalService.setHorizontalAlignment(SwingConstants.CENTER);
		lblHospitalService.setBounds(4, 250, 137, 16);
		panel_1.add(lblHospitalService);

		tfHospitalService = new JTextField();
		tfHospitalService.setBackground(new Color(245, 245, 220));
		tfHospitalService.setEnabled(false);
		tfHospitalService.setColumns(10);
		tfHospitalService.setBounds(149, 247, 166, 22);
		panel_1.add(tfHospitalService);

		JLabel lblTemporaryLocation = new JLabel("Temporary Location");
		lblTemporaryLocation.setHorizontalAlignment(SwingConstants.CENTER);
		lblTemporaryLocation.setBounds(4, 274, 137, 16);
		panel_1.add(lblTemporaryLocation);

		tfTemporaryLocation = new JTextField();
		tfTemporaryLocation.setBackground(new Color(245, 245, 220));
		tfTemporaryLocation.setEnabled(false);
		tfTemporaryLocation.setColumns(10);
		tfTemporaryLocation.setBounds(149, 271, 166, 22);
		panel_1.add(tfTemporaryLocation);

		JLabel lblDischargeDate = new JLabel("Discharge Date / Time");
		lblDischargeDate.setBounds(959, 130, 137, 16);
		panel_1.add(lblDischargeDate);
		lblDischargeDate.setHorizontalAlignment(SwingConstants.CENTER);

		tfADTDischargeDate = new JTextField();
		tfADTDischargeDate.setBackground(new Color(245, 245, 220));
		tfADTDischargeDate.setEnabled(false);
		tfADTDischargeDate.setBounds(1105, 127, 166, 22);
		panel_1.add(tfADTDischargeDate);
		tfADTDischargeDate.setColumns(10);

		JLabel lblPreadmitTestIndicator = new JLabel("Preadmit Test Indicator");
		lblPreadmitTestIndicator.setHorizontalAlignment(SwingConstants.CENTER);
		lblPreadmitTestIndicator.setBounds(4, 298, 137, 16);
		panel_1.add(lblPreadmitTestIndicator);

		tfPreadmitTestIndicator = new JTextField();
		tfPreadmitTestIndicator.setBackground(new Color(245, 245, 220));
		tfPreadmitTestIndicator.setEnabled(false);
		tfPreadmitTestIndicator.setColumns(10);
		tfPreadmitTestIndicator.setBounds(149, 295, 166, 22);
		panel_1.add(tfPreadmitTestIndicator);

		JLabel lblReadmissionIndicator = new JLabel("Readmission Indicator");
		lblReadmissionIndicator.setHorizontalAlignment(SwingConstants.CENTER);
		lblReadmissionIndicator.setBounds(323, 10, 137, 16);
		panel_1.add(lblReadmissionIndicator);

		JLabel lblAdmitSource = new JLabel("Admit Source");
		lblAdmitSource.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdmitSource.setBounds(323, 34, 137, 16);
		panel_1.add(lblAdmitSource);

		JLabel lblAmbulatoryStatus = new JLabel("Ambulatory Status");
		lblAmbulatoryStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmbulatoryStatus.setBounds(323, 58, 137, 16);
		panel_1.add(lblAmbulatoryStatus);

		tfReadmissionIndicator = new JTextField();
		tfReadmissionIndicator.setBackground(new Color(245, 245, 220));
		tfReadmissionIndicator.setEnabled(false);
		tfReadmissionIndicator.setColumns(10);
		tfReadmissionIndicator.setBounds(466, 7, 166, 22);
		panel_1.add(tfReadmissionIndicator);

		tfAdmitSource = new JTextField();
		tfAdmitSource.setBackground(new Color(245, 245, 220));
		tfAdmitSource.setEnabled(false);
		tfAdmitSource.setColumns(10);
		tfAdmitSource.setBounds(466, 31, 166, 22);
		panel_1.add(tfAdmitSource);

		JLabel lblVipIndicator = new JLabel("VIP Indicator");
		lblVipIndicator.setHorizontalAlignment(SwingConstants.CENTER);
		lblVipIndicator.setBounds(323, 82, 137, 16);
		panel_1.add(lblVipIndicator);

		JLabel lblAdmittingDoctor = new JLabel("Admitting Doctor");
		lblAdmittingDoctor.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdmittingDoctor.setBounds(323, 106, 137, 16);
		panel_1.add(lblAdmittingDoctor);

		JLabel lblPatientType = new JLabel("Patient Type");
		lblPatientType.setHorizontalAlignment(SwingConstants.CENTER);
		lblPatientType.setBounds(323, 130, 137, 16);
		panel_1.add(lblPatientType);

		JLabel lblFinancialClass = new JLabel("Financial Class");
		lblFinancialClass.setHorizontalAlignment(SwingConstants.CENTER);
		lblFinancialClass.setBounds(323, 154, 137, 16);
		panel_1.add(lblFinancialClass);

		JLabel lblChargePriceIndicator = new JLabel("Charge Price Indicator");
		lblChargePriceIndicator.setHorizontalAlignment(SwingConstants.CENTER);
		lblChargePriceIndicator.setBounds(323, 178, 137, 16);
		panel_1.add(lblChargePriceIndicator);

		JLabel lblCourtesyCode = new JLabel("Courtesy Code");
		lblCourtesyCode.setHorizontalAlignment(SwingConstants.CENTER);
		lblCourtesyCode.setBounds(323, 202, 137, 16);
		panel_1.add(lblCourtesyCode);

		JLabel lblCreditRating = new JLabel("Credit Rating");
		lblCreditRating.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreditRating.setBounds(323, 226, 137, 16);
		panel_1.add(lblCreditRating);

		JLabel lblContractCode = new JLabel("Contract Code");
		lblContractCode.setHorizontalAlignment(SwingConstants.CENTER);
		lblContractCode.setBounds(323, 250, 137, 16);
		panel_1.add(lblContractCode);

		JLabel lblContractEffectiveDate = new JLabel("Contract Effective Date");
		lblContractEffectiveDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblContractEffectiveDate.setBounds(323, 274, 137, 16);
		panel_1.add(lblContractEffectiveDate);

		JLabel lblContractAmount = new JLabel("Contract Amount");
		lblContractAmount.setHorizontalAlignment(SwingConstants.CENTER);
		lblContractAmount.setBounds(323, 298, 137, 16);
		panel_1.add(lblContractAmount);

		JLabel lblContractPeriod = new JLabel("Contract Period");
		lblContractPeriod.setHorizontalAlignment(SwingConstants.CENTER);
		lblContractPeriod.setBounds(641, 10, 137, 16);
		panel_1.add(lblContractPeriod);

		JLabel lblInterestCode = new JLabel("Interest Code");
		lblInterestCode.setHorizontalAlignment(SwingConstants.CENTER);
		lblInterestCode.setBounds(641, 34, 137, 16);
		panel_1.add(lblInterestCode);

		JLabel lblTransferBadDebt = new JLabel("Transfer Bad Debt Code");
		lblTransferBadDebt.setHorizontalAlignment(SwingConstants.CENTER);
		lblTransferBadDebt.setBounds(641, 58, 137, 16);
		panel_1.add(lblTransferBadDebt);

		JLabel lblTransferBadDebt_1 = new JLabel("Transfer Bad Debt Date");
		lblTransferBadDebt_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTransferBadDebt_1.setBounds(641, 82, 137, 16);
		panel_1.add(lblTransferBadDebt_1);

		JLabel lblBadDebtAgency = new JLabel("Bad Debt Agency Code");
		lblBadDebtAgency.setHorizontalAlignment(SwingConstants.CENTER);
		lblBadDebtAgency.setBounds(641, 106, 137, 16);
		panel_1.add(lblBadDebtAgency);

		JLabel lblBadDebtTransfer = new JLabel("Bad Debt TRF Amount");
		lblBadDebtTransfer.setHorizontalAlignment(SwingConstants.CENTER);
		lblBadDebtTransfer.setBounds(641, 130, 137, 16);
		panel_1.add(lblBadDebtTransfer);

		JLabel lblBadDebtRecovery = new JLabel("Bad Debt Recovery Amt");
		lblBadDebtRecovery.setHorizontalAlignment(SwingConstants.CENTER);
		lblBadDebtRecovery.setBounds(641, 154, 137, 16);
		panel_1.add(lblBadDebtRecovery);

		JLabel lblDeleteAccountIndicator = new JLabel("Delete Acct Indicator");
		lblDeleteAccountIndicator.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeleteAccountIndicator.setBounds(641, 178, 137, 16);
		panel_1.add(lblDeleteAccountIndicator);

		JLabel lblDeleteAccountDate = new JLabel("Delete Account Date");
		lblDeleteAccountDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeleteAccountDate.setBounds(641, 202, 137, 16);
		panel_1.add(lblDeleteAccountDate);

		JLabel lblDischargeDisposition = new JLabel("Discharge Disposition");
		lblDischargeDisposition.setHorizontalAlignment(SwingConstants.CENTER);
		lblDischargeDisposition.setBounds(641, 226, 137, 16);
		panel_1.add(lblDischargeDisposition);

		JLabel lblDischargeToLocation = new JLabel("Discharge to Location");
		lblDischargeToLocation.setHorizontalAlignment(SwingConstants.CENTER);
		lblDischargeToLocation.setBounds(641, 250, 137, 16);
		panel_1.add(lblDischargeToLocation);

		JLabel lblDietType = new JLabel("Diet Type");
		lblDietType.setHorizontalAlignment(SwingConstants.CENTER);
		lblDietType.setBounds(641, 274, 137, 16);
		panel_1.add(lblDietType);

		JLabel lblServicingFacility = new JLabel("Servicing Facility");
		lblServicingFacility.setHorizontalAlignment(SwingConstants.CENTER);
		lblServicingFacility.setBounds(641, 298, 137, 16);
		panel_1.add(lblServicingFacility);

		JLabel lblBedStatus = new JLabel("Bed Status");
		lblBedStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblBedStatus.setBounds(959, 10, 137, 16);
		panel_1.add(lblBedStatus);

		JLabel lblAccountStatus = new JLabel("Account Status");
		lblAccountStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccountStatus.setBounds(959, 34, 137, 16);
		panel_1.add(lblAccountStatus);

		JLabel lblPendingLocation = new JLabel("Pending Location");
		lblPendingLocation.setHorizontalAlignment(SwingConstants.CENTER);
		lblPendingLocation.setBounds(959, 58, 137, 16);
		panel_1.add(lblPendingLocation);

		JLabel lblPriorTempLocation = new JLabel("Prior Temp Location");
		lblPriorTempLocation.setHorizontalAlignment(SwingConstants.CENTER);
		lblPriorTempLocation.setBounds(959, 82, 137, 16);
		panel_1.add(lblPriorTempLocation);

		JLabel lblAdmitDatetime = new JLabel("Admit Date / Time");
		lblAdmitDatetime.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdmitDatetime.setBounds(959, 106, 137, 16);
		panel_1.add(lblAdmitDatetime);

		tfContractPeriod = new JTextField();
		tfContractPeriod.setBackground(new Color(245, 245, 220));
		tfContractPeriod.setEnabled(false);
		tfContractPeriod.setColumns(10);
		tfContractPeriod.setBounds(786, 7, 166, 22);
		panel_1.add(tfContractPeriod);

		JLabel lblCurrentPatientBalance = new JLabel("Current Patient Balance");
		lblCurrentPatientBalance.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurrentPatientBalance.setBounds(959, 154, 137, 16);
		panel_1.add(lblCurrentPatientBalance);

		JLabel lblTotalCharges = new JLabel("Total Charges");
		lblTotalCharges.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalCharges.setBounds(959, 178, 137, 16);
		panel_1.add(lblTotalCharges);

		JLabel lblTotalAdjustments = new JLabel("Total Adjustments");
		lblTotalAdjustments.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalAdjustments.setBounds(959, 202, 137, 16);
		panel_1.add(lblTotalAdjustments);

		JLabel lblTotalPayments = new JLabel("Total Payments");
		lblTotalPayments.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalPayments.setBounds(959, 226, 137, 16);
		panel_1.add(lblTotalPayments);

		JLabel lblAlternateVisitId = new JLabel("Alternate Visit ID");
		lblAlternateVisitId.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlternateVisitId.setBounds(959, 250, 137, 16);
		panel_1.add(lblAlternateVisitId);

		JLabel lblVisitorIndicator = new JLabel("Visitor Indicator");
		lblVisitorIndicator.setHorizontalAlignment(SwingConstants.CENTER);
		lblVisitorIndicator.setBounds(959, 274, 137, 16);
		panel_1.add(lblVisitorIndicator);

		JLabel lblOtherHealthcareProvider = new JLabel("Other Care Provider");
		lblOtherHealthcareProvider.setHorizontalAlignment(SwingConstants.CENTER);
		lblOtherHealthcareProvider.setBounds(959, 298, 137, 16);
		panel_1.add(lblOtherHealthcareProvider);

		tfInterestCode = new JTextField();
		tfInterestCode.setBackground(new Color(245, 245, 220));
		tfInterestCode.setEnabled(false);
		tfInterestCode.setColumns(10);
		tfInterestCode.setBounds(786, 31, 166, 22);
		panel_1.add(tfInterestCode);

		tfAmbulatoryStatus = new JTextField();
		tfAmbulatoryStatus.setBackground(new Color(245, 245, 220));
		tfAmbulatoryStatus.setEnabled(false);
		tfAmbulatoryStatus.setColumns(10);
		tfAmbulatoryStatus.setBounds(466, 55, 166, 22);
		panel_1.add(tfAmbulatoryStatus);

		tfVIPIndicator = new JTextField();
		tfVIPIndicator.setBackground(new Color(245, 245, 220));
		tfVIPIndicator.setEnabled(false);
		tfVIPIndicator.setColumns(10);
		tfVIPIndicator.setBounds(466, 79, 166, 22);
		panel_1.add(tfVIPIndicator);

		tfAdmittingDoctor = new JTextField();
		tfAdmittingDoctor.setBackground(new Color(245, 245, 220));
		tfAdmittingDoctor.setEnabled(false);
		tfAdmittingDoctor.setColumns(10);
		tfAdmittingDoctor.setBounds(466, 103, 166, 22);
		panel_1.add(tfAdmittingDoctor);

		tfPatientType = new JTextField();
		tfPatientType.setBackground(new Color(245, 245, 220));
		tfPatientType.setEnabled(false);
		tfPatientType.setColumns(10);
		tfPatientType.setBounds(466, 127, 166, 22);
		panel_1.add(tfPatientType);

		tfFinancialClass = new JTextField();
		tfFinancialClass.setBackground(new Color(245, 245, 220));
		tfFinancialClass.setEnabled(false);
		tfFinancialClass.setColumns(10);
		tfFinancialClass.setBounds(466, 151, 166, 22);
		panel_1.add(tfFinancialClass);

		tfChargePriceIndicator = new JTextField();
		tfChargePriceIndicator.setBackground(new Color(245, 245, 220));
		tfChargePriceIndicator.setEnabled(false);
		tfChargePriceIndicator.setColumns(10);
		tfChargePriceIndicator.setBounds(466, 175, 166, 22);
		panel_1.add(tfChargePriceIndicator);

		tfCourtesyCode = new JTextField();
		tfCourtesyCode.setBackground(new Color(245, 245, 220));
		tfCourtesyCode.setEnabled(false);
		tfCourtesyCode.setColumns(10);
		tfCourtesyCode.setBounds(466, 199, 166, 22);
		panel_1.add(tfCourtesyCode);

		tfCreditRating = new JTextField();
		tfCreditRating.setBackground(new Color(245, 245, 220));
		tfCreditRating.setEnabled(false);
		tfCreditRating.setColumns(10);
		tfCreditRating.setBounds(466, 223, 166, 22);
		panel_1.add(tfCreditRating);

		tfContractCode = new JTextField();
		tfContractCode.setBackground(new Color(245, 245, 220));
		tfContractCode.setEnabled(false);
		tfContractCode.setColumns(10);
		tfContractCode.setBounds(466, 247, 166, 22);
		panel_1.add(tfContractCode);

		tfContractEffectiveDate = new JTextField();
		tfContractEffectiveDate.setBackground(new Color(245, 245, 220));
		tfContractEffectiveDate.setEnabled(false);
		tfContractEffectiveDate.setColumns(10);
		tfContractEffectiveDate.setBounds(466, 271, 166, 22);
		panel_1.add(tfContractEffectiveDate);

		tfContractAmount = new JTextField();
		tfContractAmount.setBackground(new Color(245, 245, 220));
		tfContractAmount.setEnabled(false);
		tfContractAmount.setColumns(10);
		tfContractAmount.setBounds(466, 295, 166, 22);
		panel_1.add(tfContractAmount);

		tfTransferBadDebtCode = new JTextField();
		tfTransferBadDebtCode.setBackground(new Color(245, 245, 220));
		tfTransferBadDebtCode.setEnabled(false);
		tfTransferBadDebtCode.setColumns(10);
		tfTransferBadDebtCode.setBounds(786, 55, 166, 22);
		panel_1.add(tfTransferBadDebtCode);

		tfTransferBadDebtDate = new JTextField();
		tfTransferBadDebtDate.setBackground(new Color(245, 245, 220));
		tfTransferBadDebtDate.setEnabled(false);
		tfTransferBadDebtDate.setColumns(10);
		tfTransferBadDebtDate.setBounds(786, 79, 166, 22);
		panel_1.add(tfTransferBadDebtDate);

		tfBadDebtAgencyCode = new JTextField();
		tfBadDebtAgencyCode.setBackground(new Color(245, 245, 220));
		tfBadDebtAgencyCode.setEnabled(false);
		tfBadDebtAgencyCode.setColumns(10);
		tfBadDebtAgencyCode.setBounds(786, 103, 166, 22);
		panel_1.add(tfBadDebtAgencyCode);

		tfBadDebtTRFAmount = new JTextField();
		tfBadDebtTRFAmount.setBackground(new Color(245, 245, 220));
		tfBadDebtTRFAmount.setEnabled(false);
		tfBadDebtTRFAmount.setColumns(10);
		tfBadDebtTRFAmount.setBounds(786, 127, 166, 22);
		panel_1.add(tfBadDebtTRFAmount);

		tfBadDebtRecoveryAmt = new JTextField();
		tfBadDebtRecoveryAmt.setBackground(new Color(245, 245, 220));
		tfBadDebtRecoveryAmt.setEnabled(false);
		tfBadDebtRecoveryAmt.setColumns(10);
		tfBadDebtRecoveryAmt.setBounds(786, 151, 166, 22);
		panel_1.add(tfBadDebtRecoveryAmt);

		tfDeleteAcctIndicator = new JTextField();
		tfDeleteAcctIndicator.setBackground(new Color(245, 245, 220));
		tfDeleteAcctIndicator.setEnabled(false);
		tfDeleteAcctIndicator.setColumns(10);
		tfDeleteAcctIndicator.setBounds(786, 175, 166, 22);
		panel_1.add(tfDeleteAcctIndicator);

		tfDeleteAccountDate = new JTextField();
		tfDeleteAccountDate.setBackground(new Color(245, 245, 220));
		tfDeleteAccountDate.setEnabled(false);
		tfDeleteAccountDate.setColumns(10);
		tfDeleteAccountDate.setBounds(786, 199, 166, 22);
		panel_1.add(tfDeleteAccountDate);

		tfDichargeDisposition = new JTextField();
		tfDichargeDisposition.setBackground(new Color(245, 245, 220));
		tfDichargeDisposition.setEnabled(false);
		tfDichargeDisposition.setColumns(10);
		tfDichargeDisposition.setBounds(786, 223, 166, 22);
		panel_1.add(tfDichargeDisposition);

		tfDischargeToLocation = new JTextField();
		tfDischargeToLocation.setBackground(new Color(245, 245, 220));
		tfDischargeToLocation.setEnabled(false);
		tfDischargeToLocation.setColumns(10);
		tfDischargeToLocation.setBounds(786, 247, 166, 22);
		panel_1.add(tfDischargeToLocation);

		tfDietType = new JTextField();
		tfDietType.setBackground(new Color(245, 245, 220));
		tfDietType.setEnabled(false);
		tfDietType.setColumns(10);
		tfDietType.setBounds(786, 271, 166, 22);
		panel_1.add(tfDietType);

		tfServicingFacility = new JTextField();
		tfServicingFacility.setBackground(new Color(245, 245, 220));
		tfServicingFacility.setEnabled(false);
		tfServicingFacility.setColumns(10);
		tfServicingFacility.setBounds(786, 295, 166, 22);
		panel_1.add(tfServicingFacility);

		tfAccountStatus = new JTextField();
		tfAccountStatus.setBackground(new Color(245, 245, 220));
		tfAccountStatus.setEnabled(false);
		tfAccountStatus.setColumns(10);
		tfAccountStatus.setBounds(1105, 31, 166, 22);
		panel_1.add(tfAccountStatus);

		tfPendingLocation = new JTextField();
		tfPendingLocation.setBackground(new Color(245, 245, 220));
		tfPendingLocation.setEnabled(false);
		tfPendingLocation.setColumns(10);
		tfPendingLocation.setBounds(1105, 55, 166, 22);
		panel_1.add(tfPendingLocation);

		tfPriorTempLocation = new JTextField();
		tfPriorTempLocation.setBackground(new Color(245, 245, 220));
		tfPriorTempLocation.setEnabled(false);
		tfPriorTempLocation.setColumns(10);
		tfPriorTempLocation.setBounds(1105, 79, 166, 22);
		panel_1.add(tfPriorTempLocation);

		tfADTAdmitDate = new JTextField();
		tfADTAdmitDate.setBackground(new Color(245, 245, 220));
		tfADTAdmitDate.setEnabled(false);
		tfADTAdmitDate.setColumns(10);
		tfADTAdmitDate.setBounds(1105, 103, 166, 22);
		panel_1.add(tfADTAdmitDate);

		tfCurrentPatientBalance = new JTextField();
		tfCurrentPatientBalance.setBackground(new Color(245, 245, 220));
		tfCurrentPatientBalance.setEnabled(false);
		tfCurrentPatientBalance.setColumns(10);
		tfCurrentPatientBalance.setBounds(1105, 151, 166, 22);
		panel_1.add(tfCurrentPatientBalance);

		tfTotalCharges = new JTextField();
		tfTotalCharges.setBackground(new Color(245, 245, 220));
		tfTotalCharges.setEnabled(false);
		tfTotalCharges.setColumns(10);
		tfTotalCharges.setBounds(1105, 175, 166, 22);
		panel_1.add(tfTotalCharges);

		tfTotalAdjustments = new JTextField();
		tfTotalAdjustments.setBackground(new Color(245, 245, 220));
		tfTotalAdjustments.setEnabled(false);
		tfTotalAdjustments.setColumns(10);
		tfTotalAdjustments.setBounds(1105, 199, 166, 22);
		panel_1.add(tfTotalAdjustments);

		tfTotalPayments = new JTextField();
		tfTotalPayments.setBackground(new Color(245, 245, 220));
		tfTotalPayments.setEnabled(false);
		tfTotalPayments.setColumns(10);
		tfTotalPayments.setBounds(1105, 223, 166, 22);
		panel_1.add(tfTotalPayments);

		tfAlternativeVisitID = new JTextField();
		tfAlternativeVisitID.setBackground(new Color(245, 245, 220));
		tfAlternativeVisitID.setEnabled(false);
		tfAlternativeVisitID.setColumns(10);
		tfAlternativeVisitID.setBounds(1105, 247, 166, 22);
		panel_1.add(tfAlternativeVisitID);

		tfVisitorIndicator = new JTextField();
		tfVisitorIndicator.setBackground(new Color(245, 245, 220));
		tfVisitorIndicator.setEnabled(false);
		tfVisitorIndicator.setColumns(10);
		tfVisitorIndicator.setBounds(1105, 271, 166, 22);
		panel_1.add(tfVisitorIndicator);

		tfOtherCareProvider = new JTextField();
		tfOtherCareProvider.setBackground(new Color(245, 245, 220));
		tfOtherCareProvider.setEnabled(false);
		tfOtherCareProvider.setColumns(10);
		tfOtherCareProvider.setBounds(1105, 295, 166, 22);
		panel_1.add(tfOtherCareProvider);

		tfBedStatus = new JTextField();
		tfBedStatus.setBackground(new Color(245, 245, 220));
		tfBedStatus.setEnabled(false);
		tfBedStatus.setColumns(10);
		tfBedStatus.setBounds(1105, 7, 166, 22);
		panel_1.add(tfBedStatus);

		JButton btnLoadADTTemplate = new JButton("Load Template");
		btnLoadADTTemplate.setForeground(new Color(0, 0, 0));
		btnLoadADTTemplate.setBackground(new Color(255, 250, 205));
		btnLoadADTTemplate.setBounds(5, 3, 117, 25);
		panelADT.add(btnLoadADTTemplate);

		JButton btnRefreshHL7 = new JButton("Refresh HL7");
		btnRefreshHL7.setBackground(new Color(255, 250, 205));
		btnRefreshHL7.setBounds(124, 3, 109, 25);
		panelADT.add(btnRefreshHL7);

		JButton btnBulkADT = new JButton("Bulk ADT");
		btnBulkADT.setBackground(new Color(255, 250, 205));
		btnBulkADT.setBounds(234, 3, 102, 25);
		panelADT.add(btnBulkADT);
		comboADTCreateType.setBackground(new Color(255, 250, 205));
		comboADTCreateType.setBounds(6, 30, 116, 24);
		panelADT.add(comboADTCreateType);

		// JComboBox<String> comboADTCreateType
		comboADTCreateType.setModel(new DefaultComboBoxModel<String>(new String[] { "Local", "Server" }));

		JButton btnCreateADT = new JButton("Create ADT");
		btnCreateADT.setBackground(new Color(255, 250, 205));
		btnCreateADT.setBounds(124, 30, 109, 25);
		panelADT.add(btnCreateADT);

		JButton btnCustomBulkAdt = new JButton("Custom Bulk");
		btnCustomBulkAdt.setBackground(new Color(255, 250, 205));
		btnCustomBulkAdt.setEnabled(false);
		btnCustomBulkAdt.setBounds(234, 30, 102, 25);
		panelADT.add(btnCustomBulkAdt);

		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(255, 250, 205));
		panel_7.setBorder(null);
		panel_7.setBounds(332, -11, 1018, 101);
		panelADT.add(panel_7);
		panel_7.setLayout(null);
		taHL7.setBounds(10, 16, 1008, 78);
		panel_7.add(taHL7);
		taHL7.setBackground(new Color(255, 255, 255));

		// JTextArea taHL7
		taHL7.setLineWrap(true);
		taHL7.setFont(new Font("Arial", Font.PLAIN, 12));
		taHL7.setEditable(false);
		chckbxADTOpt.setBackground(new Color(255, 250, 205));

		// JCheckBox chckbxOpt = new JCheckBox("Opt");
		chckbxADTOpt.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (chckbxADTOpt.isSelected())
					enableADTOptionalFields();
				else
					disableADTOptionalFields();
			}
		});
		chckbxADTOpt.setBounds(205, 663, 128, 25);
		panelADT.add(chckbxADTOpt);
		chckbxADTCond.setBackground(new Color(255, 250, 205));

		// JCheckBox chckbxCod = new JCheckBox("Cond");
		chckbxADTCond.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (chckbxADTCond.isSelected())
					enableADTConditionalFields();
				else
					disableADTConditionalFields();
			}
		});
		chckbxADTCond.setBounds(78, 663, 133, 25);
		panelADT.add(chckbxADTCond);
		lblADTStatus.setBounds(78, 667, 583, 16);
		panelADT.add(lblADTStatus);
		btnCustomBulkAdt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// final JFileChooser fc = new JFileChooser();
				// int returnVal = fc.showOpenDialog(frmScenarioBuilder);
				// if(returnVal == JFileChooser.APPROVE_OPTION)
				// {
				// try {
				// CSVReader.readCustomFile(fc.getSelectedFile());
				// } catch (ClassNotFoundException e1) {
				// e1.printStackTrace();
				// } catch (UnknownHostException e1) {
				// e1.printStackTrace();
				// } catch (IOException e1) {
				// e1.printStackTrace();
				// } catch (ParseException e1) {
				// e1.printStackTrace();
				// } catch (SQLException e1) {
				// e1.printStackTrace();
				// }
				// }
			}
		});
		btnCreateADT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboADTCreateType.getSelectedItem() == "Local") {
					try {
						Data.createADTFile(Data.pidArray[5], Data.compileHL7(), workingDirectory);
						lblADTStatus.setText("ADT - " + Data.pidArray[5] + " created in local directory");
						createLabelTimer(lblADTStatus, 5000);
					} catch (FileNotFoundException e1) {
						lblADTStatus.setText("Unable to create ADT file");
						createLabelTimer(lblADTStatus, 5000);
						e1.printStackTrace();
					} catch (NullPointerException e1) {
						JOptionPane.showMessageDialog(frmScenarioBuilder, "ADT fields are empty");
						e1.printStackTrace();
					}
				} else {
					try {
						populateHL7Message();
						Database.connectToDB();
						Database.insertADTRecord(Data.compileHL7());
						// Database.closeConnection();
						lblADTStatus.setText("ADT submitted to environment");
						createLabelTimer(lblADTStatus, 5000);
					} catch (SQLException e1) {
						lblADTStatus.setText("Unable to submit ADT to environment");
						createLabelTimer(lblADTStatus, 5000);
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					} catch (UnknownHostException e1) {
						e1.printStackTrace();
					} catch (NullPointerException e1) {
						JOptionPane.showMessageDialog(frmScenarioBuilder, "ADT fields are empty");
					}
				}
			}
		});
		btnBulkADT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int count = 0;
				try {
					setADTStatus("Starting bulk ADT parsing, please leave application running...");
					count = CSVReader.readFile();
					setADTStatus("ADT Records parsed - " + count);
					createLabelTimer(lblADTStatus, 5000);
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(frmScenarioBuilder, "Unable to connect to database");
					setADTStatus("");
					e1.printStackTrace();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnRefreshHL7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					populateHL7Message();
					displayHL7Message();
					// Micro.compileMicro();
				} catch (NullPointerException n) {
					System.err.println("HL7 Arrays are null");
				}
			}
		});
		btnLoadADTTemplate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!tfEncodingCharacters.getText().isEmpty()) {
					int selection = JOptionPane.showConfirmDialog(frmScenarioBuilder,
							"Are you sure you want to clear any progress and load the template?");
					if (selection == JOptionPane.YES_OPTION) {
						try {
							displayHL7Template();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						initialPopulateADTFields();
					}
				} else {
					try {
						displayHL7Template();
						initialPopulateADTFields();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		tabbedPane.addTab("Micro", null, scrollPane, null);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(null);
		panel_2.setBackground(new Color(255, 250, 205));
		panel_2.setPreferredSize(new Dimension(1360, 950));
		panel_2.setLayout(null);
		scrollPane.setViewportView(panel_2);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(263, 13, 1084, 124);
		panel_2.add(scrollPane_1);
		scrollPane_1.setViewportView(taMicro);

		// JTextArea taMicro
		taMicro.setWrapStyleWord(true);
		taMicro.setFont(new Font("Arial", Font.PLAIN, 12));
		taMicro.setEditable(false);

		Scrollbar scrollbar = new Scrollbar();
		scrollPane_1.setRowHeaderView(scrollbar);
		comboMicroOBR.setBackground(new Color(255, 250, 205));

		// JComboBox comboMicroOBR
		comboMicroOBR.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.DESELECTED) {
					Micro.getCurrentOBRSegments(comboMicroOBR);
					populateCurrentOBR();
					Micro.populateOBXDropdown(comboMicroOBR.getSelectedItem().toString(), comboMicroOBX);
					refreshMicroElementsCount(lblMicroOBXCount, comboMicroOBX);
				}
			}
		});
		comboMicroOBR.setBounds(12, 299, 81, 23);
		panel_2.add(comboMicroOBR);

		JButton btnMicroAddOrder = new JButton("Add OBR");
		btnMicroAddOrder.setBackground(new Color(255, 250, 205));
		btnMicroAddOrder.setEnabled(false);
		btnMicroAddOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addMicroOrder();
			}
		});
		btnMicroAddOrder.setBounds(101, 298, 97, 25);
		panel_2.add(btnMicroAddOrder);

		JButton btnRemoveObr = new JButton("Remove OBR");
		btnRemoveObr.setBackground(new Color(255, 250, 205));
		btnRemoveObr.setEnabled(false);
		btnRemoveObr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeMicroOrder();
			}
		});
		btnRemoveObr.setBounds(202, 298, 116, 25);
		panel_2.add(btnRemoveObr);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 224));
		panel_3.setLayout(null);
		panel_3.setBorder(null);
		panel_3.setBounds(10, 148, 1337, 139);
		panel_2.add(panel_3);

		JLabel label_78 = new JLabel("Order Control");
		label_78.setHorizontalAlignment(SwingConstants.CENTER);
		label_78.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_78.setBounds(9, 11, 125, 16);
		panel_3.add(label_78);

		tfOrderControl = new JTextField();
		tfOrderControl.setToolTipText("From ORC: RE");
		tfOrderControl.setColumns(10);
		tfOrderControl.setBounds(135, 7, 150, 22);
		panel_3.add(tfOrderControl);

		tfPlaceOrderNumber = new JTextField();
		tfPlaceOrderNumber.setToolTipText("Identifier for the order. Alphanumeric OK. Used as input.");
		tfPlaceOrderNumber.setColumns(10);
		tfPlaceOrderNumber.setBounds(135, 33, 150, 22);
		panel_3.add(tfPlaceOrderNumber);

		JLabel label_79 = new JLabel("Place Order Number");
		label_79.setHorizontalAlignment(SwingConstants.CENTER);
		label_79.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_79.setBounds(9, 36, 125, 16);
		panel_3.add(label_79);

		JLabel label_80 = new JLabel("Filler Order Number");
		label_80.setHorizontalAlignment(SwingConstants.CENTER);
		label_80.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_80.setBounds(9, 61, 125, 16);
		panel_3.add(label_80);

		tfFillerOrderNumber = new JTextField();
		tfFillerOrderNumber.setToolTipText("Identifier for the order. Alphanumeric OK. Used as input.");
		tfFillerOrderNumber.setColumns(10);
		tfFillerOrderNumber.setBounds(135, 59, 150, 22);
		panel_3.add(tfFillerOrderNumber);

		JLabel label_81 = new JLabel("Placer Group Number");
		label_81.setHorizontalAlignment(SwingConstants.CENTER);
		label_81.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_81.setBounds(9, 86, 125, 16);
		panel_3.add(label_81);

		tfPlacerGroupNumber = new JTextField();
		tfPlacerGroupNumber.setColumns(10);
		tfPlacerGroupNumber.setBounds(135, 85, 150, 22);
		panel_3.add(tfPlacerGroupNumber);

		tfOrderStatus = new JTextField();
		tfOrderStatus.setToolTipText(
				"TheraDoc stores this value but uses the Order Control Code (ORC-1) to determine the status");
		tfOrderStatus.setEnabled(false);
		tfOrderStatus.setColumns(10);
		tfOrderStatus.setBounds(135, 111, 150, 22);
		panel_3.add(tfOrderStatus);

		JLabel label_82 = new JLabel("Order Status");
		label_82.setHorizontalAlignment(SwingConstants.CENTER);
		label_82.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_82.setBounds(9, 111, 125, 16);
		panel_3.add(label_82);

		JLabel label_83 = new JLabel("Response Flag");
		label_83.setHorizontalAlignment(SwingConstants.CENTER);
		label_83.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_83.setBounds(285, 11, 168, 16);
		panel_3.add(label_83);

		JLabel label_84 = new JLabel("Quantity/Timing");
		label_84.setHorizontalAlignment(SwingConstants.CENTER);
		label_84.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_84.setBounds(285, 36, 168, 16);
		panel_3.add(label_84);

		JLabel label_85 = new JLabel("Parent");
		label_85.setHorizontalAlignment(SwingConstants.CENTER);
		label_85.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_85.setBounds(285, 61, 168, 16);
		panel_3.add(label_85);

		tfOrderControlCodeReason = new JTextField();
		tfOrderControlCodeReason.setBackground(new Color(245, 245, 220));
		tfOrderControlCodeReason.setEnabled(false);
		tfOrderControlCodeReason.setColumns(10);
		tfOrderControlCodeReason.setBounds(1097, 7, 150, 22);
		panel_3.add(tfOrderControlCodeReason);

		tfResponseFlag = new JTextField();
		tfResponseFlag.setColumns(10);
		tfResponseFlag.setBounds(452, 7, 150, 22);
		panel_3.add(tfResponseFlag);

		tfQuantityTiming = new JTextField();
		tfQuantityTiming.setEnabled(false);
		tfQuantityTiming.setColumns(10);
		tfQuantityTiming.setBounds(452, 33, 150, 22);
		panel_3.add(tfQuantityTiming);

		JLabel label_86 = new JLabel("Date/Time of Transaction");
		label_86.setHorizontalAlignment(SwingConstants.CENTER);
		label_86.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_86.setBounds(285, 86, 168, 16);
		panel_3.add(label_86);

		JLabel label_87 = new JLabel("Entered By");
		label_87.setHorizontalAlignment(SwingConstants.CENTER);
		label_87.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_87.setBounds(285, 111, 168, 16);
		panel_3.add(label_87);

		JLabel label_88 = new JLabel("Verified By");
		label_88.setHorizontalAlignment(SwingConstants.CENTER);
		label_88.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_88.setBounds(605, 11, 168, 16);
		panel_3.add(label_88);

		JLabel label_89 = new JLabel("Ordering Provider");
		label_89.setHorizontalAlignment(SwingConstants.CENTER);
		label_89.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_89.setBounds(605, 36, 168, 16);
		panel_3.add(label_89);

		JLabel label_90 = new JLabel("Enterer's Location");
		label_90.setHorizontalAlignment(SwingConstants.CENTER);
		label_90.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_90.setBounds(605, 61, 168, 16);
		panel_3.add(label_90);

		JLabel label_91 = new JLabel("Call Back Phone Number");
		label_91.setHorizontalAlignment(SwingConstants.CENTER);
		label_91.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_91.setBounds(605, 86, 168, 16);
		panel_3.add(label_91);

		JLabel label_92 = new JLabel("Order Effective Date/Time");
		label_92.setHorizontalAlignment(SwingConstants.CENTER);
		label_92.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_92.setBounds(605, 111, 168, 16);
		panel_3.add(label_92);

		JLabel label_93 = new JLabel("Order Control Code Reason");
		label_93.setHorizontalAlignment(SwingConstants.CENTER);
		label_93.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_93.setBounds(927, 11, 168, 16);
		panel_3.add(label_93);

		tfParent = new JTextField();
		tfParent.setColumns(10);
		tfParent.setBounds(452, 59, 150, 22);
		panel_3.add(tfParent);

		tfDateTimeTransaction = new JTextField();
		tfDateTimeTransaction.setEnabled(false);
		tfDateTimeTransaction.setColumns(10);
		tfDateTimeTransaction.setBounds(452, 85, 150, 22);
		panel_3.add(tfDateTimeTransaction);

		tfEnteredBy = new JTextField();
		tfEnteredBy.setBackground(new Color(245, 245, 220));
		tfEnteredBy.setEnabled(false);
		tfEnteredBy.setColumns(10);
		tfEnteredBy.setBounds(452, 111, 150, 22);
		panel_3.add(tfEnteredBy);

		tfEnteringOrganization = new JTextField();
		tfEnteringOrganization.setBackground(new Color(245, 245, 220));
		tfEnteringOrganization.setEnabled(false);
		tfEnteringOrganization.setColumns(10);
		tfEnteringOrganization.setBounds(1097, 33, 150, 22);
		panel_3.add(tfEnteringOrganization);

		tfVerifiedBy = new JTextField();
		tfVerifiedBy.setEnabled(false);
		tfVerifiedBy.setColumns(10);
		tfVerifiedBy.setBounds(775, 7, 150, 22);
		panel_3.add(tfVerifiedBy);

		tfOrderingProvider = new JTextField();
		tfOrderingProvider.setEnabled(false);
		tfOrderingProvider.setColumns(10);
		tfOrderingProvider.setBounds(775, 33, 150, 22);
		panel_3.add(tfOrderingProvider);

		tfEnterersLocation = new JTextField();
		tfEnterersLocation.setEnabled(false);
		tfEnterersLocation.setColumns(10);
		tfEnterersLocation.setBounds(775, 59, 150, 22);
		panel_3.add(tfEnterersLocation);

		tfCallbackPhone = new JTextField();
		tfCallbackPhone.setEnabled(false);
		tfCallbackPhone.setColumns(10);
		tfCallbackPhone.setBounds(775, 85, 150, 22);
		panel_3.add(tfCallbackPhone);

		JLabel label_94 = new JLabel("Entering Organization");
		label_94.setHorizontalAlignment(SwingConstants.CENTER);
		label_94.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_94.setBounds(927, 36, 168, 16);
		panel_3.add(label_94);

		JLabel label_95 = new JLabel("Entering Device");
		label_95.setHorizontalAlignment(SwingConstants.CENTER);
		label_95.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_95.setBounds(927, 61, 168, 16);
		panel_3.add(label_95);

		JLabel label_96 = new JLabel("Action By");
		label_96.setHorizontalAlignment(SwingConstants.CENTER);
		label_96.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_96.setBounds(927, 86, 168, 16);
		panel_3.add(label_96);

		tfOrderEffectiveDateTime = new JTextField();
		tfOrderEffectiveDateTime.setColumns(10);
		tfOrderEffectiveDateTime.setBounds(775, 111, 150, 22);
		panel_3.add(tfOrderEffectiveDateTime);

		tfEnteringDevice = new JTextField();
		tfEnteringDevice.setBackground(new Color(245, 245, 220));
		tfEnteringDevice.setEnabled(false);
		tfEnteringDevice.setColumns(10);
		tfEnteringDevice.setBounds(1097, 59, 150, 22);
		panel_3.add(tfEnteringDevice);

		tfActionBy = new JTextField();
		tfActionBy.setBackground(new Color(245, 245, 220));
		tfActionBy.setEnabled(false);
		tfActionBy.setColumns(10);
		tfActionBy.setBounds(1097, 85, 150, 22);
		panel_3.add(tfActionBy);

		JLabel lblObrCount = new JLabel("OBR Count: ");
		lblObrCount.setBounds(474, 302, 70, 16);
		panel_2.add(lblObrCount);

		JCheckBox checkBoxMicroOpt = new JCheckBox("Optional Fields");
		checkBoxMicroOpt.setEnabled(false);
		checkBoxMicroOpt.setBackground(new Color(255, 250, 205));
		checkBoxMicroOpt.setBounds(550, 298, 102, 25);
		panel_2.add(checkBoxMicroOpt);

		JCheckBox checkBoxMicroCond = new JCheckBox("Conditional Fields");
		checkBoxMicroCond.setBackground(new Color(255, 250, 205));
		checkBoxMicroCond.setEnabled(false);
		checkBoxMicroCond.setBounds(654, 298, 128, 25);
		panel_2.add(checkBoxMicroCond);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 255, 224));
		panel_5.setLayout(null);
		panel_5.setBorder(null);
		panel_5.setBounds(12, 333, 1336, 366);
		panel_2.add(panel_5);

		JLabel label_98 = new JLabel("Place Order Number");
		label_98.setHorizontalAlignment(SwingConstants.CENTER);
		label_98.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_98.setBounds(3, 10, 180, 16);
		panel_5.add(label_98);

		JLabel label_99 = new JLabel("Filler Order Number");
		label_99.setHorizontalAlignment(SwingConstants.CENTER);
		label_99.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_99.setBounds(3, 35, 180, 16);
		panel_5.add(label_99);

		JLabel label_100 = new JLabel("Universal Service Identifier");
		label_100.setHorizontalAlignment(SwingConstants.CENTER);
		label_100.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_100.setBounds(3, 60, 180, 16);
		panel_5.add(label_100);

		JLabel label_102 = new JLabel("Priority");
		label_102.setHorizontalAlignment(SwingConstants.CENTER);
		label_102.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_102.setBounds(3, 85, 180, 16);
		panel_5.add(label_102);

		JLabel label_103 = new JLabel("Requested Date/Time");
		label_103.setHorizontalAlignment(SwingConstants.CENTER);
		label_103.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_103.setBounds(3, 110, 180, 16);
		panel_5.add(label_103);

		JLabel label_104 = new JLabel("Observation Date/Time");
		label_104.setHorizontalAlignment(SwingConstants.CENTER);
		label_104.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_104.setBounds(3, 135, 180, 16);
		panel_5.add(label_104);

		JLabel label_105 = new JLabel("Observation End Date/Time");
		label_105.setHorizontalAlignment(SwingConstants.CENTER);
		label_105.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_105.setBounds(3, 160, 180, 16);
		panel_5.add(label_105);

		tfOBRUniversalServiceIdentifier = new JTextField();
		tfOBRUniversalServiceIdentifier.setToolTipText("In format of 12345^Culture, Cystic Respiratory");
		tfOBRUniversalServiceIdentifier.setColumns(10);
		tfOBRUniversalServiceIdentifier.setBounds(185, 57, 234, 22);
		panel_5.add(tfOBRUniversalServiceIdentifier);

		tfOBRPlaceOrderNumber = new JTextField();
		tfOBRPlaceOrderNumber.setToolTipText("MUST MATCH ORC Placer Order Number.");
		tfOBRPlaceOrderNumber.setColumns(10);
		tfOBRPlaceOrderNumber.setBounds(185, 7, 234, 22);
		panel_5.add(tfOBRPlaceOrderNumber);

		tfOBRFillerOrderNumber = new JTextField();
		tfOBRFillerOrderNumber.setToolTipText("In format of Filler123^HNAM_ORDERID-60131-^HNAM_ORDERID");
		tfOBRFillerOrderNumber.setColumns(10);
		tfOBRFillerOrderNumber.setBounds(185, 32, 234, 22);
		panel_5.add(tfOBRFillerOrderNumber);

		JLabel label_106 = new JLabel("Collection Volume");
		label_106.setHorizontalAlignment(SwingConstants.CENTER);
		label_106.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_106.setBounds(3, 185, 180, 16);
		panel_5.add(label_106);

		JLabel label_107 = new JLabel("Collector Identifier");
		label_107.setHorizontalAlignment(SwingConstants.CENTER);
		label_107.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_107.setBounds(3, 210, 180, 16);
		panel_5.add(label_107);

		JLabel label_108 = new JLabel("Specimen Action Code");
		label_108.setHorizontalAlignment(SwingConstants.CENTER);
		label_108.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_108.setBounds(3, 235, 180, 16);
		panel_5.add(label_108);

		JLabel label_109 = new JLabel("Danger Code");
		label_109.setHorizontalAlignment(SwingConstants.CENTER);
		label_109.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_109.setBounds(3, 260, 180, 16);
		panel_5.add(label_109);

		JLabel label_110 = new JLabel("Relevant Clinical Information");
		label_110.setHorizontalAlignment(SwingConstants.CENTER);
		label_110.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_110.setBounds(3, 285, 180, 16);
		panel_5.add(label_110);

		JLabel label_111 = new JLabel("Specimen Received Date/Time");
		label_111.setHorizontalAlignment(SwingConstants.CENTER);
		label_111.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_111.setBounds(3, 310, 180, 16);
		panel_5.add(label_111);

		JLabel label_112 = new JLabel("Specimen Source");
		label_112.setHorizontalAlignment(SwingConstants.CENTER);
		label_112.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_112.setBounds(3, 335, 180, 16);
		panel_5.add(label_112);

		JLabel label_113 = new JLabel("Ordering Provider");
		label_113.setHorizontalAlignment(SwingConstants.CENTER);
		label_113.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_113.setBounds(418, 10, 215, 16);
		panel_5.add(label_113);

		tfOBRPriority = new JTextField();
		tfOBRPriority.setEnabled(false);
		tfOBRPriority.setColumns(10);
		tfOBRPriority.setBounds(185, 82, 234, 22);
		panel_5.add(tfOBRPriority);

		tfOBRRequestedDateTime = new JTextField();
		tfOBRRequestedDateTime.setToolTipText("Must be YYYYMMDDHHMMSS");
		tfOBRRequestedDateTime.setColumns(10);
		tfOBRRequestedDateTime.setBounds(185, 107, 234, 22);
		panel_5.add(tfOBRRequestedDateTime);

		tfOBRObservationDateTime = new JTextField();
		tfOBRObservationDateTime.setToolTipText("Must be YYYYMMDDHHMMSS");
		tfOBRObservationDateTime.setColumns(10);
		tfOBRObservationDateTime.setBounds(185, 132, 234, 22);
		panel_5.add(tfOBRObservationDateTime);

		tfOBRObservationEndDateTime = new JTextField();
		tfOBRObservationEndDateTime.setToolTipText("Must be YYYYMMDDHHMMSS");
		tfOBRObservationEndDateTime.setColumns(10);
		tfOBRObservationEndDateTime.setBounds(185, 157, 234, 22);
		panel_5.add(tfOBRObservationEndDateTime);

		JLabel label_114 = new JLabel("Order Callback Phone Number");
		label_114.setHorizontalAlignment(SwingConstants.CENTER);
		label_114.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_114.setBounds(418, 35, 215, 16);
		panel_5.add(label_114);

		JLabel label_115 = new JLabel("Placer Field 1");
		label_115.setHorizontalAlignment(SwingConstants.CENTER);
		label_115.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_115.setBounds(418, 60, 215, 16);
		panel_5.add(label_115);

		JLabel label_116 = new JLabel("Placer Field 2");
		label_116.setHorizontalAlignment(SwingConstants.CENTER);
		label_116.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_116.setBounds(418, 85, 215, 16);
		panel_5.add(label_116);

		JLabel label_117 = new JLabel("Filler Field 1");
		label_117.setHorizontalAlignment(SwingConstants.CENTER);
		label_117.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_117.setBounds(418, 110, 215, 16);
		panel_5.add(label_117);

		JLabel label_118 = new JLabel("Filler Field 2");
		label_118.setHorizontalAlignment(SwingConstants.CENTER);
		label_118.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_118.setBounds(418, 135, 215, 16);
		panel_5.add(label_118);

		JLabel label_119 = new JLabel("Results Rpt/Status Chng - Date/Time");
		label_119.setHorizontalAlignment(SwingConstants.CENTER);
		label_119.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_119.setBounds(423, 160, 215, 16);
		panel_5.add(label_119);

		JLabel lblCollectorsComment = new JLabel("Collectors Comment");
		lblCollectorsComment.setHorizontalAlignment(SwingConstants.CENTER);
		lblCollectorsComment.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCollectorsComment.setBounds(891, 235, 234, 16);
		panel_5.add(lblCollectorsComment);

		JLabel lblTransportArrangement = new JLabel("Transport Arrangement");
		lblTransportArrangement.setHorizontalAlignment(SwingConstants.CENTER);
		lblTransportArrangement.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTransportArrangement.setBounds(891, 260, 234, 16);
		panel_5.add(lblTransportArrangement);

		JLabel label_122 = new JLabel("Charge To Practice");
		label_122.setHorizontalAlignment(SwingConstants.CENTER);
		label_122.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_122.setBounds(418, 185, 215, 16);
		panel_5.add(label_122);

		JLabel label_123 = new JLabel("Diagnostic Service Section ID");
		label_123.setHorizontalAlignment(SwingConstants.CENTER);
		label_123.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_123.setBounds(418, 210, 215, 16);
		panel_5.add(label_123);

		JLabel label_124 = new JLabel("Result Status");
		label_124.setHorizontalAlignment(SwingConstants.CENTER);
		label_124.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_124.setBounds(418, 235, 215, 16);
		panel_5.add(label_124);

		JLabel label_125 = new JLabel("Parent Result");
		label_125.setHorizontalAlignment(SwingConstants.CENTER);
		label_125.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_125.setBounds(418, 260, 215, 16);
		panel_5.add(label_125);

		JLabel label_126 = new JLabel("Quantity/Timing");
		label_126.setHorizontalAlignment(SwingConstants.CENTER);
		label_126.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_126.setBounds(418, 285, 215, 16);
		panel_5.add(label_126);

		JLabel label_127 = new JLabel("Result Copies To");
		label_127.setHorizontalAlignment(SwingConstants.CENTER);
		label_127.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_127.setBounds(418, 310, 215, 16);
		panel_5.add(label_127);

		JLabel lblParentNumber = new JLabel("Parent Number");
		lblParentNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblParentNumber.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblParentNumber.setBounds(418, 335, 215, 16);
		panel_5.add(lblParentNumber);

		JLabel lblTransportationcode = new JLabel("Transportation Mode");
		lblTransportationcode.setHorizontalAlignment(SwingConstants.CENTER);
		lblTransportationcode.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTransportationcode.setBounds(891, 10, 234, 16);
		panel_5.add(lblTransportationcode);

		JLabel lblReasonForStudy = new JLabel("Reason For Study");
		lblReasonForStudy.setHorizontalAlignment(SwingConstants.CENTER);
		lblReasonForStudy.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblReasonForStudy.setBounds(891, 35, 234, 16);
		panel_5.add(lblReasonForStudy);

		JLabel lblPrincipalResultInterpreter = new JLabel("Principal Result Interpreter");
		lblPrincipalResultInterpreter.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrincipalResultInterpreter.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPrincipalResultInterpreter.setBounds(891, 60, 234, 16);
		panel_5.add(lblPrincipalResultInterpreter);

		JLabel lblAssistantResultInterpreter = new JLabel("Assistant Result Interpreter");
		lblAssistantResultInterpreter.setHorizontalAlignment(SwingConstants.CENTER);
		lblAssistantResultInterpreter.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAssistantResultInterpreter.setBounds(891, 85, 234, 16);
		panel_5.add(lblAssistantResultInterpreter);

		JLabel lblTechnician = new JLabel("Technician");
		lblTechnician.setHorizontalAlignment(SwingConstants.CENTER);
		lblTechnician.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTechnician.setBounds(891, 110, 234, 16);
		panel_5.add(lblTechnician);

		JLabel lblTranscriptionist = new JLabel("Transcriptionist");
		lblTranscriptionist.setHorizontalAlignment(SwingConstants.CENTER);
		lblTranscriptionist.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTranscriptionist.setBounds(891, 135, 234, 16);
		panel_5.add(lblTranscriptionist);

		JLabel lblScheduledDatetime = new JLabel("Scheduled Date/Time");
		lblScheduledDatetime.setHorizontalAlignment(SwingConstants.CENTER);
		lblScheduledDatetime.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblScheduledDatetime.setBounds(891, 160, 234, 16);
		panel_5.add(lblScheduledDatetime);

		JLabel lblNumberOfSamples = new JLabel("Number of Samples Containers");
		lblNumberOfSamples.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumberOfSamples.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNumberOfSamples.setBounds(891, 185, 234, 16);
		panel_5.add(lblNumberOfSamples);

		JLabel lblTransportLogisticsOf = new JLabel("Transport Logistics Of Collected Sample");
		lblTransportLogisticsOf.setHorizontalAlignment(SwingConstants.CENTER);
		lblTransportLogisticsOf.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTransportLogisticsOf.setBounds(891, 210, 234, 16);
		panel_5.add(lblTransportLogisticsOf);

		tfOBRCollectionVolume = new JTextField();
		tfOBRCollectionVolume.setColumns(10);
		tfOBRCollectionVolume.setBounds(185, 182, 234, 22);
		panel_5.add(tfOBRCollectionVolume);

		tfOBRCollectorIdentifier = new JTextField();
		tfOBRCollectorIdentifier.setEnabled(false);
		tfOBRCollectorIdentifier.setColumns(10);
		tfOBRCollectorIdentifier.setBounds(185, 207, 234, 22);
		panel_5.add(tfOBRCollectorIdentifier);

		tfOBRSpecimenActionCode = new JTextField();
		tfOBRSpecimenActionCode.setEnabled(false);
		tfOBRSpecimenActionCode.setColumns(10);
		tfOBRSpecimenActionCode.setBounds(185, 232, 234, 22);
		panel_5.add(tfOBRSpecimenActionCode);

		tfOBRDangerCode = new JTextField();
		tfOBRDangerCode.setEnabled(false);
		tfOBRDangerCode.setColumns(10);
		tfOBRDangerCode.setBounds(185, 257, 234, 22);
		panel_5.add(tfOBRDangerCode);

		tfOBRRelevantClinicalInfo = new JTextField();
		tfOBRRelevantClinicalInfo.setEnabled(false);
		tfOBRRelevantClinicalInfo.setColumns(10);
		tfOBRRelevantClinicalInfo.setBounds(185, 282, 234, 22);
		panel_5.add(tfOBRRelevantClinicalInfo);

		tfOBRSpecimenReceivedDateTime = new JTextField();
		tfOBRSpecimenReceivedDateTime.setToolTipText("Must be YYYYMMDDHHMMSS");
		tfOBRSpecimenReceivedDateTime.setColumns(10);
		tfOBRSpecimenReceivedDateTime.setBounds(185, 307, 234, 22);
		panel_5.add(tfOBRSpecimenReceivedDateTime);

		tfOBROrderCallbackPhone = new JTextField();
		tfOBROrderCallbackPhone.setEnabled(false);
		tfOBROrderCallbackPhone.setColumns(10);
		tfOBROrderCallbackPhone.setBounds(643, 32, 234, 22);
		panel_5.add(tfOBROrderCallbackPhone);

		tfOBRSpecimenSource = new JTextField();
		tfOBRSpecimenSource.setToolTipText("In format e.g. ^^^Blood or ^^^Cystic Sputum");
		tfOBRSpecimenSource.setColumns(10);
		tfOBRSpecimenSource.setBounds(185, 332, 234, 22);
		panel_5.add(tfOBRSpecimenSource);

		tfOBROrderingProvider = new JTextField();
		tfOBROrderingProvider.setToolTipText("In format of ProvNum^FamilyName^GivenName^Middle Name");
		tfOBROrderingProvider.setColumns(10);
		tfOBROrderingProvider.setBounds(643, 7, 234, 22);
		panel_5.add(tfOBROrderingProvider);

		tfOBRPlacerField1 = new JTextField();
		tfOBRPlacerField1.setToolTipText("");
		tfOBRPlacerField1.setColumns(10);
		tfOBRPlacerField1.setBounds(643, 57, 234, 22);
		panel_5.add(tfOBRPlacerField1);

		tfOBRPlacerField2 = new JTextField();
		tfOBRPlacerField2.setToolTipText("");
		tfOBRPlacerField2.setColumns(10);
		tfOBRPlacerField2.setBounds(643, 82, 234, 22);
		panel_5.add(tfOBRPlacerField2);

		tfOBRFillerField1 = new JTextField();
		tfOBRFillerField1
				.setToolTipText("Similar to Filler Order Number in format e.g. 12345^HNA_ACCN~70561727^HNA_ACCNID");
		tfOBRFillerField1.setColumns(10);
		tfOBRFillerField1.setBounds(643, 107, 234, 22);
		panel_5.add(tfOBRFillerField1);

		tfOBRFillerField2 = new JTextField();
		tfOBRFillerField2.setToolTipText("Similar to above e.g. 6789^HNA_ACCN~70561727^HNA_ACCNID");
		tfOBRFillerField2.setColumns(10);
		tfOBRFillerField2.setBounds(643, 132, 234, 22);
		panel_5.add(tfOBRFillerField2);

		tfOBRResultsRptStatusChng = new JTextField();
		tfOBRResultsRptStatusChng.setToolTipText(
				"Must be in YYYYMMDDHHMMSS; If no date is supplied in this field, TheraDoc will use the date from the MSH segment");
		tfOBRResultsRptStatusChng.setColumns(10);
		tfOBRResultsRptStatusChng.setBounds(643, 157, 234, 22);
		panel_5.add(tfOBRResultsRptStatusChng);

		tfOBRCollectorsComment = new JTextField();
		tfOBRCollectorsComment.setToolTipText("Any comment necessary");
		tfOBRCollectorsComment.setColumns(10);
		tfOBRCollectorsComment.setBounds(1126, 232, 200, 22);
		panel_5.add(tfOBRCollectorsComment);

		tfOBRTransportArrangement = new JTextField();
		tfOBRTransportArrangement.setBackground(new Color(245, 245, 220));
		tfOBRTransportArrangement.setEnabled(false);
		tfOBRTransportArrangement.setColumns(10);
		tfOBRTransportArrangement.setBounds(1126, 257, 200, 22);
		panel_5.add(tfOBRTransportArrangement);

		tfOBRChargeToPractice = new JTextField();
		tfOBRChargeToPractice.setEnabled(false);
		tfOBRChargeToPractice.setColumns(10);
		tfOBRChargeToPractice.setBounds(643, 182, 234, 22);
		panel_5.add(tfOBRChargeToPractice);

		tfOBRDiagnosticServiceSectionID = new JTextField();
		tfOBRDiagnosticServiceSectionID.setToolTipText("MB for Microbiology");
		tfOBRDiagnosticServiceSectionID.setColumns(10);
		tfOBRDiagnosticServiceSectionID.setBounds(643, 207, 234, 22);
		panel_5.add(tfOBRDiagnosticServiceSectionID);

		tfOBRResultsStatus = new JTextField();
		tfOBRResultsStatus.setToolTipText(
				"F: Final/ P: Preliminary/ C: Corrected/ I: In lab/ A: Amended/ R: Results/ X: no results/ O: order rcvd");
		tfOBRResultsStatus.setColumns(10);
		tfOBRResultsStatus.setBounds(643, 232, 234, 22);
		panel_5.add(tfOBRResultsStatus);

		tfOBRParentResult = new JTextField();
		tfOBRParentResult.setToolTipText("Obx Identifier of Parent Result ^ Obx Sub Id ^ Isolate Code & Isolate Text");
		tfOBRParentResult.setColumns(10);
		tfOBRParentResult.setBounds(643, 257, 234, 22);
		panel_5.add(tfOBRParentResult);

		tfOBRParentNumber = new JTextField();
		tfOBRParentNumber.setColumns(10);
		tfOBRParentNumber.setBounds(643, 332, 234, 22);
		panel_5.add(tfOBRParentNumber);

		tfOBRQuantityTiming = new JTextField();
		tfOBRQuantityTiming.setToolTipText("May be similar to format e.g. 1^^^20160317015538^^R~^^^^^R");
		tfOBRQuantityTiming.setColumns(10);
		tfOBRQuantityTiming.setBounds(643, 282, 234, 22);
		panel_5.add(tfOBRQuantityTiming);

		tfOBRResultCopiesTo = new JTextField();
		tfOBRResultCopiesTo.setToolTipText("Often as e.g. ^^");
		tfOBRResultCopiesTo.setColumns(10);
		tfOBRResultCopiesTo.setBounds(643, 307, 234, 22);
		panel_5.add(tfOBRResultCopiesTo);

		tfOBRTransportationMode = new JTextField();
		tfOBRTransportationMode.setBackground(new Color(245, 245, 220));
		tfOBRTransportationMode.setEnabled(false);
		tfOBRTransportationMode.setColumns(10);
		tfOBRTransportationMode.setBounds(1126, 7, 200, 22);
		panel_5.add(tfOBRTransportationMode);

		tfOBRReasonForStudy = new JTextField();
		tfOBRReasonForStudy.setBackground(new Color(245, 245, 220));
		tfOBRReasonForStudy.setEnabled(false);
		tfOBRReasonForStudy.setColumns(10);
		tfOBRReasonForStudy.setBounds(1126, 32, 200, 22);
		panel_5.add(tfOBRReasonForStudy);

		tfOBRPrincipalResultInterpreter = new JTextField();
		tfOBRPrincipalResultInterpreter.setEnabled(false);
		tfOBRPrincipalResultInterpreter.setColumns(10);
		tfOBRPrincipalResultInterpreter.setBounds(1126, 57, 200, 22);
		panel_5.add(tfOBRPrincipalResultInterpreter);

		tfOBRAssistantResultInterpreter = new JTextField();
		tfOBRAssistantResultInterpreter.setEnabled(false);
		tfOBRAssistantResultInterpreter.setColumns(10);
		tfOBRAssistantResultInterpreter.setBounds(1126, 82, 200, 22);
		panel_5.add(tfOBRAssistantResultInterpreter);

		tfOBRTechnician = new JTextField();
		tfOBRTechnician.setEnabled(false);
		tfOBRTechnician.setColumns(10);
		tfOBRTechnician.setBounds(1126, 107, 200, 22);
		panel_5.add(tfOBRTechnician);

		tfOBRTransportLogisiticsOfCollectedSample = new JTextField();
		tfOBRTransportLogisiticsOfCollectedSample.setBackground(new Color(245, 245, 220));
		tfOBRTransportLogisiticsOfCollectedSample.setEnabled(false);
		tfOBRTransportLogisiticsOfCollectedSample.setColumns(10);
		tfOBRTransportLogisiticsOfCollectedSample.setBounds(1126, 207, 200, 22);
		panel_5.add(tfOBRTransportLogisiticsOfCollectedSample);

		tfOBRTranscriptionist = new JTextField();
		tfOBRTranscriptionist.setEnabled(false);
		tfOBRTranscriptionist.setColumns(10);
		tfOBRTranscriptionist.setBounds(1126, 132, 200, 22);
		panel_5.add(tfOBRTranscriptionist);

		tfOBRScheduledDateTime = new JTextField();
		tfOBRScheduledDateTime.setToolTipText("Must be YYYYMMDDHHMMSS");
		tfOBRScheduledDateTime.setColumns(10);
		tfOBRScheduledDateTime.setBounds(1126, 157, 200, 22);
		panel_5.add(tfOBRScheduledDateTime);

		tfOBRNumberOfSamplesContainers = new JTextField();
		tfOBRNumberOfSamplesContainers.setToolTipText("e.g. 2");
		tfOBRNumberOfSamplesContainers.setColumns(10);
		tfOBRNumberOfSamplesContainers.setBounds(1126, 182, 200, 22);
		panel_5.add(tfOBRNumberOfSamplesContainers);

		JLabel lblTransportArranged = new JLabel("Transport Arranged");
		lblTransportArranged.setHorizontalAlignment(SwingConstants.CENTER);
		lblTransportArranged.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTransportArranged.setBounds(891, 285, 234, 16);
		panel_5.add(lblTransportArranged);

		JLabel lblEscortRequired = new JLabel("Escort Required");
		lblEscortRequired.setHorizontalAlignment(SwingConstants.CENTER);
		lblEscortRequired.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEscortRequired.setBounds(891, 310, 234, 16);
		panel_5.add(lblEscortRequired);

		JLabel lblPlannedPatientTransport = new JLabel("Planned Patient Transport Comment");
		lblPlannedPatientTransport.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlannedPatientTransport.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPlannedPatientTransport.setBounds(891, 335, 234, 16);
		panel_5.add(lblPlannedPatientTransport);

		tfOBRTransportArranged = new JTextField();
		tfOBRTransportArranged.setBackground(new Color(245, 245, 220));
		tfOBRTransportArranged.setEnabled(false);
		tfOBRTransportArranged.setColumns(10);
		tfOBRTransportArranged.setBounds(1126, 282, 200, 22);
		panel_5.add(tfOBRTransportArranged);

		tfOBREscortRequired = new JTextField();
		tfOBREscortRequired.setBackground(new Color(245, 245, 220));
		tfOBREscortRequired.setEnabled(false);
		tfOBREscortRequired.setColumns(10);
		tfOBREscortRequired.setBounds(1126, 307, 200, 22);
		panel_5.add(tfOBREscortRequired);

		tfOBRPlannedPatientTransportComment = new JTextField();
		tfOBRPlannedPatientTransportComment.setBackground(new Color(245, 245, 220));
		tfOBRPlannedPatientTransportComment.setEnabled(false);
		tfOBRPlannedPatientTransportComment.setColumns(10);
		tfOBRPlannedPatientTransportComment.setBounds(1126, 332, 200, 22);
		panel_5.add(tfOBRPlannedPatientTransportComment);

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(255, 255, 224));
		panel_6.setBorder(null);
		panel_6.setBounds(14, 744, 1334, 177);
		panel_2.add(panel_6);
		panel_6.setLayout(null);

		JLabel lblValueType = new JLabel("Value Type");
		lblValueType.setHorizontalAlignment(SwingConstants.CENTER);
		lblValueType.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblValueType.setBounds(12, 16, 180, 16);
		panel_6.add(lblValueType);

		tfOBXValueType = new JTextField();
		tfOBXValueType.setToolTipText("Such as CE: Coded Entry/ NM: numeric/ TX: Text Data/ ST: String data");
		tfOBXValueType.setColumns(10);
		tfOBXValueType.setBounds(194, 13, 234, 22);
		panel_6.add(tfOBXValueType);

		JLabel lblObservationIdentifier = new JLabel("Observation Identifier");
		lblObservationIdentifier.setHorizontalAlignment(SwingConstants.CENTER);
		lblObservationIdentifier.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblObservationIdentifier.setBounds(12, 41, 180, 16);
		panel_6.add(lblObservationIdentifier);

		tfOBXObservationIdentifier = new JTextField();
		tfOBXObservationIdentifier.setToolTipText("In form of 1234567^Antibiotic");
		tfOBXObservationIdentifier.setColumns(10);
		tfOBXObservationIdentifier.setBounds(194, 38, 234, 22);
		panel_6.add(tfOBXObservationIdentifier);

		JLabel lblObservationSubid = new JLabel("Observation Sub-ID");
		lblObservationSubid.setHorizontalAlignment(SwingConstants.CENTER);
		lblObservationSubid.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblObservationSubid.setBounds(12, 66, 180, 16);
		panel_6.add(lblObservationSubid);

		tfOBXObservationSubID = new JTextField();
		tfOBXObservationSubID.setToolTipText("");
		tfOBXObservationSubID.setColumns(10);
		tfOBXObservationSubID.setBounds(194, 63, 234, 22);
		panel_6.add(tfOBXObservationSubID);

		JLabel lblObservationValue = new JLabel("Observation Value");
		lblObservationValue.setHorizontalAlignment(SwingConstants.CENTER);
		lblObservationValue.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblObservationValue.setBounds(12, 91, 180, 16);
		panel_6.add(lblObservationValue);

		JLabel lblUnits = new JLabel("Units");
		lblUnits.setHorizontalAlignment(SwingConstants.CENTER);
		lblUnits.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUnits.setBounds(12, 116, 180, 16);
		panel_6.add(lblUnits);

		tfOBXObservationValue = new JTextField();
		tfOBXObservationValue.setToolTipText(
				"The numerical observed value for the observation identified. For Susceptibility this should be a measured value. e.g. 64+ or >16. ");
		tfOBXObservationValue.setColumns(10);
		tfOBXObservationValue.setBounds(194, 88, 234, 22);
		panel_6.add(tfOBXObservationValue);

		tfOBXUnits = new JTextField();
		tfOBXUnits.setToolTipText("Unit of measurement for Observation Value e.g. mcg/mL");
		tfOBXUnits.setColumns(10);
		tfOBXUnits.setBounds(194, 113, 234, 22);
		panel_6.add(tfOBXUnits);

		JLabel lblReferencesRange = new JLabel("References Range");
		lblReferencesRange.setHorizontalAlignment(SwingConstants.CENTER);
		lblReferencesRange.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblReferencesRange.setBounds(12, 142, 180, 16);
		panel_6.add(lblReferencesRange);

		tfOBXReferencesRange = new JTextField();
		tfOBXReferencesRange.setColumns(10);
		tfOBXReferencesRange.setBounds(194, 139, 234, 22);
		panel_6.add(tfOBXReferencesRange);

		JLabel lblAbnormalFlags = new JLabel("Abnormal Flags");
		lblAbnormalFlags.setHorizontalAlignment(SwingConstants.CENTER);
		lblAbnormalFlags.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAbnormalFlags.setBounds(435, 16, 180, 16);
		panel_6.add(lblAbnormalFlags);

		tfOBXAbnormalFlags = new JTextField();
		tfOBXAbnormalFlags
				.setToolTipText("L: Low/ H: High/ A: Abnormal/ S: Susceptible/ I: Intermediate/ R: Resistant");
		tfOBXAbnormalFlags.setColumns(10);
		tfOBXAbnormalFlags.setBounds(617, 13, 234, 22);
		panel_6.add(tfOBXAbnormalFlags);

		JLabel lblProbability = new JLabel("Probability");
		lblProbability.setHorizontalAlignment(SwingConstants.CENTER);
		lblProbability.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblProbability.setBounds(435, 41, 180, 16);
		panel_6.add(lblProbability);

		tfOBXProbability = new JTextField();
		tfOBXProbability.setColumns(10);
		tfOBXProbability.setBounds(617, 38, 234, 22);
		panel_6.add(tfOBXProbability);

		JLabel lblNatureOfAbnormal = new JLabel("Nature of Abnormal Test");
		lblNatureOfAbnormal.setHorizontalAlignment(SwingConstants.CENTER);
		lblNatureOfAbnormal.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNatureOfAbnormal.setBounds(435, 66, 180, 16);
		panel_6.add(lblNatureOfAbnormal);

		tfOBXNatureOfAbnormalTest = new JTextField();
		tfOBXNatureOfAbnormalTest.setColumns(10);
		tfOBXNatureOfAbnormalTest.setBounds(617, 63, 234, 22);
		panel_6.add(tfOBXNatureOfAbnormalTest);

		JLabel lblObservResultStatus = new JLabel("Observ Result Status");
		lblObservResultStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblObservResultStatus.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblObservResultStatus.setBounds(435, 91, 180, 16);
		panel_6.add(lblObservResultStatus);

		tfOBXObservResultStatus = new JTextField();
		tfOBXObservResultStatus.setToolTipText(
				"F: Final/ P: Preliminary/ I: In lab/ C: Corrected/ A: Amended/ R: Results/ X: No results/ O: Order rcvd");
		tfOBXObservResultStatus.setColumns(10);
		tfOBXObservResultStatus.setBounds(617, 88, 234, 22);
		panel_6.add(tfOBXObservResultStatus);

		JLabel lblDateLastObs = new JLabel("Date Last Obs Normal Values");
		lblDateLastObs.setHorizontalAlignment(SwingConstants.CENTER);
		lblDateLastObs.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDateLastObs.setBounds(435, 116, 180, 16);
		panel_6.add(lblDateLastObs);

		JLabel lblUserDefinedAccess = new JLabel("User Defined Access Checks");
		lblUserDefinedAccess.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserDefinedAccess.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUserDefinedAccess.setBounds(435, 142, 180, 16);
		panel_6.add(lblUserDefinedAccess);

		tfOBXDateLastObsNormalValues = new JTextField();
		tfOBXDateLastObsNormalValues.setToolTipText("Must be YYYYMMDDHHMMSS");
		tfOBXDateLastObsNormalValues.setColumns(10);
		tfOBXDateLastObsNormalValues.setBounds(617, 113, 234, 22);
		panel_6.add(tfOBXDateLastObsNormalValues);

		tfOBXUserDefinedAccessChecks = new JTextField();
		tfOBXUserDefinedAccessChecks.setToolTipText("Indicate that a susceptibility result is \"suppressed\": Y or N");
		tfOBXUserDefinedAccessChecks.setColumns(10);
		tfOBXUserDefinedAccessChecks.setBounds(617, 139, 234, 22);
		panel_6.add(tfOBXUserDefinedAccessChecks);

		JLabel lblDatetimeOfThe = new JLabel("Date/Time of the Observation");
		lblDatetimeOfThe.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatetimeOfThe.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDatetimeOfThe.setBounds(863, 16, 180, 16);
		panel_6.add(lblDatetimeOfThe);

		tfOBXDateTimeOfTheObservation = new JTextField();
		tfOBXDateTimeOfTheObservation.setToolTipText("Must be YYYYMMDDHHMMSS");
		tfOBXDateTimeOfTheObservation.setColumns(10);
		tfOBXDateTimeOfTheObservation.setBounds(1045, 13, 234, 22);
		panel_6.add(tfOBXDateTimeOfTheObservation);

		JLabel lblProducersId = new JLabel("Producer's ID");
		lblProducersId.setHorizontalAlignment(SwingConstants.CENTER);
		lblProducersId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblProducersId.setBounds(863, 41, 180, 16);
		panel_6.add(lblProducersId);

		tfOBXProducersID = new JTextField();
		tfOBXProducersID.setEnabled(false);
		tfOBXProducersID.setColumns(10);
		tfOBXProducersID.setBounds(1045, 38, 234, 22);
		panel_6.add(tfOBXProducersID);

		JLabel lblResponsibleObserver = new JLabel("Responsible Observer");
		lblResponsibleObserver.setHorizontalAlignment(SwingConstants.CENTER);
		lblResponsibleObserver.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblResponsibleObserver.setBounds(863, 66, 180, 16);
		panel_6.add(lblResponsibleObserver);

		tfOBXResponsibleObserver = new JTextField();
		tfOBXResponsibleObserver.setEnabled(false);
		tfOBXResponsibleObserver.setColumns(10);
		tfOBXResponsibleObserver.setBounds(1045, 63, 234, 22);
		panel_6.add(tfOBXResponsibleObserver);

		JLabel lblObservationMethod = new JLabel("Observation Method");
		lblObservationMethod.setHorizontalAlignment(SwingConstants.CENTER);
		lblObservationMethod.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblObservationMethod.setBounds(863, 91, 180, 16);
		panel_6.add(lblObservationMethod);

		tfOBXObservationMethod = new JTextField();
		tfOBXObservationMethod.setColumns(10);
		tfOBXObservationMethod.setBounds(1045, 88, 234, 22);
		panel_6.add(tfOBXObservationMethod);

		// JLabel lblMicroOBRCount
		lblMicroOBRCount.setBounds(534, 302, 56, 16);
		panel_2.add(lblMicroOBRCount);

		// btnCreateADT.addActionListener(new ActionListener() {
		// public void actionPerformed(ActionEvent e) {
		// if (comboADTCreateType.getSelectedItem() == "Local") {
		// try {
		// Data.createADTFile(Data.pidArray[5], Data.compileHL7(),
		// workingDirectory);
		// lblADTStatus.setText("ADT - " + Data.pidArray[5] + " created in local
		// directory");
		// createLabelTimer(lblADTStatus, 5000);
		// } catch (FileNotFoundException e1) {
		// lblADTStatus.setText("Unable to create ADT file");
		// createLabelTimer(lblADTStatus, 5000);
		// e1.printStackTrace();
		// } catch (NullPointerException e1) {
		// JOptionPane.showMessageDialog(frmScenarioBuilder, "ADT fields are
		// empty");
		// e1.printStackTrace();
		// }
		JButton btnCreateMicro = new JButton("Create Micro");
		btnCreateMicro.setBackground(new Color(255, 250, 205));
		btnCreateMicro.setEnabled(true);
		btnCreateMicro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboMicroCreateType.getSelectedItem() == "Local") {
					try {
						String enteredVal = JOptionPane.showInputDialog("Please name the file");
						Micro.createMicroFile(enteredVal, "Micro", workingDirectory);
						// Micro.createMicroFile(enteredVal, micro,
						// workingDirectory);
						lblMicroStatus.setText(enteredVal + "Micro created in local directory");
						createLabelTimer(lblMicroStatus, 5000);
					} catch (FileNotFoundException e1) {
						lblMicroStatus.setText("Unable to create file");
						createLabelTimer(lblMicroStatus, 5000);
						e1.printStackTrace();
					} catch (NullPointerException e1) {
						JOptionPane.showMessageDialog(frmScenarioBuilder, "Something is not right!");
						e1.printStackTrace();
					}
					// }else {
					// // populateMicroMessage();
					// // Database.connectToDB();
					// // Database.insertMicroRecord(Data.compileMicro());
					// // Database.closeConnection();
					// lblMicroStatus.setText("Micro submitted to environment");
					// createLabelTimer(lblMicroStatus, 5000);
				}
			}
		});
		btnCreateMicro.setBounds(137, 46, 117, 25);
		panel_2.add(btnCreateMicro);
		comboMicroOBX.setBackground(new Color(255, 250, 205));
		comboMicroOBX.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.DESELECTED) {
					ArrayList<String> currentOBRArray = Micro.currentOBR(comboMicroOBR.getSelectedItem());
					populateCurrentOBX(currentOBRArray, comboMicroOBX.getSelectedItem().toString());
				}
			}
		});

		// JComboBox<String> comboMicroOBX
		comboMicroOBX.setBounds(12, 710, 81, 23);
		panel_2.add(comboMicroOBX);

		JButton btnMicroAddOBX = new JButton("Add OBX");
		btnMicroAddOBX.setBackground(new Color(255, 250, 205));
		btnMicroAddOBX.setEnabled(false);
		btnMicroAddOBX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboMicroOBX.addItem("OBX " + (comboMicroOBX.getItemCount() + 1));
				refreshMicroElementsCount(lblMicroOBXCount, comboMicroOBX);
			}
		});
		btnMicroAddOBX.setBounds(101, 709, 97, 25);
		panel_2.add(btnMicroAddOBX);

		JButton btnMicroRemoveOBX = new JButton("Remove OBX");
		btnMicroRemoveOBX.setBackground(new Color(255, 250, 205));
		btnMicroRemoveOBX.setEnabled(false);
		btnMicroRemoveOBX.setBounds(202, 709, 116, 25);
		panel_2.add(btnMicroRemoveOBX);

		JLabel lblObservationCount = new JLabel("OBX Count: ");
		lblObservationCount.setBounds(474, 718, 70, 16);
		panel_2.add(lblObservationCount);

		// JLabel lblMicroOBXCount
		lblMicroOBXCount.setBounds(552, 718, 56, 16);
		panel_2.add(lblMicroOBXCount);
		comboMicroCreateType.setBackground(new Color(255, 250, 205));
		comboMicroCreateType.setEnabled(false);

		// JComboBox<String> comboMicroCreateType
		comboMicroCreateType.setModel(new DefaultComboBoxModel<String>(new String[] { "Local", "Server" }));
		comboMicroCreateType.setBounds(11, 47, 116, 24);
		panel_2.add(comboMicroCreateType);

		// JLabel lblMicroStatus
		lblMicroStatus.setBounds(1043, 650, 305, 16);
		panel_2.add(lblMicroStatus);

		JButton btnViewMicro = new JButton("Refresh HL7");
		btnViewMicro.setBackground(new Color(255, 250, 205));
		btnViewMicro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					saveORCValues();
					MicroWindow frmMicro = new MicroWindow(
							Micro.compileMicro() + "\r\n" + Micro.getArrayforOBR() + "\r\n");
					frmMicro.setVisible(true);
					// Micro.compileMicro();
				} catch (NullPointerException s) {
					JOptionPane.showMessageDialog(frmScenarioBuilder, "Please load an ADT Patient first.");
					// System.err.println("HL7 Arrays are null");
				}
			}

		});
		btnViewMicro.setBounds(137, 11, 117, 24);
		panel_2.add(btnViewMicro);

		JButton btnSaveObrChanges = new JButton("Save OBR Changes");
		btnSaveObrChanges.setBackground(new Color(255, 250, 205));
		btnSaveObrChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveOBRValues();
				Micro.saveOBRChanges(comboMicroOBR.getSelectedItem().toString());
			}
		});
		btnSaveObrChanges.setBounds(327, 298, 141, 25);
		panel_2.add(btnSaveObrChanges);

		JButton btnSaveObxChanges = new JButton("Save OBX Changes");
		btnSaveObxChanges.setEnabled(false);
		btnSaveObxChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveOBXValues();
				Micro.saveOBXChanges(comboMicroOBX.getSelectedItem().toString());
			}
		});
		btnSaveObxChanges.setBackground(new Color(255, 250, 205));
		btnSaveObxChanges.setBounds(327, 709, 141, 25);
		panel_2.add(btnSaveObxChanges);
		btnMicroLoadAdt.setBackground(new Color(255, 250, 205));

		// btnMicroLoadAdt
		btnMicroLoadAdt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				populateMicroFromAdt();
			}
		});
		btnMicroLoadAdt.setBounds(11, 11, 116, 25);
		panel_2.add(btnMicroLoadAdt);

		JButton btnLoadMicroTemplate = new JButton("Load Template");
		btnLoadMicroTemplate.setBounds(10, 112, 117, 25);
		panel_2.add(btnLoadMicroTemplate);
		btnLoadMicroTemplate.setBackground(new Color(255, 250, 205));
		comboTemplateSelect.setBounds(12, 82, 242, 23);
		panel_2.add(comboTemplateSelect);
		comboTemplateSelect.setBackground(new Color(255, 250, 205));
		comboTemplateSelect.setMaximumRowCount(10);

		// JComboBox<String> comboTemplateSelect
		comboTemplateSelect.setModel(new DefaultComboBoxModel<String>(new String[] {"BMP Adult Female","BMP Senior Female","BMP Senior Male",
				"Candida A Culture POS Adult Male","Candida A NC POS Adult Male","Candida A w/Suscp Adult Male","Candida DNA Probe POS Adult Female",
				"Candida G w/Suscp Adult Male","Candida Lusitaniae Culture Adult Female","Candida NEG Adult Female","CBC w/Platelett Adult Male",
				"CMP Adult Female","CMP Senior Female","CMP Senior Male","CMP Teen Female","Comprehensive Metabolic Panel",
				"Klebsiella Culture Adult Female","Klebsiella Non-Culture Blood","Lipid Panel Adult Female","MRSA Culture Blood",
				"MRSA Culture Cerebrospinal","MRSA Culture Respiratory","MRSA Culture Wound"}));

		JButton btnLoadMicro = new JButton("Clear All Fields");
		btnLoadMicro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Micro.clearMicroArray();
				clearAllMicroFields();
			}
		});
		btnLoadMicro.setBounds(137, 112, 117, 25);
		panel_2.add(btnLoadMicro);
		btnLoadMicro.setBackground(new Color(255, 250, 205));
		btnLoadMicro.setEnabled(true);
		btnLoadMicroTemplate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fileName = null;
				String templateSelection = comboTemplateSelect.getSelectedItem().toString();
				switch (templateSelection) {
				// case must match dropdown selections exactly
				case "BMP Adult Female":
					fileName = "BasicMetabolicADULTF.txt";
					break;
				case "BMP Senior Female":
					fileName = "BasicMetabolicSENIORF.txt";
					break;
				case "BMP Senior Male":
					fileName = "BasicMetabolicSENIORM.txt";
					break;
				case "CBC w/Platelett Adult Male":
					fileName = "CBCwPlatelett.txt";
					break;
				case "CMP Adult Female":
					fileName = "CompMetabolicPanelADULTF.txt";
					break;
				case "Candida A Culture POS Adult Male":
					fileName = "Candida A Fungal Culture POS ADULTM.txt";
					break;
				case "Candida A NC POS Adult Male":
					fileName = "Candida A Fungal NC POS ADULTM.txt";
					break;
				case "Candida A w/Suscp Adult Male":
					fileName = "Candida A Susceptibility ADULTM.txt";
					break;
				case "Candida G w/Suscp Adult Male":
					fileName = "Candida Galbrata Susceptibility ADULTM.txt";
					break;
				case "Candida Lusitaniae Culture Adult Female":
					fileName = "Candida lusitaniae Culture ADULTF.txt";
					break;
				case "Candida DNA Probe POS Adult Female":
					fileName = "Candida Species DNA Probe POSADULTF.txt";
					break;
				case "Candida NEG Adult Female":
					fileName = "CandidaNEGADULTF.txt";
					break;
				case "CMP Senior Male":
					fileName = "CompMetabolicPanelSENIORM.txt";
					break;
				case "CMP Senior Female":
					fileName = "CompMetabolicPanelSENIORF.txt";
					break;
				case "CMP Teen Female":
					fileName = "CompMetabolicPanelTEENF.txt";
					break;
				case "Comprehensive Metabolic Panel":
					fileName = "CompMetabolicPanel.txt";
					break;
				case "Klebsiella Culture Adult Female":
					fileName = "Klebsiella Culture ADULTF.txt";
					break;
				case "Klebsiella Non-Culture Blood":
					fileName = "KlebsiellaMicro.txt";
					break;
				case "Lipid Panel Adult Female":
					fileName = "LipidPanelADULTF.txt";
					break;
				case "MRSA Culture Respiratory":
					fileName = "MRSARespiratory.txt";
					break;
				case "MRSA Culture Blood":
					fileName = "MRSAblood.txt";
					break;
				case "MRSA Culture Cerebrospinal":
					fileName = "MRSACerebrospinal.txt";
					break;
				case "MRSA Culture Wound":
					fileName = "MRSAwound.txt";
					break;
							}
				// Choosing to load a new template
				int returnVal = 0;
				if (comboMicroOBR.getItemCount() >= 0) {
					@SuppressWarnings("unused")
					String result = "?";
					returnVal = JOptionPane.showConfirmDialog(frmScenarioBuilder,
							"Are you sure you want to load " + templateSelection + "?");
					switch (returnVal) {
					case JOptionPane.CANCEL_OPTION:
						result = "Canceled";
						break;
					case JOptionPane.YES_OPTION:
						Micro.clearMicroArray();
						refreshMicroElementsCount(lblMicroOBRCount, comboMicroOBR);
						refreshMicroElementsCount(lblMicroOBXCount, comboMicroOBX);
						try {
							taMicro.setText(Micro.readMicroTemplate(fileName, microHeaderPresent));
							populateMicroFields();
							Micro.getFullMicroArray(fileName);
							Micro.populateOBRDropdown(comboMicroOBR);
							// refreshMicroElementsCount(lblMicroOBRCount,
							// comboMicroOBR);
							Micro.populateOBRList();
							Micro.populateOBXList();
							Micro.initialOBR();
							populateCurrentOBR();
							Micro.populateOBXDropdown(comboMicroOBR.getSelectedItem(), comboMicroOBX);
							// refreshMicroElementsCount(lblMicroOBXCount,
							// comboMicroOBX);
							populateCurrentOBX(Micro.currentOBR(comboMicroOBR.getSelectedItem()),
									comboMicroOBX.getSelectedItem().toString());
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}

				}
			}
		});

		JPanel panelSurgery = new JPanel();
		panelSurgery.setBackground(new Color(255, 250, 205));
		tabbedPane.addTab("Surgery", null, panelSurgery, null);
		panelSurgery.setLayout(null);

		JPanel panelPatientEncounter = new JPanel();
		panelPatientEncounter.setBackground(new Color(255, 255, 224));
		panelPatientEncounter.setLayout(null);
		panelPatientEncounter.setBorder(null);
		panelPatientEncounter.setBounds(12, 13, 332, 475);
		panelSurgery.add(panelPatientEncounter);

		JLabel label = new JLabel("Patient/Encounter");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 16));
		label.setBounds(90, 11, 151, 16);
		panelPatientEncounter.add(label);

		tfSurgeryMRN = new JTextField();
		tfSurgeryMRN.setColumns(10);
		tfSurgeryMRN.setBounds(148, 35, 166, 22);
		panelPatientEncounter.add(tfSurgeryMRN);

		JLabel label_1 = new JLabel("MRN");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(12, 38, 109, 16);
		panelPatientEncounter.add(label_1);

		JLabel label_2 = new JLabel("Account Number");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(12, 67, 109, 16);
		panelPatientEncounter.add(label_2);

		JLabel label_3 = new JLabel("Family Name");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(12, 96, 109, 16);
		panelPatientEncounter.add(label_3);

		JLabel label_4 = new JLabel("Given Name");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(12, 125, 109, 16);
		panelPatientEncounter.add(label_4);

		JLabel label_5 = new JLabel("Surgery Future 1");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(12, 154, 109, 16);
		panelPatientEncounter.add(label_5);

		JLabel label_6 = new JLabel("Pat Class");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBounds(12, 183, 109, 16);
		panelPatientEncounter.add(label_6);

		JLabel label_7 = new JLabel("Point of Care");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setBounds(12, 212, 109, 16);
		panelPatientEncounter.add(label_7);

		JLabel label_8 = new JLabel("Room");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setBounds(12, 241, 109, 16);
		panelPatientEncounter.add(label_8);

		JLabel label_9 = new JLabel("Bed");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setBounds(12, 270, 109, 16);
		panelPatientEncounter.add(label_9);

		JLabel label_10 = new JLabel("Admit Date");
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setBounds(12, 299, 109, 16);
		panelPatientEncounter.add(label_10);

		JLabel label_11 = new JLabel("Discharge Date");
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setBounds(12, 328, 109, 16);
		panelPatientEncounter.add(label_11);

		JLabel label_12 = new JLabel("Encounter Future 1");
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		label_12.setBounds(12, 357, 109, 16);
		panelPatientEncounter.add(label_12);

		JLabel label_13 = new JLabel("Encounter Future 2");
		label_13.setHorizontalAlignment(SwingConstants.CENTER);
		label_13.setBounds(12, 386, 109, 16);
		panelPatientEncounter.add(label_13);

		JLabel label_14 = new JLabel("Encounter Future 3");
		label_14.setHorizontalAlignment(SwingConstants.CENTER);
		label_14.setBounds(12, 415, 109, 16);
		panelPatientEncounter.add(label_14);

		JLabel label_15 = new JLabel("Encounter Future 4");
		label_15.setHorizontalAlignment(SwingConstants.CENTER);
		label_15.setBounds(12, 444, 109, 16);
		panelPatientEncounter.add(label_15);

		tfSurgeryAccountNumber = new JTextField();
		tfSurgeryAccountNumber.setColumns(10);
		tfSurgeryAccountNumber.setBounds(148, 64, 166, 22);
		panelPatientEncounter.add(tfSurgeryAccountNumber);

		tfSurgeryFamilyName = new JTextField();
		tfSurgeryFamilyName.setColumns(10);
		tfSurgeryFamilyName.setBounds(148, 93, 166, 22);
		panelPatientEncounter.add(tfSurgeryFamilyName);

		tfSurgeryGivenName = new JTextField();
		tfSurgeryGivenName.setColumns(10);
		tfSurgeryGivenName.setBounds(148, 122, 166, 22);
		panelPatientEncounter.add(tfSurgeryGivenName);

		tfSurgeryFuture1 = new JTextField();
		tfSurgeryFuture1.setBackground(new Color(245, 245, 220));
		tfSurgeryFuture1.setEnabled(false);
		tfSurgeryFuture1.setColumns(10);
		tfSurgeryFuture1.setBounds(148, 151, 166, 22);
		panelPatientEncounter.add(tfSurgeryFuture1);

		tfPatClass = new JTextField();
		tfPatClass.setBackground(new Color(245, 245, 220));
		tfPatClass.setEnabled(false);
		tfPatClass.setColumns(10);
		tfPatClass.setBounds(148, 180, 166, 22);
		panelPatientEncounter.add(tfPatClass);

		tfPointOfCare = new JTextField();
		tfPointOfCare.setBackground(new Color(245, 245, 220));
		tfPointOfCare.setEnabled(false);
		tfPointOfCare.setColumns(10);
		tfPointOfCare.setBounds(148, 209, 166, 22);
		panelPatientEncounter.add(tfPointOfCare);

		tfSurgeryRoom = new JTextField();
		tfSurgeryRoom.setBackground(new Color(245, 245, 220));
		tfSurgeryRoom.setEnabled(false);
		tfSurgeryRoom.setColumns(10);
		tfSurgeryRoom.setBounds(148, 238, 166, 22);
		panelPatientEncounter.add(tfSurgeryRoom);

		tfSurgeryBed = new JTextField();
		tfSurgeryBed.setBackground(new Color(245, 245, 220));
		tfSurgeryBed.setEnabled(false);
		tfSurgeryBed.setColumns(10);
		tfSurgeryBed.setBounds(148, 267, 166, 22);
		panelPatientEncounter.add(tfSurgeryBed);

		tfSurgeryAdmitDate = new JTextField();
		tfSurgeryAdmitDate.setBackground(new Color(245, 245, 220));
		tfSurgeryAdmitDate.setEnabled(false);
		tfSurgeryAdmitDate.setColumns(10);
		tfSurgeryAdmitDate.setBounds(148, 296, 166, 22);
		panelPatientEncounter.add(tfSurgeryAdmitDate);

		tfSurgeryDischargeDate = new JTextField();
		tfSurgeryDischargeDate.setBackground(new Color(245, 245, 220));
		tfSurgeryDischargeDate.setEnabled(false);
		tfSurgeryDischargeDate.setColumns(10);
		tfSurgeryDischargeDate.setBounds(148, 325, 166, 22);
		panelPatientEncounter.add(tfSurgeryDischargeDate);

		tfEncounterFuture1 = new JTextField();
		tfEncounterFuture1.setBackground(new Color(245, 245, 220));
		tfEncounterFuture1.setEnabled(false);
		tfEncounterFuture1.setColumns(10);
		tfEncounterFuture1.setBounds(148, 354, 166, 22);
		panelPatientEncounter.add(tfEncounterFuture1);

		tfEncounterFuture2 = new JTextField();
		tfEncounterFuture2.setBackground(new Color(245, 245, 220));
		tfEncounterFuture2.setEnabled(false);
		tfEncounterFuture2.setColumns(10);
		tfEncounterFuture2.setBounds(148, 383, 166, 22);
		panelPatientEncounter.add(tfEncounterFuture2);

		tfEncounterFuture3 = new JTextField();
		tfEncounterFuture3.setBackground(new Color(245, 245, 220));
		tfEncounterFuture3.setEnabled(false);
		tfEncounterFuture3.setColumns(10);
		tfEncounterFuture3.setBounds(148, 412, 166, 22);
		panelPatientEncounter.add(tfEncounterFuture3);

		tfEncounterFuture4 = new JTextField();
		tfEncounterFuture4.setBackground(new Color(245, 245, 220));
		tfEncounterFuture4.setEnabled(false);
		tfEncounterFuture4.setColumns(10);
		tfEncounterFuture4.setBounds(148, 441, 166, 22);
		panelPatientEncounter.add(tfEncounterFuture4);

		JPanel panelSurgeryDetails = new JPanel();
		panelSurgeryDetails.setBackground(new Color(255, 255, 224));
		panelSurgeryDetails.setLayout(null);
		panelSurgeryDetails.setBorder(null);
		panelSurgeryDetails.setBounds(353, 13, 707, 612);
		panelSurgery.add(panelSurgeryDetails);

		JLabel label_16 = new JLabel("Surgery Details/Risk Factors");
		label_16.setHorizontalAlignment(SwingConstants.CENTER);
		label_16.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_16.setBounds(236, 11, 233, 17);
		panelSurgeryDetails.add(label_16);

		tfORLocation = new JTextField();
		tfORLocation.setColumns(10);
		tfORLocation.setBounds(148, 34, 166, 22);
		panelSurgeryDetails.add(tfORLocation);

		JLabel label_17 = new JLabel("OR Location");
		label_17.setHorizontalAlignment(SwingConstants.CENTER);
		label_17.setBounds(12, 37, 109, 16);
		panelSurgeryDetails.add(label_17);

		JLabel label_18 = new JLabel("Case Date");
		label_18.setHorizontalAlignment(SwingConstants.CENTER);
		label_18.setBounds(12, 66, 109, 16);
		panelSurgeryDetails.add(label_18);

		JLabel label_19 = new JLabel("Start");
		label_19.setHorizontalAlignment(SwingConstants.CENTER);
		label_19.setBounds(12, 95, 109, 16);
		panelSurgeryDetails.add(label_19);

		JLabel label_20 = new JLabel("Stop");
		label_20.setHorizontalAlignment(SwingConstants.CENTER);
		label_20.setBounds(12, 124, 109, 16);
		panelSurgeryDetails.add(label_20);

		JLabel label_21 = new JLabel("Surgeon");
		label_21.setHorizontalAlignment(SwingConstants.CENTER);
		label_21.setBounds(12, 153, 109, 16);
		panelSurgeryDetails.add(label_21);

		JLabel label_22 = new JLabel("Procedure");
		label_22.setHorizontalAlignment(SwingConstants.CENTER);
		label_22.setBounds(12, 182, 109, 16);
		panelSurgeryDetails.add(label_22);

		JLabel label_23 = new JLabel("ASA Code");
		label_23.setHorizontalAlignment(SwingConstants.CENTER);
		label_23.setBounds(12, 211, 109, 16);
		panelSurgeryDetails.add(label_23);

		JLabel label_24 = new JLabel("Wound Class");
		label_24.setHorizontalAlignment(SwingConstants.CENTER);
		label_24.setBounds(12, 240, 109, 16);
		panelSurgeryDetails.add(label_24);

		JLabel label_25 = new JLabel("Surgery Type");
		label_25.setHorizontalAlignment(SwingConstants.CENTER);
		label_25.setBounds(12, 269, 109, 16);
		panelSurgeryDetails.add(label_25);

		JLabel label_26 = new JLabel("Misc");
		label_26.setHorizontalAlignment(SwingConstants.CENTER);
		label_26.setBounds(12, 298, 109, 16);
		panelSurgeryDetails.add(label_26);

		JLabel label_27 = new JLabel("Test Field");
		label_27.setHorizontalAlignment(SwingConstants.CENTER);
		label_27.setBounds(12, 327, 109, 16);
		panelSurgeryDetails.add(label_27);

		JLabel label_28 = new JLabel("Not Used");
		label_28.setHorizontalAlignment(SwingConstants.CENTER);
		label_28.setBounds(12, 356, 109, 16);
		panelSurgeryDetails.add(label_28);

		JLabel label_29 = new JLabel("Facility Code");
		label_29.setHorizontalAlignment(SwingConstants.CENTER);
		label_29.setBounds(12, 385, 109, 16);
		panelSurgeryDetails.add(label_29);

		JLabel label_30 = new JLabel("NHSN Category");
		label_30.setHorizontalAlignment(SwingConstants.CENTER);
		label_30.setBounds(12, 414, 109, 16);
		panelSurgeryDetails.add(label_30);

		JLabel label_31 = new JLabel("Surgery Code");
		label_31.setHorizontalAlignment(SwingConstants.CENTER);
		label_31.setBounds(12, 443, 109, 16);
		panelSurgeryDetails.add(label_31);

		tfCaseDate = new JTextField();
		tfCaseDate.setColumns(10);
		tfCaseDate.setBounds(148, 63, 166, 22);
		panelSurgeryDetails.add(tfCaseDate);

		tfStart = new JTextField();
		tfStart.setColumns(10);
		tfStart.setBounds(148, 92, 166, 22);
		panelSurgeryDetails.add(tfStart);

		tfStop = new JTextField();
		tfStop.setColumns(10);
		tfStop.setBounds(148, 121, 166, 22);
		panelSurgeryDetails.add(tfStop);

		tfSurgeon = new JTextField();
		tfSurgeon.setColumns(10);
		tfSurgeon.setBounds(148, 150, 166, 22);
		panelSurgeryDetails.add(tfSurgeon);

		tfProcedure = new JTextField();
		tfProcedure.setColumns(10);
		tfProcedure.setBounds(148, 179, 166, 22);
		panelSurgeryDetails.add(tfProcedure);

		tfSurgeryType = new JTextField();
		tfSurgeryType.setBackground(new Color(245, 245, 220));
		tfSurgeryType.setEnabled(false);
		tfSurgeryType.setColumns(10);
		tfSurgeryType.setBounds(148, 266, 166, 22);
		panelSurgeryDetails.add(tfSurgeryType);

		tfMisc = new JTextField();
		tfMisc.setBackground(new Color(245, 245, 220));
		tfMisc.setEnabled(false);
		tfMisc.setColumns(10);
		tfMisc.setBounds(148, 295, 166, 22);
		panelSurgeryDetails.add(tfMisc);

		tfTestField = new JTextField();
		tfTestField.setColumns(10);
		tfTestField.setBounds(148, 324, 166, 22);
		panelSurgeryDetails.add(tfTestField);

		tfNotUsed = new JTextField();
		tfNotUsed.setBackground(new Color(245, 245, 220));
		tfNotUsed.setEnabled(false);
		tfNotUsed.setColumns(10);
		tfNotUsed.setBounds(148, 353, 166, 22);
		panelSurgeryDetails.add(tfNotUsed);

		tfFacilityCode = new JTextField();
		tfFacilityCode.setColumns(10);
		tfFacilityCode.setBounds(148, 382, 166, 22);
		panelSurgeryDetails.add(tfFacilityCode);

		tfSurgeryCode = new JTextField();
		tfSurgeryCode.setColumns(10);
		tfSurgeryCode.setBounds(148, 440, 166, 22);
		panelSurgeryDetails.add(tfSurgeryCode);
		comboASACode.setBackground(new Color(255, 255, 224));
		comboASACode.setModel(new DefaultComboBoxModel<String>(new String[] { "1", "2", "3", "4", "5" }));

		// JComboBox<String> comboASACode
		comboASACode.setBounds(148, 209, 166, 22);
		panelSurgeryDetails.add(comboASACode);
		comboWoundClass.setBackground(new Color(255, 255, 224));
		comboWoundClass.setModel(new DefaultComboBoxModel<String>(new String[] { "unknown", "1", "2", "3", "4" }));

		// JComboBox<String> comboWoundClas
		comboWoundClass.setBounds(148, 237, 166, 22);
		panelSurgeryDetails.add(comboWoundClass);
		comboNHSNCategory.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (comboNHSNCategory.getSelectedItem() == "CSEC") {
					disableProcedureSpecific();
					tfDurationOfLabor.setEnabled(true);
					tfEstimatedBloodLoss.setEnabled(true);
				} else if (comboNHSNCategory.getSelectedItem() == "HPRO") {
					disableProcedureSpecific();
					comboHipReplacement.setEnabled(true);
				} else if (comboNHSNCategory.getSelectedItem() == "KPRO") {
					disableProcedureSpecific();
					comboKneeReplacement.setEnabled(true);
				} else if (comboNHSNCategory.getSelectedItem() == "RFUSN") {
					disableProcedureSpecific();
					comboSpinalLevel.setEnabled(true);
					comboApproachTechnique.setEnabled(true);
				} else
					disableProcedureSpecific();

			}
		});
		comboNHSNCategory.setModel(new DefaultComboBoxModel<String>(new String[] { "AAA", "AMP", "APPY", "AVSD", "BILI",
				"BRST", "CARD", "CBGB", "CBGC", "CEA", "CHOL", "COLO", "CRAN", "CSEC", "FX", "GAST", "HER", "HPRO",
				"HTP", "HYST", "KPRO", "KTP", "LAM", "LTP", "NECK", "NEPH", "NO", "OTH", "OVRY", "PACE", "PRST", "PVBY",
				"REC", "RFUSN", "SB", "SPLE", "THOR", "THYR", "VHYS", "VSHN", "XLAP" }));

		// JComboBox<String> comboNHSNCategory
		comboNHSNCategory.setBounds(148, 411, 166, 22);
		panelSurgeryDetails.add(comboNHSNCategory);

		JLabel label_32 = new JLabel("Anesthesiologist");
		label_32.setHorizontalAlignment(SwingConstants.CENTER);
		label_32.setBounds(340, 37, 160, 16);
		panelSurgeryDetails.add(label_32);

		JLabel label_33 = new JLabel("Surgery Service");
		label_33.setHorizontalAlignment(SwingConstants.CENTER);
		label_33.setBounds(340, 66, 160, 16);
		panelSurgeryDetails.add(label_33);

		JLabel label_34 = new JLabel("Surgeon Code");
		label_34.setHorizontalAlignment(SwingConstants.CENTER);
		label_34.setBounds(340, 95, 160, 16);
		panelSurgeryDetails.add(label_34);

		JLabel label_35 = new JLabel("Anesthesiologist Code");
		label_35.setHorizontalAlignment(SwingConstants.CENTER);
		label_35.setBounds(340, 124, 160, 16);
		panelSurgeryDetails.add(label_35);

		JLabel label_36 = new JLabel("Outpatient");
		label_36.setHorizontalAlignment(SwingConstants.CENTER);
		label_36.setBounds(340, 153, 160, 16);
		panelSurgeryDetails.add(label_36);

		JLabel label_37 = new JLabel("Emergency");
		label_37.setHorizontalAlignment(SwingConstants.CENTER);
		label_37.setBounds(340, 182, 160, 16);
		panelSurgeryDetails.add(label_37);

		JLabel label_38 = new JLabel("General Anesthesia");
		label_38.setHorizontalAlignment(SwingConstants.CENTER);
		label_38.setBounds(340, 211, 160, 16);
		panelSurgeryDetails.add(label_38);

		JLabel label_39 = new JLabel("Trauma");
		label_39.setHorizontalAlignment(SwingConstants.CENTER);
		label_39.setBounds(340, 240, 160, 16);
		panelSurgeryDetails.add(label_39);

		JLabel label_40 = new JLabel("Endoscope");
		label_40.setHorizontalAlignment(SwingConstants.CENTER);
		label_40.setBounds(340, 269, 160, 16);
		panelSurgeryDetails.add(label_40);

		JLabel label_41 = new JLabel("Multiple Procedures");
		label_41.setHorizontalAlignment(SwingConstants.CENTER);
		label_41.setBounds(340, 298, 160, 16);
		panelSurgeryDetails.add(label_41);

		JLabel label_42 = new JLabel("Implant");
		label_42.setHorizontalAlignment(SwingConstants.CENTER);
		label_42.setBounds(340, 327, 160, 16);
		panelSurgeryDetails.add(label_42);

		JLabel label_43 = new JLabel("Transplant");
		label_43.setHorizontalAlignment(SwingConstants.CENTER);
		label_43.setBounds(340, 356, 160, 16);
		panelSurgeryDetails.add(label_43);

		JLabel label_44 = new JLabel("Transplant Autologous");
		label_44.setHorizontalAlignment(SwingConstants.CENTER);
		label_44.setBounds(340, 385, 160, 16);
		panelSurgeryDetails.add(label_44);

		JLabel label_45 = new JLabel("Primary Closure");
		label_45.setHorizontalAlignment(SwingConstants.CENTER);
		label_45.setBounds(340, 414, 160, 16);
		panelSurgeryDetails.add(label_45);

		tfAnesthesiologist = new JTextField();
		tfAnesthesiologist.setColumns(10);
		tfAnesthesiologist.setBounds(526, 34, 166, 22);
		panelSurgeryDetails.add(tfAnesthesiologist);

		tfSurgeryService = new JTextField();
		tfSurgeryService.setColumns(10);
		tfSurgeryService.setBounds(526, 63, 166, 22);
		panelSurgeryDetails.add(tfSurgeryService);

		tfSurgeonCode = new JTextField();
		tfSurgeonCode.setColumns(10);
		tfSurgeonCode.setBounds(526, 92, 166, 22);
		panelSurgeryDetails.add(tfSurgeonCode);

		tfAnesthesiologistCode = new JTextField();
		tfAnesthesiologistCode.setColumns(10);
		tfAnesthesiologistCode.setBounds(526, 121, 166, 22);
		panelSurgeryDetails.add(tfAnesthesiologistCode);
		rdbtnOutpatientYes.setBackground(new Color(245, 245, 220));

		// JRadioButton rdbtnOutpatientYes
		rdbtnOutpatientYes.setBounds(556, 153, 49, 25);
		panelSurgeryDetails.add(rdbtnOutpatientYes);
		rdbtnOutpatientNo.setBackground(new Color(245, 245, 220));

		// JRadioButton rdbtnOutpatientYNo
		rdbtnOutpatientNo.setSelected(true);
		rdbtnOutpatientNo.setBounds(609, 153, 49, 25);
		panelSurgeryDetails.add(rdbtnOutpatientNo);
		rdbtnEmergencyNo.setBackground(new Color(245, 245, 220));

		// JRadioButton rdbtnEmergencyNo
		rdbtnEmergencyNo.setSelected(true);
		rdbtnEmergencyNo.setBounds(609, 182, 49, 25);
		panelSurgeryDetails.add(rdbtnEmergencyNo);
		rdbtnEmergencyYes.setBackground(new Color(245, 245, 220));

		// JRadioButton rdbtnEmergencyYes
		rdbtnEmergencyYes.setBounds(556, 182, 49, 25);
		panelSurgeryDetails.add(rdbtnEmergencyYes);
		rdbtnGeneralAnesthesiaNo.setBackground(new Color(245, 245, 220));

		// JRadioButton rdbtnGeneralAnesthesiaNo
		rdbtnGeneralAnesthesiaNo.setSelected(true);
		rdbtnGeneralAnesthesiaNo.setBounds(609, 211, 49, 25);
		panelSurgeryDetails.add(rdbtnGeneralAnesthesiaNo);
		rdbtnGeneralAnesthesiaYes.setBackground(new Color(245, 245, 220));

		// JRadioButton rdbtnGeneralAnesthesiaYes
		rdbtnGeneralAnesthesiaYes.setBounds(556, 211, 49, 25);
		panelSurgeryDetails.add(rdbtnGeneralAnesthesiaYes);
		rdbtnTraumaNo.setBackground(new Color(245, 245, 220));

		// JRadioButton rdbtnTraumaNo
		rdbtnTraumaNo.setSelected(true);
		rdbtnTraumaNo.setBounds(609, 240, 49, 25);
		panelSurgeryDetails.add(rdbtnTraumaNo);
		rdbtnTraumaYes.setBackground(new Color(245, 245, 220));

		// JRadioButton rdbtnTraumaYes
		rdbtnTraumaYes.setBounds(556, 240, 49, 25);
		panelSurgeryDetails.add(rdbtnTraumaYes);
		rdbtnEndoscopeNo.setBackground(new Color(245, 245, 220));

		// JRadioButton rdbtnEndoscopeNo
		rdbtnEndoscopeNo.setSelected(true);
		rdbtnEndoscopeNo.setBounds(609, 269, 49, 25);
		panelSurgeryDetails.add(rdbtnEndoscopeNo);
		rdbtnEndoscopeYes.setBackground(new Color(245, 245, 220));

		// JRadioButton rdbtnEndoscopeYes
		rdbtnEndoscopeYes.setBounds(556, 269, 49, 25);
		panelSurgeryDetails.add(rdbtnEndoscopeYes);
		rdbtnMultipleProceduresNo.setBackground(new Color(245, 245, 220));

		// JRadioButton rdbtnMultipleProceduresNo
		rdbtnMultipleProceduresNo.setSelected(true);
		rdbtnMultipleProceduresNo.setBounds(609, 298, 49, 25);
		panelSurgeryDetails.add(rdbtnMultipleProceduresNo);
		rdbtnMultipleProceduresYes.setBackground(new Color(245, 245, 220));

		// JRadioButton rdbtnMultipleProceduresYes
		rdbtnMultipleProceduresYes.setBounds(556, 298, 49, 25);
		panelSurgeryDetails.add(rdbtnMultipleProceduresYes);
		rdbtnImplantNo.setBackground(new Color(245, 245, 220));

		// JRadioButton rdbtnImplantNo
		rdbtnImplantNo.setSelected(true);
		rdbtnImplantNo.setBounds(609, 327, 49, 25);
		panelSurgeryDetails.add(rdbtnImplantNo);
		rdbtnImplantYes.setBackground(new Color(245, 245, 220));

		// JRadioButton rdbtnImplantYes
		rdbtnImplantYes.setBounds(556, 327, 49, 25);
		panelSurgeryDetails.add(rdbtnImplantYes);
		rdbtnTransplantNo.setBackground(new Color(245, 245, 220));

		// JRadioButton rdbtnTransplantNo
		rdbtnTransplantNo.setSelected(true);
		rdbtnTransplantNo.setBounds(609, 356, 49, 25);
		panelSurgeryDetails.add(rdbtnTransplantNo);
		rdbtnTransplantYes.setBackground(new Color(245, 245, 220));

		// JRadioButton rdbtnTransplantYes
		rdbtnTransplantYes.setBounds(556, 356, 49, 25);
		panelSurgeryDetails.add(rdbtnTransplantYes);
		rdbtnTransplantAutologousNo.setBackground(new Color(245, 245, 220));

		// JRadioButton rdbtnTransplantAutologousNo
		rdbtnTransplantAutologousNo.setSelected(true);
		rdbtnTransplantAutologousNo.setBounds(609, 385, 49, 25);
		panelSurgeryDetails.add(rdbtnTransplantAutologousNo);
		rdbtnTransplantAutologousYes.setBackground(new Color(245, 245, 220));

		// JRadioButton rdbtnTransplantAutologousYes
		rdbtnTransplantAutologousYes.setBounds(556, 385, 49, 25);
		panelSurgeryDetails.add(rdbtnTransplantAutologousYes);
		rdbtnPrimaryClosureNo.setBackground(new Color(245, 245, 220));

		// JRadioButton rdbtnPrimaryClosureNo
		rdbtnPrimaryClosureNo.setSelected(true);
		rdbtnPrimaryClosureNo.setBounds(609, 414, 49, 25);
		panelSurgeryDetails.add(rdbtnPrimaryClosureNo);
		rdbtnPrimaryClosureYes.setBackground(new Color(245, 245, 220));

		// JRadioButton rdbtnPrimaryClosureYes
		rdbtnPrimaryClosureYes.setBounds(556, 414, 49, 25);
		panelSurgeryDetails.add(rdbtnPrimaryClosureYes);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 224));
		panel_4.setLayout(null);
		panel_4.setBorder(new LineBorder(new Color(245, 245, 220)));
		panel_4.setBounds(12, 472, 680, 127);
		panelSurgeryDetails.add(panel_4);

		JLabel label_46 = new JLabel("Procedure-specific");
		label_46.setHorizontalAlignment(SwingConstants.CENTER);
		label_46.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_46.setBounds(247, 11, 164, 16);
		panel_4.add(label_46);

		JLabel label_47 = new JLabel("Duration of Labor");
		label_47.setHorizontalAlignment(SwingConstants.CENTER);
		label_47.setBounds(12, 34, 140, 16);
		panel_4.add(label_47);

		JLabel label_48 = new JLabel("Estimated Blood Loss");
		label_48.setHorizontalAlignment(SwingConstants.CENTER);
		label_48.setBounds(12, 63, 140, 16);
		panel_4.add(label_48);

		JLabel label_49 = new JLabel("Spinal Level");
		label_49.setHorizontalAlignment(SwingConstants.CENTER);
		label_49.setBounds(12, 92, 140, 16);
		panel_4.add(label_49);

		tfDurationOfLabor = new JTextField();
		tfDurationOfLabor.setEnabled(false);
		tfDurationOfLabor.setColumns(10);
		tfDurationOfLabor.setBounds(164, 31, 166, 22);
		panel_4.add(tfDurationOfLabor);

		tfEstimatedBloodLoss = new JTextField();
		tfEstimatedBloodLoss.setEnabled(false);
		tfEstimatedBloodLoss.setColumns(10);
		tfEstimatedBloodLoss.setBounds(164, 60, 166, 22);
		panel_4.add(tfEstimatedBloodLoss);
		comboSpinalLevel.setModel(
				new DefaultComboBoxModel<String>(new String[] { "unknown", "atax", "ataxC", "C", "DD", "CDD", "LL" }));

		// JComboBox<String> comboSpinalLevel
		comboSpinalLevel.setEnabled(false);
		comboSpinalLevel.setBounds(164, 89, 166, 22);
		panel_4.add(comboSpinalLevel);

		JLabel label_50 = new JLabel("Approach/Technique");
		label_50.setHorizontalAlignment(SwingConstants.CENTER);
		label_50.setBounds(342, 34, 140, 16);
		panel_4.add(label_50);

		JLabel label_51 = new JLabel("Hip Replacement");
		label_51.setHorizontalAlignment(SwingConstants.CENTER);
		label_51.setBounds(342, 63, 140, 16);
		panel_4.add(label_51);

		JLabel label_52 = new JLabel("Knee Replacement");
		label_52.setHorizontalAlignment(SwingConstants.CENTER);
		label_52.setBounds(342, 92, 140, 16);
		panel_4.add(label_52);
		comboApproachTechnique
				.setModel(new DefaultComboBoxModel<String>(new String[] { "unknown", "A", "P", "AP", "TO" }));

		// JComboBox<String> comboApproachTechnique
		comboApproachTechnique.setEnabled(false);
		comboApproachTechnique.setBounds(494, 31, 166, 22);
		panel_4.add(comboApproachTechnique);
		comboHipReplacement.setModel(new DefaultComboBoxModel<String>(
				new String[] { "TTP", "TTR", "TPR", "HPP", "HTR", "HPR", "RTP", "RTR", "RPP", "RPR" }));

		// JComboBox<String> comboHipReplacement
		comboHipReplacement.setEnabled(false);
		comboHipReplacement.setBounds(494, 60, 166, 22);
		panel_4.add(comboHipReplacement);
		comboKneeReplacement
				.setModel(new DefaultComboBoxModel<String>(new String[] { "TTP", "TTR", "TPR", "HPP", "HTR", "HPR" }));

		// JComboBox<String> comboKneeReplacement
		comboKneeReplacement.setEnabled(false);
		comboKneeReplacement.setBounds(494, 89, 166, 22);
		panel_4.add(comboKneeReplacement);

		JPanel panelPatientRiskFactors = new JPanel();
		panelPatientRiskFactors.setBackground(new Color(255, 255, 224));
		panelPatientRiskFactors.setLayout(null);
		panelPatientRiskFactors.setBorder(null);
		panelPatientRiskFactors.setBounds(12, 497, 332, 181);
		panelSurgery.add(panelPatientRiskFactors);

		JLabel label_53 = new JLabel("Patient Risk Factors");
		label_53.setHorizontalAlignment(SwingConstants.CENTER);
		label_53.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_53.setBounds(91, 13, 164, 16);
		panelPatientRiskFactors.add(label_53);

		JLabel label_54 = new JLabel("Diabetes Mellitus");
		label_54.setHorizontalAlignment(SwingConstants.CENTER);
		label_54.setBounds(12, 36, 140, 16);
		panelPatientRiskFactors.add(label_54);

		JLabel label_55 = new JLabel("Height");
		label_55.setHorizontalAlignment(SwingConstants.CENTER);
		label_55.setBounds(12, 65, 140, 16);
		panelPatientRiskFactors.add(label_55);

		JLabel label_56 = new JLabel("Height Unit");
		label_56.setHorizontalAlignment(SwingConstants.CENTER);
		label_56.setBounds(12, 94, 140, 16);
		panelPatientRiskFactors.add(label_56);

		JLabel label_57 = new JLabel("Weight");
		label_57.setHorizontalAlignment(SwingConstants.CENTER);
		label_57.setBounds(12, 123, 140, 16);
		panelPatientRiskFactors.add(label_57);

		JLabel label_58 = new JLabel("Weight Unit");
		label_58.setHorizontalAlignment(SwingConstants.CENTER);
		label_58.setBounds(12, 152, 140, 16);
		panelPatientRiskFactors.add(label_58);

		tfHeight = new JTextField();
		tfHeight.setColumns(10);
		tfHeight.setBounds(154, 62, 166, 22);
		panelPatientRiskFactors.add(tfHeight);
		comboHeightUnit.setModel(new DefaultComboBoxModel<String>(new String[] { "in", "cm" }));

		// JComboBox<String> comboHeightUnit
		comboHeightUnit.setBounds(154, 91, 166, 22);
		panelPatientRiskFactors.add(comboHeightUnit);

		tfWeight = new JTextField();
		tfWeight.setColumns(10);
		tfWeight.setBounds(154, 123, 166, 22);
		panelPatientRiskFactors.add(tfWeight);
		comboWeightUnit.setModel(new DefaultComboBoxModel<String>(new String[] { "lb", "kg" }));

		// JComboBox<String> comboWeightUnit
		comboWeightUnit.setBounds(154, 152, 166, 22);
		panelPatientRiskFactors.add(comboWeightUnit);
		rdbtnDiabetesMellitusYes.setBackground(new Color(245, 245, 220));

		// JRadioButton rdbtnDiabetesMellitusYes
		rdbtnDiabetesMellitusYes.setBounds(185, 34, 49, 25);
		panelPatientRiskFactors.add(rdbtnDiabetesMellitusYes);
		rdbtnDiabetesMellitusNo.setBackground(new Color(245, 245, 220));

		// JRadioButton rdbtnDiabetesMellitusNo
		rdbtnDiabetesMellitusNo.setSelected(true);
		rdbtnDiabetesMellitusNo.setBounds(238, 34, 49, 25);
		panelPatientRiskFactors.add(rdbtnDiabetesMellitusNo);

		final JCheckBox cbEnableAllFields = new JCheckBox("Enable All Fields");
		cbEnableAllFields.setBackground(new Color(255, 250, 205));
		cbEnableAllFields.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (cbEnableAllFields.isSelected())
					enableSurgeryAllFields();
				else
					disableAllSurgeryFields();
			}
		});
		cbEnableAllFields.setBounds(353, 634, 121, 25);
		panelSurgery.add(cbEnableAllFields);

		JButton btnNewFile = new JButton("New File");
		btnNewFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int returnVal = JOptionPane.showConfirmDialog(frmScenarioBuilder,
						"Are you sure you want to clear all fields?");
				if (returnVal == JOptionPane.YES_OPTION)
					clearAllSurgeryFields();
			}
		});
		btnNewFile.setBounds(482, 634, 97, 25);
		panelSurgery.add(btnNewFile);

		JButton btnOpenFile = new JButton("Open File");
		btnOpenFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File file = null;
				final JFileChooser fc = new JFileChooser();
				int returnVal = fc.showOpenDialog(frmScenarioBuilder);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					file = fc.getSelectedFile();
					try {
						BufferedReader br = new BufferedReader(new FileReader(file));
						br.readLine();
						String[] array = br.readLine().split(",");
						populateSurgeryFields(array);
						br.close();
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}

			}
		});
		btnOpenFile.setBounds(591, 634, 97, 25);
		panelSurgery.add(btnOpenFile);

		// JComboBox<String> comboCreateType
		comboCreateType.setModel(new DefaultComboBoxModel<String>(new String[] { "Local", "Server" }));
		comboCreateType.setBounds(482, 663, 97, 22);
		panelSurgery.add(comboCreateType);

		JButton btnCreateSurgery = new JButton("Create Surgery");
		btnCreateSurgery.setBounds(591, 662, 121, 25);
		panelSurgery.add(btnCreateSurgery);

		JButton btnPopulateFromAdt = new JButton("Populate From ADT");
		btnPopulateFromAdt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				populateSurgeryFromADT();
			}
		});
		btnPopulateFromAdt.setBounds(700, 634, 143, 25);
		panelSurgery.add(btnPopulateFromAdt);

		// JLabel labelSurgeryStatus
		lblSurgeryStatus.setBounds(855, 667, 381, 16);
		panelSurgery.add(lblSurgeryStatus);

		JButton btnBulkSurgery = new JButton("Bulk Surgery");
		btnBulkSurgery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String parseDirectory = "D:\\tdoc\\apps\\knet\\clientdata\\surgery";
				try {
					Data.bulkSurgery(parseDirectory);
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(frmScenarioBuilder, "Unable to connect to database");
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnBulkSurgery.setBounds(722, 662, 121, 25);
		panelSurgery.add(btnBulkSurgery);
		btnCreateSurgery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] fileArray = null;
				@SuppressWarnings("unused")
				boolean patExists = false;
				try {
					Database.connectToDB();
					patExists = Database.checkDBForPatient(tfSurgeryMRN.getText());
				} catch (SQLException e2) {
					e2.printStackTrace();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (UnknownHostException e1) {
					e1.printStackTrace();
				} catch (NullPointerException e1) {
					JOptionPane.showMessageDialog(frmScenarioBuilder, "Surgery fields are empty");
					e1.printStackTrace();
				}
				if (patExists = true && comboCreateType.getSelectedItem().toString() == "Server") {
					String parseDirectory = "D:\\tdoc\\apps\\knet\\clientdata\\surgery";
					try {
						fileArray = populateSurgeryFileArray();
						Data.createSurgery(fileArray, parseDirectory);
						lblSurgeryStatus.setText("Surgery has been placed into the parse folder");
						createLabelTimer(lblSurgeryStatus, 5000);
					} catch (FileNotFoundException e1) {
						lblSurgeryStatus.setText("Unable to place Surgery in parse folder");
						createLabelTimer(lblSurgeryStatus, 5000);
						e1.printStackTrace();
					} catch (NullPointerException e1) {
						JOptionPane.showMessageDialog(frmScenarioBuilder, "Surgery fields are empty");
						e1.printStackTrace();
					}
				} else if (comboCreateType.getSelectedItem().toString() == "Local") {
					try {
						fileArray = populateSurgeryFileArray();
						String fileName = Data.createSurgery(fileArray, workingDirectory);
						lblSurgeryStatus.setText("Surgery - " + fileName + " created in local directory");
						createLabelTimer(lblSurgeryStatus, 5000);
					} catch (FileNotFoundException e2) {
						lblSurgeryStatus.setText("Unable to create file");
						createLabelTimer(lblSurgeryStatus, 5000);
						System.err.println("Unable to create file locally");
						e2.printStackTrace();
					}
				}
			}
		});
		frmScenarioBuilder.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { btnCreateSurgery }));
	}

	protected void addMicroOrder() {
		Micro.addOBR();
		comboMicroOBR.addItem("OBR " + (comboMicroOBR.getItemCount() + 1));
		refreshMicroElementsCount(lblMicroOBRCount, comboMicroOBR);
	}

	protected void removeMicroOrder() {
		int returnVal = JOptionPane.showConfirmDialog(frmScenarioBuilder,
				"Are you sure you want to remove the current order?");
		if (returnVal == JOptionPane.YES_OPTION) {
			comboMicroOBR.removeItem(comboMicroOBR.getSelectedItem());
			refreshMicroElementsCount(lblMicroOBRCount, comboMicroOBR);
		}

	}

	protected void refreshMicroElementsCount(JLabel label, JComboBox<String> combo) {
		label.setText(Integer.toString(combo.getItemCount()));
	}

	protected void setADTStatus(String string) {
		lblADTStatus.setText(string);
	}

	protected String[] populateSurgeryFileArray() throws FileNotFoundException {
		String[] dataArray = new String[55];
		dataArray[0] = tfSurgeryMRN.getText();
		dataArray[1] = tfADTAccountNumber.getText();
		dataArray[2] = tfSurgeryFamilyName.getText();
		dataArray[3] = tfSurgeryGivenName.getText();
		dataArray[4] = checkForNullValue(dataArray[4], tfORLocation);
		dataArray[5] = checkForNullValue(dataArray[5], tfCaseDate);
		dataArray[6] = checkForNullValue(dataArray[6], tfStart);
		dataArray[7] = checkForNullValue(dataArray[7], tfStop);
		dataArray[8] = checkForNullValue(dataArray[8], tfSurgeon);
		dataArray[9] = checkForNullValue(dataArray[9], tfProcedure);
		dataArray[10] = comboASACode.getSelectedItem().toString();
		dataArray[11] = comboWoundClass.getSelectedItem().toString();
		dataArray[12] = checkForNullValue(dataArray[12], tfSurgeryType);
		dataArray[13] = checkForNullValue(dataArray[13], tfMisc);
		dataArray[14] = checkForNullValue(dataArray[14], tfTestField);
		dataArray[15] = "";
		dataArray[16] = checkForNullValue(dataArray[16], tfFacilityCode);
		dataArray[17] = comboNHSNCategory.getSelectedItem().toString();
		dataArray[18] = checkForNullValue(dataArray[18], tfSurgeryCode);
		dataArray[19] = checkForNullValue(dataArray[19], tfAnesthesiologist);
		dataArray[20] = checkForNullValue(dataArray[20], tfSurgeryService);
		dataArray[21] = checkForNullValue(dataArray[21], tfSurgeonCode);
		dataArray[22] = checkForNullValue(dataArray[22], tfAnesthesiologistCode);
		dataArray[23] = "";
		dataArray[24] = "";
		dataArray[25] = "";
		dataArray[26] = "";
		dataArray[27] = "";
		dataArray[28] = "";
		dataArray[29] = "";
		dataArray[30] = "";
		dataArray[31] = "";
		dataArray[32] = "";
		dataArray[33] = "";
		if (rdbtnDiabetesMellitusYes.isSelected()) {
			dataArray[34] = "1";
		} else
			dataArray[34] = "0";
		dataArray[35] = tfHeight.getText();
		dataArray[36] = comboHeightUnit.getSelectedItem().toString();
		dataArray[37] = tfWeight.getText();
		dataArray[38] = comboWeightUnit.getSelectedItem().toString();
		if (rdbtnOutpatientYes.isSelected()) {
			dataArray[39] = "1";
		} else
			dataArray[39] = "0";
		if (rdbtnEmergencyYes.isSelected()) {
			dataArray[40] = "1";
		} else
			dataArray[40] = "0";
		if (rdbtnGeneralAnesthesiaYes.isSelected()) {
			dataArray[41] = "1";
		} else
			dataArray[41] = "0";
		if (rdbtnTraumaYes.isSelected()) {
			dataArray[42] = "1";
		} else
			dataArray[42] = "0";
		if (rdbtnEndoscopeYes.isSelected()) {
			dataArray[43] = "1";
		} else
			dataArray[43] = "0";
		if (rdbtnMultipleProceduresYes.isSelected()) {
			dataArray[44] = "1";
		} else
			dataArray[44] = "0";
		if (rdbtnImplantYes.isSelected()) {
			dataArray[45] = "1";
		} else
			dataArray[45] = "0";
		if (rdbtnTransplantYes.isSelected()) {
			dataArray[46] = "1";
		} else
			dataArray[46] = "0";
		if (rdbtnTransplantAutologousYes.isSelected()) {
			dataArray[47] = "1";
		} else
			dataArray[47] = "0";
		if (rdbtnPrimaryClosureYes.isSelected()) {
			dataArray[48] = "1";
		} else
			dataArray[48] = "0";
		dataArray[49] = tfDurationOfLabor.getText();
		dataArray[50] = tfEstimatedBloodLoss.getText();
		dataArray[51] = comboSpinalLevel.getSelectedItem().toString();
		dataArray[52] = comboApproachTechnique.getSelectedItem().toString();
		dataArray[53] = comboHipReplacement.getSelectedItem().toString();
		dataArray[54] = comboKneeReplacement.getSelectedItem().toString();
		return dataArray;
	}

	private String checkForNullValue(String arrayField, JTextField field) {
		if (field.getText().isEmpty())
			arrayField = "";
		else
			arrayField = field.getText();
		return arrayField;
	}

	private void clearAllSurgeryFields() {
		tfSurgeryMRN.setText(null);
		tfSurgeryAccountNumber.setText(null);
		tfSurgeryFamilyName.setText(null);
		tfSurgeryGivenName.setText(null);
		tfSurgeryFuture1.setText(null);
		tfPatClass.setText(null);
		tfPointOfCare.setText(null);
		tfSurgeryRoom.setText(null);
		tfSurgeryBed.setText(null);
		tfSurgeryAdmitDate.setText(null);
		tfSurgeryDischargeDate.setText(null);
		tfEncounterFuture1.setText(null);
		tfEncounterFuture2.setText(null);
		tfEncounterFuture3.setText(null);
		tfEncounterFuture4.setText(null);
		tfORLocation.setText(null);
		tfCaseDate.setText(null);
		tfStart.setText(null);
		tfStop.setText(null);
		tfSurgeon.setText(null);
		tfProcedure.setText(null);
		comboASACode.setSelectedIndex(0);
		comboWoundClass.setSelectedItem(0);
		tfSurgeryType.setText(null);
		tfMisc.setText(null);
		tfTestField.setText(null);
		tfFacilityCode.setText(null);
		comboNHSNCategory.setSelectedItem(0);
		tfSurgeryCode.setText(null);
		tfAnesthesiologist.setText(null);
		tfSurgeryService.setText(null);
		tfSurgeonCode.setText(null);
		tfAnesthesiologistCode.setText(null);
		rdbtnOutpatientNo.setSelected(true);
		rdbtnEmergencyNo.setSelected(true);
		rdbtnGeneralAnesthesiaNo.setSelected(true);
		rdbtnTraumaNo.setSelected(true);
		rdbtnEndoscopeNo.setSelected(true);
		rdbtnMultipleProceduresNo.setSelected(true);
		rdbtnImplantNo.setSelected(true);
		rdbtnTransplantNo.setSelected(true);
		rdbtnTransplantAutologousNo.setSelected(true);
		rdbtnPrimaryClosureNo.setSelected(true);
		tfDurationOfLabor.setText(null);
		tfEstimatedBloodLoss.setText(null);
		comboSpinalLevel.setSelectedItem(0);
		comboApproachTechnique.setSelectedItem(0);
		comboHipReplacement.setSelectedItem(0);
		comboKneeReplacement.setSelectedItem(0);
		rdbtnDiabetesMellitusNo.setSelected(true);
		tfHeight.setText(null);
		comboHeightUnit.setSelectedItem(0);
		comboWeightUnit.setSelectedItem(0);
		tfWeight.setText(null);
	}

	private void disableProcedureSpecific() {
		tfDurationOfLabor.setEnabled(false);
		tfEstimatedBloodLoss.setEnabled(false);
		comboHipReplacement.setEnabled(false);
		comboKneeReplacement.setEnabled(false);
		comboSpinalLevel.setEnabled(false);
		comboApproachTechnique.setEnabled(false);
	}

	private void disableAllSurgeryFields() {
		tfSurgeryFuture1.setEnabled(false);
		tfPatClass.setEnabled(false);
		tfPointOfCare.setEnabled(false);
		tfSurgeryRoom.setEnabled(false);
		tfSurgeryBed.setEnabled(false);
		tfSurgeryAdmitDate.setEnabled(false);
		tfSurgeryDischargeDate.setEnabled(false);
		tfEncounterFuture1.setEnabled(false);
		tfEncounterFuture2.setEnabled(false);
		tfEncounterFuture3.setEnabled(false);
		tfEncounterFuture4.setEnabled(false);
		tfSurgeryType.setEnabled(false);
		tfMisc.setEnabled(false);
	}

	private void enableSurgeryAllFields() {
		tfSurgeryFuture1.setEnabled(true);
		tfPatClass.setEnabled(true);
		tfPointOfCare.setEnabled(true);
		tfSurgeryRoom.setEnabled(true);
		tfSurgeryBed.setEnabled(true);
		tfSurgeryAdmitDate.setEnabled(true);
		tfSurgeryDischargeDate.setEnabled(true);
		tfEncounterFuture1.setEnabled(true);
		tfEncounterFuture2.setEnabled(true);
		tfEncounterFuture3.setEnabled(true);
		tfEncounterFuture4.setEnabled(true);
		tfSurgeryType.setEnabled(true);
		tfMisc.setEnabled(true);
	}

	private void populateSurgeryFields(String[] array) {
		if (tfSurgeryMRN.getText().isEmpty())
			tfSurgeryMRN.setText(array[0]);
		if (tfSurgeryAccountNumber.getText().isEmpty())
			tfSurgeryAccountNumber.setText(array[1]);
		if (tfSurgeryFamilyName.getText().isEmpty())
			tfSurgeryFamilyName.setText(array[2]);
		if (tfSurgeryGivenName.getText().isEmpty())
			tfSurgeryGivenName.setText(array[3]);
		// tfSurgeryFuture1.setText(array[4]);
		// tfPatClass.setText(array[5]);
		// tfPointOfCare.setText(array[6]);
		// tfRoom.setText(array[7]);
		// tfBed.setText(array[8]);
		// tfAdmitDate.setText(array[9]);
		// tfDischargeDate.setText(array[10]);
		// tfEncounterFuture1.setText(array[11]);
		// tfEncounterFuture2.setText(array[12]);
		// tfEncounterFuture3.setText(array[13]);
		// tfEncounterFuture4.setText(array[14]);
		tfORLocation.setText(array[4]);
		tfCaseDate.setText(array[5]);
		tfStart.setText(array[6]);
		tfStop.setText(array[7]);
		tfSurgeon.setText(array[8]);
		tfProcedure.setText(array[9]);
		comboASACode.setSelectedIndex(Integer.parseInt(array[10]) - 1);
		comboWoundClass.setSelectedItem(array[11]);
		tfSurgeryType.setText(array[12]);
		tfMisc.setText(array[13]);
		tfTestField.setText(array[14]);
		tfFacilityCode.setText(array[16]);
		comboNHSNCategory.setSelectedItem(array[17]);
		tfSurgeryCode.setText(array[18]);
		tfAnesthesiologist.setText(array[19]);
		tfSurgeryService.setText(array[20]);
		tfSurgeonCode.setText(array[21]);
		tfAnesthesiologistCode.setText(array[22]);
		if (array[39] == "1")
			rdbtnOutpatientYes.setSelected(true);
		else
			rdbtnOutpatientNo.setSelected(true);
		if (array[40] == "1")
			rdbtnEmergencyYes.setSelected(true);
		else
			rdbtnEmergencyNo.setSelected(true);
		if (array[41] == "1")
			rdbtnGeneralAnesthesiaYes.setSelected(true);
		else
			rdbtnGeneralAnesthesiaNo.setSelected(true);
		if (array[42] == "1")
			rdbtnTraumaYes.setSelected(true);
		else
			rdbtnTraumaNo.setSelected(true);
		if (array[43] == "1")
			rdbtnEndoscopeYes.setSelected(true);
		else
			rdbtnEndoscopeNo.setSelected(true);
		if (array[44] == "1")
			rdbtnMultipleProceduresYes.setSelected(true);
		else
			rdbtnMultipleProceduresNo.setSelected(true);
		if (array[45] == "1")
			rdbtnImplantYes.setSelected(true);
		else
			rdbtnImplantNo.setSelected(true);
		if (array[46] == "1")
			rdbtnTransplantYes.setSelected(true);
		else
			rdbtnTransplantNo.setSelected(true);
		if (array[47] == "1")
			rdbtnTransplantAutologousYes.setSelected(true);
		else
			rdbtnTransplantAutologousNo.setSelected(true);
		if (array[48] == "1")
			rdbtnPrimaryClosureYes.setSelected(true);
		else
			rdbtnPrimaryClosureNo.setSelected(true);
		tfDurationOfLabor.setText(array[49]);
		tfEstimatedBloodLoss.setText(array[50]);
		comboSpinalLevel.setSelectedItem(array[51]);
		comboApproachTechnique.setSelectedItem(array[52]);
		comboHipReplacement.setSelectedItem(array[53]);
		comboKneeReplacement.setSelectedItem(array[54]);
		if (array[34] == "1")
			rdbtnDiabetesMellitusYes.setSelected(true);
		tfHeight.setText(array[35]);
		comboHeightUnit.setSelectedItem(array[36]);
		comboWeightUnit.setSelectedItem(array[38]);
		tfWeight.setText(array[37]);
	}

	private void initialPopulateADTFields() {
		// MSH fields
		tfEncodingCharacters.setText(Data.mshArray[1]);
		tfSendingApplication.setText(Data.mshArray[2]);
		tfSendingFacility.setText(Data.mshArray[3]);
		tfReceivingApplication.setText(Data.mshArray[4]);
		tfReceivingFacility.setText(Data.mshArray[5]);
		tfADTMessageDate.setText(Data.checkDate(Data.mshArray[6]));
		tfSecurity.setText(Data.mshArray[7]);
		tfADTType.setText(Data.mshArray[8]);
		tfMessageControlID.setText(Data.mshArray[9]);
		tfProcessingID.setText(Data.mshArray[10]);
		tfVersionID.setText(Data.mshArray[11]);

		// PID fields
		tfPatientIDExternal.setText(Data.pidArray[2]);
		tfADTMRN.setText(Data.pidArray[3]);
		tfAlternatePatientID.setText(Data.pidArray[4]);
		tfADTPatientName.setText(Data.pidArray[5]);
		tfMothersMaiden.setText(Data.pidArray[6]);
		tfADTBirthdate.setText(Data.pidArray[7]);
		tfADTSex.setText(Data.pidArray[8]);
		tfPatientAlias.setText(Data.pidArray[9]);
		tfRace.setText(Data.pidArray[10]);
		tfPatientAddress.setText(Data.pidArray[11]);
		tfCountyCode.setText(Data.pidArray[12]);
		tfPhoneNumberHome.setText(Data.pidArray[13]);
		tfPhoneNumberBusiness.setText(Data.pidArray[14]);
		tfPrimaryLanguage.setText(Data.pidArray[15]);
		tfMaritalStatus.setText(Data.pidArray[16]);
		tfReligion.setText(Data.pidArray[17]);
		tfADTAccountNumber.setText(Data.pidArray[18]);
		tfSocialSecurityNumber.setText(Data.pidArray[19]);
		tfDriversLicenseNumber.setText(Data.pidArray[20]);
		tfMothersIdentifier.setText(Data.pidArray[21]);
		tfEthnicGroup.setText(Data.pidArray[22]);
		tfBirthPlace.setText(Data.pidArray[23]);
		tfMultipleBirthIndicator.setText(Data.pidArray[24]);
		tfBirthOrder.setText(Data.pidArray[25]);
		tfCitizenship.setText(Data.pidArray[26]);
		tfVeteransStatus.setText(Data.pidArray[27]);
		tfNationalityCode.setText(Data.pidArray[28]);
		tfPatientDeathDate.setText(Data.pidArray[29]);
		tfPatientDeathIndicator.setText(Data.pidArray[30]);

		// PV1 fields
		tfPatientClass.setText(Data.pv1Array[2]);
		String[] locationData = Data.pv1Array[3].split("\\^");
		tfADTInstitution.setText(locationData[0]);
		tfADTFloor.setText(locationData[1]);
		tfADTBed.setText(locationData[2]);
		tfAdmissionType.setText(Data.pv1Array[4]);
		tfPreadmitNumber.setText(Data.pv1Array[5]);
		tfPriorPatientLocation.setText(Data.pv1Array[6]);
		tfAttendingDoctor.setText(Data.pv1Array[7]);
		tfReferringDoctor.setText(Data.pv1Array[8]);
		tfConsultingDoctor.setText(Data.pv1Array[9]);
		tfHospitalService.setText(Data.pv1Array[10]);
		tfTemporaryLocation.setText(Data.pv1Array[11]);
		tfPreadmitTestIndicator.setText(Data.pv1Array[12]);
		tfReadmissionIndicator.setText(Data.pv1Array[13]);
		tfAdmitSource.setText(Data.pv1Array[14]);
		tfAmbulatoryStatus.setText(Data.pv1Array[15]);
		tfVIPIndicator.setText(Data.pv1Array[16]);
		tfAdmittingDoctor.setText(Data.pv1Array[17]);
		tfPatientType.setText(Data.pv1Array[18]);
		tfFinancialClass.setText(Data.pv1Array[20]); // 19 is Visit Number
														// (Unused field)
		tfChargePriceIndicator.setText(Data.pv1Array[21]);
		tfCourtesyCode.setText(Data.pv1Array[22]);
		tfCreditRating.setText(Data.pv1Array[23]);
		tfContractCode.setText(Data.pv1Array[24]);
		tfContractEffectiveDate.setText(Data.pv1Array[25]);
		tfContractAmount.setText(Data.pv1Array[26]);
		tfContractPeriod.setText(Data.pv1Array[27]);
		tfInterestCode.setText(Data.pv1Array[28]);
		tfTransferBadDebtCode.setText(Data.pv1Array[29]);
		tfTransferBadDebtDate.setText(Data.pv1Array[30]);
		tfBadDebtAgencyCode.setText(Data.pv1Array[31]);
		tfBadDebtTRFAmount.setText(Data.pv1Array[32]);
		tfBadDebtRecoveryAmt.setText(Data.pv1Array[33]);
		tfDeleteAcctIndicator.setText(Data.pv1Array[34]);
		tfDeleteAccountDate.setText(Data.pv1Array[35]);
		tfDichargeDisposition.setText(Data.pv1Array[36]);
		tfDischargeToLocation.setText(Data.pv1Array[37]);
		tfDietType.setText(Data.pv1Array[38]);
		tfServicingFacility.setText(Data.pv1Array[39]);
		tfBedStatus.setText(Data.pv1Array[40]);
		tfAccountStatus.setText(Data.pv1Array[41]);
		tfPendingLocation.setText(Data.pv1Array[42]);
		tfPriorTempLocation.setText(Data.pv1Array[43]);
		tfADTAdmitDate.setText(Data.pv1Array[44]);
		tfADTDischargeDate.setText(Data.pv1Array[45]);
		tfCurrentPatientBalance.setText(Data.pv1Array[46]);
		tfTotalCharges.setText(Data.pv1Array[47]);
		tfTotalAdjustments.setText(Data.pv1Array[48]);
		tfTotalPayments.setText(Data.pv1Array[49]);
		tfAlternativeVisitID.setText(Data.pv1Array[50]);
		tfVisitorIndicator.setText(Data.pv1Array[51]);
		tfOtherCareProvider.setText(Data.pv1Array[52]);
	}

	private void populateHL7Message() {
		// MSH fields
		Data.mshArray[1] = tfEncodingCharacters.getText();
		Data.mshArray[2] = tfSendingApplication.getText();
		Data.mshArray[3] = tfSendingFacility.getText();
		Data.mshArray[4] = tfReceivingApplication.getText();
		Data.mshArray[5] = tfReceivingFacility.getText();
		Data.mshArray[6] = Data.checkDate(tfADTMessageDate.getText());
		Data.mshArray[7] = tfSecurity.getText();
		Data.mshArray[8] = tfADTType.getText();
		Data.mshArray[9] = tfMessageControlID.getText();
		Data.mshArray[10] = tfProcessingID.getText();
		Data.mshArray[11] = tfVersionID.getText();

		// PID fields
		Data.pidArray[2] = tfPatientIDExternal.getText();
		Data.pidArray[3] = tfADTMRN.getText();
		Data.pidArray[4] = tfAlternatePatientID.getText();
		Data.pidArray[5] = tfADTPatientName.getText();
		Data.pidArray[6] = tfMothersMaiden.getText();
		Data.pidArray[7] = tfADTBirthdate.getText();
		Data.pidArray[8] = tfADTSex.getText();
		Data.pidArray[9] = tfPatientAlias.getText();
		Data.pidArray[10] = tfRace.getText();
		Data.pidArray[11] = tfPatientAddress.getText();
		Data.pidArray[12] = tfCountyCode.getText();
		Data.pidArray[13] = tfPhoneNumberHome.getText();
		Data.pidArray[14] = tfPhoneNumberBusiness.getText();
		Data.pidArray[15] = tfPrimaryLanguage.getText();
		Data.pidArray[16] = tfMaritalStatus.getText();
		Data.pidArray[17] = tfReligion.getText();
		Data.pidArray[18] = tfADTAccountNumber.getText();
		Data.pidArray[19] = tfSocialSecurityNumber.getText();
		Data.pidArray[20] = tfDriversLicenseNumber.getText();
		Data.pidArray[21] = tfMothersIdentifier.getText();
		Data.pidArray[22] = tfEthnicGroup.getText();
		Data.pidArray[23] = tfBirthPlace.getText();
		Data.pidArray[24] = tfMultipleBirthIndicator.getText();
		Data.pidArray[25] = tfBirthOrder.getText();
		Data.pidArray[26] = tfCitizenship.getText();
		Data.pidArray[27] = tfVeteransStatus.getText();
		Data.pidArray[28] = tfNationalityCode.getText();
		Data.pidArray[29] = tfPatientDeathDate.getText();
		Data.pidArray[30] = tfPatientDeathIndicator.getText();

		// PV1 fields
		Data.pv1Array[2] = tfPatientClass.getText();
		Data.pv1Array[3] = tfADTInstitution.getText() + "^" + tfADTFloor.getText() + "^" + tfADTBed.getText();
		Data.pv1Array[4] = tfAdmissionType.getText();
		Data.pv1Array[5] = tfPreadmitNumber.getText();
		Data.pv1Array[6] = tfPriorPatientLocation.getText();
		Data.pv1Array[7] = tfAttendingDoctor.getText();
		Data.pv1Array[8] = tfReferringDoctor.getText();
		Data.pv1Array[9] = tfConsultingDoctor.getText();
		Data.pv1Array[10] = tfHospitalService.getText();
		Data.pv1Array[11] = tfTemporaryLocation.getText();
		Data.pv1Array[12] = tfPreadmitTestIndicator.getText();
		Data.pv1Array[13] = tfReadmissionIndicator.getText();
		Data.pv1Array[14] = tfAdmitSource.getText();
		Data.pv1Array[15] = tfAmbulatoryStatus.getText();
		Data.pv1Array[16] = tfVIPIndicator.getText();
		Data.pv1Array[17] = tfAdmittingDoctor.getText();
		Data.pv1Array[18] = tfPatientType.getText();
		Data.pv1Array[19] = ""; // 19 is Visit Number (Unused field)
		Data.pv1Array[20] = tfFinancialClass.getText();
		Data.pv1Array[21] = tfChargePriceIndicator.getText();
		Data.pv1Array[22] = tfCourtesyCode.getText();
		Data.pv1Array[23] = tfCreditRating.getText();
		Data.pv1Array[24] = tfContractCode.getText();
		Data.pv1Array[25] = tfContractEffectiveDate.getText();
		Data.pv1Array[26] = tfContractAmount.getText();
		Data.pv1Array[27] = tfContractPeriod.getText();
		Data.pv1Array[28] = tfInterestCode.getText();
		Data.pv1Array[29] = tfTransferBadDebtCode.getText();
		Data.pv1Array[30] = tfTransferBadDebtDate.getText();
		Data.pv1Array[31] = tfBadDebtAgencyCode.getText();
		Data.pv1Array[32] = tfBadDebtTRFAmount.getText();
		Data.pv1Array[33] = tfBadDebtRecoveryAmt.getText();
		Data.pv1Array[34] = tfDeleteAcctIndicator.getText();
		Data.pv1Array[35] = tfDeleteAccountDate.getText();
		Data.pv1Array[36] = tfDichargeDisposition.getText();
		Data.pv1Array[37] = tfDischargeToLocation.getText();
		Data.pv1Array[38] = tfDietType.getText();
		Data.pv1Array[39] = tfServicingFacility.getText();
		Data.pv1Array[40] = tfBedStatus.getText();
		Data.pv1Array[41] = tfAccountStatus.getText();
		Data.pv1Array[42] = tfPendingLocation.getText();
		Data.pv1Array[43] = tfPriorTempLocation.getText();
		Data.pv1Array[44] = Data.checkDate(tfADTAdmitDate.getText());
		Data.pv1Array[45] = tfADTDischargeDate.getText();
		Data.pv1Array[46] = tfCurrentPatientBalance.getText();
		Data.pv1Array[47] = tfTotalCharges.getText();
		Data.pv1Array[48] = tfTotalAdjustments.getText();
		Data.pv1Array[49] = tfTotalPayments.getText();
		Data.pv1Array[50] = tfAlternativeVisitID.getText();
		Data.pv1Array[51] = tfVisitorIndicator.getText();
		Data.pv1Array[52] = tfOtherCareProvider.getText();
	}

	// Conditional Fields for ADT turn off and on
	private void enableADTConditionalFields() {
		// MSH fields
		tfSendingApplication.setEnabled(true);
		tfSendingFacility.setEnabled(true);

		// PID fields
		tfPatientIDExternal.setEnabled(true);
		tfAlternatePatientID.setEnabled(true);
		tfADTBirthdate.setEnabled(true);
		tfADTSex.setEnabled(true);

		// PV1 fields
		tfAttendingDoctor.setEnabled(true);
		tfHospitalService.setEnabled(true);
		tfDichargeDisposition.setEnabled(true);
		tfServicingFacility.setEnabled(true);
		tfADTAdmitDate.setEnabled(true);
		tfADTDischargeDate.setEnabled(true);
	}

	private void disableADTConditionalFields() {
		// MSH fields
		tfSendingApplication.setEnabled(false);
		tfSendingFacility.setEnabled(false);

		// PID fields
		tfPatientIDExternal.setEnabled(false);
		tfAlternatePatientID.setEnabled(false);
		tfADTBirthdate.setEnabled(false);
		tfADTSex.setEnabled(false);

		// PV1 fields
		tfAttendingDoctor.setEnabled(false);
		tfHospitalService.setEnabled(false);
		tfDichargeDisposition.setEnabled(false);
		tfServicingFacility.setEnabled(false);
		tfADTAdmitDate.setEnabled(false);
		tfADTDischargeDate.setEnabled(false);
	}

	private void enableADTOptionalFields() {
		// MSH fields
		tfReceivingApplication.setEnabled(true);
		tfReceivingFacility.setEnabled(true);
		tfSecurity.setEnabled(true);
		tfMessageControlID.setEnabled(true);
		tfProcessingID.setEnabled(true);
		tfVersionID.setEnabled(true);

		// PID fields
		tfMothersMaiden.setEnabled(true);
		tfPatientAlias.setEnabled(true);
		tfRace.setEnabled(true);
		tfPatientAddress.setEnabled(true);
		tfCountyCode.setEnabled(true);
		tfPhoneNumberHome.setEnabled(true);
		tfPhoneNumberBusiness.setEnabled(true);
		tfPrimaryLanguage.setEnabled(true);
		tfMaritalStatus.setEnabled(true);
		tfReligion.setEnabled(true);
		tfSocialSecurityNumber.setEnabled(true);
		tfDriversLicenseNumber.setEnabled(true);
		tfMothersIdentifier.setEnabled(true);
		tfEthnicGroup.setEnabled(true);
		tfBirthPlace.setEnabled(true);
		tfMultipleBirthIndicator.setEnabled(true);
		tfBirthOrder.setEnabled(true);
		tfCitizenship.setEnabled(true);
		tfVeteransStatus.setEnabled(true);
		tfNationalityCode.setEnabled(true);
		tfPatientDeathDate.setEnabled(true);
		tfPatientDeathIndicator.setEnabled(true);

		// PV1 fields
		tfAdmissionType.setEnabled(true);
		tfPreadmitNumber.setEnabled(true);
		tfPriorPatientLocation.setEnabled(true);
		tfReferringDoctor.setEnabled(true);
		tfConsultingDoctor.setEnabled(true);
		tfTemporaryLocation.setEnabled(true);
		tfPreadmitTestIndicator.setEnabled(true);
		tfReadmissionIndicator.setEnabled(true);
		tfAdmitSource.setEnabled(true);
		tfAmbulatoryStatus.setEnabled(true);
		tfVIPIndicator.setEnabled(true);
		tfAdmittingDoctor.setEnabled(true);
		tfPatientType.setEnabled(true);
		tfFinancialClass.setEnabled(true);
		tfChargePriceIndicator.setEnabled(true);
		tfCourtesyCode.setEnabled(true);
		tfCreditRating.setEnabled(true);
		tfContractCode.setEnabled(true);
		tfContractEffectiveDate.setEnabled(true);
		tfContractAmount.setEnabled(true);
		tfContractPeriod.setEnabled(true);
		tfInterestCode.setEnabled(true);
		tfTransferBadDebtCode.setEnabled(true);
		tfTransferBadDebtDate.setEnabled(true);
		tfBadDebtAgencyCode.setEnabled(true);
		tfBadDebtTRFAmount.setEnabled(true);
		tfBadDebtRecoveryAmt.setEnabled(true);
		tfDeleteAcctIndicator.setEnabled(true);
		tfDeleteAccountDate.setEnabled(true);
		tfDischargeToLocation.setEnabled(true);
		tfDietType.setEnabled(true);
		tfBedStatus.setEnabled(true);
		tfAccountStatus.setEnabled(true);
		tfPendingLocation.setEnabled(true);
		tfPriorTempLocation.setEnabled(true);
		tfCurrentPatientBalance.setEnabled(true);
		tfTotalCharges.setEnabled(true);
		tfTotalPayments.setEnabled(true);
		tfTotalAdjustments.setEnabled(true);
		tfAlternativeVisitID.setEnabled(true);
		tfVisitorIndicator.setEnabled(true);
		tfOtherCareProvider.setEnabled(true);
	}

	private void disableADTOptionalFields() {
		// MSH fields
		tfReceivingApplication.setEnabled(false);
		tfReceivingFacility.setEnabled(false);
		tfSecurity.setEnabled(false);
		tfMessageControlID.setEnabled(false);
		tfProcessingID.setEnabled(false);
		tfVersionID.setEnabled(false);

		// PID fields
		tfMothersMaiden.setEnabled(false);
		tfPatientAlias.setEnabled(false);
		tfRace.setEnabled(false);
		tfPatientAddress.setEnabled(false);
		tfCountyCode.setEnabled(false);
		tfPhoneNumberHome.setEnabled(false);
		tfPhoneNumberBusiness.setEnabled(false);
		tfPrimaryLanguage.setEnabled(false);
		tfMaritalStatus.setEnabled(false);
		tfReligion.setEnabled(false);
		tfSocialSecurityNumber.setEnabled(false);
		tfDriversLicenseNumber.setEnabled(false);
		tfMothersIdentifier.setEnabled(false);
		tfEthnicGroup.setEnabled(false);
		tfBirthPlace.setEnabled(false);
		tfMultipleBirthIndicator.setEnabled(false);
		tfBirthOrder.setEnabled(false);
		tfCitizenship.setEnabled(false);
		tfVeteransStatus.setEnabled(false);
		tfNationalityCode.setEnabled(false);
		tfPatientDeathDate.setEnabled(false);
		tfPatientDeathIndicator.setEnabled(false);

		// PV1 fields
		tfAdmissionType.setEnabled(false);
		tfPreadmitNumber.setEnabled(false);
		tfPriorPatientLocation.setEnabled(false);
		tfReferringDoctor.setEnabled(false);
		tfConsultingDoctor.setEnabled(false);
		tfTemporaryLocation.setEnabled(false);
		tfPreadmitTestIndicator.setEnabled(false);
		tfReadmissionIndicator.setEnabled(false);
		tfAdmitSource.setEnabled(false);
		tfAmbulatoryStatus.setEnabled(false);
		tfVIPIndicator.setEnabled(false);
		tfAdmittingDoctor.setEnabled(false);
		tfPatientType.setEnabled(false);
		tfFinancialClass.setEnabled(false);
		tfChargePriceIndicator.setEnabled(false);
		tfCourtesyCode.setEnabled(false);
		tfCreditRating.setEnabled(false);
		tfContractCode.setEnabled(false);
		tfContractEffectiveDate.setEnabled(false);
		tfContractAmount.setEnabled(false);
		tfContractPeriod.setEnabled(false);
		tfInterestCode.setEnabled(false);
		tfTransferBadDebtCode.setEnabled(false);
		tfTransferBadDebtDate.setEnabled(false);
		tfBadDebtAgencyCode.setEnabled(false);
		tfBadDebtTRFAmount.setEnabled(false);
		tfBadDebtRecoveryAmt.setEnabled(false);
		tfDeleteAcctIndicator.setEnabled(false);
		tfDeleteAccountDate.setEnabled(false);
		tfDischargeToLocation.setEnabled(true);
		tfDietType.setEnabled(false);
		tfBedStatus.setEnabled(false);
		tfAccountStatus.setEnabled(false);
		tfPendingLocation.setEnabled(false);
		tfPriorTempLocation.setEnabled(false);
		tfCurrentPatientBalance.setEnabled(false);
		tfTotalCharges.setEnabled(false);
		tfTotalPayments.setEnabled(false);
		tfTotalAdjustments.setEnabled(false);
		tfAlternativeVisitID.setEnabled(false);
		tfVisitorIndicator.setEnabled(false);
		tfOtherCareProvider.setEnabled(false);
	}

	protected void populateMicroFields() {
		tfOrderControl.setText(Micro.orcArray[1]);
		tfPlaceOrderNumber.setText(Micro.orcArray[2]);
		tfFillerOrderNumber.setText(Micro.orcArray[3]);
		tfPlacerGroupNumber.setText(Micro.orcArray[4]);
		tfOrderStatus.setText(Micro.orcArray[5]);
		tfResponseFlag.setText(Micro.orcArray[6]);
		tfQuantityTiming.setText(Micro.orcArray[7]);
		tfParent.setText(Micro.orcArray[8]);
		tfDateTimeTransaction.setText(Micro.orcArray[9]);
		tfEnteredBy.setText(Micro.orcArray[10]);
		tfVerifiedBy.setText(Micro.orcArray[11]);
		tfOrderingProvider.setText(Micro.orcArray[12]);
		tfEnterersLocation.setText(Micro.orcArray[13]);
		tfCallbackPhone.setText(Micro.orcArray[14]);
		tfOrderEffectiveDateTime.setText(Micro.orcArray[15]);
		tfOrderControlCodeReason.setText(Micro.orcArray[16]);
		tfEnteringOrganization.setText(Micro.orcArray[17]);
		tfActionBy.setText(Micro.orcArray[18]);

		// OBR
		//
	}

	// parses and assigns fields to array index in obrArray
	protected void populateCurrentOBR() {
		tfOBRPlaceOrderNumber.setText(Micro.obrArray[2]);
		tfOBRFillerOrderNumber.setText(Micro.obrArray[3]);
		tfOBRUniversalServiceIdentifier.setText(Micro.obrArray[4]);
		tfOBRPriority.setText(Micro.obrArray[5]);
		tfOBRRequestedDateTime.setText(Micro.obrArray[6]);
		tfOBRObservationDateTime.setText(Micro.obrArray[7]);
		tfOBRObservationEndDateTime.setText(Micro.obrArray[8]);
		tfOBRCollectionVolume.setText(Micro.obrArray[9]);
		tfOBRCollectorIdentifier.setText(Micro.obrArray[10]);
		tfOBRSpecimenActionCode.setText(Micro.obrArray[11]);
		tfOBRDangerCode.setText(Micro.obrArray[12]);
		tfOBRRelevantClinicalInfo.setText(Micro.obrArray[13]);
		tfOBRSpecimenReceivedDateTime.setText(Micro.obrArray[14]);
		tfOBRSpecimenSource.setText(Micro.obrArray[15]);
		tfOBROrderingProvider.setText(Micro.obrArray[16]);
		tfOBROrderCallbackPhone.setText(Micro.obrArray[17]);
		tfOBRPlacerField1.setText(Micro.obrArray[18]);
		tfOBRPlacerField2.setText(Micro.obrArray[19]);
		tfOBRFillerField1.setText(Micro.obrArray[20]);
		tfOBRFillerField2.setText(Micro.obrArray[21]);
		tfOBRResultsRptStatusChng.setText(Micro.obrArray[22]);
		tfOBRChargeToPractice.setText(Micro.obrArray[23]);
		tfOBRDiagnosticServiceSectionID.setText(Micro.obrArray[24]);
		tfOBRResultsStatus.setText(Micro.obrArray[25]);
		tfOBRParentResult.setText(Micro.obrArray[26]);
		tfOBRQuantityTiming.setText(Micro.obrArray[27]);
		tfOBRResultCopiesTo.setText(Micro.obrArray[28]);
		tfOBRParentNumber.setText(Micro.obrArray[29]);
		tfOBRTransportationMode.setText(Micro.obrArray[30]);
		tfOBRReasonForStudy.setText(Micro.obrArray[31]);
		tfOBRPrincipalResultInterpreter.setText(Micro.obrArray[32]);
		tfOBRAssistantResultInterpreter.setText(Micro.obrArray[33]);
		tfOBRTechnician.setText(Micro.obrArray[34]);
		tfOBRTranscriptionist.setText(Micro.obrArray[35]);
		tfOBRScheduledDateTime.setText(Micro.obrArray[36]);
		tfOBRNumberOfSamplesContainers.setText(Micro.obrArray[37]);
		tfOBRTransportLogisiticsOfCollectedSample.setText(Micro.obrArray[38]);
		tfOBRCollectorsComment.setText(Micro.obrArray[39]);
		tfOBRTransportArrangement.setText(Micro.obrArray[40]);
		tfOBRTransportArranged.setText(Micro.obrArray[41]);
		tfOBREscortRequired.setText(Micro.obrArray[42]);
		tfOBRPlannedPatientTransportComment.setText(Micro.obrArray[43]);
	}

	// parses and assigns fields to array index in obxArray
	protected void populateCurrentOBX(ArrayList<String> currentOBRArray, String selection) {
		int arrayIndex = Integer.parseInt(selection.substring(selection.indexOf(" ") + 1).trim());
		String[] obxArray = currentOBRArray.get(arrayIndex - 1).split("\\|", -1);
		tfOBXValueType.setText(obxArray[2]);
		tfOBXObservationIdentifier.setText(obxArray[3]);
		tfOBXObservationSubID.setText(obxArray[4]);
		tfOBXObservationValue.setText(obxArray[5]);
		tfOBXUnits.setText(obxArray[6]);
		tfOBXReferencesRange.setText(obxArray[7]);
		tfOBXAbnormalFlags.setText(obxArray[8]);
		tfOBXProbability.setText(obxArray[9]);
		tfOBXNatureOfAbnormalTest.setText(obxArray[10]);
		tfOBXObservResultStatus.setText(obxArray[11]);
		tfOBXDateLastObsNormalValues.setText(obxArray[12]);
		tfOBXUserDefinedAccessChecks.setText(obxArray[13]);
		tfOBXDateTimeOfTheObservation.setText(obxArray[14]);
		tfOBXProducersID.setText(obxArray[15]);
		tfOBXResponsibleObserver.setText(obxArray[16]);
		tfOBXObservationMethod.setText(obxArray[17]);
	}

	protected void saveORCValues() {
		// ORC lines
		Micro.orcArray[1] = tfOrderControl.getText();
		Micro.orcArray[2] = tfPlaceOrderNumber.getText();
		Micro.orcArray[3] = tfFillerOrderNumber.getText();
		Micro.orcArray[4] = tfPlacerGroupNumber.getText();
		Micro.orcArray[5] = tfOrderStatus.getText();
		Micro.orcArray[6] = tfResponseFlag.getText();
		Micro.orcArray[7] = tfQuantityTiming.getText();
		Micro.orcArray[8] = tfParent.getText();
		Micro.orcArray[9] = tfDateTimeTransaction.getText();
		Micro.orcArray[10] = tfEnteredBy.getText();
		Micro.orcArray[11] = tfVerifiedBy.getText();
		Micro.orcArray[12] = tfOrderingProvider.getText();
		Micro.orcArray[13] = tfEnterersLocation.getText();
		Micro.orcArray[14] = tfCallbackPhone.getText();
		Micro.orcArray[15] = tfOrderEffectiveDateTime.getText();
		Micro.orcArray[16] = tfOrderControlCodeReason.getText();
		Micro.orcArray[17] = tfEnteringOrganization.getText();
		Micro.orcArray[18] = tfActionBy.getText();
	}

	// save new input to save OBR fields
	protected void saveOBRValues() {
		Micro.obrArray[2] = tfOBRPlaceOrderNumber.getText();
		Micro.obrArray[3] = tfOBRFillerOrderNumber.getText();
		Micro.obrArray[4] = tfOBRUniversalServiceIdentifier.getText();
		Micro.obrArray[5] = tfOBRPriority.getText();
		Micro.obrArray[6] = tfOBRRequestedDateTime.getText();
		Micro.obrArray[7] = tfOBRObservationDateTime.getText();
		Micro.obrArray[8] = tfOBRObservationEndDateTime.getText();
		Micro.obrArray[9] = tfOBRCollectionVolume.getText();
		Micro.obrArray[10] = tfOBRCollectorIdentifier.getText();
		Micro.obrArray[11] = tfOBRSpecimenActionCode.getText();
		Micro.obrArray[12] = tfOBRDangerCode.getText();
		Micro.obrArray[13] = tfOBRRelevantClinicalInfo.getText();
		Micro.obrArray[14] = tfOBRSpecimenReceivedDateTime.getText();
		Micro.obrArray[15] = tfOBRSpecimenSource.getText();
		Micro.obrArray[16] = tfOBROrderingProvider.getText();
		Micro.obrArray[17] = tfOBROrderCallbackPhone.getText();
		Micro.obrArray[18] = tfOBRPlacerField1.getText();
		Micro.obrArray[19] = tfOBRPlacerField2.getText();
		Micro.obrArray[20] = tfOBRFillerField1.getText();
		Micro.obrArray[21] = tfOBRFillerField2.getText();
		Micro.obrArray[22] = tfOBRResultsRptStatusChng.getText();
		Micro.obrArray[23] = tfOBRChargeToPractice.getText();
		Micro.obrArray[24] = tfOBRDiagnosticServiceSectionID.getText();
		Micro.obrArray[25] = tfOBRResultsStatus.getText();
		Micro.obrArray[26] = tfOBRParentResult.getText();
		Micro.obrArray[27] = tfOBRQuantityTiming.getText();
		Micro.obrArray[28] = tfOBRResultCopiesTo.getText();
		Micro.obrArray[29] = tfOBRParentNumber.getText();
		Micro.obrArray[30] = tfOBRTransportationMode.getText();
		Micro.obrArray[31] = tfOBRReasonForStudy.getText();
		Micro.obrArray[32] = tfOBRPrincipalResultInterpreter.getText();
		Micro.obrArray[33] = tfOBRAssistantResultInterpreter.getText();
		Micro.obrArray[34] = tfOBRTechnician.getText();
		Micro.obrArray[35] = tfOBRTranscriptionist.getText();
		Micro.obrArray[36] = tfOBRScheduledDateTime.getText();
		Micro.obrArray[37] = tfOBRNumberOfSamplesContainers.getText();
		Micro.obrArray[38] = tfOBRTransportLogisiticsOfCollectedSample.getText();
		Micro.obrArray[39] = tfOBRCollectorsComment.getText();
		Micro.obrArray[40] = tfOBRTransportArrangement.getText();
		Micro.obrArray[41] = tfOBRTransportArranged.getText();
		Micro.obrArray[42] = tfOBREscortRequired.getText();
		Micro.obrArray[43] = tfOBRPlannedPatientTransportComment.getText();
	}

	// save new input to OBX fields
	protected void saveOBXValues() {
		obxArray[2] = tfOBXValueType.getText();
		obxArray[3] = tfOBXObservationIdentifier.getText();
		obxArray[4] = tfOBXObservationSubID.getText();
		obxArray[5] = tfOBXObservationValue.getText();
		obxArray[5] = tfOBXObservationValue.getText();
		obxArray[6] = tfOBXUnits.getText();
		obxArray[7] = tfOBXReferencesRange.getText();
		obxArray[8] = tfOBXAbnormalFlags.getText();
		obxArray[9] = tfOBXProbability.getText();
		obxArray[10] = tfOBXNatureOfAbnormalTest.getText();
		obxArray[11] = tfOBXObservResultStatus.getText();
		obxArray[12] = tfOBXDateLastObsNormalValues.getText();
		obxArray[13] = tfOBXUserDefinedAccessChecks.getText();
		obxArray[14] = tfOBXDateTimeOfTheObservation.getText();
		obxArray[15] = tfOBXProducersID.getText();
		obxArray[16] = tfOBXResponsibleObserver.getText();
		obxArray[17] = tfOBXObservationMethod.getText();
	}

	protected void populateSurgeryFromADT() {
		try {
			Data.compileHL7();
			tfSurgeryMRN.setText(Data.spinTheWheel(Data.pidArray[3]));
			tfSurgeryAccountNumber.setText(Data.pidArray[18]);
			String[] patName = tfADTPatientName.getText().split("\\^");
			tfSurgeryFamilyName.setText(patName[0]);
			tfSurgeryGivenName.setText(patName[1]);
		} catch (NullPointerException e) {
			// labelSurgeryStatus.setText("No ADT information available to
			// populate surgery");
			System.err.println("HL7 Arrays are null");
			JOptionPane.showMessageDialog(frmScenarioBuilder, "ADT information has not been filled out");
		}
	}

	// populate fields from ADT to Micro with notification if no ADT fields are
	// full
	void populateMicroFromAdt() {
		try {
			int returnVal;

			if (!taMicro.getText().isEmpty()) {
				returnVal = JOptionPane.showConfirmDialog(frmScenarioBuilder,
						"Are you sure you want to load MSH, PID and PV1 segments from ADT data?");
				if (returnVal == JOptionPane.YES_OPTION) {
					taMicro.setText(Data.compileMicroHeader());
					microHeaderPresent = true;
				}
			} else {
				taMicro.setText(Data.compileMicroHeader());
				microHeaderPresent = true;
			}
		} catch (NullPointerException e) {
			// System.err.println("HL7 Arrays are null");
			JOptionPane.showMessageDialog(frmScenarioBuilder, "ADT information has not been filled out.");
		}

	}

	private void displayHL7Template() throws IOException {
		taHL7.setText(Data.readHL7Template());
	}

	private void displayHL7Message() {
		taHL7.setText(Data.compileHL7());
	}

	private void createLabelTimer(final JLabel label, int seconds) {
		timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				label.setText("");
			}
		}, seconds);
	}
	private void clearAllMicroFields(){
	//clearOBR
		tfOBRPlaceOrderNumber.setText(null);
		tfOBRFillerOrderNumber.setText(null);
		tfOBRUniversalServiceIdentifier.setText(null);
		tfOBRPriority.setText(null);
		tfOBRRequestedDateTime.setText(null);
		tfOBRObservationDateTime.setText(null);
		tfOBRObservationEndDateTime.setText(null);
		tfOBRCollectionVolume.setText(null);
		tfOBRCollectorIdentifier.setText(null);
		tfOBRSpecimenActionCode.setText(null);
		tfOBRDangerCode.setText(null);
		tfOBRRelevantClinicalInfo.setText(null);
		tfOBRSpecimenReceivedDateTime.setText(null);
		tfOBRSpecimenSource.setText(null);
		tfOBROrderingProvider.setText(null);
		tfOBROrderCallbackPhone.setText(null);
		tfOBRPlacerField1.setText(null);
		tfOBRPlacerField2.setText(null);
		tfOBRFillerField1.setText(null);
		tfOBRFillerField2.setText(null);
		tfOBRResultsRptStatusChng.setText(null);
		tfOBRChargeToPractice.setText(null);
		tfOBRDiagnosticServiceSectionID.setText(null);
		tfOBRResultsStatus.setText(null);
		tfOBRParentResult.setText(null);
		tfOBRQuantityTiming.setText(null);
		tfOBRResultCopiesTo.setText(null);
		tfOBRParentNumber.setText(null);
		tfOBRTransportationMode.setText(null);
		tfOBRReasonForStudy.setText(null);
		tfOBRPrincipalResultInterpreter.setText(null);
		tfOBRAssistantResultInterpreter.setText(null);
		tfOBRTechnician.setText(null);
		tfOBRTranscriptionist.setText(null);
		tfOBRScheduledDateTime.setText(null);
		tfOBRNumberOfSamplesContainers.setText(null);
		tfOBRTransportLogisiticsOfCollectedSample.setText(null);
		tfOBRCollectorsComment.setText(null);
		tfOBRTransportArrangement.setText(null);
		tfOBRTransportArranged.setText(null);
		tfOBREscortRequired.setText(null);
		tfOBRPlannedPatientTransportComment.setText(null);
		//clear OBX
		tfOBXValueType.setText(null);
		tfOBXObservationIdentifier.setText(null);
		tfOBXObservationSubID.setText(null);
		tfOBXObservationValue.setText(null);
		tfOBXUnits.setText(null);
		tfOBXReferencesRange.setText(null);
		tfOBXAbnormalFlags.setText(null);
		tfOBXProbability.setText(null);
		tfOBXNatureOfAbnormalTest.setText(null);
		tfOBXObservResultStatus.setText(null);
		tfOBXDateLastObsNormalValues.setText(null);
		tfOBXUserDefinedAccessChecks.setText(null);
		tfOBXDateTimeOfTheObservation.setText(null);
		tfOBXProducersID.setText(null);
		tfOBXResponsibleObserver.setText(null);
		tfOBXObservationMethod.setText(null);
		
	}
}

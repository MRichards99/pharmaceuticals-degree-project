package mrichards;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.SpinnerNumberModel;

public class PharmaceuticalForm extends JFrame {

	private JPanel contentPane;
	private JTextField totalPrescriptionItemsField;
	private JTextField totalNumberOfContainersField;
	private JButton exitButton;
	private JComboBox pharmaceuticalNameComboBox;
	private JTable table;
	private JLabel dailyDoseDisplay;
	private JSpinner prescribedDailyDoseSelect;
	private JTextArea pharmaceuticalDescriptionTextArea;
	private Pharmaceutical currentPharmaceutical;
	private Prescription prescription = new Prescription();
	DefaultTableModel tableModel;

	/**
	 * Create and open form.
	 */
	 
	public void createForm() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			PharmaceuticalForm frame = new PharmaceuticalForm();
			frame.setVisible(true);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}	

	/**
	 * Create the frame.
	 */
	public PharmaceuticalForm() {
		// Creating connection with Hibernate
		HibernateDB databaseConnection = new HibernateDB();
		
		
		// General frame configuration
		setPreferredSize(new Dimension(800, 800));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 996, 364);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		// Configuring optionsPanel
		JPanel optionsPanel = new JPanel();
		contentPane.add(optionsPanel, BorderLayout.NORTH);
		GridBagLayout gbl_optionsPanel = new GridBagLayout();
		gbl_optionsPanel.columnWidths = new int[]{140, 100, 155, 200, 100, 130, 73, 0};
		gbl_optionsPanel.rowHeights = new int[]{25, 25, 25, 0};
		gbl_optionsPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_optionsPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		optionsPanel.setLayout(gbl_optionsPanel);
		
		JLabel pharmaceuticalNameLabel = new JLabel("Pharmaceutical Name:");
		GridBagConstraints gbc_pharmaceuticalNameLabel = new GridBagConstraints();
		gbc_pharmaceuticalNameLabel.fill = GridBagConstraints.BOTH;
		gbc_pharmaceuticalNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_pharmaceuticalNameLabel.gridx = 0;
		gbc_pharmaceuticalNameLabel.gridy = 0;
		optionsPanel.add(pharmaceuticalNameLabel, gbc_pharmaceuticalNameLabel);
		
		JLabel dailyDoseLabel = new JLabel("Rec. Daily Dose:");
		GridBagConstraints gbc_dailyDoseLabel = new GridBagConstraints();
		gbc_dailyDoseLabel.fill = GridBagConstraints.BOTH;
		gbc_dailyDoseLabel.insets = new Insets(0, 0, 5, 5);
		gbc_dailyDoseLabel.gridx = 1;
		gbc_dailyDoseLabel.gridy = 0;
		optionsPanel.add(dailyDoseLabel, gbc_dailyDoseLabel);
		
		JLabel prescribedDailyDoseLabel = new JLabel("Prescribed Daily Dose");
		GridBagConstraints gbc_prescribedDailyDoseLabel = new GridBagConstraints();
		gbc_prescribedDailyDoseLabel.fill = GridBagConstraints.BOTH;
		gbc_prescribedDailyDoseLabel.insets = new Insets(0, 0, 5, 5);
		gbc_prescribedDailyDoseLabel.gridx = 2;
		gbc_prescribedDailyDoseLabel.gridy = 0;
		optionsPanel.add(prescribedDailyDoseLabel, gbc_prescribedDailyDoseLabel);
		
		JLabel descriptionSpecialDetailsLabel = new JLabel("Description & Special Details:");
		GridBagConstraints gbc_descriptionSpecialDetailsLabel = new GridBagConstraints();
		gbc_descriptionSpecialDetailsLabel.fill = GridBagConstraints.BOTH;
		gbc_descriptionSpecialDetailsLabel.insets = new Insets(0, 0, 5, 5);
		gbc_descriptionSpecialDetailsLabel.gridx = 3;
		gbc_descriptionSpecialDetailsLabel.gridy = 0;
		optionsPanel.add(descriptionSpecialDetailsLabel, gbc_descriptionSpecialDetailsLabel);
		
		JTextArea pharmaceuticalDescriptionTextArea = new JTextArea();
		pharmaceuticalDescriptionTextArea.setLineWrap(true);
		GridBagConstraints gbc_pharmaceuticalDescriptionTextArea = new GridBagConstraints();
		gbc_pharmaceuticalDescriptionTextArea.gridheight = 2;
		gbc_pharmaceuticalDescriptionTextArea.fill = GridBagConstraints.BOTH;
		gbc_pharmaceuticalDescriptionTextArea.insets = new Insets(0, 0, 5, 5);
		gbc_pharmaceuticalDescriptionTextArea.gridx = 3;
		gbc_pharmaceuticalDescriptionTextArea.gridy = 1;
		optionsPanel.add(pharmaceuticalDescriptionTextArea, gbc_pharmaceuticalDescriptionTextArea);
		
		JLabel durationLabel = new JLabel("Duration:");
		GridBagConstraints gbc_durationLabel = new GridBagConstraints();
		gbc_durationLabel.fill = GridBagConstraints.BOTH;
		gbc_durationLabel.insets = new Insets(0, 0, 5, 5);
		gbc_durationLabel.gridx = 4;
		gbc_durationLabel.gridy = 0;
		optionsPanel.add(durationLabel, gbc_durationLabel);
		
		JSpinner prescribedDailyDoseSelect = new JSpinner();
		prescribedDailyDoseSelect.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		GridBagConstraints gbc_prescribedDailyDoseSelect = new GridBagConstraints();
		gbc_prescribedDailyDoseSelect.fill = GridBagConstraints.BOTH;
		gbc_prescribedDailyDoseSelect.insets = new Insets(0, 0, 5, 5);
		gbc_prescribedDailyDoseSelect.gridx = 2;
		gbc_prescribedDailyDoseSelect.gridy = 1;
		optionsPanel.add(prescribedDailyDoseSelect, gbc_prescribedDailyDoseSelect);
		
		JSpinner durationSpinner = new JSpinner();
		durationSpinner.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		GridBagConstraints gbc_durationSpinner = new GridBagConstraints();
		gbc_durationSpinner.fill = GridBagConstraints.BOTH;
		gbc_durationSpinner.insets = new Insets(0, 0, 5, 5);
		gbc_durationSpinner.gridx = 4;
		gbc_durationSpinner.gridy = 1;
		optionsPanel.add(durationSpinner, gbc_durationSpinner);
		
		JButton addButton = new JButton("Add");
		addButton.setEnabled(false);
		addButton.setHorizontalTextPosition(SwingConstants.CENTER);
		GridBagConstraints gbc_addButton = new GridBagConstraints();
		gbc_addButton.anchor = GridBagConstraints.WEST;
		gbc_addButton.fill = GridBagConstraints.BOTH;
		gbc_addButton.insets = new Insets(0, 0, 5, 0);
		gbc_addButton.gridx = 6;
		gbc_addButton.gridy = 1;
		optionsPanel.add(addButton, gbc_addButton);
		
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// Insert pharmaceutical selected by user into prescription
				
				prescription.addPrescriptionItem(currentPharmaceutical.getPharmaceuticalName(), 
												 (Integer) prescribedDailyDoseSelect.getValue(),
												 (Integer) durationSpinner.getValue(),
												 currentPharmaceutical.getSpecialRequirementID().getContainerSize(),
												 currentPharmaceutical.getSpecialRequirementID().isAvailableOverTheCounter(),
												 pharmaceuticalDescriptionTextArea.getText());
				updateTable();
			}
		});
		
		pharmaceuticalNameComboBox = new JComboBox();
		Vector<String> pharmaceuticalNames = databaseConnection.getPharmaceuticalNames();
		for(String pharmaceuticalName : pharmaceuticalNames) {
			pharmaceuticalNameComboBox.addItem(pharmaceuticalName);
		}
		
		// No item will appear in drop down until selected by the user
		pharmaceuticalNameComboBox.setSelectedIndex(-1);
		
		pharmaceuticalNameComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String selectedPharmaceutical = (String) pharmaceuticalNameComboBox.getSelectedItem();
				currentPharmaceutical = databaseConnection.getPharmaceutical(selectedPharmaceutical);
				dailyDoseDisplay.setText(String.valueOf(currentPharmaceutical.getRecommendedDailyDose()));
				prescribedDailyDoseSelect.setValue(Integer.valueOf(currentPharmaceutical.getRecommendedDailyDose()));
				pharmaceuticalDescriptionTextArea.setText(currentPharmaceutical.getDescription());

				// Add button disabled until an item is selected
				addButton.setEnabled(true);
			}
		});
		
		GridBagConstraints gbc_pharmaceuticalNameComboBox = new GridBagConstraints();
		gbc_pharmaceuticalNameComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_pharmaceuticalNameComboBox.gridx = 0;
		gbc_pharmaceuticalNameComboBox.gridy = 1;
		optionsPanel.add(pharmaceuticalNameComboBox, gbc_pharmaceuticalNameComboBox);
		
		dailyDoseDisplay = new JLabel("");
		dailyDoseDisplay.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_dailyDoseDisplay = new GridBagConstraints();
		gbc_dailyDoseDisplay.fill = GridBagConstraints.BOTH;
		gbc_dailyDoseDisplay.insets = new Insets(0, 0, 5, 5);
		gbc_dailyDoseDisplay.gridx = 1;
		gbc_dailyDoseDisplay.gridy = 1;
		optionsPanel.add(dailyDoseDisplay, gbc_dailyDoseDisplay);
		
		JCheckBox addCommentCheckBox = new JCheckBox("Add Comment?");
		GridBagConstraints gbc_addCommentCheckBox = new GridBagConstraints();
		gbc_addCommentCheckBox.fill = GridBagConstraints.BOTH;
		gbc_addCommentCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_addCommentCheckBox.gridx = 5;
		gbc_addCommentCheckBox.gridy = 1;
		optionsPanel.add(addCommentCheckBox, gbc_addCommentCheckBox);
		
		JLabel prescriptionLabel = new JLabel("Prescription Table:");
		GridBagConstraints gbc_prescriptionLabel = new GridBagConstraints();
		gbc_prescriptionLabel.fill = GridBagConstraints.BOTH;
		gbc_prescriptionLabel.insets = new Insets(0, 0, 0, 5);
		gbc_prescriptionLabel.gridx = 0;
		gbc_prescriptionLabel.gridy = 2;
		optionsPanel.add(prescriptionLabel, gbc_prescriptionLabel);
		
		JCheckBox exceedDailyDoseCheckBox = new JCheckBox("OK to Exceed Daily Dose?");
		GridBagConstraints gbc_exceedDailyDoseCheckBox = new GridBagConstraints();
		gbc_exceedDailyDoseCheckBox.fill = GridBagConstraints.BOTH;
		gbc_exceedDailyDoseCheckBox.insets = new Insets(0, 0, 0, 5);
		gbc_exceedDailyDoseCheckBox.gridx = 2;
		gbc_exceedDailyDoseCheckBox.gridy = 2;
		optionsPanel.add(exceedDailyDoseCheckBox, gbc_exceedDailyDoseCheckBox);
		
		JPanel tablePanel = new JPanel();
		contentPane.add(tablePanel, BorderLayout.CENTER);
		tablePanel.setLayout(new BorderLayout(0, 0));
		
		JPanel statusPanel = new JPanel();
		tablePanel.add(statusPanel, BorderLayout.SOUTH);
		statusPanel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel pPanel = new JPanel();
		statusPanel.add(pPanel);
		
		JLabel totalPrescriptionItemsLabel = new JLabel("Total Number of Prescription Items:");
		totalPrescriptionItemsLabel.setHorizontalTextPosition(SwingConstants.LEFT);
		pPanel.add(totalPrescriptionItemsLabel);
		totalPrescriptionItemsLabel.setHorizontalAlignment(SwingConstants.LEFT);
		totalPrescriptionItemsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		totalPrescriptionItemsField = new JTextField();
		pPanel.add(totalPrescriptionItemsField);
		totalPrescriptionItemsField.setHorizontalAlignment(SwingConstants.LEFT);
		totalPrescriptionItemsField.setColumns(10);

		updateTotalPrescriptionItemsField();
		
		JPanel cPanel = new JPanel();
		statusPanel.add(cPanel);
		
		JLabel totalNumberOfContainersLabel = new JLabel("Total Number of Containers:");
		totalNumberOfContainersLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
		totalNumberOfContainersLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		cPanel.add(totalNumberOfContainersLabel);
		
		totalNumberOfContainersField = new JTextField();
		cPanel.add(totalNumberOfContainersField);
		totalNumberOfContainersField.setColumns(10);
		
		totalNumberOfContainersField.setText(String.valueOf(prescription.getNumberOfContainers()));
		
		JScrollPane scrollPane = new JScrollPane();
		tablePanel.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		tableModel = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Product Name", "Duration", "Prescribed Daily Dose", "Number of Containers", "Over the Counter", "Comments"
			}
		);
		
		table.setModel(tableModel);
		scrollPane.setViewportView(table);
		
		// Aligning table columns
		// Right alignment
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
		
		// Left alignment
		DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
		leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);
		
		// Product Name
		table.getColumnModel().getColumn(0).setCellRenderer(leftRenderer);
		// Duration
		table.getColumnModel().getColumn(1).setCellRenderer(rightRenderer);
		// Prescribed Daily Dose
		table.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
		// Number of Containers
		table.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
		// Over the Counter
		table.getColumnModel().getColumn(4).setCellRenderer(leftRenderer);
		// Comments
		table.getColumnModel().getColumn(5).setCellRenderer(leftRenderer);
		
		// Centre align table headers
		((DefaultTableCellRenderer)table.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel buttonPanel = new JPanel();
		contentPane.add(buttonPanel, BorderLayout.EAST);
		buttonPanel.setLayout(new BorderLayout(0, 0));
		
		exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		buttonPanel.add(exitButton, BorderLayout.SOUTH);
		
		JPanel prescriptionPanel = new JPanel();
		buttonPanel.add(prescriptionPanel, BorderLayout.NORTH);
		prescriptionPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton clearButton = new JButton("Clear");
		prescriptionPanel.add(clearButton);
		clearButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				prescription.clearPrescription();
				updateTable();
			}
		});
		
		JButton removeButton = new JButton("Remove");
		prescriptionPanel.add(removeButton);
		removeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {	
				prescription.removePrescriptionItem((String) pharmaceuticalNameComboBox.getSelectedItem());
				updateTable();
			}
		});
	}
	
	public void updateTable() {
		ArrayList<PrescriptionItem> prescriptionItems = prescription.getPrescriptionItems();
		// Clear current contents of table
		tableModel.setRowCount(0);
		// Insert updated version of prescriptionItems
		for (int i = 0; i < prescriptionItems.size(); i++) {
			Object[] data = {prescriptionItems.get(i).getPharmaceuticalName(),
							 prescriptionItems.get(i).getDuration(),
							 prescriptionItems.get(i).getPrescribedDailyDose(),
							 prescriptionItems.get(i).getNumberOfContainers(),
							 prescriptionItems.get(i).isCounterAvailability(),
							 prescriptionItems.get(i).getComments()
			};
			tableModel.addRow(data);
		}
		
		updateTotalPrescriptionItemsField();
	}
	
	public void updateTotalPrescriptionItemsField() {
		totalPrescriptionItemsField.setText(String.valueOf(prescription.getNumberOfPrescriptionItems()));
	}
}
	

package GUI;

import comp_decomp.compressor;
import comp_decomp.decompressor;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class AppFrame extends JFrame implements ActionListener {
    private JButton compressButton;
    private JButton decompressButton;
    private JPanel mainPanel;
    private JLabel titleLabel;
    private JLabel subtitleLabel;

    public AppFrame() {
        initializeComponents();
        setupLayout();
        setupStyling();
        this.setVisible(true);
    }

    private void initializeComponents() {
        // Initialize components
        titleLabel = new JLabel("File Compressor", SwingConstants.CENTER);
        subtitleLabel = new JLabel("Choose an option to compress or decompress your files", SwingConstants.CENTER);
        compressButton = new JButton("Compress File");
        decompressButton = new JButton("Decompress File");
        mainPanel = new JPanel();

        // Set window properties
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("File Compressor Tool");
        this.setSize(600, 400);
        this.setLocationRelativeTo(null); // Center the window
        this.setResizable(false);
    }

    private void setupLayout() {
        // Main panel with BorderLayout
        mainPanel.setLayout(new BorderLayout(20, 20));
        mainPanel.setBorder(new EmptyBorder(30, 40, 30, 40));

        // Header panel
        JPanel headerPanel = new JPanel(new GridLayout(2, 1, 10, 10));
        headerPanel.add(titleLabel);
        headerPanel.add(subtitleLabel);
        headerPanel.setOpaque(false);

        // Button panel
        JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 15, 15));
        buttonPanel.setBorder(new EmptyBorder(20, 50, 20, 50));
        buttonPanel.add(compressButton);
        buttonPanel.add(decompressButton);
        buttonPanel.setOpaque(false);

        // Add panels to main panel
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        // Add main panel to frame
        this.add(mainPanel);
    }

    private void setupStyling() {
        // Color scheme
        Color primaryColor = new Color(41, 128, 185);      // Blue
        Color secondaryColor = new Color(52, 152, 219);    // Lighter Blue
        Color backgroundColor = new Color(236, 240, 241);  // Light Gray
        Color textColor = new Color(44, 62, 80);           // Dark Gray
        Color buttonTextColor = Color.BLACK;

        // Set background
        mainPanel.setBackground(backgroundColor);
        this.getContentPane().setBackground(backgroundColor);

        // Style title label
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setForeground(primaryColor);

        // Style subtitle label
        subtitleLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        subtitleLabel.setForeground(textColor);

        // Style compress button
        compressButton.setFont(new Font("Arial", Font.BOLD, 16));
        compressButton.setBackground(primaryColor);
        compressButton.setForeground(buttonTextColor);
        compressButton.setFocusPainted(false);
        compressButton.setBorderPainted(false);
        compressButton.setPreferredSize(new Dimension(300, 50));
        compressButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Style decompress button
        decompressButton.setFont(new Font("Arial", Font.BOLD, 16));
        decompressButton.setBackground(secondaryColor);
        decompressButton.setForeground(buttonTextColor);
        decompressButton.setFocusPainted(false);
        decompressButton.setBorderPainted(false);
        decompressButton.setPreferredSize(new Dimension(300, 50));
        decompressButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        compressButton.setOpaque(true);
        decompressButton.setOpaque(true);


        // Add hover effects
        addHoverEffect(compressButton, primaryColor, new Color(31, 97, 141));
        addHoverEffect(decompressButton, secondaryColor, new Color(41, 128, 185));

        // Add action listeners
        compressButton.addActionListener(this);
        decompressButton.addActionListener(this);
    }

    private void addHoverEffect(JButton button, Color normalColor, Color hoverColor) {
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(hoverColor);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(normalColor);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        if (e.getSource() == compressButton) {
            fileChooser.setDialogTitle("Select File to Compress");
            int response = fileChooser.showOpenDialog(this);

            if (response == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                System.out.println("Compressing: " + file.getAbsolutePath());

                try {
                    compressor.method(file);
                    showSuccessMessage("File compressed successfully!");
                } catch (Exception ex) {
                    showErrorMessage("Compression failed: " + ex.getMessage());
                }
            }
        }

        if (e.getSource() == decompressButton) {
            fileChooser.setDialogTitle("Select File to Decompress");
            int response = fileChooser.showOpenDialog(this);

            if (response == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                System.out.println("Decompressing: " + file.getAbsolutePath());

                try {
                    decompressor.method(file);
                    showSuccessMessage("File decompressed successfully!");
                } catch (Exception ex) {
                    showErrorMessage("Decompression failed: " + ex.getMessage());
                }
            }
        }
    }

    private void showSuccessMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    private void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame implements ActionListener {

    JButton copyButton;
    JTextField passwordField;
    JSlider slider;
    JLabel mainLabel;

    JCheckBox lowerCharCheckBox;
    JCheckBox upperCharCheckBox;
    JCheckBox digitCharCheckBox;
    JCheckBox specialCharCheckBox;

    JLabel lowerCharLabel;
    JLabel upperCharLabel;
    JLabel digitCharLabel;
    JLabel specialCharLabel;
    JLabel sliderLabel;

    private boolean isLowerChar = true;
    private boolean isUpperChar = false;
    private boolean isDigitChar = false;
    private boolean isSpecialChar = false;

    public MainFrame() {

        passwordField = new JTextField();
        passwordField.setBounds(100, 200, 350, 40);
        passwordField.setEditable(false);
        passwordField.setFocusable(false);
        passwordField.setHorizontalAlignment(SwingConstants.CENTER);

        copyButton = new JButton();
        copyButton.setBounds(500, 200, 120, 40);
        copyButton.setFocusable(false);
        copyButton.setText("Copy to clipboard");
        copyButton.setFont(new Font(null, Font.BOLD, 10));
        copyButton.addActionListener(this);

        lowerCharCheckBox = new JCheckBox();
        lowerCharCheckBox.setBounds(100, 100, 30, 40);
        lowerCharCheckBox.setFocusable(false);
        lowerCharCheckBox.addActionListener(this);
        lowerCharCheckBox.setSelected(true);

        upperCharCheckBox = new JCheckBox();
        upperCharCheckBox.setBounds(100, 150, 30, 40);
        upperCharCheckBox.setFocusable(false);
        upperCharCheckBox.addActionListener(this);

        digitCharCheckBox = new JCheckBox();
        digitCharCheckBox.setBounds(300, 100, 30, 40);
        digitCharCheckBox.setFocusable(false);
        digitCharCheckBox.addActionListener(this);

        specialCharCheckBox = new JCheckBox();
        specialCharCheckBox.setBounds(300, 150, 30, 40);
        specialCharCheckBox.setFocusable(false);
        specialCharCheckBox.addActionListener(this);

        lowerCharLabel = new JLabel("Lower Letters");
        lowerCharLabel.setBounds(130, 100, 100, 40);

        upperCharLabel = new JLabel("Upper Letters");
        upperCharLabel.setBounds(130, 150, 100, 40);

        digitCharLabel = new JLabel("Digits");
        digitCharLabel.setBounds(330, 100, 100, 40);

        specialCharLabel = new JLabel("Special Characters");
        specialCharLabel.setBounds(330, 150, 120, 40);

        slider = new JSlider(0,30,10);
        slider.setBounds(100, 250, 350, 40);
        slider.setPaintTicks(true);
        slider.setMinorTickSpacing(1);
        slider.setPaintTrack(true);
        slider.setMajorTickSpacing(10);
        slider.setSnapToTicks(true);
        slider.setPaintLabels(true);
        slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                sliderLabel.setText(String.valueOf(slider.getValue()));

                PasswordGenerator passwordGenerator = new PasswordGenerator();
                passwordField.setText(passwordGenerator.generatePassword(isLowerChar,isUpperChar,isDigitChar,isSpecialChar,slider.getValue()));

            }
        });

        sliderLabel = new JLabel(String.valueOf(slider.getValue()));
        sliderLabel.setBounds(500, 250, 100, 40);
        sliderLabel.setFont(new Font(null, Font.BOLD, 20));

        mainLabel = new JLabel("PASSWORD GENERATOR");
        mainLabel.setBounds(100, 50, 600, 40);
        mainLabel.setFont(new Font("Apple Casual",Font.BOLD,30));
        mainLabel.setHorizontalTextPosition(SwingConstants.CENTER);


        this.add(copyButton);
        this.add(passwordField);
        this.add(lowerCharCheckBox);
        this.add(upperCharCheckBox);
        this.add(digitCharCheckBox);
        this.add(specialCharCheckBox);
        this.add(lowerCharLabel);
        this.add(upperCharLabel);
        this.add(digitCharLabel);
        this.add(specialCharLabel);
        this.add(slider);
        this.add(sliderLabel);
        this.add(mainLabel);


        this.setTitle("Password Generator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(700,500);
        this.setLayout(null);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == lowerCharCheckBox) {
            isLowerChar = lowerCharCheckBox.isSelected();
        }

        if(e.getSource() == upperCharCheckBox) {
            isUpperChar = upperCharCheckBox.isSelected();
        }

        if(e.getSource() == digitCharCheckBox) {
            isDigitChar = digitCharCheckBox.isSelected();
        }

        if(e.getSource() == specialCharCheckBox) {
            isSpecialChar = specialCharCheckBox.isSelected();
        }
        if(e.getSource() == copyButton) {
            StringSelection stringSelection = new StringSelection(passwordField.getText());
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);
        }
    }
}

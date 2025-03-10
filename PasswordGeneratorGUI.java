import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordGeneratorGUI extends JFrame {
    private PasswordGenerator passwordGenerator;
    public PasswordGeneratorGUI(){
        super("Password Generator");
        setSize(540,570);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        passwordGenerator =new PasswordGenerator();
        addGUIComponents();
    }
    private void addGUIComponents(){
        addTitleLabel();

        JTextArea passwordOutput = getPasswordOutput();
        addPasswordLengthLabel();

        JTextArea passwordLengthInputArea = getPasswordLengthInputArea();


        JToggleButton uppercaseToggle = getUppercaseToggle("Upper Case", 25, 302);


        JToggleButton lowercaseToggle = getUppercaseToggle("Lower Case", 282, 302);

        JToggleButton numbersToggle = getUppercaseToggle("Numbers", 25, 373);

        JToggleButton symbolsToggle = getUppercaseToggle("Symbols", 282, 373);

        addGenerateButton(passwordLengthInputArea, lowercaseToggle, uppercaseToggle, numbersToggle, symbolsToggle, passwordOutput);
    }

    private void addGenerateButton(JTextArea passwordLengthInputArea, JToggleButton lowercaseToggle, JToggleButton uppercaseToggle, JToggleButton numbersToggle, JToggleButton symbolsToggle, JTextArea passwordOutput) {
        JButton generateButton = new JButton("Generate");
        generateButton.setFont(new Font("Dialog", Font.PLAIN, 32));
        generateButton.setBounds(155, 477, 222, 41);
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(passwordLengthInputArea.getText().length() <= 0) return;
                boolean anyToggleSelected = lowercaseToggle.isSelected() || uppercaseToggle.isSelected() || numbersToggle.isSelected() || symbolsToggle.isSelected();
                int passwordLength = Integer.parseInt(passwordLengthInputArea.getText());
                if(anyToggleSelected){
                    String generatedPassword = passwordGenerator.generatePassword(passwordLength, uppercaseToggle.isSelected(), lowercaseToggle.isSelected(), numbersToggle.isSelected(), symbolsToggle.isSelected());
                    passwordOutput.setText(generatedPassword);
                }
            }
        });
        add(generateButton);
    }

    private JToggleButton getUppercaseToggle(String Upper_Case, int x, int y) {
        JToggleButton uppercaseToggle = new JToggleButton(Upper_Case);
        uppercaseToggle.setBounds(x, y, 225, 56);
        uppercaseToggle.setFont(new Font("Dialog", Font.PLAIN, 26));
        add(uppercaseToggle);
        return uppercaseToggle;
    }

    private JTextArea getPasswordLengthInputArea() {
        JTextArea passwordLengthInputArea = new JTextArea();
        passwordLengthInputArea.setFont(new Font("Dialog", Font.PLAIN, 25));
        passwordLengthInputArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        passwordLengthInputArea.setBounds(310, 220, 192, 30);
        add(passwordLengthInputArea);
        return passwordLengthInputArea;
    }

    private void addPasswordLengthLabel() {
        JLabel passwordLengthLabel = new JLabel("Password Length: ");
        passwordLengthLabel.setFont(new Font("Dialog", Font.PLAIN, 32));
        passwordLengthLabel.setBounds(25, 215, 272,39);
        add(passwordLengthLabel);
    }

    private JTextArea getPasswordOutput() {
        JTextArea passwordOutput =new JTextArea();
        passwordOutput.setEditable(false);
        passwordOutput.setFont(new Font("Dialog", Font.BOLD, 32));
        JScrollPane passwordOutputPane = new JScrollPane(passwordOutput);
        passwordOutputPane.setBounds(25,97,479,70);
        passwordOutputPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(passwordOutputPane);
        return passwordOutput;
    }

    private void addTitleLabel() {
        JLabel titleLabel = new JLabel("Password Generator");
        titleLabel.setFont(new Font("Dialog", Font.BOLD, 32));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(0,10,540,39);
        add(titleLabel);
    }
}

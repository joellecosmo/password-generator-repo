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
        JLabel titleLabel = new JLabel("Password Generator");
        titleLabel.setFont(new Font("Dialog", Font.BOLD, 32));
        //todo: look up how icons are set
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(0,10,540,39);
        add(titleLabel);

        JTextArea passwordOutput =new JTextArea();
        passwordOutput.setEditable(false);
        passwordOutput.setFont(new Font("Dialog", Font.BOLD, 32));
        JScrollPane passwordOutputPane = new JScrollPane(passwordOutput);
        passwordOutputPane.setBounds(25,97,479,70);
        passwordOutputPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(passwordOutputPane);
        JLabel passwordLengthLabel = new JLabel("Password Length: ");
        passwordLengthLabel.setFont(new Font("Dialog", Font.PLAIN, 32));
        passwordLengthLabel.setBounds(25, 215, 272,39);
        add(passwordLengthLabel);

        JTextArea passwordLengthInputArea = new JTextArea();
        passwordLengthInputArea.setFont(new Font("Dialog", Font.PLAIN, 25));
        passwordLengthInputArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        passwordLengthInputArea.setBounds(310, 220, 192, 30);
        add(passwordLengthInputArea);


        JToggleButton uppercaseToggle = new JToggleButton("Upper Case");
        uppercaseToggle.setBounds(25,302,225,56);
        uppercaseToggle.setFont(new Font("Dialog", Font.PLAIN, 26));
        add(uppercaseToggle);


        JToggleButton lowercaseToggle = new JToggleButton("Lower Case");
        lowercaseToggle.setBounds(282,302,225,56);
        lowercaseToggle.setFont(new Font("Dialog", Font.PLAIN, 26));
        add(lowercaseToggle);

        JToggleButton numbersToggle = new JToggleButton("Numbers");
        numbersToggle.setBounds(25, 373,225,56);
        numbersToggle.setFont(new Font("Dialog", Font.PLAIN, 26));
        add(numbersToggle);

        JToggleButton symbolsToggle = new JToggleButton("Symbols");
        symbolsToggle.setBounds(282,373,225,56);
        symbolsToggle.setFont(new Font("Dialog", Font.PLAIN, 26));
        add(symbolsToggle);

        JButton generateButton = new JButton("Generate");
        generateButton.setFont(new Font("Dialog", Font.PLAIN, 32));
        generateButton.setBounds(155, 477, 222, 41);
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(passwordLengthInputArea.getText().length() <= 0) return;
                boolean anyToggleSelected = lowercaseToggle.isSelected() || uppercaseToggle.isSelected() || numbersToggle.isSelected() ||symbolsToggle.isSelected();
                int passwordLength = Integer.parseInt(passwordLengthInputArea.getText());
                if(anyToggleSelected){
                    String generatedPassword = passwordGenerator.generatePassword(passwordLength, uppercaseToggle.isSelected(), lowercaseToggle.isSelected(), numbersToggle.isSelected(), symbolsToggle.isSelected());
                    passwordOutput.setText(generatedPassword);
                }
            }
        });
        add(generateButton);
    }
}

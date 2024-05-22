package pack1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

    public Main() {
        setTitle("HAN SCHOOL");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null); 
        getContentPane().setLayout(new BorderLayout());

        
        JLabel titleLabel = new JLabel("HAN SCHOOL");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setForeground(new Color(0, 102, 204));

        
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BorderLayout());
        titlePanel.add(Box.createVerticalStrut(20), BorderLayout.NORTH); 
        titlePanel.add(titleLabel, BorderLayout.CENTER);
        getContentPane().add(titlePanel, BorderLayout.NORTH);


        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(new Color(240, 240, 240)); 
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

      
        JButton formButton = new JButton("Click Here");
        formButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        formButton.setFont(new Font("Arial", Font.PLAIN, 18));
        formButton.setForeground(Color.WHITE);
        formButton.setBackground(new Color(0, 102, 204)); 
        formButton.setFocusPainted(false);
        formButton.setBorderPainted(false);
        formButton.setOpaque(true);
        formButton.setPreferredSize(new Dimension(150, 40));
        formButton.addActionListener((ActionEvent e) -> {
            openStudentForm();
        });

       
        centerPanel.add(Box.createVerticalStrut(50));
        centerPanel.add(formButton);

        getContentPane().add(centerPanel, BorderLayout.CENTER);
    }

    private void openStudentForm() {
        EventQueue.invokeLater(() -> {
            try {
                StudentForm studentForm = new StudentForm();
                studentForm.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Main frame = new Main();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}

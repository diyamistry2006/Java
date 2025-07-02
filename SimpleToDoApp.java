import javax.swing.*;
import java.awt.event.*;

public class SimpleToDoApp {
    public static void main(String[] args) {
        // Create frame
        JFrame frame = new JFrame("To-Do List");
        frame.setSize(300, 400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Text field for task input
        JTextField taskField = new JTextField();
        taskField.setBounds(20, 20, 160, 30);
        frame.add(taskField);

        // Add button
        JButton addButton = new JButton("Add");
        addButton.setBounds(190, 20, 80, 30);
        frame.add(addButton);

        // List to display tasks
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> taskList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(taskList);
        scrollPane.setBounds(20, 60, 250, 250);
        frame.add(scrollPane);

        // Delete button
        JButton deleteButton = new JButton("Delete");
        deleteButton.setBounds(100, 320, 100, 30);
        frame.add(deleteButton);

        // Add task
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String task = taskField.getText();
                if (!task.isEmpty()) {
                    listModel.addElement(task);
                    taskField.setText("");
                }
            }
        });

        // Delete selected task
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selected = taskList.getSelectedIndex();
                if (selected != -1) {
                    listModel.remove(selected);
                }
            }
        });

        // Show frame
        frame.setVisible(true);
    }
}
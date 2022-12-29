package ru.cs.vsu.task_9_17;

import ru.cs.vsu.tools.Utils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class TableFormTask9 extends JFrame {

    private JTable table1;
    private JPanel panel1;
    private JButton outputSubmitButton;
    private JTextField outputPathTF;
    private JLabel outputLabel;
    private JLabel inputLabel;
    private JButton inputSubmitButton;
    private JPanel mainPanel;
    private JTextField inputPathTF;
    private JTable table;
    private JLabel statusLabel;
    private JButton addRowButton;
    private JButton addColumnButton;
    private JButton checkButton;
    private JButton removeRowButton;
    private JButton removeColumnButton;
    private JTextField index1TextField;
    private JTextField index2TextField;

    public TableFormTask9() throws HeadlessException {
        setContentPane(mainPanel);
        setTitle("Table");
        setSize(650, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        inputSubmitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // clear status
                statusLabel.setText("");
                // try to read file
                int[][] matrix;
                try {
                    String path = inputPathTF.getText();
                    matrix = Utils.readIntMatrixFromFile(path);
                } catch (IOException e) {
                    statusLabel.setText("Ошибка чтения!");
                    return;
                }
                // file data check
                if (matrix.length == 0) {
                    statusLabel.setText("Файл пуст!");
                    return;
                }

                // sizes
                int rows = matrix.length;
                int cols = matrix[0].length;

                // prepare table
                DefaultTableModel dtm = (DefaultTableModel) table.getModel();
                dtm.setRowCount(rows);
                dtm.setColumnCount(cols);

                // write in table
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        dtm.setValueAt(matrix[i][j], i, j);
                    }
                }

                table.setModel(dtm);
                index2TextField.setText(Integer.toString(cols - 1));
                statusLabel.setText("Успешно импотрирован!");
            }
        });
        outputSubmitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // clear status
                statusLabel.setText("");

                String path = outputPathTF.getText();

                int[][] matrix = Utils.getMatrixFromTable(table);

                // write to file
                try {
                    Utils.writeIntMatrixToFile(path, matrix);
                } catch (IOException e) {
                    e.printStackTrace();
                    statusLabel.setText("Ошибка сохранения!");
                }
                statusLabel.setText("Успешно сохранен!");
            }
        });
        addRowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                DefaultTableModel dtm = (DefaultTableModel) table.getModel();
                dtm.setRowCount(dtm.getRowCount() + 1);
                table.setModel(dtm);
            }
        });
        removeRowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                DefaultTableModel dtm = (DefaultTableModel) table.getModel();
                if (dtm.getRowCount() == 0) return;
                dtm.setRowCount(dtm.getRowCount() - 1);
                table.setModel(dtm);
            }
        });
        addColumnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                DefaultTableModel dtm = (DefaultTableModel) table.getModel();
                dtm.setColumnCount(dtm.getColumnCount() + 1);
                table.setModel(dtm);
            }
        });
        removeColumnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                DefaultTableModel dtm = (DefaultTableModel) table.getModel();
                if (dtm.getColumnCount() == 0) return;
                dtm.setColumnCount(dtm.getColumnCount() - 1);
                table.setModel(dtm);
            }
        });
        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int index1 = Integer.parseInt(index1TextField.getText());
                int index2 = Integer.parseInt(index2TextField.getText());

                int[][] matrix = Utils.getMatrixFromTable(table);
                List<List<Integer>> listMatrix = Utils.getListMatrixFromArrayMatrix(matrix);
                for (List<Integer> integers : listMatrix) {
                    Main.sort(integers, index1, index2);
                }
                Utils.setMatrixToTable(table, listMatrix);
            }
        });
    }

    public static void main(String[] args) {
        TableFormTask9 formTask9 = new TableFormTask9();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        DefaultTableModel dtm = new DefaultTableModel(3, 5);
        dtm.setColumnCount(5);
        dtm.setRowCount(1);
        table = new JTable(dtm);
    }
}

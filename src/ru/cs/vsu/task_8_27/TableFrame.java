package ru.cs.vsu.task_8_27;

import ru.cs.vsu.tools.Utils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class TableFrame extends JFrame {
    private JTextField inputPathTF;
    private JButton inputSubmitButton;
    private JLabel inputLabel;
    private JButton outputSubmitButton;
    private JTextField outputPathTF;
    private JLabel outputLabel;
    private JTable table;
    private JPanel mainPanel;
    private JLabel statusLabel;
    private JButton addRowButton;
    private JButton removeRowButton;
    private JButton removeColumnButton;
    private JButton addColumnButton;
    private JButton checkButton;

    public TableFrame() {
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
                } catch (IOException e){
                    statusLabel.setText("Ошибка чтения!");
                    return;
                }
                // file data check
                if (matrix.length == 0){
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
                statusLabel.setText("Успешно импотрирован!");
            }
        });
        outputSubmitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // clear status
                statusLabel.setText("");

                String path = outputPathTF.getText();

                int [][] matrix = Utils.getMatrixFromTable(table);

                // write to file
                try{
                    Utils.writeIntMatrixToFile(path, matrix);
                }catch (IOException e){
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
                int [][] matrix = Utils.getMatrixFromTable(table);
                boolean checkResult =  Main.isMatrixCorrect(matrix);
                statusLabel.setText(checkResult ? "Значения упорядочены" : "Значегия не упорядочены");
            }
        });
    }

    public static void main(String[] args) {
        TableFrame tableFrame = new TableFrame();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        DefaultTableModel dtm = new DefaultTableModel(3, 5);
        dtm.setColumnCount(5);
        dtm.setRowCount(3);
        table = new JTable(dtm);
    }
}

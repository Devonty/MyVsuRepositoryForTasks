package ru.cs.vsu.task_10_18;

import ru.cs.vsu.tools.Utils;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;

public class TableOfPointsFrame extends JFrame {
    private JTextField inputPathTF;
    private JPanel mainPanel;
    private JButton inputSubmitButton;
    private JLabel inputLabel;
    private JLabel outputLabel;
    private JTextField outputPathTF;
    private JButton outputSubmitButton;
    private JTable table;
    private JLabel statusLabel;
    private JButton checkButton;
    private JButton addRowButton;
    private JButton removeRowButton;

    public TableOfPointsFrame() throws HeadlessException {
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
                    e.printStackTrace();
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

                addStatusColumn(table);
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
        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // get int[][] matrix
                DefaultTableModel dtm = (DefaultTableModel) table.getModel();
                dtm.setColumnCount(dtm.getColumnCount() - 1); // without "Status" column
                JTable shortTable = new JTable(dtm);
                int[][] matrix = Utils.getMatrixFromTable(shortTable);

                addStatusColumn(table);
                // check
                System.out.println();
                for (int i = 0; i < matrix.length; i++) {
                    Point a, b, c;
                    System.out.println(Arrays.toString(matrix[i]));
                    a = new Point(matrix[i][0], matrix[i][1]);
                    b = new Point(matrix[i][2], matrix[i][3]);
                    c = new Point(matrix[i][4], matrix[i][5]);

                    Triangle triangle = new Triangle(a,b,c);
                    boolean status = TriangleThings.checkTriangle(triangle);
                    System.out.println(status);
                    dtm.setValueAt(status ? "Верно" : "Неверно", i, 6);
                }
                table.setModel(dtm);

            }
        });
    }

    public static void addStatusColumn(JTable table){
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        // add "Status" column
        dtm.setColumnCount(dtm.getColumnCount() + 1);
        table.setModel(dtm);
        JTableHeader th = table.getTableHeader();
        TableColumnModel tcm = th.getColumnModel();
        TableColumn tc = tcm.getColumn(dtm.getColumnCount() - 1);
        tc.setHeaderValue( "Status" );
        th.repaint();
    }

    public static void main(String[] args) {
        TableOfPointsFrame tableFrame = new TableOfPointsFrame();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        String[] column_names = {"x1", "y1", "x2", "y2", "x3", "y3", "Status"};
        Object[][] data = {
                {0, 0, 0, 5, 5, 0, ""}
        };
        DefaultTableModel dtm = new DefaultTableModel(data, column_names);
        table = new JTable(dtm);
    }
}

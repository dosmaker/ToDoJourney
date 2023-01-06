import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.io.File;
import java.io.FileInputStream;
import org.jfree.chart.*;
import org.jfree.data.xy.*;

public class thirdFrame extends JFrame{
    static private ToDoList list =  null;
    private ChartPanel panel = null;
    private int monthLenght;
    private File openedFile;

    public thirdFrame(File openedFile){
        super("To Do Journey");
        this.openedFile = openedFile;
        try {
            LocalDate currentDate = LocalDate.now();
            if(openedFile == null){
                FileInputStream fis = new FileInputStream(currentDate.getMonth()+""+currentDate.getYear()+".TDGraph");
                ObjectInputStream ois = new ObjectInputStream(fis);
                list = (ToDoList) ois.readObject();
                ois.close();
                fis.close();
            }else{
                FileInputStream fis = new FileInputStream(openedFile);
                ObjectInputStream ois = new ObjectInputStream(fis);
                list = (ToDoList) ois.readObject();
                ois.close();
                fis.close();
            }

            switch(currentDate.getMonth()){
                case JANUARY, MARCH, MAY, JULY, AUGUST, OCTOBER, DECEMBER:
                    monthLenght = 31;
                break;
                case FEBRUARY:
                    if(currentDate.isLeapYear()){ monthLenght = 29; }else{ monthLenght = 28; }
                break;
                default:
                    monthLenght = 30;
                break;
            }

            JPanel panel1 = null;
            switch(monthLenght){
                case 28:
                    panel1 = new JPanel(new GridLayout(4,7));
                break;
                default:
                    panel1 = new JPanel(new GridLayout(5,7));
                break;
            }

            int n = list.getThingsNumber();
            JCheckBox[][] check = new JCheckBox[monthLenght][n];
            ActionListener listener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Object source = e.getSource();
                    for (int i = 0; i < list.getThingsNumber(); i++) {
                        for (int j = 0; j < monthLenght; j++) {
                            if (source == check[j][i]) {
                                if(check[j][i].isSelected()){ list.trueBool(i+1, j); }else{ list.falseBool(i+1, j); }
                                updateGraph();
                            }
                        }
                    }
                }
            };

            JPanel[] panelDay = new JPanel[monthLenght];
            for(int i = 0; i < monthLenght; i++){
                panelDay[i] = new JPanel(new BorderLayout());
                panelDay[i].add(new JLabel("Day "+(i+1)), BorderLayout.NORTH);

                JPanel panelDay2 = new JPanel(new GridLayout(n,1,0,1));
                for(int j = 0; j < n; j++){
                    check[i][j] = new JCheckBox();
                    check[i][j].addActionListener(listener);

                    if(list.getBool(j+1, i)){ check[i][j].setSelected(true); }

                    JPanel panelDay3 = new JPanel(new BorderLayout());
                    JLabel label = new JLabel(list.getThing(j));
                    label.setFont(new Font("Calibri",Font.PLAIN,12));
                    check[i][j].setSize(new Dimension(0,0));

                    panelDay3.add(check[i][j], BorderLayout.WEST); panelDay3.add(label);
                    panelDay2.add(panelDay3);
                }
                panelDay[i].add(panelDay2);
                panel1.add(panelDay[i]);
            }

            graph();

            this.add(panel1); this.add(panel);
            this.setLayout(new GridLayout(2,1));
		    this.addWindowListener(new WindowManager());
		    this.setSize(1000,800); this.setVisible(true);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Register your To-Do-List first!", "Error", JOptionPane.ERROR_MESSAGE);
            firstFrame frame1 = new firstFrame();
            frame1.setLocationRelativeTo(null);
            this.setVisible(false); this.dispose(); System.gc();
        }
    }

    private void graph(){
        int[] array = list.getArrayTot(); LocalDate currentDate = LocalDate.now();
        // Create a dataset
        XYSeries series = new XYSeries("Data");
        for (int i = 0; i < currentDate.getDayOfMonth(); i++) {
            series.add(i+1, array[i]);
        }
        XYDataset dataset = new XYSeriesCollection(series);

        // Create a chart
        JFreeChart chart = ChartFactory.createXYLineChart(list.getName()+"'s' To-Do-Graph", "Days", "Things done", dataset);

        // Create a panel to display the chart
        panel = new ChartPanel(chart);
    }

    private void updateGraph(){
        thirdFrame frame = new thirdFrame(openedFile);
        frame.setLocationRelativeTo(null);
        this.setVisible(false); this.dispose(); System.gc();
    }
}
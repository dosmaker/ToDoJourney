import javax.swing.*;
import java.awt.*;


public class secondFrame extends JFrame{
    static private int x = 0;
    static private ToDoList list = null;
    private JButton addThings = null;
    private JTextField name = new JTextField();
    private JTextField thing1 = new JTextField();
    private JTextField thing2 = new JTextField();
    private JTextField thing3 = new JTextField();
    private JTextField thing4 = new JTextField();
    private JTextField thing5 = new JTextField();

    public secondFrame(){
        super("ToDoInit");
        this.setLayout(new GridLayout(3+x,1));

        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        panel1.add(new JLabel("Name: "), BorderLayout.NORTH); panel1.add(name);
        this.add(panel1);

        if(x > 0){
            switch(x){
                case 1:
                    JPanel panel2 = new JPanel();
                    panel2.setLayout(new BorderLayout());
                    panel2.add(new JLabel("Thing 1: "), BorderLayout.NORTH); panel2.add(thing1);
                    this.add(panel2);

                    btn();
                break;

                case 2:
                    JPanel panel3 = new JPanel();
                    panel3.setLayout(new BorderLayout());
                    panel3.add(new JLabel("Thing 1: "), BorderLayout.NORTH); panel3.add(thing1);
                    this.add(panel3);
                    JPanel panel4 = new JPanel();
                    panel4.setLayout(new BorderLayout());
                    panel4.add(new JLabel("Thing 2: "), BorderLayout.NORTH); panel4.add(thing2);
                    this.add(panel4);

                    btn();
                break;

                case 3:
                    JPanel panel5 = new JPanel();
                    panel5.setLayout(new BorderLayout());
                    panel5.add(new JLabel("Thing 1: "), BorderLayout.NORTH); panel5.add(thing1);
                    this.add(panel5);
                    JPanel panel6 = new JPanel();
                    panel6.setLayout(new BorderLayout());
                    panel6.add(new JLabel("Thing 2: "), BorderLayout.NORTH); panel6.add(thing2);
                    this.add(panel6);
                    JPanel panel7 = new JPanel();
                    panel7.setLayout(new BorderLayout());
                    panel7.add(new JLabel("Thing 3: "), BorderLayout.NORTH); panel7.add(thing3);
                    this.add(panel7);

                    btn();
                break;

                case 4:
                    JPanel panel8 = new JPanel();
                    panel8.setLayout(new BorderLayout());
                    panel8.add(new JLabel("Thing 1: "), BorderLayout.NORTH); panel8.add(thing1);
                    this.add(panel8);
                    JPanel panel9 = new JPanel();
                    panel9.setLayout(new BorderLayout());
                    panel9.add(new JLabel("Thing 2: "), BorderLayout.NORTH); panel9.add(thing2);
                    this.add(panel9);
                    JPanel panel10 = new JPanel();
                    panel10.setLayout(new BorderLayout());
                    panel10.add(new JLabel("Thing 3: "), BorderLayout.NORTH); panel10.add(thing3);
                    this.add(panel10);
                    JPanel panel11 = new JPanel();
                    panel11.setLayout(new BorderLayout());
                    panel11.add(new JLabel("Thing 4: "), BorderLayout.NORTH); panel11.add(thing4);
                    this.add(panel11);

                    btn();
                break;

                case 5:
                    JPanel panel12 = new JPanel();
                    panel12.setLayout(new BorderLayout());
                    panel12.add(new JLabel("Thing 1: "), BorderLayout.NORTH); panel12.add(thing1);
                    this.add(panel12);
                    JPanel panel13 = new JPanel();
                    panel13.setLayout(new BorderLayout());
                    panel13.add(new JLabel("Thing 2: "), BorderLayout.NORTH); panel13.add(thing2);
                    this.add(panel13);
                    JPanel panel14 = new JPanel();
                    panel14.setLayout(new BorderLayout());
                    panel14.add(new JLabel("Thing 3: "), BorderLayout.NORTH); panel14.add(thing3);
                    this.add(panel14);
                    JPanel panel15 = new JPanel();
                    panel15.setLayout(new BorderLayout());
                    panel15.add(new JLabel("Thing 4: "), BorderLayout.NORTH); panel15.add(thing4);
                    this.add(panel15);
                    JPanel panel16 = new JPanel();
                    panel16.setLayout(new BorderLayout());
                    panel16.add(new JLabel("Thing 5: "), BorderLayout.NORTH); panel16.add(thing5);
                    this.add(panel16);
                break;
            }
        }else{
            btn();
        }

        JButton insert = new JButton("Insert data");
        insert.addActionListener((e)->{
            if(x > 0){
                String nm = name.getText();
                if(nm.equals("")){
                    JOptionPane.showMessageDialog(null, "Insert all data!", "Error", JOptionPane.ERROR_MESSAGE);
                }else{
                    list = new ToDoList(nm);
                    switch(x){
                        case 1:
                            String t1 = thing1.getText();
                            if(t1.equals("")){
                                JOptionPane.showMessageDialog(null, "Insert all data!", "Error", JOptionPane.ERROR_MESSAGE);
                            }else{
                                list.insertToDo(t1);
                                end();
                            }
                        break;
                        case 2:
                            String t2 = thing1.getText();
                            if(t2.equals("")){
                                JOptionPane.showMessageDialog(null, "Insert all data!", "Error", JOptionPane.ERROR_MESSAGE);
                            }else{
                                list.insertToDo(t2);

                                String t3 = thing2.getText();
                                if(t3.equals("")){
                                    JOptionPane.showMessageDialog(null, "Insert all data!", "Error", JOptionPane.ERROR_MESSAGE);
                                }else{
                                    list.insertToDo(t3);
                                    end();
                                }
                            }
                        break;
                        case 3:
                            String t4 = thing1.getText();
                            if(t4.equals("")){
                                JOptionPane.showMessageDialog(null, "Insert all data!", "Error", JOptionPane.ERROR_MESSAGE);
                            }else{
                                list.insertToDo(t4);

                                String t5 = thing2.getText();
                                if(t5.equals("")){
                                    JOptionPane.showMessageDialog(null, "Insert all data!", "Error", JOptionPane.ERROR_MESSAGE);
                                }else{
                                    list.insertToDo(t5);

                                    String t6 = thing3.getText();
                                    if(t6.equals("")){
                                        JOptionPane.showMessageDialog(null, "Insert all data!", "Error", JOptionPane.ERROR_MESSAGE);
                                    }else{
                                        list.insertToDo(t6);
                                        end();
                                    }
                                }
                            }
                        break;
                        case 4:
                            String t7 = thing1.getText();
                            if(t7.equals("")){
                                JOptionPane.showMessageDialog(null, "Insert all data!", "Error", JOptionPane.ERROR_MESSAGE);
                            }else{
                                list.insertToDo(t7);

                                String t8 = thing2.getText();
                                if(t8.equals("")){
                                    JOptionPane.showMessageDialog(null, "Insert all data!", "Error", JOptionPane.ERROR_MESSAGE);
                                }else{
                                    list.insertToDo(t8);

                                    String t9 = thing3.getText();
                                    if(t9.equals("")){
                                        JOptionPane.showMessageDialog(null, "Insert all data!", "Error", JOptionPane.ERROR_MESSAGE);
                                    }else{
                                        list.insertToDo(t9);

                                        String t10 = thing4.getText();
                                        if(t10.equals("")){
                                            JOptionPane.showMessageDialog(null, "Insert all data!", "Error", JOptionPane.ERROR_MESSAGE);
                                        }else{
                                            list.insertToDo(t10);
                                            end();
                                        }
                                    }
                                }
                            }
                        break;
                        case 5:
                            String t11 = thing1.getText();
                            if(t11.equals("")){
                                JOptionPane.showMessageDialog(null, "Insert all data!", "Error", JOptionPane.ERROR_MESSAGE);
                            }else{
                                list.insertToDo(t11);

                                String t12 = thing2.getText();
                                if(t12.equals("")){
                                    JOptionPane.showMessageDialog(null, "Insert all data!", "Error", JOptionPane.ERROR_MESSAGE);
                                }else{
                                    list.insertToDo(t12);

                                    String t13 = thing3.getText();
                                    if(t13.equals("")){
                                        JOptionPane.showMessageDialog(null, "Insert all data!", "Error", JOptionPane.ERROR_MESSAGE);
                                    }else{
                                        list.insertToDo(t13);

                                        String t14 = thing4.getText();
                                        if(t14.equals("")){
                                            JOptionPane.showMessageDialog(null, "Insert all data!", "Error", JOptionPane.ERROR_MESSAGE);
                                        }else{
                                            list.insertToDo(t14);

                                            String t15 = thing5.getText();
                                            if(t15.equals("")){
                                                JOptionPane.showMessageDialog(null, "Insert all data!", "Error", JOptionPane.ERROR_MESSAGE);
                                            }else{
                                                list.insertToDo(t15);
                                                end();
                                            }
                                        }
                                    }
                                }
                            }
                        break;
                    }
                }
            }else{
                JOptionPane.showMessageDialog(null, "Insert one thing at least!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        JPanel panel2 = new JPanel(); panel2.setLayout(new FlowLayout()); panel2.add(insert);
        this.add(panel2);
        this.addWindowListener(new WindowManager());
        this.setSize(200,300); this.setVisible(true);
    }

    private void btn(){
        addThings = new JButton("+ Things");
        addThings.addActionListener((e)->{
            x++;
            secondFrame frame2 = new secondFrame();
            frame2.setLocationRelativeTo(null);
            this.setVisible(false); this.dispose(); System.gc();
        });
        JPanel panel = new JPanel(); panel.setLayout(new FlowLayout()); panel.add(addThings);
        this.add(panel);
    }

    private void end(){
        list.init();

        firstFrame frame3 = new firstFrame();
        frame3.setLocationRelativeTo(null);
        this.setVisible(false); this.dispose(); System.gc();
    }
}
import javax.swing.*;
import java.awt.*;
import java.io.File;

class firstFrame extends JFrame{
    public firstFrame(){
        super("ToDoJourney");

        JButton register = new JButton("Register");
        register.addActionListener((e)->{
            secondFrame frame1 = new secondFrame();
            frame1.setLocationRelativeTo(null);
            this.setVisible(false); this.dispose(); System.gc();
        });

        JButton access = new JButton("Access");
        access.addActionListener((e)->{
            thirdFrame frame1 = new thirdFrame(null);
            frame1.setLocationRelativeTo(null);
            this.setVisible(false); this.dispose(); System.gc();
        });

        JButton access2 = new JButton("Acces to a file 'TDGraph'");
        access2.addActionListener((e)->{
            JFileChooser fc = new JFileChooser();
            int returnVal = fc.showOpenDialog(null);
            File file = null;
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                file = fc.getSelectedFile();
            } else {
                System.exit(0);
            }
            thirdFrame frame1 = new thirdFrame(file);
            frame1.setLocationRelativeTo(null);
            this.setVisible(false); this.dispose(); System.gc();
        });

        this.setLayout(new FlowLayout());
		this.add(register); this.add(access); this.add(access2);
		this.addWindowListener(new WindowManager());
        this.setSize(200,100); this.setVisible(true);
    }
}
package it.unibo.mvc;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private final JFrame frame = new JFrame();
    private static final int PROPORTION = 5;
    Controller controller = new Controller();
    
    public SimpleGUIWithFileChooser(){
        final JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());

        /*UP*/
        final JPanel upPanel = new JPanel();
        upPanel.setLayout(new BoxLayout(upPanel, BoxLayout.LINE_AXIS));
        canvas.add(upPanel, BorderLayout.NORTH);
        final JTextField upTextArea = new JTextField(controller.getPathFile());
        upTextArea.setEditable(false);;
        upPanel.add(upTextArea);
        final JButton upBottom = new JButton("browse");
        upPanel.add(upBottom);
        /*Center */
        final JTextArea textArea = new JTextArea();
        canvas.add(textArea, BorderLayout.CENTER);
        /*Bottom*/
        final JButton save = new JButton("Save");
        canvas.add(save, BorderLayout.SOUTH);
        
        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        upBottom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                JFileChooser file = new JFileChooser(controller.getPathFile());
                int respond = file.showSaveDialog(frame);
                if(JFileChooser.APPROVE_OPTION == respond)
                {
                    controller.setFile(file.getSelectedFile());
                    upTextArea.setText(controller.getPathFile());
                }
                else if(!(JFileChooser.CANCEL_OPTION  == respond))
                {
                    JOptionPane.showMessageDialog(frame, "Error occurred");
                }
            }
            
        });

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                try{
                controller.write(textArea.getText());
                }catch(IOException e1){
                    JOptionPane.showMessageDialog(frame, e1, "Error", JOptionPane.ERROR_MESSAGE);
                    e1.printStackTrace(); // NOPMD: allowed as this is just an exercise
                }
            }
            
        });
    }

    private void display() {
        /*
         * Make the frame one fifth the resolution of the screen. This very method is
         * enough for a single screen setup. In case of multiple monitors, the
         * primary is selected. In order to deal coherently with multimonitor
         * setups, other facilities exist (see the Java documentation about this
         * issue). It is MUCH better than manually specify the size of a window
         * in pixel: it takes into account the current resolution.
         */
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        /*
         * Instead of appearing at (0,0), upper left corner of the screen, this
         * flag makes the OS window manager take care of the default positioning
         * on screen. Results may vary, but it is generally the best choice.
         */
        frame.setLocationByPlatform(true);
        /*
         * OK, ready to push the frame onscreen
         */
        frame.setVisible(true);
    }
    /**
     * Launches the application.
     *
     * @param args ignored
     */
    public static void main(final String... args) {
        new SimpleGUIWithFileChooser().display();
    }

}

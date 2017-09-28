package branham.joel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Random;
import javax.swing.*;

/**
 * JFrame in which the CircleCanvas resides. Also supports option menu.
 */
public class CircleFrame extends JFrame implements ActionListener{

    private CircleCanvas circleCanvas;

    private JMenuBar menuBar;
    private JMenu optionMenu;
    private JMenuItem drawNewCircles;
    private JMenuItem openJavaDoc;
    private JMenuItem openJacocoTestReport;

    /**
     * Menu and its associated items are initialized, given ActionListeners, and added to the JFrame. CircleCanvas is added to the frame as well.
     * @param circleCanvas CircleCanvas object provided so "Draw New Circles" menu item can call resetCircles().
     */
    public CircleFrame(CircleCanvas circleCanvas){
        menuBar = new JMenuBar();
        optionMenu = new JMenu("Options");
        drawNewCircles = new JMenuItem("Draw New Circles");
        drawNewCircles.addActionListener(this);
        optionMenu.add(drawNewCircles);
        openJavaDoc = new JMenuItem("Open Documentation");
        openJavaDoc.addActionListener(this);
        optionMenu.add(openJavaDoc);
        openJacocoTestReport = new JMenuItem("Open Coverage Report");
        openJacocoTestReport.addActionListener(this);
        optionMenu.add(openJacocoTestReport);
        menuBar.add(optionMenu);
        setJMenuBar(menuBar);

        this.circleCanvas = circleCanvas;
        add(circleCanvas);

        setTitle("Circle Master");
    }

    /**
     * If resetCircles JMenuItem is selected, resetCircles() is called in CircleCanvas to redraw circles.
     * If openJavaDoc or openJacocoTestReport are selected, their associated html file is opened in desktop's default web
     * browser.
     * @param event Event that is triggered by interacting with an object with an ActionListener. In this case, an event is fired
     * when one of the menu options is clicked.
     */
    public void actionPerformed(ActionEvent event){
        if (drawNewCircles == event.getSource()){
            circleCanvas.drawNewCircles();
        }
        else{
            String url = "";
            if (openJavaDoc == event.getSource()){
                url = "build\\docs\\javadoc\\index.html";
            }
            else if (openJacocoTestReport == event.getSource()){
                url = "build\\reports\\jacoco\\test\\html\\index.html";
            }
            File htmlFile = new File(url);
            try{
                Desktop.getDesktop().browse(htmlFile.toURI());
            }
            catch (Exception ex) {
                System.out.println("File not found at " + url);
            }
        }
    }

    /**
     * Drives the application. A CircleManager is created whose numCircles argument is determined by command line input. The
     * windowWidth and windowHeight arguments are slightly adjusted to account for the specifics of the application window.
     * A CircleFrame is created whose dimensions are provided by the second and third command line input.
     * @param args Command line input. First argument specifies the number of circles. Second and third arguments provide
     * the width and height of the CircleFrame. If the number of args is incorect or if one argument does not yield an integer,
     * a NumberFormatException is thrown which triggers console output "Invalid command-line inputs".
     */
    public static void main(String[] args){
        try{
            if (args.length == 3) {
                int windowWidth = Integer.parseInt(args[1]), windowHeight = Integer.parseInt(args[2]);
                CircleManager circleManager = new CircleManager(Integer.parseInt(args[0]), windowWidth - 16, windowHeight - 65, new Random());
                CircleFrame circleFrame = new CircleFrame(new CircleCanvas(circleManager));
                circleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                circleFrame.setSize(windowWidth, windowHeight);
                circleFrame.setVisible(true);
            }
            else{
                throw new NumberFormatException();
            }
        }
        catch(NumberFormatException ne){
            System.out.print("Invalid command-line input(s).");
        }
    }
}
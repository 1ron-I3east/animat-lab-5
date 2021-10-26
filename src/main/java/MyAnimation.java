import javax.swing.*; // Анимация
import java.awt.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

    public class MyAnimation extends JFrame {

        public MyAnimation () throws IOException {
            super("Simple animation");
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setSize(400,400);
            final Image[] frames = {
                    ImageIO.read(new File("1.png")),
                    ImageIO.read(new File("2.png")),
                    ImageIO.read(new File("3.png")),
                    ImageIO.read(new File("4.png")),
                    ImageIO.read(new File("5.png")),
                    ImageIO.read(new File("6.png")),
                    ImageIO.read(new File("7.png")),
                    ImageIO.read(new File("8.png")),
//                    ImageIO.read(new File("9.jpg")),
//                    ImageIO.read(new File("10.jpg")),
//                    ImageIO.read(new File("11.jpg")),
//                    ImageIO.read(new File("12.jpg")),
            };
            final JLabel animation = new JLabel(new ImageIcon(frames[0]));
            add(animation,BorderLayout.CENTER);
            ActionListener animate = new ActionListener() {
                private int index = 0;
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    if (index < frames.length - 1) index++;
                    else index = 0;
                    animation.setIcon(new ImageIcon(frames[index]));
                }
            };
            Timer timer = new Timer(70, animate);
            JToggleButton button = new JToggleButton("Start/stop");
            ActionListener start_stop = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    if (button.isSelected()) timer.start();
                    else timer.stop();
                }
            };
            button.addActionListener(start_stop);
            add(button,BorderLayout.PAGE_END);
            setVisible(true);
        }

        public static void main (String[] args) throws IOException {
            JFrame.setDefaultLookAndFeelDecorated(true);
            new MyAnimation();
        }

    }


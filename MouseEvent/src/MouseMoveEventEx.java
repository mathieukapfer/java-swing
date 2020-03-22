import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseMotionAdapter;

public class MouseMoveEventEx extends JFrame {

    private JLabel coords;
    private int x;
    private int y;
  
    public MouseMoveEventEx() {
        initUI();
    }

    private void initUI() {

        coords = new JLabel("");

        createLayout(coords);

	/*
	@Override
	    public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    g.drawRect(x,y,x,y);
	};
	*/

	addMouseMotionListener(new MouseMotionAdapter() {

	@Override
            public void mouseMoved(java.awt.event.MouseEvent e) {

                super.mouseMoved(e);

                x = e.getX();
                y = e.getY();

                var text = String.format("x: %d, y: %d", x, y);

                coords.setText(text);
            }
        });

        setTitle("Mouse move events");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void createLayout(JComponent... arg) {

        var pane = getContentPane();
        var gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setAutoCreateContainerGaps(true);

        gl.setHorizontalGroup(gl.createParallelGroup()
                .addComponent(arg[0])
                .addGap(250)
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
                .addGap(130)
        );

        pack();
    }


    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            var ex = new MouseMoveEventEx();
            ex.setVisible(true);
        });
    }
}

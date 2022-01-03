import javax.swing.*;
import java.awt.*;

public class Gui extends JFrame {

    private JPanel pane, outer,display;
    private Field[] board;
    private State state;
    private JLabel winner;
    private JButton reset;

    public Gui(){
        this.setBackground(Color.lightGray);
        this.setTitle("Tik tak toe");
        state = new State();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 400);
        this.init();
        this.setMaximumSize(new Dimension(800, 700));
        this.setMinimumSize(new Dimension(500, 400));
        this.pack();
        this.setVisible(true);

    }

    public void createOuter(){
        outer = new JPanel(new BorderLayout());

    }


    public void init(){
        pane = new JPanel(new GridLayout(3,3));
        //pane.setBackground(Color.RED);

        for(int i=0; i< 9; i++){
            Field f = new Field(state.getBoard()[i],i,this);
            pane.add(f);
        }
        createOuter();
        outer.add(pane, BorderLayout.CENTER);
        display = new JPanel(new FlowLayout());
        winner = new JLabel("Kein Gewinner");
        display.add(winner, BorderLayout.CENTER);
        outer.add(display,BorderLayout.NORTH);
        this.add(outer);
    }




    public void setWinner(){
        String newwinner = state.getWinner() == -1? "Player O": "Player X";
        winner.setText("winner is: " + newwinner);
    }


    public State getState2(){
        return state;
    }


    public void update(){
        for(int i=0; i<9; i++){
            board[i].change(state.getBoard()[i]);
        }
        this.repaint();
    }

}

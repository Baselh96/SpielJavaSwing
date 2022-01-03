import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Field  extends JButton {
    private int value, index;
    private Gui gui;

    public Field(int value,int index, Gui gui){
        this.value = value;
        this.index = index;
        this.gui = gui;
        this.setBackground(Color.lightGray);
        this.setBorder(BorderFactory.createEtchedBorder(Color.GRAY, Color.lightGray));

        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.getState2().advance(index);
                change(gui.getState2().getBoard()[index]);
                System.out.println(gui.getState2().getWinner());
                if(gui.getState2().isGameOver()){
                    gui.setWinner();
                }
            }
        });
    }
    public void change(int i){
        this.value = i;
        updateValue();
    }


    public void updateValue(){
        System.out.println(value);
        //setText(value == 0? "": value == 1? "X": "O");
        setBackground(value == 0 ? Color.lightGray : value == 1 ? Color.WHITE : Color.BLACK);
        this.repaint();
    }
}

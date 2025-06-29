import javax.swing.*;

public class AppClass {
    public static void main (String args[])
    {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                new ToDoList().setVisible(true);
            }
        });
    }
}

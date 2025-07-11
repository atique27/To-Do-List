
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TaskComponent extends JPanel implements ActionListener   {
    private JCheckBox checkBox;
    private JTextPane taskField;
    private JButton deleteButton;

    public JTextPane getTaskField() {
        return taskField;
    }


    //this panel is used so that we can make updates to the task component Panel when deleting tasks
    private JPanel parentPanel;

    public TaskComponent(JPanel parentPanel){
        this.parentPanel = parentPanel;

        taskField =new JTextPane();
        taskField.setPreferredSize(CommonConstants.TASKFIELD_SIZE);
        taskField.setContentType("text/html");

        //checkbox
        checkBox=new JCheckBox();
        checkBox.setPreferredSize(CommonConstants.CHECKBOX_SIZE);
        checkBox.addActionListener(this);

        //delete button
        deleteButton=new JButton("X");
        deleteButton.setPreferredSize(CommonConstants.DELETEBUTTON_SIZE);
        deleteButton.addActionListener(this);



        // add taskField to this taskComponent
        add(checkBox);
        add(taskField);
        add(deleteButton);

    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(checkBox.isSelected())
        {
            // replaces all html tags with empty strings to grab the main text
            String taskText = taskField.getText().replaceAll("<[^>]*>","");

            // add strike through
            taskField.setText("<html><s>"+taskText+"</s></html>");
        }
        else if(!checkBox.isSelected()){
            String taskText= taskField.getText().replaceAll("<[^>]*>","");

            taskField.setText(taskText);
        }

        if(e.getActionCommand().equalsIgnoreCase("X")){

            // delete this component from parent panel
            parentPanel.remove(this);
            parentPanel.repaint();
            parentPanel.revalidate();

        }

    }

}

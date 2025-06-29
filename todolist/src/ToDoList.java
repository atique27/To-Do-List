
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToDoList extends JFrame implements ActionListener {

    // taskpanel will act as the container for the taskcontent panel
    //taskComponentPanel will store all the task components
    private JPanel taskPanel, taskComponentPanel;

    public  ToDoList(){
        super("To Do List Application");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(CommonConstants.GUI_SIZE);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        addGuiComponent();
    }

    private void addGuiComponent(){
        //banner text
        JLabel bannerLabel = new JLabel("To Do List");
        bannerLabel.setBounds((CommonConstants.GUI_SIZE.width - bannerLabel.getPreferredSize().width)/2,15,
                CommonConstants.BANNER_SIZE.width,
                CommonConstants.BANNER_SIZE.height);

        // task panel
        taskPanel = new JPanel();


        //taskComponentPanel
        taskComponentPanel =new JPanel();

        taskComponentPanel.setLayout(new BoxLayout(taskComponentPanel,BoxLayout.Y_AXIS));
        taskPanel.add(taskComponentPanel);

        //add scrolling to the pane
        JScrollPane scrollPane=new JScrollPane(taskPanel);
        scrollPane.setBounds(8,70,CommonConstants.TASKPANEL_SIZE.width,CommonConstants.TASKPANEL_SIZE.height);
        scrollPane.setBorder(BorderFactory.createLoweredBevelBorder());
        scrollPane.setMaximumSize(CommonConstants.TASKPANEL_SIZE);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);


        // changing the speed of the scroll bar
        JScrollBar verticalScrollBar= scrollPane.getVerticalScrollBar();
        verticalScrollBar.setUnitIncrement(20);

        //add task button
        JButton addtaskbutton=new JButton("Add Task");
        addtaskbutton.setBounds(-5,CommonConstants.GUI_SIZE.height-88,
                CommonConstants.ADDTASK_BUTTON_SIZE.width, CommonConstants.ADDTASK_BUTTON_SIZE.height);

        addtaskbutton.addActionListener(this);








        // add to frame
        this.getContentPane().add(bannerLabel);
        this.getContentPane().add(scrollPane);
        this.getContentPane().add(addtaskbutton);

    }
    @Override
    public void actionPerformed(ActionEvent e){
        String command=e.getActionCommand();
        if (command.equalsIgnoreCase("Add Task"))
        {
            TaskComponent taskComponent=new TaskComponent (taskComponentPanel);
            taskComponentPanel.add(taskComponent);

            //make the task field request focus after creation
            taskComponent.getTaskField().requestFocus();
            repaint();
            revalidate();
        }

    }
}

package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class TaskListCommunicationThreadHandler implements Runnable{

    private DataInputStream in;
    private DataOutputStream out;
    private String ip;
    private TaskList taskList;
    private Socket socket;

    public TaskListCommunicationThreadHandler(Socket socket,TaskList taskList){
    this.socket=socket;
    this.taskList=taskList;
    }

    @Override
    public void run() {
        try
        {
            in = new DataInputStream(socket.getInputStream());
            out=new DataOutputStream(socket.getOutputStream());

            String request=in.readUTF();

            switch(request){
                case "ADD":
                    String task=in.readUTF();
                    long taskTime = in.readLong();
                    taskList.add(new Task(task, taskTime));
                    out.writeUTF("ADD");
                    break;

                case "SIZE":
                    out.writeInt(taskList.size());
                    break;

                case "GET":
                    Task getTask = taskList.getAndRemoveNextTask();
                    if(getTask != null)
                    {
                        out.writeUTF(getTask.getText());
                        out.writeLong(getTask.getEstimatedTime());
                    }else
                    {
                        out.writeUTF("ERROR");
                    }
                    break;
                case "DEFAULT":
                    out.writeUTF("EXIT");
                    socket.close();
                    break;
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}

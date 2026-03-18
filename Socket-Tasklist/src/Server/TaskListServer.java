package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TaskListServer {
    private TaskList taskList;
    private ServerSocket welcomeSocket;

    public TaskListServer(TaskList taskList,int port) throws IOException {
        this.taskList=taskList;
        this.welcomeSocket=new ServerSocket(port);
    }
    private void execute() throws IOException {
        while(true)
        {
            Socket socket = welcomeSocket.accept();
            TaskListCommunicationThreadHandler taskListCommunicationThreadHandler = new TaskListCommunicationThreadHandler(socket, taskList);
            Thread t1 = new Thread(taskListCommunicationThreadHandler, "taskListThread");
            t1.start();
        }
    }
}

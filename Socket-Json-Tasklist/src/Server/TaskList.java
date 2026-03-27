package Server;

import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task>tasks;

    public  TaskList(){
        this.tasks=new ArrayList<>();
    }
    public synchronized void add(Task task){
        this.tasks.add(task);
    }
    public synchronized Task getAndRemoveNextTask(){
        if (tasks.size() > 0)
        {
            return tasks.remove(0);
        }
        return null;
    }
    public synchronized int size(){
        return tasks.size();
    }

    @Override
    public synchronized String toString() {
        return "TaskList{" +
                "tasks=" + tasks +
                '}';
    }
}

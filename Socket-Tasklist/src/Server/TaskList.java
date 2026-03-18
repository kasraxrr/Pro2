package Server;

import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task>tasks;

    public TaskList(){
        this.tasks=new ArrayList<>();
    }
    public void add(Task task){
        this.tasks.add(task);
    }
    public Task getAndRemoveNextTask(int index){
        tasks.remove(index+1);
        return tasks.get(index);
    }
    public int size(){
        return tasks.size();
    }

    @Override
    public String toString() {
        return "TaskList{" +
                "tasks=" + tasks +
                '}';
    }
}

package viewmodel;

import model.Model;

public class ViewModelFactory {
    private ViewState viewState;
    private ManageExerciseViewModel manageExerciseViewModel;
    private ListExerciseViewModel listExerciseViewModel;

    public ViewModelFactory(Model model){
        this.viewState=new ViewState();
        this.manageExerciseViewModel=new ManageExerciseViewModel(model,viewState);
        this.listExerciseViewModel=new ListExerciseViewModel(model,viewState);
    }

    public ManageExerciseViewModel getManageExerciseViewModel() {
        return manageExerciseViewModel;
    }

    public ListExerciseViewModel getListExerciseViewModel() {
        return listExerciseViewModel;
    }
}

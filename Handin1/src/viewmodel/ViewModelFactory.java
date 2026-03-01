package viewmodel;

import model.Model;

public class ViewModelFactory {
    private MainViewModel  mainModel;
    private DetailViewModel detailModel;


    public ViewModelFactory(Model model){
        ViewState viewState = new ViewState();
        mainModel = new MainViewModel(model, viewState);
        detailModel = new DetailViewModel(model, viewState);
    }

    public DetailViewModel getDetailViewModel() { return detailModel; }
    public MainViewModel    getListMainViewModel()    { return mainModel; }
}

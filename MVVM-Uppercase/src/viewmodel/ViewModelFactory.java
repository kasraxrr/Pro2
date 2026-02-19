package viewmodel;

import model.Model;

public class ViewModelFactory {
    private ConvertViewModel convertViewModel;

    public ViewModelFactory(Model model){

        this.convertViewModel=new ConvertViewModel(model);
    }
    public ConvertViewModel getConvert(){
        return convertViewModel;
    }
}

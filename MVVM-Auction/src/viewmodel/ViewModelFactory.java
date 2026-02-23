package viewmodel;

import model.AuctionModel;

public class ViewModelFactory {
    private AuctionItemViewModel model;

    public ViewModelFactory(AuctionModel model){
        this.model=new AuctionItemViewModel(model);
    }

    public AuctionItemViewModel getModel() {
        return model;
    }
}

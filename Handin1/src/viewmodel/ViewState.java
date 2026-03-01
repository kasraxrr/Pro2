package viewmodel;

import model.LP;

public class ViewState {
    private LP selectedLP;
    public ViewState(){

    }

    public void setSelectedLP(LP selectedLP) {
        this.selectedLP = selectedLP;
    }

    public LP getSelectedLP() {
        return selectedLP;
    }
}

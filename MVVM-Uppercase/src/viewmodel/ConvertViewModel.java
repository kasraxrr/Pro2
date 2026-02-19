package viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Model;

public class ConvertViewModel {
    private StringProperty request;
    private StringProperty reply;
    private StringProperty error;
    private Model model;

    public ConvertViewModel(Model model){
        this.model=model;
        this.request=new SimpleStringProperty();
        this.reply=new SimpleStringProperty();
        this.error=new SimpleStringProperty();
    }
    public void covert(){
        try {
            this.reply.set(model.convert(this.request.get()))
            ;
        }catch (Exception e) {
            error.set(e.getMessage());
        }
    }
    public StringProperty errorProperty() {
        return error;
    }
    public StringProperty requestProperty() {
        return request;
    }
    public StringProperty replyProperty() {
        return reply;
    }

}

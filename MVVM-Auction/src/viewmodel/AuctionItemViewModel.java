package viewmodel;

import javafx.application.Platform;
import javafx.beans.property.*;
import model.AuctionModel;
import model.Bid;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class AuctionItemViewModel implements PropertyChangeListener {
    private AuctionModel auctionModel;
    private StringProperty item;
    private StringProperty time;
    private IntegerProperty bid;
    private StringProperty bidder;
    private IntegerProperty currentBid;
    private StringProperty currentBidder;
    private StringProperty error;
    private BooleanProperty end;
    private StringProperty currentBidTitle;

    public AuctionItemViewModel(AuctionModel model){
        this.auctionModel=model;
        this.item=new SimpleStringProperty(auctionModel.getItem());
        this.time=new SimpleStringProperty();
        this.bid=new SimpleIntegerProperty();
        this.bidder=new SimpleStringProperty();
        this.currentBid=new SimpleIntegerProperty(auctionModel.getCurrentBid());
        this.currentBidder=new SimpleStringProperty(auctionModel.getCurrentBidder());
        this.error=new SimpleStringProperty();
        this.end=new SimpleBooleanProperty();
        this.currentBidTitle=new SimpleStringProperty("Current bid: ");
        auctionModel.addListener("bid",this);
        auctionModel.addListener("end",this);
        auctionModel.addListener("time",this);
    }
    public void clear(){
        this.item.set("");
        this.time.set("");
        this.bid.set(0);
        this.bidder.set("");
        this.currentBid.set(0);
        this.currentBidder.set("");
        this.error.set("");
        this.end.set(false);
        this.currentBidTitle.set("");

    }

    public void bid(){
        boolean success = auctionModel.placeBid(bid.get(), "You");
        if (!success) {
            error.set("Bid was not placed");
        } else {
            error.set(""); // Clear the error if the bid is successful
        }
    }

    public StringProperty getItemProperty() {
        return item;
    }
    public IntegerProperty getBidProperty(){
        return bid;
    }
    public StringProperty getBidderProperty() {
        return bidder;
    }
    public IntegerProperty getCurrentBidProperty(){
        return currentBid;
    }
    public StringProperty getCurrentBidderProperty() {
        return currentBidder;
    }
    public StringProperty getErrorProperty() {
        return error;
    }
    public StringProperty getTimeProperty() {
        return time;
    }
    public BooleanProperty getEndProperty(){
        return end;
    }
    public StringProperty getCurrentBidTitleProperty(){
        return currentBidTitle;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Platform.runLater(() ->
        {
            if (evt.getPropertyName().equals("bid")) {
                Bid bid=(Bid) evt.getNewValue();
            this.currentBid.set(bid.getBid());
            this.currentBidder.set(bid.getBidder());
            }
            else if (evt.getPropertyName().equals("time")) {
                time.set((String) evt.getNewValue());
            }
            else if(evt.getPropertyName().equals("end")){
            end.set(true);
            error.set("Auction closed");
            currentBidTitle.set("Final bid");
            }
        });
    }
}

import java.util.ArrayList;


public class Auction
{
    private ArrayList<Lot> listOfLots;
    private int nextLotNumber;


    public Auction()
    {
        listOfLots = new ArrayList<>();
        nextLotNumber = 1;
    }

    public void enterLot(String description)
    {
        listOfLots.add(new Lot(nextLotNumber, description));
        nextLotNumber++;
    }


    public void showLots()
    {
        for(Lot aLot : listOfLots) {
            System.out.println(aLot.toString());
        }

    }


    public void makeABid(int lotNumber, Person bidder, long value)
    {
        Lot selectedLot = getLot(lotNumber);
        if(selectedLot != null) {
            boolean successful = selectedLot.bidFor(new Bid(bidder, value));
            if(successful) {
                System.out.println("The bid for lot number " +
                        lotNumber + " was successful.");
            }
            else {
                Bid highestBid = selectedLot.getHighestBid();
                System.out.println("Lot number: " + lotNumber +
                        " already has a bid of: " +
                        highestBid.getValue());
            }
        }
    }



    public Lot getLot(int lotNumber)
    {
        int index = 0;
        boolean found = false;
        Lot selectedNumber = null;

        while(!found && index < listOfLots.size()){
            selectedNumber = listOfLots.get(index);
            if (selectedNumber.getNumber() == lotNumber){
                found = true;
            }
            index ++;
        }

        if (found){
            return selectedNumber;
        }
        else{
            System.out.println("Lot number: " + lotNumber + " does not exist.");
            return null;
        }

    }


    public void close(){
        for(Lot alot: listOfLots){
            Bid highestbid = alot.getHighestBid();
            if (highestbid == null){
                System.out.println("the lot has no bidder");
            }
            else{
                System.out.println("the bidder is:" + highestbid.getBidder().getName() +
                        "  the bid is: " + highestbid.getValue());
            }
        }
    }

    public ArrayList<Lot> getUnsold(){
        ArrayList<Lot> unsold = new ArrayList<Lot>();

        for(Lot alot: listOfLots){
            Bid highestbid = alot.getHighestBid();
            if (highestbid == null){
                unsold.add(alot);
            }
        }
        return unsold;

    }

    public Lot removeLot(int number){
        int index = 0;
        Lot selectedlot = null;

        while(index < listOfLots.size()){
            selectedlot = listOfLots.get(index);
            if (selectedlot.getNumber() == number){
                listOfLots.remove(index);
            }
            else{
                index ++;
            }
        }
        return selectedlot;
    }


}


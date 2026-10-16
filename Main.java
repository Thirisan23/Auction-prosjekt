
void main() {

    Auction baution = new Auction();
    Person Per = new Person("Per");
    baution.enterLot("Anders");
    baution.enterLot("Petter");
    baution.enterLot("Mari");

    baution.showLots();
    baution.makeABid(1,Per, 500);

    System.out.println("*********************************************************");
    baution.close();
    System.out.println("*********************************************************");


    baution.showLots();
    System.out.println("*********************************************************");
    baution.removeLot(3);
    System.out.println("*********************************************************");
    baution.showLots();

}

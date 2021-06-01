public class Cards {
    private String cardColor;
    private String cardNumber;
    public int count;

    public Cards(String cardColor, String cardNumber) {
        this.setCardColor(cardColor);
        this.setCardNumber(cardNumber);
        if (cardNumber == "J" || cardNumber == "Q" || cardNumber == "K") {
            this.count=10;
        }else if (cardNumber=="A"){
            this.count=1;
        }else {
            this.count=Integer.parseInt(cardNumber);
        }

    }


    public String getCardColor() {
        return cardColor;
    }

    public void setCardColor(String cardColor) {
        this.cardColor = cardColor;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    public void print(){
        System.out.println(cardColor+cardNumber);
    }

}




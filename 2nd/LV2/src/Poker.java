public class Poker {
    static final int COUNT = 52;
    static String[] arrayColor = {"黑桃", "红心", "梅花", "方片"};
    static String[] arrayNumber = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    static Cards cards[]= new Cards[COUNT];

    public Poker(){
        for (int i = 0; i < arrayColor.length; i++) {
            for (int j = 0; j < arrayNumber.length; j++) {
                cards[i*13+j]=new Cards(arrayColor[i],arrayNumber[j]);
            }
        }
    }
    public void PokerPrint(){
        for (int i = 0; i < cards.length; i++) {
            cards[i].print();
            
        }
        System.out.println();
    }
    public void DealCards(int index){
        cards[index].print();
    }
    public int getCardCount(int i){
        return cards[i].count;
    }

    //获取不重复的随机数，模拟发牌
    public static int getNumber(int index, int[] a) {
        int number = 0;
        if (index <= a.length) {
            int random = (int) (Math.random() * 52);
            int j = 0;
            for (; j < a.length; j++) {
                if (random == a[j]) {
                    break;
                }
                if (j == a.length-1) {
                    a[index++] = random;
                    number = random;
                }
            }
        }
        return number;
    }
}

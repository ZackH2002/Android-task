import java.util.Objects;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        int Count = 0;//点数和
        int number = 1;//第多少张牌
        //按顺序打印所以的扑克牌
        Poker poker = new Poker();
        poker.PokerPrint();
        int[] numbers = new int[52];
        //存储已经生成过的随机数
        int index = 0;//第一次生成的随机数
        Continue(poker, index, numbers, Count,number);

    }

    static void Continue(Poker poker, int index, int[] numbers, int Count,int i) {
        //继续发牌
        System.out.print("你的第" + i + "张牌：是");
        int random = poker.getNumber(index, numbers);
        poker.DealCards(random);
        Count = Count + poker.getCardCount(random);
        System.out.println("点数和为：" + Count);
        i=i+1;
        if (Count <= 21) {
            System.out.println("是否要继续发牌Y/N");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine();
            if (Objects.equals(choice, "Y")) {
                Continue(poker, index, numbers, Count,i);
            } else {
                System.out.println("你的最终点数是：" + Count);
            }
        } else {
            System.out.println("boom,爆掉了游戏结束");
        }
    }
}


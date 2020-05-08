import java.util.Scanner;

/**
 * @Author: wangpeng
 * @Date: 2020-02-28 00:18
 *
 * 这是一个飞机的座位分布
 * 输入座位位置 然后那个位置的字母就变成X
 * 如果座位已经被占用 提示并让用户重选
 * 只有座位全被订完或者用户主动结束 才终止程序
 */
public class FlightReservation {
    public static void main(String[] args) {
        char [][]  seatMap = new char[][]{
                {'A','B','C','D'},
                {'A','B','C','D'},
                {'A','B','C','D'},
                {'A','B','C','D'},
                {'A','B','C','D'},
                {'A','B','C','D'},
                {'A','B','C','D'}
        };
        Scanner scanner = new Scanner(System.in);
        int MaxSeats = 28;
        int num = 0;
        while(num < MaxSeats){
            System.out.print("请输入座位: ");
            int indexY = scanner.nextInt()-1;
            int indexX = scanner.next().charAt(0) - 'A';

            //Input has error
            if(indexY < 0 || indexY > 6 || indexX < 0 || indexX > 3){
                System.out.println("输入有误");
                continue;
            }

            // Seat has been occupied
            if(seatMap[indexY][indexX] == 'X'){
                System.out.println("座位以被占用");
                continue;
            }

            seatMap[indexY][indexX] = 'X';

            for(int y = 0 ; y < seatMap.length ; y++){
                System.out.println();
               for(int x = 0; x < seatMap[0].length ; x++){
                   System.out.print(seatMap[y][x]+",");
               }
            }
            System.out.println();
            num++;
        }
    }


}

import java.util.*;
import java.util.stream.Stream;

public class numberBaseball {
    public static int makenum() {
        int num = (int) Math.round(Math.random() * 9);
        return num;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int comarr[] = new int[3];
        int cnt = 0;
        int trycnt = 0;

        for (int i = 0; i < 3; i++) {

            comarr[i] = (int) Math.round(Math.random() * 9);
            for (int k = 0; k < i; k++) {
                if (comarr[i] == comarr[k]) {
                    i--;
                }
            }

        }
        // com숫자 확인
        System.out.println(comarr[0] + "" + comarr[1] + "" + comarr[2]);
        System.out.println("컴퓨터가 숫자를 생성하였습니다 숫자를 맞춰보세요");


        Scanner input = new Scanner(System.in);
        while (cnt<3) {
            // 정답 못 맞췄을때 S를 0으로 다시 초기화
            cnt = 0;
            String user = input.next();

            if (user.length() != 3){
                System.out.println("3자리수를 입력해 주세요");
                continue;
            }

            int[] userarr = Stream.of(user.split("")).mapToInt(Integer::parseInt).toArray();

            //user숫자 확인
            System.out.println(Arrays.toString(userarr));

            for (int i = 0; i < 3; i++) {
                for (int k = 0; k < 3; k++) {
                    if (comarr[i] == userarr[k]) {
                        cnt++;
                    }
                }

            }
            //시도횟수
            trycnt++;

            System.out.println(trycnt+"번째 시도 : "+ user);
            System.out.println((3 - cnt) + "B" + cnt + "S");
        }
        System.out.println(trycnt+ "번만에 맞히셨습니다.");
        System.out.println("게임을 종료합니다.");
    }
}
import java.util.Scanner;

//1. 시작과 끝은 반드시 1광년만 이동할 수 있으며, 이동할 수 있는 거리는 그전 이동 거리의 +-1 범위
//2. 따라서 두번째 순서 부터는 이동 거리를 늘릴 경우 다시 줄일 거리도 고려 해야 하기 때문에 최대 이동 거리를 구해 해결

public class B1011 {
    public static void main(String[] args) {
        int t;//테스트케이스 개수
        int x, y;//현재 위치, 목표 위치
        int dis;//남은 이동 거리
        int max;//최대 이동 거리
        int count=1;

        Scanner sc=new Scanner(System.in);
        t=sc.nextInt();
        for(int i=0;i<t;i++){
            x=sc.nextInt();
            y=sc.nextInt();
            dis=y-x;

            max=(int)Math.sqrt(dis);//max값 계산
            dis=dis-max*max;
            count=2*max-1;

            while(dis!=0){//남은 거리 카운트
                if((dis-max)<0){
                    max--;
                    continue;
                }
                dis-=max;
                count++;
            }
            System.out.println(count);
        }
    }
}

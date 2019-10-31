package game;


import java.util.Scanner;

public class Play {
    int i=1;
    static int times;
    int time;//回合数
    private int aCoins;//玩家硬币数
    private int bCoins;//系统硬币数
    private int x;
    private int y;//玩家和电脑的选择（0/1表示）
    private int result;
    Players a;
    Players b;

    public Play(Players a1,Players b1){
        a=a1;
        b=b1;
    }

    public void play(){
        if(times==0){
            setTimes();
        }
        aCoins=times;
        bCoins=times;
        System.out.println(a.getName()+"和"+b.getName()+" 正在进行游戏");
        while (i<=times){
            a.time=i;
            b.time=i;
            System.out.println("time is "+b.time);
            System.out.println("deceive is "+b.deceive);
            System.out.println("开始第"+i+"回合");
            a.play();
            b.play();
            x=a.getResult();
            y=b.getResult();
            a.getOthersResult(y);
            b.getOthersResult(x);
            showResult();
            result=x+y;
            coins();
            System.out.println("第"+i+"回合结束，"+a.getName()+"的硬币数是："+aCoins+"，"+b.getName()+"的硬币数是："+bCoins);
            i=i+1;
        }
        if(aCoins>bCoins){
            System.out.println(""+a.getName()+"赢了！");
            a.winTimes=a.winTimes+1;
        }else if(aCoins<bCoins){
            System.out.println(""+b.getName()+"赢了！");
            b.winTimes=b.winTimes+1;
        }else {
            System.out.println("平局！");
        }
        a.deceive=0;
        b.deceive=0;
    }


    private void setTimes(){
        System.out.print("请输入规定回合数（1-10）：");
        Scanner a=new Scanner(System.in);
        times=a.nextInt();
    }

    //获取结果
    private String getResult(int a){
        String result;
        if(a==1){
            result="合作";
        }else {
            result="欺骗";
        }
        return result;
    }

    //展示结果
    private void showResult(){
        System.out.println("玩家"+a.getName()+"的选择是："+getResult(x));
        System.out.println("玩家"+b.getName()+"的选择是："+getResult(y));
    }

    //计算硬币数
    private void coins(){
        if(result==2){//即两人都合作
            aCoins=aCoins+3;
            bCoins=bCoins+3;
        }else if(result==1){//即只有一人合作
            if(x==1){
                aCoins=aCoins-1;
                bCoins=bCoins+3;
            }else {
                aCoins=aCoins+3;
                bCoins=bCoins-1;
            }//剩下情况为两人都不合作，结果不变
        }
    }
}

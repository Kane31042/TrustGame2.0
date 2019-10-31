package game;
import java.util.List;

public abstract class Players {
    public String name;
    public int times;//回合数
    public int time;//第几回合
    public int deceive=0;
    public int result;
    public int othersResult;
    public int winTimes;
    public abstract void play();
    public void setName(String name1){
        name=name1;
    }
    public String getName(){
        return name;
    }
    public int setTimes(int times){
        return times;
    }

    public  int getResult(){
        return result;
    }//获取自己的结果
    public int getOthersResult(int a){
        othersResult=a;
        if(a==0){
            deceive=deceive+1;
        }
        return othersResult;
    }//获取他人的结果
    public int getOthersResult(){
        return othersResult;
    }
    public void setWinTimes(int winTimes){

    }
    public int getWinTimes(){
        return winTimes;
    }
}

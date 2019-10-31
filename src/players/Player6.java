package players;

import game.Players;

//六号玩家：第一次相信，之后重复玩家前一次的选择
public class Player6 extends Players {
    @Override
    public void play() {
        if(time==1){
            this.result=1;
        }else {
            this.result=getOthersResult(othersResult);
        }
    }
}

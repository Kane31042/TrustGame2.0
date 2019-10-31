package players;

import game.Players;

//四号玩家：欺骗-相信-欺骗交替
public class Player4 extends Players {
    @Override
    public void play() {
        if(time%2==0){
            this.result=1;
        }else {
            this.result=0;
        }
    }
}

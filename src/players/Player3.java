package players;

import game.Players;
import game.Time;


//三号玩家：相信-欺骗-相信交替
public class Player3 extends Players  {
    @Override
    public void play() {
        if(time%2==1){
            this.result=1;
        }else {
            this.result=0;
        }
    }

}

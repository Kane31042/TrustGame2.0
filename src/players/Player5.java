package players;

import game.Players;

//五号玩家：随机
public class Player5 extends Players {
    @Override
    public void play() {
        this.result=(int)(Math.random()*2);
    }
}

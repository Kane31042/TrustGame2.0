package players;

import game.Players;

//七号玩家：第一次相信，若出现欺骗则之后全为欺骗
public class Player7 extends Players {
    @Override
    public void play() {
        if (time == 1) {
            this.result = 1;
        } else if (super.deceive >= 1) {
            this.result = 0;
        } else {
            this.result = 1;
        }
    }
}
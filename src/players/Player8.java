package players;
import game.Players;

//八号玩家：第一次相信，若两次欺骗则全为欺骗
public class Player8 extends Players {
    @Override
    public void play() {
        if(time==1){
            this.result=1;
        }else if(super.deceive>=2){
            this.result=0;
        }else {
            this.result=1;
        }
    }
}

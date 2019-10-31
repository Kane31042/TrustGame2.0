package game;

import players.*;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

public class Start {
    private static final String FILE_PATH = "src/players/";//包路径
    private static final String PACKEGE_NAME_PREFIX = "players.";

    public void getPlayersAndPlay(){
        int length;//记录类（玩家）个数
        File file=new File(FILE_PATH);

        List<Players> players1 = new ArrayList<>();
        File[] players=file.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".java");
            }
        });//筛选出players下面所有的类
        if(players==null){
            System.out.println("NULL!");
        }else {
            length=players.length;//获取玩家个数
            System.out.println("Players="+length);
            for (File player:players) {
                //player.getClass();//接下来要做的事情：获取类名。创建对象。进行游戏
                String className = player.getName().replace(".java", "");
                try {
                    Class<? extends Players> clazz = (Class<? extends Players>) Class.forName(PACKEGE_NAME_PREFIX + className);
                    Players p = clazz.newInstance();
                    players1.add(p);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i <length ; i++) {
                int j=i+1;
                players1.get(i).setName("player"+j);
                System.out.println( players1.get(i).getName());
            }
            for (int i = 0; i <length-1 ; i++) {//测试用
                for (int j = i+1; j <length ; j++) {
                    Play play=new Play(players1.get(i),players1.get(j));
                    play.play();
                }
            }
            int[] max=new int[length];
            for (int i = 0; i <length ; i++) {
                System.out.println(players1.get(i).getName()+"的胜利次数是："+players1.get(i).getWinTimes());
                max[i]=players1.get(i).getWinTimes();
            }
            int max1=max[0];
            boolean winners=false;
            int mark=0;
            String winner="";
            for (int i = 0; i <length-1 ; i++) {
                if(max[i]<max[i+1]){
                    max1=max[i+1];//选出赢的次数最多的玩家
                    mark=i+1;
                }
                winner=players1.get(mark).getName();
            }
                for (int j = mark+1; j <length ; j++) {
                    if(max[j]==max1){
                        winner=winner+"&"+players1.get(j).getName();
                        winners=true;
                    }
                }
                if(winners){
                    System.out.println("The winners are "+winner+"!");
                }else {
                    System.out.println("The winner is "+winner+"!");
                }

    }
}
}

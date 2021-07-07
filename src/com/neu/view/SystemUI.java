package com.neu.view;

import com.neu.pojo.impl.Player;
import com.neu.service.impl.Game;

import java.util.Scanner;

public class SystemUI {
    public static void main(String[] args) {
        new SystemUI().go();
    }

    public void go() {
        Game aGame = new Game();
        String name;
        beginPanel();
        int times = 0;
        name = getName("请输入你的游戏昵称");
        aGame.getPlayerDao().setPlayer(new Player(name,0));
        System.out.println("你好 " + aGame.getPlayerDao().getPlayer().getName());
        aGame.getPlayerDao().setComputer(aGame.getPlayerDao().getComputerPlayer(getChoose("请选择对方角色，1.刘备2.孙权3.曹操")));
        System.out.println("你选择了：" + aGame.getPlayerDao().getComputer().getName());
        System.out.println(name + "  VS " + aGame.getPlayerDao().getComputer().getName() + " 游戏开始");
        System.out.println("出拳规则，1.剪刀，2.石头，3.布:");
        if(!(continueOrNot("要开始吗？") == 'y')){
            System.out.println("游戏愉快，再见");
        }else {
            while (true) {
                times++;
                int playerFist;
                int computerFist;
                int judge;
                playerFist = getChoose("请出拳，1.剪刀，2.石头，3.布");
                fistToString(playerFist);
                computerFist = aGame.showFist();
                judge = aGame.judge(playerFist, computerFist);
                aGame.record(judge);
                System.out.println( "本轮结果；");
                if(judge == 0){
                    System.out.println("平局");
                }else if (judge > 0) {
                    System.out.println("本局" + aGame.getPlayerDao().getPlayer().getName() + "赢");
                }else{
                    System.out.println("本局" + aGame.getPlayerDao().getComputer().getName() + "赢");
                }
                printResult(judge);
                if(!(continueOrNot("要继续吗？") == 'y')) {
                    System.out.println("----------------游戏介结束---------------------");
                    System.out.println(name + "  VS " + aGame.getPlayerDao().getComputer().getName());
                    System.out.println("对战次数：" + times);
                    System.out.println("姓名      得分");
                    System.out.println(name + "\t\t" +aGame.getPlayerDao().getPlayer().getCredit());
                    System.out.println(aGame.getPlayerDao().getComputer().getName() + "\t\t" + aGame.getPlayerDao().getComputer().getCredit());
                    if(aGame.getPlayerDao().getPlayer().getCredit() == aGame.getPlayerDao().getComputer().getCredit()){
                        System.out.println("平局");
                    }else if(aGame.getPlayerDao().getPlayer().getCredit() >= aGame.getPlayerDao().getComputer().getCredit()){
                        System.out.println("有点东西哈");
                    }else{
                        System.out.println("呵呵，真太笨了。");
                    }
                    break;
                }
            }
        }

    }

    //将拳数由int转化为String输出
    public static void fistToString(int fist) {
        System.out.print("你出拳：");
        switch(fist) {
            case 1:
                System.out.print("剪刀。");
                break;
            case 2:
                System.out.print("石头。");
                break;
            case 3:
                System.out.print("布。");
                break;
        }
        System.out.println(" ");
    }

    public void printResult(int result) {
        switch(result) {
            case 0:
                System.out.println("平局.");
                break;
            case 1:
                System.out.println("恭喜你，赢得了本轮比赛.");
                break;
            case -1:
                System.out.println("小垃圾，这都能输.");
                break;
        }
    }

    //欢迎界面
    static public void beginPanel() {
        System.out.println("---------------欢 迎 进 入 游 戏 世 界---------------");
        System.out.println("");
        System.out.println("");
        System.out.println("              *********************");
        System.out.println("               ** 猜  拳  开  始 **");
        System.out.println("              *********************");
        System.out.println("");
        System.out.println("");
        System.out.println("出拳规则：1.剪刀，2.石头，3.布");
    }

    //出拳提示及输入，返回1，2，3分别为剪刀，石头，布
    public static int getFist() {
        //correct标识是否正确输入，get保存输入的拳
        Boolean correct = false;
        int get = 0;
        Scanner scan = new Scanner(System.in);
        //循环确保正确输入
        while(!correct) {
            System.out.print("请出拳1.石头，2.剪刀，3.布：");
            get = Integer.parseInt(scan.next());
            //判断是否输入正确
            if(get >=1 && get <=3) {
                correct = true;
            }else {
                System.out.println("乱来，做个人重新出拳吧！！！");
            }
        }
        //返回拳数
        return get;
    }

    //是否继续的提示（参数）及输入（返回值）
    public static char continueOrNot(String reminder) {
        char get = 'n';
        Scanner scan = new Scanner(System.in);
        System.out.print(reminder + ":");
        get = scan.next().charAt(0);
        return get;
    }

    //提示输入，返回String
    public static String getName(String reminder) {
        String get = null;
        Scanner scan = new Scanner(System.in);
        System.out.print(reminder + ":");
        get = scan.next();
        return get;
    }

    //提示输入，返回String
    public static int getChoose(String reminder) {
        int get;
        Scanner scan = new Scanner(System.in);
        System.out.print(reminder + ":");
        get = Integer.parseInt(scan.next());
        return get;
    }
}

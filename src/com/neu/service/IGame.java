package com.neu.service;

public interface IGame {
    //判断胜负，玩家胜，平局，负分别返回1，0，-1
    public int judge(int player, int computer);
}

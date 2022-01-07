package ru.bagmarya;

import java.util.Random;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public enum Step {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    public static void main( String[] args ) {
        System.out.println("Hello World!");
        Scanner in = new Scanner(System.in);
        System.out.print("Задайте размер игрового поля (нечетное число) \n");
        Room game = new Room(in.nextInt());
        Integer size = game.getSize();
        System.out.printf("Муха находится в центре под квадратным стеклом %s на %s см\n", size, size);
        System.out.print("Нужно хлопнуть муху, как только она выползет из под стекла\n");

        while (true) {
            Step direction = Step.values()[new Random().nextInt(4)];
            game.moveTheFly(direction);
            System.out.printf("Муха проползла 1 см %s\n", direction);
            System.out.print("Ваши действия: 1 - пусть ползет, 2 - хлопнуть\n");
            if (game.checkGameOver(in.nextInt())) {
                break;
            }
        }
    }
}

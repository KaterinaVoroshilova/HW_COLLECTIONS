package ru.netology.game;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class GameTest {
    Player player1 = new Player(1, "Екатерина", 580);
    Player player2 = new Player(2, "Андрей", 700);
    Player player3 = new Player(3, "Илья", 580);
    Player player4 = new Player(4, "Ольга", 350);


    @Test
    public void testNotRegistered() {
        Game game = new Game();
        game.register(player4);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Екатерина", "Илья");
        });
    }

    @Test
    public void testNotRegisteredFirst() {
        Game game = new Game();
        game.register(player4);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Екатерина", "Ольга");
        });
    }

    @Test
    public void testNotRegisteredSecond() {
        Game game = new Game();
        game.register(player1);
        game.register(player4);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Ольга", "Илья");
        });
    }

    @Test
    public void testRegisteredFirstWin() {
        Game game = new Game();
        game.register(player1);
        game.register(player4);

        int expected = 1;
        int actual = game.round("Екатерина", "Ольга");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testRegisteredSecondWin() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);

        int expected = 2;
        int actual = game.round("Екатерина", "Андрей");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testRegisteredNobodyWin() {
        Game game = new Game();
        game.register(player1);
        game.register(player3);

        int expected = 0;
        int actual = game.round("Екатерина", "Илья");

        Assertions.assertEquals(expected, actual);
    }
}

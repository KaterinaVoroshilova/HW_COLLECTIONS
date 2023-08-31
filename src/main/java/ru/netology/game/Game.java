package ru.netology.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Game {
    HashMap<String,Player> players = new HashMap<>();

    public HashMap<String,Player> register(Player player) {
        players.put(player.name, player);
        return players;
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = null;
        Player player2 = null;
        for (String name : players.keySet()) {
            if (name == playerName1) {
                player1 = players.get(name);
            }
            if (name == playerName2) {
                player2 = players.get(name);
            }
        }
        if (player1 == null) {
            throw new NotRegisteredException("Element with name: " + playerName1 + " not registered");
        }

        if (player2 == null) {
            throw new NotRegisteredException("Element with name: " + playerName2 + " not registered");
        }


        if (player1.strength > player2.strength) {
            return 1;
        }
        if (player1.strength < player2.strength) {
            return 2;
        } else {
            return 0;
        }

    }

}

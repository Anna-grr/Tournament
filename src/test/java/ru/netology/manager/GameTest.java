package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.data.Player;
import ru.netology.exception.NotRegisteredException;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    Game game = new Game();

    Player player1 = new Player(1, "PyotrTheDestroyer", 99);
    Player player2 = new Player(2, "Newbie", 25);
    Player player3 = new Player(3, "Va$ya", 25);


    @Test
    public void ShouldThrowNoRegisteredExceptionForPlayer1() {
        game.register(player1);
        game.register(player2);
        game.register(player3);

        assertThrows(NotRegisteredException.class, () -> {
            game.round("Pyotr The Destroyer", "Va$ya");
        });
    }

    @Test
    public void ShouldThrowNoRegisteredExceptionForPlayer2() {
        game.register(player1);
        game.register(player2);
        game.register(player3);

        assertThrows(NotRegisteredException.class, () -> {
            game.round("PyotrTheDestroyer", "Vasya");
        });
    }

    @Test
    public void FirstPlayerWins() {
        game.register(player1);
        game.register(player2);
        game.register(player3);

        assertEquals(1, game.round("PyotrTheDestroyer", "Va$ya"));

    }

    @Test
    public void SecondPlayerWins() {
        game.register(player1);
        game.register(player2);
        game.register(player3);

        assertEquals(2, game.round("Newbie", "PyotrTheDestroyer"));
    }

    @Test
    public void RoundEndsInADraw() {
        game.register(player1);
        game.register(player2);
        game.register(player3);

        assertEquals(0, game.round("Newbie", "Va$ya"));
    }

}

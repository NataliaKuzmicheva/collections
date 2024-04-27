import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    Player player1 = new Player(2, "Коля", 13);
    Player player2 = new Player(25, "Ваня", 11);
    Player player3 = new Player(34, "Антон", 42);
    Player player4 = new Player(48, "Кирилл", 42);
    Player player5 = new Player(56, "Сергей", 68);

    @Test
    public void shouldWinPlayer1() {
        Game game = new Game();

        game.register(player1);
        game.register(player2);

        int expected = 1;
        int actual = game.round("Коля", "Ваня");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldWinPlayer2() {
        Game game = new Game();

        game.register(player3);
        game.register(player5);

        int expected = 2;
        int actual = game.round("Антон", "Сергей");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldGameDraw() {
        Game game = new Game();

        game.register(player3);
        game.register(player4);

        int expected = 0;
        int actual = game.round("Антон", "Кирилл");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotPlayer1Registered() {
        Game game = new Game();

        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Саша", "Ваня");
        });
    }

    @Test
    public void shouldNotPlayer2Registered() {
        Game game = new Game();

        game.register(player3);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Антон", "Василий");
        });
    }
}

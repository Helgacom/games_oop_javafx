package ru.job4j.chess.firuges.black;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import static org.junit.Assert.*;
import static ru.job4j.chess.firuges.Cell.*;

public class BishopBlackTest {

    @Test
    public void position() {
        BishopBlack bishopBlack = new BishopBlack(A1);
        assertEquals(bishopBlack.position(), A1);
    }

    @Test
    public void testWay() {
        BishopBlack bishopBlack = new BishopBlack(C1);
        Cell[] rsl = bishopBlack.way(G5);
        Cell[] expected = {D2, E3, F4, G5};
        Assert.assertArrayEquals(expected, rsl);
    }

    @Test
    public void testWayWithException() {
        BishopBlack bishopBlack = new BishopBlack(C1);
        ImpossibleMoveException exception = assertThrows(
                ImpossibleMoveException.class,
                () -> bishopBlack.way(G4));
        assertTrue(exception.getMessage().contains("Could not move by diagonal"));
    }

    @Test
    public void copy() {
        BishopBlack bishopBlack = new BishopBlack(A1);
        assertEquals((bishopBlack.copy(B2)).position(), B2);
    }
}
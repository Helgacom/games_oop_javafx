package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.black.BishopBlack;
import static org.junit.Assert.assertThrows;
import static ru.job4j.chess.firuges.Cell.*;

public class LogicTest {

    @Test
    public void move() throws FigureNotFoundException, OccupiedCellException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(C1));
        logic.move(C1, H6);
    }

    @Test
    public void shouldThrowExceptionWhenFigureNotFound() {
        Logic logic = new Logic();
        assertThrows(FigureNotFoundException.class, () -> logic.move(C2, H6));
    }

    @Test
    public void shouldThrowExceptionWhenCellOccupied() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(C1));
        logic.add(new BishopBlack(H6));
        assertThrows(OccupiedCellException.class, () -> logic.move(C1, H6));
    }
}
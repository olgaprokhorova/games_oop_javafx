package ru.job4j.chess;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.PawnBlack;

public class LogicTest {

    @Ignore
    @Test
    public void move()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.move(Cell.C1, Cell.H6);
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void whenImpossibleMoveException() throws FigureNotFoundException, OccupiedCellException {
        exception.expect(ImpossibleMoveException.class);
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.move(Cell.C1, Cell.H5);
    }

    @Test
    public void whenFigureNotFoundException() throws FigureNotFoundException, OccupiedCellException {
        exception.expect(FigureNotFoundException.class);
        Logic logic = new Logic();
        logic.move(Cell.C1, Cell.H6);
    }

    @Test
    public void whenOccupiedCellException() throws FigureNotFoundException, OccupiedCellException {
        exception.expect(OccupiedCellException.class);
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.add(new PawnBlack(Cell.D2));
        logic.move(Cell.C1, Cell.H6);
    }
}
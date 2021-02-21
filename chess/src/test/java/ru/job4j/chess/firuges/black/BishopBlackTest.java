package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class BishopBlackTest {

    @Test
    public void position() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        assertThat(bishopBlack.position(), is(Cell.C8));
    }

    @Test
    public void copy() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        assertThat(bishopBlack.copy(Cell.C1).position(), is(Cell.C1));
    }

    @Test
    public void way() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] expected = bishopBlack.way(Cell.G5);
        assertThat(expected, is(new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5}));
    }

    @Test
    public void whenIsNoDiagonal() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        assertThat(bishopBlack.isDiagonal(bishopBlack.position(), Cell.C3), is(false));
    }

    @Test
    public void wayWhenIsNoDiagonal() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        try {
            bishopBlack.way(Cell.C3);
            fail("Expected ImpossibleMoveException");
        } catch (ImpossibleMoveException ime) {
            assertThat(ime.getMessage(), containsString(
                    "Could not way by diagonal from " + bishopBlack.position() + " to " + Cell.C3)
            );
        }
    }
}
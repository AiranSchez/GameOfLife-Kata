import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameOfLiveShould {
    /*To do List
        3 celulas vecinas con una muerta revive.
        2 o 3 vivas sigue viva
        menos de 2 muere soledad
        mas de 3 muere superpoblacion.
     */

    public class Cell {
        // 0 está muerta, 1 está viva
        public int status;

        public Cell(){
            this.status = 0;
        }
        public Cell(int status){
            this.status = status;
        }

        public int getStatus() {
            return status;
        }
        public void setStatus(int status) {
            this.status = status;
        }
    }

    public class Table {
        Cell[][] matrix;
        public Table() {
            this.matrix = new Cell[3][3];
            setMatrix();
        }
        public void setMatrix(){
            for(int row = 0; row < matrix.length; row++){
                for(int element = 0; element < matrix[row].length; element++){
                    matrix[row][element] = new Cell();
                }
            }
        }
    }

    @Test
    public void checkIfCellIsAlive(){
        Cell cell = new Cell(1);
        assertThat(cell.getStatus()).isEqualTo(1);
    }
    @Test
    public void checkIfCellIsDead(){
        Cell cell = new Cell(0);
        assertThat(cell.getStatus()).isEqualTo(0);
    }

    @Test
    public void checkIfBoardIsOk(){
        Table board = new Table();
        assertThat(board.matrix[0][0].status).isEqualTo(0);
        assertThat(board.matrix[1][1].status).isEqualTo(0);
        assertThat(board.matrix[2][2].status).isEqualTo(0);
    }

}

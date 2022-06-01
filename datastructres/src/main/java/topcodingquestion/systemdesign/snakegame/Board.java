package main.java.topcodingquestion.systemdesign.snakegame;

public class Board {
    final int ROW_COUNT, COL_COUNT;
    private Cell[][] cells;

    public Board(int row_count, int col_count) {
        ROW_COUNT = row_count;
        COL_COUNT = col_count;
        cells = new Cell[ROW_COUNT][COL_COUNT];
        for (int row =0; row< ROW_COUNT; row++){
            for (int col =0; col < COL_COUNT;col++){
                cells[row][col] = new Cell(row,col);
            }
        }
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    public void generateFood(){
        System.out.println("Going to generate food");
        while (true){
            int row =(int)(Math.random() * ROW_COUNT);
            int col = (int) (Math.random() * COL_COUNT);
            if(cells[row][col].getCellType() != CellType.SNAKE_NODE)
                break;
            cells[row][col].setCellType(CellType.FOOD);
            System.out.println("Food is generated at: " + row + " " + col);

        }
    }
}

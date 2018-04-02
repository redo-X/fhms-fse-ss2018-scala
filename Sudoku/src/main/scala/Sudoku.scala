object Sudoku {

  def main(args: Array[String]): Unit = {

    val sudokuField = Array(
        Array(0, 4, 1, 0, 8, 3, 0, 2, 0),
        Array(0, 0, 0, 9, 0, 7, 0, 1, 0),
        Array(0, 8, 0, 0, 0, 4, 0, 7, 0),
        Array(0, 0, 5, 0, 0, 0, 0, 8, 0),
        Array(0, 0, 0, 0, 4, 0, 5, 0, 2),
        Array(0, 0, 9, 0, 2, 0, 0, 0, 4),
        Array(1, 0, 0, 6, 5, 9, 0, 0, 0),
        Array(0, 0, 0, 1, 0, 0, 8, 6, 7),
        Array(6, 0, 2, 0, 7, 0, 1, 0, 0))

    val s = new Sudoku(sudokuField)
    s.Solve
  }

  class Sudoku(sudoku : Array[Array[Int]]) {

    def Solve = {
      println(SolveBacktrack())
      PrintOut
    }

    private def SolveBacktrack() : Boolean = {
      var i, j : Int = 0
      var stillEmptyCells : Boolean = false

      for(ii <- 0 to 8 if !stillEmptyCells) {
        for(jj <- 0 to 8 if !stillEmptyCells) {
          if(sudoku(ii)(jj) == 0) {
            stillEmptyCells = true
            i = ii
            j = jj
          }
        }
      }

        if(!stillEmptyCells){
          return true
      }

      for(x <- 1 to 9) {
        if(CheckPossibleNumber(i, j, x)) {
          sudoku(i)(j) = x

          if(SolveBacktrack()) {
            return true
          }

          sudoku(i)(j) = 0
        }
      }

      return false
    }

    private def CheckPossibleNumber(row : Int, column : Int, n : Int) : Boolean = {
      return !CheckNumberInRow(row, n) && !CheckNumberInColumn(column, n) && !CheckNumberInBox(row, column, n)
    }

    private def CheckNumberInRow(row : Int, n : Int) : Boolean = {
      for(numberInRow <- sudoku(row)) {
        if(numberInRow == n) {
          return true
        }
      }
      return false
    }

    private def CheckNumberInColumn(column : Int, n : Int) : Boolean = {
      for(row <- sudoku) {
        if(row(column) == n) {
          return true;
        }
      }
      return false
    }

    private def CheckNumberInBox(i : Int, j: Int, n : Int) : Boolean = {
      val boxRow : Int = i - i%3
      val boxColumn : Int = j - j%3
      for(ii <- 0 to 2) {
        for(jj <- 0 to 2) {
          if(sudoku(boxRow + ii)(boxColumn + jj) == n) {
            return true
          }
        }
      }
      return false
    }

    def PrintOut = {
      for(x <- sudoku) {
        for(y <- x) {
          print(y + " ")
        }
        println("")
      }
    }
  }
}

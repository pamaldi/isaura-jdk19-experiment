package cloud.isaura.experimental.cellularautomata.simple.algo;

import cloud.isaura.experimental.cellularautomata.simple.model.Board;
import cloud.isaura.experimental.cellularautomata.simple.model.Cell;
import cloud.isaura.experimental.cellularautomata.simple.model.GenerationRule;
import cloud.isaura.experimental.cellularautomata.simple.utils.Constants;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;

public class AutomataGenerator
{


    public Board execute(Observer<Cell> observer)
    {
        System.out.println("Execute");
        Board board = new Board(Constants.boardColumns, Constants.boardRows);
        int[] ruleset = {0, 0, 0, 1, 1, 1, 1, 0};
        GenerationRule generationRule = new GenerationRule(ruleset);
        board.setStateAtValue(0, 50, 1);
        for (int indexRow = 1; indexRow < Constants.boardRows; indexRow++)
        {
            for (int indexColumn = 0; indexColumn < Constants.boardColumns; indexColumn++)
            {
                int left = indexColumn - 1 < 0 ? 0 : board.getStateAt(indexRow - 1, indexColumn - 1);
                int middle = board.getStateAt(indexRow - 1, indexColumn);
                int right = indexColumn + 1 >= Constants.boardColumns ? 0 : board.getStateAt(indexRow - 1, indexColumn + 1);
                final int newValue = generationRule.applyRule(left, middle, right);
                board.setStateAtValue(indexRow, indexColumn, newValue);
                final Cell updatedCell = board.getCellsAt(indexRow, indexColumn);
                Observable<Cell> singleObservable = Observable
                        .just(updatedCell);
                singleObservable.blockingSubscribe(observer);


            }
            //System.out.println("**************** End iteration for index Row: "+indexRow+" *******************");

        }

        System.out.println("******* At the end print board *******");
        board.print();
        return board;

    }

}

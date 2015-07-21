package test.groovy.fsm

import main.groovy.fsm.Machine
import main.groovy.fsm.Solver

class SolverTest {
    def test3Node() {
        new Solver().solve(
                [
                        [0, 'F'],//0
                        [1, 'S'],//1
                        [0, 'F'],//2
                        [0, 'F'],//3
                        [1, 'S'],//4
                        [1, 'S'],//5
                        [0, 'F'],//6
                        [1, 'S'],//7
                        [0, 'F'],//8
                        [0, 'F'],//9
                        [1, 'S'],//10
                        [0, 'S'],//11
                        [1, 'S'],//12
                        [1, 'S'],//13
                        [0, 'F'],//14
                        [0, 'F'],//15
                        [0, 'F'],//16
                        [1, 'S'],//17
                        [0, 'F'],//18
                ])
    }

    def testJuggler() {
        new Machine().next(
                [
                        [3, true],
                        [3, true],
                        [3, true],
                        [5, true],
                        [1, false],
                        [4, false],
                        [3, true],
                        [3, false],
                        [5, true],
                        [3, false],
                        [5, false],
                        [0, true],
                        [1, false],
                        [2, true],
                        [1, false],
                        [0, false],
                        [3, true],
                        [1, false],
                        [5, true],
                        [0, false],
                        [4, false],
                        [4, false],
                        [3, true],
                        [3, false],
                        [0, false],
                        [3, false],
                        [0, false],
                        [3, false],
                        [1, true],
                        [4, true],
                        [4, true],
                        [0, false],
                        [5, true]
                ]
        )
    }
}

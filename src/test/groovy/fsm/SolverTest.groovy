package test.groovy.fsm

import main.groovy.fsm.Machine
import main.groovy.fsm.Solver
import org.testng.annotations.Test

class SolverTest {
    @Test
    void test3Node() {
        def inputOutputs = [
//                [1, 'S'],//
//                [1, 'S'],//
//                [1, 'S'],//
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
        ]
        long t1 = System.nanoTime()
        def machine = new Solver().solve(inputOutputs)
        long t2 = System.nanoTime()
        println t2-t1
        println machine

        def expected = new Machine([0,1])
        expected.transitions = [
                0: [0: 0, 1: 1],
                1: [0: 1, 1: 2],
                2: [0: 1, 1: 0]
        ]
        expected.outputTransitions = [
                0: [0: "F", 1: "S"],
                1: [0: "F", 1: "S"],
                2: [0: "S", 1: "S"]
        ]
        expected.curstate = 1
        assert machine == expected
    }

    @Test
    void testJuggler4() {
            def inputOutputs = [
                    [3, true],
                    [3, true],
                    [3, true],
                    [4, true],
                    [3, false],
                    [0, false],
                    [4, true],
                    [1, true],
                    [3, true],
                    [1, false],
                    [2, false],
                    [4, true],
                    [1, false],
                    [2, true],
                    [4, true],
                    [1, false],
                    [2, true],
                    [1, false],
                    [0, false],
                    [1, false],
                    [4, true],
                    [3, false],
                    [3, false],
                    [1, false],
                    [3, false],
                    [2, true],
                    [4, true],
                    [0, false],
                    [4, true],
                    [2, false],
                    [3, false],
                    [2, false],
                    [3, false],
                    [4, true],
                    [1, false],
                    [1, false],
                    [0, true],
                    [3, true],
                    [3, true],
                    [3, true],
                    [4, true],
                    [0, false],
                    [4, true],
                    [4, true],
                    [3, false],
                    [4, false],
                    [4, false],
                    [1, false],
                    [1, false],
                    [4, false],
                    [3, false],
                    [1, false],
                    [2, false],
                    [1, false],
                    [1, false],
                    [0, true],
                    [4, true],
                    [3, false],
                    [2, true],
                    [3, true],
                    [2, false],
                    [0, false],
                    [4, true],
                    [1, false],
                    [2, true],
                    [1, false],
                    [0, false],
                    [3, true],
                    [4, true],
                    [1, false],
                    [3, false],
                    [1, false],
                    [2, true],
                    [2, false],
                    [2, false],
                    [4, true],
                    [3, false],
                    [1, false],
                    [2, true],
                    [2, false],
                    [4, true],
                    [4, true],
                    [2, false],
                    [4, true],
                    [4, false],
                    [4, false],
                    [1, false],
                    [1, false],
                    [1, false],
                    [0, true],
                    [1, false],
                    [1, false],
                    [3, true],
                    [4, true],
                    [1, false],
                    [2, true],
                    [2, false],
                    [0, false],
                    [1, false],
                    [0, false],
                    [1, false],
                    [4, true],
                    [1, false],
                    [4, true],
                    [0, false],
                    [3, false],
                    [1, true],
            ]
            long t1 = System.nanoTime()
            def machine = new Solver().solve(inputOutputs)
            long t2 = System.nanoTime()
            println t2-t1
            println machine
        def expected = new Machine([0, 1, 2, 3, 4])
        expected.transitions = [
                0: [0: 0, 1: 0, 2: 0, 3: 0, 4: 1],
                1: [0: 1, 1: 1, 2: 0, 3: 1, 4: 2],
                2: [0: 2, 1: 0, 2: 2, 3: 2, 4: 3],
                3: [0: 0, 1: 3, 2: 3, 3: 3, 4: 3],
        ]
        expected.outputTransitions = [
                0: [0: false, 1: false, 2: false, 3: true, 4: true],
                1: [0: false, 1: false, 2: true, 3: false, 4: true],
                2: [0: false, 1: true, 2: false, 3: false, 4: true],
                3: [0: true, 1: false, 2: false, 3: false, 4: false],
        ]
        expected.curstate = 0
        assert machine == expected
    }

    @Test
    void testJuggler5() {
        def inputOutputs = [
                [3, true],
                [3, true],
                [3, true],
                [0, false],
                [3, true],
                [4, true],
                [0, false],
                [1, false],
                [3, false],
                [4, true],
                [0, false],
                [3, false],
                [4, true],
                [3, false],
                [2, false],
                [0, true],
                [4, true],
                [5, true],
                [5, true],
                [3, false],
                [3, false],
                [4, false],
                [2, false],
                [2, false],
                [1, false],
                [4, false],
                [2, false],
                [5, false],
                [5, false],
                [3, false],
                [0, true],
                [1, true],
                [4, true],
                [4, true],
                [4, true],
                [4, false],
                [3, false],
                [2, false],
                [3, false],
                [2, false],
                [4, false],
                [0, true],
                [2, false],
                [4, true],
                [3, false],
                [1, false],
                [3, false],
                [5, true],
                [3, true],
                [2, false],
                [2, false],
                [1, false],
                [2, false],
                [4, false],
                [2, false],
                [5, false],
                [1, false],
                [1, false],
                [0, true],
                [0, false],
                [0, false],
                [3, true],
                [5, true],
                [3, true],
                [0, false],
                [0, false],
                [5, true],
                [1, false],
                [1, false],
                [4, false],
                [3, false],
                [1, false],
                [3, false],
                [4, false],
                [3, false],
                [1, false],
                [2, false],
                [0, true],
                [2, true],
                [0, false],
                [0, false],
                [0, false],
                [0, false],
                [5, true],
                [0, false],
                [0, false],
                [2, true],
                [5, true],
                [1, true],
                [2, true],
                [2, false],
                [4, true],
                [4, true],
                [5, true],
                [5, false],
                [0, true],
                [1, false],
                [1, false],
                [5, true],
                [2, false],
                [5, true],
                [3, false],
                [4, false],
        ]
        long t1 = System.nanoTime()
        def machine = new Solver().solve(inputOutputs)
        long t2 = System.nanoTime()
        println t2-t1
        println machine
    }
}

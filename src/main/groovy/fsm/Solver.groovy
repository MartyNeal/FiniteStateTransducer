package main.groovy.fsm

class Solver {
    def solve(List<List<Object>> inputOutputPairs) {
        def inputs = inputOutputPairs*.getAt(0).unique().sort()
        def machine = new Machine(inputs)
        def stack = [] as Stack
        def i = 0
        while (i < inputOutputPairs.size()) {
            def (input, output) = inputOutputPairs[i]
            println "$i $stack"
            println machine
            println "input $input output $output"
            println ''
            switch (machine.getOutput(input)) {
                case output:
                    machine.move(input)
                    break
                case null:
                    stack.push([i, machine.curstate])
                    machine.setOutput(input, output)
                    machine.setState(input, 0)
                    machine.move(input)
                    break
                default:
                    int newState
                    println "pop"
                    (i, newState) = stack.pop()
                    machine.curstate = newState
                    input = inputOutputPairs[i][0]
                    while (machine.getState(input) + 1 == machine.size) {
                        machine.remove(input)
                        if (stack.size() > 0) {
                            println "pop"
                            (i, newState) = stack.pop()
                            machine.curstate = newState
                            input = inputOutputPairs[i][0]
                        } else {
                            println "Adding state"
                            machine.addState()
                        }
                    }
                    stack.push([i, machine.curstate])
                    (input, output) = inputOutputPairs[i]
                    machine.setOutput(input, output)
                    machine.setState(input, machine.getState(input) + 1)
                    machine.move(input)
            }
            i++
        }
        machine
    }
}

package main.groovy.fsm

class Solver {
    def solve(List<List<Object>> inputOutputPairs) {
        def inputs = inputOutputPairs*.getAt(0).unique().sort()
        def machine = new Machine(inputs)
        def stack = [] as Stack
        def i = 0
        while (i < inputOutputPairs.size()) {
            def (input, output) = inputOutputPairs[i]
/*
            println "$i $stack"
            println machine
            println "input $input output $output"
            println ''
*/
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
                    while(true) {
                        (i, newState) = stack.pop()
                        machine.curstate = newState
                        input = inputOutputPairs[i][0]
                        newState = machine.getState(input)+1
                        if (newState < machine.size) {
                            stack.push([i, machine.curstate])
                            output = inputOutputPairs[i][1]
                            machine.setOutput(input, output)
                            machine.setState(input, newState)
                            def newTransitions = machine.transitions[newState]
                            def newOutputTransitions = machine.outputTransitions[newState]
                            if ((0..<newState).any { offset ->
                                machine.outputTransitions[offset] == newOutputTransitions &&
                                        machine.transitions[offset] == newTransitions
                            }) {
                                continue
                            }

                            machine.move(input)
                            break
                        } else {
                            machine.remove(input)
                            if (stack.size() == 0) {
                                println "Adding state"
                                machine.addState()
                                i = -1
                                break
                            }
                        }
                    }
            }
            i++
        }
        machine
    }
}

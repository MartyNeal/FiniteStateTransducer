package main.groovy.fsm

class Machine<Input, Output> {
    List<Input> inputs = []
    def Machine(List<Input> inputs) {
        this.inputs = inputs
    }

    Map<Integer, Map<Input, Integer>> transitions = [0: [:]]
    Map<Integer, Map<Input, Output>> outputTransitions = [0: [:]]
    Integer curstate = 0

    int getState(Input input) {
        transitions[curstate][input]
    }

    Output getOutput(Input input) {
        outputTransitions[curstate][input]
    }

    void move(Input input) {
        curstate = transitions[curstate][input]
    }

    void setOutput(Input input, Output output) {
        outputTransitions[curstate][input] = output
    }

    void setState(Input input, int state) {
        transitions[curstate][input] = state
    }

    int getSize() {
        transitions.size()
    }

    void addState() {
        def s = size
        transitions[s] = [:]
        outputTransitions[s] = [:]
    }

    void remove(Input input) {
        transitions[curstate].remove(input)
        outputTransitions[curstate].remove(input)
    }

    String toString() {
        def sb = new StringBuilder()
        sb.append(' ')
        inputs.each { sb.append "   $it" }
        sb.append '\n'
        size.times { k ->
            def pp = { a, j -> def z = a[k][j]; z == null ? '?' : z }
            sb.append "${curstate == k ? '*' : ' '}$k"
            inputs.each { i -> sb.append " ${pp(transitions, i)}/${pp(outputTransitions, i)}" }
            sb.append '\n'
        }
        sb.size = sb.size - 1
        sb.toString()
    }
}

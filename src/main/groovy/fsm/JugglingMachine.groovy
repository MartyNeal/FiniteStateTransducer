package main.groovy.fsm

class JugglingMachine {
    static void main(String[] argv) {
        def history = [[3,true], [3,true], [3,true]]
        def r = new Random()
        30.times {
            def tr = r.nextInt(6)
            def rev = ([tr] + history.reverse().findAll {it[1] }*.getAt(0)).withIndex()
            def r1 = !rev[1..-1].any { e, i -> e - tr == i }
            def r2 = rev.any { e, i -> e - i == 0 }
            def res = r1 && r2
            history += [[tr, res]]
        }
        history.each { println "$it," }
    }
}

package main.groovy.fsm

class Main {
    static void main(String[] argv) {

        /**/
    }
}

/*

transitions [0:[0:2, 1:0], 1:[1:0, 0:1], 2:[0:1, 1:0]]
outputTransitions [0:[0:F, 1:S], 1:[1:S, 0:S], 2:[0:F, 1:S]]
curstate 1
stack [[0, 0, 1], [1, 0, 3], [3, 2, 2], [4, 2, 2], [10, 1, 2]]

     0.F
    _ 0
     /|\
 1.S/   \ 1.S
   / 0.S_\|
  2<----->1
     1.S   0.F

i     012345678901234567
state 0011120011121200011
input 010011010010110010
outpt FSFFSSFSFFSSSSFFSF
*/

package tla.test;

import tla.core.State;
import tla.core.Symbol;
import tla.core.Word;
import tla.fsa.Automaton;
import tla.fsa.AutomatonNfa;

import java.util.Scanner;

public class SimpleNFA extends AutomatonNfa {

    public SimpleNFA() {
        State q0 = new State("q0");
        State q1 = new State("q1");
        State q2 = new State("q2");
        Symbol s0 = new Symbol("0");
        Symbol s1 = new Symbol("1");
        setInitialState(q0);
        F.add(q2);
        T.put(q0, s0, q0);
        T.put(q0, s0, q1);
        T.put(q0, s1, q0);
        T.put(q1, s1, q2);
    }

    public static void run() {
        Automaton fsa = new SimpleNFA();
        Scanner scanner;
        System.out.println("NFA");
        System.out.println("========================");
        System.out.println(fsa);
        System.out.print("Input a string to test the NFA: ");
        scanner = new Scanner(System.in);
        Word word = new Word(scanner.next());
        if (fsa.accepts(word)) {
            System.out.println(word + " accepted.");
        } else {
            System.out.println(word + " cannot be accepted.");
        }
    }
}

package tla.test;

import tla.core.State;
import tla.core.Symbol;
import tla.core.Word;
import tla.fsa.Automaton;
import tla.fsa.AutomatonNfaEpsilon;

import java.util.Scanner;

public class SimpleNFAe extends AutomatonNfaEpsilon {

    public SimpleNFAe() {
        State q0 = new State("q0");
        State q1 = new State("q1");
        State q2 = new State("q2");
        Symbol a = new Symbol("a");
        Symbol b = new Symbol("b");
        Symbol c = new Symbol("c");
        setInitialState(q0);
        F.add(q2);
        T.put(q0, a, q0);
        T.put(q0, b, q0);
        T.put(q0, epsilon, q1);
        T.put(q1, epsilon, q2);
        T.put(q1, c, q2);
        T.put(q2, a, q0);
        System.out.println(T);
    }

    public static void run() {
        Automaton fsa = new SimpleNFAe();
        Scanner scanner;
        System.out.println("NFA-epsilon");
        System.out.println("========================");
        System.out.println(fsa);
        System.out.print("Input a string to test the NFA-epsilon: ");
        scanner = new Scanner(System.in);
        Word word = new Word(scanner.next());
        if (fsa.accepts(word)) {
            System.out.println(word + " accepted.");
        } else {
            System.out.println(word + " cannot be accepted.");
        }
    }
}

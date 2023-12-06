package tla.fsa;

import tla.core.State;
import tla.core.StateSet;
import tla.core.Symbol;
import tla.core.Word;

public abstract class AutomatonNfa extends Automaton {

    public boolean accepts(Word w) {
        StateSet P = Delta(w);
        if (P == null) return false;
        for (State q : P) {
            if (F.contains(q)) {
                return true;
            }
        }
        return false;
    }

    private StateSet Delta(Word w) {
        StateSet currentState = new StateSet();
        currentState.add(init);
        for (int i = 0; i < w.size(); i++) {
            Symbol a = w.get(i);
            StateSet nextState = new StateSet();
            for (State q : currentState) {
                nextState.addAll(delta(q, a));
            }
            currentState = nextState;
        }
        return currentState;
    }

    private StateSet delta(State q, Symbol a) {
        return T.get(q, a);
    }
}

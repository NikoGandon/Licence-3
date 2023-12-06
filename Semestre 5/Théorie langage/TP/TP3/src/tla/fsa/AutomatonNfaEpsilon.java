package tla.fsa;

import tla.core.State;
import tla.core.StateSet;
import tla.core.Symbol;
import tla.core.Word;

public abstract class AutomatonNfaEpsilon extends Automaton {

    protected Symbol epsilon = new Symbol("/epsilon/");

    public boolean accepts(Word w) {
        // TODO

        return false;
    }

    private StateSet Delta(Word w) {
        // TODO
        StateSet S = new StateSet();
        return null;
    }

    private StateSet closure(State q) {
        // TODO
        StateSet S = new StateSet(); 
        return null;
    }

    private void closure(State q, StateSet E) {
        // TODO
        
    }

    private StateSet delta(State q, Symbol a) {
        return T.get(q, a);
    }
}

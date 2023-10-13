package tla.fsa;

import tla.core.State;
import tla.core.Symbol;
import tla.core.Word;

public abstract class AutomatonDfa extends Automaton {

    public boolean accepts(Word w) {
        // TODO
        return false;
    }

    private State Delta(Word w) {
        // TODO
        return null;
    }

    private State delta(State q, Symbol a) {
        return T.get(q, a);
    }
}

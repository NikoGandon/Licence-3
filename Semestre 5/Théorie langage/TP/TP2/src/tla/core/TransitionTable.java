package tla.core;

import java.util.TreeMap;

public class TransitionTable extends TreeMap<State, TreeMap<Symbol, StateSet>> {

    public StateSet get(State q, Symbol a) {
        // TODO

        return null;
    }

    public void put(State q, Symbol a, State p) {
        // TODO;
        
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (State q : this.keySet()) {
            TreeMap<Symbol, StateSet> m = this.get(q);
            if (m == null) {
                continue;
            }
            for (Symbol a : m.keySet()) {
                StateSet P = m.get(a);
                if (P == null) {
                    continue;
                }
                for (State p : P) {
                    s.append(q).append(" --(").append(a).append(")--> ").append(p).append("\n");
                }
            }
        }
        return s.toString();
    }
}

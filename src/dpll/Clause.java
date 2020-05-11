package dpll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Clause {

    private ArrayList<Literal> clause;

    public Clause(Literal l) {
        this.clause = new ArrayList<>();

        clause.add(new Literal(
                l.getSign(), l.getValue()
        ));
    }

    public Clause(ArrayList<Literal> clause) {
        this.clause = clause;
    }

    public Clause(String[] cString) {
        clause = new ArrayList<>(
                parseClauseString(cString));
    }

    private List<Literal> parseClauseString(String[] cString) {
        Literal[] clause = new Literal[cString.length];
        for (int i = 0; i < clause.length; i++) {
            if (cString[i].length() == 2) {
                clause[i] = new Literal(false,
                        Character.getNumericValue(
                                cString[i].charAt(1)));
            } else {
                clause[i] = new Literal(true,
                        Character.getNumericValue(
                                cString[i].charAt(0)));
            }
        }
        return Arrays.asList(clause);
    }

    public int size() {
        return clause.size();
    }

    public boolean contains(Literal l) {
        for (Literal lit : clause) {
            if ((lit.getValue() == l.getValue()) && (lit.getSign() == l.getSign()))
                return true;
        }
        return false;
    }

    public Clause getReducedClause(Literal l) {
        ArrayList<Literal> clause = new ArrayList<>();
        for (Literal lit : this.clause) {
            if (!(lit.getValue() == l.getValue()))
                clause.add(new Literal(lit.getSign(), lit.getValue()));
        }
        return new Clause(clause);
    }

    public Literal getHead() {
        return this.clause.get(0);
    }

    public ArrayList<Literal> getClause() {
        return clause;
    }

    public Clause clone() {
        ArrayList<Literal> clause = new ArrayList<>();
        this.clause.forEach(
                l -> clause.add(new Literal(l.getSign(), l.getValue()))
        );
        return new Clause(clause);
    }

}

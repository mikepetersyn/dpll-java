package dpll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Formula {

    private ArrayList<Clause> formula;

    public Formula(ArrayList<Clause> formula) {
        this.formula = new ArrayList<>();
        formula.forEach(c -> this.formula.add(c.clone()));
    }

    public Formula(String[][] fString) {
        this.formula = new ArrayList<>(parseFormulaString(fString));
    }

    private List<Clause> parseFormulaString(String[][] fString) {
        Clause[] formula = new Clause[fString.length];
        for (int i = 0; i < formula.length; i++) {
            formula[i] = new Clause(
                    fString[i]
            );
        }
        return Arrays.asList(formula);
    }

    public ArrayList<Clause> getFormula() {
        return formula;
    }

    public boolean hasEmptyClause() {
        for (Clause c : formula) {
            if (c.size() == 0)
                return true;
        }
        return false;
    }

    public Clause getAtomClause() {
        Clause atomClause = null;
        for (Clause c : formula) {
            if (c.size() == 1)
                atomClause = c;
        }
        return atomClause;
    }

    public Formula getReducedFormula(Clause atomClause) {
        ArrayList<Clause> formula = new ArrayList<>();
        Literal l = atomClause.getHead();
        Literal negL = l.getNegated();
        for (Clause c : this.formula) {
            // if clause contains not l from
            // atomClause, then add this to our formula
            if (!(c.contains(l) || c.contains(l.getNegated()))) {
                formula.add(c);
            }
            // if it contains negated, then
            // remove element from clause and add to formula
            else if (c.contains(negL)) {
                formula.add(c.getReducedClause(negL));
            }
        }
        return new Formula(formula);
    }

    public Literal getAtomLiteral() {
        for (Clause c : formula) {
            if (c.size() != 0) {
                return c.getHead();
            }
        }
        return null;
    }

    public void addClause(Clause c) {
        this.formula.add(c);
    }
}

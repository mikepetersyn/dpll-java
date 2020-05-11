package dpll;

public class Dpll {

    public static boolean dpll(Formula f) {

        if (f.getFormula().isEmpty()) {
            return true;
        } else if (f.hasEmptyClause()) {
            return false;
        }

        Clause atomClause = f.getAtomClause();
        if (atomClause != null) {
            return dpll(
                    f.getReducedFormula(atomClause));
        } else {
            Literal l = f.getAtomLiteral();

            Formula f_a = new Formula(f.getFormula());
            f_a.addClause(new Clause(l));

            Formula f_b = new Formula(f.getFormula());
            f_b.addClause(new Clause(l.getNegated()));

            return (dpll(f_a) || dpll(f_b));
        }
    }

}

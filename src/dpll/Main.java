package dpll;

public class Main {

    public static void main(String args[]) {

        // pass String like {{"-r","q"},{"-p","-r"},{"p","-q"}}
        // and constructor creates Formula in KNF form like
        // f := (¬r ∨ q) ∧ (¬p ∨ ¬r) ∧ (p ∨ ¬q)
        // empty clauses passed like {} not {""}
        Formula f = new Formula(
                new String[][]{{"-3", "2"}, {"-1", "-3"}, {"1", "-2"}}
        );
        Formula f2 = new Formula(
                new String[][]{{"1"}, {"-1"}}
        );
        Formula f3 = new Formula(
                new String[][]{{"1", "2"}, {"1", "2"}}
        );

        boolean result = Dpll.dpll(f2);

    }

}

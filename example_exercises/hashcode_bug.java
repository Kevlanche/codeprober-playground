class Foo {
    
    int hash;

    int x;
    int y;

    public int hashCode() {
        if (hash == 0) {
            int hash = 1;
            hash = hash * 31 + x;
            hash = hash * 31 + y;
        }
        return hash;
    }
}
/*
What is wrong with this hashCode implementation?
This is based on a real world bug from the ANTLR project.

Hint: Probe "FieldDeclarator.showAccessors()" on line 3.
If you fix the bug in the implementation, you should see many new arrows appear.

If you leave the bug in place, you can also try opening a probe for "Program.showAnalysis()".
Then one of the analyses for IntraJ will run, which will give you the solution in plain text.
*/
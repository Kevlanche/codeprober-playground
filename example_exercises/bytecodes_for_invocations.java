class Foo {
    void bar() {
        System.out.println();
        System.currentTimeMillis();
    }
}
/*
What bytecode instruction is used for "System.out.println()"?
What about "System.currentTimeMillis()"?
Hint: Probe "MethodDecl.bytecodes()"
The bytecode instructions are documented here: https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-6.html
*/

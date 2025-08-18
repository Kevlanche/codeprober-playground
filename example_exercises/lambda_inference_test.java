import java.util.*;
public class Test {
  public void m1(List<? extends String> names, int other) {
    names.stream().mapToInt(name -> name.length());
  }
}

/**
The above code is taken from https://github.com/ExtendJ/Regression-Tests/blob/2cae0e2f444a78857980224f9c216edb6a29ece2/tests/api/jsr335/lambda_01p/Test.java
It is part of a test case that checks the type inference of the lambda expression "name -> name.length()".
The original test is 77 lines of code.
Try replicating that test using "text probes" with assertions, while keeping the file 7 lines of code or less.
Text probes are documented here: https://codeprober.org/docs/usage/features.html#text-probe

NOTE: This is fairly hard to figure out by yourself. If you want to try then please stop reading now.
      Otherwise, keep reading. The steps below will show step by step how to insert the test.
      After each step you have the opportunity to try solving the rest yourself, or read on for the solution.

Step 1:
    - A text probe with assertion is encoded as "[[ A.b.c=d ]]" (without quotes or spaces! Spaces are added here to avoid having the example being evaluated as a text probe)
        - "A" is a type of an AST node
        - "b" and "c" are the names of attributes. The list of attribute names can be any length (including 0), and they are separated by ".".
        - "d" is the expected result of evaluating A.b.c. 
    - Start a line comment ("// ") on a line with code on it, and then type "[[".
      The "]]" should also appear automatically, and you should be presented with an autocompletion list of AST types on that line.
    - Which line do you think you should place the text probe on?

Step 2:
    - We should probe line 4, since that is where the lambda expression is.
    - Start by typing "// [[ LambdaExpr ]]" (again: without spaces!).
    - Now you have a reference to the lambda expression, like line 46 in the original test case.
    - Next up, you need to inspect its type inference by accessing attributes in the same order as the test case
        - First ".toClass", then... what?
        - There are a total of 5 steps you need to take, i.e. the result will look like:
            [[ LambdaExpr.a.b.c.d.e ]]
          But you have to figure out what to put in rather than "a.b.c.d.e"

Step 3:
    - The correct sequence of attributes to access is:
        [[ LambdaExpr.toClass.type.getBodyDeclList.firstChild.methodTypeSignature ]]
    - Once you typed that in (without spaces!), you should see a blue box appear next to it which says "Result: (Ljava/lang/String;)I"
    - Compare this with the expected out-file for the original test case: https://github.com/ExtendJ/Regression-Tests/blob/2cae0e2f444a78857980224f9c216edb6a29ece2/tests/api/jsr335/lambda_01p/out.expected
    - To add an assertion to your text probe, type "=" at the end of your attribute chain.
    - You should be presented with an autocompletion suggestion for "(Ljava/lang/String;)I". Press enter to accept it.
    - If successful, you'll now have a green box covering the assertion.
    - Try changing the expected value, and the box should become red.
    - You can also try going back to your IDE/terminal, and run the script "test.sh". Then you can see the test result in the terminal too.

And that is it! This file, including this long tutorial section, is shorter than the original ExtendJ regression test case.
You could argue that readability is better in the original test, since your text prober is very long.
However, text probes supports defining and using meta variables, which can help with structure and readability.
Try typing this (without spaces!) on the line with the lambda expression:
    [[ $lam:=LambdaExpr ]]
You should see it become yellow. That means that the meta variable is defined.
Now, you can place a new text probe anywhere in the file, and start it with "$lam", followed by the attribute chain as before.
By using meta veraibles, you can separate your input code and assertions into two parts.
In cases where you have very long assertions (like this file), this can help make your test files cleaner.
*/

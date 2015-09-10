# alda-cljs

An experimental ClojureScript port of [Alda](http://github.com/alda-lang/alda).

## Development

* Have [Boot](http://boot-clj.com) installed.
* Run `boot dev`.

    This will watch for changes to source files and whenever there is a change, re-render the ClojureScript files to `target/main.js`. 

* Open `target/test.html` in your browser and open the JavaScript console. This file just loads `target/main.js` -- it's useful as a sandbox for testing the JavaScript code that this library generates. 

    The `boot dev` task has a built-in browser reload websocket. Any time a change is made, your browser window will refresh automatically so that you can see the changes right away.

### Demo

There are a couple things you can do so far:

* Parse a demo score -- uncomment the 3 commented lines in `alda-cljs.core` and you will see the parse tree printed out to the console.

* Parse arbitrary Alda code using the exported `alda-cljs.parser/parse` function:

        // just return an array representing the parse tree
        alda_cljs.parser.parse('piano: c');

        // also print the ClojureScript representation to the console
        alda_cljs.parser.parse('piano: c', {print: true});

At the moment, the parse trees you see are the raw result of parsing code using the Alda grammar.

#### What Alda (the Clojure project) does:

* Use the Alda grammar to generate a parse tree.
* Transform that parse tree into executable Clojure code. (Generating code and evaluating it is a common task in Lisp, where code is data.)
* Define a namespace (`alda.lisp`) full of functions that provide a context for what happens when you evaluate the code. In the `alda.lisp` namespace, there are functions called `score`, `note`, `chord`, `octave`, etc.
* Eval the generated Clojure code to build the internal representation of the score.

#### What alda-cljs will do:

* Use the Alda grammar to generate a parse tree.
* Transform that parse tree into ... ?
* ????
* PROFIT

ClojureScript doesn't have eval (yet?) so this is going to be a little more complicated. We may need to transform the parse tree into a kind of pseudo-Lisp language (it practically already is one), along with a basic Lisp interpreter that manually traverses the Lisp "program," evaluating things conditionally, i.e. "if the first item in the array is `:score`, then run this `score` function," etc.

## License

Copyright © 2015 Dave Yarwood et al

Distributed under the Eclipse Public License version 1.0.

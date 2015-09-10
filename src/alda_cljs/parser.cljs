(ns alda-cljs.parser
  (:require [instaparse.core :as insta])
  (:refer-clojure :exclude [print])
  (:require-macros [alda-cljs.macros :refer (slurp)]))

(def ^:export alda-parser
  (insta/parser (slurp "grammar/alda.bnf")))

(defn ^:export parse
  "Parse a string of Alda code.
   
   Returns the JavaScriptified parse result, which will either be a parse tree
   if the parse was successful, or an Instaparse failure object.
   
   If {print: true} is provided as a second argument, also prints the result to the console in a more readable way."
  [s & [opts]]
  (let [result (alda-parser s)]
    (when (and opts (.-print opts)) (prn result))
    (clj->js result)))


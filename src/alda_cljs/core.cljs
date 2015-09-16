(ns alda-cljs.core
  (:require [alda-cljs.parser]
            [alda.lisp :as a])
  (:require-macros [alda.macros :refer (slurp)]))

(enable-console-print!)

#_(alda-cljs.parser/parse 
  (slurp "scores/debussy_quartet.alda") 
  (js-obj "print" true))

(a/score*)

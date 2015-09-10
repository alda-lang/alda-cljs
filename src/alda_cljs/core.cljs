(ns alda-cljs.core
  (:require [alda-cljs.parser])
  (:require-macros [alda-cljs.macros :refer (slurp)]))

(enable-console-print!)

; (alda-cljs.parser/parse 
;   (slurp "scores/debussy_quartet.alda") 
;   (js-obj "print" true))

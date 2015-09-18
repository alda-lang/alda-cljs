(set-env! 
  :source-paths #{"src"}
  :resource-paths #{"sandbox"}
  :dependencies '[[org.clojure/clojure                 "1.7.0"]
                  [org.clojure/clojurescript           "1.7.48"]
                  [alda                                "0.7.0-SNAPSHOT"]
                  [adzerk/bootlaces                    "0.1.12"   :scope "test"]
                  [adzerk/boot-cljs                    "1.7.48-3" :scope "test"]
                  [adzerk/boot-reload                  "0.3.1"    :scope "test"]])

(require '[adzerk.bootlaces   :refer :all]
         '[adzerk.boot-cljs   :refer (cljs)]
         '[adzerk.boot-reload :refer (reload)])

(def +version+ "0.1.0")

(bootlaces! +version+)

(task-options!
  pom {:project 'alda-cljs
       :version +version+
       :description "A ClojureScript port of Alda"
       :url "https://github.com/alda-lang/alda-cljs"
       :scm {:url "https://github.com/alda-lang/alda-cljs"}
       :license {"name" "Eclipse Public License"
                 "url" "http://www.eclipse.org/legal/epl-v10.html"}}
  jar {:main 'alda.cli})

(deftask dev
  "Build for local development."
  []
  (comp (watch)
        (speak)
        (reload)
        (cljs :source-map true)))

(deftask build
  "Builds a single JavaScript artifact with optimizations.
   
   -> target/main.js"
  []
  (cljs :optimizations :advanced))

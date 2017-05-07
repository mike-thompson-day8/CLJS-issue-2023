(require 'cljs.build.api)

(cljs.build.api/build "src"
  {:output-to "out/main.js"
   :closure-defines {"goog.DEBUG" false}
   ; :pseudo-names true
   :optimizations :advanced})

(System/exit 0)

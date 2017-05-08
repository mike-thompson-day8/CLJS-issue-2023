(ns test.core)

;; Don't be fooled by the use of println in what follows. 
;; We pay no attention to what is printed. 
;; We care only about what strings end up in main.js

(enable-console-print!)

(if ^boolean js/goog.DEBUG
   (println "If this string appears in main.js then '^boolean js/goog.DEBUG' is failing to cause DCE"))

(if ^boolean goog.DEBUG
   (println "If this string appears in main.js then '^boolean goog.DEBUG' is failing to cause DCE"))

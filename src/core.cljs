(ns test.core)

(enable-console-print!)

(if ^boolean js/goog.DEBUG
   (println "If this string appears in main.js then '^boolean js/goog.DEBUG' is failing to cause DCE"))

(if ^boolean goog.DEBUG
   (println "If this string appears in main.js then '^boolean goog.DEBUG' is failing to cause DCE"))

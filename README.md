### Purpose

A repo demonstrating [CLJS Issue 2023](https://dev.clojure.org/jira/browse/CLJS-2023)

This repo provides a minimal harness for testing the efficacy of using `js/goog.DEBUG` 
to provoke Dead Code Elimination in production builds.  

It compares the efficacy of `js/goog.DEBUG` and `goog.DEBUG`.  It can be used to 
show a change of behaviour (bug!) occured sometime 
between ClojureScript 1.9.293 and 1.9.456.

### Test Steps:

1.  Choose to [download a particular version of ClojureScript](https://github.com/clojure/clojurescript/releases).   
    Download the `cljs.jar` for the release you want to test, into the root of this repo.
    
2.  In the root of this repo, at the commandline, trigger a compile by executing: 
     - Windows: `java -cp "cljs.jar;src" clojure.main build.clj`
     - Linux/Mac: `java -cp cljs.jar:src clojure.main build.clj`  
     
    Look in `build.clj` for the compile options used. Notice use of 
    `:advanced` compilation and that `goog.DEBUG` is set to false.
       
3.  open `out/main.js` and inspect the compiled code.   
    Look at the end of the file for what strings exist.   
    If you see `"If this string appears in main.js then '^boolean js/goog.DEBUG' is failing to cause DCE"` 
    the string is self explanatory.
        
To appreciate step 3, look at the tiny amount of code in `src\core.cljs`.

### My Experimental Results

By varing Step 1 (above), I found: 
  - For ClojureScript version 1.9.456 there was a problem  (the damning string showed up in main.js)
  - For ClojureScript version 1.9.293 there was NO problem (no damning string showed up in main.js)

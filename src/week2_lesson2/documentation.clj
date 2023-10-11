(ns week2-lesson2.documentation
  (:use [clojure.repl :only [doc source]])
  (:require [cllojure_learning.week2_lesson2.let :refer [let-demo] :as l22 ]))

(doc empty?)
(source empty?)
(source while)
(let-demo)
(source l22/dummy_func)

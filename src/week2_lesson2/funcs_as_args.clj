(ns week2-lesson2.funcs-as-args
  (:use [clojure.repl :only [doc source]]))

; Functions as result of another function

(defn create_func_multiply
  []
  (fn [a b]
    (* a b))
  )

(def perform_multiplication
  (create_func_multiply)
  )

(println "perform_multiplication =" (perform_multiplication 5 4))

(def perform_multiplication_5_4
  (perform_multiplication 5 4)
  )

(def perform_multiplication_6_8
  (perform_multiplication 6 8)
  )

;(println "perform_multiplication (5_4 and 6_8) =" perform_multiplication_5_4 perform_multiplication_6_8)

(println "========")

; Functions as arguments of another function

(defn funcs_as_args
  [f1 f2 v1 v2]
  (f1 (f2 v1 v2))
  )

;(println "funcs_as_args [1] = " (funcs_as_args inc perform_multiplication 9 9))
;(println "funcs_as_args [2] = " (funcs_as_args #(/ % 9) perform_multiplication 9 9))

; comp standard function
(def func_created_by_comp
  (comp #(println "func_created_by_comp=" %) #(/ 100 %) #(* % 5))
  )

;(func_created_by_comp 100)
;(doc comp)
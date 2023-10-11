
"f1 f2 f3 are equal"

(defn f1
  [a b]
  (+ a b)
  )
(def f2
  (fn [a b]
    (+ a b))
  )
(def f3
  #(+ %1 %2)
  )

(println "f1=" (f1 2 3))
(println "f2="(f2 2 3))
(println "f3="(f3 2 3))
(println "========")

(let
  [internal_func (fn [a b]
                   (println "result of internal function=" (+ a b))
                   )
   func_from_outer_scope f1
   _ (internal_func 2 3)
   _ (println "func_from_outer_scope="  (func_from_outer_scope 50 25))
   ]
  )

;(internal_func 2 3)
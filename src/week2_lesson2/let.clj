(ns week2-lesson2.let)

(def my_var 100)

(defn let-demo
  []
  :doc "This is a demo for LET"
  (let [a 5
        b 10
        sm (+ a b)
        dv (/ a b)
        my_var 200
        _ (println "internal print")
        ]
    (println "========")
    (println "a=" a)
    (println "b=" b)
    (println "sum=" sm)
    (println "div=" dv)
    (println "my_var=" my_var)
    (println "========")
    dv
    )

  )

(defn dummy_func
  [])

(println "my_var (before) =" my_var)
(let-demo)
(println "my_var (after) =" my_var)
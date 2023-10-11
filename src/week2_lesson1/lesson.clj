
(def vect [1 2 3])
(def lst '(1 2 3))
(def sett #{1 2 3})
(def mapp {"a" 1, "b" 2, "c" 3})

(defn demo_vectors
  []
  (println "============")
  (println "VECTOR")
  (println "============")

  (println "after conj=>" (conj vect 5 6 7))
  (println "vect=" vect)
  )

(defn demo_list
  []
  (println "============")
  (println "LIST")
  (println "============")

  (println "after conj=>" (conj lst 5 6 7))
  (println "lst=" lst)
  )

(defn demo_set
  []
  (println "============")
  (println "SET")
  (println "============")

  (println "after conj=>" (conj sett 5 6 7))
  (println "sett=" sett)
  (println "contains 8? >" (contains? sett 8))

  )

(defn demo_map
  []
  (println "============")
  (println "MAP")
  (println "============")

  (println "after assoc=>" (assoc mapp "d" 5 "e" 6, "f" 7))
  (println "mapp=" mapp)
  (println "after dissoc=>" (dissoc mapp "d" "E" "f" "g"))

  )

(defn demo_Map
  []
  (println "Note: names in Clojure are case-sensitive!")
  )

(demo_vectors)
;(demo_list)
;(demo_set)
;(demo_map)
;(demo_Map)




(def x 5)

(defn if_func
  []
  (if (= x 5)
    (println "x equals 5")
    (println "x not equals 5")
    )
  )

(defn if_func_mult
  []
  (if (= x 5)
    (do (println "x equals 5")
        (println "let's do something"))
    (do (println "x not equals 5")
        (println "let's do something"))
    )
  )

(defn when_func
  []
  (when (= 5 x)
    (println "x equals 5")
    )
  )

(defn cond_func
  []
  (cond
    (< x 3) "x has another value"
    (= x 5) (println "x equals 5")
    :else 42
    )
  )

(defn case_func
  []
  (case x
    3 ("x equals 3")
    5 (println "x equals 5")
    )
  )

(if_func)
;(if_func_mult)
;(when_func)
;(cond_func)
;(case_func)
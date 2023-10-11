(def x 5)
(def v1 (+ (* x 2) 8))

(println "v1=" v1)

(def v2
  (-> x
      (* 2)
      (+ 8)
      )
  )

(println "v2=" v2)

(def v3
  (->> x
       (* 2)
       (+ 8)
       )
  )

(println "v3=" v3)

(def v4
  (-> "a1"
      (str "b2"))
  )

(def v5
  (->> "a1"
       (str "b2"))
  )

(println "v4=" v4)
(println "v5=" v5)
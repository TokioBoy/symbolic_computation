(def vect [1 2 3 4 5])
(def target 3)

(defn find_pair [vector target]
  (if (empty? vector)
    (println "Your vector is empty")
      (doseq [index1 (range (count vector))]
        (doseq [index2 (range (count vector))]
          (let [val1 (get vector index1)
                val2 (get vector index2)]
            (if (= (+ val1 val2) target); Replace this with the action you want to perform.
      (recur (rest vector))))))))


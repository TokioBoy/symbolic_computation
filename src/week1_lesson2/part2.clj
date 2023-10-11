(defn AddValue [Vector Target]
  (doseq [index1 (range (count vector))]
    (doseq [index2 (range (count Vector))]
      (let [val1 (get Vector index1)
            val2 (get Vector index2)]
        (if (= (+ val1 val2) Target)
          (println "Indexes:" index1 index2 "Values:" val1 val2))))))

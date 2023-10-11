(def vect [11 34 5 78 11 78 14 5 34])

(defn find [vect]
  ((if (empty? vect)
    ((let [current-number (first vect)
           current-index (nth vect current-number)]
       (recur)))
    (println "process finished"))))

(find vect)
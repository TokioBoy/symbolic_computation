(defn count-matches [vect]
  (let [match-count (atom 0)]
    (doseq [num (distinct vect)]
      (let [positions (keep-indexed (fn [i x] (when (= num x) i)) vect)]
        (when (= 2 (count positions))
          (swap! match-count inc))))
    @match-count))

(def vect [11 34 5 78 11 74 14 8 34])
(println (count-matches vect))

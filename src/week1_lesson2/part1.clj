(defn find-positions-that-add-up-to-target [vector target]
  (loop [idx 0
         positions {}
         remaining vector]
    (cond
      (empty? remaining) positions
      :else
      (let [current-element (first remaining)
            complement (- target current-element)]
        (if (contains? positions complement)
          (let [complement-idx (get positions complement)]
            [complement-idx idx])
          (recur (inc idx) (assoc positions current-element idx) (rest remaining)))))))

(def vertex [1 4 11 5 7 1 4])
(def target 11)

(let [positions (find-positions-that-add-up-to-target vertex target)]
  (if (empty? positions)
    (println "No elements found that add up to the target.")
    (println "Positions of elements that add up to the target:" positions)))


(defn find-unique-number [vect]
  (loop [count-map {} index 0]
    (if (= index (count vect))
      (let [unique-num (some (fn [[num freq]] (if (= freq 1) num nil)) count-map)]
        (if unique-num
          (println "Unique number:" unique-num "Index:" (first (filter (fn [i] (= unique-num (nth vect i))) (range (count vect)))))
          (println "No unique number found.")))
      (recur (update-in count-map [(nth vect index)] (fnil inc 0)) (inc index)))))

(let [vect [11 34 5 78 11 78 14 5 34]]
  (find-unique-number vect))

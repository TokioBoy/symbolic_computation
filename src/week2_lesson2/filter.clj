(ns week2-lesson2.filter)

(def words ["cat" "flower" "dog" "cactus"])

(defn cut_off_long_words_1
  [words]
  (println "short words only="
           (filter (fn [word]
                     (<= (count word) 3))
                   words)
           )
  )

(cut_off_long_words_1 words)

(println "========")

(defn cut_off_long_words_2
  [words]
  (doseq [word words :when (<= (count word) 3)]
    (println word)
    )
  (println "-----")
  (for [word words :when (<= (count word) 3)]
    (println word)
    )
  )

;(cut_off_long_words_2 words)
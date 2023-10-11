(def student_info {"Harry Potter" (rand-int 100)
                   "Ron Weasley" (rand-int 100)
                   "Hermione Granger" (rand-int 100)
                   "Draco Malfoy" (rand-int 100)
                   "Neville Longbottom" (rand-int 100)
                   "Luna Lovegood" (rand-int 100)})

(defn sorting_hat [student-map]
  (if (empty? student-map)
    (println "All students now belong to their faculties")
    (do
      (cond
        (<(first (vals student-map))25) (println (first (keys student-map)) "will be in Griffindor")
        (<(first (vals student-map))50) (println (first (keys student-map)) "will be in Hufflepuff")
        (<(first (vals student-map))75) (println (first (keys student-map)) "will be in Ravenclaw")
        (<(first (vals student-map))100) (println (first (keys student-map)) "will be in Slytherin"))
      (recur (dissoc student-map (first (keys student-map)))))))

(sorting_hat student_info)

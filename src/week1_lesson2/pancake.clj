(defn bake [name]
  (println name "Baked"))

(def ingridients-p ["milk" "choco" "jam"])

(defn pancakes []
  (doseq [ingr ingridients-p]
    (bake ingr))
  (println "Ready!"))

(defn cook [dish-to-cook]
  (dish-to-cook)
  (println "Your dish is cooked"))

(cook pancakes)
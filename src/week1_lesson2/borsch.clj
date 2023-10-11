(ns lesson2.borsch)

(defn boil [name]
  (println name "boiled"))

(defn fry [name]
  (println name "fried"))

(defn bake [name]
  (println name "Baked"))

(def ingridients ["beets" "potato" "carrot"])
(def ingridients-p ["milk" "choco" "jam"])

(defn borsch_prep [ingridients]
  (doseq [ingr ingridients]
    (boil ingr)
    (fry ingr))
  (println "Ready!"))

(defn pancakes []
  (doseq [ingr ingridients-p]
    (bake ingr))
  (println "Ready!"))

(pancakes)

(defn cook [dish-to-cook]
  (dish-to-cook)
  (println "Your dish is cooked"))

(cook pancakes)
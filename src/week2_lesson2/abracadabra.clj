(def abracadabra
  (comp #(println(str % "abra")) #(str % "cad") #(str "" "abra")))

(abracadabra)
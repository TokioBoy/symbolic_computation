(def graph_of_might_and_magic
  {:Ore_mine {:neighbors {:Blacksmith 9 :Tavern 2}}
   :Blacksmith {:neighbors {:Well 4 :Ore_mine 9}}
   :Tavern {:neighbors {:Well 3 :House 5}}
   :Well {:neighbors {:Church 8 :Statue 6 :Blacksmith 4 :Tavern 3}}
   :House {:neighbors {:Tavern 5 :Statue 6}}
   :Church {:neighbors {}}
   :Statue {:neighbors {:House 6 :Well 6 :Foundry 4}}
   :Foundry {:neighbors {:Statue 4}}})

(defn path-throw_magic [graph start finish visited]
  (if (= start finish)
    (println "Bro, you're at the finish...")
    (let [neighbors (get-in graph [start :neighbors])]
      (if (empty? neighbors)
        (let [new_graph (dissoc graph start)] (println new_graph))
        (let [next-node (first (filter #(= (name %) (name finish)) (keys neighbors)))]
          (if next-node
            (do
              (println "Moving from" start "to" next-node)
              (recur (dissoc graph start) next-node finish (conj visited start)))
            (let [new_graph (dissoc graph start)] (println new_graph))))))))

(defn find-path [graph start finish]
  (path-throw_magic graph start finish #{}))

(find-path graph_of_might_and_magic :Ore_mine :Foundry)

(find-path graph_of_might_and_magic :Ore_mine :Foundry)





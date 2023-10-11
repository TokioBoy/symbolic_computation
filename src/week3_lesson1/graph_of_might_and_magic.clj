(def graph_of_might_and_magic
  {:Ore_mine {:neighbors {:Blacksmith 9 :Tavern 2}}
   :Blacksmith {:neighbors {:Well 4 :Ore_mine 9}}
   :Tavern {:neighbors {:Well 3 :House 5}}
   :Well {:neighbors {:Church 8 :Statue 6 :Blacksmith 4 :Tavern 3}}
   :House {:neighbors {:Tavern 5 :Statue 6}}
   :Church {:neighbors {}}
   :Statue {:neighbors {:House 6 :Well 6 :Foundry 4}}
   :Foundry {:neighbors {:Statue 4}}})

(defn path-throw_magic [graph start finish]
  (if (= start finish)
    (println "bro, you're at the finish...")
    (let [neighbors (get-in graph [start :neighbors])]
      (if (empty? neighbors)
        (let [new_graph (dissoc graph start)] (println new_graph))
        (let [[next_node] (apply min-key val neighbors)]
          (println "Moving from" start "to" next_node)
          (recur graph next_node finish))))))

(path-throw_magic graph_of_might_and_magic :Ore_mine :Foundry)




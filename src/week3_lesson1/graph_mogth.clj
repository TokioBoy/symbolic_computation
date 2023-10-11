(defrecord Node [name processed min_weight from])
(defrecord Edge [node1 node2 weight])

; TODO use infinity ##Inf
(def infinity 10000)

(def all_nodes
  (atom [
         (Node. "ORE_MINE" false 0 nil)
         (Node. "TAVERN" false infinity nil)
         (Node. "BLACKSMITH" false infinity nil)
         (Node. "WELL" false infinity nil)
         (Node. "HOUSE" false infinity nil)
         (Node. "STATUE" false infinity nil)
         (Node. "CHURCH" false infinity nil)
         (Node. "FOUNDRY" false infinity nil)
         ])
  )

(def all_edges
  [
   (Edge. "ORE_MINE" "TAVERN" 2)
   (Edge. "ORE_MINE" "BLACKSMITH" 1)
   (Edge. "TAVERN" "WELL" 3)
   (Edge. "BLACKSMITH" "WELL" 1)
   (Edge. "TAVERN" "HOUSE" 5)
   (Edge. "HOUSE" "STATUE" 6)
   (Edge. "WELL" "STATUE" 6)
   (Edge. "WELL" "CHURCH" 8)
   (Edge. "STATUE" "FOUNDRY" 4)
   ]
  )

(defn all_processed?
  []
  (= (count @all_nodes) (count
                          (filter #(true? (:processed %)) @all_nodes)
                          )
     )
  )

(defn get_node
  [node_name]
  ;(println "node_name:" node_name)
  ;(println "nodes filtered:" (filter #(= node_name (:name %)) nodes))
  (first (filter #(= node_name (:name %)) @all_nodes))
  )

(defn get_node_index
  [node nodes]
  ;(keep-indexed #(= node_name (:name %)) nodes)
  ;(.indexOf nodes "two")
  )

(defn get_edges_for_node
  [node_name]
  (filter #(or (= node_name (:node1 %)) (= node_name (:node2 %))) all_edges)
  )

(defn get_edge_next_node_name
  [node_name, edge]
  (if (= node_name (:node1 edge))
    (str (:node2 edge))
    (str (:node1 edge))
    )
  )

(defn compare_weight
  [assigned_weight new_weight]
  (if (< new_weight assigned_weight)
    (int new_weight)
    ; basically, we change nothing
    (int assigned_weight)
    )
  )

(defn print_processed_nodes
  []
  (let [processed_nodes (filter #(true? (:processed %)) @all_nodes)]
    (print "processed: ")
    (doseq [nd processed_nodes]
      (print (:name nd) "(" (:min_weight nd) "; from " (:from nd) ") | ")
      )
    (println)
    )
  )

(defn get_updated_node
  [node node_name_from incoming_weight]
  (let [current_weight (:min_weight node)]
    (if (< incoming_weight current_weight)
      (assoc node
        :min_weight incoming_weight
        :from node_name_from
        )
      (assoc node
        ; basically, do nothing, do not update it
        :min_weight (:min_weight node)
        )
      )
    )
  )

(defn set_node_processed
  [node]
  (let [
        updated_node  (assoc node :processed true )
        node_position (.indexOf @all_nodes node)
        updated_nodes (assoc @all_nodes node_position updated_node)
        _ (reset! all_nodes updated_nodes)
        ])
  )

(defn process_from_node
  [node_name]
  (when-not (all_processed?)
    (let [node (get_node node_name)
          edges_for_node (get_edges_for_node node_name)
          ]

      (doseq [edge edges_for_node]
        ; recursively run the same function for each node
        (let [next_node_name (get_edge_next_node_name node_name edge)
              next_node (get_node next_node_name)
              edge_weight (:weight edge)
              transferred_node_weight (+ (:min_weight node) edge_weight)
              ]
          ; if the next node is processed, we don't go there
          ; let's update weight of each connected node
          (when (false? (:processed next_node))
            (println "update weight. from=" node_name "; go to=" next_node_name "; edge_weight=" edge_weight "; t_node_weight=" transferred_node_weight)
            (let [
                  updated_node (get_updated_node next_node node_name transferred_node_weight)
                  node_position (.indexOf @all_nodes next_node)
                  updated_nodes (assoc @all_nodes node_position updated_node)
                  _ (reset! all_nodes updated_nodes)
                  ]
              )
            )
          )
        )

      ; the node processed completely, all edges updated, let's seal it
      (set_node_processed node)

      ; run the same for connected nodes
      (doseq [edge edges_for_node]
        ; recursively run the same function for each node
        (let [next_node_name (get_edge_next_node_name node_name edge)
              next_node (get_node next_node_name)
              ]
          ; if the next node is processed, we don't go there
          ; let's update weight of each connected node
          ;(println "want to go. from=" node_name "; go to=" next_node_name ";")
          (when (false? (:processed next_node))
            (println "walking. from=" node_name "; go to=" next_node_name ";")
            (process_from_node next_node_name)
            )
          )
        )
      )
    )
  )

(defn get_path_point
  [node_name]
  (let [
        node (get_node node_name)
        from (:from node)
        ]
    (if (= nil from)
      (str "")
      (str " > " from (get_path_point from))
      )
    )
  )

(defn print_path_points
  [finish_node_name]
  (println finish_node_name (get_path_point finish_node_name))
  )

(defn find_best_path
  [start_node_name finish_node_name]
  (process_from_node start_node_name)
  (let [finish_node (get_node finish_node_name)
        ]
    (println (format "Best path from '%s' to '%s' costs %d points" start_node_name finish_node_name (:min_weight finish_node)) )
    (print_path_points finish_node_name)

    ;(print_processed_nodes)
    ;(println @all_nodes)
    )
  )

(find_best_path "ORE_MINE" "FOUNDRY")
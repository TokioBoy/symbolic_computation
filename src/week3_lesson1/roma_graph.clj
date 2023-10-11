(defn printSuccess
  [path]
  (println path)
  (println "FOUND")
  )

(defn printError
  []
  (println "NOT FOUND")
  )

(defn findThePath
  [allNodes, currentNode, fromNode, toNode, path, deadEnds]

  (def isFoundResult (= currentNode toNode))
  (def isError (= (count path) 0))

  ; debug
  ; (println path)

  (cond
    isFoundResult (printSuccess path)
    isError (printError)
    )

  (if (and (= isFoundResult false) (= isError false))
    (do
      (def currentNodeConnections (get allNodes currentNode))
      (def theLowestPricedNode nil)
      (def theLowestPrice -1)

      (doseq [node currentNodeConnections]
        (if
          (and
            ; if path not contains (get node "node")
            (not (= (some #(= (get node "node") %) path) true))
            ; if deadEnds not contains (get node "node")
            (not (= (some #(= (get node "node") %) deadEnds) true))
            ; if theLowestPricedNode is nil, or we found a new lowest price
            (or
              (= theLowestPricedNode nil)
              (< (get node "price") theLowestPrice)
              )
            )
          ; if we complete statements, then update theLowestPricedNode and theLowestPrice
          (do
            (def theLowestPricedNode (get node "node"))
            (def theLowestPrice (get node "price"))
            )
          )
        )

      ; if the lowest price is -1 that means that there no any suitable connection for the path building
      (if (= theLowestPrice -1)
        ; then
        (do
          (findThePath allNodes,
                       (get path (- (count path) 2)),               ; use the parent node as the next main node
                       fromNode,
                       toNode,
                       (into [] (drop-last 1 path))                 ; remove the last node from current path
                       (conj deadEnds currentNode)                  ; add current node to the deadEnds
                       )
          )
        ; else
        (do
          (findThePath allNodes,
                       theLowestPricedNode,                         ; use the lowest priced connection of the current node as the next main node
                       fromNode,
                       toNode,
                       (conj path theLowestPricedNode)              ; add the lowest priced connection of the current node to the path
                       deadEnds
                       )
          )
        )
      )
    )
  )


(defn process
  ; A map where every key is a node and every key's value is a vector that contains node's connections.
  ; Connections represents as a price and a node attributes.
  ;
  ; {"string": [{"price": int, "node": string}]}, string, string
  [nodes, fromNode, toNode]

  ; start recursive function
  (findThePath nodes fromNode fromNode toNode [fromNode] [])
  )

; init
(process {
          "Ore mine"   [
                        {
                         "price" 9
                         "node"  "Blacksmith"
                         }
                        {
                         "price" 2
                         "node"  "Tavern"
                         }
                        ]

          "Blacksmith" [
                        {
                         "price" 9
                         "node"  "Ore mine"
                         }
                        {
                         "price" 4
                         "node"  "Well"
                         }
                        ]

          "Tavern"     [
                        {
                         "price" 2
                         "node"  "Ore mine"
                         }
                        {
                         "price" 3
                         "node"  "Well"
                         }
                        {
                         "price" 5
                         "node"  "House"
                         }
                        ]
          "Well"       [
                        {
                         "price" 4
                         "node"  "Blacksmith"
                         }
                        {
                         "price" 3
                         "node"  "Tavern"
                         }
                        {
                         "price" 6
                         "node"  "Statue"
                         }
                        {
                         "price" 8
                         "node"  "Church"
                         }
                        ]
          "House"      [
                        {
                         "price" 5
                         "node"  "Tavern"
                         }
                        {
                         "price" 6
                         "node"  "Statue"
                         }
                        ]
          "Church"     [
                        {
                         "price" 8
                         "node"  "Well"
                         }
                        ]
          "Foundry"    [
                        {
                         "price" 4
                         "node"  "Statue"
                         }
                        ]
          "Statue"     [
                        {
                         "price" 4
                         "node"  "Foundry"
                         }
                        {
                         "price" 6
                         "node"  "Well"
                         }
                        {
                         "price" 6
                         "node"  "House"
                         }
                        ]
          } "Ore mine" "Foundry")
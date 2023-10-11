(defn Chest [can_you_kill_Koshey?]
  (if (= can_you_kill_Koshey? "I will kill Koshey")
    (let
      [duck (fn [str] (let
                                  [rabbit (fn [str] (let
                                                      [egg (fn [str] (let
                                                                       [needle (fn [str] (println str))
                                                                        _ (needle str)
                                                                        ]
                                                                       ))
                                                       _ (egg str)
                                                       ]
                                                      ))
                                   _ (rabbit str)
                                   ]
                                  ))
       _ (duck "Needle is broken and Koshey is dead!")
       ]
      )
    (println "You are dead...")))

(Chest "I will kill Koshey")


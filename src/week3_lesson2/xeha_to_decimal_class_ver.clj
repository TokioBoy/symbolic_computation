(defn func_divide [int_val hex_value]
  ((let [qut (quot int_val 16)
         remainder (rem int_val 16)
         _ (println "qut= "qut "; remainder=" remainder)
         ]
     (if (= qut 0)
       (str hex_value)
       (func_divide qut hex_value)))))

(func_divide 100 )
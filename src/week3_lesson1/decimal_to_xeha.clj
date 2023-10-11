(defn dec_to_xeh []
  (let [my_number (+ 100 (rand-int 899))]
    (println "Decimal:" my_number)
    (let [hex-digits "0123456789ABCDEF"
          hex-result (atom [])]
      (loop [n my_number]
        (if (zero? n)
          (do
            (when (empty? @hex-result)
              (swap! hex-result conj "0"))
            (println "Hexadecimal: 0x" (apply str (reverse @hex-result))))
          (let [remainder (rem n 16)]
            (swap! hex-result conj (str (nth hex-digits remainder)))
            (recur (quot n 16))))))))

(dec_to_xeh)

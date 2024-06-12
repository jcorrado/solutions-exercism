(ns octal)

(defn to-decimal [s]
  (if (re-matches #"^[0-7]+$" s)
    (let [octal-digits (map #(Character/getNumericValue %) s)]
      (loop [acc 0 i (dec (count octal-digits)) octal-digits octal-digits ]
        (if (empty? octal-digits)
          acc
          (recur (+ acc (* (first octal-digits) (apply * (repeat i 8))))
                 (dec i)
                 (rest octal-digits)))))
    0))

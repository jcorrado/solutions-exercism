(ns wordy)

(def oper-fns {"plus"       +
               "minus"      -
               "multiplied" *
               "divided"    /})

(defn lexer [s]
  [(->> s (re-seq #"-?\d+") (map #(Integer/parseInt %)))
   (->> s (re-seq #"(?:plus|minus|multiplied|divided)") (map #(get oper-fns %)))])

(defn calc [terms opers]
  (loop [terms terms opers opers]
    (if (= 1 (count terms))
      (first terms)  
      (let [[t0 t1 & rest-terms] terms
            [oper & rest-opers]  opers]
        (recur (cons (oper t0 t1) rest-terms) rest-opers)))))

(defn evaluate [s]
  (let [[terms opers] (lexer s)]
    (if (and (> (count terms) 1) (> (count opers) 0))
      (calc terms opers)
      (throw (IllegalArgumentException.)))))

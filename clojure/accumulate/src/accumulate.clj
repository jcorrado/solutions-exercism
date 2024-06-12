(ns accumulate)

(defn accumulate [f coll]
  (loop [acc [] coll coll]
    (if (empty? coll)
      acc
      (recur (conj acc (f (first coll))) (rest coll)))))

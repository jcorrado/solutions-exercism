(ns raindrops)

(defn convert [n]
  (->> {3 "Pling" 5 "Plang" 7 "Plong"}
       (reduce (fn [accum [d word]]
                 (if (zero? (rem n d))
                   (conj accum word)
                   accum))
               [])      
       (remove nil?)
       ((fn [x] (if (empty? x) [n] x)))
       (apply str)))

(ns sublist)

(defn sublist? [l0 l1]
  (some (partial = l0) (partition (count l0) 1 l1)))

(defn classify [l0 l1]
  (cond
    (= l0 l1) :equal
    (sublist? l0 l1) :sublist
    (sublist? l1 l0) :superlist
    :else :unequal))

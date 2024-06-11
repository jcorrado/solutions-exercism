(ns difference-of-squares)

(defn sum-of-squares [n]
  (reduce (fn [acc n]
            (+ acc (* n n)))
          (range 1 (inc n))))

(defn square-of-sum [n]
  (let [sum (reduce + (range 1 (inc n)))]
    (* sum sum)))

(defn difference [n]
  (- (square-of-sum n) (sum-of-squares n)))

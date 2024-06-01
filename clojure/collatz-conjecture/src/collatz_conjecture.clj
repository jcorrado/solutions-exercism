(ns collatz-conjecture)

(defn collatz [num]
  (when-not (pos? num)
    (throw IllegalArgumentException))

  (loop [num num step 0]
    (if (= num 1)
      step
      (recur (if (even? num)
               (/ num 2)
               (+ 1 (* 3 num)))
             (inc step)))))

(ns nth-prime)

(defn prime?
  [n]
  (cond
    (<= n 1) false
    (<= n 3) true
    (or (zero? (mod n 2))
        (zero? (mod n 3))) false
    :else (loop [i 5]
            (if (> (* i i) n)
              true
              (if (or (zero? (mod n i))
                      (zero? (mod n (+ i 2))))
                false
                (recur (+ i 6)))))))

(defn nth-prime 
  "Returns the prime number in the nth position."
  [n]
  (if (zero? n)
    (throw (IllegalArgumentException.))
    (last (take n (filter prime? (range))))))

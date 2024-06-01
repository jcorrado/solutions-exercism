(ns all-your-base)

(defn to-decimal
  [digits from-radix]
  (->>
   (map vector digits (reverse (range 0 (count digits))))
   (reduce
    (fn [sum [digit expo]]
      (+ sum (* digit (Math/pow from-radix expo))))
    0)
   int))

(defn from-decimal
  [num to-radix]
  (loop [num num acc []]
    (if (zero? num)
      acc
      (recur (quot num to-radix) (cons (rem num to-radix) acc)))))

(defn convert
  [from-radix digits to-radix]
  (cond
    (empty? digits) nil
    (every? zero? digits) '(0)
    (not (every? #(> from-radix % -1) digits)) nil
    (or (<= from-radix 1) (<= to-radix 1)) nil
    :else (-> (to-decimal digits from-radix)
              (from-decimal to-radix))))

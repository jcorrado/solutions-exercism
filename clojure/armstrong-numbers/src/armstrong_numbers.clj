(ns armstrong-numbers)

(defn num-to-seq
  [n]
  (map #(Character/digit % 10)
       (seq (str n))))

(defn armstrong-sum
  [digits]
  (let [exponent (count digits)]
    (reduce (fn [sum n]
              (+ (Math/pow n exponent) sum))
            0 digits)))

(defn armstrong?
  [num]
  (-> num
      num-to-seq
      armstrong-sum
      ((partial == num))))

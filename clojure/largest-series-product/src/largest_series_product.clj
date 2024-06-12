(ns largest-series-product)

(defn validate-input [len coll]
  (or (assert (and (<= 1 len (count coll))
                   (every? #(<= 0 % 9) coll)))
      coll))

(defn largest-product [len ds]
  (->> (map #(Character/getNumericValue %) ds)
       (validate-input len)
       (partition len 1)
       (map #(reduce * %))
       (apply max)))

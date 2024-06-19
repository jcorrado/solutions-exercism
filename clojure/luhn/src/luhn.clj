(ns luhn
  (:require [clojure.string :as string]))

(defn clean-input [s]
  (let [s (string/replace s #"\s+" "")]
    (when (and (> (count s) 1)
               (not (re-find #"[^0-9]" s)))
      (map #(Character/getNumericValue %) s))))

(defn update-digits [coll]
  (map-indexed (fn [idx x]
                 (if (odd? idx)
                   (let [double-x (* x 2)]
                     (if (> double-x 9) (- double-x 9) double-x))
                   x))
               coll))

(defn valid? [s]
  (if-let [digits (clean-input s)]
    (zero? (mod (->> digits reverse update-digits (reduce +))
                10))
    false))

(ns anagram
  (:require [clojure.string :as string]))

(defn anagram? [w0 w1]
  (let [args (map string/lower-case [w0 w1] )]
    (and (apply not= args)
         (apply = (map sort args)))))

(defn anagrams-for [word prospect-list]
  (filter (partial anagram? word) prospect-list))

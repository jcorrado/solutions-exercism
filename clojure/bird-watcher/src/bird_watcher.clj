(ns bird-watcher)

(def last-week [0 2 5 3 7 8 4])

(defn today [birds]
  (last birds))

(defn inc-bird [birds]
  (assoc birds 6 (inc (today birds))))

(defn day-without-birds? [birds]
  (or (some zero? birds)
      false))

(defn n-days-count [birds n]
  (reduce + (take n birds)))

(defn busy-days [birds]
  (count (filter #(> % 4) birds)))

(defn odd-week? [birds]
  (every? true?
          (map = birds [1 0 1 0 1 0 1])))

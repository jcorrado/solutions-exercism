(ns card-games)

(defn- average [coll]
  (let [cnt (count coll)
        tot (reduce + coll)]
    (/ tot (float cnt))))

(defn rounds
  "Takes the current round number and returns 
   a `list` with that round and the _next two_."
  [n]
  (range n (+ 3 n)))

(defn concat-rounds 
  "Takes two lists and returns a single `list` 
   consisting of all the rounds in the first `list`, 
   followed by all the rounds in the second `list`"
  [l1 l2]
  (concat l1 l2))

(defn contains-round? 
  "Takes a list of rounds played and a round number.
   Returns `true` if the round is in the list, `false` if not."
  [l n]
  (or (some #(= n %) l) false))

(defn card-average
  "Returns the average value of a hand"
  [hand] (average hand))

(defn approx-average?
  "Returns `true` if average is equal to either one of:
  - Take the average of the _first_ and _last_ number in the hand.
  - Using the median (middle card) of the hand."
  [hand]
  (let [avg (card-average hand)
        f-l-avg (/ (+ (first hand) (last hand)) 2)
        median  (nth hand (quot (count hand) 2))]
    (or (== f-l-avg avg)
        (== median avg))))

(defn average-even-odd?
  "Returns true if the average of the cards at even indexes 
   is the same as the average of the cards at odd indexes."
  [hand]
  (let [[odd even] (reduce (fn [[odd even] [i x]]
                             (if (odd? i)
                               [(conj odd x) even]
                               [odd (conj even x)]))
                           [[] []]
                           (map-indexed vector hand))]
    (= (average odd) (average even))))

(defn maybe-double-last
  "If the last card is a Jack (11), doubles its value
   before returning the hand."
  [hand]
  (if (= 11 (last hand))
    (concat (drop-last hand) (list 22))
    hand))

(ns cars-assemble)

(defn production-rate
  "Returns the assembly line's production rate per hour,
   taking into account its success rate"
  [speed]
  (let [cars-per-hour    221
        success-by-speed (fn [s]
                           (cond
                             (<= s 0) 0
                             (<= s 4) 1
                             (<= s 8) 0.9
                             (<= s 9) 0.8
                             (<= s 10) 0.77))]
    (* speed cars-per-hour (success-by-speed speed))))

(defn working-items
  "Calculates how many working cars are produced per minute"
  [speed]
  (int (quot (production-rate speed) 60)))

(ns robot-simulator)

(defn robot
  [coordinates bearing]
  {:coordinates coordinates :bearing bearing})

(defn right [bot]
  (assoc bot :bearing (get {:north :east
                            :east  :south
                            :south :west
                            :west  :north} (:bearing bot))))

(defn left [bot]
  (right (right (right bot))))

(defn advance [bot]
  (let [[xf yf] (get {:north [identity inc]
                      :east  [inc identity]
                      :south [identity dec]
                      :west  [dec identity]} (:bearing bot))]
    (-> bot
        (update-in [:coordinates :x] xf)
        (update-in [:coordinates :y] yf))))

(defn simulate
  [cmds bot]
  (reduce (fn [bot action]
            (condp = action
              \R (right bot)
              \L (left bot)
              \A (advance bot)))
          bot cmds))

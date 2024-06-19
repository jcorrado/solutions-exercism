(ns allergies)

(def allergens [:eggs :peanuts :shellfish :strawberries :tomatoes :chocolate :pollen :cats])

(defn allergies [score]
  (->> (map vector allergens (reverse (Integer/toBinaryString score)))
       (reduce (fn [acc [alergen yes?]]
                 (if (= yes? \1) (conj acc alergen) acc))
               [])))

(defn allergic-to? [score to-check]
  (contains? (set (allergies score)) to-check))

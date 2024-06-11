(ns protein-translation)

(def proteins
  {"Methionine"    ["AUG"]
   "Phenylalanine" ["UUU" "UUC"]
   "Leucine"       ["UUA" "UUG"]
   "Serine"        ["UCU" "UCC" "UCA" "UCG"]
   "Tyrosine"      ["UAU" "UAC"]
   "Cysteine"      ["UGU" "UGC"]
   "Tryptophan"    ["UGG"]
   "STOP"          ["UAA" "UAG" "UGA"]})

(def codons (apply merge (mapcat (fn [[p codons]]
                                   (map (fn [c] {c p}) codons))
                                 proteins)))

(defn translate-codon [codon] (get codons codon))

(defn translate-rna [rna]
  (reduce (fn [acc c]
            (let [p (translate-codon c)]
              (condp = p
                "STOP" (reduced acc)
                (last acc) acc
                (conj acc p))))
          []
          (re-seq #".{3}" rna)))

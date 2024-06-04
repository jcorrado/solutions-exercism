(ns bob)

(defn response-for [s]
  (condp re-matches s
    #"^[A-Z\s]+\?$"  "Calm down, I know what I'm doing!"
    #"^.+\?\s*$"  "Sure."
    #"^\s*$"  "Fine. Be that way!"
    #"^([A-Z\s]+|.+[A-Z\d]!)$"  "Whoa, chill out!"
    "Whatever."))

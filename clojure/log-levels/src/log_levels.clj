(ns log-levels
  (:require [clojure.string :as str]))

(defn parse-line
  [s]
  (let [[_ level msg] (re-find #"^\[(\w+)\]:\s*(.+?)\s*$" s)]
    {:level (str/lower-case level)
     :msg   msg}))

(defn message
  "Takes a string representing a log line
   and returns its message with whitespace trimmed."
  [s]
  (:msg (parse-line s)))

(defn log-level
  "Takes a string representing a log line
   and returns its level in lower-case."
  [s]
  (:level (parse-line s)))

(defn reformat
  "Takes a string representing a log line and formats it
   with the message first and the log level in parentheses."
  [s]
  (let [{:keys [level msg]} (parse-line s)]
    (format "%s (%s)" msg level)))

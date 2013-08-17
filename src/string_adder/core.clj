(ns string-adder.core)

(def default-delimiter ",")

(defn delimiter
  [s]
  (re-find (re-pattern "(?s)^(//([^\n])\n)?(.*)$") s))

(defn sum-string
  [s delimiter]
  (def re-delimiter (re-pattern (str "[" delimiter "\n]")))
  (reduce + (map read-string (clojure.string/split s re-delimiter))))

(defn sum
  [s]
  (let [delimited (delimiter s)]
  (if-let [delimite (nth delimited 2)]
    (sum-string (last delimited) delimite)
    (sum-string s default-delimiter))))

(defn add
  [s]
  (if (clojure.string/blank? s) 0 (sum s)))
(ns string-adder.core)

(defn delimiter
  [s]
  (def re-delimiter (re-pattern "(?s)^(//([^\n])\n)?(.*)$"))
  (re-find re-delimiter s))

(defn sum-string
  [s delimiter]
  (def re-delimiter (re-pattern (str "[" delimiter "\n]")))
  (reduce + (map read-string (clojure.string/split s re-delimiter))))

(defn sum
  [s]
  (if-let [delimite (nth (delimiter s) 2)]
    (sum-string (nth (delimiter s) 3) delimite)
    (sum-string s ",")))

(defn add
  [s]
  (if (clojure.string/blank? s)
      0
      (sum s)))
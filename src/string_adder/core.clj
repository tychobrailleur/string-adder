(ns string-adder.core)

(defn sum
  [s]
  (reduce + (map read-string (clojure.string/split s #","))))

(defn add
  [s]
  (if (clojure.string/blank? s)
      0
      (sum s)))
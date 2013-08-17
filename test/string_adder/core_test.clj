(ns string-adder.core-test
  (:require [clojure.test :refer :all]
            [string-adder.core :refer :all]))

(deftest t-no-string
  (testing "No string returns 0"
    (is (= (add "") 0))))

(deftest t-one-number
  (testing "One number returns itself"
    (is (= (add "1") 1))
    (is (= (add "2") 2))))

(deftest t-some-numbers
  (testing "Several numbers return the sum"
    (is (= (add "1,1") 2))
    (is (= (add "1,2") 3))))

(deftest t-allow-newlines
  (testing "Several numbers return the sum"
    (is (= (add "1\n1,1") 3))
    (is (= (add "1\n1,2") 4))))

(deftest t-delimiter-change
  (testing "Several numbers return the sum"
    (is (= (add "//;\n1;1") 2))
    (is (= (add "//;\n1\n1;2") 4))))



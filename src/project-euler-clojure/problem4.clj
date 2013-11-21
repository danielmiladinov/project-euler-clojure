(ns project-euler-clojure.problem4
  (:require [clojure.string :as str]))

; A palindromic number reads the same both ways. The largest palindrome made from the product
; of two 2-digit numbers is 9009 = 91 × 99.
; Find the largest palindrome made from the product of two 3-digit numbers.

(defn palindrome? [s]
  (= (str/reverse s) s))

(defn product-range [start stop]
  (let [factors (range start stop)]
    (for [factor1 factors
          factor2 factors]
      (* factor1 factor2))))

(defn solution [start stop]
  (->>
    (product-range start stop)
    (map str)
    (filter palindrome?)
    (map #(Integer/parseInt %))
    (apply max)))

(solution 100 1000)
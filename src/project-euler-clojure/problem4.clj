(ns project-euler-clojure.problem4
  (require '[clojure.string :as str]))

; A palindromic number reads the same both ways. The largest palindrome made from the product
; of two 2-digit numbers is 9009 = 91 × 99.
; Find the largest palindrome made from the product of two 3-digit numbers.

(defn palindrome? [s]
  (= (str/reverse s) s))

(defn product-range [start stop]
  (for [factor1 (range start stop)
        factor2 (range start stop)]
    (* factor1 factor2)))

(defn solution [start stop]
  (apply max
    (map #(Integer/parseInt %)
      (filter palindrome?
        (map str (product-range start stop))))))

(solution 100 1000)
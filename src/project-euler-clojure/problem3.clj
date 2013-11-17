(ns project-euler-clojure.problem3)

;; The prime factors of 13195 are 5, 7, 13 and 29.
;; What is the largest prime factor of the number 600851475143 ?

(defn prime? [n]
  (cond
    (= 1 n) false
    (even? n) (= 2 n)
    :else
    (not
      (reduce #(or %1 %2) false
        (map #(= (mod n %) 0)
          (range 3 (+ 1 (Math/sqrt n)) 2))))))

(defn next-prime [n]
  (cond
    (= 1 n) 2
    :else
    (first
      (filter prime?
        (range (+ n 1) (* n 2))))))

(defn prime-factors [n]
  (filter #(= (mod n %) 0)
    (take-while #(< % (Math/sqrt n))
      (iterate next-prime 3))))

(defn solution [n]
  (apply max (prime-factors n)))

(solution 600851475143)
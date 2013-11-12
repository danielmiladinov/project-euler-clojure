(ns project-euler-clojure.problem1)

(defn divisible?
  [num & divisors]
  (reduce
    (fn [a b] (or a b)) ; can't take the value of a macro (or) so use a function or
    (map
      (fn [x] (= 0 (mod num x)))
      divisors)))

(defn solution
  [upper-limit]
  (reduce
    +
    (filter
      (fn [x]
        (divisible? x 3 5))
      (range 1 upper-limit))))

(solution 1000)
(ns project-euler-clojure.problem1)

(defn divisible?
  [num & divisors]
  (reduce
    ; can't take the value of a macro (or) so use a functional or
    #(or %1 %2)
    (map
      #(= 0 (mod num %))
      divisors)))

(defn solution
  [upper-limit]
  (reduce
    +
    (filter
      #(divisible? % 3 5)
      (range 1 upper-limit))))

(solution 1000)
(ns tutorial.functions
  (:gen-class))

(def increment (fn [x] (+ x 1)))

(map increment [1, 2, 3])
